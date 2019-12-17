package org.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dao.ITeacherDao;
import org.entity.Teacher;
import org.util.DBUtil;

public class TeacherDaoImpl implements ITeacherDao{

	
	public boolean isExist(int tno) {
		return queryTeacherBySno(tno)==null? false:true;
		}

	
	public boolean addTeacher(Teacher teacher) {
		String sql = "insert into teacher(tno,tname,tage,depart,password)values(?,?,?,?,?)";
		Object[] params = {teacher.getTno(),teacher.getTname(),teacher.getTage(),teacher.getDepart(),teacher.getPassword()};
		return DBUtil.executeUpdate(sql, params);
	}

	
	public boolean updateTeacherBySno(int tno, Teacher teacher) {
		String sql = "update teacher set tname =?,tage=?,depart=?,password=? where tno=?";
		Object[] params = {teacher.getTname(),teacher.getTage(),teacher.getDepart(),teacher.getPassword(),tno};
		return DBUtil.executeUpdate(sql, params);
	
	}

	
	public boolean deleteTeacherBySno(int tno) {
		String sql = "delete from teacher where tno=?";
		Object[] params = {tno};
		return DBUtil.executeUpdate(sql, params);
	}

	
	public List<Teacher> queryAllTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		Teacher teacher = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

		String sql = "select * from teacher";
		rs = DBUtil.executeQuary(sql, null);
		
		//rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			int no = rs.getInt("tno");
			String name = rs.getString("tname");
			int age = rs.getInt("tage");
			String depart = rs.getString("depart");
			teacher = new Teacher(no,name,age,depart);
			teachers.add(teacher);			
		}
		return teachers;
		
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

	
	public Teacher queryTeacherBySno(int tno) {
		Teacher teacher = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {

		String sql = "select * from teacher where tno=?";
		Object[] params = {tno};
		rs = DBUtil.executeQuary(sql, params);
		
		if(rs.next())
		{
			int no = rs.getInt("tno");
			String name = rs.getString("tname");
			int age = rs.getInt("tage");
			String depart = rs.getString("depart");
			teacher = new Teacher(no,name,age,depart);
		}
		return teacher;
		
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
	
	//根据用户信息表中的id查询老师
	public Teacher queryUserInfoById(int id) {
		Teacher teacher = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {

		String sql = "select tno,tname,tage,depart,teacher.`password`,userinfo.role from userInfo,teacher where userid=tno and userid=?";
		Object[] params = {id};
		rs = DBUtil.executeQuary(sql, params);
		
		if(rs.next())
		{
			int tno = rs.getInt("tno");
			String name = rs.getString("tname");
			int age = rs.getInt("tage");
			String depart = rs.getString("depart");
			String password = rs.getString("password");
			String role = rs.getString("role");
			teacher = new Teacher(tno,name,age,depart,password,role);
		}
		return teacher;
		
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
