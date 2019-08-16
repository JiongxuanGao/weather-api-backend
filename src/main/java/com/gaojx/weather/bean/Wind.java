package com.gaojx.weather.bean;

import java.io.Serializable;

public class Wind implements Serializable {
	private static final long serialVersionUID = 2700635855563160535L;
	private double speed;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
