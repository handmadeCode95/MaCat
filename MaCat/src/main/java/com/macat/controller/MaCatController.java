package com.macat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.service.DAO;
import com.macat.service.FaqSearchDTO;
import com.macat.service.FaqDTO;
import com.macat.service.MbersSearchDTO;
import com.macat.service.MbersDTO;
import com.macat.service.NotsSearchDTO;
import com.macat.service.Paging;
import com.macat.service.ProductsDTO;
import com.macat.service.QnaSearchDTO;
import com.macat.service.QnaDTO;

@Controller
public class MaCatController {

	@Inject
	private DAO dao;

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	// 페이징을 위한 회원 정보 검색 기록
	private MbersSearchDTO mbersSearchDTO;
	private NotsSearchDTO notsSearchDTO;
	private QnaSearchDTO qnaSearchDTO;
	private FaqSearchDTO faqSearchDTO;

	private String usedDTO; // 페이징을 위한 조회 기록
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
	public ModelAndView getLoginOkCmd(HttpSession session, MbersDTO mbersDTO) {
		ModelAndView mv;
		MbersDTO loginMber = dao.getLogin(mbersDTO);
		if (loginMber != null) {
			mv = new ModelAndView("admin/main");
			session.setAttribute("loginData", loginMber);
			dao.getLoginRecord(mbersDTO);
			return mv;
		} else {
			mv = new ModelAndView("login");
			mv.addObject("loginData", "fail");
			return mv;
		}
	}

	// 회원가입
	@RequestMapping(value = "mber_join.mcat", method = RequestMethod.POST)
	public ModelAndView getJoinCmd(MbersDTO mbersDTO) {
		// 테스트맨 생성기
		/*
		 * mbersDTO.setEmail(mbersDTO.getEmail() + mbersDTO.getEmail_end()); String id =
		 * mbersDTO.getId(); for (int i = 1; i <= 50; i++) { mbersDTO.setId(id + i);
		 * dao.getJoin(mbersDTO); }
		 */

		mbersDTO.setMber_email(mbersDTO.getMber_email() + mbersDTO.getMber_email_end());
		dao.getJoin(mbersDTO);
		return new ModelAndView("redirect:login.mcat");
	}

	// 관리자 main으로 이동
	@RequestMapping("admin.mcat")
	public ModelAndView getAdminMainCmd() {
		return new ModelAndView("admin/main");
	}
	
