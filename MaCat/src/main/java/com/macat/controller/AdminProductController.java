package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.AdminProductManagementDAO;
import com.macat.dto.FaqSearchDTO;
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.QnaSearchDTO;

@Controller
public class AdminProductController {
	
	private final AdminProductManagementDAO adminProductManagementDAO;

	@Autowired
	public AdminProductController(AdminProductManagementDAO adminProductManagementDAO) {
		this.adminProductManagementDAO = adminProductManagementDAO;
	}

	// 페이징을 위한 회원 정보 검색 기록
	private NotsSearchDTO notsSearchDTO;
	private QnaSearchDTO qnaSearchDTO;
	private FaqSearchDTO faqSearchDTO;

	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	
	
	// 상품관리로 이동
	@GetMapping("product_manage.mcat")
	public ModelAndView redirectProductManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/product/product_manager");
		
		this.cPage = cPage;
		usedDTO = "ProductsDTO";
		
		return mv;
	}

}
