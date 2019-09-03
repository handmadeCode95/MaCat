package com.macat.dto;

public class ProductsSearchDTO {
	
	private String prduct_sq, prduct_nm, prduct_amt, prduct_cd, ctgry_nm, prduct_dlvy_price_start, prduct_dlvy_price_end,  
						prduct_reg_dt_start, prduct_reg_dt_end, prduct_price_start, prduct_price_end, prduct_dc_start, prduct_dc_end, and_or_chk;
	private int begin, end;
	
	public ProductsSearchDTO() {
		
	}
	
	public ProductsSearchDTO(String prduct_sq, String prduct_nm, String prduct_amt, String prduct_cd, String ctgry_nm,
			String prduct_dlvy_price_start, String prduct_dlvy_price_end, String prduct_reg_dt_start,
			String prduct_reg_dt_end, String prduct_price_start, String prduct_price_end, String prduct_dc_start,
			String prduct_dc_end, String and_or_chk, int begin, int end) {
		super();
		this.prduct_sq = prduct_sq;
		this.prduct_nm = prduct_nm;
		this.prduct_amt = prduct_amt;
		this.prduct_cd = prduct_cd;
		this.ctgry_nm = ctgry_nm;
		this.prduct_dlvy_price_start = prduct_dlvy_price_start;
		this.prduct_dlvy_price_end = prduct_dlvy_price_end;
		this.prduct_reg_dt_start = prduct_reg_dt_start;
		this.prduct_reg_dt_end = prduct_reg_dt_end;
		this.prduct_price_start = prduct_price_start;
		this.prduct_price_end = prduct_price_end;
		this.prduct_dc_start = prduct_dc_start;
		this.prduct_dc_end = prduct_dc_end;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}
	public String getPrduct_sq() {
		return prduct_sq;
	}
	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}
	public String getPrduct_nm() {
		return prduct_nm;
	}
	public void setPrduct_nm(String prduct_nm) {
		this.prduct_nm = prduct_nm;
	}
	public String getPrduct_amt() {
		return prduct_amt;
	}
	public void setPrduct_amt(String prduct_amt) {
		this.prduct_amt = prduct_amt;
	}
	public String getPrduct_cd() {
		return prduct_cd;
	}
	public void setPrduct_cd(String prduct_cd) {
		this.prduct_cd = prduct_cd;
	}
	public String getCtgry_nm() {
		return ctgry_nm;
	}
	public void setCtgry_nm(String ctgry_nm) {
		this.ctgry_nm = ctgry_nm;
	}
	public String getPrduct_dlvy_price_start() {
		return prduct_dlvy_price_start;
	}
	public void setPrduct_dlvy_price_start(String prduct_dlvy_price_start) {
		this.prduct_dlvy_price_start = prduct_dlvy_price_start;
	}
	public String getPrduct_dlvy_price_end() {
		return prduct_dlvy_price_end;
	}
	public void setPrduct_dlvy_price_end(String prduct_dlvy_price_end) {
		this.prduct_dlvy_price_end = prduct_dlvy_price_end;
	}
	public String getPrduct_reg_dt_start() {
		return prduct_reg_dt_start;
	}
	public void setPrduct_reg_dt_start(String prduct_reg_dt_start) {
		this.prduct_reg_dt_start = prduct_reg_dt_start;
	}
	public String getPrduct_reg_dt_end() {
		return prduct_reg_dt_end;
	}
	public void setPrduct_reg_dt_end(String prduct_reg_dt_end) {
		this.prduct_reg_dt_end = prduct_reg_dt_end;
	}
	public String getPrduct_price_start() {
		return prduct_price_start;
	}
	public void setPrduct_price_start(String prduct_price_start) {
		this.prduct_price_start = prduct_price_start;
	}
	public String getPrduct_price_end() {
		return prduct_price_end;
	}
	public void setPrduct_price_end(String prduct_price_end) {
		this.prduct_price_end = prduct_price_end;
	}
	public String getPrduct_dc_start() {
		return prduct_dc_start;
	}
	public void setPrduct_dc_start(String prduct_dc_start) {
		this.prduct_dc_start = prduct_dc_start;
	}
	public String getPrduct_dc_end() {
		return prduct_dc_end;
	}
	public void setPrduct_dc_end(String prduct_dc_end) {
		this.prduct_dc_end = prduct_dc_end;
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
