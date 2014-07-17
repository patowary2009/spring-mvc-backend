package com.rajib.test.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajib.test.dao.IUserDao;
import com.rajib.test.vo.UserDetailsVo;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao dao;
	
	

	@Override
	public UserDetailsVo addUserDetails(UserDetailsVo userDetailsVo) {
		try {
			userDetailsVo = dao.addUserDetails(userDetailsVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetailsVo;
	}



	
	@Override
	public List<UserDetailsVo> fetchUserList() {
		// TODO Auto-generated method stub
		try {
			return dao.fetchUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
