package org.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@SpringCloudApplication
@RestController
public class ZuulApplication {
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(ZuulApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
		System.out.println("====GatewayzuulApplication start successful==========");
	}
}
