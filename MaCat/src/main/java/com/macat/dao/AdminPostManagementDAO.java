package com.macat.dao;

import com.macat.dto.AdminDTO;

public interface AdminPostManagementDAO extends AdminManagementDAO {

	public AdminDTO getPostView(String sq);
	
}
