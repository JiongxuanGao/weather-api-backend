package com.gaojx.weather.bean;

import java.io.Serializable;

public class WeatherInfo implements Serializable {

	private static final long serialVersionUID = -1987983585022861141L;
	private String cityName;
	private String updatedTime;
	private String weather;
	private String temperature;
	private String windSpeed;

	public WeatherInfo() {
		super();
	}

	public WeatherInfo(String cityName, String updatedTime, String weather, String temperature, String windSpeed) {
		super();
		this.cityName = cityName;
		this.updatedTime = updatedTime;
		this.weather = weather;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

}
