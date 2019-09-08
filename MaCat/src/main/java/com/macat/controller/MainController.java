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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.MainDAOImpl;
import com.macat.dto.CartsDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.PageDTO;
import com.macat.util.FileUploadUtil;
import com.macat.util.CookieUtil;
import com.macat.util.PagingUtil;
import com.macat.util.PriceUtil;

@Controller
@SessionAttributes("ctgriesDTO")
public class MainController {
	
	private final MainDAOImpl mainDAOImpl;

	@Autowired
	public MainController(MainDAOImpl mainDAOImpl) {
		this.mainDAOImpl = mainDAOImpl;
	}
	
	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	
	// 메인 페이지로 이동
	@GetMapping("main.mcat")
	public ModelAndView redirectMainPageCmd(ModelAndView mv) {
		mv.setViewName("main");
		mv.addObject("ctgriesDTO", mainDAOImpl.getCategories());
		return mv;
	}

	// 로그인 페이지로 이동
	@GetMapping("login.mcat")
	public ModelAndView redirectLoginPageCmd(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}

	// 회원가입 페이지로 이동
	@GetMapping("join.mcat")
	public ModelAndView redirectJoinPageCmd(ModelAndView mv) {
		mv.setViewName("join");
		return mv;
	}

	// 로그인
	@PostMapping("login_ok.mcat")
	public ModelAndView loginCmd(ModelAndView mv, HttpSession session, HttpServletResponse response, MbersDTO mbersDTO) {
		response.addCookie(CookieUtil.setCookie("cart", null, 0)); // 장바구니 쿠키 삭제 <<개선필요

		mbersDTO = mainDAOImpl.login(mbersDTO);
		if (mbersDTO != null) {
			mv.setViewName("main");
			session.setAttribute("loginData", mbersDTO);
			mainDAOImpl.updateLoginRecord(mbersDTO);
			return mv;
		} else {
			mv.setViewName("login");
			mv.addObject("loginData", "fail");
			return mv;
		}
	}

	@GetMapping("logout.mcat")
	public ModelAndView logoutCmd(ModelAndView mv, HttpSession session) {
		mv.setViewName("main");
		session.removeAttribute("loginData");
		return mv;
	}

	// 회원가입
	@PostMapping("mber_join.mcat")
	public ModelAndView joinCmd(ModelAndView mv, MbersDTO mbersDTO) {
		mv.setViewName("redirect:login.mcat");
		// 테스트맨 생성기
		// mbersDTO.setMber_email(mbersDTO.getMber_email() +
		// mbersDTO.getMber_email_end());
		// String id = mbersDTO.getMber_id();
		// for (int i = 1; i <= 100; i++) {
		// mbersDTO.setMber_id(id + i);
		// mainDAOImpl.getJoin(mbersDTO);
		// }

		mbersDTO.setMber_email(mbersDTO.getMber_email() + mbersDTO.getMber_email_end());
		mainDAOImpl.insertMember(mbersDTO);
		return mv;
	}

	// 관리자 main으로 이동
	@GetMapping("admin.mcat")
	public ModelAndView redirectAdminMainPageCmd(ModelAndView mv) {
		mv.setViewName("admin/main");
		return mv;
	}

	// 카테고리 페이지로 이동
	@GetMapping("category.mcat")
	public ModelAndView redirectCategoryCmd(ModelAndView mv, String cPage, int ctgry_group, int ctgry_level,
			String ctgry_nm) {
		mv.setViewName("product/category");

		this.cPage = cPage;

		PageDTO pageDTO = new PageDTO(20);

		if (ctgry_level > 0) {
			count = mainDAOImpl.getProductCount(ctgry_nm);
			PagingUtil.getPage(pageDTO, count, cPage);
			mv.addObject("productsDTO", mainDAOImpl.getProductsList(ctgry_nm, pageDTO.getBegin(), pageDTO.getEnd()));
		} else {
			count = mainDAOImpl.getProductCount(ctgry_group);
			PagingUtil.getPage(pageDTO, count, cPage);
			mv.addObject("productsDTO", mainDAOImpl.getProductsList(ctgry_group, pageDTO.getBegin(), pageDTO.getEnd()));
		}

		mv.addObject("ctgry_group", ctgry_group);
		mv.addObject("ctgry_level", ctgry_level);
		mv.addObject("ctgry_nm", ctgry_nm);
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}

	// 장바구니로 이동
	@GetMapping("cart.mcat")
	public ModelAndView redirectCartCmd(ModelAndView mv, String mber_sq) {
		mv.setViewName("cart");
		if (mber_sq != null) {
			List<CartsDTO> cartList = mainDAOImpl.getCarts(mber_sq);
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
	
	// 스마트에디터2 파일 업로드
	@PostMapping("file_upload.mcat")
	public ModelAndView fileUploadCmd(ModelAndView mv, MultipartRequest multipartRequest, HttpServletRequest request,
			@SessionAttribute("loginData") MbersDTO mbersDTO) throws IOException{
		mv.setViewName("file_upload");
		MultipartFile imgfile = multipartRequest.getFile("Filedata");
		Calendar cal = Calendar.getInstance();
		String fileName = imgfile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String replaceName = cal.getTimeInMillis() + fileType;  
		
		String path = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
		FileUploadUtil.fileUpload(imgfile, path, replaceName);
		mv.addObject("path", path);
		mv.addObject("filename", replaceName);
		return mv;
	}

}
