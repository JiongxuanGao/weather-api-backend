package com.gaojx.weather.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main implements Serializable {

	private static final long serialVersionUID = -8511681297176960955L;

	// temperature
	private double temp;

	private int pressure;

	private int humidity;

	@JsonProperty("temp_min")
	private double tempMin;

	@JsonProperty("temp_max")
	private double tempMax;

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

}
