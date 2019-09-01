package com.macat.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.DAO;
import com.macat.dto.ImagesDTO;
import com.macat.dto.PageDTO;
import com.macat.dto.ProductsDTO;
import com.macat.service.Paging;

@Controller
@RequestMapping("admin/products/*.mcat")
public class AdmimProductsController extends Paging {
	
	@Autowired
	private DAO dao;
	
	// 상품관리로 이동
	@GetMapping("manager.mcat")
	public ModelAndView getPrductManageCmd(String cPage) {
		this.cPage = cPage;
		usedDTO = "ProductsDTO";
		ModelAndView mv = new ModelAndView("admin/product/product_manager");
		PageDTO pageDTO = new PageDTO();

		return mv;
	}

	// 관리자 상품등록 상세페이지로 이동
	@GetMapping("add.mcat")
	public ModelAndView getProductRegCmd() {
		return new ModelAndView("admin/product/add_product");
	}

	// 상품 등록
	@PostMapping("reg.mcat")
	public ModelAndView getAddProductInfoCmd(@ModelAttribute ProductsDTO productsDTO, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");

			ImagesDTO imagesDTO = new ImagesDTO();
			Map<String, MultipartFile> map = new HashMap<String, MultipartFile>();
			map.put("main_img", productsDTO.getMain_img());
			map.put("sub_img1", productsDTO.getSub_img1());
			map.put("sub_img2", productsDTO.getSub_img2());
			map.put("sub_img3", productsDTO.getSub_img3());

			for (String i : map.keySet()) {
				if (map.get(i).isEmpty()) {
					switch (i) {
					case "main_img":
						productsDTO.setMain_img_nm("");
						break;
					case "sub_img1":
						productsDTO.setSub_img1_nm("");
						break;
					case "sub_img2":
						productsDTO.setSub_img2_nm("");
						break;
					case "sub_img3":
						productsDTO.setSub_img3_nm("");
						break;
					}

				} else {
					imagesDTO.setImg_thumb_fl(1);
					imagesDTO.setImg_body_fl(0);
					imagesDTO.setPrduct_sq(productsDTO.getPrduct_sq());
					imagesDTO.setImg_main_fl(0);
					switch (i) {
					case "main_img":
						productsDTO.setMain_img_nm(productsDTO.getMain_img().getOriginalFilename());
						imagesDTO.setImg_ord(1);
						imagesDTO.setImg_main_fl(1);
						imagesDTO.setImg_nm(productsDTO.getMain_img_nm());
						break;
					case "sub_img1":
						productsDTO.setSub_img1_nm(productsDTO.getSub_img1().getOriginalFilename());
						imagesDTO.setImg_ord(2);
						imagesDTO.setImg_nm(productsDTO.getSub_img1_nm());
						break;
					case "sub_img2":
						productsDTO.setSub_img2_nm(productsDTO.getSub_img2().getOriginalFilename());
						imagesDTO.setImg_ord(3);
						imagesDTO.setImg_nm(productsDTO.getSub_img2_nm());
						break;
					case "sub_img3":
						productsDTO.setSub_img3_nm(productsDTO.getSub_img3().getOriginalFilename());
						imagesDTO.setImg_ord(4);
						imagesDTO.setImg_nm(productsDTO.getSub_img3_nm());
						break;
					}
				}
				switch (i) {
				case "main_img":
					if (dao.getAddProduct(productsDTO) > 0) {
						map.get(i).transferTo(new File(path + "/" + productsDTO.getMain_img_nm()));
					}
					break;
				case "sub_img1":
					if (dao.getAddProduct(productsDTO) > 0) {
						map.get(i).transferTo(new File(path + "/" + productsDTO.getSub_img1_nm()));
					}
					break;
				case "sub_img2":
					if (dao.getAddProduct(productsDTO) > 0) {
						map.get(i).transferTo(new File(path + "/" + productsDTO.getSub_img2_nm()));
					}
					break;
				case "sub_img3":
					if (dao.getAddProduct(productsDTO) > 0) {
						map.get(i).transferTo(new File(path + "/" + productsDTO.getSub_img3_nm()));
					}
					break;
				}

				dao.getAddImg(imagesDTO);
			}

		} catch (Exception e) {
			
		}
		return new ModelAndView("admin/product/reg");
	}

}
