package com.rajib.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.rajib.test.vo.UserDetailsVo;

public interface IUserDao {
	
	public UserDetailsVo addUserDetails(UserDetailsVo userDetailsVo) throws SQLException;
	
	public List<UserDetailsVo> fetchUserList() throws SQLException;

}
