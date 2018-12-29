package com.manish.dinesh.projecthomeatomation.Models;

public class Device {
	
	private int did;
	private String name;
	private Boolean onORoff = false;
	private float powerCunsumption = 0;
	private float totalPowerConsumed = 0;
	private String extraData ;
	private String details;
	
	public Device(int did, String name, Boolean onORoff, float powerCunsumption, float totalPowerConsumed,
			String extraData, String details) {
		super();
		this.did = did;
		this.name = name;
		this.onORoff = onORoff;
		this.powerCunsumption = powerCunsumption;
		this.totalPowerConsumed = totalPowerConsumed;
		this.extraData = extraData;
		this.details = details;
	}

	public Device() {
		super();
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOnORoff() {
		return onORoff;
	}

	public void setOnORoff(Boolean onORoff) {
		this.onORoff = onORoff;
	}

	public float getPowerCunsumption() {
		return powerCunsumption;
	}

	public void setPowerCunsumption(float powerCunsumption) {
		this.powerCunsumption = powerCunsumption;
	}

	public float getTotalPowerConsumed() {
		return totalPowerConsumed;
	}

	public void setTotalPowerConsumed(float totalPowerConsumed) {
		this.totalPowerConsumed = totalPowerConsumed;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Device [did=" + did + ", name=" + name + ", onORoff=" + onORoff + ", powerCunsumption="
				+ powerCunsumption + ", totalPowerConsumed=" + totalPowerConsumed + ", extraData=" + extraData
				+ ", details=" + details + "]";
	}
		
}
