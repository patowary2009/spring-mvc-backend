package com.rajib.test.service;

import java.util.List;

import com.rajib.test.vo.UserDetailsVo;

public interface IUserService {

	public UserDetailsVo addUserDetails(UserDetailsVo userDetailsVo);
	
	public List<UserDetailsVo> fetchUserList();
}
