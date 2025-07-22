package com.predfut.demospringsecurity.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.predfut.demospringsecurity.Dto.Users;
import com.predfut.demospringsecurity.Repo.UsersRepo;
import com.predfut.demospringsecurity.Service.Usersservice;

@RestController

public class UsersController {
	@Autowired
	Usersservice service;
	
	private static final Logger l=LoggerFactory.getLogger(UsersController.class);
	
	@PostMapping("/Register")
	public Users register( @RequestBody Users U)
	{
		l.info("Received request to register user: "+ U.getuId());
		return service.save(U);
	}
	
	 @PostMapping("/login")
	    public String login(@RequestBody Users u) {
		 l.info("Received request to login user: "+ u.getuId());
			return service.verify(u);
			
	       
	}	
	
	
	

}
