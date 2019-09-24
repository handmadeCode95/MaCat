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
	
/*
 * 예를들어 웹페이지에서 json으로 request한 파라미터들을 java에서 받으려면 java object로의 변환이 필요하며 마찬가지로
 * response 시에도 java object에서 json으로 변환이 필요하다.
 * 
 * 이러한 작업들을 해주는 어노테이션이 바로 @RequestBody 와 @ResponseBody 이다. 컨트롤러에 두 어노테이션을 추가해주면,
 * JSON이나 key/value 방식 xml 등으로 송수신 할 수 있다.
 * 
 * @RequestBody -> HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할 : http 요청을 자바로 분배
	- HTTP body안에 JSON을 VO에 맵핑
	- HTTP 요청(Request)의 body안에 담겨있는 JSON(또는 XML)을 VO에 자동으로 맵핑시키는 어노테이션
	
	@ResponseBody -> 자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할 : 자바를 모아서 http로 송신	
	- 함수의 return 값을 직렬화하여 HTTP Response의 body에 담습니다.
	- VO 객체를 JSON으로 바꿔서 HTTP body에 담습니다.
 * 
 * 컨트롤러 메서드 안에 기술된 리스폰스바디는 '함수의 return 값을 직렬화하여 HTTP Response의 body에 담을꺼야!' 
 * 라고 스프링에게 알려줍니다. 
 * +만약에 Accept에 application/json이라고 적었으면 함수의 return값을 JSON으로 바꿔서 HTTP body에 담을 것입니다.
 */

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
