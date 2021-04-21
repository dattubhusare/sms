package com.dattu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dattu.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
