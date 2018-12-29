package com.manish.dinesh.projecthomeatomation.Models;

import java.util.Collections;
import java.util.List;

public class Arduino {

	private int aid;
	private List<Device> devices = Collections.emptyList();
	
	public Arduino(int aid, List<Device> devices) {
		super();
		this.aid = aid;
		this.devices = devices;
	}

	public Arduino() {
		super();
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "Arduino [aid=" + aid + ", devices=" + devices + "]";
	}
	
}
