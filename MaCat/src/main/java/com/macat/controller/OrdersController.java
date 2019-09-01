package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;

@Controller
@RequestMapping("orders/*.mcat")
public class OrdersController {
	
	@Autowired
	private DAO dao;
	
	// 결제페이지로 이동
	@GetMapping("new.mcat")
	public ModelAndView getOrderCmd() {
		return new ModelAndView("macat_order_page");
	}

}
