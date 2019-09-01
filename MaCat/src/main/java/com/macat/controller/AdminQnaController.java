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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;
import com.macat.dto.PageDTO;
import com.macat.dto.QnaDTO;
import com.macat.dto.QnaSearchDTO;
import com.macat.service.Paging;

@Controller
@RequestMapping("admin/qna/*.mcat")
public class AdminQnaController extends Paging {

	@Autowired
	private DAO dao;
	
	// 고객 문의 관리로 이동
	@GetMapping("manager.mcat")
	public ModelAndView getQnaCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "QnaDTO";
		// ModelAndView mv = new ModelAndView("admin/qna/management");
		ModelAndView mv = new ModelAndView("admin/qna/customer_manager");
		PageDTO pageDTO = new PageDTO();
		count = dao.getQnaCount();
		setPage(pageDTO, count, cPage);
		mv.addObject("qna_ctgries", dao.getQnaCtgriesList());
		mv.addObject("qnaDTO", dao.getQnaList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}

	// 고객 문의 페이징
	@PostMapping("paging.mcat")
	@ResponseBody
	public Map<String, Object> getQnaPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO();
		Map<String, Object> map = new HashMap<String, Object>();

		setPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		switch (usedDTO) {
		case "QnaDTO":
			map.put("qnaDTO", dao.getQnaList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			qnaSearchDTO.setBegin(pageDTO.getBegin());
			qnaSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "QnaSearchDTO_and":
				map.put("qnaDTO", dao.getQnaAndSearch(qnaSearchDTO));
				break;
			case "QnaSearchDTO_or":
				map.put("qnaDTO", dao.getQnaOrSearch(qnaSearchDTO));
				break;
			}
		}

		return map;
	}

	// 고객 문의 검색
	@PostMapping("search.mcat")
	@ResponseBody
	public Map<String, Object> getQnaSearchCmd(@RequestBody QnaSearchDTO qnaSearchDTO) {

		if (qnaSearchDTO.getQna_reg_dt_start() != null)
			qnaSearchDTO.setQna_reg_dt_start(qnaSearchDTO.getQna_reg_dt_start() + " 00:00:00");
		if (qnaSearchDTO.getQna_reg_dt_end() != null)
			qnaSearchDTO.setQna_reg_dt_end(qnaSearchDTO.getQna_reg_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO();

		switch (qnaSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "QnaSearchDTO_and";
			count = dao.getQnaAndCount(qnaSearchDTO);
			break;
		case "or":
			usedDTO = "QnaSearchDTO_or";
			count = dao.getQnaOrCount(qnaSearchDTO);
			break;
		}

		setPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		qnaSearchDTO.setBegin(pageDTO.getBegin());
		qnaSearchDTO.setEnd(pageDTO.getEnd());
		this.qnaSearchDTO = qnaSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (qnaSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("qnaDTO", dao.getQnaAndSearch(qnaSearchDTO));
			break;
		case "or":
			map.put("qnaDTO", dao.getQnaOrSearch(qnaSearchDTO));
			break;
		}

		return map;
	}

	// 고객 문의 삭제
	@PostMapping("delete.mcat")
	@ResponseBody
	public Map<String, Object> getQnaDeleteCmd(@RequestBody Map<String, List<String>> qnas) {
		for (String i : qnas.keySet()) {
			for (String j : qnas.get(i)) {
				dao.getQnaDelete(j);
			}
		}

		switch (usedDTO) {
		case "QnaDTO":
			count = dao.getQnaCount();
			break;
		case "QnaSearchDTO_and":
			count = dao.getQnaAndCount(qnaSearchDTO);
			break;
		case "QnaSearchDTO_or":
			count = dao.getQnaOrCount(qnaSearchDTO);
			break;
		}

		return getQnaPagingCmd(cPage);
	}

	// 문의 보기로 이동
	@GetMapping("view.mcat")
	public ModelAndView getQnaViewCmd(HttpSession session, String qna_sq) {
		QnaDTO qnaDTO = dao.getQnaView(qna_sq);

		qnaDTO.setQna_view_cnt(qnaDTO.getQna_view_cnt() + 1);
		dao.getQnaRdcntUpdate(qnaDTO);

		session.setAttribute("qnaDTO", qnaDTO);

		return new ModelAndView("admin/qna/view");
	}

}
