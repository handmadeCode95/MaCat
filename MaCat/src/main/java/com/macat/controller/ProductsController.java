package com.macat.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;
import com.macat.dto.ProductsDTO;
import com.macat.service.CookieUtil;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private DAO dao;
	public DAO getDao() {return dao;}
	public void setDao(DAO dao) {this.dao = dao;}
	
	// 상품 페이지로 이동
	@GetMapping("/view.mcat")
	public ModelAndView getProductCmd(@CookieValue(required = false, name = "viewedProductSq1") String viewedProductSq1,
			@CookieValue(required = false, name = "viewedProductSq2") String viewedProductSq2,
			@CookieValue(required = false, name = "viewedProductSq3") String viewedProductSq3,
			@CookieValue(required = false, name = "viewedProductThumb1") String viewedProductThumb1,
			@CookieValue(required = false, name = "viewedProductThumb2") String viewedProductThumb2,
			@CookieValue(required = false, name = "viewedProductThumb3") String viewedProductThumb3,
			HttpServletResponse response, String prduct_sq, String prduct_thumb_nm) {
		ModelAndView mv = new ModelAndView("product/product");

		// 조회수 증가
		if (dao.getProductViewCntUp(prduct_sq) < 1)
			System.out.println("조회수증가실패");

		// 최근 본 상품 쿠키에 추가. 3개 이상이면 첫 상품 삭제, 중복 불가
		if (!prduct_sq.equals(viewedProductSq1) && !prduct_sq.equals(viewedProductSq2)
				&& !prduct_sq.equals(viewedProductSq3)) {
			if (viewedProductSq1 != null) {
				if (viewedProductSq2 != null) {
					if (viewedProductSq3 != null) {
						response.addCookie(CookieUtil.setCookie("viewedProductSq1", viewedProductSq2, 60 * 60 * 24));
						response.addCookie(
								CookieUtil.setCookie("viewedProductThumb1", viewedProductThumb2, 60 * 60 * 24));
						response.addCookie(CookieUtil.setCookie("viewedProductSq2", viewedProductSq3, 60 * 60 * 24));
						response.addCookie(
								CookieUtil.setCookie("viewedProductThumb2", viewedProductThumb3, 60 * 60 * 24));
					}
					response.addCookie(CookieUtil.setCookie("viewedProductSq3", prduct_sq, 60 * 60 * 24));
					response.addCookie(CookieUtil.setCookie("viewedProductThumb3", prduct_thumb_nm, 60 * 60 * 24));
				} else {
					response.addCookie(CookieUtil.setCookie("viewedProductSq2", prduct_sq, 60 * 60 * 24));
					response.addCookie(CookieUtil.setCookie("viewedProductThumb2", prduct_thumb_nm, 60 * 60 * 24));
				}
			} else {
				response.addCookie(CookieUtil.setCookie("viewedProductSq1", prduct_sq, 60 * 60 * 24));
				response.addCookie(CookieUtil.setCookie("viewedProductThumb1", prduct_thumb_nm, 60 * 60 * 24));
			}
		}

		ProductsDTO productsDTO = dao.getProduct(prduct_sq);

		// 상품 총 적립 금액
		if (productsDTO.getPrduct_save() > 0) {
			productsDTO.setPrduct_point(productsDTO.getPrduct_save());
		} else if (productsDTO.getPrduct_save_pt() > 0 && productsDTO.getPrduct_price() > 99) {
			productsDTO.setPrduct_point(productsDTO.getPrduct_price() * productsDTO.getPrduct_save_pt() / 100);
		} else {
			productsDTO.setPrduct_point(0);
		}

		// 상품 할인된 가격
		if (productsDTO.getPrduct_dc() > 0) {
			productsDTO.setPrduct_dced_price(productsDTO.getPrduct_price() - productsDTO.getPrduct_dc());
		} else if (productsDTO.getPrduct_dc_pt() > 0 && productsDTO.getPrduct_price() > 99) {
			productsDTO.setPrduct_dced_price(productsDTO.getPrduct_price()
					- (productsDTO.getPrduct_price() * productsDTO.getPrduct_dc_pt() / 100));
		} else {
			productsDTO.setPrduct_dced_price(productsDTO.getPrduct_price());
		}

		// 상품 평점 반올림
		productsDTO.setPrduct_rating_round(Math.round(productsDTO.getPrduct_rating_avg()));

		// 상품 색상
		productsDTO.setColors(dao.getColors(prduct_sq));

		mv.addObject("imagesDTO", dao.getProductImages(prduct_sq));
		mv.addObject("more_product", dao.getProductsList(productsDTO.getCtgry_nm(), 1, 5));
		mv.addObject("review_cnt", dao.getReviewsCount());
		mv.addObject("productsDTO", productsDTO);
		return mv;
	}

	/*
	 * # 추가해야할것 - 좋아요 버튼 - 상품 정렬 버튼
	 */
	
	// 장바구니 중복 체크
	@PostMapping("/overlap.mcat")
	@ResponseBody
	public boolean isOverlapCmd(@RequestBody Map<String, Object> requestMap) {
		return dao.getCartOverlap(requestMap) > 0 ? true : false;
	}

	
	// 장바구니 수량 추가
	@PostMapping("/add.mcat")
	@ResponseBody
	public int addCartCmd(@RequestBody Map<String, Object> requestMap) {
		int result = 0;
		if ((boolean)requestMap.remove("overlap")) {
			result = dao.getCartAmtUpdate(requestMap);
		} else {
			result = dao.getAddCart(requestMap);
		}
		return result;

	}

}
