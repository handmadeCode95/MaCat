package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminDTO;
import com.macat.dto.AdminSearchDTO;
import com.macat.dto.FaqDTO;

@Repository("adminFaqManagementDAO")
public class AdminFaqManagementDAO implements AdminPostManagementDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }

	@Override
	public int getAdminCount() {
		return sqlSessionTemplate.selectOne("faq_count");
	}

	@Override
	public List<FaqDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("faq", map);
	}

	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("faq_and_count", adminSearchDTO);
	}

	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("faq_or_count", adminSearchDTO);
	}

	@Override
	public List<FaqDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("faq_and_search", adminSearchDTO);
	}

	@Override
	public List<FaqDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("faq_or_search", adminSearchDTO);
	}
	
	@Override
	public AdminDTO getPostView(String sq) {
		return sqlSessionTemplate.selectOne("faq_view", sq);
	}

	@Override
	public int deleteAdmin(String sq) {
		return sqlSessionTemplate.delete("faq_delete", sq);
	}
	
}
