package com.macat.dto;

public class DeliveryDTO implements AdminDTO{
	private String dlvy_sq, mber_sq, order_sq, da_sq, dlvy_zip_no, dlvy_phone_no, dlvy_nm, dlvy_adres, dlvy_start_dt, dlvy_end_dt,
			  dlvy_tel_no, dlvy_co_nm, dlvy_waybill_no, dlvy_msg, dlvy_deail_adres;

	public DeliveryDTO() {	}

	public DeliveryDTO(String dlvy_sq, String mber_sq, String order_sq, String da_sq, String dlvy_zip_no,
			String dlvy_phone_no, String dlvy_nm, String dlvy_adres, String dlvy_start_dt, String dlvy_end_dt,
			String dlvy_tel_no, String dlvy_co_nm, String dlvy_waybill_no, String dlvy_msg, String dlvy_deail_adres) {
		super();
		this.dlvy_sq = dlvy_sq;
		this.mber_sq = mber_sq;
		this.order_sq = order_sq;
		this.da_sq = da_sq;
		this.dlvy_zip_no = dlvy_zip_no;
		this.dlvy_phone_no = dlvy_phone_no;
		this.dlvy_nm = dlvy_nm;
		this.dlvy_adres = dlvy_adres;
		this.dlvy_start_dt = dlvy_start_dt;
		this.dlvy_end_dt = dlvy_end_dt;
		this.dlvy_tel_no = dlvy_tel_no;
		this.dlvy_co_nm = dlvy_co_nm;
		this.dlvy_waybill_no = dlvy_waybill_no;
		this.dlvy_msg = dlvy_msg;
		this.dlvy_deail_adres = dlvy_deail_adres;
	}

	public String getDlvy_sq() {
		return dlvy_sq;
	}

	public void setDlvy_sq(String dlvy_sq) {
		this.dlvy_sq = dlvy_sq;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getOrder_sq() {
		return order_sq;
	}

	public void setOrder_sq(String order_sq) {
		this.order_sq = order_sq;
	}

	public String getDa_sq() {
		return da_sq;
	}

	public void setDa_sq(String da_sq) {
		this.da_sq = da_sq;
	}

	public String getDlvy_zip_no() {
		return dlvy_zip_no;
	}

	public void setDlvy_zip_no(String dlvy_zip_no) {
		this.dlvy_zip_no = dlvy_zip_no;
	}

	public String getDlvy_phone_no() {
		return dlvy_phone_no;
	}

	public void setDlvy_phone_no(String dlvy_phone_no) {
		this.dlvy_phone_no = dlvy_phone_no;
	}

	public String getDlvy_nm() {
		return dlvy_nm;
	}

	public void setDlvy_nm(String dlvy_nm) {
		this.dlvy_nm = dlvy_nm;
	}

	public String getDlvy_adres() {
		return dlvy_adres;
	}

	public void setDlvy_adres(String dlvy_adres) {
		this.dlvy_adres = dlvy_adres;
	}

	public String getDlvy_start_dt() {
		return dlvy_start_dt;
	}

	public void setDlvy_start_dt(String dlvy_start_dt) {
		this.dlvy_start_dt = dlvy_start_dt;
	}

	public String getDlvy_end_dt() {
		return dlvy_end_dt;
	}

	public void setDlvy_end_dt(String dlvy_end_dt) {
		this.dlvy_end_dt = dlvy_end_dt;
	}

	public String getDlvy_tel_no() {
		return dlvy_tel_no;
	}

	public void setDlvy_tel_no(String dlvy_tel_no) {
		this.dlvy_tel_no = dlvy_tel_no;
	}

	public String getDlvy_co_nm() {
		return dlvy_co_nm;
	}

	public void setDlvy_co_nm(String dlvy_co_nm) {
		this.dlvy_co_nm = dlvy_co_nm;
	}

	public String getDlvy_waybill_no() {
		return dlvy_waybill_no;
	}

	public void setDlvy_waybill_no(String dlvy_waybill_no) {
		this.dlvy_waybill_no = dlvy_waybill_no;
	}

	public String getDlvy_msg() {
		return dlvy_msg;
	}

	public void setDlvy_msg(String dlvy_msg) {
		this.dlvy_msg = dlvy_msg;
	}

	public String getDlvy_deail_adres() {
		return dlvy_deail_adres;
	}

	public void setDlvy_deail_adres(String dlvy_deail_adres) {
		this.dlvy_deail_adres = dlvy_deail_adres;
	}
	
}