package com.macat.dto;

public class ReviewSearchDTO implements AdminSearchDTO{
	private String re_sn, re_sj, re_nm, re_id, re_reg_date_start, re_reg_date_end, re_rating, re_view_cnt, re_like,
				re_ans_st, and_or_chk;
	private int begin, end;
	
	public ReviewSearchDTO() {	}

	public ReviewSearchDTO(String re_sn, String re_sj, String re_nm, String re_id, String re_reg_date_start,
			String re_reg_date_end, String re_rating, String re_view_cnt, String re_like, String re_ans_st,
			String and_or_chk, int begin, int end) {
		super();
		this.re_sn = re_sn;
		this.re_sj = re_sj;
		this.re_nm = re_nm;
		this.re_id = re_id;
		this.re_reg_date_start = re_reg_date_start;
		this.re_reg_date_end = re_reg_date_end;
		this.re_rating = re_rating;
		this.re_view_cnt = re_view_cnt;
		this.re_like = re_like;
		this.re_ans_st = re_ans_st;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getRe_sn() {
		return re_sn;
	}

	public void setRe_sn(String re_sn) {
		this.re_sn = re_sn;
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

	public String getRe_id() {
		return re_id;
	}

	public void setRe_id(String re_id) {
		this.re_id = re_id;
	}

	public String getRe_reg_date_start() {
		return re_reg_date_start;
	}

	public void setRe_reg_date_start(String re_reg_date_start) {
		this.re_reg_date_start = re_reg_date_start;
	}

	public String getRe_reg_date_end() {
		return re_reg_date_end;
	}

	public void setRe_reg_date_end(String re_reg_date_end) {
		this.re_reg_date_end = re_reg_date_end;
	}

	public String getRe_rating() {
		return re_rating;
	}

	public void setRe_rating(String re_rating) {
		this.re_rating = re_rating;
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