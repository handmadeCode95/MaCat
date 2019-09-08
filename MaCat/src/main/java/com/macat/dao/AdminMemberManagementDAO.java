package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;
import com.macat.dto.MberGradDTO;
import com.macat.dto.MbersDTO;

@Repository("adminMemberManagementDAO")
public class AdminMemberManagementDAO implements AdminManagementDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }
	
	
	// 회원 전체 인원
	@Override
	public int getAdminCount() {
		return sqlSessionTemplate.selectOne("mbers_count");
	}
	
	// 회원 and조건 검색 결과 인원
	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("mbers_and_count", adminSearchDTO);
	}
		
	// 회원 or조건 검색 결과 인원
	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectOne("mbers_or_count", adminSearchDTO);
	}
	
	// 회원 전체 조회
	@Override
	public List<MbersDTO> getAdminList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("members", map);
	}

	// 회원 and조건 검색
	@Override
	public List<MbersDTO> getAndSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("mbers_and_search", adminSearchDTO);
	}

	// 회원 or조건 검색
	@Override
	public List<MbersDTO> getOrSearch(AdminSearchDTO adminSearchDTO) {
		return sqlSessionTemplate.selectList("mbers_or_search", adminSearchDTO);
	}

	// 회원 탈퇴(관리자)
	@Override
	public int deleteAdmin(String mber_sq) {
		return sqlSessionTemplate.delete("mbers_withdrawal_admin", mber_sq);
	}
	
	// 회원 등급 조회
	public List<MberGradDTO> getMemberGradeList() {
		return sqlSessionTemplate.selectList("mber_grad_list");
	}
	
	// 회원 정보 수정
	public int updateMember(MbersDTO mbersDTO) {
		return sqlSessionTemplate.update("mbers_update", mbersDTO);
	}
	
}
