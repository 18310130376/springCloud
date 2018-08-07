package org.config.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
	
	 @Autowired
	 UserService userService;
	
	@RequestMapping(value = "/consumer01/{name}",method = RequestMethod.GET)
	public String getClientInfo01(HttpServletRequest request,@PathVariable("name") String name){
	  return userService.getClientInfo03(name);
	}
}
