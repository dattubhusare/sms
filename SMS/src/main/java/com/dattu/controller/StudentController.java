package com.dattu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dattu.model.Student;
import com.dattu.service.IStudentService;


@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private IStudentService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> list=service.allStudents();
		return ResponseEntity.ok(list);
		
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> findStudent(@PathVariable Integer id) 
	{
		Student student=service.findOneStudent(id);
		return ResponseEntity.ok(student);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> saveStudent(@RequestBody Student student)
	{
		Integer id=service.saveStudent(student);
		String message="Successfully Created Following Record Of Student Id "+id;
		
		return ResponseEntity.ok(message);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody Student student){ 
		service.saveStudent(student);
		String message="Update Of Id ="+id+"Successful";
		return ResponseEntity.ok(message);
				
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
	{
		service.deleteStudent(id);
		String message="Successfully Deleted Following Record of Id "+id;
		
		return ResponseEntity.ok(message);
	}

}
