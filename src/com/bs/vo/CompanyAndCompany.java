package com.bs.vo;

public class CompanyAndCompany {
	private String companyName;
	private String subCompanyName;
	private String rel;
	private int id;
	private int subCompanyId;
	
	public int getSubCompanyId() {
		return subCompanyId;
	}
	public void setSubCompanyId(int subCompanyId) {
		this.subCompanyId = subCompanyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSubCompanyName() {
		return subCompanyName;
	}
	public void setSubCompanyName(String subCompanyName) {
		this.subCompanyName = subCompanyName;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CompanyAndCompany(String companyName, String subCompanyName,
			String rel) {
		super();
		this.companyName = companyName;
		this.subCompanyName = subCompanyName;
		this.rel = rel;
	}
	public CompanyAndCompany(String companyName, String subCompanyName,
			String rel, int id,int subCompanyId) {
		super();
		this.companyName = companyName;
		this.subCompanyName = subCompanyName;
		this.rel = rel;
		this.id = id;
		this.subCompanyId =subCompanyId;
	}
}
