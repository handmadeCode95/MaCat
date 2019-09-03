package com.macat.controller;

import java.io.File;
import java.io.IOException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;


import com.macat.dao.DAO;
import com.macat.dto.CartsDTO;
import com.macat.dto.DateDTO;
import com.macat.dto.FaqDTO;
import com.macat.dto.FaqSearchDTO;
import com.macat.dto.ImagesDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.MbersSearchDTO;
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.dto.ProductsDTO;
import com.macat.dto.QnaDTO;
import com.macat.dto.QnaSearchDTO;
import com.macat.service.CookieUtil;
import com.macat.service.DateUtil;
import com.macat.service.FileUpload;

import com.macat.service.Paging;
import com.macat.service.PriceUtil;

@Controller
public class MaCatController {

	private final DAO dao;

	@Autowired
	public MaCatController(DAO dao, Paging paging) {
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
	
	boolean overlap;

	// 장바구니 중복 체크
	@RequestMapping(value = "cart_overlap.mcat", method = RequestMethod.POST)
	@ResponseBody
	public boolean isOverlapCmd(@RequestBody Map<String, Object> requestMap) {
		overlap = dao.getCartOverlap(requestMap) > 0 ?true :false; 
		return overlap;
	}
	
	// 장바구니 수량 추가
	@RequestMapping(value = "add_cart.mcat", method = RequestMethod.POST)
	@ResponseBody
	public int addCartCmd(@RequestBody Map<String, Object> requestMap) {
		int result = 0;
		if (overlap) {
			result = dao.getCartAmtUpdate(requestMap);
		}else {
			result = dao.getAddCart(requestMap);
		}
		return result;

	}
	
	// 결제페이지로 이동
	@RequestMapping("order.mcat")
	public ModelAndView getOrderCmd(ModelAndView mv) {
		mv.setViewName("");
		return mv;
	}
	
	
	/*////////////////////////////////// 관리자 메인 //////////////////////////////////*/
	
	
	// 회원 정보 조회로 이동
	@RequestMapping("mbers_manager.mcat")
	public ModelAndView getMembersCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/members/manager");
		
		this.cPage = cPage;
		usedDTO = "MbersDTO";

		DateDTO dateDTO = new DateDTO();
		dateDTO.setToday(DateUtil.getToday());
		dateDTO.setOneWeekAgo(DateUtil.addDate(-7));
		dateDTO.setOneMonthAgo(DateUtil.addMonth(-1));
		dateDTO.setThreeMonthAgo(DateUtil.addMonth(-3));
		dateDTO.setSixMonthAgo(DateUtil.addMonth(-6));
		dateDTO.setOneYearAgo(DateUtil.addYear(-1));
		
		PageDTO pageDTO = new PageDTO(50);
		count = dao.getMbersCount();
		Paging.getPage(pageDTO, count, cPage);
		mv.addObject("mbers_count", count);

		mv.addObject("dateDTO", dateDTO);
		mv.addObject("mber_grad", dao.getMberGradList());
		mv.addObject("mbersDTO", dao.getMbersList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}

	// 공지사항 조회로 이동
	@RequestMapping("nots_manage.mcat")
	public ModelAndView getNoticesCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/notices/management");
		this.cPage = cPage;
		usedDTO = "NotsDTO";
		PageDTO pageDTO = new PageDTO();
		count = dao.getNotsCount();
		Paging.getPage(pageDTO, count, cPage);
		mv.addObject("notsDTO", dao.getNotsList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}

	// 고객 문의 관리로 이동
	@RequestMapping("qna_manage.mcat")
	public ModelAndView getQnaCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/qna/customer_manager");
		
		this.cPage = cPage;
		usedDTO = "QnaDTO";
		
		PageDTO pageDTO = new PageDTO();
		count = dao.getQnaCount();
		Paging.getPage(pageDTO, count, cPage);
		mv.addObject("qna_ctgries", dao.getQnaCtgriesList());
		mv.addObject("qnaDTO", dao.getQnaList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// FAQ 관리로 이동
	@RequestMapping("faq_manage.mcat")
	public ModelAndView getFaqCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/faq/management");
		
		this.cPage = cPage;
		usedDTO = "FaqDTO";
		
		PageDTO pageDTO = new PageDTO();
		count = dao.getFaqCount();
		Paging.getPage(pageDTO, count, cPage);
		mv.addObject("qna_ctgries", dao.getQnaCtgriesList());
		mv.addObject("faqDTO", dao.getFaqList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// 상품관리로 이동
	@RequestMapping("product_manage.mcat")
	public ModelAndView getPrductManageCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/product/product_manager");
		
		this.cPage = cPage;
		usedDTO = "ProductsDTO";
		
		return mv;
	}
	
	
	// 관리자 상품등록 상세페이지로 이동
	@RequestMapping("add_product.mcat")
	public ModelAndView getProductRegCmd(ModelAndView mv) {
		mv.setViewName("admin/product/add_product");
		return mv;
	}

	// 상세페이지 등록
	@RequestMapping(value = "product_reg.mcat", method = RequestMethod.POST)
	public ModelAndView getAddProductInfoCmd(ModelAndView mv, @ModelAttribute ProductsDTO productsDTO, HttpServletRequest request) {
		try {
			mv.setViewName("admin/product/reg");
			
		} catch (Exception e) {
		}
		return mv;
	}
	
	/*////////////////////////////////// 파일 업로드 //////////////////////////////////*/
	
	
	@RequestMapping(value = "file_upload.mcat", method = RequestMethod.POST)
	public ModelAndView getfileUploadCmd(ModelAndView mv, MultipartRequest multipartRequest, HttpServletRequest request) throws IOException{
		mv.setViewName("file_upload");
		MultipartFile imgfile = multipartRequest.getFile("Filedata");
		Calendar cal = Calendar.getInstance();
		String fileName = imgfile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String replaceName = cal.getTimeInMillis() + fileType;  
		
		String path = request.getSession().getServletContext().getRealPath("/")+File.separator+"resources/upload";
		FileUpload.fileUpload(imgfile, path, replaceName);
		mv.addObject("path", path);
		mv.addObject("filename", replaceName);
		return mv;
	}

	
	/*////////////////////////////////// 회원 정보 관리 //////////////////////////////////*/

	
	// 회원 정보 페이징
	@RequestMapping(value = "mbers_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMbersPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(50);

		Map<String, Object> map = new HashMap<String, Object>();

		Paging.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		map.put("mbers_count", count);

		
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

		Paging.getPage(pageDTO, count, null);
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
		PageDTO pageDTO = new PageDTO();
		Map<String, Object> map = new HashMap<String, Object>();

		Paging.getPage(pageDTO, count, cPage);
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
	@RequestMapping(value = "nots_search.mcat", method = RequestMethod.POST)
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

		Paging.getPage(pageDTO, count, null);
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
	@RequestMapping("nots_write.mcat")
	public ModelAndView getNotsWriteGoCmd(ModelAndView mv) {
		mv.setViewName("admin/notices/write");
		return mv;
	}

	// 공지사항 수정으로 이동
	@RequestMapping("nots_update.mcat")
	public ModelAndView getNotsUpdateGoCmd(ModelAndView mv) {
		mv.setViewName("admin/notices/update");
		return mv;
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
		PageDTO pageDTO = new PageDTO();
		Map<String, Object> map = new HashMap<String, Object>();

		Paging.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		switch (usedDTO) {
		case "QnaDTO":
			map.put("qnaDTO", dao.getQnaList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			qnaSearchDTO.setBegin(pageDTO.getBegin());
			qnaSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "QnaSearchDTO_and":
				map.put("qnaDTO", dao.getQnaAndSearch(qnaSearchDTO));
				break;
			case "QnaSearchDTO_or":
				map.put("qnaDTO", dao.getQnaOrSearch(qnaSearchDTO));
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
		PageDTO pageDTO = new PageDTO();

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

		Paging.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		qnaSearchDTO.setBegin(pageDTO.getBegin());
		qnaSearchDTO.setEnd(pageDTO.getEnd());
		this.qnaSearchDTO = qnaSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (qnaSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("qnaDTO", dao.getQnaAndSearch(qnaSearchDTO));
			break;
		case "or":
			map.put("qnaDTO", dao.getQnaOrSearch(qnaSearchDTO));
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
	public ModelAndView getQnaViewCmd(ModelAndView mv, HttpSession session, String qna_sq) {
		mv.setViewName("admin/qna/view");
		
		QnaDTO qnaDTO = dao.getQnaView(qna_sq);

		qnaDTO.setQna_view_cnt(qnaDTO.getQna_view_cnt() + 1);
		dao.getQnaRdcntUpdate(qnaDTO);

		session.setAttribute("qnaDTO", qnaDTO);

		return mv;
	}
	

	/*////////////////////////////////// FAQ 관리 //////////////////////////////////*/

	
	// FAQ 페이징
	@RequestMapping(value = "faq_paging.mcat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFaqPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO();
		Map<String, Object> map = new HashMap<String, Object>();

		Paging.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);

		switch (usedDTO) {
		case "FaqDTO":
			map.put("faqDTO", dao.getFaqList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			faqSearchDTO.setBegin(pageDTO.getBegin());
			faqSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "FaqSearchDTO_and":
				map.put("faqDTO", dao.getFaqAndSearch(faqSearchDTO));
				break;
			case "FaqSearchDTO_or":
				map.put("faqDTO", dao.getFaqOrSearch(faqSearchDTO));
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
		PageDTO pageDTO = new PageDTO();

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

		Paging.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		faqSearchDTO.setBegin(pageDTO.getBegin());
		faqSearchDTO.setEnd(pageDTO.getEnd());
		this.faqSearchDTO = faqSearchDTO; // 페이징을 위한 검색 기록 저장

		switch (faqSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("faqDTO", dao.getFaqAndSearch(faqSearchDTO));
			break;
		case "or":
			map.put("faqDTO", dao.getFaqOrSearch(faqSearchDTO));
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
	public ModelAndView getFaqViewCmd(ModelAndView mv, HttpSession session, String faq_sq) {
		mv.setViewName("admin/faq/view");
		session.setAttribute("faqDTO", dao.getFaqView(faq_sq));
		return mv;
	}
	
	/*////////////////////////////////// 마이 페이지 //////////////////////////////////*/
	
	// 구매후기 페이지 이동
	@RequestMapping("review.mcat")
	public ModelAndView getReviewCmd(ModelAndView mv) {
		mv.setViewName("member/review");
		return mv;
	}
	
	// 마이페이지 이동
	@RequestMapping("mypage.mcat")
	public ModelAndView getMyPageCmd(ModelAndView mv) {
		mv.setViewName("member/mypage");
		return mv;
	}
	
	// 마이페이지 - 주문내역관리 이동
	@RequestMapping("mypage_order_inquiry.mcat")
	public ModelAndView getOrderInquiryCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_order_inquiry");
		return mv;
	}
	
	// 마이페이지 - 프로필 관리 이동	
	
	// 마이페이지 - 찜목록 관리 이동
	@RequestMapping("mypage_wishlist.mcat")
	public ModelAndView getWishListCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_wishlist");
		return mv;
	}
	
	// 마이페이지 - 마일리지 이동
	
	// 마이페이지 - 게시물 관리 페이지 이동
	@RequestMapping("mypage_post_management.mcat")
	public ModelAndView getPostManageCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_post_management");
		return mv;
	}
	
	// 마이페이지 - 배송주소록 관리 이동
	@RequestMapping("mypage_deliveryAdress.mcat")
	public ModelAndView getDeliveryAdressCmd(ModelAndView mv) {
		mv.setViewName("member/mypage_deliveryAdress");
		return mv;
	}
	
}