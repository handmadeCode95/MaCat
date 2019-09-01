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

import com.macat.dao.DAO;
import com.macat.dto.DateDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.MbersSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.service.DateUtil;
import com.macat.service.Paging;

@Controller
@RequestMapping("admin/members/*.mcat")
public class AdminMembersController extends Paging {

	private final DAO dao;
	
	@Autowired
	public AdminMembersController(DAO dao) {
		this.dao = dao;
	}

	// 회원 정보 조회로 이동
	@GetMapping("manager.mcat")
	public ModelAndView getMembersCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "MbersDTO";
		ModelAndView mv = new ModelAndView("admin/members/manager");

		DateDTO dateDTO = new DateDTO();
		dateDTO.setToday(DateUtil.getToday());
		dateDTO.setOneWeekAgo(DateUtil.addDate(-7));
		dateDTO.setOneMonthAgo(DateUtil.addMonth(-1));
		dateDTO.setThreeMonthAgo(DateUtil.addMonth(-3));
		dateDTO.setSixMonthAgo(DateUtil.addMonth(-6));
		dateDTO.setOneYearAgo(DateUtil.addYear(-1));
		mv.addObject("dateDTO", dateDTO);

		PageDTO pageDTO = new PageDTO(50);
		count = dao.getMbersCount();
		setPage(pageDTO, count, cPage);
		
		mv.addObject("mber_grad", dao.getMberGradList());
		mv.addObject("mbersDTO", dao.getMbersList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// 회원 정보 페이징
	@PostMapping("paging.mcat")
	@ResponseBody
	public Map<String, Object> getMbersPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(50);
		Map<String, Object> map = new HashMap<String, Object>();

		setPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);
		map.put("mber_grad", dao.getMberGradList());

		switch (usedDTO) {
		case "MbersDTO":
			map.put("mbersDTO", dao.getMbersList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			mbersSearchDTO.setBegin(pageDTO.getBegin());
			mbersSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "MbersSearchDTO_and":
				map.put("mbersDTO", dao.getMbersAndSearch(mbersSearchDTO));
				break;
			case "MbersSearchDTO_or":
				map.put("mbersDTO", dao.getMbersOrSearch(mbersSearchDTO));
				break;
			}
		}

		return map;
	}

	// 회원 검색
	@PostMapping("search.mcat")
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
			count = dao.getMbersAndCount(mbersSearchDTO);
			break;
		case "or":
			usedDTO = "MbersSearchDTO_or";
			count = dao.getMbersOrCount(mbersSearchDTO);
			break;
		}

		setPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);

		map.put("mbers_count", count);

		mbersSearchDTO.setBegin(pageDTO.getBegin());
		mbersSearchDTO.setEnd(pageDTO.getEnd());
		this.mbersSearchDTO = mbersSearchDTO; // 페이징을 위한 검색 기록 저장

		map.put("mber_grad", dao.getMberGradList());

		switch (mbersSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("mbersDTO", dao.getMbersAndSearch(mbersSearchDTO));
			break;
		case "or":
			map.put("mbersDTO", dao.getMbersOrSearch(mbersSearchDTO));
			break;
		}

		return map;
	}

	// 회원 정보 수정
	@PostMapping("update.mcat")
	@ResponseBody
	public Map<String, Object> getMbersUpdateCmd(@RequestBody Map<String, List<MbersDTO>> members) {
		for (String i : members.keySet()) {
			for (MbersDTO j : members.get(i)) {
				dao.getMbersUpdate(j);
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
				dao.getMbersWithdrawal(j);
			}
		}

		switch (usedDTO) {
		case "MbersDTO":
			count = dao.getMbersCount();
			break;
		case "MbersSearchDTO_and":
			count = dao.getMbersAndCount(mbersSearchDTO);
			break;
		case "MbersSearchDTO_or":
			count = dao.getMbersOrCount(mbersSearchDTO);
			break;
		}

		return getMbersPagingCmd(cPage);
	}

}
