package com.rajib.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.rajib.test.utility.ConnectionUtil;
import com.rajib.test.vo.UserDetailsVo;

@Repository
public class LoginDao implements ILoginDao {

	@Override
	public UserDetailsVo loginUserDetails(UserDetailsVo userDetailsVo) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		
		String query = "select user_name,password,id from login_user where user_name='"+userDetailsVo.getUsername()+"' and password='"+userDetailsVo.getPassword()+"'";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs != null){
			while(rs.next()){
				userDetailsVo.setId(rs.getInt("id")+"");
			}
		}
		return userDetailsVo;
	}
	
}
