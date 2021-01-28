package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.exceptions.StudentNotFoundException;
import com.edu.model.Students;
import com.edu.service.StudentService;

@RestController
public class StudentController{

	@Autowired
	StudentService studentService;
	
	@GetMapping("/Students")
	private ResponseEntity<List<Students>> getAllStudents()
	{
		List<Students> students = studentService.getAllStudents();
		return new ResponseEntity<List<Students>>(students, HttpStatus.OK);
	}
	
	@GetMapping("/Students/{studentid}")
	private ResponseEntity<Students> getStudent(@PathVariable("studentid") int studentid)
	{
		if(studentid <= 0)
		{
			throw new StudentNotFoundException("Not a valid Student");
		}
		Students student = studentService.getStudentsById(studentid);
		return new ResponseEntity<Students>(student,HttpStatus.OK);
	}
	
	@PostMapping("/Students")
	private ResponseEntity<Students> saveStudent(@RequestBody Students student)
	{
		studentService.saveOrUpdate(student);
		return new ResponseEntity<Students>(student,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Students/{studentid}")  
	private ResponseEntity<Void> deleteBook(@PathVariable("studentid") int studentid)   
	{  
	studentService.deleteById(studentid);
	throw new StudentNotFoundException("Student Deleted");
	} 
	
	@PutMapping("/Students/{studentid}")  
	private ResponseEntity<Students> update(@RequestBody Students student, @PathVariable("studentid") int id)   
	{  
		if(id == 0)
		{
			throw new StudentNotFoundException("Could not update student details");  
		}
		studentService.update(student, id); 
		return new ResponseEntity<Students>(student,HttpStatus.OK);
	}
	
}
