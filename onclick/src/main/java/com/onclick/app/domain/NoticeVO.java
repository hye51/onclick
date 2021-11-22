package com.onclick.app.domain;

public class NoticeVO {
	
	private int nidx; /* 알림고유번호 */
	private String nwriter; /* 작성자 */
	private String ncontents; /* 내용 */
	private String ndate; /* 작성날짜 */
	private String ndelyn; /* 삭제여부 */
	private String ncheck; /* 확인여부 */
	private int lidx; /* 강의 고유번호 */
	private int sidx; /* 학번 */
	private int cidx; /* 강좌고유번호 */
	private int lnidx; /* 공지사항고유번호 */
	private int tuidx; /* 과제고유번호 */

	public int getNidx() {
		return nidx;
	}
	public void setNidx(int nidx) {
		this.nidx = nidx;
	}
	public String getNwriter() {
		return nwriter;
	}
	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}
	public String getNcontents() {
		return ncontents;
	}
	public void setNcontents(String ncontents) {
		this.ncontents = ncontents;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getNdelyn() {
		return ndelyn;
	}
	public void setNdelyn(String ndelyn) {
		this.ndelyn = ndelyn;
	}
	public String getNcheck() {
		return ncheck;
	}
	public void setNcheck(String ncheck) {
		this.ncheck = ncheck;
	}
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
	public int getSidx() {
		return sidx;
	}
	public void setSidx(int sidx) {
		this.sidx = sidx;
	}
	public int getCidx() {
		return cidx;
	}
	public void setCidx(int cidx) {
		this.cidx = cidx;
	}
	public int getLnidx() {
		return lnidx;
	}
	public void setLnidx(int lnidx) {
		this.lnidx = lnidx;
	}
	public int getTuidx() {
		return tuidx;
	}
	public void setTuidx(int tuidx) {
		this.tuidx = tuidx;
	}




}
