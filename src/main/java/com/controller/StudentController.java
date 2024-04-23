package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Student;
import com.repo.StudentRepo;

import jakarta.transaction.Transactional;

@Transactional
@Controller
public class StudentController {
   
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("studentlist",repo.findAll());
		return "home";
	}
	
	@GetMapping("/saveStudentPage")
	public String saveStudentPage(Model model) {
		Student student=new Student("Vaishali", "Pune", "vaishu@1234gmail.com");
		model.addAttribute("student",student);
		return "add_student";
	}
	
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student")Student student) {
		repo.save(student);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/updateStudentPage/{id}")
	public String showUpdateStudentPage(@PathVariable("id")int id, Model model) {
		
		System.out.println("The data is changing based on "+id);
		
		Student temp=repo.findById(id).get();
		System.out.println(temp);
		model.addAttribute("student",temp);
		return "update_student";
		
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id")int id) {
		repo.deleteById(id);
		return "redirect:/";
		
	}
	
}
