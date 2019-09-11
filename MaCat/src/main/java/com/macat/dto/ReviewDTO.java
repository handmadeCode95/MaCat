package com.macat.dto;

public class ReviewDTO implements AdminDTO{
	
	private String re_sq, mber_sq, prduct_sq, re_reg_dt, re_ratgin, re_view_cnt, re_like, re_ans_st, re_id,
				re_sj, re_nm, re_cn;
	
	public ReviewDTO() {}

	public ReviewDTO(String re_sq, String mber_sq, String prduct_sq, String re_reg_dt, String re_ratgin,
			String re_view_cnt, String re_like, String re_ans_st, String re_id, String re_sj, String re_nm,
			String re_cn) {
		super();
		this.re_sq = re_sq;
		this.mber_sq = mber_sq;
		this.prduct_sq = prduct_sq;
		this.re_reg_dt = re_reg_dt;
		this.re_ratgin = re_ratgin;
		this.re_view_cnt = re_view_cnt;
		this.re_like = re_like;
		this.re_ans_st = re_ans_st;
		this.re_id = re_id;
		this.re_sj = re_sj;
		this.re_nm = re_nm;
		this.re_cn = re_cn;
	}

	public String getRe_sq() {
		return re_sq;
	}

	public void setRe_sq(String re_sq) {
		this.re_sq = re_sq;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getPrduct_sq() {
		return prduct_sq;
	}

	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}

	public String getRe_reg_dt() {
		return re_reg_dt;
	}

	public void setRe_reg_dt(String re_reg_dt) {
		this.re_reg_dt = re_reg_dt;
	}

	public String getRe_ratgin() {
		return re_ratgin;
	}

	public void setRe_ratgin(String re_ratgin) {
		this.re_ratgin = re_ratgin;
	}

	public String getRe_view_cnt() {
		return re_view_cnt;
	}

	public void setRe_view_cnt(String re_view_cnt) {
		this.re_view_cnt = re_view_cnt;
	}

	public String getRe_like() {
		return re_like;
	}

	public void setRe_like(String re_like) {
		this.re_like = re_like;
	}

	public String getRe_ans_st() {
		return re_ans_st;
	}

	public void setRe_ans_st(String re_ans_st) {
		this.re_ans_st = re_ans_st;
	}

	public String getRe_id() {
		return re_id;
	}

	public void setRe_id(String re_id) {
		this.re_id = re_id;
	}

	public String getRe_sj() {
		return re_sj;
	}

	public void setRe_sj(String re_sj) {
		this.re_sj = re_sj;
	}

	public String getRe_nm() {
		return re_nm;
	}

	public void setRe_nm(String re_nm) {
		this.re_nm = re_nm;
	}

	public String getRe_cn() {
		return re_cn;
	}

	public void setRe_cn(String re_cn) {
		this.re_cn = re_cn;
	}
	
	
}
