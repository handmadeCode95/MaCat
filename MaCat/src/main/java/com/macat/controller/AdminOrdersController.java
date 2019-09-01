package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macat.dao.DAO;

@Controller
@RequestMapping("admin/orders/*.mcat")
public class AdminOrdersController {

	@Autowired
	private DAO dao;
	
	// 주문 관리로 이동
	// @GetMapping("manager.mcat")
	// public ModelAndView getOdrManageCmd() {

	// }
	
}
