package com.macat.service;

import java.util.List;
import java.util.Map;

import com.macat.dto.PageDTO;

public interface AdminService {
	
	public PageDTO paging(String cPage);
	public List<?> getList(); 
	public List<?> getPageList();
	public List<?> getSearchList();
	public int delete(Map<String, List<String>> list);

}
