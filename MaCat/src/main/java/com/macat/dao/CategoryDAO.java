package com.macat.dao;

import java.util.List;

import com.macat.dto.ProductsDTO;

public interface CategoryDAO {
	
	public ProductsDTO getProduct(String sq);

	public int getReviewsCount();

	@SuppressWarnings("rawtypes") public List getColors(String sq);
	
	@SuppressWarnings("rawtypes") public List getProductImages(String sq);
	
	public int updateProductViewCount(String group);

}
