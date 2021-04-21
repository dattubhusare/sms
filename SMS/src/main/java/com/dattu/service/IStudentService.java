package com.dattu.service;

import java.util.List;

import com.dattu.model.Student;



public interface IStudentService {
	Integer saveStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(Integer id);
	List<Student> allStudents();
	Student findOneStudent(Integer id);

}
