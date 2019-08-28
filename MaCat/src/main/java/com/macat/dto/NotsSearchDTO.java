package com.macat.dto;

public class NotsSearchDTO {
	
	private String not_sq, not_sj, mber_sq, not_reg_dt_start, not_reg_dt_end ,and_or_chk;
	private int begin, end; // 페이징
	
	public NotsSearchDTO() {

	}

	public NotsSearchDTO(String not_sq, String not_sj, String mber_sq, String not_reg_dt_start, String not_reg_dt_end,
			String and_or_chk, int begin, int end) {
		super();
		this.not_sq = not_sq;
		this.not_sj = not_sj;
		this.mber_sq = mber_sq;
		this.not_reg_dt_start = not_reg_dt_start;
		this.not_reg_dt_end = not_reg_dt_end;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getNot_sq() {
		return not_sq;
	}

	public void setNot_sq(String not_sq) {
		this.not_sq = not_sq;
	}

	public String getNot_sj() {
		return not_sj;
	}

	public void setNot_sj(String not_sj) {
		this.not_sj = not_sj;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getNot_reg_dt_start() {
		return not_reg_dt_start;
	}

	public void setNot_reg_dt_start(String not_reg_dt_start) {
		this.not_reg_dt_start = not_reg_dt_start;
	}

	public String getNot_reg_dt_end() {
		return not_reg_dt_end;
	}

	public void setNot_reg_dt_end(String not_reg_dt_end) {
		this.not_reg_dt_end = not_reg_dt_end;
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
