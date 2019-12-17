package org.entity;

//创建学生实体类
public class Student {

	private int sno;
	private String sname;
	private int sage;
	private String saddress;
	private String spassword;
	private String role;
	
	public Student(int sno, String sname, int sage, String saddress, String spassword, String role) {
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
		this.spassword = spassword;
		this.role = role;
	}

	public Student(int sno, String sname, int sage, String saddress, String spassword) {
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
		this.spassword = spassword;
	}

	public Student() {
		
	}
	
	public Student(int sno, String spassword) {
		this.sno = sno;
		this.spassword = spassword;
	}
	
	public Student(String sname, int sage) {
		
		this.sname = sname;
		this.sage = sage;
	}
	public Student(String sname, int sage, String saddress) {
		
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	public Student(int sno, String sname, int sage, String saddress) {
		
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	
	public String toString() {
		return this.getSno()+"-" + this.getSname()+"-"+this.getSage()+"-"+this.getSaddress();
	}
	
	
}
