package com.boot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigServerController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/provider", method = RequestMethod.GET)
	public String provider01(HttpServletRequest request) {
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println(request.getParameter("name"));
		System.out.println(
				"serviceId=" + instance.getServiceId() + ",host=" + instance.getHost() + ":" + instance.getPort());
		return "hello spring";
	}
	
	@RequestMapping(value = "/provider/{name}", method = RequestMethod.GET)
	public String provider02(HttpServletRequest request,@PathVariable("name") String name) {
		System.out.println("====name:"+name);
		return "hello spring provider02";
	}
	
	@RequestMapping(value = "/provider", method = RequestMethod.POST)
	public String provider03(@RequestBody Map<String,Object> param) {
		System.out.println("====name:"+param);
		return "hello spring provider03";
	}
}