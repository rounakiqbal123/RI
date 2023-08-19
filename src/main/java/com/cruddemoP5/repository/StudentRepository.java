package com.cruddemoP5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cruddemoP5.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	Student findByName(String name);
}
