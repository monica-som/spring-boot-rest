package com.monica.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monica.springrest.entity.Course;
import com.monica.springrest.service.service;

@RestController
public class MyController {
	
	@Autowired
	private service courseService;
	
	//to extract the list of course present in database
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseService.getCourses();	
	}
	
	//get course for the {id}
	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable long id) {
		return courseService.getCourseById(id);
	}
	
	//add a new  course
	@PostMapping("/courses")
	public Course addNewCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	//update the existing course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	//delete the course with {id}
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long id){
		try {
			this.courseService.deleteCourse(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	 
}
