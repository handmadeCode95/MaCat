package com.macat.service;

public class QnaSearchVO {
	
	private String qna_sn, qna_sj, qna_name, qna_id, qna_reg_date_start, qna_reg_date_end, view_answer, view_answered_qna, and_or_chk;
	private int begin, end; // 페이징
	
	public QnaSearchVO() {

	}

	public QnaSearchVO(String qna_sn, String qna_sj, String qna_name, String qna_id, String qna_reg_date_start,
			String qna_reg_date_end, String view_answer, String view_answered_qna, String and_or_chk, int begin,
			int end) {
		super();
		this.qna_sn = qna_sn;
		this.qna_sj = qna_sj;
		this.qna_name = qna_name;
		this.qna_id = qna_id;
		this.qna_reg_date_start = qna_reg_date_start;
		this.qna_reg_date_end = qna_reg_date_end;
		this.view_answer = view_answer;
		this.view_answered_qna = view_answered_qna;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getQna_sn() {
		return qna_sn;
	}

	public void setQna_sn(String qna_sn) {
		this.qna_sn = qna_sn;
	}

	public String getQna_sj() {
		return qna_sj;
	}

	public void setQna_sj(String qna_sj) {
		this.qna_sj = qna_sj;
	}

	public String getQna_name() {
		return qna_name;
	}

	public void setQna_name(String qna_name) {
		this.qna_name = qna_name;
	}

	public String getQna_id() {
		return qna_id;
	}

	public void setQna_id(String qna_id) {
		this.qna_id = qna_id;
	}

	public String getQna_reg_date_start() {
		return qna_reg_date_start;
	}

	public void setQna_reg_date_start(String qna_reg_date_start) {
		this.qna_reg_date_start = qna_reg_date_start;
	}

	public String getQna_reg_date_end() {
		return qna_reg_date_end;
	}

	public void setQna_reg_date_end(String qna_reg_date_end) {
		this.qna_reg_date_end = qna_reg_date_end;
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

	public String getView_answer() {
		return view_answer;
	}

	public void setView_answer(String view_answer) {
		this.view_answer = view_answer;
	}

	public String getView_answered_qna() {
		return view_answered_qna;
	}

	public void setView_answered_qna(String view_answered_qna) {
		this.view_answered_qna = view_answered_qna;
	}
}
