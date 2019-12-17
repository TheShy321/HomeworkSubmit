package org.service.impl;

import java.util.List;

import org.dao.IStudentDao;
import org.dao.impl.StudentDaoImpl;
import org.entity.Student;
import org.service.IStudentService;
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	//查询一个人
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	
	//查询全部学生
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	
	//逻辑层的修改
	public boolean updateStudentBySno(int sno, Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}else {
			return false;
		}
	}
	
	
	//逻辑层的删除
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}
			return false;
	}
	
	//增加
	public boolean addStudent(Student student) {
		if(studentDao.isExist(student.getSno())) {//如果存在，不增加
			System.out.println("此人已存在");
			return false;
		}else {
			studentDao.addStudent(student);
			return true;
		}
	}

	@Override
	public Student queryStudentInfoById(int id) {
		
		return studentDao.queryStudentInfoById(id);
	}

	
	public boolean isExist(int sno) {
		return studentDao.isExist(sno);
	}
}
