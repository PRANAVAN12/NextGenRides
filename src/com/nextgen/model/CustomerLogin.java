package com.nextgen.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nextgen.dao.DB_Connection;

import bean.Login_Bean;

public class CustomerLogin {
	 
	public boolean check_user_name(Login_Bean obj_Login_Bean){
		
		boolean flag=false;
		
		
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.getConnection();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			
			String qurey="select * from customers where username=? and password=?";
			ps=connection.prepareStatement(qurey);
			ps.setString(1, obj_Login_Bean.getUser_name());
			ps.setString(2, obj_Login_Bean.getPassword());
			System.out.println(ps);
			rs=ps.executeQuery();
			
			if(rs.next()){
				flag=true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null){
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		
		return flag;
		
	}

}
