package com.rajib.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rajib.test.service.IUserService;
import com.rajib.test.service.ILoginService;
import com.rajib.test.vo.UserDetailsVo;

@Controller
public class UserDetailsController {
	
	@Autowired
	private ILoginService service;
	
	@RequestMapping(value="/login", method= RequestMethod.POST, consumes ="application/json")
	public @ResponseBody UserDetailsVo loginUser(@RequestBody UserDetailsVo userDetailsVo) {
		String userName = userDetailsVo.getUsername();
		String password = userDetailsVo.getPassword();
		
		userDetailsVo = service.loginUserDetails(userDetailsVo);
		/*if(userName.equals("rajib") && password.equals("bedrock")) {
			userDetailsVo.setId(Math.random()+"");
			
		}*/
		
		return userDetailsVo;
	}
	
	@Autowired
	private IUserService addUserService;
	
	@RequestMapping(value="/addUser", method= RequestMethod.POST, consumes ="application/json")
	public @ResponseBody UserDetailsVo addUser(@RequestBody UserDetailsVo userDetailsVo) {
		
		userDetailsVo =  addUserService.addUserDetails(userDetailsVo);
		return userDetailsVo;
	}
	
	@RequestMapping(value="/getUser", method= RequestMethod.GET, produces ="application/json")
	public @ResponseBody UserDetailsVo loginUser() {
		return new UserDetailsVo("test", "password", "id");
	}
	
	@RequestMapping(value="/getUserList", method= RequestMethod.GET, produces ="application/json")
	public @ResponseBody List<UserDetailsVo> fetchUserList() {
		return addUserService.fetchUserList();
	}
}
