package com.rest.webservice.controller;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.webservice.repository.DBUtil;

@Controller
@RequestMapping("/api/v1")
public class HelloController {


	@Autowired
	DBUtil util;
	
	
	@RequestMapping(value="/get", method = RequestMethod.GET )
	//@GetMapping("/get")
	@ResponseBody
	public String  getData() {
		
		
	Connection conn =	util.getDBConnection();
		
		
		return "Hello Friends , \n  "+conn;
		
	}
	
}
