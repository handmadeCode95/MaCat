package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.macat.dto.CartsDTO;
import com.macat.dto.CtgriesDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.ProductsDTO;

@Repository("mainDAOImpl")
public class MainDAOImpl implements MainDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	
	@Override
	public int insertMember(MbersDTO mbersDTO) {
		return sqlSessionTemplate.insert("join", mbersDTO);
	}
	
	@Override
	public MbersDTO login(MbersDTO mbersDTO) {
		return sqlSessionTemplate.selectOne("login", mbersDTO);
	}
	
	@Override
	public int updateLoginRecord(MbersDTO mbersDTO) {
		return sqlSessionTemplate.update("login_record", mbersDTO);
	}
	
	@Override
	public List<CartsDTO> getCarts(String mber_sq) {
		return sqlSessionTemplate.selectList("cart", mber_sq);
	}
	
	@Override
	public List<CtgriesDTO> getCategories() {
		return sqlSessionTemplate.selectList("categories");
	}
	
	@Override
	public List<CtgriesDTO> getCategoryGroups(int ctgry_group) {
		return sqlSessionTemplate.selectList("ctgry_group", ctgry_group);
	}
	
	@Override
	public int getProductCount(int prduct_ctgry_group) {
		return sqlSessionTemplate.selectOne("products_group_list_count", prduct_ctgry_group);
	}
	
	@Override
	public int getProductCount(String ctgry_nm) {
		return sqlSessionTemplate.selectOne("products_list_count", ctgry_nm);
	}
	
	@Override
	public List<ProductsDTO> getProductsList(int prduct_ctgry_group, int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("prduct_ctgry_group", prduct_ctgry_group);
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("products_group_list", map);
	}
	
	@Override
	public List<ProductsDTO> getProductsList(String ctgry_nm, int begin, int end) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ctgry_nm", ctgry_nm);
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		return sqlSessionTemplate.selectList("products_list", map);
	}
	
	@Override
	public List<CtgriesDTO> getQnaCategories() {
		return sqlSessionTemplate.selectList("qna_ctgries_list");
	}

}
