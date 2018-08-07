package org.config.controller;

import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService{

	@Override
	public String getClientInfo03(String name) {
		return "sorry "+name;
	}
}
