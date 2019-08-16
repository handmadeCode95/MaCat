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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.service.DAO;
import com.macat.service.FaqSearchVO;
import com.macat.service.FaqVO;
import com.macat.service.ImagesVO;
import com.macat.service.MbersSearchVO;
import com.macat.service.MbersVO;
import com.macat.service.NotsSearchVO;
import com.macat.service.Paging;
import com.macat.service.PqSearchVO;
import com.macat.service.PqVO;
import com.macat.service.ProductsVO;
import com.macat.service.QnaSearchVO;
import com.macat.service.QnaVO;

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
	private QnaSearchVO qnaSearchVO;
	private PqSearchVO pqSearchVO;
	private FaqSearchVO faqSearchVO;

	private String usedVO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록

	
	/*////////////////////////////////// 메인 //////////////////////////////////*/

	
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
		if (loginMber != null) {
			mv = new ModelAndView("admin/main");
			session.setAttribute("loginChk", loginMber);
			dao.getLoginRecord(mbersVO);
			return mv;
		} else {
			mv = new ModelAndView("login");
			mv.addObject("loginChk", "fail");
			return mv;
		}
	}

	// 회원가입
	@RequestMapping(value = "mber_join.mcat", method = RequestMethod.POST)
	public ModelAndView getJoinCmd(MbersVO mbersVO) {
		// 테스트맨 생성기
		/*
		 * mbersVO.setEmail(mbersVO.getEmail() + mbersVO.getEmail_end()); String id =
		 * mbersVO.getId(); for (int i = 1; i <= 50; i++) { mbersVO.setId(id + i);
		 * dao.getJoin(mbersVO); }
		 */

		mbersVO.setEmail(mbersVO.getEmail() + mbersVO.getEmail_end());
		dao.getJoin(mbersVO);
		return new ModelAndView("redirect:login.mcat");
	}

	// 관리자 main으로 이동
	@RequestMapping("admin.mcat")
	public ModelAndView getAdminMainCmd() {
		return new ModelAndView("admin/main");
	}
	
	// 카테고리 페이지로 이동
	@RequestMapping("category.mcat")
	public ModelAndView getCategoryCmd(int ctgry_group) {
		ModelAndView mv = new ModelAndView("product/category");
		Paging paging = new Paging(20);
		count = dao.getProductsCount();
		getPaging(paging, count, cPage);
		
		List<ProductsVO> products = dao.getProductsList(ctgry_group, paging.getBegin(), paging.getEnd());
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> prduct_sqs = new ArrayList<String>();
		for (ProductsVO i : products) {
			prduct_sqs.add(i.getPrduct_sq());
		}
		map.put("prduct_sqs", prduct_sqs);
		
		mv.addObject("categories", dao.getCategoryGroup(ctgry_group));
		mv.addObject("product_imgs", dao.getCategoryProductImgs(map));
		mv.addObject("products", products);
		mv.addObject("paging", paging);
		return mv;
	}

	
	/*////////////////////////////////// 관리자 메인 //////////////////////////////////*/

	
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

	// 고객 문의 관리로 이동
	@RequestMapping("qna_manage.mcat")
	public ModelAndView getQnaCmd(String cPage) {
		usedVO = "QnaVO";
		ModelAndView mv = new ModelAndView("admin/qna/management");
		Paging paging = new Paging();
		count = dao.getQnaCount();
		getPaging(paging, count, cPage);
		mv.addObject("qna", dao.getQnaList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}
	
	// 상품 문의 관리로 이동
	@RequestMapping("pq_manage.mcat")
	public ModelAndView getPqCmd(String cPage) {
		usedVO = "PqVO";
		ModelAndView mv = new ModelAndView("admin/pq/management");
		Paging paging = new Paging();
		count = dao.getPqCount();
		getPaging(paging, count, cPage);
		mv.addObject("product_qna", dao.getPqList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}
	
	// FAQ 관리로 이동
	@RequestMapping("faq_manage.mcat")
	public ModelAndView getFaqCmd(String cPage) {
		usedVO = "FaqVO";
		ModelAndView mv = new ModelAndView("admin/faq/management");
		Paging paging = new Paging();
		count = dao.getFaqCount();
		getPaging(paging, count, cPage);
		mv.addObject("faq", dao.getFaqList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}

	
	/*////////////////////////////////// 회원 정보 관리 //////////////////////////////////*/

	
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
		case "MbersVO":
			map.put("mbersVO", dao.getMbersList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			mbersSearchVO.setBegin(paging.getBegin());
			mbersSearchVO.setEnd(paging.getEnd());
			switch (usedVO) {
			case "MbersSearchVO_and":
				map.put("mbersVO", dao.getMbersAndSearch(mbersSearchVO));
				break;
			case "MbersSearchVO_or":
				map.put("mbersVO", dao.getMbersOrSearch(mbersSearchVO));
				break;
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
		case "and":
			usedVO = "MbersSearchVO_and";
			count = dao.getMbersAndCount(mbersSearchVO);
			break;
		case "or":
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
		case "and":
			map.put("mbersVO", dao.getMbersAndSearch(mbersSearchVO));
			break;
		case "or":
			map.put("mbersVO", dao.getMbersOrSearch(mbersSearchVO));
			break;
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
		case "MbersVO":
			count = dao.getMbersCount();
			break;
		case "MbersSearchVO_and":
			count = dao.getMbersAndCount(mbersSearchVO);
			break;
		case "MbersSearchVO_or":
			count = dao.getMbersOrCount(mbersSearchVO);
			break;
		}

		return getMbersPagingCmd(cPage);
	}

	
	/*////////////////////////////////// 공지사항 관리 //////////////////////////////////*/

	
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
		case "NotsVO":
			map.put("notsVO", dao.getNotsList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			notsSearchVO.setBegin(paging.getBegin());
			notsSearchVO.setEnd(paging.getEnd());
			switch (usedVO) {
			case "NotsSearchVO_and":
				map.put("notsVO", dao.getNotsAndSearch(notsSearchVO));
				break;
			case "NotsSearchVO_or":
				map.put("notsVO", dao.getNotsOrSearch(notsSearchVO));
				break;
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
		case "and":
			usedVO = "NotsSearchVO_and";
			count = dao.getNotsAndCount(notsSearchVO);
			break;
		case "or":
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
		case "and":
			map.put("notsVO", dao.getNotsAndSearch(notsSearchVO));
			break;
		case "or":
			map.put("notsVO", dao.getNotsOrSearch(notsSearchVO));
			break;
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
	@RequestMapping(value = "nots_delete.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotsDeleteCmd(@RequestBody Map<String, List<String>> nots) {
		for (String i : nots.keySet()) {
			for (String j : nots.get(i)) {
				dao.getNotsDelete(j);
			}
		}

		switch (usedVO) {
		case "NotsVO":
			count = dao.getNotsCount();
			break;
		case "NotsSearchVO_and":
			count = dao.getNotsAndCount(notsSearchVO);
			break;
		case "NotsSearchVO_or":
			count = dao.getNotsOrCount(notsSearchVO);
			break;
		}

		return getNotsPagingCmd(cPage);
	}

	
	/*////////////////////////////////// 고객 문의 관리 //////////////////////////////////*/

	
	// 고객 문의 페이징
	@RequestMapping(value = "qna_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getQnaPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();

		getPaging(paging, count, cPage);
		map.put("paging", paging);

		switch (usedVO) {
		case "QnaVO":
			map.put("qnaVO", dao.getQnaList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			qnaSearchVO.setBegin(paging.getBegin());
			qnaSearchVO.setEnd(paging.getEnd());
			switch (usedVO) {
			case "QnaSearchVO_and":
				map.put("qnaVO", dao.getQnaAndSearch(qnaSearchVO));
				break;
			case "QnaSearchVO_or":
				map.put("qnaVO", dao.getQnaOrSearch(qnaSearchVO));
				break;
			}
		}

		return map;
	}

	// 고객 문의 검색
	@RequestMapping(value = "qna_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getQnaSearchCmd(@RequestBody QnaSearchVO qnaSearchVO) {

		if (qnaSearchVO.getQna_reg_date_start() != null)
			qnaSearchVO.setQna_reg_date_start(qnaSearchVO.getQna_reg_date_start() + " 00:00:00");
		if (qnaSearchVO.getQna_reg_date_end() != null)
			qnaSearchVO.setQna_reg_date_end(qnaSearchVO.getQna_reg_date_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();

		switch (qnaSearchVO.getAnd_or_chk()) {
		case "and":
			usedVO = "QnaSearchVO_and";
			count = dao.getQnaAndCount(qnaSearchVO);
			break;
		case "or":
			usedVO = "QnaSearchVO_or";
			count = dao.getQnaOrCount(qnaSearchVO);
			break;
		}

		getPaging(paging, count, null);
		map.put("paging", paging);
		qnaSearchVO.setBegin(paging.getBegin());
		qnaSearchVO.setEnd(paging.getEnd());
		this.qnaSearchVO = qnaSearchVO; // 페이징을 위한 검색 기록 저장

		switch (qnaSearchVO.getAnd_or_chk()) {
		case "and":
			map.put("qnaVO", dao.getQnaAndSearch(qnaSearchVO));
			break;
		case "or":
			map.put("qnaVO", dao.getQnaOrSearch(qnaSearchVO));
			break;
		}

		return map;
	}

	// 고객 문의 삭제
	@RequestMapping(value = "qna_delete.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getQnaDeleteCmd(@RequestBody Map<String, List<String>> qnas) {
		for (String i : qnas.keySet()) {
			for (String j : qnas.get(i)) {
				dao.getQnaDelete(j);
			}
		}

		switch (usedVO) {
		case "QnaVO":
			count = dao.getQnaCount();
			break;
		case "QnaSearchVO_and":
			count = dao.getQnaAndCount(qnaSearchVO);
			break;
		case "QnaSearchVO_or":
			count = dao.getQnaOrCount(qnaSearchVO);
			break;
		}

		return getQnaPagingCmd(cPage);
	}

	// 문의 보기로 이동
	@RequestMapping("qna_view.mcat")
	public ModelAndView getQnaViewCmd(HttpSession session, String qna_sn) {
		QnaVO qnaVO = dao.getQnaView(qna_sn);

		qnaVO.setQna_rdcnt(qnaVO.getQna_rdcnt() + 1);
		dao.getQnaRdcntUpdate(qnaVO);

		session.setAttribute("qnaVO", qnaVO);

		return new ModelAndView("admin/qna/view");
	}
	

	/*////////////////////////////////// 상품 문의 관리 //////////////////////////////////*/

	
	// 상품 문의 페이징
	@RequestMapping(value = "pq_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPqPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();

		getPaging(paging, count, cPage);
		map.put("paging", paging);

		switch (usedVO) {
		case "PqVO":
			map.put("pqVO", dao.getQnaList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			pqSearchVO.setBegin(paging.getBegin());
			pqSearchVO.setEnd(paging.getEnd());
			switch (usedVO) {
			case "PqSearchVO_and":
				map.put("pqVO", dao.getPqAndSearch(pqSearchVO));
				break;
			case "PqSearchVO_or":
				map.put("pqVO", dao.getPqOrSearch(pqSearchVO));
				break;
			}
		}

		return map;
	}

	// 상품 문의 검색
	@RequestMapping(value = "pq_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPqSearchCmd(@RequestBody PqSearchVO pqSearchVO) {

		if (pqSearchVO.getPq_reg_date_start() != null)
			pqSearchVO.setPq_reg_date_start(pqSearchVO.getPq_reg_date_start() + " 00:00:00");
		if (pqSearchVO.getPq_reg_date_end() != null)
			pqSearchVO.setPq_reg_date_end(pqSearchVO.getPq_reg_date_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();

		switch (pqSearchVO.getAnd_or_chk()) {
		case "and":
			usedVO = "PqSearchVO_and";
			count = dao.getPqAndCount(pqSearchVO);
			break;
		case "or":
			usedVO = "PqSearchVO_or";
			count = dao.getPqOrCount(pqSearchVO);
			break;
		}

		getPaging(paging, count, null);
		map.put("paging", paging);
		pqSearchVO.setBegin(paging.getBegin());
		pqSearchVO.setEnd(paging.getEnd());
		this.pqSearchVO = pqSearchVO; // 페이징을 위한 검색 기록 저장

		switch (pqSearchVO.getAnd_or_chk()) {
		case "and":
			map.put("pqVO", dao.getPqAndSearch(pqSearchVO));
			break;
		case "or":
			map.put("pqVO", dao.getPqOrSearch(pqSearchVO));
			break;
		}

		return map;
	}

	// 상품 문의 삭제
	@RequestMapping(value = "pq_delete.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPqDeleteCmd(@RequestBody Map<String, List<String>> pqs) {
		for (String i : pqs.keySet()) {
			for (String j : pqs.get(i)) {
				dao.getPqDelete(j);
			}
		}

		switch (usedVO) {
		case "PqVO":
			count = dao.getPqCount();
			break;
		case "PqSearchVO_and":
			count = dao.getPqAndCount(pqSearchVO);
			break;
		case "PqSearchVO_or":
			count = dao.getPqOrCount(pqSearchVO);
			break;
		}

		return getPqPagingCmd(cPage);
	}

	// 상품 문의 보기로 이동
	@RequestMapping("pq_view.mcat")
	public ModelAndView getPqViewCmd(HttpSession session, String pq_sn) {
		PqVO pqVO = dao.getPqView(pq_sn);
		
		session.setAttribute("pqVO", pqVO);

		return new ModelAndView("admin/pq/view");
	}
	
	
	/*////////////////////////////////// FAQ 관리 //////////////////////////////////*/

	
	// FAQ 페이징
	@RequestMapping(value = "faq_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFaqPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();

		getPaging(paging, count, cPage);
		map.put("paging", paging);

		switch (usedVO) {
		case "FaqVO":
			map.put("faqVO", dao.getFaqList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			faqSearchVO.setBegin(paging.getBegin());
			faqSearchVO.setEnd(paging.getEnd());
			switch (usedVO) {
			case "FaqSearchVO_and":
				map.put("faqVO", dao.getFaqAndSearch(faqSearchVO));
				break;
			case "FaqSearchVO_or":
				map.put("faqVO", dao.getFaqOrSearch(faqSearchVO));
				break;
			}
		}

		return map;
	}

	// FAQ 검색
	@RequestMapping(value = "faq_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFaqSearchCmd(@RequestBody FaqSearchVO faqSearchVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();

		switch (faqSearchVO.getAnd_or_chk()) {
		case "and":
			usedVO = "FaqSearchVO_and";
			count = dao.getFaqAndCount(faqSearchVO);
			break;
		case "or":
			usedVO = "FaqSearchVO_or";
			count = dao.getFaqOrCount(faqSearchVO);
			break;
		}

		getPaging(paging, count, null);
		map.put("paging", paging);
		faqSearchVO.setBegin(paging.getBegin());
		faqSearchVO.setEnd(paging.getEnd());
		this.faqSearchVO = faqSearchVO; // 페이징을 위한 검색 기록 저장

		switch (faqSearchVO.getAnd_or_chk()) {
		case "and":
			map.put("faqVO", dao.getFaqAndSearch(faqSearchVO));
			break;
		case "or":
			map.put("faqVO", dao.getFaqOrSearch(faqSearchVO));
			break;
		}
		
		return map;
	}
	
	// FAQ 삭제
	@RequestMapping(value = "faq_delete.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFaqDeleteCmd(@RequestBody Map<String, List<String>> faqs) {
		for (String i : faqs.keySet()) {
			for (String j : faqs.get(i)) {
				dao.getFaqDelete(j);
			}
		}

		switch (usedVO) {
		case "FaqVO":
			count = dao.getFaqCount();
			break;
		case "FaqSearchVO_and":
			count = dao.getFaqAndCount(faqSearchVO);
			break;
		case "FaqSearchVO_or":
			count = dao.getFaqOrCount(faqSearchVO);
			break;
		}

		return getFaqPagingCmd(cPage);
	}

	// FAQ 보기로 이동
	@RequestMapping("faq_view.mcat")
	public ModelAndView getFaqViewCmd(HttpSession session, String faq_sn) {
		FaqVO faqVO = dao.getFaqView(faq_sn);

		session.setAttribute("faqVO", faqVO);

		return new ModelAndView("admin/faq/view");
	}
	
	
	/*////////////////////////////////// 페이징 //////////////////////////////////*/

	
	public void getPaging(Paging paging, int count, String cPage) {
		paging.setTotalRecord(count);

		if (paging.getTotalRecord() <= paging.getNumPerPage()) {
			paging.setTotalPage(1);
		} else {
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				paging.setTotalPage(paging.getTotalPage() + 1);
			}
		}

		if (cPage == null) {
			paging.setNowPage(1);
		} else {
			paging.setNowPage(Integer.parseInt(cPage));
		}

		paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
		paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

		paging.setBeginBlock(
				(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
		paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}
	}
}