//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onclick.app.domain.AttendenceDTO;
import com.onclick.app.domain.ClassVo;
import com.onclick.app.persistence.ClassService_Mapper;

@Service("classServiceImpl")
public class ClassServiceImpl implements ClassService{

	@Autowired
	SqlSession sqlSession;
	
	@Transactional
	@Override
	public HashMap<String,Object> classInsert(ClassVo cv) {
		//강좌 업로드
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("cname", cv.getCname());
		hm.put("ccontents", cv.getCcontents());
		hm.put("csta", cv.getCsta());
		hm.put("cfin", cv.getCfin());
		hm.put("cweek", cv.getCweek());
		hm.put("creyn", cv.getCreyn());
		hm.put("cnotyn", cv.getCnotyn());
		hm.put("lidx", cv.getLidx());
		hm.put("cfile", cv.getCfile());
		hm.put("clive", cv.getClive());
		
		HashMap<String,Object> value = new HashMap<String,Object>();
		
		if(cv.getClive().equals("N")) {
			ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
			int result = csm.classInsert(hm);
	
			//insert후 cidx 값
			int cidx = Integer.parseInt(String.valueOf(hm.get("cidx")));
	
			//강의를 듣는 모든학생 insert (동영상 출석)
			int cnt = csm.stuVideoDefault(cidx, cv.getLidx());
	
			value.put("result", result);
			value.put("cidx", cidx);
		} else {
			ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
			int result = csm.classInsert(hm);
			
			//insert후 cidx 값
			int cidx = Integer.parseInt(String.valueOf(hm.get("cidx")));
			
			//강의를 듣는 모든학생 insert (실시간 출석)
			int cnt = csm.stuLiveDefault(cidx, cv.getLidx());
			
			value.put("result", result);
			value.put("cidx", cidx);
		}
		
		return value;
	}

	@Override
	public ArrayList<ClassVo> classSelect(int lidx){
		//강좌 리스트
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> alist = csm.classSelect(lidx);
		
		return alist;
	}

	@Override
	public ClassVo classSelectOne(int cidx) {
		//강좌 내용 불러오기
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ClassVo cv = csm.classSelectOne(cidx);
		
		return cv;
	}

	@Override
	public int classDelete(int cidx) {
		//강좌 삭제
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result = csm.classDelete(cidx);

		return result;
	}

	@Override
	public int classUpdate(ClassVo cv) {
		//강좌 내용 수정 
		HashMap<String,Object> hm = new HashMap<String,Object>();		
		hm.put("cidx", cv.getCidx());
		hm.put("cname", cv.getCname());
		hm.put("ccontents", cv.getCcontents());
		hm.put("csta", cv.getCsta());
		hm.put("cfin", cv.getCfin());
		hm.put("cweek", cv.getCweek());
		hm.put("creyn", cv.getCreyn());
		hm.put("cnotyn", cv.getCnotyn());
		hm.put("cfile", cv.getCfile());
		
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result=csm.classUpdate(hm);
		
		return result;
	}

	@Override
	public ArrayList<ClassVo> classFinDash(int lidx) {
		//강의 홈 대시보드 - 마감 예정인 강의(해당 강의 하나)
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> cdlist = csm.classFinDash(lidx);
		return cdlist;
	}

	@Override
	public ArrayList<ClassVo> classAllFinDash(int sidx) {
		//학생 대시보드 - 마감 예정인 강의(강의 전체)
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> clist = csm.classAllFinDash(sidx);
		return clist;
	}

	@Override
	public ArrayList<ClassVo> lastClassDash(int sidx) {
		//학생 대시보드 - 최근 수강한 강의
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> lclist = csm.lastClassDash(sidx);
		return lclist;
	}

	@Override
	public ArrayList<ClassVo> classWeekVideo(int lidx, int cweek) {
		//주차별 강의 정보 가져오기(동영상)
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> clist = csm.classWeekVideo(lidx, cweek);
		return clist;
	}

	@Override
	public ArrayList<ClassVo> classWeekLive(int lidx, int cweek) {
		//주차별 강의 정보 가져오기(실시간)
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> clist = csm.classWeekLive(lidx, cweek);
		
		return clist;
	}


}
