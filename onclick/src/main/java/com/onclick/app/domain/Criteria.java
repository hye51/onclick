package com.onclick.app.domain;

public class Criteria {

	private int page = 1; //페이지 값을 받는 변수
	private int perPageNum = 10; //화면 리스트 출력 개수
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
}
