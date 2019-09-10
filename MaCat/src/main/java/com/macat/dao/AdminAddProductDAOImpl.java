package com.macat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.ImagesDTO;
import com.macat.dto.ProductsDTO;

@Repository("adminProductDAOImpl")
public class AdminAddProductDAOImpl implements AdminAddProductDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	// 상품 추가
	@Override
	public int insertProduct(ProductsDTO productsDTO) {
		return sqlSessionTemplate.insert("add_product", productsDTO);
	}
	// 상품 이미지 추가
	@Override
	public int insertImage(ImagesDTO imagesDTO) {
		return sqlSessionTemplate.insert("add_img", imagesDTO);
	}
	// 상품 이미지 추가
	@Override
	public int insertImages(List<ImagesDTO> imagesDTOs) {
		return sqlSessionTemplate.insert("add_imgs", imagesDTOs);
	}

}
