package com.macat.dto;

public class OrderDTO implements AdminDTO{
	
	private String order_sq, mber_sq, prduct_sq, order_dt, order_paymt_dt, order_amt, order_point, order_pay, order_status,
					   order_method, cpon_sq, order_compt_dt;
	
	public OrderDTO() {	}
	
	public OrderDTO(String order_sq, String mber_sq, String prduct_sq, String order_dt, String order_paymt_dt,
			String order_amt, String order_point, String order_pay, String order_status, String order_method,
			String cpon_sq, String order_compt_dt) {
		super();
		this.order_sq = order_sq;
		this.mber_sq = mber_sq;
		this.prduct_sq = prduct_sq;
		this.order_dt = order_dt;
		this.order_paymt_dt = order_paymt_dt;
		this.order_amt = order_amt;
		this.order_point = order_point;
		this.order_pay = order_pay;
		this.order_status = order_status;
		this.order_method = order_method;
		this.cpon_sq = cpon_sq;
		this.order_compt_dt = order_compt_dt;
	}

	public String getOrder_sq() {
		return order_sq;
	}

	public void setOrder_sq(String order_sq) {
		this.order_sq = order_sq;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getPrduct_sq() {
		return prduct_sq;
	}

	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}

	public String getOrder_dt() {
		return order_dt;
	}

	public void setOrder_dt(String order_dt) {
		this.order_dt = order_dt;
	}

	public String getOrder_paymt_dt() {
		return order_paymt_dt;
	}

	public void setOrder_paymt_dt(String order_paymt_dt) {
		this.order_paymt_dt = order_paymt_dt;
	}

	public String getOrder_amt() {
		return order_amt;
	}

	public void setOrder_amt(String order_amt) {
		this.order_amt = order_amt;
	}

	public String getOrder_point() {
		return order_point;
	}

	public void setOrder_point(String order_point) {
		this.order_point = order_point;
	}

	public String getOrder_pay() {
		return order_pay;
	}

	public void setOrder_pay(String order_pay) {
		this.order_pay = order_pay;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_method() {
		return order_method;
	}

	public void setOrder_method(String order_method) {
		this.order_method = order_method;
	}

	public String getCpon_sq() {
		return cpon_sq;
	}

	public void setCpon_sq(String cpon_sq) {
		this.cpon_sq = cpon_sq;
	}

	public String getOrder_compt_dt() {
		return order_compt_dt;
	}

	public void setOrder_compt_dt(String order_compt_dt) {
		this.order_compt_dt = order_compt_dt;
	}
	
	
}
