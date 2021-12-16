package com.course.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.rest.api.entity.Course;
import com.course.rest.api.services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is Home Method";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses()	
	{
		return courseservice.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getcoursesbyId(@PathVariable long courseId)
	{
		return courseservice.getcoursebyId(courseId);
		
	}
	
	@PostMapping("/courses")
	public Course addcourse(@RequestBody Course course)
	{
	
		return courseservice.addcourse(course);
		
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus>  deletecoursesbyId(@PathVariable long courseId )
	{

		try {
			this.courseservice.deletecoursebyId(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
