package com.bs.service;

import com.bs.dao.PersonDao;

public class PersonConvertService {
	public int getPersonIdByName(String name){
		PersonDao pd = new PersonDao();
		int id = 0;
		id = pd.getPersonIdByName(name);
		return id;
	}
}
