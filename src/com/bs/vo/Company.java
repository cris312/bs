package com.bs.vo;

public class Company {
	private int companyid;      //��˾id
	private String companyName;  //��˾����
	private int[] personEdges = new int[100];  //�빫˾�����ӵ������˵�id
	private int[] companyEdges = new int[100];  //�빫˾�����ӵ����й�˾��id
	private int pe;    //�빫˾�����ӵ������˵�����
	private int ce;    //�빫˾�����ӵ����й�˾������
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
