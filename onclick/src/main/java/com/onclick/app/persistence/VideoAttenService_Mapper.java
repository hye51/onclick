package com.onclick.app.persistence;

import java.util.HashMap;

public interface VideoAttenService_Mapper {

	//영상 시청시 시청기록 업데이트
		public int videoUpdate(HashMap<String,Object> hm);
}
