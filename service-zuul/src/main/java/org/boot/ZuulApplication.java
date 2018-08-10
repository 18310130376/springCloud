package org.boot;

import java.security.Principal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@SpringCloudApplication
@RestController
public class ZuulApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
		System.out.println("====GatewayzuulApplication start successful==========");
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
