package com.senla.educationsystem.api.service;

import java.util.List;

import com.senla.educationsystem.model.bean.Group;
import com.senla.educationsystem.model.bean.Lesson;

public interface ILessonService {

	boolean addLesson(Lesson lesson) throws Exception;

	boolean removeLesson(Lesson lesson) throws Exception;

	boolean updateLesson(Lesson lesson) throws Exception;

	boolean addGroupToLesson(Lesson lesson, Group group) throws Exception;

	List<Lesson> getAllLessons() throws Exception;

	Lesson getLessonById(Integer id) throws Exception;

	List<Lesson> getLessonsByCourse(Integer courseId) throws Exception;

	List<Lesson> getLessonsByLecture(Integer lectureId) throws Exception;
}
