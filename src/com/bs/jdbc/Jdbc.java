package com.bs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Jdbc {
	final static String dburl = "jdbc:mysql://127.0.0.1:3306/test2";
	static String username = "root";
	static String pwd = "root";
	private static DataSource ds= null;
	/*static {
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource)envCtx.lookup("jdbc/datasource");
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}*/
	public static Connection getConnection() {
	Connection con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dburl, username, pwd);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}
	
	public static void release(Connection conn,PreparedStatement st,ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	  public static void release(Connection conn,PreparedStatement st){
		    
			
	         
	         if(st!=null){
	             try{
	                 //关闭负责执行SQL命令的Statement对象
	                 st.close();
	             }catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }
	         
	         if(conn!=null){
	             try{
	                 //将Connection连接对象还给数据库连接池
	                 conn.close();
	             }catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }
	     }
}

