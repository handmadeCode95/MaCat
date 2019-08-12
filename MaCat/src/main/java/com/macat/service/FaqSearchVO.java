package com.macat.service;

public class FaqSearchVO {
	
	private String faq_ctgry, faq_sn, faq_sj, faq_name, faq_id, and_or_chk;
	private int begin, end; // 페이징
	
	public FaqSearchVO() {

	}
	
	public FaqSearchVO(String faq_ctgry, String faq_sn, String faq_sj, String faq_name, String faq_id,
			String and_or_chk, int begin, int end) {
		super();
		this.faq_ctgry = faq_ctgry;
		this.faq_sn = faq_sn;
		this.faq_sj = faq_sj;
		this.faq_name = faq_name;
		this.faq_id = faq_id;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}

	public String getFaq_ctgry() {
		return faq_ctgry;
	}

	public void setFaq_ctgry(String faq_ctgry) {
		this.faq_ctgry = faq_ctgry;
	}

	public String getFaq_sn() {
		return faq_sn;
	}

	public void setFaq_sn(String faq_sn) {
		this.faq_sn = faq_sn;
	}

	public String getFaq_sj() {
		return faq_sj;
	}

	public void setFaq_sj(String faq_sj) {
		this.faq_sj = faq_sj;
	}

	public String getFaq_name() {
		return faq_name;
	}

	public void setFaq_name(String faq_name) {
		this.faq_name = faq_name;
	}

	public String getFaq_id() {
		return faq_id;
	}

	public void setFaq_id(String faq_id) {
		this.faq_id = faq_id;
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
