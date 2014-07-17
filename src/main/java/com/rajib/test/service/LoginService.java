package com.rajib.test.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajib.test.dao.ILoginDao;
import com.rajib.test.vo.UserDetailsVo;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private ILoginDao dao;
	
	
	@Override
	public UserDetailsVo loginUserDetails(UserDetailsVo userDetailsVo) {
		
		try {
			userDetailsVo = dao.loginUserDetails(userDetailsVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetailsVo;
	}

}
