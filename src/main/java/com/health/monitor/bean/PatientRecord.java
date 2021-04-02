package com.health.monitor.bean;

public class PatientRecord {
	private String name;
	private int id_ref,cigsPerDay,age,bpMeds,currSmoker,diab,male,prevHyp,prevStroke,tenYearCHD;
	private double glucose,totchol,bmi;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId_ref() {
		return id_ref;
	}
	public void setId_ref(int id_ref) {
		this.id_ref = id_ref;
	}
	public int getCigsPerDay() {
		return cigsPerDay;
	}
	public void setCigsPerDay(int cigsPerDay) {
		this.cigsPerDay = cigsPerDay;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getBpMeds() {
		return bpMeds;
	}
	public void setBpMeds(int bpMeds) {
		this.bpMeds = bpMeds;
	}
	public int getCurrSmoker() {
		return currSmoker;
	}
	public void setCurrSmoker(int currSmoker) {
		this.currSmoker = currSmoker;
	}
	public int getDiab() {
		return diab;
	}
	public void setDiab(int diab) {
		this.diab = diab;
	}
	public int getMale() {
		return male;
	}
	public void setMale(int male) {
		this.male = male;
	}
	public int getPrevHyp() {
		return prevHyp;
	}
	public void setPrevHyp(int prevHyp) {
		this.prevHyp = prevHyp;
	}
	public int getPrevStroke() {
		return prevStroke;
	}
	public void setPrevStroke(int prevStroke) {
		this.prevStroke = prevStroke;
	}
	public int getTenYearCHD() {
		return tenYearCHD;
	}
	public void setTenYearCHD(int tenYearCHD) {
		this.tenYearCHD = tenYearCHD;
	}
	public double getGlucose() {
		return glucose;
	}
	public void setGlucose(double glucose) {
		this.glucose = glucose;
	}
	public double getTotchol() {
		return totchol;
	}
	public void setTotchol(double totchol) {
		this.totchol = totchol;
	}
	public void setBMI(double bmi) {
		this.bmi = bmi;
	}
	public double getBMI() {
		return bmi;
	}
}
