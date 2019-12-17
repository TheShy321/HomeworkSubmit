package org.service.impl;

import java.util.List;


import org.dao.ITeacherDao;
import org.dao.impl.TeacherDaoImpl;
import org.entity.Teacher;
import org.service.ITeacherService;

public class TeacherServiceImpl implements ITeacherService{
	
	ITeacherDao teacherDao = new TeacherDaoImpl();
	
	public Teacher queryTeacherBySno(int tno) {
		return teacherDao.queryTeacherBySno(tno);
		
	}

	
	public List<Teacher> queryAllTeachers() {
		return teacherDao.queryAllTeachers();
	}

	
	public boolean updateTeacherBySno(int tno, Teacher teacher) {
		if(teacherDao.isExist(tno)) {
			return teacherDao.updateTeacherBySno(tno, teacher);
		}else {
			return false;
		}
	}

	
	public boolean deleteTeacherBySno(int tno) {
		if(teacherDao.isExist(tno)) {
			return teacherDao.deleteTeacherBySno(tno);
		}
			return false;
	}

	
	
	public boolean addTeacher(Teacher teacher) {

		if(teacherDao.isExist(teacher.getTno())) {//如果存在，不增加
			System.out.println("此人已存在");
			return false;
		}else {
			teacherDao.addTeacher(teacher);
			return true;
		}
	
	}


	public Teacher queryUserInfoById(int id) {
		
		return teacherDao.queryUserInfoById(id);
	}


	public boolean isExist(int tno) {
		
		return teacherDao.isExist(tno);
	}

}
