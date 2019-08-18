package com.gaojx.weather.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.web.client.RestTemplate;

import com.gaojx.weather.bean.WeatherData;
import com.gaojx.weather.bean.WeatherInfo;

import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class WeatherApiControllerTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private WeatherApiController weatherApiController = new WeatherApiController();

	@Test
	public void testNormalUrl() {
		WeatherData mockedWeatherData = new WeatherData();
		mockedWeatherData.setName("Dalian");
		mockedWeatherData.setDt(123456);
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.anyObject())).thenReturn(mockedWeatherData);

		WeatherInfo weatherInfo = weatherApiController.getWeatherInfoByCityName("abc", "");
		Assert.assertTrue(weatherInfo.isResult());
		Assert.assertEquals(mockedWeatherData.getName(), weatherInfo.getCityName());
	}

	@Test
	public void testAbnormalUrl() {
		WeatherInfo weatherInfo = weatherApiController.getWeatherInfoByCityName("", "");
		Assert.assertFalse(weatherInfo.isResult());
		Assert.assertEquals("", weatherInfo.getCityName());
	}

}
