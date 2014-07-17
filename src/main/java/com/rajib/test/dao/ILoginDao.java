package com.rajib.test.dao;

import java.sql.SQLException;

import com.rajib.test.vo.UserDetailsVo;

public interface ILoginDao {
	public UserDetailsVo loginUserDetails(UserDetailsVo userDetailsVo) throws SQLException;
}
