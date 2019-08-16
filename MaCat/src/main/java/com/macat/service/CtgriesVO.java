package com.macat.service;

public class CtgriesVO {
	
	private String ctgry_nm, ctgry_ord, ctgry_group, ctgry_level;
	
	public CtgriesVO() {

	}

	public CtgriesVO(String ctgry_nm, String ctgry_ord, String ctgry_group, String ctgry_level) {
		super();
		this.ctgry_nm = ctgry_nm;
		this.ctgry_ord = ctgry_ord;
		this.ctgry_group = ctgry_group;
		this.ctgry_level = ctgry_level;
	}

	public String getCtgry_nm() {
		return ctgry_nm;
	}

	public void setCtgry_nm(String ctgry_nm) {
		this.ctgry_nm = ctgry_nm;
	}

	public String getCtgry_ord() {
		return ctgry_ord;
	}

	public void setCtgry_ord(String ctgry_ord) {
		this.ctgry_ord = ctgry_ord;
	}

	public String getCtgry_group() {
		return ctgry_group;
	}

	public void setCtgry_group(String ctgry_group) {
		this.ctgry_group = ctgry_group;
	}

	public String getCtgry_level() {
		return ctgry_level;
	}

	public void setCtgry_level(String ctgry_level) {
		this.ctgry_level = ctgry_level;
	}
}
