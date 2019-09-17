package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.ReviewDTO;

@Repository("adminReviewManagementDAO")
public class AdminReviewManagementDAO implements AdminManagementDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	// 리뷰 전체
	@Override
	public int getAdminCount() {
		return sqlSessionTemplate.selectOne("reviews_count");
	}
	
	// 리뷰 전체 조회
	@Override
	public List<ReviewDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("reviews", map);
	}
	
	// 리뷰 and조건 검색 결과 인원
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("reviews_and_count", adminSearchDTO);
	}
		
	// 리뷰 or조건 검색 결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("reviews_or_count", adminSearchDTO);
	}

	// 리뷰 and조건 검색
	@Override
	public List<ReviewDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("reviews_and_search", adminSearchDTO);
	}

	// 리뷰 or조건 검색
	@Override
	public List<ReviewDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("reviews_or_search", adminSearchDTO);
	}

	// 리뷰 삭제(관리자)
	@Override
	public int deleteAdmin(String re_sq) {
		return sqlSessionTemplate.delete("reviews_delete", re_sq);
	}
	
	// 리뷰글 한개 가져오기
	public ReviewDTO getReview(String re_sq) {
		return sqlSessionTemplate.selectOne("review_read", re_sq);
	}
}
