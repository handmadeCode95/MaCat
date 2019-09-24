package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.DeliveryAddrDTO;
import com.macat.dto.DeliveryDTO;

@Repository("adminDeliveryAddrManagementDAO")
public class AdminDeliveryAddrManagementDAO implements AdminManagementDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {return sqlSessionTemplate;}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {this.sqlSessionTemplate = sqlSessionTemplate;}
	
	// 전체 배송지 수량
	@Override
	public int getAdminCount()	{
		return sqlSessionTemplate.selectOne("dlvy_addr_count");
	}
	
	// 전체 배송지 정보 가져오기
	@Override
	public List<DeliveryAddrDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("dlvy_addr", map);
	}
	
	// 배송지  and조건 검색결과 인원	
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("dlvy_addr_and_count", adminSearchDTO);
	}

	// 배송지 or조건 검색결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("dlvy_addr_or_count", adminSearchDTO);	
	}
	
	// 배송지 and조건 검색
	@Override
	public List<DeliveryAddrDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("dlvy_addr_and_search", adminSearchDTO);
	}
	
	// 배송지 and조건 검색
	@Override
	public List<DeliveryAddrDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("dlvy_addr_or_search", adminSearchDTO);
	}
	
	// 배송지 수정
	public int updateOrder(DeliveryAddrDTO deliveryAddrDTO) {
		return sqlSessionTemplate.update("dlvy_addr_update", deliveryAddrDTO);
	}
	
	// 배송지 삭제
	@Override
	public int deleteAdmin(String da_sq) {
		return sqlSessionTemplate.delete("dlvy_addr_delete", da_sq);
	}	
	
}