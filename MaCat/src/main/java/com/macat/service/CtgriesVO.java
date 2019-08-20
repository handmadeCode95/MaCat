package com.macat.service;

public class CtgriesVO {
	
	private String ctgry_nm;
	private int ctgry_ord, ctgry_group, ctgry_level;
	
	public CtgriesVO() {

	}

	public CtgriesVO(String ctgry_nm, int ctgry_ord, int ctgry_group, int ctgry_level) {
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

	public int getCtgry_ord() {
		return ctgry_ord;
	}

	public void setCtgry_ord(int ctgry_ord) {
		this.ctgry_ord = ctgry_ord;
	}

	public int getCtgry_group() {
		return ctgry_group;
	}

	public void setCtgry_group(int ctgry_group) {
		this.ctgry_group = ctgry_group;
	}

	public int getCtgry_level() {
		return ctgry_level;
	}

	public void setCtgry_level(int ctgry_level) {
		this.ctgry_level = ctgry_level;
	}
}
