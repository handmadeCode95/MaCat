package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.OrderDTO;
import com.macat.dto.PointDTO;

@Repository("adminPointManagementDAO")
public class AdminPointManagementDAO implements AdminManagementDAO{
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {return sqlSessionTemplate;}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {this.sqlSessionTemplate = sqlSessionTemplate;}
	
	// 전체 쿠폰 수량
	@Override
	public int getAdminCount()	{
		return sqlSessionTemplate.selectOne("points_count");
	}
	
	// 전체 쿠폰 정보 가져오기
	@Override
	public List<PointDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("points", map);
	}
	
	// 쿠폰 and조건 검색결과 인원	
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("points_and_count", adminSearchDTO);
	}

	// 쿠폰 or조건 검색결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("points_or_count", adminSearchDTO);	
	}
	
	// 쿠폰 and조건 검색
	@Override
	public List<PointDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("points_and_search", adminSearchDTO);
	}
	
	// 쿠폰 and조건 검색
	@Override
	public List<PointDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("points_or_search", adminSearchDTO);
	}
	
	// 쿠폰 수정 : 많지 않음 - 주문량, 주문결제포인트, 주문상태
	public int updateOrder(PointDTO pointDTO) {
		return sqlSessionTemplate.update("points_update", pointDTO);
	}
	
	// 쿠폰 삭제
	@Override
	public int deleteAdmin(String point_sq) {
		return sqlSessionTemplate.delete("points_delete", point_sq);
	}	
	
}