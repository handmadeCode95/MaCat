package com.macat.service;

public class QnaVO {
	
	private String qna_sq, qna_sj, qna_nm, qna_id, qna_cn, qna_reg_dt, qc_nm, mber_sq, qna_ans_st;
	private int qna_view_cnt, qna_group, qna_level;

	public QnaVO() {

	}

	public QnaVO(String qna_sq, String qna_sj, String qna_nm, String qna_id, String qna_cn, String qna_reg_dt,
			String qc_nm, String mber_sq, String qna_ans_st, int qna_view_cnt, int qna_group, int qna_level) {
		super();
		this.qna_sq = qna_sq;
		this.qna_sj = qna_sj;
		this.qna_nm = qna_nm;
		this.qna_id = qna_id;
		this.qna_cn = qna_cn;
		this.qna_reg_dt = qna_reg_dt;
		this.qc_nm = qc_nm;
		this.mber_sq = mber_sq;
		this.qna_ans_st = qna_ans_st;
		this.qna_view_cnt = qna_view_cnt;
		this.qna_group = qna_group;
		this.qna_level = qna_level;
	}

	public String getQna_sq() {
		return qna_sq;
	}

	public void setQna_sq(String qna_sq) {
		this.qna_sq = qna_sq;
	}

	public String getQna_sj() {
		return qna_sj;
	}

	public void setQna_sj(String qna_sj) {
		this.qna_sj = qna_sj;
	}

	public String getQna_nm() {
		return qna_nm;
	}

	public void setQna_nm(String qna_nm) {
		this.qna_nm = qna_nm;
	}

	public String getQna_id() {
		return qna_id;
	}

	public void setQna_id(String qna_id) {
		this.qna_id = qna_id;
	}

	public String getQna_cn() {
		return qna_cn;
	}

	public void setQna_cn(String qna_cn) {
		this.qna_cn = qna_cn;
	}

	public String getQna_reg_dt() {
		return qna_reg_dt;
	}

	public void setQna_reg_dt(String qna_reg_dt) {
		this.qna_reg_dt = qna_reg_dt;
	}

	public String getQc_nm() {
		return qc_nm;
	}

	public void setQc_nm(String qc_nm) {
		this.qc_nm = qc_nm;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getQna_ans_st() {
		return qna_ans_st;
	}

	public void setQna_ans_st(String qna_ans_st) {
		this.qna_ans_st = qna_ans_st;
	}

	public int getQna_view_cnt() {
		return qna_view_cnt;
	}

	public void setQna_view_cnt(int qna_view_cnt) {
		this.qna_view_cnt = qna_view_cnt;
	}

	public int getQna_group() {
		return qna_group;
	}

	public void setQna_group(int qna_group) {
		this.qna_group = qna_group;
	}

	public int getQna_level() {
		return qna_level;
	}

	public void setQna_level(int qna_level) {
		this.qna_level = qna_level;
	}

	
}
