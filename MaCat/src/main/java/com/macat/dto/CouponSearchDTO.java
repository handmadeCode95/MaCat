package com.macat.dto;

public class CouponSearchDTO implements AdminSearchDTO{
	
	private String cpon_sq, mber_sq, cpon_reg_dt_start, cpon_reg_dt_end, cpon_exp_dt_start, cpon_exp_dt_end,
			  cpon_nm, cpon_dc_pt, cpon_dc, and_or_chk;
	private int begin, end;
	
	public CouponSearchDTO() {	}

	public CouponSearchDTO(String cpon_sq, String mber_sq, String cpon_reg_dt_start, String cpon_reg_dt_end,
			String cpon_exp_dt_start, String cpon_exp_dt_end, String cpon_nm, String cpon_dc_pt, String cpon_dc,
			String and_or_chk, int begin, int end) {
		super();
		this.cpon_sq = cpon_sq;
		this.mber_sq = mber_sq;
		this.cpon_reg_dt_start = cpon_reg_dt_start;
		this.cpon_reg_dt_end = cpon_reg_dt_end;
		this.cpon_exp_dt_start = cpon_exp_dt_start;
		this.cpon_exp_dt_end = cpon_exp_dt_end;
		this.cpon_nm = cpon_nm;
		this.cpon_dc_pt = cpon_dc_pt;
		this.cpon_dc = cpon_dc;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getCpon_sq() {
		return cpon_sq;
	}

	public void setCpon_sq(String cpon_sq) {
		this.cpon_sq = cpon_sq;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getCpon_reg_dt_start() {
		return cpon_reg_dt_start;
	}

	public void setCpon_reg_dt_start(String cpon_reg_dt_start) {
		this.cpon_reg_dt_start = cpon_reg_dt_start;
	}

	public String getCpon_reg_dt_end() {
		return cpon_reg_dt_end;
	}

	public void setCpon_reg_dt_end(String cpon_reg_dt_end) {
		this.cpon_reg_dt_end = cpon_reg_dt_end;
	}

	public String getCpon_exp_dt_start() {
		return cpon_exp_dt_start;
	}

	public void setCpon_exp_dt_start(String cpon_exp_dt_start) {
		this.cpon_exp_dt_start = cpon_exp_dt_start;
	}

	public String getCpon_exp_dt_end() {
		return cpon_exp_dt_end;
	}

	public void setCpon_exp_dt_end(String cpon_exp_dt_end) {
		this.cpon_exp_dt_end = cpon_exp_dt_end;
	}

	public String getCpon_nm() {
		return cpon_nm;
	}

	public void setCpon_nm(String cpon_nm) {
		this.cpon_nm = cpon_nm;
	}

	public String getCpon_dc_pt() {
		return cpon_dc_pt;
	}

	public void setCpon_dc_pt(String cpon_dc_pt) {
		this.cpon_dc_pt = cpon_dc_pt;
	}

	public String getCpon_dc() {
		return cpon_dc;
	}

	public void setCpon_dc(String cpon_dc) {
		this.cpon_dc = cpon_dc;
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