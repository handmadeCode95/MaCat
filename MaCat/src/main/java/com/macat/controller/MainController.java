package com.macat.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;
import com.macat.dto.CartsDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.PageDTO;
import com.macat.service.CookieUtil;
import com.macat.service.FileUpload;
import com.macat.service.Paging;
import com.macat.service.PriceUtil;

@Controller
@RequestMapping("*.mcat")
public class MainController {
	
	@Autowired
	private DAO dao;
	
	// 메인 페이지로 이동
	@GetMapping("main.mcat")
	public ModelAndView getMainCmd(HttpSession session) {
		session.setAttribute("ctgriesDTO", dao.getCategories());
		return new ModelAndView("main");
	}
	
	// 로그인 페이지로 이동
	@GetMapping("login.mcat")
	public ModelAndView getLoginCmd() {
		return new ModelAndView("login");
	}
	
	// 로그인
	@PostMapping("loginOk.mcat")
	public ModelAndView getLoginOkCmd(HttpSession session, MbersDTO mbersDTO, HttpServletResponse response) {
		ModelAndView mv;
		response.addCookie(CookieUtil.setCookie("cart", null, 0)); // 장바구니 쿠키 삭제

		MbersDTO loginMber = dao.getLogin(mbersDTO);
		if (loginMber != null) {
			mv = new ModelAndView("main");
			session.setAttribute("loginData", loginMber);
			dao.getLoginRecord(mbersDTO);
			return mv;
		} else {
			mv = new ModelAndView("login");
			mv.addObject("loginData", "fail");
			return mv;
		}
	}
	
	// 로그아웃
	@GetMapping("logout.mcat")
	public ModelAndView getLogout(HttpSession session) {
		session.removeAttribute("loginData");
		return new ModelAndView("main");
	}

	// 회원가입 페이지로 이동
	@GetMapping("join.mcat")
	public ModelAndView getJoinCmd() {
		return new ModelAndView("join");
	}
	
	// 회원가입
	@PostMapping("joinOk.mcat")
	public ModelAndView getJoinCmd(MbersDTO mbersDTO) {
		// 테스트맨 생성기
		// mbersDTO.setMber_email(mbersDTO.getMber_email() +
		// mbersDTO.getMber_email_end());
		// String id = mbersDTO.getMber_id();
		// for (int i = 1; i <= 100; i++) {
		//	 mbersDTO.setMber_id(id + i);
		//	 dao.getJoin(mbersDTO);
		// }

		mbersDTO.setMber_email(mbersDTO.getMber_email() + mbersDTO.getMber_email_end());
		dao.getJoin(mbersDTO);
		return new ModelAndView("redirect:login.mcat");
	}
	
	// 관리자 센터로 이동 <임시>
	@GetMapping("admin.mcat")
	public ModelAndView getAdminMainCmd() {
		return new ModelAndView("admin/main");
	}
	
	// 카테고리 페이지로 이동
	@GetMapping("category.mcat")
	public ModelAndView getCategoryCmd(String cPage, int ctgry_group, int ctgry_level, String ctgry_nm) {
		Paging.cPage = cPage;

		ModelAndView mv = new ModelAndView("product/category");
		PageDTO pageDTO = new PageDTO(20);

		if (ctgry_level > 0) {
			Paging.count = dao.getProductsCount(ctgry_nm);
			Paging.setPage(pageDTO, Paging.count, cPage);
			mv.addObject("productsDTO", dao.getProductsList(ctgry_nm, pageDTO.getBegin(), pageDTO.getEnd()));
		} else {
			Paging.count = dao.getProductsCount(ctgry_group);
			Paging.setPage(pageDTO, Paging.count, cPage);
			mv.addObject("productsDTO", dao.getProductsList(ctgry_group, pageDTO.getBegin(), pageDTO.getEnd()));
		}

		mv.addObject("ctgry_group", ctgry_group);
		mv.addObject("ctgry_level", ctgry_level);
		mv.addObject("ctgry_nm", ctgry_nm);
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// 장바구니로 이동
	@GetMapping("cart.mcat")
	public ModelAndView getCartCmd(String mber_sq) {
		ModelAndView mv = new ModelAndView("cart");
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
	
	// 파일 업로드
	@PostMapping("fileUpload.mcat")
	public ModelAndView getfileUploadCmd(MultipartRequest multipartRequest, HttpServletRequest request) throws IOException{
		ModelAndView mv = new ModelAndView("file_upload");
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

}
