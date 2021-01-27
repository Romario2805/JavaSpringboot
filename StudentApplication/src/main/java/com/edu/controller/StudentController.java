package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.model.Students;
import com.edu.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/Students")
	private List<Students> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/Students/{studentid}")
	private Students getStudent(@PathVariable("studentid") int studentid)
	{
		return studentService.getStudentsById(studentid);
	}
	
	@PostMapping("/Student")
	private int saveStudent(@RequestBody Students student)
	{
		studentService.saveOrUpdate(student);
		return student.getRegno();
	}
	
	@DeleteMapping("/Students/{studentid}")  
	private void deleteBook(@PathVariable("studentid") int studentid)   
	{  
	studentService.deleteById(studentid);  
	} 
	
	@PutMapping("/Student/{studentid}")  
	private Students update(@RequestBody Students student, @PathVariable("studentid") int id)   
	{  
	studentService.update(student, id);  
	return student;  
	} 
	
}
