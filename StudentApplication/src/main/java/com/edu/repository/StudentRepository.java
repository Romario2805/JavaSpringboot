package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.model.Students;
@Repository
public interface StudentRepository extends JpaRepository<Students,Integer>{

}
