package com.macat.dto;

public class OrderSearchDTO implements AdminSearchDTO{
	
	private String order_sq, prduct_sq, order_pay, mber_sq, order_method, order_status, order_dt_start, order_dt_end, order_compt_dt_start,
				order_compt_dt_end, order_paymt_dt_start, order_paymt_dt_end, and_or_chk;
	private int begin, end; // 페이징
	
	public OrderSearchDTO() { 	}
	
	public OrderSearchDTO(String and_or_chk) {
		super();
		this.and_or_chk = and_or_chk;
	}

	public String getAnd_or_chk() {
		return and_or_chk;
	}

	public void setAnd_or_chk(String and_or_chk) {
		this.and_or_chk = and_or_chk;
	}



	public OrderSearchDTO(String order_sq, String prduct_sq, String order_pay, String mber_sq, String order_method,
			String order_status, String order_dt_start, String order_dt_end, String order_compt_dt_start,
			String order_compt_dt_end, String order_paymt_dt_start, String order_paymt_dt_end, int begin, int end) {
		super();
		this.order_sq = order_sq;
		this.prduct_sq = prduct_sq;
		this.order_pay = order_pay;
		this.mber_sq = mber_sq;
		this.order_method = order_method;
		this.order_status = order_status;
		this.order_dt_start = order_dt_start;
		this.order_dt_end = order_dt_end;
		this.order_compt_dt_start = order_compt_dt_start;
		this.order_compt_dt_end = order_compt_dt_end;
		this.order_paymt_dt_start = order_paymt_dt_start;
		this.order_paymt_dt_end = order_paymt_dt_end;
		this.begin = begin;
		this.end = end;
	}



	public String getOrder_sq() {
		return order_sq;
	}

	public void setOrder_sq(String order_sq) {
		this.order_sq = order_sq;
	}

	public String getPrduct_sq() {
		return prduct_sq;
	}

	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}

	public String getOrder_pay() {
		return order_pay;
	}

	public void setOrder_pay(String order_pay) {
		this.order_pay = order_pay;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getOrder_method() {
		return order_method;
	}

	public void setOrder_method(String order_method) {
		this.order_method = order_method;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_dt_start() {
		return order_dt_start;
	}

	public void setOrder_dt_start(String order_dt_start) {
		this.order_dt_start = order_dt_start;
	}

	public String getOrder_dt_end() {
		return order_dt_end;
	}

	public void setOrder_dt_end(String order_dt_end) {
		this.order_dt_end = order_dt_end;
	}

	public String getOrder_compt_dt_start() {
		return order_compt_dt_start;
	}

	public void setOrder_compt_dt_start(String order_compt_dt_start) {
		this.order_compt_dt_start = order_compt_dt_start;
	}

	public String getOrder_compt_dt_end() {
		return order_compt_dt_end;
	}

	public void setOrder_compt_dt_end(String order_compt_dt_end) {
		this.order_compt_dt_end = order_compt_dt_end;
	}

	public String getOrder_paymt_dt_start() {
		return order_paymt_dt_start;
	}

	public void setOrder_paymt_dt_start(String order_paymt_dt_start) {
		this.order_paymt_dt_start = order_paymt_dt_start;
	}

	public String getOrder_paymt_dt_end() {
		return order_paymt_dt_end;
	}

	public void setOrder_paymt_dt_end(String order_paymt_dt_end) {
		this.order_paymt_dt_end = order_paymt_dt_end;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}
