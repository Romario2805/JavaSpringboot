package com.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.model.Students;
import com.edu.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Students> getAllStudents()
	{
		List<Students> students = new ArrayList<Students>();
		studentRepository.findAll().forEach(student->students.add(student));
		return students;
	}
	
	public Students getStudentsById(int id) {
		return studentRepository.findById(id).get();
	}
	
	public void saveOrUpdate(Students students)
	{
		studentRepository.save(students);
	}
	
	public void deleteById(int id)
	{
		studentRepository.deleteById(id);
	}
	
	public void update(Students students,int id)
	{
		studentRepository.save(students);
	}

}