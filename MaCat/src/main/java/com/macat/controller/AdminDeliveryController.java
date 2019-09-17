package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.macat.dao.AdminMemberManagementDAO;
import com.macat.dto.DeliverySearchDTO;

@Controller
public class AdminDeliveryController {

	private final AdminMemberManagementDAO adminMemberManagementDAO;
	
	@Autowired
	public AdminDeliveryController(AdminMemberManagementDAO adminMemberManagementDAO) {
		this.adminMemberManagementDAO = adminMemberManagementDAO;
	}
	
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	private DeliverySearchDTO deliverySearchDTO; // 페이징을 위한 회원 정보 검색 기록
	
}
