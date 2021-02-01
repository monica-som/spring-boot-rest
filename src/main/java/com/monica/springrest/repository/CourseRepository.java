package com.monica.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monica.springrest.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
