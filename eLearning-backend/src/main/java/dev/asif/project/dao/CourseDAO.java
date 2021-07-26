package dev.asif.project.dao;

import java.util.List;

import dev.asif.project.model.Course;

public interface CourseDAO {

	List<Course> findAll();
	boolean addCourse(Course course);
	Course getCourseById(Long courseId);
	boolean deleteCourse(Long courseId);
	boolean updateCourse(Course course);
}
