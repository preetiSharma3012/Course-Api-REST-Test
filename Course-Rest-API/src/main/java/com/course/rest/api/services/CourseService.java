package com.course.rest.api.services;

import java.util.List;

import com.course.rest.api.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public Course getcoursebyId(long courseId);

	public Course addcourse(Course course);

	public Course deletecoursebyId(long courseId);

}