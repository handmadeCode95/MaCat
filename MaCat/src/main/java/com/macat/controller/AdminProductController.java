package com.macat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.AdminProductManagementDAO;
import com.macat.dto.AdminSearchDTO;
import com.macat.dto.DateDTO;
import com.macat.dto.FaqSearchDTO;
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.dto.ProductsDTO;
import com.macat.dto.ProductsSearchDTO;
import com.macat.dto.QnaSearchDTO;
import com.macat.util.DateCalculateUtil;
import com.macat.util.PagingUtil;

@Controller
public class AdminProductController {
	
	private final AdminProductManagementDAO adminProductManagementDAO;

	@Autowired
	public AdminProductController(AdminProductManagementDAO adminProductManagementDAO) {
		this.adminProductManagementDAO = adminProductManagementDAO;
	}

	// 페이징을 위한 회원 정보 검색 기록
	private NotsSearchDTO notsSearchDTO;
	private QnaSearchDTO qnaSearchDTO;
	private FaqSearchDTO faqSearchDTO;
	private ProductsSearchDTO productsSearchDTO;

	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	
	// 상품관리로 이동
	@GetMapping("product_manage.mcat")
	public ModelAndView redirectProductManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/product/product_manager");
		
		this.cPage = cPage;
		usedDTO = "ProductsDTO";
		
		DateDTO dateDTO = new DateDTO(); 
		dateDTO.setToday(DateCalculateUtil.getToday()); 
		dateDTO.setOneWeekAgo(DateCalculateUtil.addDate(-7)); 
		dateDTO.setOneMonthAgo(DateCalculateUtil.addMonth(-1)); 
		dateDTO.setThreeMonthAgo(DateCalculateUtil.addMonth(-3)); 
		dateDTO.setSixMonthAgo(DateCalculateUtil.addMonth(-6)); 
		dateDTO.setOneYearAgo(DateCalculateUtil.addYear(-1)); 
		 
		PageDTO pageDTO = new PageDTO(50); 
		count = adminProductManagementDAO.getAdminCount(); 
		PagingUtil.getPage(pageDTO, count, cPage); 
		mv.addObject("prducts_count", count);
		 
		mv.addObject("dateDTO", dateDTO); 
		mv.addObject("productsDTO", adminProductManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd())); 
		mv.addObject("pageDTO", pageDTO); 
		
		return mv;
	}
	
	// 상품정보 페이징
	@PostMapping("prducts_paging.mcat")
	@ResponseBody
	public Map<String, Object> getProductsPageDTOCmd(@RequestBody String cPage){
		
		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(50);	
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);
		map.put("prducts_count", count);
		
		switch (usedDTO) {
		case "ProductsDTO" :
			map.put("productsDTO", adminProductManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			productsSearchDTO.setBegin(pageDTO.getBegin());
			productsSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "ProductsSearchDTO_and":
				map.put("productsDTO", adminProductManagementDAO.getAndSearch(productsSearchDTO));
				break;
			case "ProductsSearchDTO_or":
				map.put("productsDTO", adminProductManagementDAO.getOrSearch(productsSearchDTO));
				break;
			}
		}
		return map;
	}
	
	// 상품 검색
	@PostMapping("products_search.mcat")
	@ResponseBody
	public Map<String, Object> getProductsSearchCmd(@RequestBody ProductsSearchDTO productsSearchDTO){
		
		if(productsSearchDTO.getPrduct_dlvy_price_start() != null)
			productsSearchDTO.setPrduct_dlvy_price_start(productsSearchDTO.getPrduct_dlvy_price_start());
		if(productsSearchDTO.getPrduct_dlvy_price_end() != null)
			productsSearchDTO.setPrduct_dlvy_price_end(productsSearchDTO.getPrduct_dlvy_price_end());
		if(productsSearchDTO.getPrduct_reg_dt_start() != null)
			productsSearchDTO.setPrduct_reg_dt_start(productsSearchDTO.getPrduct_reg_dt_start() + " 00:00:00");
		if(productsSearchDTO.getPrduct_reg_dt_end() != null)
			productsSearchDTO.setPrduct_reg_dt_end(productsSearchDTO.getPrduct_reg_dt_end() + " 23:59:59");
		if(productsSearchDTO.getPrduct_price_start() != null)
			productsSearchDTO.setPrduct_price_start(productsSearchDTO.getPrduct_price_start());
		if(productsSearchDTO.getPrduct_price_end() != null)
			productsSearchDTO.setPrduct_price_end(productsSearchDTO.getPrduct_price_end());
		if(productsSearchDTO.getPrduct_dc_start() != null)
			productsSearchDTO.setPrduct_dc_start(productsSearchDTO.getPrduct_dc_start());
		if(productsSearchDTO.getPrduct_dc_end() != null)
			productsSearchDTO.setPrduct_dc_end(productsSearchDTO.getPrduct_dc_end());
		
		Map<String, Object> map = new HashMap<String, Object>();

		PageDTO pageDTO = new PageDTO(50);
		
		switch(productsSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "ProductsSearchDTO_and";
			count = adminProductManagementDAO.getAndCount(productsSearchDTO);
			break;
		case "or":
			usedDTO = "ProductsSearchDTO_or";
			count = adminProductManagementDAO.getOrCount(productsSearchDTO);
			break;
		}
		
		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);
		
		productsSearchDTO.setBegin(pageDTO.getBegin());
		productsSearchDTO.setEnd(pageDTO.getEnd());
		this.productsSearchDTO = productsSearchDTO; // 페이징용 검색기록 저장
		
		switch(productsSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("productsDTO", adminProductManagementDAO.getAndSearch(productsSearchDTO));
			break;
		case "or":
			map.put("productsDTO", adminProductManagementDAO.getOrSearch(productsSearchDTO));
			break;
		}		
		return map;
	}
	
	// 상품정보수정 (페이지 이동)
	@GetMapping("products_update_page.mcat")
	public ModelAndView getProductUpdatePageCmd(ModelAndView mv, String prduct_sq) {
		mv.setViewName("admin/product/add_product");
		mv.addObject("productsDTO", adminProductManagementDAO.getProduct(prduct_sq));
		mv.addObject("url", "product_update_page");
		return mv;
	}

	// 상품 정보 수정 : 관리자 페이지 내부
	@PostMapping("products_update.mcat")
	@ResponseBody
	public Map<String, Object> getProductsUpdateCmd(@RequestBody Map<String, List<ProductsDTO>> products){
		for (String i : products.keySet()) {
			for (ProductsDTO j : products.get(i)) {
				adminProductManagementDAO.getProductsUpdate(j);
			}
		}
		return getProductsPageDTOCmd(cPage);		
	}
	
	// 상품 삭제
		@PostMapping("products_delete.mcat")
		@ResponseBody
		public Map<String, Object> getProductsDeleteCmd(@RequestBody Map<String, List<String>> products){
			for (String i : products.keySet()) {
				for (String j : products.get(i)) {
					adminProductManagementDAO.deleteAdmin(j);
				}
			}
			
			switch (usedDTO) {
			case "ProductsDTO":
				count = adminProductManagementDAO.getAdminCount();
				break;
			case "ProductsSearchDTO_and":
				count = adminProductManagementDAO.getProductsAndCount(productsSearchDTO);
				break;
			case "ProductsSearchDTO_or":
				count = adminProductManagementDAO.getProductsOrCount(productsSearchDTO);
				break;
			}
			
			return getProductsPageDTOCmd(cPage);		
		}
	
	
}
