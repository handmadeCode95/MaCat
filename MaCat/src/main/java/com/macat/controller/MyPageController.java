package com.macat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.MainDAOImpl;

@Controller
public class MyPageController {

	private final MainDAOImpl mainDAOImpl;

	@Autowired
	public MyPageController(MainDAOImpl mainDAOImpl) {
		this.mainDAOImpl = mainDAOImpl;
	}

	
	// 구매후기 페이지 이동
	@GetMapping("review.mcat")
	public ModelAndView getReviewCmd(ModelAndView mv) {
		mv.setViewName("member/review");
		return mv;
	}
	
	// 마이페이지 이동
	@GetMapping("mypage.mcat")
	public ModelAndView getMyPageCmd(ModelAndView mv) {
		mv.setViewName("member/mypage");
		return mv;
	}
	
	// 마이페이지 - 주문내역관리 이동
	@GetMapping("mypage_order_inquiry.mcat")
	public ModelAndView getOrderInquiryCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_order_inquiry");
		return mv;
	}
	
	// 마이페이지 - 프로필 관리 이동	
	
	// 마이페이지 - 찜목록 관리 이동
	@GetMapping("mypage_wishlist.mcat")
	public ModelAndView getWishListCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_wishlist");
		return mv;
	}
	
	// 마이페이지 - 마일리지 이동
	
	// 마이페이지 - 게시물 관리 페이지 이동
	@GetMapping("mypage_post_management.mcat")
	public ModelAndView getPostManageCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_post_management");
		return mv;
	}
	
	// 마이페이지 - 배송주소록 관리 이동
	@GetMapping("mypage_deliveryAdress.mcat")
	public ModelAndView getDeliveryAdressCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_deliveryAdress");
		return mv;
	}
	
}