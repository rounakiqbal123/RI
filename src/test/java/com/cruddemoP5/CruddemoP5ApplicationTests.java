package com.cruddemoP5;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemoP5.entity.Student;
import com.cruddemoP5.repository.StudentRepository;

@SpringBootTest
class CruddemoP5ApplicationTests {
	
	@Autowired
	StudentRepository studentRepository;

	@Test
	void contextLoads() {
		System.out.println("hello");
	}
	
	@Test
	void saveStudent() {
		Student s = new Student();
		s.setName("Broje");
		s.setCourse("Tester");
		s.setFee(2200);
		
		studentRepository.save(s);
	}
	
	@Test
	void updateStudent() {
		Optional<Student> findById = studentRepository.findById(2L);
		Student student = findById.get();
		
		student.setCourse("Web dev");
		
		studentRepository.save(student);
	}

	@Test
	void deleteStudent() {
		Optional<Student> findById = studentRepository.findById(2L);
		Student student = findById.get();
		
		studentRepository.delete(student);
	}
	
	@Test
	void getAllStudent() {
		List<Student> students = studentRepository.findAll();
		
		for (Student student : students) {
			System.out.println("Id : "+student.getId());
			System.out.println("Name : "+student.getName());
			System.out.println("Course : "+student.getCourse());
			System.out.println("Fee : "+student.getFee());
			System.out.println();
		}
	}
	
	@Test
	void getOneStudent() {
		Optional<Student> findById = studentRepository.findById(3L);
		Student student = findById.get();
		
		System.out.println("Id : "+student.getId());
		System.out.println("Name : "+student.getName());
		System.out.println("Course : "+student.getCourse());
		System.out.println("Fee : "+student.getFee());
	}
	
	@Test
	void getOneStudentByName() {
		Student student = studentRepository.findByName("Broje");
		
		System.out.println("Id : "+student.getId());
		System.out.println("Name : "+student.getName());
		System.out.println("Course : "+student.getCourse());
		System.out.println("Fee : "+student.getFee());
	}
}
