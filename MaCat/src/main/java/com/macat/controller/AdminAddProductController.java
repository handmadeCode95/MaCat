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

import com.macat.dao.AdminAddProductDAOImpl;
import com.macat.dto.ImagesDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.ProductsDTO;
import com.macat.util.FileUploadUtil;

@Controller
@SessionAttributes("productForm")
public class AdminAddProductController {
	
	private final AdminAddProductDAOImpl adminProductDAOImpl;

	@Autowired
	public AdminAddProductController(AdminAddProductDAOImpl adminProductDAOImpl) {
		this.adminProductDAOImpl = adminProductDAOImpl;
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
		String prduct_sq = productsDTO.getPrduct_sq();
		
		Calendar cal = Calendar.getInstance();
		MultipartFile mainImg = productsDTO.getMain_img();
		MultipartFile subImg1 = productsDTO.getSub_img1();
		MultipartFile subImg2 = productsDTO.getSub_img2();
		MultipartFile subImg3 = productsDTO.getSub_img3();
		Map<String, List<ImagesDTO>> imgMap = new HashMap<String, List<ImagesDTO>>();
		List<ImagesDTO> imagesDTOs = new ArrayList<ImagesDTO>();
		
		String mainfileName = mainImg.getOriginalFilename();
		String mainfileType = mainfileName.substring(mainfileName.lastIndexOf("."), mainfileName.length());
		productsDTO.setMain_img_nm(cal.getTimeInMillis() + mainfileType);  
		
		String mainPath = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
		//이름바꾸고 mybatis Foreach구현 String mainPath = FileUpload.fileUpload(mainImg, path, productsDTO.getMain_img_nm());
		imagesDTOs.add(new ImagesDTO(mainPath, 0, 1, 0, prduct_sq));
		
		if (subImg1 != null && subImg1.getSize() > 0) {
			String subfileName1 = subImg1.getOriginalFilename();
			String subfileType1 = subfileName1.substring(subfileName1.lastIndexOf("."), subfileName1.length());
			productsDTO.setMain_img_nm(cal.getTimeInMillis() + subfileType1);  
			
			String path = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
			String subPath1 = FileUploadUtil.fileUpload(mainImg, path, productsDTO.getMain_img_nm());
			imagesDTOs.add(new ImagesDTO(subPath1, 1, 0, 0, prduct_sq));
		}
		if (subImg2 != null && subImg2.getSize() > 0) {
			String fileName = subImg2.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			productsDTO.setMain_img_nm(cal.getTimeInMillis() + fileType);  
			
			String path = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
			String subPath2 = FileUploadUtil.fileUpload(subImg2, path, productsDTO.getMain_img_nm());
			imagesDTOs.add(new ImagesDTO(subPath2, 1, 0, 0, prduct_sq));
		}
		if (subImg3 != null && subImg3.getSize() > 0) {
			String fileName = subImg3.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			productsDTO.setMain_img_nm(cal.getTimeInMillis() + fileType);  
			
			String path = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources/upload/" + mbersDTO.getMber_id();
			String subPath3 = FileUploadUtil.fileUpload(subImg3, path, productsDTO.getMain_img_nm());
			imagesDTOs.add(new ImagesDTO(subPath3, 1, 0, 0, prduct_sq));
		}
		
		imgMap.put("imgList", imagesDTOs);
		
		// 상품등록, 이미지등록
		//dao.insertProduct(productsDTO);
		
		
		sessionStatus.setComplete();
		return mv;
	}

}
