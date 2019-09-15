package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.CouponDTO;
import com.macat.dto.OrderDTO;

@Repository("adminCouponManagementDAO")
public class AdminCouponManagementDAO implements AdminManagementDAO{
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {return sqlSessionTemplate;}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {this.sqlSessionTemplate = sqlSessionTemplate;}

	// 전체 쿠폰 수량
	@Override
	public int getAdminCount()	{
		return sqlSessionTemplate.selectOne("coupons_count");
	}
	
	// 전체 쿠폰 정보 가져오기
	@Override
	public List<CouponDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("coupons", map);
	}
	
	// 쿠폰 and조건 검색결과 인원	
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("coupons_and_count", adminSearchDTO);
	}

	// 쿠폰 or조건 검색결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("coupons_or_count", adminSearchDTO);	
	}
	
	// 쿠폰 and조건 검색
	@Override
	public List<CouponDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("coupons_and_search", adminSearchDTO);
	}
	
	// 쿠폰 or조건 검색
	@Override
	public List<CouponDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("coupons_or_search", adminSearchDTO);
	}
	
	// 쿠폰 수정 : 많지 않음 - 주문량, 주문결제포인트, 주문상태
	public int updateOrder(CouponDTO couponDTO) {
		return sqlSessionTemplate.update("coupons_update", couponDTO);
	}
	
	// 쿠폰 삭제
	@Override
	public int deleteAdmin(String cpon_sq) {
		return sqlSessionTemplate.delete("coupons_delete", cpon_sq);
	}
}
