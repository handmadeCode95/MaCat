package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.OrderDTO;

@Repository("adminOrderManagementDAO")
public class AdminOrderManagementDAO implements AdminManagementDAO{
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	// 전체 주문 수량
	@Override
	public int getAdminCount()	{
		return sqlSessionTemplate.selectOne("orders_count");
	}
	
	// 전체 주문 정보 가져오기
	@Override
	public List<OrderDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("orders", map);
	}
	
	// 주문 and조건 검색결과 인원	
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("order_and_count", adminSearchDTO);
	}

	// 주문 or조건 검색결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("order_or_count", adminSearchDTO);	
	}
	
	// 주문 and조건 검색
	@Override
	public List<OrderDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("order_and_search", adminSearchDTO);
	}
	
	// 주문 and조건 검색
	@Override
	public List<OrderDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("order_or_search", adminSearchDTO);
	}
	
	// 주문 수정 : 많지 않음 - 주문량, 주문결제포인트, 주문상태
	public int updateOrder(OrderDTO orderDTO) {
		return sqlSessionTemplate.update("order_update", orderDTO);
	}
	
	// 주문 삭제
	@Override
	public int deleteAdmin(String order_sq) {
		return sqlSessionTemplate.delete("orders_delete", order_sq);
	}
	
	
}