	// 카테고리 페이지로 이동
	@RequestMapping("category.mcat")
	public ModelAndView getCategoryCmd(HttpSession session, String cPage, int ctgry_group, int ctgry_level, String ctgry_nm) {
		this.cPage = cPage;
		
		// 메인쪽으로 이동
		session.setAttribute("categories", dao.getCategories());
		
		ModelAndView mv = new ModelAndView("product/category");
		Paging paging = new Paging(20);

		
		if (ctgry_level > 0) {
			count = dao.getProductsCount(ctgry_nm);
			paging.getPaging(paging, count, cPage);
			mv.addObject("products", dao.getProductsList(ctgry_nm, paging.getBegin(), paging.getEnd()));
		}else {
			count = dao.getProductsCount(ctgry_group);
			paging.getPaging(paging, count, cPage);
			mv.addObject("products", dao.getProductsList(ctgry_group, paging.getBegin(), paging.getEnd()));
		}
		
		mv.addObject("ctgry_group", ctgry_group);
		mv.addObject("ctgry_level", ctgry_level);
		mv.addObject("ctgry_nm", ctgry_nm);
		mv.addObject("paging", paging);
		return mv;
	}
	
	
	/*////////////////////////////////// 카테고리 //////////////////////////////////*/
	
	
	// 상품 페이지로 이동
	@RequestMapping("product.mcat")
	public ModelAndView getProductCmd(@CookieValue(required = false, name = "viewedProductSq1") String viewedProductSq1,
			@CookieValue(required = false, name = "viewedProductSq2") String viewedProductSq2,
			@CookieValue(required = false, name = "viewedProductSq3") String viewedProductSq3,
			@CookieValue(required = false, name = "viewedProductThumb1") String viewedProductThumb1,
			@CookieValue(required = false, name = "viewedProductThumb2") String viewedProductThumb2,
			@CookieValue(required = false, name = "viewedProductThumb3") String viewedProductThumb3,
			HttpServletResponse response, String prduct_sq, String prduct_thumb_nm) {
		ModelAndView mv = new ModelAndView("product/product");
		
		// 조회수 증가
		if (dao.getProductViewCntUp(prduct_sq) < 1) System.out.println("조회수증가실패");
		
		// 최근 본 상품 쿠키에 추가. 3개 이상이면 첫 상품 삭제, 중복 불가
		if (!prduct_sq.equals(viewedProductSq1) && !prduct_sq.equals(viewedProductSq2) && !prduct_sq.equals(viewedProductSq3)) {
			if (viewedProductSq1 != null) {
				if (viewedProductSq2 != null) {
					if (viewedProductSq3 != null) {
						response.addCookie(setCookie("viewedProductSq1", viewedProductSq2, 60 * 60 * 24));
						response.addCookie(setCookie("viewedProductThumb1", viewedProductThumb2, 60 * 60 * 24));
						response.addCookie(setCookie("viewedProductSq2", viewedProductSq3, 60 * 60 * 24));
						response.addCookie(setCookie("viewedProductThumb2", viewedProductThumb3, 60 * 60 * 24));
					}
					response.addCookie(setCookie("viewedProductSq3", prduct_sq, 60 * 60 * 24));
					response.addCookie(setCookie("viewedProductThumb3", prduct_thumb_nm, 60 * 60 * 24));
				}else {
					response.addCookie(setCookie("viewedProductSq2", prduct_sq, 60 * 60 * 24));
					response.addCookie(setCookie("viewedProductThumb2", prduct_thumb_nm, 60 * 60 * 24));
				}
			}else {
				response.addCookie(setCookie("viewedProductSq1", prduct_sq, 60 * 60 * 24));
				response.addCookie(setCookie("viewedProductThumb1", prduct_thumb_nm, 60 * 60 * 24));
			}
		}
		
		ProductsDTO productsDTO =  dao.getProduct(prduct_sq);
		
		// 상품 총 적립 금액
		if (productsDTO.getPrduct_save() > 0) {
			productsDTO.setPrduct_point(productsDTO.getPrduct_save());
		}else if (productsDTO.getPrduct_save_pt() > 0 && productsDTO.getPrduct_price() > 99) {
			productsDTO.setPrduct_point(productsDTO.getPrduct_price() * productsDTO.getPrduct_save_pt() / 100);
		}else {
			productsDTO.setPrduct_point(0);
		}
		
		// 상품 할인된 가격
		if (productsDTO.getPrduct_dc() > 0) {
			productsDTO.setPrduct_dced_price(productsDTO.getPrduct_price() - productsDTO.getPrduct_dc());
		}else if (productsDTO.getPrduct_dc_pt() > 0 && productsDTO.getPrduct_price() > 99) {
			productsDTO.setPrduct_dced_price(productsDTO.getPrduct_price() - (productsDTO.getPrduct_price() * productsDTO.getPrduct_dc_pt() / 100));
		}else {
			productsDTO.setPrduct_dced_price(productsDTO.getPrduct_price());
		}
		
		// 상품 평점 반올림
		productsDTO.setPrduct_rating_round(Math.round(productsDTO.getPrduct_rating_avg()));
		
		// 상품 색상
		productsDTO.setColors(dao.getColors(prduct_sq));
		
		mv.addObject("product_imgs", dao.getProductImages(prduct_sq));
		mv.addObject("more_product", dao.getProductsList(productsDTO.getCtgry_nm(), 1, 5));
		mv.addObject("review_cnt", dao.getReviewsCount());
		mv.addObject("product", productsDTO);
		return mv;
	}
	
	
	/*////////////////////////////////// 상품 페이지 //////////////////////////////////*/
	
//
//	@RequestMapping("cookie_cart.mcat")
//	@ResponseBody
//	public void getCookieCart(@RequestBody String prduct_sq, HttpServletResponse response,
//			@CookieValue(required = false, name = "cart_product") String cart_product) {
//		if (cart_product == null) {
//			response.addCookie(setCookie("cart_product", prduct_sq, 60 * 60 * 24));
//		}else {
//			
//		}
//		
//	}
//	
	
	/*////////////////////////////////// 관리자 메인 //////////////////////////////////*/
	
	
	// 회원 정보 조회로 이동
	@RequestMapping("mbers_manager.mcat")
	public ModelAndView getMembersCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "MbersDTO";
		ModelAndView mv = new ModelAndView("admin/members/manager");
		Paging paging = new Paging();
		count = dao.getMbersCount();
		paging.getPaging(paging, count, cPage);
		mv.addObject("mber_grad", dao.getMberGradList());
		mv.addObject("members", dao.getMbersList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}

	// 공지사항 조회로 이동
	@RequestMapping("nots_manage.mcat")
	public ModelAndView getNoticesCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "NotsDTO";
		ModelAndView mv = new ModelAndView("admin/notices/management");
		Paging paging = new Paging();
		count = dao.getNotsCount();
		paging.getPaging(paging, count, cPage);
		mv.addObject("notices", dao.getNotsList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}

