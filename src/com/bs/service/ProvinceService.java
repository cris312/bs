package com.bs.service;

import com.bs.dao.ProvinceDao;
import com.bs.vo.Province;

public class ProvinceService {
	public Province[] setAllColor(){
		Province []p = new Province[50];
		String color = null;
		ProvinceDao pd = new ProvinceDao();
		p = pd.getAllProvince();
		for(int i=1;i<=31;i++){
			String temp = String.valueOf(Integer.toHexString(p[i].getValue()));
			if(temp.length()==1){
				temp = "0"+temp;
			}
			if(temp.length()==2)
				color = "#0000"+temp;
			if(temp.length()==3)
				color = "#000"+temp;
			p[i].setColor(color);
		}
		return p;
	}
}
