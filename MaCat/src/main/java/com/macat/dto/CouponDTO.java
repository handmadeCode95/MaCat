package com.macat.dto;

public class CouponDTO implements AdminDTO{
	
	private String cpon_sq, mber_sq, cpon_reg_dt, cpon_exp_dt, cpon_fl, cpon_nm, cpon_dc_pt, cpon_dc;
	
	public CouponDTO() {	}

	public CouponDTO(String cpon_sq, String mber_sq, String cpon_reg_dt, String cpon_exp_dt, String cpon_fl,
			String cpon_nm, String cpon_dc_pt, String cpon_dc) {
		super();
		this.cpon_sq = cpon_sq;
		this.mber_sq = mber_sq;
		this.cpon_reg_dt = cpon_reg_dt;
		this.cpon_exp_dt = cpon_exp_dt;
		this.cpon_fl = cpon_fl;
		this.cpon_nm = cpon_nm;
		this.cpon_dc_pt = cpon_dc_pt;
		this.cpon_dc = cpon_dc;
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

	public String getCpon_reg_dt() {
		return cpon_reg_dt;
	}

	public void setCpon_reg_dt(String cpon_reg_dt) {
		this.cpon_reg_dt = cpon_reg_dt;
	}

	public String getCpon_exp_dt() {
		return cpon_exp_dt;
	}

	public void setCpon_exp_dt(String cpon_exp_dt) {
		this.cpon_exp_dt = cpon_exp_dt;
	}

	public String getCpon_fl() {
		return cpon_fl;
	}

	public void setCpon_fl(String cpon_fl) {
		this.cpon_fl = cpon_fl;
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
}