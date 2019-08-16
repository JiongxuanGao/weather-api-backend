package com.gaojx.weather.bean;

import java.io.Serializable;
import java.util.List;

public class WeatherData implements Serializable {
	private static final long serialVersionUID = -4459402002958468100L;
	private List<Weather> weather;
	private Wind wind;
	private Main main;
	// Time of data calculation, unix, UTC
	private long dt;
	private int timezone;
	// city id
	private int id;
	// city name
	private String name;

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
