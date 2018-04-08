package com.senla.educationsystem.dao;

import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.ILessonTimeDAO;
import com.senla.educationsystem.model.bean.LessonTime;

@Repository
public class LessonTimeDAO extends AbstractDAO<LessonTime> implements ILessonTimeDAO {

}
