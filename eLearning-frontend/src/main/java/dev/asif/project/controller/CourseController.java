package dev.asif.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.asif.project.dao.CourseDAO;
import dev.asif.project.dao.impl.CourseDAOImpl;
import dev.asif.project.model.Course;

@Controller
public class CourseController {
	
	CourseDAO courseDAO = new CourseDAOImpl();
	
	@GetMapping("/course-list")
	public String coursesPage(Model model) {
		List<Course> courseList = courseDAO.findAll();
		model.addAttribute("courses", courseList);
		return "courses";
	}
	
	@GetMapping("/add-course")
	public String addCourseForm(Model model) {
		model.addAttribute("course", new Course());
		return "add-course";
	}
	
	@PostMapping("/add-course")
	public String addCourse(@ModelAttribute("course") Course course) {
		courseDAO.addCourse(course);
		return "redirect:/course-list";
	}
	
	@GetMapping("/delete-course/{course-id}")
	public String deleteCourse(@PathVariable("course-id") Long courseId) {
		courseDAO.deleteCourse(courseId);
		return "redirect:/course-list";
	}

}
