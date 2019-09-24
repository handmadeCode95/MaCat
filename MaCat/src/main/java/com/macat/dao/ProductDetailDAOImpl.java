package com.macat.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("productDetailDAOImpl")
public class ProductDetailDAOImpl implements ProductDetailDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	// 장바구니 중복 체크
	@Override
	public int getCartOverlap(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("cart_overlap", map);
	}
	
	// 장바구니 수량 추가
	@Override
	public int updateCartAmount(Map<String, Object> map) {
		return sqlSessionTemplate.update("cart_amt_update", map);
	}
	
	// 장바구니 추가
	@Override
	public int insertCart(Map<String, Object> map) {
		return sqlSessionTemplate.insert("add_cart", map);
	}
	
	// 장바구니 업데이트
	@Override
	public int editCart(Map<String, String> map) {
		return sqlSessionTemplate.update("edit_cart", map);
	}

}
