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
import com.macat.service.NotsSearchVO;
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
	
	// 페이징을 위한 회원 정보 검색 기록
	private MbersSearchVO mbersSearchVO;
	private NotsSearchVO notsSearchVO;
	
	private String usedVO;			 	 // 페이징을 위한 조회 기록
	private int count;					 // 페이징을 위한 검색 인원 수 기록
	private String cPage;				 // 페이징을 위한 현재 페이지 기록
	
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
	
	
	////////////////////////////////// 관리자 메인 //////////////////////////////////
	
	
	// 회원 정보 조회로 이동
	@RequestMapping("mbers_manage.mcat")
	public ModelAndView getMembersCmd(String cPage) {
		usedVO = "MbersVO";
		ModelAndView mv = new ModelAndView("admin/members/management");
		Paging paging = new Paging();
		count = dao.getMbersCount();
		getPaging(paging, count, cPage);
		mv.addObject("members", dao.getMbersList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}
	
	// 공지사항 조회로 이동
	@RequestMapping("nots_manage.mcat")
	public ModelAndView getNoticesCmd(String cPage) {
		usedVO = "NotsVO";
		ModelAndView mv = new ModelAndView("admin/notices/management");
		Paging paging = new Paging();
		count = dao.getNotsCount();
		getPaging(paging, count, cPage);
		mv.addObject("notices", dao.getNotsList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}
	
		
	////////////////////////////////// 회원 정보 관리 //////////////////////////////////
	
	
	// 회원 정보 페이징
	@RequestMapping(value = "mbers_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMbersPagingCmd(@RequestBody String cPage) {
		
		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();
		
		getPaging(paging, count, cPage);
		map.put("paging", paging);
		
		switch (usedVO) {
			case "MbersVO" :
				map.put("mbersVO", dao.getMbersList(paging.getBegin(), paging.getEnd()));
				break;
			default :
				mbersSearchVO.setBegin(paging.getBegin());
				mbersSearchVO.setEnd(paging.getEnd());
				switch (usedVO) {
					case "MbersSearchVO_and" : map.put("mbersVO", dao.getMbersAndSearch(mbersSearchVO)); break;
					case "MbersSearchVO_or"  : map.put("mbersVO", dao.getMbersOrSearch(mbersSearchVO));  break;
				}
		}
		
		return map;
	}
	
	// 회원 검색
	@RequestMapping(value = "mbers_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMbersSearchCmd(@RequestBody MbersSearchVO mbersSearchVO) {
		
		if (mbersSearchVO.getBirthday_start() != null)
			mbersSearchVO.setBirthday_start(mbersSearchVO.getBirthday_start() + " 00:00:00");
		if (mbersSearchVO.getBirthday_end() != null)
			mbersSearchVO.setBirthday_end(mbersSearchVO.getBirthday_end() + " 23:59:59");
		if (mbersSearchVO.getConect_rcord_start() != null)
			mbersSearchVO.setConect_rcord_start(mbersSearchVO.getConect_rcord_start() + " 00:00:00");
		if (mbersSearchVO.getConect_rcord_end() != null)
			mbersSearchVO.setConect_rcord_end(mbersSearchVO.getConect_rcord_end() + " 23:59:59");
		if (mbersSearchVO.getReg_date_start() != null)
			mbersSearchVO.setReg_date_start(mbersSearchVO.getReg_date_start() + " 00:00:00");
		if (mbersSearchVO.getReg_date_end() != null)
			mbersSearchVO.setReg_date_end(mbersSearchVO.getReg_date_end() + " 23:59:59");
		
		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();
		
		switch (mbersSearchVO.getAnd_or_chk()) {
			case "and" :
				usedVO = "MbersSearchVO_and";
				count = dao.getMbersAndCount(mbersSearchVO);
				break;
			case "or"  :
				usedVO = "MbersSearchVO_or";
				count = dao.getMbersOrCount(mbersSearchVO);
				break;
		}
		
		getPaging(paging, count, null);
		map.put("paging", paging);
		mbersSearchVO.setBegin(paging.getBegin());
		mbersSearchVO.setEnd(paging.getEnd());
		this.mbersSearchVO = mbersSearchVO; // 페이징을 위한 검색 기록 저장
		
		switch (mbersSearchVO.getAnd_or_chk()) {
			case "and" : map.put("mbersVO", dao.getMbersAndSearch(mbersSearchVO)); break;
			case "or"  : map.put("mbersVO", dao.getMbersOrSearch(mbersSearchVO));  break;
		}
		
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
		return getMbersPagingCmd(cPage);
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
		
		switch (usedVO) {
			case "MbersVO"			 : count = dao.getMbersCount(); 				break;
			case "MbersSearchVO_and" : count = dao.getMbersAndCount(mbersSearchVO); break;
			case "MbersSearchVO_or"	 : count = dao.getMbersOrCount(mbersSearchVO);  break;
		}
		
		return getMbersPagingCmd(cPage);
	}
	
	
	////////////////////////////////// 공지사항 관리 //////////////////////////////////
	
	
	// 공지사항 페이징
	@RequestMapping(value = "nots_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotsPagingCmd(@RequestBody String cPage) {
		
		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();
		
		getPaging(paging, count, cPage);
		map.put("paging", paging);
		
		switch (usedVO) {
			case "NotsVO" :
				map.put("NotsVO", dao.getNotsList(paging.getBegin(), paging.getEnd()));
				break;
			default :
				notsSearchVO.setBegin(paging.getBegin());
				notsSearchVO.setEnd(paging.getEnd());
				switch (usedVO) {
					case "NotsSearchVO_and" : map.put("NotsVO", dao.getNotsAndSearch(notsSearchVO)); break;
					case "NotsSearchVO_or"  : map.put("NotsVO", dao.getNotsOrSearch(notsSearchVO));  break;
				}
		}
		
		return map;
	}
	
	// 공지사항 검색
	@RequestMapping(value = "nots_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotsSearchCmd(@RequestBody NotsSearchVO notsSearchVO) {
		
		if (notsSearchVO.getNot_reg_date_start() != null)
			notsSearchVO.setNot_reg_date_start(notsSearchVO.getNot_reg_date_start() + " 00:00:00");
		if (notsSearchVO.getNot_reg_date_end() != null)
			notsSearchVO.setNot_reg_date_end(notsSearchVO.getNot_reg_date_end() + " 23:59:59");
		
		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();
		
		switch (notsSearchVO.getAnd_or_chk()) {
			case "and" :
				usedVO = "NotsSearchVO_and";
				count = dao.getNotsAndCount(notsSearchVO);
				break;
			case "or"  :
				usedVO = "NotsSearchVO_or";
				count = dao.getNotsOrCount(notsSearchVO);
				break;
		}
		
		getPaging(paging, count, null);
		map.put("paging", paging);
		notsSearchVO.setBegin(paging.getBegin());
		notsSearchVO.setEnd(paging.getEnd());
		this.notsSearchVO = notsSearchVO; // 페이징을 위한 검색 기록 저장
		
		switch (notsSearchVO.getAnd_or_chk()) {
			case "and" : map.put("NotsVO", dao.getNotsAndSearch(notsSearchVO)); break;
			case "or"  : map.put("NotsVO", dao.getNotsOrSearch(notsSearchVO));  break;
		}
		
		return map;
	}
	
	// 공지사항 작성으로 이동
	@RequestMapping("nots_write.mcat")
	public ModelAndView getNotsWriteGoCmd() {
		return new ModelAndView("admin/notices/write");
	}
	
	// 공지사항 수정으로 이동
	@RequestMapping("nots_update.mcat")
	public ModelAndView getNotsUpdateGoCmd() {
		return new ModelAndView("admin/notices/update");
	}
	
	// 공지사항 삭제
	@RequestMapping(value = "delete.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotsDeleteCmd(@RequestBody Map<String, List<String>> nots) {
		for (String i : nots.keySet()) {
			for (String j : nots.get(i)) {
				dao.getNotsDelete(j);
			}
		}
		
		switch (usedVO) {
			case "NotsVO"			: count = dao.getNotsCount(); 				 break;
			case "NotsSearchVO_and" : count = dao.getNotsAndCount(notsSearchVO); break;
			case "NotsSearchVO_or"	: count = dao.getNotsOrCount(notsSearchVO);  break;
		}
		
		return getNotsPagingCmd(cPage);
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