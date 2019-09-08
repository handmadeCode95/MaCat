package com.macat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.macat.dto.AdminSearchDTO;

@Repository("adminProductManagementDAO")
public class AdminProductManagementDAO implements AdminManagementDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() { return sqlSessionTemplate; }
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) { this.sqlSessionTemplate = sqlSessionTemplate; }

	
	@Override
	public int getAdminCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getAdminList(int begin, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAndCount(AdminSearchDTO adminSearchDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOrCount(AdminSearchDTO adminSearchDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getAndSearch(AdminSearchDTO adminSearchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getOrSearch(AdminSearchDTO adminSearchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAdmin(String sq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
