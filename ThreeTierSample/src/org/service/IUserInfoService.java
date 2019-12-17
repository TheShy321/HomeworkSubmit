package org.service;

import java.util.List;

import org.entity.Teacher;
import org.entity.UserInfo;

public interface IUserInfoService {
	public List<UserInfo> queryAllUsers();
}
