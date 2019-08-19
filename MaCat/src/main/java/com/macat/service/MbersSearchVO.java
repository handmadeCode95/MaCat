package com.macat.service;

public class MbersSearchVO {
	
	private String mber_sq, mber_id, mber_nm, mber_birthday_dt_start, mber_birthday_dt_end, mber_gender, mber_reg_dt_start, mber_reg_dt_end,
					mber_conect_dt_start, mber_conect_dt_end, mber_phone_no, mber_grad_nm, and_or_chk;
	private int begin, end; // 페이징
	
	public MbersSearchVO() {

	}

	public MbersSearchVO(String mber_sq, String mber_id, String mber_nm, String mber_birthday_dt_start,
			String mber_birthday_dt_end, String mber_gender, String mber_reg_dt_start, String mber_reg_dt_end,
			String mber_conect_dt_start, String mber_conect_dt_end, String mber_phone_no, String mber_grad_nm,
			String and_or_chk, int begin, int end) {
		super();
		this.mber_sq = mber_sq;
		this.mber_id = mber_id;
		this.mber_nm = mber_nm;
		this.mber_birthday_dt_start = mber_birthday_dt_start;
		this.mber_birthday_dt_end = mber_birthday_dt_end;
		this.mber_gender = mber_gender;
		this.mber_reg_dt_start = mber_reg_dt_start;
		this.mber_reg_dt_end = mber_reg_dt_end;
		this.mber_conect_dt_start = mber_conect_dt_start;
		this.mber_conect_dt_end = mber_conect_dt_end;
		this.mber_phone_no = mber_phone_no;
		this.mber_grad_nm = mber_grad_nm;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getMber_id() {
		return mber_id;
	}

	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}

	public String getMber_nm() {
		return mber_nm;
	}

	public void setMber_nm(String mber_nm) {
		this.mber_nm = mber_nm;
	}

	public String getMber_birthday_dt_start() {
		return mber_birthday_dt_start;
	}

	public void setMber_birthday_dt_start(String mber_birthday_dt_start) {
		this.mber_birthday_dt_start = mber_birthday_dt_start;
	}

	public String getMber_birthday_dt_end() {
		return mber_birthday_dt_end;
	}

	public void setMber_birthday_dt_end(String mber_birthday_dt_end) {
		this.mber_birthday_dt_end = mber_birthday_dt_end;
	}

	public String getMber_gender() {
		return mber_gender;
	}

	public void setMber_gender(String mber_gender) {
		this.mber_gender = mber_gender;
	}

	public String getMber_reg_dt_start() {
		return mber_reg_dt_start;
	}

	public void setMber_reg_dt_start(String mber_reg_dt_start) {
		this.mber_reg_dt_start = mber_reg_dt_start;
	}

	public String getMber_reg_dt_end() {
		return mber_reg_dt_end;
	}

	public void setMber_reg_dt_end(String mber_reg_dt_end) {
		this.mber_reg_dt_end = mber_reg_dt_end;
	}

	public String getMber_conect_dt_start() {
		return mber_conect_dt_start;
	}

	public void setMber_conect_dt_start(String mber_conect_dt_start) {
		this.mber_conect_dt_start = mber_conect_dt_start;
	}

	public String getMber_conect_dt_end() {
		return mber_conect_dt_end;
	}

	public void setMber_conect_dt_end(String mber_conect_dt_end) {
		this.mber_conect_dt_end = mber_conect_dt_end;
	}

	public String getMber_phone_no() {
		return mber_phone_no;
	}

	public void setMber_phone_no(String mber_phone_no) {
		this.mber_phone_no = mber_phone_no;
	}

	public String getMber_grad_nm() {
		return mber_grad_nm;
	}

	public void setMber_grad_nm(String mber_grad_nm) {
		this.mber_grad_nm = mber_grad_nm;
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
