package com.macat.service;

public class NotsSearchVO {
	
	private String not_sn, not_sj, not_name, mber_sn, not_reg_date_start, not_reg_date_end ,and_or_chk;
	private int begin, end; // 페이징
	
	public NotsSearchVO() {

	}

	public NotsSearchVO(String not_sn, String not_sj, String not_name, String mber_sn, String not_reg_date_start,
			String not_reg_date_end, String and_or_chk, int begin, int end) {
		super();
		this.not_sn = not_sn;
		this.not_sj = not_sj;
		this.not_name = not_name;
		this.mber_sn = mber_sn;
		this.not_reg_date_start = not_reg_date_start;
		this.not_reg_date_end = not_reg_date_end;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
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

	public String getMber_sn() {
		return mber_sn;
	}

	public void setMber_sn(String mber_sn) {
		this.mber_sn = mber_sn;
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
