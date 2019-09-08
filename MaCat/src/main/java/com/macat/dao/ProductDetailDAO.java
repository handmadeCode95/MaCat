package com.macat.dao;

import java.util.Map;

public interface ProductDetailDAO {

	public int getCartOverlap(Map<String, Object> map);
	
	public int updateCartAmount(Map<String, Object> map);
	
	public int insertCart(Map<String, Object> map);
	
}
