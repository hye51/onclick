package com.onclick.app.domain;

public class TaskVO { //������ ���� ���ε�

	private int tuidx; //���� �ε���
	private String tuname; //���� ����
	private String tustart; //���� ������
	private String tufin; //���� ������
	private String tudate; //�ۼ���
	private String tudelyn;
	private int lidx; //���ǰ�����ȣ
	private String tucontents; //���� ����
	private int fidx; //÷������ ��ȣ
	
	public int getFidx() {
		return fidx;
	}
	public void setFidx(int fidx) {
		this.fidx = fidx;
	}
	public String getTucontents() {
		return tucontents;
	}
	public void setTucontents(String tucontents) {
		this.tucontents = tucontents;
	}
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
