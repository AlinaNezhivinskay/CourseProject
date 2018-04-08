package com.senla.educationsystem.model.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "creation_date")
	private Date creationDate;
	@ManyToMany
	@JoinTable(name = "group_students", joinColumns = { @JoinColumn(name = "id_group") }, inverseJoinColumns = {
			@JoinColumn(name = "id_student") })
	private List<User> students;
	@ManyToMany
	@JoinTable(name = "lesson_groups", joinColumns = { @JoinColumn(name = "id_group") }, inverseJoinColumns = {
			@JoinColumn(name = "id_lesson") })
	private List<Lesson> lessons;

	public Group() {

	}

	public Group(String name, Date creationDate) {
		this.name = name;
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

}
