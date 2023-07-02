package com.modernhome.persistence;

import java.util.List;

import com.modernhome.domain.LineShutdownVO;
import com.modernhome.domain.LineVO;
import com.modernhome.domain.PageVO;

public interface LineDAO {
	
	// 라인 목록 조회
	public List<LineVO> getLineList() throws Exception;
	
	// 라인조회 + 검색
	public List<LineVO> getLineListSearch(LineVO lvo) throws Exception;
	
	// 라인 등록
	public void regLine(LineVO lvo) throws Exception;
	
	// 라인수정
	public void updateLine(LineVO lvo) throws Exception;
	
	// 라인 삭제
	public void deleteLine(int line_id) throws Exception;
	
	// 라인 수정 정보 저장
	public void regLineShutdown(LineShutdownVO lsvo) throws Exception;
	
}