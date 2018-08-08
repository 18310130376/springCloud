package org.config.controller;

import java.util.HashMap;
import java.util.Map;

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
	public Map<String,Object> getClientInfo01(HttpServletRequest request,@PathVariable("name") String name){
	  request.getHeaderNames();
	  Map<String,Object> result = new HashMap<>();
	  result.put("result", userService.getClientInfo03(name));
	  return result;
	}
}
