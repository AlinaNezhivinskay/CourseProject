package com.senla.educationsystem.model.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_lecture", nullable = false)
	private Lecture lecture;
	@Column(name = "date", nullable = false)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "id_lesson_time", nullable = false)
	private LessonTime time;
	@Column(name = "room")
	private Integer room;
	@ManyToMany(mappedBy = "lessons")
	private List<Group> groups;

	public Lesson() {

	}

	public Lesson(Lecture lecture, Date date, LessonTime time, Integer room) {
		this.lecture = lecture;
		this.date = date;
		this.time = time;
		this.room = room;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LessonTime getTime() {
		return time;
	}

	public void setTime(LessonTime time) {
		this.time = time;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void addGroup(Group group) {
		this.groups.add(group);
	}

	public void removeGroup(Group group) {
		this.groups.remove(group);
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

}
