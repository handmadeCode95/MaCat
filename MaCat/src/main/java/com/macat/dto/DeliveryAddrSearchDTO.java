package com.macat.dto;

public class DeliveryAddrSearchDTO implements AdminSearchDTO{
	
	private String da_sq, mber_sq, da_zip_no, da_phone, da_adres, da_tel, da_detail_adres, and_or_chk;
	private int begin, end;
	
	public DeliveryAddrSearchDTO() {	}

	public DeliveryAddrSearchDTO(String da_sq, String mber_sq, String da_zip_no, String da_phone, String da_adres,
			String da_tel, String da_detail_adres, String and_or_chk, int begin, int end) {
		super();
		this.da_sq = da_sq;
		this.mber_sq = mber_sq;
		this.da_zip_no = da_zip_no;
		this.da_phone = da_phone;
		this.da_adres = da_adres;
		this.da_tel = da_tel;
		this.da_detail_adres = da_detail_adres;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getDa_sq() {
		return da_sq;
	}

	public void setDa_sq(String da_sq) {
		this.da_sq = da_sq;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getDa_zip_no() {
		return da_zip_no;
	}

	public void setDa_zip_no(String da_zip_no) {
		this.da_zip_no = da_zip_no;
	}

	public String getDa_phone() {
		return da_phone;
	}

	public void setDa_phone(String da_phone) {
		this.da_phone = da_phone;
	}

	public String getDa_adres() {
		return da_adres;
	}

	public void setDa_adres(String da_adres) {
		this.da_adres = da_adres;
	}

	public String getDa_tel() {
		return da_tel;
	}

	public void setDa_tel(String da_tel) {
		this.da_tel = da_tel;
	}

	public String getDa_detail_adres() {
		return da_detail_adres;
	}

	public void setDa_detail_adres(String da_detail_adres) {
		this.da_detail_adres = da_detail_adres;
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