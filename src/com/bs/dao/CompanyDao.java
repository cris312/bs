package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bs.jdbc.Jdbc;
import com.bs.vo.Company;
import com.bs.vo.CompanyAndCompany;
import com.bs.vo.CompanyAndPerson;
import com.bs.vo.Person;

public class CompanyDao {
	public int getIdByStockId(String sid){
		int id = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql1 = "select id from stockinfo2 where stockid=?";
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("id");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return id;
	}
	public Company getRelationByStock(String m_stockId){
		ArrayList<CompanyAndCompany> cac = new ArrayList<CompanyAndCompany>();
		ArrayList<CompanyAndPerson> cap = new ArrayList<CompanyAndPerson>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		Company cp = null;
		String sql = "select stockinfo2.id,stockinfo2.conme,companyrel.subcomanyid,"
				+ "subcompany.cpname,role from stockinfo2,companyrel,subcompany where"
				+ " (subcompany.subcompanyid=companyrel.subcomanyid and "
				+ "stockinfo2.stockid=companyrel.stockid and stockinfo2.stockid=?)";
		String sql2 = "select personrel.personid,stockinfo2.id,personrel.stockid,"
				+ "person.personname,personrel.title from stockinfo2,"
				+ "personrel,person where (stockinfo2.stockid=personrel.stockid "
				+ "and personrel.stockid=? and person.personid=personrel.personid)";
		CompanyAndCompany mcac = null;
		CompanyAndPerson mcap = null;
		int pCount = 0;
		int cCount = 0;
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_stockId);
			rs = ps.executeQuery();
			/*
			 * 公司和公司
			 * */
			while(rs.next()){
				mcac = new CompanyAndCompany(rs.getString("stockinfo2.conme"), 
						rs.getString("subcompany.cpname"), rs.getString("role"),rs.getInt("stockinfo2.id"),rs.getInt("companyrel.subcomanyid"));
				cac.add(mcac);
			}
			PreparedStatement ps2 = null;
			ResultSet rs2 = null;
			ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, m_stockId);
			rs2 = ps2.executeQuery();
			/*
			 * 公司和人
			 * */
			while(rs2.next()){
				mcap = new CompanyAndPerson(rs2.getInt("personrel.personid"), 
						rs2.getString("person.personname"), 
						rs2.getString("personrel.stockid"), 
						rs2.getString("personrel.title"));
				cap.add(mcap);
			}
			int[] pEdges = new int[100];
			int[] cEdges = new int[100];
			for(int i=0;i<cac.size();i++){
				cEdges[cCount] = cac.get(i).getSubCompanyId();
				cCount++;
			}
			for(int i=0;i<cap.size();i++){
				pEdges[pCount] = cap.get(i).getPersonId();
				pCount++;
			}
			cp = new Company(cac.get(0).getId(), cac.get(0).getCompanyName(), pEdges, cEdges, pCount, cCount);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return cp;
	}
	/*
	 * 获取和搜索的人有关系的所有代码
	 * */
	public Company[] getAllCompany(int personId){
		Company[] com = new Company[10000];
		PersonDao pd = new PersonDao();
		ArrayList<String> s = new ArrayList<String>();
		s = pd.getStockIdByPersonId(personId);
		int count = 0;
		for(int i=0;i<s.size();i++){
			com[count] = getRelationByStock(s.get(i));
			count++;
		}
		return com;
	}
	/*
	 * 通过股票获取公司id
	 * */
	public int getCompanyIdByStock(String s){
		int id = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql1 = "select id from stockinfo2 where stockid=?";
		int count = 0;
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setString(1, s);
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("id");	
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return id;
	}
	/*
	 * 获取子公司名称
	 * */
	public String getSubCompanyNameById(int id){
		String name = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql1 = "select cpname from subcompany where subcompanyid=?";
		int count = 0;
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString("cpname");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return name;
	}
	/*
	 * 获取公司名称
	 * */
	public String getCompanyNameById(int id){
		String name = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql1 = "select conme from stockinfo2 where id=?";
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString("conme");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return name;
	}
	public String getStockidById(int id){
		String sid = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql1 = "select stockid from stockinfo2 where id=?";
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				sid = rs.getString("stockid");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return sid;
	}
	public String getStockIdByName(String name){
		String sid = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql1 = "select stockid from stockinfo2 where conme=?";
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				sid = rs.getString("stockid");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return sid;
	}
}
