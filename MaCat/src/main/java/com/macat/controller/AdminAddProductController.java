package com.macat.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.AdminAddProductDAO;
import com.macat.dto.ImagesDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.ProductsDTO;
import com.macat.util.FileUploadUtil;

@Controller
@SessionAttributes("productForm")
public class AdminAddProductController {
	
	private final AdminAddProductDAO adminProductDAO;

	@Autowired
	public AdminAddProductController(AdminAddProductDAO adminProductDAO) {
		this.adminProductDAO = adminProductDAO;
	}
	
	
	// 관리자 상품등록 상세페이지로 이동
	@GetMapping("add_product.mcat")
	public ModelAndView redirectProductRegCmd(ModelAndView mv) {
		mv.setViewName("admin/product/add_product");
		return mv;
	}
	
	// 상세페이지 추가로 이동
	@PostMapping("product_reg.mcat")
	public ModelAndView getAddProductInfoCmd(ModelAndView mv, ProductsDTO productsDTO) {
		mv.setViewName("admin/product/reg");
		mv.addObject("productForm", productsDTO);
		return mv;
	}
	
	// 상품 추가 완료
	@PostMapping("product_reg_ok.mcat")
	public ModelAndView getAddProductInfoOkCmd(ModelAndView mv, SessionStatus sessionStatus, HttpServletRequest request, 
			@SessionAttribute("productForm") ProductsDTO productsDTO, @SessionAttribute("loginData") MbersDTO mbersDTO,
			String prduct_cn) throws IOException {
		mv.setViewName("main");
		
		productsDTO.setPrduct_cn(prduct_cn);
		productsDTO.setPrduct_ctgry_group(adminProductDAO.getCategoryGroup(productsDTO.getCtgry_nm()));
		
		Calendar cal = Calendar.getInstance();
		MultipartFile mainImg = productsDTO.getMain_img();
		MultipartFile subImg1 = productsDTO.getSub_img1();
		MultipartFile subImg2 = productsDTO.getSub_img2();
		MultipartFile subImg3 = productsDTO.getSub_img3();
		List<ImagesDTO> imagesDTOs = new ArrayList<ImagesDTO>();
		
		String mainfileName = mainImg.getOriginalFilename();
		String mainfileType = mainfileName.substring(mainfileName.lastIndexOf("."), mainfileName.length());
		productsDTO.setMain_img_nm(cal.getTimeInMillis() + mainfileType);
		
		String mainPath = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
		FileUploadUtil.fileUpload(mainImg, mainPath, productsDTO.getMain_img_nm());
		
		productsDTO.setPrduct_thumb_nm(mbersDTO.getMber_id() + "/" + productsDTO.getMain_img_nm());
		adminProductDAO.insertProduct(productsDTO);
		String prduct_sq = productsDTO.getPrduct_sq();
		System.out.println(prduct_sq);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prduct_sq", prduct_sq);
		map.put("colors", productsDTO.getColors());
		adminProductDAO.insertColors(map);
		
		imagesDTOs.add(new ImagesDTO(mbersDTO.getMber_id() + "/" + productsDTO.getMain_img_nm(), 0, 1, 0, prduct_sq));
		
		if (subImg1 != null && subImg1.getSize() > 0) {
			String subfileName1 = subImg1.getOriginalFilename();
			String subfileType1 = subfileName1.substring(subfileName1.lastIndexOf("."), subfileName1.length());
			productsDTO.setSub_img1_nm(cal.getTimeInMillis() + subfileType1);  
			
			String subPath1 = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
			FileUploadUtil.fileUpload(mainImg, subPath1, productsDTO.getMain_img_nm());
			imagesDTOs.add(new ImagesDTO(mbersDTO.getMber_id() + "/" + productsDTO.getSub_img1_nm(), 1, 0, 0, prduct_sq));
		}
		if (subImg2 != null && subImg2.getSize() > 0) {
			String fileName = subImg2.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			productsDTO.setSub_img2_nm(cal.getTimeInMillis() + fileType);
			
			String subPath2 = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
			FileUploadUtil.fileUpload(subImg2, subPath2, productsDTO.getMain_img_nm());
			imagesDTOs.add(new ImagesDTO(mbersDTO.getMber_id() + "/" + productsDTO.getSub_img2_nm(), 1, 0, 0, prduct_sq));
		}
		if (subImg3 != null && subImg3.getSize() > 0) {
			String fileName = subImg3.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			productsDTO.setSub_img3_nm(cal.getTimeInMillis() + fileType);  
			
			String subPath3 = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
			FileUploadUtil.fileUpload(subImg3, subPath3, productsDTO.getMain_img_nm());
			imagesDTOs.add(new ImagesDTO(mbersDTO.getMber_id() + "/" + productsDTO.getSub_img3_nm(), 1, 0, 0, prduct_sq));
		}
		
		adminProductDAO.insertImages(imagesDTOs);
		
		sessionStatus.setComplete();
		return mv;
	}

}
