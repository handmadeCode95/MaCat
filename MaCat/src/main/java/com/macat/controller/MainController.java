package com.macat.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;
import com.macat.dto.CartsDTO;
import com.macat.dto.CtgriesDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.PageDTO;
import com.macat.service.CookieUtil;
import com.macat.service.Paging;
import com.macat.service.PriceUtil;

@Controller
@SessionAttributes("ctgriesDTO")
public class MainController {
	
	private final DAO dao;

	@Autowired
	public MainController(DAO dao, Paging paging) {
		this.dao = dao;
	}
	
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	
	// 메인 페이지로 이동
	@RequestMapping("main.mcat")
	public ModelAndView getMainCmd(ModelAndView mv) {
		mv.setViewName("main");
		mv.addObject("ctgriesDTO", dao.getCategories());
		return mv;
	}

	// 로그인 페이지로 이동
	@RequestMapping("login.mcat")
	public ModelAndView getLoginCmd(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}

	// 회원가입 페이지로 이동
	@RequestMapping("join.mcat")
	public ModelAndView getJoinCmd(ModelAndView mv) {
		mv.setViewName("join");
		return mv;
	}

	// 로그인
	@RequestMapping(value = "login_ok.mcat", method = RequestMethod.POST)
	public ModelAndView getLoginOkCmd(ModelAndView mv, HttpSession session, HttpServletResponse response, MbersDTO mbersDTO) {
		response.addCookie(CookieUtil.setCookie("cart", null, 0)); // 장바구니 쿠키 삭제 <<개선필요

		mbersDTO = dao.getLogin(mbersDTO);
		if (mbersDTO != null) {
			mv.setViewName("main");
			session.setAttribute("loginData", mbersDTO);
			dao.getLoginRecord(mbersDTO);
			return mv;
		} else {
			mv.setViewName("login");
			mv.addObject("loginData", "fail");
			return mv;
		}
	}

	@RequestMapping("logout.mcat")
	public ModelAndView getLogout(ModelAndView mv, HttpSession session) {
		mv.setViewName("main");
		session.removeAttribute("loginData");
		return mv;
	}

	// 회원가입
	@RequestMapping(value = "mber_join.mcat", method = RequestMethod.POST)
	public ModelAndView getJoinCmd(ModelAndView mv, MbersDTO mbersDTO) {
		mv.setViewName("redirect:login.mcat");
		// 테스트맨 생성기
		// mbersDTO.setMber_email(mbersDTO.getMber_email() +
		// mbersDTO.getMber_email_end());
		// String id = mbersDTO.getMber_id();
		// for (int i = 1; i <= 100; i++) {
		// mbersDTO.setMber_id(id + i);
		// dao.getJoin(mbersDTO);
		// }

		mbersDTO.setMber_email(mbersDTO.getMber_email() + mbersDTO.getMber_email_end());
		dao.getJoin(mbersDTO);
		return mv;
	}

	// 관리자 main으로 이동
	@RequestMapping("admin.mcat")
	public ModelAndView getAdminMainCmd(ModelAndView mv) {
		mv.setViewName("admin/main");
		return mv;
	}

	// 카테고리 페이지로 이동
	@RequestMapping("category.mcat")
	public ModelAndView getCategoryCmd(ModelAndView mv, String cPage, int ctgry_group, int ctgry_level,
			String ctgry_nm) {
		mv.setViewName("product/category");

		this.cPage = cPage;

		PageDTO pageDTO = new PageDTO(20);

		if (ctgry_level > 0) {
			count = dao.getProductsCount(ctgry_nm);
			Paging.getPage(pageDTO, count, cPage);
			mv.addObject("productsDTO", dao.getProductsList(ctgry_nm, pageDTO.getBegin(), pageDTO.getEnd()));
		} else {
			count = dao.getProductsCount(ctgry_group);
			Paging.getPage(pageDTO, count, cPage);
			mv.addObject("productsDTO", dao.getProductsList(ctgry_group, pageDTO.getBegin(), pageDTO.getEnd()));
		}

		mv.addObject("ctgry_group", ctgry_group);
		mv.addObject("ctgry_level", ctgry_level);
		mv.addObject("ctgry_nm", ctgry_nm);
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}

	// 장바구니로 이동
	@RequestMapping("cart.mcat")
	public ModelAndView getCartCmd(ModelAndView mv, String mber_sq) {
		mv.setViewName("cart");
		if (mber_sq != null) {
			List<CartsDTO> cartList = dao.getCarts(mber_sq);
			int totalPrice = 0;
			int totalDC = 0;
			int mostDlvyPrice = 0;

			for (CartsDTO i : cartList) {
				int dc = PriceUtil.getDc(i.getPrduct_price(), i.getPrduct_dc(), i.getPrduct_dc_pt());
				int price = i.getPrduct_price();

				totalDC += dc;
				totalPrice += price;
				i.setPrduct_dced_price(price - dc);

				if (mostDlvyPrice < i.getPrduct_dlvy_price()) {
					mostDlvyPrice = i.getPrduct_dlvy_price();
				}
			}

			if (totalPrice - totalDC > 50000) {
				for (CartsDTO i : cartList) {
					i.setPrduct_dlvy_price(0);
				}
				mostDlvyPrice = 0;
			}

			mv.addObject("totalPrice", totalPrice);
			mv.addObject("totalDC", totalDC);
			mv.addObject("mostDlvyPrice", mostDlvyPrice);
			mv.addObject("cartsDTO", cartList);
		}
		return mv;
	}

}
