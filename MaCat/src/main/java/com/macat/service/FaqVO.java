package com.macat.service;

public class FaqVO {
	
	private String faq_sn, faq_sj, faq_name, faq_cn, faq_ctgry, mber_sn;

	public FaqVO(String faq_sn, String faq_sj, String faq_name, String faq_cn, String faq_ctgry, String mber_sn) {
		super();
		this.faq_sn = faq_sn;
		this.faq_sj = faq_sj;
		this.faq_name = faq_name;
		this.faq_cn = faq_cn;
		this.faq_ctgry = faq_ctgry;
		this.mber_sn = mber_sn;
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

	public String getFaq_cn() {
		return faq_cn;
	}

	public void setFaq_cn(String faq_cn) {
		this.faq_cn = faq_cn;
	}

	public String getFaq_ctgry() {
		return faq_ctgry;
	}

	public void setFaq_ctgry(String faq_ctgry) {
		this.faq_ctgry = faq_ctgry;
	}

	public String getMber_sn() {
		return mber_sn;
	}

	public void setMber_sn(String mber_sn) {
		this.mber_sn = mber_sn;
	}
}
