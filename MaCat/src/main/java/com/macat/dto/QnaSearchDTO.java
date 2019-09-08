package com.macat.dto;

public class QnaSearchDTO implements AdminSearchDTO {
	
	private String qc_nm, qna_sq, qna_sj, qna_nm, qna_id, qna_reg_dt_start, qna_reg_dt_end, view, and_or_chk;
	private int begin, end; // 페이징
	
	public QnaSearchDTO() {

	}

	public QnaSearchDTO(String qc_nm, String qna_sq, String qna_sj, String qna_nm, String qna_id,
			String qna_reg_dt_start, String qna_reg_dt_end, String view, String and_or_chk, int begin, int end) {
		super();
		this.qc_nm = qc_nm;
		this.qna_sq = qna_sq;
		this.qna_sj = qna_sj;
		this.qna_nm = qna_nm;
		this.qna_id = qna_id;
		this.qna_reg_dt_start = qna_reg_dt_start;
		this.qna_reg_dt_end = qna_reg_dt_end;
		this.view = view;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getQc_nm() {
		return qc_nm;
	}

	public void setQc_nm(String qc_nm) {
		this.qc_nm = qc_nm;
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

	public String getQna_reg_dt_start() {
		return qna_reg_dt_start;
	}

	public void setQna_reg_dt_start(String qna_reg_dt_start) {
		this.qna_reg_dt_start = qna_reg_dt_start;
	}

	public String getQna_reg_dt_end() {
		return qna_reg_dt_end;
	}

	public void setQna_reg_dt_end(String qna_reg_dt_end) {
		this.qna_reg_dt_end = qna_reg_dt_end;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
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
