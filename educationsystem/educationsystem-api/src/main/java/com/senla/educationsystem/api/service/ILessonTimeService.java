package com.senla.educationsystem.api.service;

import java.util.List;

import com.senla.educationsystem.model.bean.LessonTime;

public interface ILessonTimeService {
	boolean addLessonTime(LessonTime time) throws Exception;

	boolean removeLessonTime(LessonTime time) throws Exception;

	boolean updateLessonTime(LessonTime time) throws Exception;

	List<LessonTime> getAllLessonTimes() throws Exception;

	LessonTime getLessonTimeById(Integer id) throws Exception;

}
