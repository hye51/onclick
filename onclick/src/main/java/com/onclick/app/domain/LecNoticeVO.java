package com.onclick.app.domain;

public class LecNoticeVO { //강의 공지사항

	private int lnidx; //공지사항 인덱스
	private String lnsubject; //공지사항 제목
	private String lncontents; //공지사항 내용
	private String lndate; //공지사항 작성일
	private String lndelyn; //공지사항 삭제여부
	private int lidx; //강의 인덱스
	private int fidx; //파일 인덱스
	
	
	public int getFidx() {
		return fidx;
	}
	public void setFidx(int fidx) {
		this.fidx = fidx;
	}
	public int getLnidx() {
		return lnidx;
	}
	public void setLnidx(int lnidx) {
		this.lnidx = lnidx;
	}
	public String getLnsubject() {
		return lnsubject;
	}
	public void setLnsubject(String lnsubject) {
		this.lnsubject = lnsubject;
	}
	public String getLncontents() {
		return lncontents;
	}
	public void setLncontents(String lncontents) {
		this.lncontents = lncontents;
	}
	public String getLndate() {
		return lndate;
	}
	public void setLndate(String lndate) {
		this.lndate = lndate;
	}
	public String getLndelyn() {
		return lndelyn;
	}
	public void setLndelyn(String lndelyn) {
		this.lndelyn = lndelyn;
	}
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
}
