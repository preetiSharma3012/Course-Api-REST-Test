package com.course.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rest.api.dao.CourseDaoRepo;
import com.course.rest.api.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDaoRepo CourseDaoRepoObj; 
	
	public CourseServiceImpl() {
	}
	
	@Override
	public List<Course> getCourses() {
		
		return CourseDaoRepoObj.findAll();
	}

	@Override
	public Course getcoursebyId(long courseId) {
		
		return CourseDaoRepoObj.getById(courseId);
	}

	@Override
	public Course addcourse(Course course) 
	{
		CourseDaoRepoObj.save(course);
		
		return course;
		
	}

	@Override
	public void deletecoursebyId(long courseId) {
		
		//@SuppressWarnings("deprecation")
		Course entity = CourseDaoRepoObj.getOne(courseId);
		CourseDaoRepoObj.delete(entity);
		
	}
	
	
	
	

}
