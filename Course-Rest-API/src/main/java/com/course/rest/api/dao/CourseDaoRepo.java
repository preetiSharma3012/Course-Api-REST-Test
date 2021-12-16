package com.course.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.rest.api.entity.Course;

public interface CourseDaoRepo extends JpaRepository<Course,Long>{

}
