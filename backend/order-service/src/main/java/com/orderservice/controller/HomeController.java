package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/admin")
	public String adminMethod() {
		return "this is admin area of order service running at port"+env.getProperty("local.server.port");
	}
}
