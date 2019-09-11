package com.macat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.macat.dao.AdminOrderManagementDAO;
import com.macat.dto.DateDTO;
import com.macat.dto.OrderDTO;
import com.macat.dto.OrderSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.util.DateCalculateUtil;
import com.macat.util.PagingUtil;

@Controller
public class AdminOrderController {
	
	private final AdminOrderManagementDAO adminOrderManagementDAO;
	
	@Autowired
	public AdminOrderController(AdminOrderManagementDAO adminOrderManagementDAO) {
		this.adminOrderManagementDAO = adminOrderManagementDAO;
	}

	private String usedDTO; // 페이징을 위한 조회 기록
	private int count; // 페이징을 위한 검색 인원 수 기록
	private String cPage; // 페이징을 위한 현재 페이지 기록
	private OrderSearchDTO orderSearchDTO; // 페이징을 위한 회원 정보 검색 기록	
	
	// 주문 정보 조회로 이동
	@GetMapping("order_manage.mcat")
	public ModelAndView redirectOrderManagerCmd(ModelAndView mv, String cPage) {
		mv.setViewName("admin/product/order_manager");		
		this.cPage = cPage;
		usedDTO = "OrderDTO";

		DateDTO dateDTO = new DateDTO();
		dateDTO.setToday(DateCalculateUtil.getToday());
		dateDTO.setOneWeekAgo(DateCalculateUtil.addDate(-7));
		dateDTO.setOneMonthAgo(DateCalculateUtil.addMonth(-1));
		dateDTO.setThreeMonthAgo(DateCalculateUtil.addMonth(-3));
		dateDTO.setSixMonthAgo(DateCalculateUtil.addMonth(-6));
		dateDTO.setOneYearAgo(DateCalculateUtil.addYear(-1));
		
		PageDTO pageDTO = new PageDTO(50);
		count = adminOrderManagementDAO.getAdminCount();
		PagingUtil.getPage(pageDTO, count, cPage);
		mv.addObject("orders_count", count);

		mv.addObject("dateDTO", dateDTO);
		mv.addObject("orderDTO", adminOrderManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
		mv.addObject("pageDTO", pageDTO);
		return mv;
	}
	
	// 주문 정보 페이징
	@PostMapping("order_paging.mcat")
	@ResponseBody
	public Map<String, Object> getOrderPagingCmd(@RequestBody String cPage) {

		this.cPage = cPage;
		PageDTO pageDTO = new PageDTO(50);

		Map<String, Object> map = new HashMap<String, Object>();

		PagingUtil.getPage(pageDTO, count, cPage);
		map.put("pageDTO", pageDTO);
		map.put("orders_count", count);			

		switch (usedDTO) {
		case "MbersDTO":
			map.put("mbersDTO", adminOrderManagementDAO.getAdminList(pageDTO.getBegin(), pageDTO.getEnd()));
			break;
		default:
			orderSearchDTO.setBegin(pageDTO.getBegin());
			orderSearchDTO.setEnd(pageDTO.getEnd());
			switch (usedDTO) {
			case "MbersSearchDTO_and":
				map.put("mbersDTO", adminOrderManagementDAO.getAndSearch(orderSearchDTO));
				break;
			case "MbersSearchDTO_or":
				map.put("mbersDTO", adminOrderManagementDAO.getOrSearch(orderSearchDTO));
				break;
			}
		}

		return map;
	}
	
	// 주문 검색
	@PostMapping("order_search.mcat")
	@ResponseBody
	public Map<String, Object> getOrderSearchCmd(@RequestBody OrderSearchDTO orderSearchDTO) {

		if (orderSearchDTO.getOrder_dt_start() != null)
			orderSearchDTO.setOrder_dt_start(orderSearchDTO.getOrder_dt_start() + " 00:00:00");
		if (orderSearchDTO.getOrder_dt_end() != null)
			orderSearchDTO.setOrder_dt_end(orderSearchDTO.getOrder_dt_end() + " 23:59:59");
		if (orderSearchDTO.getOrder_compt_dt_start() != null)
			orderSearchDTO.setOrder_compt_dt_start(orderSearchDTO.getOrder_compt_dt_start() + " 00:00:00");
		if (orderSearchDTO.getOrder_compt_dt_end() != null)
			orderSearchDTO.setOrder_compt_dt_end(orderSearchDTO.getOrder_compt_dt_end() + " 23:59:59");
		if (orderSearchDTO.getOrder_paymt_dt_start() != null)
			orderSearchDTO.setOrder_paymt_dt_start(orderSearchDTO.getOrder_paymt_dt_start() + " 00:00:00");
		if (orderSearchDTO.getOrder_paymt_dt_end() != null)
			orderSearchDTO.setOrder_paymt_dt_end(orderSearchDTO.getOrder_paymt_dt_end() + " 23:59:59");

		Map<String, Object> map = new HashMap<String, Object>();

		PageDTO pageDTO = new PageDTO(50);


		switch (orderSearchDTO.getAnd_or_chk()) {
		case "and":
			usedDTO = "OrderSearchDTO_and";
			count = adminOrderManagementDAO.getAndCount(orderSearchDTO);
			break;
		case "or":
			usedDTO = "OrderSearchDTO_or";
			count = adminOrderManagementDAO.getOrCount(orderSearchDTO);
			break;
		}

		PagingUtil.getPage(pageDTO, count, null);
		map.put("pageDTO", pageDTO);

		map.put("orders_count", count);

		orderSearchDTO.setBegin(pageDTO.getBegin());
		orderSearchDTO.setEnd(pageDTO.getEnd());
		this.orderSearchDTO = orderSearchDTO; // 페이징을 위한 검색 기록 저장		

		switch (orderSearchDTO.getAnd_or_chk()) {
		case "and":
			map.put("orderDTO", adminOrderManagementDAO.getAndSearch(orderSearchDTO));
			break;
		case "or":
			map.put("orderDTO", adminOrderManagementDAO.getOrSearch(orderSearchDTO));
			break;
		}

		return map;
	}
	
	// 주문 정보 수정
	@PostMapping("order_update.mcat")
	@ResponseBody
	public Map<String, Object> getOrderUpdateCmd(@RequestBody Map<String, List<OrderDTO>> order) {
		for (String i : order.keySet()) {
			for (OrderDTO j : order.get(i)) {
				adminOrderManagementDAO.updateOrder(j);
			}
		}
		return getOrderPagingCmd(cPage);
	}

	// 주문 삭제
	@PostMapping("order_delete.mcat")
	@ResponseBody
	public Map<String, Object> getOrderDeleteCmd(@RequestBody Map<String, List<String>> order) {
		for (String i : order.keySet()) {
			for (String j : order.get(i)) {
				adminOrderManagementDAO.deleteAdmin(j);
			}
		}

		switch (usedDTO) {
		case "OrderDTO":
			count = adminOrderManagementDAO.getAdminCount();
			break;
		case "OrderSearchDTO_and":
			count = adminOrderManagementDAO.getAndCount(orderSearchDTO);
			break;
		case "OrderSearchDTO_or":
			count = adminOrderManagementDAO.getOrCount(orderSearchDTO);
			break;
		}

		return getOrderPagingCmd(cPage);
	}
	
}
