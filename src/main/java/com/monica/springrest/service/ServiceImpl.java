package com.monica.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monica.springrest.entity.Course;
import com.monica.springrest.repository.CourseRepository;


@Service
public class ServiceImpl implements service {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}


	@Override
	public  Course getCourseById(long courseId) {
		Optional<Course> optional = courseRepository.findById(courseId);
		
		Course course = null;
		if (optional.isPresent()) {
			course=optional.get();
		}
		else {
			throw new RuntimeException("course not found for the id:"+courseId);
		}
		return course;
	}
		


	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
		
	}


	@Override
	public void deleteCourse(long courseId) {
		Course course = courseRepository.getOne(courseId);
		courseRepository.delete(course);
	}
}
