package org.dao;

import java.util.List;

import org.entity.Teacher;

public interface ITeacherDao {

	public boolean isExist(int sno);
	public boolean addTeacher(Teacher teacher);
	public boolean updateTeacherBySno(int sno, Teacher teacher);
	public boolean deleteTeacherBySno(int sno);
	public List<Teacher> queryAllTeachers();
	public Teacher queryTeacherBySno(int sno);
	public Teacher queryUserInfoById(int id);


}
