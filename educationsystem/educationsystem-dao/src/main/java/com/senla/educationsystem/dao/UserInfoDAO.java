package com.senla.educationsystem.dao;

import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.IUserInfoDAO;
import com.senla.educationsystem.model.bean.UserInfo;

@Repository
public class UserInfoDAO extends AbstractDAO<UserInfo> implements IUserInfoDAO {

}
