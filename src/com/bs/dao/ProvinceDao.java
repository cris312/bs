package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.jdbc.Jdbc;
import com.bs.vo.Province;

public class ProvinceDao {
	public Province[] getAllProvince(){
		Province []p = new Province[50];
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "select pro,pid,count(pid) as value from stockinfo2 group by pid";
		Province pp = null;
		try{
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				p[rs.getInt("pid")] = new Province(rs.getString("pro"), rs.getInt("value"));	
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.release(conn, ps, rs);
		}
		return p;
	}
}
