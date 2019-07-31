package com.macat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.service.DAO;
import com.macat.service.MbersSearchVO;
import com.macat.service.MbersVO;
import com.macat.service.NotSearchVO;
import com.macat.service.Paging;

@Controller
public class MyController {

	@Inject
	private DAO dao;

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	private String cPage;
	
	////////////////////////////////// 메인 //////////////////////////////////
	
	// 로그인 페이지로 이동
	@RequestMapping("login.mcat")
	public ModelAndView getLoginCmd() {
		return new ModelAndView("login");
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping("join.mcat")
	public ModelAndView getJoinCmd() {
		return new ModelAndView("join");
	}
	
	// 로그인
	@RequestMapping(value = "login_ok.mcat", method = RequestMethod.POST)
	public ModelAndView getLoginOkCmd(HttpSession session, MbersVO mbersVO) {
		ModelAndView mv;
		MbersVO loginMber = dao.getLogin(mbersVO); 
		if (loginMber  != null) {
			mv = new ModelAndView("admin/main");
			session.setAttribute("loginChk", loginMber);
			dao.getLoginRecord(mbersVO);
			return mv;
		}else {
			mv = new ModelAndView("login");
			mv.addObject("loginChk", "fail");
			return mv;
		}
	}
	
	// 회원가입
	@RequestMapping(value = "mber_join.mcat", method = RequestMethod.POST)
	public ModelAndView getJoinCmd(MbersVO mbersVO) {
		// 테스트맨 생성기
		/*mbersVO.setEmail(mbersVO.getEmail() + mbersVO.getEmail_end());
		String id = mbersVO.getId();
		for (int i = 1; i <= 50; i++) {
			mbersVO.setId(id + i);
			dao.getJoin(mbersVO);
		}*/
		 
		mbersVO.setEmail(mbersVO.getEmail() + mbersVO.getEmail_end());
		dao.getJoin(mbersVO);
		return new ModelAndView("redirect:login.mcat");
	}
	
	// 관리자 main으로 이동
	@RequestMapping("admin.mcat")
	public ModelAndView getAdminMain() {
		return new ModelAndView("admin/main");
	}
	
	// 회원 정보 조회로 이동
	@RequestMapping("mbers_manage.mcat")
	public ModelAndView getMbersListCmd(String cPage) {
		ModelAndView mv = new ModelAndView("admin/members/search");
		Paging paging = new Paging();
		getPaging(paging, dao.getMbersCount(), cPage);
		mv.addObject("mbers_list", dao.getMbersList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}
	
	// 회원 정보 조회로 이동
	@RequestMapping("notices_manage.mcat")
	public ModelAndView getNoticeListCmd() {
		ModelAndView mv = new ModelAndView("admin/notices/search");
		mv.addObject("notices_list", dao.getNoticesList());
		return mv;
	}
	
		
	////////////////////////////////// 회원 정보 관리 //////////////////////////////////
	
	
	// 회원 검색
	// 회원 검색 페이징 걸기
	@RequestMapping(value = "mbers_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public List<MbersVO> getMbersSearchCmd(@RequestBody MbersSearchVO mbersSearchVO) {
		if (mbersSearchVO.getConect_rcord_start() != null && mbersSearchVO.getConect_rcord_end() != null) {
			mbersSearchVO.setConect_rcord_start(mbersSearchVO.getConect_rcord_start() + " 00:00:00");
			mbersSearchVO.setConect_rcord_end(mbersSearchVO.getConect_rcord_end() + " 23:59:59");
		}else if (mbersSearchVO.getReg_date_start() != null && mbersSearchVO.getReg_date_end() != null) {
			mbersSearchVO.setReg_date_start(mbersSearchVO.getReg_date_start() + " 00:00:00");
			mbersSearchVO.setReg_date_end(mbersSearchVO.getReg_date_end() + " 23:59:59");
		}
		
		if (mbersSearchVO.getAnd_or_chk().equals("and")) {
			return dao.getMbersAndSearch(mbersSearchVO);
		}else {
			return dao.getMbersOrSearch(mbersSearchVO);
		}
	}
	
	// 회원 정보 페이징
	@RequestMapping(value = "mbers_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMbersPaging(@RequestBody String cPage) {
		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();
		getPaging(paging, dao.getMbersCount(), cPage);
		map.put("paging", paging);
		map.put("mbersVO", dao.getMbersList(paging.getBegin(), paging.getEnd()));
		return map;
	}
	
	// 회원 정보 수정
	@RequestMapping(value = "mbers_update.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMbersUpdateCmd(@RequestBody Map<String, List<MbersVO>> mbersVO) {
		for (String i : mbersVO.keySet()) {
			for (MbersVO j : mbersVO.get(i)) {
				dao.getMbersUpdate(j);
			}
		}
		return getMbersPaging(cPage);
	}
	
	// 회원 탈퇴
	@RequestMapping(value = "withdrawal.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMbersWithdrawalCmd(@RequestBody Map<String, List<String>> mbers) {
		for (String i : mbers.keySet()) {
			for (String j : mbers.get(i)) {
				dao.getMbersWithdrawal(j);
			}
		}
		return getMbersPaging(cPage);
	}
	
	
	////////////////////////////////// 공지사항 관리 //////////////////////////////////
	
	
	// 공지사항 검색
	@RequestMapping(value = "not_search.mcat", method = RequestMethod.POST)
	public ModelAndView getNoticesSearchCmd(NotSearchVO notSearchVO) {
		ModelAndView mv = new ModelAndView("admin/notices/search");
		
		if (notSearchVO.getNot_reg_date_start() != null && notSearchVO.getNot_reg_date_end() != null) {
			notSearchVO.setNot_reg_date_start(notSearchVO.getNot_reg_date_start() + " 00:00:00");
			notSearchVO.setNot_reg_date_end(notSearchVO.getNot_reg_date_end() + " 23:59:59");
		}
		
		if (notSearchVO.getAnd_or_chk().equals("and")) {
			mv.addObject("notices_list", dao.getNoticesAndSearch(notSearchVO));
		}else if (notSearchVO.getAnd_or_chk().equals("or")){
			mv.addObject("notices_list", dao.getNoticesOrSearch(notSearchVO));
		}
		
		return mv;
	}
	
	
	////////////////////////////////// 페이징 //////////////////////////////////
	
	public void getPaging(Paging paging, int count, String cPage) {
		paging.setTotalRecord(count);
		
		if(paging.getTotalRecord() <= paging.getNumPerPage()) {
			paging.setTotalPage(1);
		}else {
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			if(paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				paging.setTotalPage(paging.getTotalPage() + 1);
			}
		}
		
		if(cPage == null) {
			paging.setNowPage(1);
		}else {
			paging.setNowPage(Integer.parseInt(cPage));
		}
		
		paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
		paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());
		
		paging.setBeginBlock((int)((paging.getNowPage() - 1)/paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
		paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);
		
		if(paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}
	}
}