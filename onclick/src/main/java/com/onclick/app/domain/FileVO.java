package com.onclick.app.domain;

public class FileVO { //첨부파일
	
	private int fidx; //첨부파일인덱스
	private String fsubject; //첨부파일제목
	private String ftype; //확장자명
	private String froute; //경로
	private String fdelyn; //삭제여부
	private int tuidx; //과제인덱스
	private int ridx; //자료인덱스
	
	public int getFidx() {
		return fidx;
	}
	public void setFidx(int fidx) {
		this.fidx = fidx;
	}
	public String getFsubject() {
		return fsubject;
	}
	public void setFsubject(String fsubject) {
		this.fsubject = fsubject;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFroute() {
		return froute;
	}
	public void setFroute(String froute) {
		this.froute = froute;
	}
	public String getFdelyn() {
		return fdelyn;
	}
	public void setFdelyn(String fdelyn) {
		this.fdelyn = fdelyn;
	}
	public int getTuidx() {
		return tuidx;
	}
	public void setTuidx(int tuidx) {
		this.tuidx = tuidx;
	}
	public int getRidx() {
		return ridx;
	}
	public void setRidx(int ridx) {
		this.ridx = ridx;
	}
}
