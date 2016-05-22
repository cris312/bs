package com.bs.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tools.WriteFile;

import com.bs.dao.CompanyDao;
import com.bs.dao.PersonDao;
import com.bs.vo.Company;
import com.bs.vo.Person;

public class CompanyService {
	public String getCompanyRelationByStockId(String stockid){
		String re = "";
		CompanyDao cd = new CompanyDao();
		PersonDao pd = new PersonDao();
		Company c = cd.getRelationByStock(stockid);
		Person[] p = new Person[200];
		int p_count = 0;
		for(int i=0;i<c.getPe();i++){
			if(c.getCompanyid()!=cd.getIdByStockId(stockid)){
				p[p_count] = pd.getPersonRelationById(c.getPersonEdges()[i]);
				p_count++;
			}
		}
		try {
			JSONArray jsonMembersNodes = new JSONArray();
			JSONObject c_member = new JSONObject();
			c_member.put("id", c.getCompanyName());
			c_member.put("nodeType","CoreCompany");
			jsonMembersNodes.put(c_member);
			for(int i=0;i<c.getCe();i++){
				JSONObject c_member2 = new JSONObject();
				c_member2.put("id", cd.getSubCompanyNameById(c.getCompanyEdges()[i]));
				c_member2.put("nodeType","Company");
				jsonMembersNodes.put(c_member2);
			}
			for(int i=0;i<c.getPe();i++){
				JSONObject p_member = new JSONObject();
				p_member.put("id", pd.getPersonNameById(c.getPersonEdges()[i]));
				p_member.put("nodeType","Person");
				jsonMembersNodes.put(p_member);
			}
			for(int i=0;i<p_count;i++){
				for(int j=0;j<p[i].getE();j++){
					JSONObject pp = new JSONObject();
					pp.put("id", cd.getCompanyNameById(p[i].getCompanyEdges()[j]));
					pp.put("nodeType","Company");
					jsonMembersNodes.put(pp);
				}
			}
			JSONArray jsonMembersLinks = new JSONArray();
			for(int i=0;i<c.getCe();i++){
				JSONObject member1 = new JSONObject();
				member1.put("source", c.getCompanyName());
				member1.put("target", cd.getSubCompanyNameById(c.getCompanyEdges()[i]));
				member1.put("edgeType","CompanyAndCompany");
				jsonMembersLinks.put(member1);
			}
			for(int i=0;i<c.getPe();i++){
				JSONObject member2 = new JSONObject();
				member2.put("source", c.getCompanyName());
				member2.put("target", pd.getPersonNameById(c.getPersonEdges()[i]));
				member2.put("edgeType","CompanyAndPerson");
				jsonMembersLinks.put(member2);
			}
			for(int i=0;i<p_count;i++){
				for(int j=0;j<p[i].getE();j++){
					JSONObject member3 = new JSONObject();
					member3.put("source", p[i].getPersonName());
					member3.put("target",cd.getCompanyNameById(p[i].getCompanyEdges()[j]));
					jsonMembersLinks.put(member3);
				}
			}
			String nodes = jsonMembersNodes.toString();
			String links = jsonMembersLinks.toString();
			re = "{\"nodes\":"+nodes+",\"edges\":"+links+"}"; 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	public void getJsonFile(){
		CompanyDao cd = new CompanyDao();
		String sid = null;
		String re = null;
		WriteFile wf = new WriteFile();
		for(int i=1;i<=2000;i++){
			sid = cd.getStockidById(i);
			re = getCompanyRelationByStockId(sid);
			try {
				wf.Write(re, sid);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
