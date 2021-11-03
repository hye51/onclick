//211027 jhr 작업
package com.onclick.app.domain;

public class StudentVO {

	private int sidx; 
	private int sdep; //학생학번
	private String sname; //학생이름
	private String spwd; //학생비밀번호
	private String semail; //학생이메일
	private String sphone; //학생연락처
	private String salarm; //학생알림수
	private String sdelyn; //학생탈퇴여부
	
	public int getSidx() {
		return sidx;
	}
	public void setSidx(int sidx) {
		this.sidx = sidx;
	}
	public int getSdep() {
		return sdep;
	}
	public void setSdep(int sdep) {
		this.sdep = sdep;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSalarm() {
		return salarm;
	}
	public void setSalarm(String salarm) {
		this.salarm = salarm;
	}
	public String getSdelyn() {
		return sdelyn;
	}
	public void setSdelyn(String sdelyn) {
		this.sdelyn = sdelyn;
	}

	
}
