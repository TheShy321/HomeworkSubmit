package org.service;

import java.util.List;

import org.entity.Student;

public interface IStudentService {
	
	public Student queryStudentBySno(int sno);
	public List<Student> queryAllStudents();
	public boolean updateStudentBySno(int sno, Student student);
	public boolean deleteStudentBySno(int sno);
	public boolean addStudent(Student student);
	public Student queryStudentInfoById(int id);
	public boolean isExist(int sno);
}
