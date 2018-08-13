package org.boot.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@PreAuthorize("hasRole('admin')")
	@RequestMapping(value="getUsers",method = RequestMethod.GET)
    public List<User> getUsers() {
        return new ArrayList<>();
    }
	
	@PreAuthorize("hasRole('user')")
	@RequestMapping(value="getUsersList",method = RequestMethod.GET)
    public List<User> getUsersList() {
        return new ArrayList<>();
    }
	
}
