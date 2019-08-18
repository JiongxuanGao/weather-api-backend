package com.gaojx.weather.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaojx.weather.bean.Weather;
import com.gaojx.weather.bean.WeatherData;
import com.gaojx.weather.bean.WeatherInfo;

@RestController
public class WeatherApiController {
	private static final Logger log = LoggerFactory.getLogger(WeatherApiController.class);

	@Value("${weather.api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false) String name) {
		// say hi
		log.info("hello name=" + name);
		return "Hello " + name + "!";
	}

	@GetMapping("/weather")
	public WeatherInfo getWeatherInfoByCityName(@RequestParam(value = "city") String city,
			@RequestParam(value = "country", required = false) String country) {
		String cityName = StringUtils.EMPTY, formattedDate = StringUtils.EMPTY, weather = StringUtils.EMPTY,
				temperature = StringUtils.EMPTY, windSpeed = StringUtils.EMPTY;
		long timestamp = 0L;
		boolean result = false;
		if (StringUtils.isNotBlank(city)) {
			WeatherData weatherData = null;
			try {
				weatherData = restTemplate.getForObject(getUrl(city, country), WeatherData.class);
			} catch (Exception exception) {
				log.error("Error occured when trying to retrieve weather info for " + city + "," + country
						+ ". Exception=" + exception);
				result = false;
			}
			if (weatherData != null) {
				cityName = weatherData.getName();
				timestamp = weatherData.getDt();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E hh:mm a", Locale.US);
				formattedDate = Instant.ofEpochSecond(timestamp).atZone(ZoneId.of("UTC-0")).format(formatter);
				List<Weather> weathers = weatherData.getWeather();
				weather = CollectionUtils.isEmpty(weathers) ? StringUtils.EMPTY : weathers.get(0).getMain();
				temperature = String.valueOf(weatherData.getMain().getTemp());
				windSpeed = String.format("%.2f", (weatherData.getWind().getSpeed() * 3.6));
				result = true;
			}
			log.info("cityName=" + cityName + ", updatedTime(UNIX)=" + timestamp + ", updatedTime=" + formattedDate
					+ ", weather=" + weather + ", temperature=" + temperature + ", windSpeed=" + windSpeed);
		}
		return new WeatherInfo(result, cityName, formattedDate, weather, temperature, windSpeed);
	}

	private String getUrl(String city, String country) {
		// api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2e4f30bf7dc456ee1b893c2d0a544e87
		String query = city;
		if (StringUtils.isNotBlank(country)) {
			query = query + "," + country;
		}
		return "http://api.openweathermap.org/data/2.5/weather?q=" + query + "&APPID=" + apiKey + "&units=metric";
	}
}
