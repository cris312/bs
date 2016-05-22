package com.bs.vo;

public class Company {
	private int companyid;      //公司id
	private String companyName;  //公司名称
	private int[] personEdges = new int[100];  //与公司所连接的所有人的id
	private int[] companyEdges = new int[100];  //与公司所连接的所有公司的id
	private int pe;    //与公司所连接的所有人的数量
	private int ce;    //与公司所连接的所有公司的数量
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int[] getPersonEdges() {
		return personEdges;
	}
	public void setPersonEdges(int[] personEdges) {
		this.personEdges = personEdges;
	}
	public int[] getCompanyEdges() {
		return companyEdges;
	}
	public void setCompanyEdges(int[] companyEdges) {
		this.companyEdges = companyEdges;
	}
	public int getPe() {
		return pe;
	}
	public void setPe(int pe) {
		this.pe = pe;
	}
	public int getCe() {
		return ce;
	}
	public void setCe(int ce) {
		this.ce = ce;
	}
	public Company(int companyid, String companyName, int[] personEdges,
			int[] companyEdges, int pe, int ce) {
		super();
		this.companyid = companyid;
		this.companyName = companyName;
		this.personEdges = personEdges;
		this.companyEdges = companyEdges;
		this.pe = pe;
		this.ce = ce;
	}
}
