package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bs.jdbc.Jdbc;
import com.bs.vo.Net;
import com.bs.vo.Person;
import com.bs.vo.Province;

public class PersonDao {
	/*
	 * ��ȡ�߹�����
	 * */
	public String getPersonNameById(int id){
		String name=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "select personName from person where personid=?";
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString("personName");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return name;
	}
	/*
	 * ��ȡ�ڵ� ��
	 * */
	public Person getPersonRelationById(int id){
		CompanyDao cpDao = new CompanyDao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql1 = "select * from personrel where personid=?";
		int count = 0;
		int[] mark = new int[60000];
		int[] edges = new int[100];
		int mid = 0;
		Person p = null;
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				mid = cpDao.getCompanyIdByStock(rs.getString("stockid"));
				if(mark[mid]==0){
					edges[count] = mid;
					mark[mid] = 1;
					count++;
				}
			}
			p = new Person(id, getPersonNameById(id), edges, count);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return p;
	}
	/*
	 * ��ȡ�����йصĹ�˾����
	 * */
	public ArrayList<String> getStockIdByPersonId(int id){
		CompanyDao cpDao = new CompanyDao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<String> s = new ArrayList<String>();
		String sql1 = "select * from personrel where personid=?";
		int count = 0;
		int[] mark = new int[600000];
		int[] edges = new int[100];
		int mid = 0;
		Person p = null;
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				mid = cpDao.getCompanyIdByStock(rs.getString("stockid"));
				if(mark[mid]==0){
					s.add(rs.getString("stockid"));
					mark[mid] = 1;
					count++;					
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return s;
	}
	/*
	 * ��ȡ�˵�id
	 * */
	public int getPersonIdByName(String name){
		int id=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "select personid from person where personName=?";
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("personid");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return id;
	}
}
