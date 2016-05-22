package com.bs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tools.WriteFile;

import com.bs.dao.CompanyDao;
import com.bs.dao.PersonDao;
import com.bs.vo.Company;
import com.bs.vo.Person;

public class RelationService {
	public void getRelationByPersonId(int id){
		PersonDao pd = new PersonDao();
		Person p = null;
		p = pd.getPersonRelationById(id);
		Company[] c = new Company[100];
		CompanyDao cd = new CompanyDao();
		c = cd.getAllCompany(id);
		int c_count = 0;
		String re = null;
		while(c[c_count]!=null){
			c_count++;
		}
		/*
		 * Json Nodes
		 * */
		try{
		JSONArray jsonMembersNodes = new JSONArray();
		JSONObject p_member = new JSONObject();
		p_member.put("id",p.getId());
		p_member.put("name", p.getPersonName());
		p_member.put("cluster",1);
		jsonMembersNodes.put(p_member);
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getCe();j++){
				JSONObject cn_member = new JSONObject();
				cn_member.put("id", c[i].getCompanyEdges()[j]);
				cn_member.put("name", cd.getSubCompanyNameById(c[i].getCompanyEdges()[j]));
				cn_member.put("cluster",1);	
				jsonMembersNodes.put(cn_member);
			}
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getPe();j++){
				if(c[i].getPersonEdges()[j]!=id){
					JSONObject pn_member = new JSONObject();
					pn_member.put("cluster",1);
					pn_member.put("name", pd.getPersonNameById(c[i].getPersonEdges()[j]));
					pn_member.put("id", c[i].getPersonEdges()[j]);
					jsonMembersNodes.put(pn_member);
				}
			}
		}
		/*
		 * Json Links
		 * */
		JSONArray jsonMembersLinks = new JSONArray();
		for(int i=0;i<p.getE();i++){
			JSONObject l_member1 = new JSONObject();
			l_member1.put("source", p.getId());
			l_member1.put("target", p.getCompanyEdges()[i]);
			jsonMembersLinks.put(l_member1);
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getCe();j++){
				JSONObject l_member2 = new JSONObject();
				l_member2.put("source", c[i].getCompanyid());
				l_member2.put("target", c[i].getCompanyEdges()[j]);
				jsonMembersLinks.put(l_member2);
			}
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getPe();j++){
				if(c[i].getPersonEdges()[j]!=id){
					JSONObject l_member3 = new JSONObject();
					l_member3.put("source", c[i].getCompanyid());
					l_member3.put("target", c[i].getPersonEdges()[j]);
					jsonMembersLinks.put(l_member3);
				}
			}
		}
		String nodes = jsonMembersNodes.toString();
		String links = jsonMembersLinks.toString();
		re = "{\"nodes\":"+nodes+",\"edges\":"+links+"}"; 
		}catch(JSONException e){
			e.printStackTrace();
		}
		//System.out.println("DaaaONE~~~~~~");
		FileWriter fw = null;
		try {
//			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f=new File("F:\\Hadoopworkspace\\bs\\WebContent\\person\\"+String.valueOf(id)+".json");
			fw = new FileWriter(f, true);
			} catch (IOException e) {
			e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(fw);
			pw.print(re);
			pw.flush();
			try {
			fw.flush();
			pw.close();
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		
		System.out.println("DONE~~~~~~");
	}
	public void getRelationByPersonId2(int id){
		PersonDao pd = new PersonDao();
		Person p = null;
		p = pd.getPersonRelationById(id);
		Company[] c = new Company[100];
		CompanyDao cd = new CompanyDao();
		c = cd.getAllCompany(id);
		int c_count = 0;
		String re = null;
		while(c[c_count]!=null){
			c_count++;
		}
		/*
		 * Json Nodes
		 * */
		String[] nodes = new String[1000];
		int n = 0;
		nodes[n] = "{\"id\":" +p.getId()+",\"name\":\""+p.getPersonName()+"\",\"cluster\":"+"1}";
		n++;
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getCe();j++){
				nodes[n] = "{\"id\":" +c[i].getCompanyEdges()[j]+",\"name\":\""+
			cd.getSubCompanyNameById(c[i].getCompanyEdges()[j])+"\",\"cluster\":"+"2}";
				n++;
			}
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getPe();j++){
				if(c[i].getPersonEdges()[j]!=id){
					nodes[n] = "{\"id\":" +c[i].getPersonEdges()[j]+",\"name\":\""+
							pd.getPersonNameById(c[i].getPersonEdges()[j])+"\",\"cluster\":"+"3}";
					n++;
				}
			}
		}
		/*
		 * Json Links
		 * */
		String[] links = new String[1000];
		int l = 0;
		for(int i=0;i<p.getE();i++){
			links[l] = "{\"source\":"+p.getId()+",\"target\":"+p.getCompanyEdges()[i]+"}";
			l++;
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getCe();j++){
				links[l] = "{\"source\":"+c[i].getCompanyid()+",\"target\":"+c[i].getCompanyEdges()[j]+"}";
				l++;
			}
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getPe();j++){
				if(c[i].getPersonEdges()[j]!=id){
					links[l] = "{\"source\":"+c[i].getCompanyid()+",\"target\":"+c[i].getPersonEdges()[j]+"}";
					l++;
				}
			}
		}
		String r_nodes = "";
		String r_links = "";
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++){
			if(i==n-1){
				sb.append(nodes[i]);
				break;
			}
			sb.append(nodes[i]+",");
		}
		r_nodes = sb.toString();
		StringBuffer sb2 = new StringBuffer();
		for(int i=0;i<l;i++){
			if(i==l-1){
				sb2.append(links[i]);
				break;
			}
			sb2.append(links[i]+",");
		}
		r_links = sb2.toString();
		re = "{\"nodes\":["+r_nodes+"],\"edges\":["+r_links+"]}"; 
		System.out.println("DaaaONE~~~~~~");
		FileWriter fw = null;
		try {
//			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f=new File("F:\\Hadoopworkspace\\bs\\WebContent\\116.json");
			fw = new FileWriter(f, true);
			} catch (IOException e) {
			e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(fw);
			pw.print(re);
			pw.flush();
			try {
			fw.flush();
			pw.close();
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		
		System.out.println("DONE~~~~~~");
	}
	
	
	/*
	 * communication
	 * */
	public void getRelationByPersonId3(int id){
		PersonDao pd = new PersonDao();
		Person p = null;
		p = pd.getPersonRelationById(id);
		Company[] c = new Company[100];
		CompanyDao cd = new CompanyDao();
		c = cd.getAllCompany(id);
		int c_count = 0;
		String re = null;
		while(c[c_count]!=null){
			c_count++;
		}
		/*
		 * Json Nodes
		 * */
		try{
		JSONArray jsonMembersNodes = new JSONArray();
		JSONObject p_member = new JSONObject();
		p_member.put("id", p.getPersonName());
		p_member.put("nodeType","CorePerson");
		jsonMembersNodes.put(p_member);
		for(int i=0;i<p.getE();i++){
			JSONObject pp = new JSONObject();
			pp.put("id", cd.getCompanyNameById(p.getCompanyEdges()[i]));
			pp.put("nodeType","Company");
			jsonMembersNodes.put(pp);
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getCe();j++){
				JSONObject cn_member = new JSONObject();
				cn_member.put("id", cd.getSubCompanyNameById(c[i].getCompanyEdges()[j]));
				cn_member.put("nodeType","Company");	
				jsonMembersNodes.put(cn_member);
			}
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getPe();j++){
				if(c[i].getPersonEdges()[j]!=id){
					JSONObject pn_member = new JSONObject();
					pn_member.put("id", pd.getPersonNameById(c[i].getPersonEdges()[j]));
					pn_member.put("nodeType", "Person");
					jsonMembersNodes.put(pn_member);
				}
			}
		}
		/*
		 * Json Links
		 * */
		JSONArray jsonMembersLinks = new JSONArray();
		for(int i=0;i<p.getE();i++){
			JSONObject l_member1 = new JSONObject();
			l_member1.put("source", p.getPersonName());
			l_member1.put("target", cd.getCompanyNameById(p.getCompanyEdges()[i]));
			l_member1.put("edgeType","PersonAndCompany");
			jsonMembersLinks.put(l_member1);
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getCe();j++){
				JSONObject l_member2 = new JSONObject();
				l_member2.put("source", c[i].getCompanyName());
				l_member2.put("target", cd.getSubCompanyNameById(c[i].getCompanyEdges()[j]));
				l_member2.put("edgeType","CompanyAndCompany");
				jsonMembersLinks.put(l_member2);
			}
		}
		for(int i=0;i<c_count;i++){
			for(int j=0;j<c[i].getPe();j++){
				if(c[i].getPersonEdges()[j]!=id){
					JSONObject l_member3 = new JSONObject();
					l_member3.put("source", c[i].getCompanyName());
					l_member3.put("target", pd.getPersonNameById(c[i].getPersonEdges()[j]));
					l_member3.put("edgeType","PersonAndCompany");
					jsonMembersLinks.put(l_member3);
				}
			}
		}
		String nodes = jsonMembersNodes.toString();
		String links = jsonMembersLinks.toString();
		re = "{\"nodes\":"+nodes+",\"edges\":"+links+"}"; 
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		//System.out.println("DaaaONE~~~~~~");
		WriteFile wf = new WriteFile();
		try {
			wf.Write(re, id);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("DONE~~~~~~");
	}
}
