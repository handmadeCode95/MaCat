package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminDTO;
import com.macat.dto.AdminSearchDTO;
import com.macat.dto.QnaDTO;

@Repository("adminQnaManagementDAO")
public class AdminQnaManagementDAO implements AdminPostManagementDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }

	
	// 전체 문의 갯수
	@Override
	public int getAdminCount() {
		return sqlSessionTemplate.selectOne("qna_count");
	}

	// 고객 문의 가져오기
	@Override
	public List<QnaDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("qna", map);
	}

	// 고객 문의 and조건 검색 결과 인원
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("qna_and_count", adminSearchDTO);
	}

	// 고객 문의 or조건 검색 결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("qna_or_count", adminSearchDTO);
	}

	// 고객 문의 and조건 검색
	@Override
	public List<QnaDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("qna_and_search", adminSearchDTO);
	}

	// 고객 문의 or조건 검색
	@Override
	public List<QnaDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("qna_or_search", adminSearchDTO);
	}

	// 고객 문의 삭제
	@Override
	public int deleteAdmin(String sq) {
		return sqlSessionTemplate.delete("qna_delete", sq);
	}
	
	// 고객 문의 보기
	@Override
	public AdminDTO getPostView(String sq) {
		return sqlSessionTemplate.selectOne("qna_view", sq);
	}
	
	// 고객 문의 조회수 업데이트
	public int updateQnaViewCount(QnaDTO qnaDTO) {
		return sqlSessionTemplate.update("qna_rdcnt_update", qnaDTO);
	}

}
