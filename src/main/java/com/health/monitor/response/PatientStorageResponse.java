package com.health.monitor.response;

public class PatientStorageResponse {
	int patient_id,id_ref;
	String name;
	public PatientStorageResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public PatientStorageResponse(int patient_id,int id_ref,String name) {
		this.patient_id = patient_id;
		this.id_ref = id_ref;
		this.name = name;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getId_ref() {
		return id_ref;
	}
	public void setId_ref(int id_ref) {
		this.id_ref = id_ref;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
