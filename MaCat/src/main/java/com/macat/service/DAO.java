package com.macat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	////////////////////////////////// 메인 //////////////////////////////////

	
	// 회원가입
	public int getJoin(MbersVO mbersVO) {
		return sqlSessionTemplate.insert("join", mbersVO);
	}

	// 로그인
	public MbersVO getLogin(MbersVO mbersVO) {
		return sqlSessionTemplate.selectOne("login", mbersVO);
	}

	// 접속일 업데이트
	public int getLoginRecord(MbersVO mbersVO) {
		return sqlSessionTemplate.update("login_record", mbersVO);
	}
	
	
	////////////////////////////////// 회원 정보 관리 //////////////////////////////////
	
	
	// 전체 회원 숫자
	public int getMbersCount() {
		return sqlSessionTemplate.selectOne("mbers_count");
	}
	
	// 회원 정보 가져오기
	public List<MbersVO> getMbersList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("mbers_list", map);
	}

	// 회원 and조건 검색
	public List<MbersVO> getMbersAndSearch(MbersSearchVO mbersSearchVO) {
		return sqlSessionTemplate.selectList("mber_and_search", mbersSearchVO);
	}

	// 회원 or조건 검색
	public List<MbersVO> getMbersOrSearch(MbersSearchVO mbersSearchVO) {
		return sqlSessionTemplate.selectList("mber_or_search", mbersSearchVO);
	}

	// 회원 정보 수정
	public int getMbersUpdate(MbersVO mbersVO) {
		return sqlSessionTemplate.update("mber_update", mbersVO);
	}

	// 회원 탈퇴(관리자)
	public int getMbersWithdrawal(String mber_sn) {
		return sqlSessionTemplate.delete("mber_withdrawal_admin", mber_sn);
	}
	
	
	////////////////////////////////// 공지사항 관리 //////////////////////////////////
	
	
	// 공지사항 가져오기
	public List<MbersVO> getNoticesList() {
		return sqlSessionTemplate.selectList("notices_list");
	}
	
	// 공지 and조건 검색
	public List<MbersVO> getNoticesAndSearch(NotSearchVO notSearchVO) {
		return sqlSessionTemplate.selectList("not_and_search", notSearchVO);
	}

	// 공지 or조건 검색
	public List<MbersVO> getNoticesOrSearch(NotSearchVO notSearchVO) {
		return sqlSessionTemplate.selectList("not_or_search", notSearchVO);
	}
}
