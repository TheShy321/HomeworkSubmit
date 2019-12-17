package org.dao;

import java.util.List;

import org.entity.Student;

public interface IStudentDao {
	public boolean isExist(int sno);
	public boolean addStudent(Student student);
	public boolean updateStudentBySno(int sno, Student student);
	public boolean deleteStudentBySno(int sno);
	public List<Student> queryAllStudents();
	public Student queryStudentBySno(int sno);
	public Student queryStudentInfoById(int id);
}
