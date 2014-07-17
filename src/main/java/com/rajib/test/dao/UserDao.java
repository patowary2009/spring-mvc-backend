package com.rajib.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rajib.test.utility.ConnectionUtil;
import com.rajib.test.vo.UserDetailsVo;

@Repository
public class UserDao implements IUserDao {

	@Override
	public UserDetailsVo addUserDetails(UserDetailsVo userDetailsVo) throws SQLException {
Connection conn = ConnectionUtil.getConnection();
		
		String query = "insert into login_user (user_name, password) values ('"+userDetailsVo.getUsername()+"','"+userDetailsVo.getPassword()+"')";
		Statement statement = conn.createStatement();
		int status = statement.executeUpdate(query);
		if(status > 0 ){
			query = "select max(id) as max_id from login_user";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				userDetailsVo.setId(rs.getInt("max_id")+"");
			}
		}
		return userDetailsVo;
	}

	@Override
	public List<UserDetailsVo> fetchUserList() throws SQLException {
		
		Connection conn = ConnectionUtil.getConnection();
		
		List<UserDetailsVo> userList = new ArrayList<UserDetailsVo>();
		String query = "select user_name,password,id from login_user";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs != null){
			while(rs.next()){
				UserDetailsVo temp = new UserDetailsVo(rs.getString("user_name"),rs.getString("password"),rs.getInt("id")+"");
				userList.add(temp);
			}
		}
		return userList;
	}

}
