package org.dao;

import java.util.List;

import org.entity.Teacher;
import org.entity.UserInfo;

public interface IUserInfoDao {
	public List<UserInfo> queryAllUsers();
	public Teacher queryUserInfo(int id);
}
