package com.modernhome.persistence;

import java.util.List;

import com.modernhome.domain.WijoinVO;

public interface QualityDAO {
	
	// 품질현황 목록 조회
	public List<WijoinVO> getQualityList() throws Exception;
	
	// 품질현황 목록 조회 + 검색
	public List<WijoinVO> getQualitySearch(String qc_num, String startDate, String endDate, String qc_yn) throws Exception;
	
	// 품질 업데이트
	public void updateQuality(WijoinVO wvo);
	
} // QualityDAO
