package com.course.rest.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.rest.api.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
	list=new ArrayList<>();
	list.add(new Course(100,"Core Java","This is core java course"));
	list.add(new Course(101,"Spring Boot","This is core Spring Boot"));
	list.add(new Course(102,"Java Script","This is core Java Script"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getcoursebyId(long courseId) {
		
		Course c = null;
		
		for(Course course:list)
		{
			if(course.getId()== courseId)
			{
				c=course;
				break;			
				
			}
		}
		return c;
	}

	@Override
	public Course addcourse(Course course) 
	{
		list.add(course);
		
		return course;
		
	}

	@Override
	public Course deletecoursebyId(long courseId) {
		
		Course c =null;
		
		for(Course course : list)
		{
			if(course.getId() == courseId)
			{
				list.remove(course);
				break;
			}
		}
		
		return c;
	}
	
	
	
	

}
