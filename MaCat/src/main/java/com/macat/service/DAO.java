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
		return sqlSessionTemplate.selectList("members", map);
	}
	
	// 회원 and조건 검색 결과 인원
	public int getMbersAndCount(MbersSearchVO mbersSearchVO) {
		return sqlSessionTemplate.selectOne("mbers_and_count", mbersSearchVO);
	}
		
	// 회원 or조건 검색 결과 인원
	public int getMbersOrCount(MbersSearchVO mbersSearchVO) {
		return sqlSessionTemplate.selectOne("mbers_or_count", mbersSearchVO);
	}

	// 회원 and조건 검색
	public List<MbersVO> getMbersAndSearch(MbersSearchVO mbersSearchVO) {
		return sqlSessionTemplate.selectList("mbers_and_search", mbersSearchVO);
	}

	// 회원 or조건 검색
	public List<MbersVO> getMbersOrSearch(MbersSearchVO mbersSearchVO) {
		return sqlSessionTemplate.selectList("mbers_or_search", mbersSearchVO);
	}

	// 회원 정보 수정
	public int getMbersUpdate(MbersVO mbersVO) {
		return sqlSessionTemplate.update("mbers_update", mbersVO);
	}

	// 회원 탈퇴(관리자)
	public int getMbersWithdrawal(String mber_sn) {
		return sqlSessionTemplate.delete("mbers_withdrawal_admin", mber_sn);
	}
	
	
	////////////////////////////////// 공지사항 관리 //////////////////////////////////

	
	// 전체 공지 갯수
		public int getNotsCount() {
			return sqlSessionTemplate.selectOne("nots_count");
		}
	
	// 공지사항 가져오기
	public List<NotsVO> getNotsList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("notices", map);
	}
	
	// 공지사항 and조건 검색 결과 인원
	public int getNotsAndCount(NotsSearchVO notsSearchVO) {
		return sqlSessionTemplate.selectOne("nots_and_count", notsSearchVO);
	}
			
	// 공지사항 or조건 검색 결과 인원
	public int getNotsOrCount(NotsSearchVO notsSearchVO) {
		return sqlSessionTemplate.selectOne("nots_or_count", notsSearchVO);
	}

	// 공지사항 and조건 검색
	public List<NotsVO> getNotsAndSearch(NotsSearchVO notsSearchVO) {
		return sqlSessionTemplate.selectList("nots_and_search", notsSearchVO);
	}

	// 공지사항 or조건 검색
	public List<NotsVO> getNotsOrSearch(NotsSearchVO notsSearchVO) {
		return sqlSessionTemplate.selectList("nots_or_search", notsSearchVO);
	}
	
	// 공지사항 삭제
	public int getNotsDelete(String not_sn) {
		return sqlSessionTemplate.delete("nots_delete", not_sn);
	}

}
