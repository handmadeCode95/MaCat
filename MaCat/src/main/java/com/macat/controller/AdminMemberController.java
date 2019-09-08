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

import com.macat.dao.AdminMemberManagementDAO;
import com.macat.dto.DateDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.MbersSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.util.DateCalculateUtil;
import com.macat.util.PagingUtil;

@Controller
public class AdminMemberController {
	
	private final AdminMemberManagementDAO adminMemberManagementDAO;

	@Autowired
	public AdminMemberController(AdminMemberManagementDAO adminMemberManagementDAO) {
		this.adminMemberManagementDAO = adminMemberManagementDAO;
	}
	
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	private MbersSearchDTO mbersSearchDTO; // 페이징을 위한 회원 정보 검색 기록
	
	
	// 회원 정보 조회로 이동
	@GetMapping("mbers_manager.mcat")
	public ModelAndView redirectMembersManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/members/manager");
		
		this.cPage = cPage;
		usedDTO = "MbersDTO";

		DateDTO dateDTO = new DateDTO();
		dateDTO.setToday(DateCalculateUtil.getToday());
		dateDTO.setOneWeekAgo(DateCalculateUtil.addDate(-7));
		dateDTO.setOneMonthAgo(DateCalculateUtil.addMonth(-1));
		dateDTO.setThreeMonthAgo(DateCalculateUtil.addMonth(-3));
		dateDTO.setSixMonthAgo(DateCalculateUtil.addMonth(-6));
		dateDTO.setOneYearAgo(DateCalculateUtil.addYear(-1));
		
		PageDTO pageDTO = new PageDTO(50);
		count = adminMemberManagementDAO.getAdminCount();
		PagingUtil.getPage(pageDTO, count, cPage);
		mv.addObject("mbers_count", count);

		mv.addObject("dateDTO", dateDTO);
		mv.addObject("mber_grad", adminMemberManagementDAO.getMemberGradeList());
		mv.addObject("mbersDTO", adminMemberManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// 회원 정보 페이징
	@PostMapping("mbers_paging.mcat")
	@ResponseBody
	public Map<String, Object> getMbersPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(50);

		Map<String, Object> map = new HashMap<String, Object>();

		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		map.put("mbers_count", count);

		
		map.put("mber_grad", adminMemberManagementDAO.getMemberGradeList());

		switch (usedDTO) {
		case "MbersDTO":
			map.put("mbersDTO", adminMemberManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			mbersSearchDTO.setBegin(pageDTO.getBegin());
			mbersSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "MbersSearchDTO_and":
				map.put("mbersDTO", adminMemberManagementDAO.getAndSearch(mbersSearchDTO));
				break;
			case "MbersSearchDTO_or":
				map.put("mbersDTO", adminMemberManagementDAO.getOrSearch(mbersSearchDTO));
				break;
			}
		}

		return map;
	}

	// 회원 검색
	@PostMapping("mbers_search.mcat")
	@ResponseBody
	public Map<String, Object> getMbersSearchCmd(@RequestBody MbersSearchDTO mbersSearchDTO) {

		if (mbersSearchDTO.getMber_birthday_dt_start() != null)
			mbersSearchDTO.setMber_birthday_dt_start(mbersSearchDTO.getMber_birthday_dt_start() + " 00:00:00");
		if (mbersSearchDTO.getMber_birthday_dt_end() != null)
			mbersSearchDTO.setMber_birthday_dt_end(mbersSearchDTO.getMber_birthday_dt_end() + " 23:59:59");
		if (mbersSearchDTO.getMber_conect_dt_start() != null)
			mbersSearchDTO.setMber_conect_dt_start(mbersSearchDTO.getMber_conect_dt_start() + " 00:00:00");
		if (mbersSearchDTO.getMber_conect_dt_end() != null)
			mbersSearchDTO.setMber_conect_dt_end(mbersSearchDTO.getMber_conect_dt_end() + " 23:59:59");
		if (mbersSearchDTO.getMber_reg_dt_start() != null)
			mbersSearchDTO.setMber_reg_dt_start(mbersSearchDTO.getMber_reg_dt_start() + " 00:00:00");
		if (mbersSearchDTO.getMber_reg_dt_end() != null)
			mbersSearchDTO.setMber_reg_dt_end(mbersSearchDTO.getMber_reg_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();

		PageDTO pageDTO = new PageDTO(50);


		switch (mbersSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "MbersSearchDTO_and";
			count = adminMemberManagementDAO.getAndCount(mbersSearchDTO);
			break;
		case "or":
			usedDTO = "MbersSearchDTO_or";
			count = adminMemberManagementDAO.getOrCount(mbersSearchDTO);
			break;
		}

		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);

		map.put("mbers_count", count);

		mbersSearchDTO.setBegin(pageDTO.getBegin());
		mbersSearchDTO.setEnd(pageDTO.getEnd());
		this.mbersSearchDTO = mbersSearchDTO; // 페이징을 위한 검색 기록 저장
		
		map.put("mber_grad", adminMemberManagementDAO.getMemberGradeList());

		switch (mbersSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("mbersDTO", adminMemberManagementDAO.getAndSearch(mbersSearchDTO));
			break;
		case "or":
			map.put("mbersDTO", adminMemberManagementDAO.getOrSearch(mbersSearchDTO));
			break;
		}

		return map;
	}

	// 회원 정보 수정
	@PostMapping("mbers_update.mcat")
	@ResponseBody
	public Map<String, Object> getMbersUpdateCmd(@RequestBody Map<String, List<MbersDTO>> members) {
		for (String i : members.keySet()) {
			for (MbersDTO j : members.get(i)) {
				adminMemberManagementDAO.updateMember(j);
			}
		}
		return getMbersPagingCmd(cPage);
	}

	// 회원 탈퇴
	@PostMapping("withdrawal.mcat")
	@ResponseBody
	public Map<String, Object> getMbersWithdrawalCmd(@RequestBody Map<String, List<String>> mbers) {
		for (String i : mbers.keySet()) {
			for (String j : mbers.get(i)) {
				adminMemberManagementDAO.deleteAdmin(j);
			}
		}

		switch (usedDTO) {
		case "MbersDTO":
			count = adminMemberManagementDAO.getAdminCount();
			break;
		case "MbersSearchDTO_and":
			count = adminMemberManagementDAO.getAndCount(mbersSearchDTO);
			break;
		case "MbersSearchDTO_or":
			count = adminMemberManagementDAO.getOrCount(mbersSearchDTO);
			break;
		}

		return getMbersPagingCmd(cPage);
	}

}
