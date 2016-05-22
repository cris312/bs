package com.bs.service;

public class updateCompanyThread extends Thread{
		public void run() {
		CompanyService cs = new CompanyService();
		cs.getJsonFile();
		}
}
