package com.course.rest.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.*;

import com.course.rest.api.dao.CourseDaoRepo;
import com.course.rest.api.entity.Course;
import com.course.rest.api.services.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseRestApiApplicationTests {

	@Autowired
	CourseService courseservice;
	
	@MockBean
	CourseDaoRepo repo;
	
	@Test
	public void getCourseTest()
	{
		when(repo.findAll()).thenReturn(Stream.of(new Course(102L,"mockjavacourse","This is mockito test case")
				, new Course(103L,"mock Spring","This is mockito test case")).collect(Collectors.toList()));
		
		assertEquals(2, courseservice.getCourses().size());	
	
	}

}
