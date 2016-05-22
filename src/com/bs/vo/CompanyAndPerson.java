package com.bs.vo;

public class CompanyAndPerson {
	private int personId;
	private String personName;
	private String companyId;
	private String title;
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CompanyAndPerson(int personId, String personName,
			String companyId, String title) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.companyId = companyId;
		this.title = title;
	}
}
