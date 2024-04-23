package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Student;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
 
}
