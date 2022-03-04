package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.beans.Manger;
import com.mapper.MangerMapper;


@Controller
public class MangerController {
	
	@Resource
	private MangerMapper mangermapper;

	
	@RequestMapping("/login-manger") 
	public String loginmanger(String number,String password,ModelMap m){
		Manger manger=mangermapper.login(number, password);
		if (manger!=null) {
			return "main-manger.html";  
		}
		else {
			m.put("msg", "用户名密码错误");
			return "login-manger.html";
		}
		
	}
	
		
	

}
