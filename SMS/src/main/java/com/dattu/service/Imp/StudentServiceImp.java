package com.dattu.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dattu.model.Student;
import com.dattu.repository.StudentRepo;
import com.dattu.service.IStudentService;
import com.dattu.util.StudentUtil;

@Service
public class StudentServiceImp implements IStudentService {
	@Autowired
	private StudentRepo sRepo;
	

	@Override
	public Integer saveStudent(Student student) {
		StudentUtil.calculation(student);
		Student stud=sRepo.save(student);
		
		
		
		return stud.getSId();
	}

	@Override
	public void updateStudent(Student student) {
		StudentUtil.calculation(student);
		sRepo.save(student);
		
		
	}

	@Override
	public void deleteStudent(Integer id) {
		sRepo.deleteById(id);
		
		
	}

	@Override
	public List<Student> allStudents() {
	   
		 
		return sRepo.findAll();
	}

	@Override
	public Student findOneStudent(Integer id) {
	     Optional<Student> stud=sRepo.findById(id);
	     if(stud.isPresent())
	     {
	    	return stud.get();
	     }
		return null;
				
	}

}
