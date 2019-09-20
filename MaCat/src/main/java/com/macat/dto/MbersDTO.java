package com.macat.dto;

public class MbersDTO implements AdminDTO {
	
	private String mber_sq, mber_id, mber_pw, mber_nm, mber_email, mber_email_end, mber_gender, mber_birthday_dt, mber_phone_no, mber_tel_no, mber_point_sum,
				   mber_reg_dt, mber_conect_dt, mber_zip_no, mber_adres, mber_detail_adres, mber_grad_nm;
	
	public MbersDTO() {	}

	public MbersDTO(String mber_sq, String mber_id, String mber_pw, String mber_nm, String mber_email,
			String mber_email_end, String mber_gender, String mber_birthday_dt, String mber_phone_no,
			String mber_tel_no, String mber_point_sum, String mber_reg_dt, String mber_conect_dt, String mber_zip_no,
			String mber_adres, String mber_detail_adres, String mber_grad_nm) {
		super();
		this.mber_sq = mber_sq;
		this.mber_id = mber_id;
		this.mber_pw = mber_pw;
		this.mber_nm = mber_nm;
		this.mber_email = mber_email;
		this.mber_email_end = mber_email_end;
		this.mber_gender = mber_gender;
		this.mber_birthday_dt = mber_birthday_dt;
		this.mber_phone_no = mber_phone_no;
		this.mber_tel_no = mber_tel_no;
		this.mber_point_sum = mber_point_sum;
		this.mber_reg_dt = mber_reg_dt;
		this.mber_conect_dt = mber_conect_dt;
		this.mber_zip_no = mber_zip_no;
		this.mber_adres = mber_adres;
		this.mber_detail_adres = mber_detail_adres;
		this.mber_grad_nm = mber_grad_nm;
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

	public String getMber_pw() {
		return mber_pw;
	}

	public void setMber_pw(String mber_pw) {
		this.mber_pw = mber_pw;
	}

	public String getMber_nm() {
		return mber_nm;
	}

	public void setMber_nm(String mber_nm) {
		this.mber_nm = mber_nm;
	}

	public String getMber_email() {
		return mber_email;
	}

	public void setMber_email(String mber_email) {
		this.mber_email = mber_email;
	}

	public String getMber_email_end() {
		return mber_email_end;
	}

	public void setMber_email_end(String mber_email_end) {
		this.mber_email_end = mber_email_end;
	}

	public String getMber_gender() {
		return mber_gender;
	}

	public void setMber_gender(String mber_gender) {
		this.mber_gender = mber_gender;
	}

	public String getMber_birthday_dt() {
		return mber_birthday_dt;
	}

	public void setMber_birthday_dt(String mber_birthday_dt) {
		this.mber_birthday_dt = mber_birthday_dt;
	}

	public String getMber_phone_no() {
		return mber_phone_no;
	}

	public void setMber_phone_no(String mber_phone_no) {
		this.mber_phone_no = mber_phone_no;
	}

	public String getMber_tel_no() {
		return mber_tel_no;
	}

	public void setMber_tel_no(String mber_tel_no) {
		this.mber_tel_no = mber_tel_no;
	}

	public String getMber_point_sum() {
		return mber_point_sum;
	}

	public void setMber_point_sum(String mber_point_sum) {
		this.mber_point_sum = mber_point_sum;
	}

	public String getMber_reg_dt() {
		return mber_reg_dt;
	}

	public void setMber_reg_dt(String mber_reg_dt) {
		this.mber_reg_dt = mber_reg_dt;
	}

	public String getMber_conect_dt() {
		return mber_conect_dt;
	}

	public void setMber_conect_dt(String mber_conect_dt) {
		this.mber_conect_dt = mber_conect_dt;
	}

	public String getMber_zip_no() {
		return mber_zip_no;
	}

	public void setMber_zip_no(String mber_zip_no) {
		this.mber_zip_no = mber_zip_no;
	}

	public String getMber_adres() {
		return mber_adres;
	}

	public void setMber_adres(String mber_adres) {
		this.mber_adres = mber_adres;
	}

	public String getMber_detail_adres() {
		return mber_detail_adres;
	}

	public void setMber_detail_adres(String mber_detail_adres) {
		this.mber_detail_adres = mber_detail_adres;
	}

	public String getMber_grad_nm() {
		return mber_grad_nm;
	}

	public void setMber_grad_nm(String mber_grad_nm) {
		this.mber_grad_nm = mber_grad_nm;
	}
	
}