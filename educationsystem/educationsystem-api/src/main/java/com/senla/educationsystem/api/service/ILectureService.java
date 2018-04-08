package com.senla.educationsystem.api.service;

import java.util.List;

import com.senla.educationsystem.model.bean.Lecture;

public interface ILectureService {

	boolean addLecture(Lecture lecture) throws Exception;

	boolean removeLecture(Lecture lecture) throws Exception;

	boolean updateLecture(Lecture lecture) throws Exception;

	List<Lecture> getAllLectures() throws Exception;

	Lecture getLectureById(Integer id) throws Exception;

	List<Lecture> getLecturesByCourse(Integer courseId) throws Exception;

	void addLecturesToCourse(List<Lecture> lectures, Integer courseId) throws Exception;

}
