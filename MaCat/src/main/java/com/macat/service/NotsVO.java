package com.macat.service;

import java.util.List;

public class NotsVO {
	
	private String not_sn, not_sj, not_name, not_cn, not_reg_date, mber_sn;
	
	public NotsVO() {

	}

	public NotsVO(String not_sn, String not_sj, String not_name, String not_cn, 
			String not_reg_date, String mber_sn) {
		super();
		this.not_sn = not_sn;
		this.not_sj = not_sj;
		this.not_name = not_name;
		this.not_cn = not_cn;
		this.not_reg_date = not_reg_date;
		this.mber_sn = mber_sn;
	}

	public String getNot_sn() {
		return not_sn;
	}

	public void setNot_sn(String not_sn) {
		this.not_sn = not_sn;
	}

	public String getNot_sj() {
		return not_sj;
	}

	public void setNot_sj(String not_sj) {
		this.not_sj = not_sj;
	}

	public String getNot_name() {
		return not_name;
	}

	public void setNot_name(String not_name) {
		this.not_name = not_name;
	}

	public String getNot_cn() {
		return not_cn;
	}

	public void setNot_cn(String not_cn) {
		this.not_cn = not_cn;
	}

	public String getNot_reg_date() {
		return not_reg_date;
	}

	public void setNot_reg_date(String not_reg_date) {
		this.not_reg_date = not_reg_date;
	}

	public String getMber_sn() {
		return mber_sn;
	}

	public void setMber_sn(String mber_sn) {
		this.mber_sn = mber_sn;
	}
}
