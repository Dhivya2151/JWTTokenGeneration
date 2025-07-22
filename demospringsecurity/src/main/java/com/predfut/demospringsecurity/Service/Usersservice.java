package com.predfut.demospringsecurity.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.predfut.demospringsecurity.Dto.Users;
import com.predfut.demospringsecurity.Repo.UsersRepo;

@Service
public class Usersservice {
	
	@Autowired
	UsersRepo urepo;

	
	@Autowired
   AuthenticationManager authenticationManager;

    @Autowired
     JwtUtil jwtUtil;
   private static final  Logger l=LoggerFactory.getLogger(Usersservice.class);

@Autowired
 PasswordEncoder encoder;
	
	public Users save(Users u)
	{
		System.out.println(u.getuId());
		 Users dbuser= urepo.findByuId(u.getuId());
		
			 if(dbuser!=null)
			 {
				 l.warn("Saving user already exist: "+ u.getuId());
				 throw new RuntimeException("User already exists with ID: " + u.getuId());
			 }
					
				l.info("Saving user: "+ u.getuId());
	u.setuPassword(encoder.encode(u.getuPassword()));
				return urepo.save(u);
			}
	

	 
	
	 
	    public String verify( Users users) {		    
	    	
	    	
	        
	          Authentication authentication=   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getuId(),users.getuPassword()));
	          if(authentication.isAuthenticated())
	          { 
	        	  Users dbUser = urepo.findByuId(users.getuId());
	        	  l.info(" user loginned : "+ dbUser.getuId());
	        	  return  jwtUtil.generateToken(dbUser);
	          }
	        
	       
	            return "Invalid credentials!";
	      
	    	 
	    	


	    }
	}


