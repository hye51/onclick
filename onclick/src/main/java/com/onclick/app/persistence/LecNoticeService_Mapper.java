package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.LecNoticeVO;

public interface LecNoticeService_Mapper {
	
	//���� �������� ���
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx);
	
	//���� ��������(��ú���)
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx);
	
	//���� ���뺸��
	public LecNoticeVO lecNoticeContent(int lnidx);
	
	//���� �������� ���ε�
	public int lecNoticeInsert(HashMap<String, Object> hm);
	
	//���� �������� ���� (���� X)
	public int lecNotModify(HashMap<String, Object> hm);
	
	//���� �������� ���� (���� ))
	public int lecNotAndFileModify(HashMap<String, Object> hm);
	
	//���� �������� ���� - ���� �ε��� ����
	public int lnExFileDelete(int lnidx);
	
	//���� �������� ����
	public int lecNoticeDelete(int lnidx);
}
