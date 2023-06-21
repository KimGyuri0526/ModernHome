package com.modernhome.service;

import java.util.List;

import com.modernhome.domain.EmployeeVO;

public interface EmployeeService {
	
	// 사원조회
	public List<EmployeeVO> employeeList();
	
	// 사원조회 + 검색
	public List<EmployeeVO> employeeListSearch(EmployeeVO evo);
	
	// 구현동작 설계
	public void employeeJoin(EmployeeVO vo);
		
	// 로그인
	public EmployeeVO employeeLogin(EmployeeVO vo); // vo - id,pw만 저장
	
	// 사원등록
	public void regEmployee(EmployeeVO evo);
	
	// 사원삭제
	public void deleteEmployee(int emp_id);
	
	// 사원업데이트
	public void updateEmployee(EmployeeVO evo);
	
	// 팀원관리
	public List<EmployeeVO> employeeManagement(Integer emp_id);
	
	// 팀원관리 - 검색
	public List<EmployeeVO> employeeMngSearch(EmployeeVO evo, Integer session_emp_id);
}
