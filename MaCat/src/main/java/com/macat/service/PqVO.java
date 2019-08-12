package com.macat.service;

public class PqVO {
	
	private String pq_sn, pq_sj, pq_name, pq_id, pq_pw, pq_cn, pq_reg_date, pq_ans_chk, mber_sn, prduct_sn;
	private int pq_group, pq_level;

	public PqVO(String pq_sn, String pq_sj, String pq_name, String pq_id, String pq_pw, String pq_cn,
			String pq_reg_date, String pq_ans_chk, String mber_sn, String prduct_sn, int pq_group, int pq_level) {
		super();
		this.pq_sn = pq_sn;
		this.pq_sj = pq_sj;
		this.pq_name = pq_name;
		this.pq_id = pq_id;
		this.pq_pw = pq_pw;
		this.pq_cn = pq_cn;
		this.pq_reg_date = pq_reg_date;
		this.pq_ans_chk = pq_ans_chk;
		this.mber_sn = mber_sn;
		this.prduct_sn = prduct_sn;
		this.pq_group = pq_group;
		this.pq_level = pq_level;
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

	public String getPq_pw() {
		return pq_pw;
	}

	public void setPq_pw(String pq_pw) {
		this.pq_pw = pq_pw;
	}

	public String getPq_cn() {
		return pq_cn;
	}

	public void setPq_cn(String pq_cn) {
		this.pq_cn = pq_cn;
	}

	public String getPq_reg_date() {
		return pq_reg_date;
	}

	public void setPq_reg_date(String pq_reg_date) {
		this.pq_reg_date = pq_reg_date;
	}

	public int getPq_group() {
		return pq_group;
	}

	public void setPq_group(int pq_group) {
		this.pq_group = pq_group;
	}

	public int getPq_level() {
		return pq_level;
	}

	public void setPq_level(int pq_level) {
		this.pq_level = pq_level;
	}

	public String getPq_ans_chk() {
		return pq_ans_chk;
	}

	public void setPq_ans_chk(String pq_ans_chk) {
		this.pq_ans_chk = pq_ans_chk;
	}

	public String getMber_sn() {
		return mber_sn;
	}

	public void setMber_sn(String mber_sn) {
		this.mber_sn = mber_sn;
	}

	public String getPrduct_sn() {
		return prduct_sn;
	}

	public void setPrduct_sn(String prduct_sn) {
		this.prduct_sn = prduct_sn;
	}
}
