package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;

@Controller
@RequestMapping("mypage/*.mcat")
public class MyPageController {
	
	@Autowired
	private DAO dao;
	
	// 마이페이지 이동
	@GetMapping("main.mcat")
	public ModelAndView getMyPageCmd() {
		return new ModelAndView("member/mypage");
	}

	// 구매후기 페이지 이동
	@GetMapping("review.mcat")
	public ModelAndView getReviewCmd() {
		return new ModelAndView("member/review");
	}
	
	/* 아래로는 매핑 수정 필요 */

	// 마이페이지 - 주문내역관리 이동
	@GetMapping("mypage_order_inquiry.mcat")
	public ModelAndView getOrderInquiryCmd() {
		return new ModelAndView("member/mypage_order_inquiry");
	}

	// 마이페이지 - 프로필 관리 이동

	// 마이페이지 - 찜목록 관리 이동
	@GetMapping("mypage_wishlist.mcat")
	public ModelAndView getWishListCmd() {
		return new ModelAndView("member/mypage_wishlist");
	}

	// 마이페이지 - 마일리지 이동

	// 마이페이지 - 게시물 관리 페이지 이동
	@GetMapping("mypage_post_management.mcat")
	public ModelAndView getPostManageCmd() {
		return new ModelAndView("member/mypage_post_management");
	}

	// 마이페이지 - 배송주소록 관리 이동
	@GetMapping("mypage_deliveryAdress.mcat")
	public ModelAndView getDeliveryAdressCmd() {
		return new ModelAndView("member/mypage_deliveryAdress");
	}
	
}
