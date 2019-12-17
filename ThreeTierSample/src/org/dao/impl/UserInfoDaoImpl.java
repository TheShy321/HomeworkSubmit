package org.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dao.IUserInfoDao;
import org.entity.Teacher;
import org.entity.UserInfo;
import org.util.DBUtil;

public class UserInfoDaoImpl implements IUserInfoDao{

	public List<UserInfo> queryAllUsers() {
		List<UserInfo> users = new ArrayList<>();
		UserInfo userinfo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

		String sql = "select * from userInfo";
		rs = DBUtil.executeQuary(sql, null);
		
		//rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt("userid");
			String password = rs.getString("password");
			String role = rs.getString("role");
			userinfo = new UserInfo(id,password,role);
			users.add(userinfo);			
		}
		return users;
		
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
	public Teacher queryUserInfo(int id) {
		Teacher teacher = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {

		String sql = "select userid,tname,tage,depart,teacher.`password`,userinfo.role from userInfo,teacher where userid=tno and userid=?";
		Object[] params = {id};
		rs = DBUtil.executeQuary(sql, params);
		
		if(rs.next())
		{
			int userid = rs.getInt("userid");
			String name = rs.getString("tname");
			int age = rs.getInt("tage");
			String depart = rs.getString("depart");
			String password = rs.getString("password");
			String role = rs.getString("role");
			teacher = new Teacher(userid,name,age,depart,password,role);
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
