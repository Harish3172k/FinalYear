package com.health.monitor.response;

public class StorageResponse {
	private double inRate,outRate,temp,heartRate;
	private String date;
	private int id,id_ref;
	public int getId_ref() {
		return id_ref;
	}
	public void setId_ref(int id_ref) {
		this.id_ref = id_ref;
	}
	public StorageResponse(int id,double inRate,double outRate,double temp,String date,double heartRate,int id_ref)
	
	{
		this.id = id;
		this.inRate = inRate;
		this.outRate = outRate;
		this.temp = temp;
		this.date = date;
		this.heartRate = heartRate;
		this.id_ref = id_ref;
	}
	public StorageResponse(int id,double inRate,double outRate,double temp,double heartRate,int id_ref)
	{
		this.id = id;
		this.inRate = inRate;
		this.outRate = outRate;
		this.temp = temp;
		this.heartRate = heartRate;
		this.id_ref = id_ref;
	}
	public double getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(double heartRate) {
		this.heartRate = heartRate;
	}
	public double getInRate() {
		return inRate;
	}
	public void setInRate(double inRate) {
		this.inRate = inRate;
	}
	public double getOutRate() {
		return outRate;
	}
	public void setOutRate(double outRate) {
		this.outRate = outRate;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
