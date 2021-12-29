package com.course.rest.api.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.course.rest.api.dao.CourseDaoRepo;
import com.course.rest.api.entity.Course;


@SpringBootTest
class CourseServiceImplTest {

	@MockBean
	CourseDaoRepo repo; 

	@Autowired
	CourseService courseService;

	@Test
	void testGetCourses() {
		when(repo.findAll()).thenReturn(Stream.of(new Course(102L,"mockjavacourse","This is mockito test case")
				, new Course(103L,"mock Spring","This is mockito test case")).collect(Collectors.toList()));

		assertEquals(2,courseService.getCourses().size());
	}

	/*@Test
	void testGetcoursebyId() {
		Long courseId = 102L;
		when(repo.findById(courseId)).thenReturn(Optional.ofNullable(Stream.of(new Course(102L,"mockjavacourse","This is mockito test case")).collect(Collectors.toList())));
		
	}

	@Test
	void testAddcourse() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletecoursebyId() {
		fail("Not yet implemented");
	}
*/
}
