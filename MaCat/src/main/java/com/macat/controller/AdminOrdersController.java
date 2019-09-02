package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macat.dao.DAO;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrdersController {

	@Autowired
	private DAO dao;
	public DAO getDao() {return dao;}
	public void setDao(DAO dao) {this.dao = dao;}
	
	// 주문 관리로 이동
	// @GetMapping("manager.mcat")
	// public ModelAndView getOdrManageCmd() {

	// }
	
}