	// 고객 문의 관리로 이동
	@RequestMapping("qna_manage.mcat")
	public ModelAndView getQnaCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "QnaDTO";
		ModelAndView mv = new ModelAndView("admin/qna/management");
		Paging paging = new Paging();
		count = dao.getQnaCount();
		paging.getPaging(paging, count, cPage);
		mv.addObject("qna_ctgries", dao.getQnaCtgriesList());
		mv.addObject("qna", dao.getQnaList(paging.getBegin(), paging.getEnd()));
		mv.addObject("paging", paging);
		return mv;
	}
	
	// FAQ 관리로 이동
	@RequestMapping("faq_manage.mcat")
	public ModelAndView getFaqCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "FaqDTO";
		ModelAndView mv = new ModelAndView("admin/faq/management");
		Paging paging = new Paging();
		count = dao.getFaqCount();
		paging.getPaging(paging, count, cPage);
		mv.addObject("qna_ctgries", dao.getQnaCtgriesList());
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

		paging.getPaging(paging, count, cPage);
		map.put("paging", paging);
		
		map.put("mber_grad", dao.getMberGradList());

		switch (usedDTO) {
		case "MbersDTO":
			map.put("members", dao.getMbersList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			mbersSearchDTO.setBegin(paging.getBegin());
			mbersSearchDTO.setEnd(paging.getEnd());
			switch (usedDTO) {
			case "MbersSearchDTO_and":
				map.put("members", dao.getMbersAndSearch(mbersSearchDTO));
				break;
			case "MbersSearchDTO_or":
				map.put("members", dao.getMbersOrSearch(mbersSearchDTO));
				break;
			}
		}

		return map;
	}

	// 회원 검색
	@RequestMapping(value = "mbers_search.mcat", method = RequestMethod.POST)
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
		Paging paging = new Paging();

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

		paging.getPaging(paging, count, null);
		map.put("paging", paging);
		mbersSearchDTO.setBegin(paging.getBegin());
		mbersSearchDTO.setEnd(paging.getEnd());
		this.mbersSearchDTO = mbersSearchDTO; // 페이징을 위한 검색 기록 저장
		
		map.put("mber_grad", dao.getMberGradList());

		switch (mbersSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("members", dao.getMbersAndSearch(mbersSearchDTO));
			break;
		case "or":
			map.put("members", dao.getMbersOrSearch(mbersSearchDTO));
			break;
		}

		return map;
	}

	// 회원 정보 수정
	@RequestMapping(value = "mbers_update.mcat", method = RequestMethod.POST)
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
	@RequestMapping(value = "withdrawal.mcat", method = RequestMethod.POST)
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

	
	/*////////////////////////////////// 공지사항 관리 //////////////////////////////////*/

	
	// 공지사항 페이징
	@RequestMapping(value = "nots_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotsPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();

		paging.getPaging(paging, count, cPage);
		map.put("paging", paging);
		
		switch (usedDTO) {
		case "NotsDTO":
			map.put("notices", dao.getNotsList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			notsSearchDTO.setBegin(paging.getBegin());
			notsSearchDTO.setEnd(paging.getEnd());
			switch (usedDTO) {
			case "NotsSearchDTO_and":
				map.put("notices", dao.getNotsAndSearch(notsSearchDTO));
				break;
			case "NotsSearchDTO_or":
				map.put("notices", dao.getNotsOrSearch(notsSearchDTO));
				break;
			}
		}

		return map;
	}

	// 공지사항 검색
	@RequestMapping(value = "nots_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotsSearchCmd(@RequestBody NotsSearchDTO notsSearchDTO) {

		if (notsSearchDTO.getNot_reg_dt_start() != null)
			notsSearchDTO.setNot_reg_dt_start(notsSearchDTO.getNot_reg_dt_start() + " 00:00:00");
		if (notsSearchDTO.getNot_reg_dt_end() != null)
			notsSearchDTO.setNot_reg_dt_end(notsSearchDTO.getNot_reg_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();

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

		paging.getPaging(paging, count, null);
		map.put("paging", paging);
		notsSearchDTO.setBegin(paging.getBegin());
		notsSearchDTO.setEnd(paging.getEnd());
		this.notsSearchDTO = notsSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (notsSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("notices", dao.getNotsAndSearch(notsSearchDTO));
			break;
		case "or":
			map.put("notices", dao.getNotsOrSearch(notsSearchDTO));
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

	
	/*////////////////////////////////// 고객 문의 관리 //////////////////////////////////*/

	
	// 고객 문의 페이징
	@RequestMapping(value = "qna_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getQnaPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();

		paging.getPaging(paging, count, cPage);
		map.put("paging", paging);

		switch (usedDTO) {
		case "QnaDTO":
			map.put("qna", dao.getQnaList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			qnaSearchDTO.setBegin(paging.getBegin());
			qnaSearchDTO.setEnd(paging.getEnd());
			switch (usedDTO) {
			case "QnaSearchDTO_and":
				map.put("qna", dao.getQnaAndSearch(qnaSearchDTO));
				break;
			case "QnaSearchDTO_or":
				map.put("qna", dao.getQnaOrSearch(qnaSearchDTO));
				break;
			}
		}

		return map;
	}

	// 고객 문의 검색
	@RequestMapping(value = "qna_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getQnaSearchCmd(@RequestBody QnaSearchDTO qnaSearchDTO) {

		if (qnaSearchDTO.getQna_reg_dt_start() != null)
			qnaSearchDTO.setQna_reg_dt_start(qnaSearchDTO.getQna_reg_dt_start() + " 00:00:00");
		if (qnaSearchDTO.getQna_reg_dt_end() != null)
			qnaSearchDTO.setQna_reg_dt_end(qnaSearchDTO.getQna_reg_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();

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

		paging.getPaging(paging, count, null);
		map.put("paging", paging);
		qnaSearchDTO.setBegin(paging.getBegin());
		qnaSearchDTO.setEnd(paging.getEnd());
		this.qnaSearchDTO = qnaSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (qnaSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("qna", dao.getQnaAndSearch(qnaSearchDTO));
			break;
		case "or":
			map.put("qna", dao.getQnaOrSearch(qnaSearchDTO));
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
	@RequestMapping("qna_view.mcat")
	public ModelAndView getQnaViewCmd(HttpSession session, String qna_sq) {
		QnaDTO qnaDTO = dao.getQnaView(qna_sq);

		qnaDTO.setQna_view_cnt(qnaDTO.getQna_view_cnt() + 1);
		dao.getQnaRdcntUpdate(qnaDTO);

		session.setAttribute("qnaDTO", qnaDTO);

		return new ModelAndView("admin/qna/view");
	}
	

	/*////////////////////////////////// FAQ 관리 //////////////////////////////////*/

	
	// FAQ 페이징
	@RequestMapping(value = "faq_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFaqPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		Paging paging = new Paging();
		Map<String, Object> map = new HashMap<String, Object>();

		paging.getPaging(paging, count, cPage);
		map.put("paging", paging);

		switch (usedDTO) {
		case "FaqDTO":
			map.put("faq", dao.getFaqList(paging.getBegin(), paging.getEnd()));
			break;
		default:
			faqSearchDTO.setBegin(paging.getBegin());
			faqSearchDTO.setEnd(paging.getEnd());
			switch (usedDTO) {
			case "FaqSearchDTO_and":
				map.put("faq", dao.getFaqAndSearch(faqSearchDTO));
				break;
			case "FaqSearchDTO_or":
				map.put("faq", dao.getFaqOrSearch(faqSearchDTO));
				break;
			}
		}

		return map;
	}

	// FAQ 검색
	@RequestMapping(value = "faq_search.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFaqSearchCmd(@RequestBody FaqSearchDTO faqSearchDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Paging paging = new Paging();

		switch (faqSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "FaqSearchDTO_and";
			count = dao.getFaqAndCount(faqSearchDTO);
			break;
		case "or":
			usedDTO = "FaqSearchDTO_or";
			count = dao.getFaqOrCount(faqSearchDTO);
			break;
		}

		paging.getPaging(paging, count, null);
		map.put("paging", paging);
		faqSearchDTO.setBegin(paging.getBegin());
		faqSearchDTO.setEnd(paging.getEnd());
		this.faqSearchDTO = faqSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (faqSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("faq", dao.getFaqAndSearch(faqSearchDTO));
			break;
		case "or":
			map.put("faq", dao.getFaqOrSearch(faqSearchDTO));
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

		switch (usedDTO) {
		case "FaqDTO":
			count = dao.getFaqCount();
			break;
		case "FaqSearchDTO_and":
			count = dao.getFaqAndCount(faqSearchDTO);
			break;
		case "FaqSearchDTO_or":
			count = dao.getFaqOrCount(faqSearchDTO);
			break;
		}

		return getFaqPagingCmd(cPage);
	}

	// FAQ 보기로 이동
	@RequestMapping("faq_view.mcat")
	public ModelAndView getFaqViewCmd(HttpSession session, String faq_sq) {
		FaqDTO faqDTO = dao.getFaqView(faq_sq);

		session.setAttribute("faqDTO", faqDTO);

		return new ModelAndView("admin/faq/view");
	}
	
	
	/*////////////////////////////////// 기타 메소드 //////////////////////////////////*/

	
	// 쿠키
	public Cookie setCookie(String name, String value, int time) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(time);
		return cookie;
	}
	
}