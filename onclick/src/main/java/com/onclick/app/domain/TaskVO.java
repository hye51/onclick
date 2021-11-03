package com.onclick.app.domain;

public class TaskVO { //교수님 과제 업로드

	private int tuidx; //과제 인덱스
	private String tuname; //과제 제목
	private String tustart; //제출 시작일
	private String tufin; //제출 종료일
	private String tudate; //작성일
	private String tuing; //진행상태(진행 or 종료)
	private int tufile; //첨부파일 번호
	private String tunotyn; //알림 여부
	private String tudelyn;
	private int lidx; //강의고유번호
	
	public int getTuidx() {
		return tuidx;
	}
	public void setTuidx(int tuidx) {
		this.tuidx = tuidx;
	}
	public String getTuname() {
		return tuname;
	}
	public void setTuname(String tuname) {
		this.tuname = tuname;
	}
	public String getTustart() {
		return tustart;
	}
	public void setTustart(String tustart) {
		this.tustart = tustart;
	}
	public String getTufin() {
		return tufin;
	}
	public void setTufin(String tufin) {
		this.tufin = tufin;
	}
	public String getTudate() {
		return tudate;
	}
	public void setTudate(String tudate) {
		this.tudate = tudate;
	}
	public String getTuing() {
		return tuing;
	}
	public void setTuing(String tuing) {
		this.tuing = tuing;
	}
	public int getTufile() {
		return tufile;
	}
	public void setTufile(int tufile) {
		this.tufile = tufile;
	}
	public String getTunotyn() {
		return tunotyn;
	}
	public void setTunotyn(String tunotyn) {
		this.tunotyn = tunotyn;
	}
	public String getTudelyn() {
		return tudelyn;
	}
	public void setTudelyn(String tudelyn) {
		this.tudelyn = tudelyn;
	}
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
	
	
}
