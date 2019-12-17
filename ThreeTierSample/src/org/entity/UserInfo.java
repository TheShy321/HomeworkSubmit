package org.entity;

public class UserInfo {
	private int userid;
	private String password;
	private String role;
	
	public UserInfo() {
		
	}
	public UserInfo(int userid, String role) {
		this.userid = userid;
		this.role = role;
	}
	public UserInfo(int userid, String password, String role) {
		this.userid = userid;
		this.password = password;
		this.role = role;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
