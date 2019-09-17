package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.macat.dao.AdminCouponManagementDAO;
import com.macat.dto.CouponSearchDTO;
import com.macat.dto.OrderSearchDTO;

@Controller
public class AdminCouponController {
	
	private final AdminCouponManagementDAO adminCouponManagementDAO;
	
	@Autowired
	public AdminCouponController(AdminCouponManagementDAO adminCouponManagementDAO) {
		this.adminCouponManagementDAO = adminCouponManagementDAO;
	}
	
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	private CouponSearchDTO couponSearchDTO; // 페이징을 위한 회원 정보 검색 기록		
	
}
