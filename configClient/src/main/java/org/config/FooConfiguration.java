package org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class FooConfiguration {
	
	@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

	 @Bean
	 Logger.Level feignLoggerLevel() {
	        //设置日志
	  return Logger.Level.FULL;
    }
}
