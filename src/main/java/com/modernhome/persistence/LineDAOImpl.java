package com.modernhome.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.modernhome.domain.LineVO;
import com.modernhome.domain.PageVO;

@Repository
public class LineDAOImpl implements LineDAO {
	
	// 의존성 주입
	@Inject
	private SqlSession sqlSession;
	
	// 로거
	private static final Logger logger = LoggerFactory.getLogger(LineDAOImpl.class);
	
	// 네임스페이스
	private static final String NAMESPACE = "com.modernhome.mapper.LineMapper";

	// 라인 조회 (페이징)
	@Override
	public List<LineVO> lineList(PageVO pvo) throws Exception {
		logger.debug("DAO -> mapper호출 -> SQL 실행(라인조회");
		
		return sqlSession.selectList(NAMESPACE + ".lineList",pvo);
	}
	
	// 총 글 개수 계산 (페이징)
	@Override
	public int getTotalCntMate() throws Exception {
		return sqlSession.selectOne(NAMESPACE +".lineTotalCnt");
	}

	// 라인 조회 + 검색(페이징)
	@Override
	public List<LineVO> lineListSearch(LineVO lvo, PageVO pvo) throws Exception{
		logger.debug("DAO -> mapper호출 -> SQL 실행 (사원조회 - 검색된 데이터만 출력)");

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mvo", lvo);
		paramMap.put("pageVO", pvo);
		
		return sqlSession.selectList(NAMESPACE +  ".lineListSearch",paramMap);
	}
	
	// 검색 결과 개수 (페이징)
	@Override
	public int getLineSearchCnt(LineVO lvo) {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mvo", lvo);
		
		return sqlSession.selectOne(NAMESPACE+".lineSearchCnt",paramMap);
	}

	// 라인 등록
	@Override
	public void regLine(LineVO lvo) {
		logger.debug("DAO -> mapper 호출 -> SQL 실행(라인등록)");
		
		sqlSession.insert(NAMESPACE+".regLine",lvo);
		
	}

	// 라인수정
	@Override
	public void updateLine(LineVO lvo) {
		logger.debug("DAO -> mapper호출 -> SQL실행(라인수정)");
		
		sqlSession.update(NAMESPACE + ".updateLine",lvo);
		
	}
	
	// 라인 삭제
	@Override
	public void deleteLine(int line_id) {
		logger.debug("DAO -> mapper 호출 -> SQL 실행(라인삭제)");
		
		sqlSession.delete(NAMESPACE + ".deleteLine",line_id);
		
	}


}