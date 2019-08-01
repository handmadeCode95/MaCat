package com.macat.service;

public class MbersSearchVO {
	
	private String mber_sn, id, name, birthday_start, birthday_end, reg_date_start, reg_date_end,
					conect_rcord_start, conect_rcord_end, phone, mber_grad, and_or_chk;
	private int begin, end;
	
	public MbersSearchVO() {

	}

	public MbersSearchVO(String mber_sn, String id, String name, String birthday_start, String birthday_end,
			String reg_date_start, String reg_date_end, String conect_rcord_start, String conect_rcord_end,
			String phone, String mber_grad, String and_or_chk, int begin, int end) {
		super();
		this.mber_sn = mber_sn;
		this.id = id;
		this.name = name;
		this.birthday_start = birthday_start;
		this.birthday_end = birthday_end;
		this.reg_date_start = reg_date_start;
		this.reg_date_end = reg_date_end;
		this.conect_rcord_start = conect_rcord_start;
		this.conect_rcord_end = conect_rcord_end;
		this.phone = phone;
		this.mber_grad = mber_grad;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getMber_sn() {
		return mber_sn;
	}

	public void setMber_sn(String mber_sn) {
		this.mber_sn = mber_sn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday_start() {
		return birthday_start;
	}

	public void setBirthday_start(String birthday_start) {
		this.birthday_start = birthday_start;
	}

	public String getBirthday_end() {
		return birthday_end;
	}

	public void setBirthday_end(String birthday_end) {
		this.birthday_end = birthday_end;
	}

	public String getReg_date_start() {
		return reg_date_start;
	}

	public void setReg_date_start(String reg_date_start) {
		this.reg_date_start = reg_date_start;
	}

	public String getReg_date_end() {
		return reg_date_end;
	}

	public void setReg_date_end(String reg_date_end) {
		this.reg_date_end = reg_date_end;
	}

	public String getConect_rcord_start() {
		return conect_rcord_start;
	}

	public void setConect_rcord_start(String conect_rcord_start) {
		this.conect_rcord_start = conect_rcord_start;
	}

	public String getConect_rcord_end() {
		return conect_rcord_end;
	}

	public void setConect_rcord_end(String conect_rcord_end) {
		this.conect_rcord_end = conect_rcord_end;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMber_grad() {
		return mber_grad;
	}

	public void setMber_grad(String mber_grad) {
		this.mber_grad = mber_grad;
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
