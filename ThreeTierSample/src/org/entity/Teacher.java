package org.entity;

public class Teacher {
	private int tno;
	private String tname;
	private int tage;
	private String depart;
	private String password;
	private String role;
	

	public Teacher(int tno, String tname, int tage, String depart, String password, String role) {
		this.tno = tno;
		this.tname = tname;
		this.tage = tage;
		this.depart = depart;
		this.password = password;
		this.role = role;
	}
	public Teacher(int tno, String tname, int tage, String depart, String password) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tage = tage;
		this.depart = depart;
		this.password = password;
	}
	public Teacher() {
		
	}
	public Teacher(int tno,String password) {
		this.tno = tno;
		this.password = password;
	}
	public Teacher(String tname, String depart) {
		this.tname = tname;
		this.depart = depart;
	}
	public Teacher(String tname, int tage, String depart) {
		
		this.tname = tname;
		this.tage = tage;
		this.depart = depart;
	}
	public Teacher(int tno, String tname, int tage, String depart) {
		
		this.tno = tno;
		this.tname = tname;
		this.tage = tage;
		this.depart = depart;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
