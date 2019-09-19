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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.AdminNoticeManagementDAO;
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.util.PagingUtil;

@Controller
public class AdminNoticesController {
	
	private final AdminNoticeManagementDAO adminNoticeManagementDAO;

	@Autowired
	public AdminNoticesController(AdminNoticeManagementDAO adminNoticeManagementDAO) {
		this.adminNoticeManagementDAO = adminNoticeManagementDAO;
	}
	
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	private NotsSearchDTO notsSearchDTO; // 페이징을 위한 회원 정보 검색 기록	
	
	// 공지사항 조회로 이동
	@GetMapping("nots_manage.mcat")
	public ModelAndView redirectNoticesManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/notices/manager");
		
		this.cPage = cPage;
		usedDTO = "NotsDTO";
		
		PageDTO pageDTO = new PageDTO(50);
		count = adminNoticeManagementDAO.getAdminCount();
		PagingUtil.getPage(pageDTO, count, cPage);		
		mv.addObject("nots_count", count);
		
		mv.addObject("notsDTO", adminNoticeManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		
		return mv;
	}
	
	// 공지사항 페이징
	@PostMapping("nots_paging.mcat")
	@ResponseBody
	public Map<String, Object> getNotsPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(50);
		
		Map<String, Object> map = new HashMap<String, Object>();

		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);
		map.put("nots_count", count);
		
		switch (usedDTO) {
		case "NotsDTO":
			map.put("notsDTO", adminNoticeManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			notsSearchDTO.setBegin(pageDTO.getBegin());
			notsSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "NotsSearchDTO_and":
				map.put("notsDTO", adminNoticeManagementDAO.getAndSearch(notsSearchDTO));
				break;
			case "NotsSearchDTO_or":
				map.put("notsDTO", adminNoticeManagementDAO.getOrSearch(notsSearchDTO));
				break;
			}
		}

		return map;
	}

	// 공지사항 검색
	@PostMapping("nots_search.mcat")
	@ResponseBody
	public Map<String, Object> getNotsSearchCmd(@RequestBody NotsSearchDTO notsSearchDTO) {

		if (notsSearchDTO.getNot_reg_dt_start() != null)
			notsSearchDTO.setNot_reg_dt_start(notsSearchDTO.getNot_reg_dt_start() + " 00:00:00");
		if (notsSearchDTO.getNot_reg_dt_end() != null)
			notsSearchDTO.setNot_reg_dt_end(notsSearchDTO.getNot_reg_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO(50);

		switch (notsSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "NotsSearchDTO_and";
			count = adminNoticeManagementDAO.getAndCount(notsSearchDTO);
			break;
		case "or":
			usedDTO = "NotsSearchDTO_or";
			count = adminNoticeManagementDAO.getOrCount(notsSearchDTO);
			break;
		}

		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		
		notsSearchDTO.setBegin(pageDTO.getBegin());
		notsSearchDTO.setEnd(pageDTO.getEnd());
		this.notsSearchDTO = notsSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (notsSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("notsDTO", adminNoticeManagementDAO.getAndSearch(notsSearchDTO));
			break;
		case "or":
			map.put("notsDTO", adminNoticeManagementDAO.getOrSearch(notsSearchDTO));
			break;
		}

		return map;
	}

	// 공지사항 작성으로 이동
	@GetMapping("nots_write.mcat")
	public ModelAndView getNotsWriteGoCmd(ModelAndView mv) {
		mv.setViewName("admin/notices/write");
		return mv;
	}

	// 페이지이동, 관리자 페이지 내부 수정 추가 필요
	// 공지사항 수정으로 이동
	@GetMapping("nots_update.mcat")
	public ModelAndView getNotsUpdateGoCmd(ModelAndView mv) {
		mv.setViewName("admin/notices/update");
		return mv;
	}

	// 공지사항 삭제
	@PostMapping("nots_delete.mcat")
	@ResponseBody
	public Map<String, Object> getNotsDeleteCmd(@RequestBody Map<String, List<String>> nots) {
		for (String i : nots.keySet()) {
			for (String j : nots.get(i)) {
				adminNoticeManagementDAO.deleteAdmin(j);
			}
		}

		switch (usedDTO) {
		case "NotsDTO":
			count = adminNoticeManagementDAO.getAdminCount();
			break;
		case "NotsSearchDTO_and":
			count = adminNoticeManagementDAO.getAndCount(notsSearchDTO);
			break;
		case "NotsSearchDTO_or":
			count = adminNoticeManagementDAO.getOrCount(notsSearchDTO);
			break;
		}

		return getNotsPagingCmd(cPage);
	}

}
