package com.bs.vo;

public class Person {
	private int id;
	private String personName;
	private int[] CompanyEdges = new int[100];
	private int e;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int[] getCompanyEdges() {
		return CompanyEdges;
	}
	public void setCompanyEdges(int[] companyEdges) {
		CompanyEdges = companyEdges;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	public Person(int id, String personName, int[] companyEdges, int e) {
		super();
		this.id = id;
		this.personName = personName;
		CompanyEdges = companyEdges;
		this.e = e;
	}
}
