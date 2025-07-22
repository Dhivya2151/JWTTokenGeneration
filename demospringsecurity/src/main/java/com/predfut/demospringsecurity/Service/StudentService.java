package com.predfut.demospringsecurity.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.predfut.demospringsecurity.Dto.StudentDetails;
import com.predfut.demospringsecurity.Repo.StudentRepo;

@Service
public class StudentService {
	@Autowired	
	StudentRepo srepo;
	
	 private static final Logger l=LoggerFactory.getLogger(StudentService.class);
	 
	public StudentDetails save(StudentDetails s)
	{
		l.info("Saving student: "+ s.getsName());
		return srepo.save(s);
		
	}
//	
	public StudentDetails findbyid(int  id)
	{
		
		Optional<StudentDetails> op = srepo.findById(id);
		if(op.isPresent())
		{
			 l.info("Fetching student with ID:"+ id);
			return op.get(); 
		}
		else
		{
			l.warn("Student not found with ID: "+ id);
			return null;
		}
		
		
	}
//	
	public StudentDetails delete(int id)
	{
		StudentDetails dbdata = findbyid(id);
		if(dbdata!=null)
		{
			  l.info("Deleting student with ID: "+ id);
			srepo.delete(dbdata);
			return dbdata;
		}
		else
		{
			l.warn("Student not found with ID: "+ id);
		return null;
		}
	}
	public StudentDetails update( int id, StudentDetails s)
	{
		StudentDetails dbstu = findbyid(id);
		if(dbstu!=null)
		{
			if(s.getsName()!=null)
			{
				dbstu.setsName(s.getsName());
			}
			if(s.getsCourseName()!=null)
			{
				dbstu.setsCourseName(s.getsCourseName());
			}
			 l.info("Uptating student with ID: "+ id);
			return srepo.save(dbstu);
		}
		else
		{
			l.warn("Student not found with ID: "+ id);
			return null;
		}		
	}
	}
	


