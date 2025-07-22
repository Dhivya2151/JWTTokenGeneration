package com.predfut.demospringsecurity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.predfut.demospringsecurity.Dto.StudentDetails;

@Repository
public interface StudentRepo extends JpaRepository<StudentDetails, Integer> {

}
