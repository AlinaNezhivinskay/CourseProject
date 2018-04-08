package com.senla.educationsystem.web.dto;

import java.util.List;

import com.senla.educationsystem.model.bean.Lecture;

public class NewLecturesDto {
	private List<Lecture> lectures;
	private Integer courseId;

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

}
