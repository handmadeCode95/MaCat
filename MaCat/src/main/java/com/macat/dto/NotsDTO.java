package com.macat.dto;

public class NotsDTO {
	
	private String not_sq, not_sj, not_cn, not_reg_dt, mber_sq;
	
	public NotsDTO() {

	}

	public NotsDTO(String not_sq, String not_sj, String not_cn, String not_reg_dt, String mber_sq) {
		super();
		this.not_sq = not_sq;
		this.not_sj = not_sj;
		this.not_cn = not_cn;
		this.not_reg_dt = not_reg_dt;
		this.mber_sq = mber_sq;
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

	public String getNot_cn() {
		return not_cn;
	}

	public void setNot_cn(String not_cn) {
		this.not_cn = not_cn;
	}

	public String getNot_reg_dt() {
		return not_reg_dt;
	}

	public void setNot_reg_dt(String not_reg_dt) {
		this.not_reg_dt = not_reg_dt;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}


}
