package com.macat.dao;

import java.util.List;

import com.macat.dto.MbersDTO;

public interface MainDAO {

	public int insertMember(MbersDTO mbersDTO);

	public MbersDTO login(MbersDTO mbersDTO);

	public int updateLoginRecord(MbersDTO mbersDTO);

	@SuppressWarnings("rawtypes") public List getCarts(String sq);
	
	@SuppressWarnings("rawtypes") public List getCategories();
	
	@SuppressWarnings("rawtypes") public List getCategoryGroups(int group);

	public int getProductCount(int gorup);
	
	public int getProductCount(String name);

	@SuppressWarnings("rawtypes") public List getProductsList(int group, int begin, int end);

	@SuppressWarnings("rawtypes") public List getProductsList(String name, int begin, int end);
	
	@SuppressWarnings("rawtypes") public List getQnaCategories();

}
