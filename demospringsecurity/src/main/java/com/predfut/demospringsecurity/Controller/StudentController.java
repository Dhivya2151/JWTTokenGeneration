package com.predfut.demospringsecurity.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.predfut.demospringsecurity.Dto.StudentDetails;
import com.predfut.demospringsecurity.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	 private  static	Logger l=LoggerFactory.getLogger(StudentController.class);
	
	@GetMapping("/")	
 
	public String home()
	{
		return "welcome to all";
	}
	
	@GetMapping("find")
	public StudentDetails findbyid(@RequestParam int id)
	{
		l.info("Received request to get student with ID: "+ id);

		return  service.findbyid(id);
		
	}
	
	@PostMapping("add")
	public StudentDetails save( @RequestBody StudentDetails st)
	{
		 l.info("Received request to add student: "+ st.getsName());
		return service.save(st);
		
		
	}
	@DeleteMapping("delete")
	public StudentDetails delete(@RequestParam int id)
	{
		l.info("Received request to delete student with ID: "+ id);

		return service.delete(id);
		
	}
	
	@PutMapping("update")
	public StudentDetails update( @RequestParam int id,@RequestBody StudentDetails st)
	{
		l.info("Received request to update student with ID: "+ id);

		return service.update(id, st);
		
	}
			

}
