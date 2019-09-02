package com.macat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.service.Paging;

@Controller
@RequestMapping("/admin/notices")
public class AdminNoticesController extends Paging {
	
	@Autowired
	private DAO dao;
	public DAO getDao() {return dao;}
	public void setDao(DAO dao) {this.dao = dao;}
	
	// 공지사항 조회로 이동
	@GetMapping("/manager.mcat")
	public ModelAndView getNoticesCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "NotsDTO";
		ModelAndView mv = new ModelAndView("admin/notices/management");
		PageDTO pageDTO = new PageDTO();
		count = dao.getNotsCount();
		setPage(pageDTO, count, cPage);
		mv.addObject("notsDTO", dao.getNotsList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// 공지사항 페이징
	@PostMapping("/paging.mcat")
	@ResponseBody
	public Map<String, Object> getNotsPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO();
		Map<String, Object> map = new HashMap<String, Object>();

		setPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		switch (usedDTO) {
		case "NotsDTO":
			map.put("notsDTO", dao.getNotsList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			notsSearchDTO.setBegin(pageDTO.getBegin());
			notsSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "NotsSearchDTO_and":
				map.put("notsDTO", dao.getNotsAndSearch(notsSearchDTO));
				break;
			case "NotsSearchDTO_or":
				map.put("notsDTO", dao.getNotsOrSearch(notsSearchDTO));
				break;
			}
		}

		return map;
	}

	// 공지사항 검색
	@PostMapping("/search.mcat")
	@ResponseBody
	public Map<String, Object> getNotsSearchCmd(@RequestBody NotsSearchDTO notsSearchDTO) {

		if (notsSearchDTO.getNot_reg_dt_start() != null)
			notsSearchDTO.setNot_reg_dt_start(notsSearchDTO.getNot_reg_dt_start() + " 00:00:00");
		if (notsSearchDTO.getNot_reg_dt_end() != null)
			notsSearchDTO.setNot_reg_dt_end(notsSearchDTO.getNot_reg_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO();

		switch (notsSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "NotsSearchDTO_and";
			count = dao.getNotsAndCount(notsSearchDTO);
			break;
		case "or":
			usedDTO = "NotsSearchDTO_or";
			count = dao.getNotsOrCount(notsSearchDTO);
			break;
		}

		setPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		notsSearchDTO.setBegin(pageDTO.getBegin());
		notsSearchDTO.setEnd(pageDTO.getEnd());
		this.notsSearchDTO = notsSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (notsSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("notsDTO", dao.getNotsAndSearch(notsSearchDTO));
			break;
		case "or":
			map.put("notsDTO", dao.getNotsOrSearch(notsSearchDTO));
			break;
		}

		return map;
	}

	// 공지사항 작성으로 이동
	@GetMapping("/write.mcat")
	public ModelAndView getNotsWriteGoCmd() {
		return new ModelAndView("admin/notices/write");
	}

	// 공지사항 수정으로 이동
	@GetMapping("/update.mcat")
	public ModelAndView getNotsUpdateGoCmd() {
		return new ModelAndView("admin/notices/update");
	}

	// 공지사항 삭제
	@PostMapping("/delete.mcat")
	@ResponseBody
	public Map<String, Object> getNotsDeleteCmd(@RequestBody Map<String, List<String>> nots) {
		for (String i : nots.keySet()) {
			for (String j : nots.get(i)) {
				dao.getNotsDelete(j);
			}
		}

		switch (usedDTO) {
		case "NotsDTO":
			count = dao.getNotsCount();
			break;
		case "NotsSearchDTO_and":
			count = dao.getNotsAndCount(notsSearchDTO);
			break;
		case "NotsSearchDTO_or":
			count = dao.getNotsOrCount(notsSearchDTO);
			break;
		}

		return getNotsPagingCmd(cPage);
	}

}
