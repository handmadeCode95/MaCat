package com.macat.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.CategoryDAOImpl;
import com.macat.dao.MainDAOImpl;
import com.macat.dto.ProductsDTO;
import com.macat.util.CookieUtil;

@Controller
public class CategoryController {
	
	private final CategoryDAOImpl categoryDAOImpl;
	private final MainDAOImpl mainDAOImpl;

	@Autowired
	public CategoryController(CategoryDAOImpl categoryDAOImpl, MainDAOImpl mainDAOImpl) {
		this.categoryDAOImpl = categoryDAOImpl;
		this.mainDAOImpl = mainDAOImpl;
	}
	
	// 상품 페이지로 이동
	@GetMapping("product.mcat")
	public ModelAndView redirectProductPageCmd(ModelAndView mv,
			@CookieValue(required = false, name = "viewedProductSq1") String viewedProductSq1,
			@CookieValue(required = false, name = "viewedProductSq2") String viewedProductSq2,
			@CookieValue(required = false, name = "viewedProductSq3") String viewedProductSq3,
			@CookieValue(required = false, name = "viewedProductThumb1") String viewedProductThumb1,
			@CookieValue(required = false, name = "viewedProductThumb2") String viewedProductThumb2,
			@CookieValue(required = false, name = "viewedProductThumb3") String viewedProductThumb3,
			HttpServletResponse response, String prduct_sq, String prduct_thumb_nm) {
		mv.setViewName("product/product");

		// 조회수 증가
		if (categoryDAOImpl.updateProductViewCount(prduct_sq) < 1)
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

		ProductsDTO productsDTO = categoryDAOImpl.getProduct(prduct_sq);

		// 상품 총 적립 금액
		if (!productsDTO.getPrduct_save().isEmpty() && productsDTO.getPrduct_save() != "") {
			productsDTO.setPrduct_point(productsDTO.getPrduct_save());
		} else if (!productsDTO.getPrduct_save_pt().isEmpty() && Integer.parseInt(productsDTO.getPrduct_price()) > 99) {
			productsDTO.setPrduct_point(String.valueOf(Integer.parseInt(productsDTO.getPrduct_price()) * Integer.parseInt(productsDTO.getPrduct_save_pt()) / 100));
		} else {
			productsDTO.setPrduct_point(String.valueOf(0));
		}

		// 상품 할인된 가격
		if (!productsDTO.getPrduct_dc().isEmpty() && productsDTO.getPrduct_dc() != "") {
			productsDTO.setPrduct_dced_price(String.valueOf(Integer.parseInt(productsDTO.getPrduct_price()) - Integer.parseInt(productsDTO.getPrduct_dc())));
		} else if (!productsDTO.getPrduct_dc_pt().isEmpty() && Integer.parseInt(productsDTO.getPrduct_price()) > 99) {
			productsDTO.setPrduct_dced_price(String.valueOf(Integer.parseInt(productsDTO.getPrduct_price()) - (Integer.parseInt(productsDTO.getPrduct_price()) * Integer.parseInt(productsDTO.getPrduct_dc_pt()) / 100)));
		} else {
			productsDTO.setPrduct_dced_price(productsDTO.getPrduct_price());
		}

		// 상품 평점 반올림
		productsDTO.setPrduct_rating_round(String.valueOf(Math.round(Float.parseFloat(productsDTO.getPrduct_rating_avg()))));

		// 상품 색상
		List<String> list = categoryDAOImpl.getColors(prduct_sq);
		productsDTO.setColors(list.toArray(new String[list.size()]));

		mv.addObject("imagesDTO", categoryDAOImpl.getProductImages(prduct_sq));
		mv.addObject("more_product", mainDAOImpl.getProductsList(productsDTO.getCtgry_nm(), 1, 5));
		mv.addObject("review_cnt", categoryDAOImpl.getReviewsCount());
		mv.addObject("productsDTO", productsDTO);
		return mv;
	}

}
