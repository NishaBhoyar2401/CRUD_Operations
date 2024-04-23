package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Student;
import com.repo.StudentRepo;

@SpringBootApplication
public class SpringBootCrudOperationStudentApplication implements CommandLineRunner{

	@Autowired
	private StudentRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationStudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student s1= new Student("Nisha","Wardha","nisha123@gmail.com");
		Student s2= new Student("Vaibhav","Hydrabad","Vaibhav123@gmail.com");
		Student s3= new Student("Pallavi","Nagpur","Pallavi123@gmail.com");
		Student s4= new Student("Rupesh","Pune","rupesh123@gmail.com");
		
		
		repo.save(s1);
		repo.save(s2);
		repo.save(s3);
		repo.save(s4);
	}

}
