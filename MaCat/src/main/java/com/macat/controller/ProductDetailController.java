package com.macat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.ProductDetailDAOImpl;
import com.macat.util.PagingUtil;

public class ProductDetailController {
	
	private final ProductDetailDAOImpl productDetailDAOImpl;

	@Autowired
	public ProductDetailController(ProductDetailDAOImpl productDetailDAOImpl, PagingUtil paging) {
		this.productDetailDAOImpl = productDetailDAOImpl;
	}
	
	boolean overlap;

	
	// 장바구니 중복 체크
	@PostMapping("cart_overlap.mcat")
	@ResponseBody
	public boolean isOverlapCmd(@RequestBody Map<String, Object> requestMap) {
		overlap = productDetailDAOImpl.getCartOverlap(requestMap) > 0 ?true :false; 
		return overlap;
	}
	
	// 장바구니 수량 추가
	@PostMapping("add_cart.mcat")
	@ResponseBody
	public int addCartCmd(@RequestBody Map<String, Object> requestMap) {
		int result = 0;
		if (overlap) {
			result = productDetailDAOImpl.updateCartAmount(requestMap);
		}else {
			result = productDetailDAOImpl.insertCart(requestMap);
		}
		return result;

	}
	
	// 결제페이지로 이동
	@GetMapping("order.mcat")
	public ModelAndView redirectOrderPageCmd(ModelAndView mv) {
		mv.setViewName("");
		return mv;
	}

}
