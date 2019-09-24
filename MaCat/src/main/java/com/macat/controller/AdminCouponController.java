package com.macat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.AdminCouponManagementDAO;
import com.macat.dto.CouponDTO;
import com.macat.dto.CouponSearchDTO;
import com.macat.dto.DateDTO;
import com.macat.dto.PageDTO;
import com.macat.util.DateCalculateUtil;
import com.macat.util.PagingUtil;

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
	
	// 쿠폰 정보 조회로 이동
	@GetMapping("coupon_manage.mcat")
	public ModelAndView redirectCouponManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/coupon/manager");
		
		this.cPage = cPage;
		usedDTO = "CouponDTO";

		DateDTO dateDTO = new DateDTO();
		dateDTO.setToday(DateCalculateUtil.getToday());
		dateDTO.setOneWeekAgo(DateCalculateUtil.addDate(-7));
		dateDTO.setOneMonthAgo(DateCalculateUtil.addMonth(-1));
		dateDTO.setThreeMonthAgo(DateCalculateUtil.addMonth(-3));
		dateDTO.setSixMonthAgo(DateCalculateUtil.addMonth(-6));
		dateDTO.setOneYearAgo(DateCalculateUtil.addYear(-1));
		
		PageDTO pageDTO = new PageDTO(20);
		count = adminCouponManagementDAO.getAdminCount();
		PagingUtil.getPage(pageDTO, count, cPage);
		mv.addObject("coupons_count", count);

		mv.addObject("dateDTO", dateDTO);
		mv.addObject("couoponDTO", adminCouponManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}	

	// 쿠폰 정보 페이징
	@PostMapping("coupon_paging.mcat")
	@ResponseBody
	public Map<String, Object> getCouponPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(20);

		Map<String, Object> map = new HashMap<String, Object>();

		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);
		map.put("coupons_count", count);		

		switch (usedDTO) {
		case "CouponDTO":
			map.put("couponDTO", adminCouponManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			couponSearchDTO.setBegin(pageDTO.getBegin());
			couponSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "CouponSearchDTO_and":
				map.put("couponDTO", adminCouponManagementDAO.getAndSearch(couponSearchDTO));
				break;
			case "CouponSearchDTO_or":
				map.put("couponDTO", adminCouponManagementDAO.getOrSearch(couponSearchDTO));
				break;
			}
		}

		return map;
	}	
	
	// 회원 검색
	@PostMapping("coupon_search.mcat")
	@ResponseBody
	public Map<String, Object> getCouponSearchCmd(@RequestBody CouponSearchDTO couponSearchDTO) {

		if (couponSearchDTO.getCpon_reg_dt_start() != null)
			couponSearchDTO.setCpon_reg_dt_start(couponSearchDTO.getCpon_reg_dt_start() + " 00:00:00");
		if (couponSearchDTO.getCpon_reg_dt_end() != null)
			couponSearchDTO.setCpon_reg_dt_end(couponSearchDTO.getCpon_reg_dt_end() + " 23:59:59");
		if (couponSearchDTO.getCpon_exp_dt_start() != null)
			couponSearchDTO.setCpon_exp_dt_start(couponSearchDTO.getCpon_exp_dt_start() + " 00:00:00");
		if (couponSearchDTO.getCpon_exp_dt_end() != null)
			couponSearchDTO.setCpon_exp_dt_end(couponSearchDTO.getCpon_exp_dt_end() + " 23:59:59");		

		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO(20);

		switch (couponSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "CouponSearchDTO_and";
			count = adminCouponManagementDAO.getAndCount(couponSearchDTO);
			break;
		case "or":
			usedDTO = "CouponSearchDTO_or";
			count = adminCouponManagementDAO.getOrCount(couponSearchDTO);
			break;
		}

		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);

		map.put("coupons_count", count);

		couponSearchDTO.setBegin(pageDTO.getBegin());
		couponSearchDTO.setEnd(pageDTO.getEnd());
		this.couponSearchDTO = couponSearchDTO; // 페이징을 위한 검색 기록 저장
		
		switch (couponSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("couponDTO", adminCouponManagementDAO.getAndSearch(couponSearchDTO));
			break;
		case "or":
			map.put("couponDTO", adminCouponManagementDAO.getOrSearch(couponSearchDTO));
			break;
		}
		return map;
	}
	
	// 쿠폰정보 수정
	@PostMapping("coupon_update.mcat")
	@ResponseBody
	public Map<String, Object> getCouponUpdateCmd(@RequestBody Map<String, List<CouponDTO>> coupon) {
		for (String i : coupon.keySet()) {
			for (CouponDTO j : coupon.get(i)) {
				adminCouponManagementDAO.updateCoupon(j);
			}
		}
		return getCouponPagingCmd(cPage);
	}
	
	// 쿠폰 삭제
	@PostMapping("coupon_delete.mcat")
	@ResponseBody
	public Map<String, Object> getCouponDeleteCmd(@RequestBody Map<String, List<String>> coupon) {
		for (String i : coupon.keySet()) {
			for (String j : coupon.get(i)) {
				adminCouponManagementDAO.deleteAdmin(j);
			}
		}

		switch (usedDTO) {
		case "CouponDTO":
			count = adminCouponManagementDAO.getAdminCount();
			break;
		case "CouponSearchDTO_and":
			count = adminCouponManagementDAO.getAndCount(couponSearchDTO);
			break;
		case "CouponSearchDTO_or":
			count = adminCouponManagementDAO.getOrCount(couponSearchDTO);
			break;
		}

		return getCouponPagingCmd(cPage);
	}
	
}
