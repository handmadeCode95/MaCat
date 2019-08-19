package com.macat.service;

public class FaqSearchVO {
	
	private String qc_nm, faq_sq, faq_sj, and_or_chk;
	private int begin, end; // 페이징
	
	public FaqSearchVO() {

	}

	public FaqSearchVO(String qc_nm, String faq_sq, String faq_sj, String and_or_chk, int begin, int end) {
		super();
		this.qc_nm = qc_nm;
		this.faq_sq = faq_sq;
		this.faq_sj = faq_sj;
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

	public String getFaq_sq() {
		return faq_sq;
	}

	public void setFaq_sq(String faq_sq) {
		this.faq_sq = faq_sq;
	}

	public String getFaq_sj() {
		return faq_sj;
	}

	public void setFaq_sj(String faq_sj) {
		this.faq_sj = faq_sj;
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
