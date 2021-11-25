package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService_Mapper {


	//강좌 업로드 
	public int classInsert(HashMap<String,Object> hm);
	
	//강좌 업로드에 따른 동영상 기본값 입력
	public int stuVideoDefault(int cidx, int lidx);
	
	//강좌 리스트 
	public ArrayList<ClassVo> classSelect(int lidx);
	
	//강좌 내용 불러오기
	public ClassVo classSelectOne(int cidx);
	
	//강좌 삭제 
	public int classDelete(int cidx);
	
	//강좌 내용 수정 
	public int classUpdate(HashMap<String,Object> hm);
	
	//학생 강좌 리스트 
	public HashMap<String,Object> stuClassList(int sidx);

	//강의 홈 대시보드 - 마감 예정인 강의
	public ArrayList<ClassVo> classFinDash(int lidx);
	
	//학생 대시보드 - 마감 예정인 강의(강의 전체)
	public ArrayList<ClassVo> classAllFinDash(int sidx);
	
	//학생 대시보드 - 최근 수강한 강의
	public ArrayList<ClassVo> lastClassDash(int sidx);

}
