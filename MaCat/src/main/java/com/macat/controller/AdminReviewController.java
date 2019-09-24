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

import com.macat.dao.AdminReviewManagementDAO;
import com.macat.dto.DateDTO;
import com.macat.dto.PageDTO;
import com.macat.dto.ProductsSearchDTO;
import com.macat.dto.ReviewSearchDTO;
import com.macat.util.DateCalculateUtil;
import com.macat.util.PagingUtil;

@Controller
public class AdminReviewController {
	
	private final AdminReviewManagementDAO adminReviewManagementDAO;
	
	@Autowired
	public AdminReviewController(AdminReviewManagementDAO adminReviewManagementDAO) {
		this.adminReviewManagementDAO = adminReviewManagementDAO;
	}
	
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	private ReviewSearchDTO reviewSearchDTO; // 페이징을 위한 회원 정보 검색 기록
	
	// 리뷰 정보 조회로 이동
	@GetMapping("reviews_manage.mcat")
	public ModelAndView redirectReviewManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/reviews/review_manager");
		
		this.cPage = cPage;
		usedDTO = "ReviewDTO";

		DateDTO dateDTO = new DateDTO();
		dateDTO.setToday(DateCalculateUtil.getToday());
		dateDTO.setOneWeekAgo(DateCalculateUtil.addDate(-7));
		dateDTO.setOneMonthAgo(DateCalculateUtil.addMonth(-1));
		dateDTO.setThreeMonthAgo(DateCalculateUtil.addMonth(-3));
		dateDTO.setSixMonthAgo(DateCalculateUtil.addMonth(-6));
		dateDTO.setOneYearAgo(DateCalculateUtil.addYear(-1));
		
		PageDTO pageDTO = new PageDTO(50);
		count = adminReviewManagementDAO.getAdminCount();
		PagingUtil.getPage(pageDTO, count, cPage);
		mv.addObject("review_count", count);

		mv.addObject("dateDTO", dateDTO);
		mv.addObject("reviewDTO", adminReviewManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// 리뷰 정보 페이징
	@PostMapping("reviews_paging.mcat")
	@ResponseBody
	public Map<String, Object> getReviewPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(50);

		Map<String, Object> map = new HashMap<String, Object>();

		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);
		map.put("review_count", count);			

		switch (usedDTO) {
		case "ReviewDTO":
			map.put("reviewDTO", adminReviewManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			reviewSearchDTO.setBegin(pageDTO.getBegin());
			reviewSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "ReviewSearchDTO_and":
				map.put("reviewDTO", adminReviewManagementDAO.getAndSearch(reviewSearchDTO));
				break;
			case "ReviewSearchDTO_or":
				map.put("reviewDTO", adminReviewManagementDAO.getOrSearch(reviewSearchDTO));
				break;
			}
		}
		return map;
	}
	
	// 리뷰 검색
	@PostMapping("reviews_search.mcat")
	@ResponseBody
	public Map<String, Object> getReviewSearchCmd(@RequestBody ReviewSearchDTO reviewSearchDTO){
		
		if(reviewSearchDTO.getRe_reg_dt_start() != null)
			reviewSearchDTO.setRe_reg_dt_start(reviewSearchDTO.getRe_reg_dt_start() + " 00:00:00");
		if(reviewSearchDTO.getRe_reg_dt_end() != null)
			reviewSearchDTO.setRe_reg_dt_end(reviewSearchDTO.getRe_reg_dt_end() + " 23:59:59");
		
		Map<String, Object> map = new HashMap<String, Object>();

		PageDTO pageDTO = new PageDTO(50);
		
		switch(reviewSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "ReviewSearchDTO_and";
			count = adminReviewManagementDAO.getAndCount(reviewSearchDTO);
			break;
		case "or":
			usedDTO = "ReviewSearchDTO_or";
			count = adminReviewManagementDAO.getOrCount(reviewSearchDTO);
			break;
		}
		
		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		
		reviewSearchDTO.setBegin(pageDTO.getBegin());
		reviewSearchDTO.setEnd(pageDTO.getEnd());
		this.reviewSearchDTO = reviewSearchDTO; // 페이징용 검색기록 저장
		
		switch(reviewSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("reviewDTO", adminReviewManagementDAO.getAndSearch(reviewSearchDTO));
			break;
		case "or":
			map.put("reviewDTO", adminReviewManagementDAO.getOrSearch(reviewSearchDTO));
			break;
		}		
		return map;
	}
	
	// 리뷰정보수정 (페이지 이동)
	@GetMapping("reviews_update_page.mcat")
	public ModelAndView getReviewUpdatePageCmd(ModelAndView mv, String re_sq) {
		mv.setViewName("admin/reviews/update");
		mv.addObject("reviewDTO", adminReviewManagementDAO.getReview(re_sq));
		mv.addObject("url", "reviews_update_page");
		return mv;
	}
	
	// 리뷰 삭제
	@PostMapping("reviews_delete.mcat")
	@ResponseBody
	public Map<String, Object> getReviewDeleteCmd(@RequestBody Map<String, List<String>> review){
		for (String i : review.keySet()) {
			for (String j : review.get(i)) {
				adminReviewManagementDAO.deleteAdmin(j);
			}
		}
		
		switch (usedDTO) {
		case "ReviewDTO":
			count = adminReviewManagementDAO.getAdminCount();
			break;
		case "ReviewDTO_and":
			count = adminReviewManagementDAO.getAndCount(reviewSearchDTO);
			break;
		case "ReviewDTO_or":
			count = adminReviewManagementDAO.getOrCount(reviewSearchDTO);
			break;
		}
		
		return getReviewPagingCmd(cPage);		
	}

}