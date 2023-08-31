package com.csm.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.entity.Student;

/**
 * By Nandlal git(nandlal8949)
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
