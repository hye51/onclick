package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.LecNoticeVO;

public interface LecNoticeService {
	
	//���� �������� ���
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx);
	
	//���� ��������(��ú���)
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx);
	
	//���� �������� ���뺸��
	public LecNoticeVO lecNoticeContent(int lnidx);
	
	//���� �������� ���ε� (���� X)
	public int lecNoticeInsert(HashMap<String, Object> hm);
	
	//���� �������� ���ε� (���� O)
	public int lecNoticeAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile);
	
	//���� �������� ���� (���� X)
	public int lecNotModify(HashMap<String, Object> hm);
	
	//���� �������� ���� (���� O)
	public int lecNotAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile);
	
	//���� �������� ���� -�����ε��� ����(ajax)
	public int lnExFileDelete(int lnidx, int fidx);
	
	//���� �������� ����
	public int lecNoticeDelete(int lnidx);
}
