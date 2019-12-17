package org.service;

import java.util.List;

import org.entity.Teacher;

public interface ITeacherService {
	public boolean isExist(int tno);
	public Teacher queryTeacherBySno(int tno);
	public List<Teacher> queryAllTeachers();
	public boolean updateTeacherBySno(int tno, Teacher teacher);
	public boolean deleteTeacherBySno(int tno);
	public boolean addTeacher(Teacher teacher);
	public Teacher queryUserInfoById(int id);
}
