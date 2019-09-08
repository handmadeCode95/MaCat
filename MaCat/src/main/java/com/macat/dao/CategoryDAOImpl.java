package com.macat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.macat.dto.ImagesDTO;
import com.macat.dto.ProductsDTO;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	
	@Override
	public ProductsDTO getProduct(String prduct_sq) {
		return sqlSessionTemplate.selectOne("product", prduct_sq);
	}
	
	@Override
	public int getReviewsCount() {
		return sqlSessionTemplate.selectOne("reviews_count");
	}
	
	@Override
	public List<String> getColors(String prduct_sq) {
		return sqlSessionTemplate.selectList("colors", prduct_sq);
	}
	
	@Override
	public List<ImagesDTO> getProductImages(String prduct_sq) {
		return sqlSessionTemplate.selectList("product_img_list", prduct_sq);
	}
	
	@Override
	public int updateProductViewCount(String prduct_sq) {
		return sqlSessionTemplate.update("product_view_cnt_up", prduct_sq);
	}

	public int getProductCount(int prduct_ctgry_group) {
		return sqlSessionTemplate.selectOne("products_group_list_count", prduct_ctgry_group);
	}
	
	public int getProductCount(String ctgry_nm) {
		return sqlSessionTemplate.selectOne("products_list_count", ctgry_nm);
	}
	
}
