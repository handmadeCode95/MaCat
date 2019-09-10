package com.macat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.AdminFaqManagementDAO;
import com.macat.dao.MainDAOImpl;
import com.macat.dto.FaqSearchDTO;
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.dto.QnaSearchDTO;
import com.macat.util.PagingUtil;

@Controller
public class AdminFaqController {
	
	private final AdminFaqManagementDAO adminFaqManagementDAO;
	private final MainDAOImpl mainDAOImpl;

	@Autowired
	public AdminFaqController(AdminFaqManagementDAO adminFaqManagementDAO, MainDAOImpl mainDAOImpl) {
		this.adminFaqManagementDAO = adminFaqManagementDAO;
		this.mainDAOImpl = mainDAOImpl;
	}

	// 페이징을 위한 회원 정보 검색 기록
	private NotsSearchDTO notsSearchDTO;
	private QnaSearchDTO qnaSearchDTO;
	private FaqSearchDTO faqSearchDTO;

	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	
	
	// FAQ 관리로 이동
	@GetMapping("faq_manage.mcat")
	public ModelAndView redirectFaqManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/faq/manager");
		
		this.cPage = cPage;
		usedDTO = "FaqDTO";
		
		PageDTO pageDTO = new PageDTO();
		count = adminFaqManagementDAO.getAdminCount();
		PagingUtil.getPage(pageDTO, count, cPage);
		mv.addObject("qna_ctgries", mainDAOImpl.getQnaCategories());
		mv.addObject("faqDTO", adminFaqManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// FAQ 페이징
	@PostMapping("faq_paging.mcat")
	@ResponseBody
	public Map<String, Object> getFaqPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO();
		Map<String, Object> map = new HashMap<String, Object>();

		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		switch (usedDTO) {
		case "FaqDTO":
			map.put("faqDTO", adminFaqManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			faqSearchDTO.setBegin(pageDTO.getBegin());
			faqSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "FaqSearchDTO_and":
				map.put("faqDTO", adminFaqManagementDAO.getAndSearch(faqSearchDTO));
				break;
			case "FaqSearchDTO_or":
				map.put("faqDTO", adminFaqManagementDAO.getOrSearch(faqSearchDTO));
				break;
			}
		}

		return map;
	}

	// FAQ 검색
	@PostMapping("faq_search.mcat")
	@ResponseBody
	public Map<String, Object> getFaqSearchCmd(@RequestBody FaqSearchDTO faqSearchDTO) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO();

		switch (faqSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "FaqSearchDTO_and";
			count = adminFaqManagementDAO.getAndCount(faqSearchDTO);
			break;
		case "or":
			usedDTO = "FaqSearchDTO_or";
			count = adminFaqManagementDAO.getOrCount(faqSearchDTO);
			break;
		}

		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		faqSearchDTO.setBegin(pageDTO.getBegin());
		faqSearchDTO.setEnd(pageDTO.getEnd());
		this.faqSearchDTO = faqSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (faqSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("faqDTO", adminFaqManagementDAO.getAndSearch(faqSearchDTO));
			break;
		case "or":
			map.put("faqDTO", adminFaqManagementDAO.getOrSearch(faqSearchDTO));
			break;
		}
		
		return map;
	}
	
	// FAQ 삭제
	@PostMapping("faq_delete.mcat")
	@ResponseBody
	public Map<String, Object> getFaqDeleteCmd(@RequestBody Map<String, List<String>> faqs) {
		for (String i : faqs.keySet()) {
			for (String j : faqs.get(i)) {
				adminFaqManagementDAO.deleteAdmin(j);
			}
		}

		switch (usedDTO) {
		case "FaqDTO":
			count = adminFaqManagementDAO.getAdminCount();
			break;
		case "FaqSearchDTO_and":
			count = adminFaqManagementDAO.getAndCount(faqSearchDTO);
			break;
		case "FaqSearchDTO_or":
			count = adminFaqManagementDAO.getOrCount(faqSearchDTO);
			break;
		}

		return getFaqPagingCmd(cPage);
	}

//	// FAQ 보기로 이동
//	@GetMapping("faq_view.mcat")
//	public ModelAndView getFaqViewCmd(ModelAndView mv, HttpSession session, String faq_sq) {
//		mv.setViewName("admin/faq/view");
//		session.setAttribute("faqDTO", adminFaqManagementDAO.getPostView(faq_sq));
//		return mv;
//	}

}
