package com.predfut.demospringsecurity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.predfut.demospringsecurity.Dto.Users;
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
	
	public Users findByuId(String name);

}
