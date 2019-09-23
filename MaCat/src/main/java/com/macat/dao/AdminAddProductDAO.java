package com.macat.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.ImagesDTO;
import com.macat.dto.ProductsDTO;

@Repository("adminProductDAOImpl")
public class AdminAddProductDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	
	public int insertProduct(ProductsDTO productsDTO) {
		return sqlSessionTemplate.insert("add_product", productsDTO);
	}
	
	public int insertImage(ImagesDTO imagesDTO) {
		return sqlSessionTemplate.insert("add_img", imagesDTO);
	}
	
	public int insertImages(List<ImagesDTO> imagesDTOs) {
		return sqlSessionTemplate.update("add_imgs", imagesDTOs);
	}
	
	public String getCategoryGroup(String ctgry_nm) {
		return sqlSessionTemplate.selectOne("category_group", ctgry_nm);
	}
	
	public int insertColors(Map<String, Object> map) {
		return sqlSessionTemplate.update("add_colors", map);
	}

}
