package com.onclick.app.domain;

import org.springframework.stereotype.Component;

@Component
public class PageMaker {

	private int totalCount; //�Խñ��� �� ����
	private int startPage; //����
	private int endPage; //��
	private int displayPageNum = 5; // ������ ���� <- 1 2 3 4 5 6 7 8 9 ... ->
	private boolean prev; //����
	private boolean next; //����
	private Criteria cri; 
	
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void calcData() {
		//total ������ �Ѿ���� 
		//startPage ���� endPage ���� ����
		//����, ���� ��ư�� ���� ���θ� ����
		
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum); // ceil - �ø� 
		//System.out.println("endPage"+ endPage);
		startPage = (endPage-displayPageNum)+1;
		//System.out.println("startPage"+ startPage);
		
		int tempEndPage = (int)Math.ceil(totalCount/(double)cri.getPerPageNum());
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//System.out.println("endPage"+ endPage);
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
		
	}
}
