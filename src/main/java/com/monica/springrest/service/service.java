package com.monica.springrest.service;

import java.util.List;

import com.monica.springrest.entity.Course;

public interface service {
	
	public List<Course> getCourses();
	public Course getCourseById(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long courseId);

}
