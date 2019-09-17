package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.DeliveryDTO;
import com.macat.dto.OrderDTO;

public class AdminDeliveryManagementDAO implements AdminManagementDAO{
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {return sqlSessionTemplate;}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {this.sqlSessionTemplate = sqlSessionTemplate;}
	
	// 전체 배송 수량
	@Override
	public int getAdminCount()	{
		return sqlSessionTemplate.selectOne("delivery_count");
	}
	
	// 전체 배송 정보 가져오기
	@Override
	public List<DeliveryDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("delivery", map);
	}
	
	// 배송 and조건 검색결과 인원	
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("delivery_and_count", adminSearchDTO);
	}

	// 배송 or조건 검색결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("delivery_or_count", adminSearchDTO);	
	}
	
	// 배송 and조건 검색
	@Override
	public List<DeliveryDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("delivery_and_search", adminSearchDTO);
	}
	
	// 배송 and조건 검색
	@Override
	public List<DeliveryDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("delivery_or_search", adminSearchDTO);
	}
	
	// 배송 수정
	public int updateOrder(DeliveryDTO deliveryDTO) {
		return sqlSessionTemplate.update("delivery_update", deliveryDTO);
	}
	
	// 배송 삭제
	@Override
	public int deleteAdmin(String dlvy_sq) {
		return sqlSessionTemplate.delete("delivery_delete", dlvy_sq);
	}	

}
