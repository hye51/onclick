package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.Criteria;
import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;

public interface TaskService { //���� ����
	
	//���� Ȩ ��ú��� ���� ���
	public ArrayList<TaskVO> taskDashSelectAll(int lidx);
	
	//���� ���뺸��
	public TaskVO taskSelectOne(int tuidx);

	//���� ���
	public ArrayList<TaskVO> taskSelectAll(HashMap<String, Object> hm);
	
	//��ü ���� ��������
	public int taskTotalCount(int lidx);
	
	//���� & ���� ���ε�
	public int taskAndFileInsert(HashMap<String,Object> hm,HashMap<String, Object> hmFile, int lidx);
	
	//������ ���ε�
	public int taskInsert(HashMap<String,Object> hm, int lidx);
	
	//���� ����
	public int taskModify(HashMap<String,Object> hm);
	
	//���� & ���� ����
	public int taskAndFileModify(HashMap<String,Object> hm,HashMap<String, Object> hmFile);
	
	//���� �����ε��� ����(ajax)
	public int tExFileDelete(int tuidx, int fidx);
	
	//���� ����
	public int taskDelete(int tuidx);
	
	//�л��� ���� ���(���� ������ ������Ȳ)
	public ArrayList<S_taskDTO> taskSubmitList(int tuidx);
}
