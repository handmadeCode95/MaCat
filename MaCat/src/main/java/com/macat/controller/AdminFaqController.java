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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;
import com.macat.dto.FaqDTO;
import com.macat.dto.FaqSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.service.Paging;

@Controller
@RequestMapping("admin/faq/*.mcat")
public class AdminFaqController extends Paging {
	
	@Autowired
	private DAO dao;
	
	// FAQ 관리로 이동
	@GetMapping("manager.mcat")
	public ModelAndView getFaqCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "FaqDTO";
		ModelAndView mv = new ModelAndView("admin/faq/management");
		PageDTO pageDTO = new PageDTO();
		count = dao.getFaqCount();
		setPage(pageDTO, count, cPage);
		mv.addObject("qna_ctgries", dao.getQnaCtgriesList());
		mv.addObject("faqDTO", dao.getFaqList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// FAQ 페이징
	@PostMapping("paging.mcat")
	@ResponseBody
	public Map<String, Object> getFaqPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO();
		Map<String, Object> map = new HashMap<String, Object>();

		Paging.setPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		switch (usedDTO) {
		case "FaqDTO":
			map.put("faqDTO", dao.getFaqList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			faqSearchDTO.setBegin(pageDTO.getBegin());
			faqSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "FaqSearchDTO_and":
				map.put("faqDTO", dao.getFaqAndSearch(faqSearchDTO));
				break;
			case "FaqSearchDTO_or":
				map.put("faqDTO", dao.getFaqOrSearch(faqSearchDTO));
				break;
			}
		}

		return map;
	}

	// FAQ 검색
	@PostMapping("search.mcat")
	@ResponseBody
	public Map<String, Object> getFaqSearchCmd(@RequestBody FaqSearchDTO faqSearchDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO();

		switch (faqSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "FaqSearchDTO_and";
			count = dao.getFaqAndCount(faqSearchDTO);
			break;
		case "or":
			usedDTO = "FaqSearchDTO_or";
			count = dao.getFaqOrCount(faqSearchDTO);
			break;
		}

		Paging.setPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		faqSearchDTO.setBegin(pageDTO.getBegin());
		faqSearchDTO.setEnd(pageDTO.getEnd());
		this.faqSearchDTO = faqSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (faqSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("faqDTO", dao.getFaqAndSearch(faqSearchDTO));
			break;
		case "or":
			map.put("faqDTO", dao.getFaqOrSearch(faqSearchDTO));
			break;
		}

		return map;
	}

	// FAQ 삭제
	@PostMapping("delete.mcat")
	@ResponseBody
	public Map<String, Object> getFaqDeleteCmd(@RequestBody Map<String, List<String>> faqs) {
		for (String i : faqs.keySet()) {
			for (String j : faqs.get(i)) {
				dao.getFaqDelete(j);
			}
		}

		switch (usedDTO) {
		case "FaqDTO":
			count = dao.getFaqCount();
			break;
		case "FaqSearchDTO_and":
			count = dao.getFaqAndCount(faqSearchDTO);
			break;
		case "FaqSearchDTO_or":
			count = dao.getFaqOrCount(faqSearchDTO);
			break;
		}

		return getFaqPagingCmd(cPage);
	}

	// FAQ 보기로 이동
	@GetMapping("view.mcat")
	public ModelAndView getFaqViewCmd(HttpSession session, String faq_sq) {
		FaqDTO faqDTO = dao.getFaqView(faq_sq);

		session.setAttribute("faqDTO", faqDTO);

		return new ModelAndView("admin/faq/view");
	}

}
