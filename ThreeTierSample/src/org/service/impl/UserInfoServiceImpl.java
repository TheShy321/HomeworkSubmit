package org.service.impl;

import java.util.List;

import org.dao.ITeacherDao;
import org.dao.IUserInfoDao;
import org.dao.impl.TeacherDaoImpl;
import org.dao.impl.UserInfoDaoImpl;
import org.entity.Teacher;
import org.entity.UserInfo;
import org.service.IUserInfoService;

public class UserInfoServiceImpl implements IUserInfoService{
	IUserInfoDao userdao = new UserInfoDaoImpl();
	ITeacherDao teacherDao = new TeacherDaoImpl();
	public List<UserInfo> queryAllUsers() {
		return userdao.queryAllUsers();
		}
	
	

	

}
