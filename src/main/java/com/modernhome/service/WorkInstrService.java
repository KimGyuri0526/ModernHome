package com.modernhome.service;

import java.util.List;

import com.modernhome.domain.WorkInstrVO;

public interface WorkInstrService {
	
	// 작업지시서 조회
	public List<WorkInstrVO> getInstr(int work_id) throws Exception;
	
	// 작업지시 목록 조회
	public List<WorkInstrVO> getInstrList() throws Exception;
	
}