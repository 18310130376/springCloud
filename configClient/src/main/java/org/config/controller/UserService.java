package org.config.controller;

import org.config.FooConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

import feign.Param;
import feign.RequestLine;


@FeignClient(name = "configServer",configuration=FooConfiguration.class,fallback = UserServiceHystrix.class)
public interface UserService {
	
	  @RequestLine("GET /provider/{name}")
	  String getClientInfo03(@Param("name") String name);
}
