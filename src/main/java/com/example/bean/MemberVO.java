package com.example.bean;

import java.util.Date;

public class MemberVO {
	private int seq;
	private String uname;
	private String uid;
	private String password;
	private String pnum;
	private String gender;
	private Date regdate;
	private int cnt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {return password;}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPnum() {return pnum;}
	public void setPnum(String pnum) {this.pnum = pnum;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
