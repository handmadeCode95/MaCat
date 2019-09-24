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

import com.macat.dao.AdminQnaManagementDAO;
import com.macat.dao.MainDAOImpl;
import com.macat.dto.PageDTO;
import com.macat.dto.QnaDTO;
import com.macat.dto.QnaSearchDTO;
import com.macat.util.PagingUtil;

@Controller
public class AdminQnaController {
	
	private final AdminQnaManagementDAO adminQnaManagementDAO;
	private final MainDAOImpl mainDAOImpl;

	@Autowired
	public AdminQnaController(AdminQnaManagementDAO adminQnaManagementDAO, MainDAOImpl mainDAOImpl) {
		this.adminQnaManagementDAO = adminQnaManagementDAO;
		this.mainDAOImpl = mainDAOImpl;
	}
	
	private QnaSearchDTO qnaSearchDTO;
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	
	
	// 고객 문의 관리로 이동
	@GetMapping("qna_manage.mcat")
	public ModelAndView redirectQnaManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/qna/manager");
		
		this.cPage = cPage;
		usedDTO = "QnaDTO";
		
		PageDTO pageDTO = new PageDTO();
		count = adminQnaManagementDAO.getAdminCount();
		PagingUtil.getPage(pageDTO, count, cPage);
		mv.addObject("qna_ctgries", mainDAOImpl.getQnaCategories());
		mv.addObject("qnaDTO", adminQnaManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	
	// 고객 문의 페이징
	@PostMapping("qna_paging.mcat")
	@ResponseBody
	public Map<String, Object> getQnaPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(30);
		Map<String, Object> map = new HashMap<String, Object>();

		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		switch (usedDTO) {
		case "QnaDTO":
			map.put("qnaDTO", adminQnaManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			qnaSearchDTO.setBegin(pageDTO.getBegin());
			qnaSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "QnaSearchDTO_and":
				map.put("qnaDTO", adminQnaManagementDAO.getAndSearch(qnaSearchDTO));
				break;
			case "QnaSearchDTO_or":
				map.put("qnaDTO", adminQnaManagementDAO.getOrSearch(qnaSearchDTO));
				break;
			}
		}

		return map;
	}

	// 고객 문의 검색
	@PostMapping("qna_search.mcat")
	@ResponseBody
	public Map<String, Object> getQnaSearchCmd(@RequestBody QnaSearchDTO qnaSearchDTO) {

		if (qnaSearchDTO.getQna_reg_dt_start() != null)
			qnaSearchDTO.setQna_reg_dt_start(qnaSearchDTO.getQna_reg_dt_start() + " 00:00:00");
		if (qnaSearchDTO.getQna_reg_dt_end() != null)
			qnaSearchDTO.setQna_reg_dt_end(qnaSearchDTO.getQna_reg_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO(30);

		switch (qnaSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "QnaSearchDTO_and";
			count = adminQnaManagementDAO.getAndCount(qnaSearchDTO);
			break;
		case "or":
			usedDTO = "QnaSearchDTO_or";
			count = adminQnaManagementDAO.getOrCount(qnaSearchDTO);
			break;
		}

		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		qnaSearchDTO.setBegin(pageDTO.getBegin());
		qnaSearchDTO.setEnd(pageDTO.getEnd());
		this.qnaSearchDTO = qnaSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (qnaSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("qnaDTO", adminQnaManagementDAO.getAndSearch(qnaSearchDTO));
			break;
		case "or":
			map.put("qnaDTO", adminQnaManagementDAO.getOrSearch(qnaSearchDTO));
			break;
		}

		return map;
	}

	// 고객 문의 삭제
	@PostMapping("qna_delete.mcat")
	@ResponseBody
	public Map<String, Object> getQnaDeleteCmd(@RequestBody Map<String, List<String>> qnas) {
		for (String i : qnas.keySet()) {
			for (String j : qnas.get(i)) {
				adminQnaManagementDAO.deleteAdmin(j);
			}
		}

		switch (usedDTO) {
		case "QnaDTO":
			count = adminQnaManagementDAO.getAdminCount();
			break;
		case "QnaSearchDTO_and":
			count = adminQnaManagementDAO.getAndCount(qnaSearchDTO);
			break;
		case "QnaSearchDTO_or":
			count = adminQnaManagementDAO.getOrCount(qnaSearchDTO);
			break;
		}

		return getQnaPagingCmd(cPage);
	}

	// 문의 보기로 이동
	@GetMapping("qna_view.mcat")
	public ModelAndView getQnaViewCmd(ModelAndView mv, HttpSession session, String qna_sq) {
		mv.setViewName("admin/qna/view");
		
		QnaDTO qnaDTO = (QnaDTO)adminQnaManagementDAO.getPostView(qna_sq);

		qnaDTO.setQna_view_cnt(qnaDTO.getQna_view_cnt() + 1);
		adminQnaManagementDAO.updateQnaViewCount(qnaDTO);

		session.setAttribute("qnaDTO", qnaDTO);

		return mv;
	}
	
	// 업데이트 작업 필요 190911

}
