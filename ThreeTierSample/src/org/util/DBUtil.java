package org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.entity.Student;

//通用的数据库操作方法
//分为增删改  和  查
public class DBUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
	private static final String USENAME = "root";
	private static final String PASSWORD = "2017403633";
	public static PreparedStatement pstmt = null;
	public static Connection connection = null;
	//通用的增删改
	
	//获取链接对象
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");;
		return DriverManager.getConnection(URL, USENAME, PASSWORD);
	}
	
	public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws SQLException, ClassNotFoundException {
		pstmt = getConnection().prepareStatement(sql);
		
		//setXXX()方法的个数依赖于？的个数，？的个数和数组的个数一致
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	
	public static boolean executeUpdate(String sql,Object[] params)
	{
		try {
	
		//String sql = "delete from student where sno=?";
		pstmt = createPreparedStatement(sql, params);

		int count = pstmt.executeUpdate();
		if(count>0) {
			return true;
		}else {
			return false;
		}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally {
			closeAll(null, pstmt, connection);
		}

	}
	
	//通用的查询 表示适合任何查询
	public static ResultSet executeQuary(String sql,Object[] params)
	{
		List<Student> students = new ArrayList<>();
		Student student = null;
		ResultSet rs = null;
		try {
		
		//String sql = "select * from student";
		pstmt = createPreparedStatement(sql, params);

		rs = pstmt.executeQuery();
		//下面的和字段值密切相关

		return rs;
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
//		finally {
//			try {
//			if(rs != null)  rs.close();
//			if(pstmt != null) pstmt.close();
//			if(connection != null) connection.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
	
	}
	public static void closeAll(ResultSet rs, Statement stmt,Connection connection) {
		try {
			if(rs != null)  rs.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
