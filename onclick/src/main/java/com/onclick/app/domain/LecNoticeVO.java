package com.onclick.app.domain;

public class LecNoticeVO { //���� ��������

	private int lnidx; //�������� �ε���
	private String lnsubject; //�������� ����
	private String lncontents; //�������� ����
	private String lndate; //�������� �ۼ���
	private String lndelyn; //�������� ��������
	private int lidx; //���� �ε���
	private int fidx; //���� �ε���
	
	
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
