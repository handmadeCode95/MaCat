package com.macat.dto;

public class DeliverySearchDTO implements AdminSearchDTO{
	
	private String dlvy_sq, mber_sq, order_sq, da_sq, dlvy_zip_no, dlvy_phone_no, dlvy_nm, dlvy_adres, dlvy_start_dt_start, 
	dlvy_start_dt_end, dlvy_end_dt_start, dlvy_end_dt_end, dlvy_tel_no, dlvy_co_nm, dlvy_waybill_no, dlvy_deail_adres, and_or_chk;
	private int begin, end; // 페이징
	
	public DeliverySearchDTO() {	}

	public DeliverySearchDTO(String dlvy_sq, String mber_sq, String order_sq, String da_sq, String dlvy_zip_no,
			String dlvy_phone_no, String dlvy_nm, String dlvy_adres, String dlvy_start_dt_start,
			String dlvy_start_dt_end, String dlvy_end_dt_start, String dlvy_end_dt_end, String dlvy_tel_no,
			String dlvy_co_nm, String dlvy_waybill_no, String dlvy_deail_adres, String and_or_chk, int begin, int end) {
		super();
		this.dlvy_sq = dlvy_sq;
		this.mber_sq = mber_sq;
		this.order_sq = order_sq;
		this.da_sq = da_sq;
		this.dlvy_zip_no = dlvy_zip_no;
		this.dlvy_phone_no = dlvy_phone_no;
		this.dlvy_nm = dlvy_nm;
		this.dlvy_adres = dlvy_adres;
		this.dlvy_start_dt_start = dlvy_start_dt_start;
		this.dlvy_start_dt_end = dlvy_start_dt_end;
		this.dlvy_end_dt_start = dlvy_end_dt_start;
		this.dlvy_end_dt_end = dlvy_end_dt_end;
		this.dlvy_tel_no = dlvy_tel_no;
		this.dlvy_co_nm = dlvy_co_nm;
		this.dlvy_waybill_no = dlvy_waybill_no;
		this.dlvy_deail_adres = dlvy_deail_adres;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
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

	public String getDlvy_start_dt_start() {
		return dlvy_start_dt_start;
	}

	public void setDlvy_start_dt_start(String dlvy_start_dt_start) {
		this.dlvy_start_dt_start = dlvy_start_dt_start;
	}

	public String getDlvy_start_dt_end() {
		return dlvy_start_dt_end;
	}

	public void setDlvy_start_dt_end(String dlvy_start_dt_end) {
		this.dlvy_start_dt_end = dlvy_start_dt_end;
	}

	public String getDlvy_end_dt_start() {
		return dlvy_end_dt_start;
	}

	public void setDlvy_end_dt_start(String dlvy_end_dt_start) {
		this.dlvy_end_dt_start = dlvy_end_dt_start;
	}

	public String getDlvy_end_dt_end() {
		return dlvy_end_dt_end;
	}

	public void setDlvy_end_dt_end(String dlvy_end_dt_end) {
		this.dlvy_end_dt_end = dlvy_end_dt_end;
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

	public String getDlvy_deail_adres() {
		return dlvy_deail_adres;
	}

	public void setDlvy_deail_adres(String dlvy_deail_adres) {
		this.dlvy_deail_adres = dlvy_deail_adres;
	}

	public String getAnd_or_chk() {
		return and_or_chk;
	}

	public void setAnd_or_chk(String and_or_chk) {
		this.and_or_chk = and_or_chk;
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