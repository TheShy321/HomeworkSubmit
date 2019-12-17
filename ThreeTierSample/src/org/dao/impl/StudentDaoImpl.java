package org.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dao.IStudentDao;
import org.entity.Student;
import org.entity.Teacher;
import org.util.DBUtil;


public class StudentDaoImpl implements IStudentDao{
	
	//查询此人是否存在
	public boolean isExist(int sno) {
		return queryStudentBySno(sno)==null? false:true;
	}
	
	//增加学生
	public boolean addStudent(Student student) {
		String sql = "insert into student(sno,sname,sage,saddress,spassword)values(?,?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress(),student.getSpassword()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号修改学生,根据sno找到待修改的人
	public boolean updateStudentBySno(int sno, Student student)
	{
		String sql = "update student set sname =?,sage=?,saddress=? where sno=?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	
	}
	
	//根据学号删除学生
	public boolean deleteStudentBySno(int sno)
	{
		String sql = "delete from student where sno=?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}

	
	//查询全部学生
	public List<Student> queryAllStudents()
	{
		List<Student> students = new ArrayList<>();
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

		String sql = "select * from student";
		rs = DBUtil.executeQuary(sql, null);
		
		//rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			int no = rs.getInt("sno");
			String name = rs.getString("sname");
			int age = rs.getInt("sage");
			String address = rs.getString("saddress");
			student = new Student(no,name,age,address);
			students.add(student);			
		}
		return students;
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	
	}
	
	//根据姓名查询
	
	//根据年龄查询
	
	//根据学号 查询学生
	public Student queryStudentBySno(int sno){
		Student student = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {

		String sql = "select * from student where sno=?";
		Object[] params = {sno};
		rs = DBUtil.executeQuary(sql, params);
		
		if(rs.next())
		{
			int no = rs.getInt("sno");
			String name = rs.getString("sname");
			int age = rs.getInt("sage");
			String address = rs.getString("saddress");
			student = new Student(no,name,age,address);
		}
		return student;
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	//判断学生是否登陆成功 成功返回一
	public static int login(Student student) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = DBUtil.getConnection();
			String sql = "select count(*) from student where sno = ? and spassword = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, student.getSno());
			pstmt.setString(2, student.getSpassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			if(result > 0) {
				return 1;
			}else {
				return 0;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			DBUtil.closeAll(rs, pstmt, connection);
		}

	}
	
	//根据用户信息表中的id查询学生
		public Student queryStudentInfoById(int id) {
			Student student = null;
			PreparedStatement pstmt = null;

			ResultSet rs = null;
			try {

			String sql = "select sno,sname,sage,saddress,spassword,student.role from userInfo,student where userid=sno and userid=?";
			Object[] params = {id};
			rs = DBUtil.executeQuary(sql, params);
			
			if(rs.next())
			{
				int sno = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				String password = rs.getString("spassword");
				String role = rs.getString("role");
				student = new Student(sno,name,age,address,password,role);
			}
			return student;
			
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
			finally {
				DBUtil.closeAll(rs, pstmt, DBUtil.connection);
			}
		
		}

	
}
