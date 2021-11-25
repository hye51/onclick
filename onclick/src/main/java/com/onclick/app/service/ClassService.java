//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService {

	//강좌 작성 
	public HashMap<String,Object> classInsert(ClassVo cv);
	
	//강좌 리스트
	public ArrayList<ClassVo> classSelect(int lidx);
	
	//강좌 내용 불러오기
	public ClassVo classSelectOne(int cidx);
	
	//강좌 삭제 
	public int classDelete(int cidx);
	
	//강좌 내용 수정 
	public int classUpdate(ClassVo cv);
	
	//강의 홈 대시보드 - 마감 예정인 강의(해당 강의 하나)
	public ArrayList<ClassVo> classFinDash(int lidx);
	
	//학생 대시보드 - 마감 예정인 강의(강의 전체)
	public ArrayList<ClassVo> classAllFinDash(int sidx);
}
