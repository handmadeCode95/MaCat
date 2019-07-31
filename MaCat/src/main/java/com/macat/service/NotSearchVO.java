package com.macat.service;

public class NotSearchVO {
	
	private String not_sn, not_sj, not_name, not_reg_date_start, not_reg_date_end ,and_or_chk;
	
	public NotSearchVO() {

	}

	public NotSearchVO(String not_sn, String not_sj, String not_name, String not_reg_date_start,
			String not_reg_date_end, String and_or_chk) {
		super();
		this.not_sn = not_sn;
		this.not_sj = not_sj;
		this.not_name = not_name;
		this.not_reg_date_start = not_reg_date_start;
		this.not_reg_date_end = not_reg_date_end;
		this.and_or_chk = and_or_chk;
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

	public String getNot_reg_date_start() {
		return not_reg_date_start;
	}

	public void setNot_reg_date_start(String not_reg_date_start) {
		this.not_reg_date_start = not_reg_date_start;
	}

	public String getNot_reg_date_end() {
		return not_reg_date_end;
	}

	public void setNot_reg_date_end(String not_reg_date_end) {
		this.not_reg_date_end = not_reg_date_end;
	}

	public String getAnd_or_chk() {
		return and_or_chk;
	}

	public void setAnd_or_chk(String and_or_chk) {
		this.and_or_chk = and_or_chk;
	}
}
