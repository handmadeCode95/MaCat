package com.macat.service;

public class PqSearchVO {
	
	private String pq_sn, prduct_sn, pq_sj, pq_name, pq_id, pq_reg_date_start, pq_reg_date_end, view, and_or_chk;
	private int begin, end; // 페이징
	
	public PqSearchVO() {

	}

	public PqSearchVO(String pq_sn, String prduct_sn, String pq_sj, String pq_name, String pq_id, String pq_reg_date_start,
			String pq_reg_date_end, String view, String and_or_chk, int begin, int end) {
		super();
		this.pq_sn = pq_sn;
		this.prduct_sn = prduct_sn;
		this.pq_sj = pq_sj;
		this.pq_name = pq_name;
		this.pq_id = pq_id;
		this.pq_reg_date_start = pq_reg_date_start;
		this.pq_reg_date_end = pq_reg_date_end;
		this.view = view;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
	}
	
	public String getPrduct_sn() {
		return prduct_sn;
	}

	public void setPrduct_sn(String prduct_sn) {
		this.prduct_sn = prduct_sn;
	}

	public String getPq_sn() {
		return pq_sn;
	}

	public void setPq_sn(String pq_sn) {
		this.pq_sn = pq_sn;
	}

	public String getPq_sj() {
		return pq_sj;
	}

	public void setPq_sj(String pq_sj) {
		this.pq_sj = pq_sj;
	}

	public String getPq_name() {
		return pq_name;
	}

	public void setPq_name(String pq_name) {
		this.pq_name = pq_name;
	}

	public String getPq_id() {
		return pq_id;
	}

	public void setPq_id(String pq_id) {
		this.pq_id = pq_id;
	}

	public String getPq_reg_date_start() {
		return pq_reg_date_start;
	}

	public void setPq_reg_date_start(String pq_reg_date_start) {
		this.pq_reg_date_start = pq_reg_date_start;
	}

	public String getPq_reg_date_end() {
		return pq_reg_date_end;
	}

	public void setPq_reg_date_end(String pq_reg_date_end) {
		this.pq_reg_date_end = pq_reg_date_end;
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

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

}
