package com.macat.dao;

import java.util.List;

import com.macat.dto.AdminSearchDTO;

public interface AdminManagementDAO {
	
	public int getAdminCount();
	
	@SuppressWarnings("rawtypes") public List getAdminList(int begin, int end);
	
	public int getAndCount(AdminSearchDTO adminSearchDTO);
	
	public int getOrCount(AdminSearchDTO adminSearchDTO);
	
	@SuppressWarnings("rawtypes") public List getAndSearch(AdminSearchDTO adminSearchDTO);
	
	@SuppressWarnings("rawtypes") public List getOrSearch(AdminSearchDTO adminSearchDTO);
	
	public int deleteAdmin(String sq);

}
