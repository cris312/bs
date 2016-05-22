package com.bs.service;

import com.bs.dao.CompanyDao;

public class CompanyConvertService {
	public String getStockIdByName(String name){
		String sid = null;
		CompanyDao cd = new CompanyDao();
		sid = cd.getStockIdByName(name);
		return sid;
	}
}
