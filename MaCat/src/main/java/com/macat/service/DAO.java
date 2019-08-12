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
	
	
	/*////////////////////////////////// 메인 //////////////////////////////////*/

	
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
	
	
	/*////////////////////////////////// 회원 정보 관리 //////////////////////////////////*/
	
	
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
	
	
	/*////////////////////////////////// 공지사항 관리 //////////////////////////////////*/

	
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
	
	
	/*////////////////////////////////// 고객 문의 관리 //////////////////////////////////*/
	
	
	// 전체 문의 갯수
	public int getQnaCount() {
		return sqlSessionTemplate.selectOne("qna_count");
	}
	
	// 고객 문의 가져오기
	public List<QnaVO> getQnaList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("qna", map);
	}
	
	// 고객 문의 and조건 검색 결과 인원
	public int getQnaAndCount(QnaSearchVO qnaSearchVO) {
		return sqlSessionTemplate.selectOne("qna_and_count", qnaSearchVO);
	}
			
	// 고객 문의 or조건 검색 결과 인원
	public int getQnaOrCount(QnaSearchVO qnaSearchVO) {
		return sqlSessionTemplate.selectOne("qna_or_count", qnaSearchVO);
	}

	// 고객 문의 and조건 검색
	public List<QnaVO> getQnaAndSearch(QnaSearchVO qnaSearchVO) {
		return sqlSessionTemplate.selectList("qna_and_search", qnaSearchVO);
	}

	// 고객 문의 or조건 검색
	public List<QnaVO> getQnaOrSearch(QnaSearchVO qnaSearchVO) {
		return sqlSessionTemplate.selectList("qna_or_search", qnaSearchVO);
	}
		
	// 고객 문의 삭제
	public int getQnaDelete(String qna_sn) {
		return sqlSessionTemplate.delete("qna_delete", qna_sn);
	}
	
	// 고객 문의 보기
	public QnaVO getQnaView(String qna_sn) {
		return sqlSessionTemplate.selectOne("qna_view", qna_sn);
	}
	
	// 고객 문의 조회수 업데이트
	public int getQnaRdcntUpdate(QnaVO qnaVO) {
		return sqlSessionTemplate.update("qna_rdcnt_update", qnaVO);
	}
	
	
	/*////////////////////////////////// 상품 문의 관리 //////////////////////////////////*/
	
	
	// 전체 문의 갯수
	public int getPqCount() {
		return sqlSessionTemplate.selectOne("pq_count");
	}
	
	// 상품 문의 가져오기
	public List<PqVO> getPqList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("product_qna", map);
	}
	
	// 상품 문의 and조건 검색 결과 인원
	public int getPqAndCount(PqSearchVO pqSearchVO) {
		return sqlSessionTemplate.selectOne("pq_and_count", pqSearchVO);
	}
			
	// 상품 문의 or조건 검색 결과 인원
	public int getPqOrCount(PqSearchVO pqSearchVO) {
		return sqlSessionTemplate.selectOne("pq_or_count", pqSearchVO);
	}

	// 상품 문의 and조건 검색
	public List<PqVO> getPqAndSearch(PqSearchVO pqSearchVO) {
		return sqlSessionTemplate.selectList("pq_and_search", pqSearchVO);
	}

	// 상품 문의 or조건 검색
	public List<PqVO> getPqOrSearch(PqSearchVO pqSearchVO) {
		return sqlSessionTemplate.selectList("pq_or_search", pqSearchVO);
	}
		
	// 상품 문의 삭제
	public int getPqDelete(String pq_sn) {
		return sqlSessionTemplate.delete("pq_delete", pq_sn);
	}
	
	// 상품 문의 보기
	public PqVO getPqView(String pq_sn) {
		return sqlSessionTemplate.selectOne("pq_view", pq_sn);
	}
	
	
	/*////////////////////////////////// FAQ 관리 //////////////////////////////////*/
	
	
	// 전체 FAQ 갯수
	public int getFaqCount() {
		return sqlSessionTemplate.selectOne("faq_count");
	}
	
	// FAQ 가져오기
	public List<FaqVO> getFaqList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("faq", map);
	}
	
	// FAQ and조건 검색 결과 인원
	public int getFaqAndCount(FaqSearchVO faqSearchVO) {
		return sqlSessionTemplate.selectOne("faq_and_count", faqSearchVO);
	}
			
	// FAQ or조건 검색 결과 인원
	public int getFaqOrCount(FaqSearchVO faqSearchVO) {
		return sqlSessionTemplate.selectOne("faq_or_count", faqSearchVO);
	}

	// FAQ and조건 검색
	public List<FaqVO> getFaqAndSearch(FaqSearchVO faqSearchVO) {
		return sqlSessionTemplate.selectList("faq_and_search", faqSearchVO);
	}

	// FAQ or조건 검색
	public List<FaqVO> getFaqOrSearch(FaqSearchVO faqSearchVO) {
		return sqlSessionTemplate.selectList("faq_or_search", faqSearchVO);
	}
		
	// FAQ 삭제
	public int getFaqDelete(String faq_sn) {
		return sqlSessionTemplate.delete("faq_delete", faq_sn);
	}
	
	// FAQ 보기
	public FaqVO getFaqView(String faq_sn) {
		return sqlSessionTemplate.selectOne("faq_view", faq_sn);
	}
	
}
