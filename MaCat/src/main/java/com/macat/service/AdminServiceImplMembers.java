package com.macat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macat.dao.DAO;
import com.macat.dto.PageDTO;

@Service("adminServiceMembers")
public class AdminServiceImplMembers extends Paging implements AdminService {
	
	@Autowired
	private DAO dao;
	public DAO getDao() {return dao;}
	public void setDao(DAO dao) {this.dao = dao;}

	@Override
	public PageDTO paging(String cPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getPageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getSearchList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Map<String, List<String>> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
