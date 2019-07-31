package com.macat.service;

import java.util.List;

public class MbersVO {
	
	private String mber_sn, id, pw, name, email, email_end, birthday, phone, tel, point,
				   reg_date, conect_rcord, zonecode, adres, detail_adres, mber_grad;
	private List<MbersVO> mbersVOList;
	
	public MbersVO() {
	
	}
	
	public MbersVO(String mber_sn, String id, String pw, String name, String email, String email_end, String birthday,
			String phone, String tel, String point, String reg_date, String conect_rcord, String zonecode, String adres,
			String detail_adres, String mber_grad) {
		super();
		this.mber_sn = mber_sn;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.email_end = email_end;
		this.birthday = birthday;
		this.phone = phone;
		this.tel = tel;
		this.point = point;
		this.reg_date = reg_date;
		this.conect_rcord = conect_rcord;
		this.zonecode = zonecode;
		this.adres = adres;
		this.detail_adres = detail_adres;
		this.mber_grad = mber_grad;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_end() {
		return email_end;
	}

	public void setEmail_end(String email_end) {
		this.email_end = email_end;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getConect_rcord() {
		return conect_rcord;
	}

	public void setConect_rcord(String conect_rcord) {
		this.conect_rcord = conect_rcord;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getDetail_adres() {
		return detail_adres;
	}

	public void setDetail_adres(String detail_adres) {
		this.detail_adres = detail_adres;
	}

	public String getMber_grad() {
		return mber_grad;
	}

	public void setMber_grad(String mber_grad) {
		this.mber_grad = mber_grad;
	}

	public List<MbersVO> getMbersVOList() {
		return mbersVOList;
	}

	public void setMbersVOList(List<MbersVO> mbersVOList) {
		this.mbersVOList = mbersVOList;
	}
}
