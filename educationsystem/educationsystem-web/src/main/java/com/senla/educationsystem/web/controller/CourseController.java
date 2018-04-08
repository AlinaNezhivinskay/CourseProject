package com.senla.educationsystem.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.ICourseService;
import com.senla.educationsystem.model.bean.Course;
import com.senla.educationsystem.model.bean.User;
import com.senla.educationsystem.model.userrole.UserRole;
import com.senla.educationsystem.web.token.TokenRepository;

@RestController
@RequestMapping("/course")
public class CourseController {

	private static Logger log = Logger.getLogger(CourseController.class.getName());

	@Autowired
	private ICourseService courseService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public boolean addCourse(@RequestHeader String token, @RequestBody Course course) {
		User lecturer = TokenRepository.getInstance().getUserByToken(token);
		boolean result = false;
		try {
			if (course != null) {
				if (lecturer.getRole() != UserRole.LECTURER) {
					return false;
				}
				course.setLecturer(lecturer);
				result = courseService.addCourse(course);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public boolean removeCourse(@RequestHeader String token, @RequestBody Course course) {
		User lecturer = TokenRepository.getInstance().getUserByToken(token);
		boolean result = false;
		try {
			if (course != null) {
				if (lecturer.getRole() != UserRole.LECTURER) {
					return false;
				}
				result = courseService.removeCourse(course);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public boolean updateCourse(@RequestHeader String token, @RequestBody Course course) {
		User lecturer = TokenRepository.getInstance().getUserByToken(token);
		boolean result = false;
		try {
			if (course != null) {
				if (lecturer.getRole() != UserRole.LECTURER) {
					return false;
				}
				result = courseService.updateCourse(course);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/my", method = RequestMethod.GET)
	public List<Course> getCoursesByLecturer(@RequestHeader String token) {
		User lecturer = TokenRepository.getInstance().getUserByToken(token);
		List<Course> courses = null;
		try {
			if (lecturer.getRole() != UserRole.LECTURER) {
				return null;
			}
			courses = courseService.getCoursesByLecturer(lecturer.getId());
		} catch (Exception e) {
			log.error(e);
		}
		return courses;
	}

}
