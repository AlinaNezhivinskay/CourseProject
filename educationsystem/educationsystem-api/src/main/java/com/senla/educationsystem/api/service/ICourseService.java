package com.senla.educationsystem.api.service;

import java.util.List;

import com.senla.educationsystem.model.bean.Course;

public interface ICourseService {

	boolean addCourse(Course course) throws Exception;

	boolean removeCourse(Course course) throws Exception;

	boolean updateCourse(Course course) throws Exception;

	List<Course> getAllCourses() throws Exception;

	Course getCourseById(Integer id) throws Exception;

	List<Course> getCoursesByLecturer(Integer lecturerId) throws Exception;
}
