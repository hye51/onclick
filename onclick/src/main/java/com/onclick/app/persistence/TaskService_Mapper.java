package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;

public interface TaskService_Mapper {

	//���� ���뺸��
	public TaskVO taskSelectOne(int tuidx);

	//���� ���
	public ArrayList<TaskVO> taskSelectAll(int lidx);
	
	//���� ���ǿ� ���
	public TaskVO taskAll(int lidx);
	
	//���� ���� ���ε�
	public int taskFileInsert(HashMap<String,Object> hmFile);
	
	//���� ���� ���ε�
	public int taskInsert(HashMap<String,Object> hm);
	
	//���� ����
	public int taskDelete(int tuidx);
	
	//�л� ���� ����(���� ���� ���ε� ��)
	public int stuTaskDefault(int lidx, int tuidx);
	
	//���� ����
	public int taskModify(HashMap<String,Object> hm);
	
	//���� ���� ����
	public int taskFileModify(HashMap<String,Object> hm);
	
	//���� �����ε��� ����
	public int tExFileDelete(int tuidx);

	//�л��� ���� ���(���� ������ ������Ȳ)
	public ArrayList<S_taskDTO> taskSubmitList(int tuidx);
}
