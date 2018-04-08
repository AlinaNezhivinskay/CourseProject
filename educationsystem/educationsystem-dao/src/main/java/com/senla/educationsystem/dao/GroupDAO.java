package com.senla.educationsystem.dao;

import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.IGroupDAO;
import com.senla.educationsystem.model.bean.Group;

@Repository
public class GroupDAO extends AbstractDAO<Group> implements IGroupDAO {

}
