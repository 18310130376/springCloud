package org.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class ApplicationConfigClient {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApplicationConfigClient.class).web(true).run(args);
		System.out.println("======configClient start successful==========");
	}
}
