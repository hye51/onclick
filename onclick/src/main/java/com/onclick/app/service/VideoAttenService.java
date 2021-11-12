//211027 jhr 작업
package com.onclick.app.service;

import java.util.HashMap;

import com.onclick.app.domain.VideoAttenDto;

public interface VideoAttenService {


	//영상 시청시 시청기록 업데이트
	public int videoUpdate(VideoAttenDto vd);
}
