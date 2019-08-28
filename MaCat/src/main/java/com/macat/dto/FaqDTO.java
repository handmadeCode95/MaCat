package com.macat.dto;

public class FaqDTO {
	
	private String faq_sq, faq_sj, faq_cn, qc_nm, mber_sq;

	public FaqDTO() {
		
	}
	
	public FaqDTO(String faq_sq, String faq_sj, String faq_cn, String qc_nm, String mber_sq) {
		super();
		this.faq_sq = faq_sq;
		this.faq_sj = faq_sj;
		this.faq_cn = faq_cn;
		this.qc_nm = qc_nm;
		this.mber_sq = mber_sq;
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

	public String getFaq_cn() {
		return faq_cn;
	}

	public void setFaq_cn(String faq_cn) {
		this.faq_cn = faq_cn;
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

	
}
