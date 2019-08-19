package com.macat.service;

public class QnaCtgriesVO {
	
	private String qc_nm, qc_ord;

	public QnaCtgriesVO() {

	}

	public QnaCtgriesVO(String qc_nm, String qc_ord) {
		super();
		this.qc_nm = qc_nm;
		this.qc_ord = qc_ord;
	}

	public String getQc_nm() {
		return qc_nm;
	}

	public void setQc_nm(String qc_nm) {
		this.qc_nm = qc_nm;
	}

	public String getQc_ord() {
		return qc_ord;
	}

	public void setQc_ord(String qc_ord) {
		this.qc_ord = qc_ord;
	}
	
}
