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
	
	
	@Override
	public int insertProduct(ProductsDTO productsDTO) {
		return sqlSessionTemplate.insert("add_product", productsDTO);
	}
	
	@Override
	public int insertImage(ImagesDTO imagesDTO) {
		return sqlSessionTemplate.insert("add_img", imagesDTO);
	}
	
	@Override
	public int insertImages(List<ImagesDTO> imagesDTOs) {
		return sqlSessionTemplate.insert("add_imgs", imagesDTOs);
	}

}
