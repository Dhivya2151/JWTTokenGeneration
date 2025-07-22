package com.predfut.demospringsecurity.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.predfut.demospringsecurity.Dto.Users;
import com.predfut.demospringsecurity.Repo.UsersRepo;
@Service
public class MyUsersDetailsService   implements UserDetailsService {
	@Autowired
	UsersRepo urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = urepo.findByuId(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        

        return new org.springframework.security.core.userdetails.User(
                user.getuId(),
                user.getuPassword(),  // encoded password
                new ArrayList<>()     // empty roles
        );
		
	}

}
