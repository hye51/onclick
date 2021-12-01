package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.AttendenceDTO;
import com.onclick.app.domain.ClassVo;

public interface ClassService_Mapper {


	//���� ���ε� 
	public int classInsert(HashMap<String,Object> hm);
	
	//���� ���ε忡 ���� ������ �⺻�� �Է�
	public int stuVideoDefault(int cidx, int lidx);
	
	//���� ���ε忡 ���� �ǽð� �⺻�� �Է�
	public int stuLiveDefault(int cidx, int lidx);
	
	//���� ����Ʈ 
	public ArrayList<ClassVo> classSelect(int lidx);
	
	//���� ���� �ҷ�����
	public ClassVo classSelectOne(int cidx);
	
	//���� ���� 
	public int classDelete(int cidx);
	
	//���� ���� ���� 
	public int classUpdate(HashMap<String,Object> hm);
	
	//�л� ���� ����Ʈ 
	public HashMap<String,Object> stuClassList(int sidx);

	//���� Ȩ ��ú��� - ���� ������ ����
	public ArrayList<ClassVo> classFinDash(int lidx);
	
	//�л� ��ú��� - ���� ������ ����(���� ��ü)
	public ArrayList<ClassVo> classAllFinDash(int sidx);
	
	//�л� ��ú��� - �ֱ� ������ ����
	public ArrayList<ClassVo> lastClassDash(int sidx);
	
	//������ ���� ���� ��������
	public ArrayList<ClassVo> classWeekVideo(int lidx, int cweek);
	
	//������ ���� ���� ��������(�ǽð�)
	public ArrayList<ClassVo> classWeekLive(int lidx, int cweek); 

}
