package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.ProductsDTO;
import com.macat.dto.ProductsSearchDTO;

@Repository("adminProductManagementDAO")
public class AdminProductManagementDAO implements AdminManagementDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }

	// 전체 상품 갯수
	@Override
	public int getAdminCount() {
		return sqlSessionTemplate.selectOne("products_count");
	}
	
	// 전체 상품정보 가져오기
	@Override
	public List<ProductsDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("products", map);
	}	
	
	// 상품 and조건 검색결과 인원
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("products_and_count", adminSearchDTO);
	}
	
	// 상품 or조건 검색 결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("products_or_count", adminSearchDTO);
	}
	
	// 상품 and 조건 검색
	@Override
	public List<ProductsDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("products_and_search", adminSearchDTO);
	}	
	
	//	상품 or 조건 검색
	@Override
	public List<ProductsDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("products_or_search", adminSearchDTO);
	}

	// 상품 삭제(관리자 페이지)
	@Override
	public int deleteAdmin(String prduct_sq) {
		return sqlSessionTemplate.delete("products_delete", prduct_sq);
	}
		
	// 하나의 상품 정보 가져오기
	public ProductsDTO getProduct(String prduct_sq) {
		return sqlSessionTemplate.selectOne("product", prduct_sq);
	}
	
	// 상품 정보 수정
	public int getProductsUpdate(ProductsDTO productsDTO) {
		return sqlSessionTemplate.update("products_update", productsDTO);
	}	

	// 상품 and조건 검색 결과 인원
	public int getProductsAndCount(ProductsSearchDTO productsSearchDTO) {
		return sqlSessionTemplate.selectOne("products_and_count", productsSearchDTO);
	}
	
	// 상품 or조건 검색 결과 인원
	public int getProductsOrCount(ProductsSearchDTO productsSearchDTO) {
		return sqlSessionTemplate.selectOne("products_or_count", productsSearchDTO);
	}
	
	// 상품 and조건 검색
	public List<ProductsDTO> getProductsAndSearch(ProductsSearchDTO productsSearchDTO){
		return sqlSessionTemplate.selectList("products_and_search", productsSearchDTO);
	}
	
	// 상품 or조건 검색
	public List<ProductsDTO> getProductsOrSearch(ProductsSearchDTO productsSearchDTO){
		return sqlSessionTemplate.selectList("products_or_search", productsSearchDTO);
	}

}
