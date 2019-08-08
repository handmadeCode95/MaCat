package com.macat.service;

public class QnaVO {
	
	private String qna_sn, qna_sj, qna_name, qna_id, qna_cn, qna_reg_date, mber_sn;
	private int qna_rdcnt, qna_group, qna_level, qna_ans_chk;

	public QnaVO() {

	}

	public QnaVO(String qna_sn, String qna_sj, String qna_name, String qna_id, String qna_cn, String qna_reg_date,
			String mber_sn, int qna_rdcnt, int qna_group, int qna_level, int qna_ans_chk) {
		super();
		this.qna_sn = qna_sn;
		this.qna_sj = qna_sj;
		this.qna_name = qna_name;
		this.qna_id = qna_id;
		this.qna_cn = qna_cn;
		this.qna_reg_date = qna_reg_date;
		this.mber_sn = mber_sn;
		this.qna_rdcnt = qna_rdcnt;
		this.qna_group = qna_group;
		this.qna_level = qna_level;
		this.qna_ans_chk = qna_ans_chk;
	}

	public String getQna_sn() {
		return qna_sn;
	}

	public void setQna_sn(String qna_sn) {
		this.qna_sn = qna_sn;
	}

	public String getQna_sj() {
		return qna_sj;
	}

	public void setQna_sj(String qna_sj) {
		this.qna_sj = qna_sj;
	}

	public String getQna_name() {
		return qna_name;
	}

	public void setQna_name(String qna_name) {
		this.qna_name = qna_name;
	}

	public String getQna_id() {
		return qna_id;
	}

	public void setQna_id(String qna_id) {
		this.qna_id = qna_id;
	}

	public String getQna_cn() {
		return qna_cn;
	}

	public void setQna_cn(String qna_cn) {
		this.qna_cn = qna_cn;
	}

	public String getQna_reg_date() {
		return qna_reg_date;
	}

	public void setQna_reg_date(String qna_reg_date) {
		this.qna_reg_date = qna_reg_date;
	}

	public String getMber_sn() {
		return mber_sn;
	}

	public void setMber_sn(String mber_sn) {
		this.mber_sn = mber_sn;
	}

	public int getQna_rdcnt() {
		return qna_rdcnt;
	}

	public void setQna_rdcnt(int qna_rdcnt) {
		this.qna_rdcnt = qna_rdcnt;
	}

	public int getQna_group() {
		return qna_group;
	}

	public void setQna_group(int qna_group) {
		this.qna_group = qna_group;
	}

	public int getQna_level() {
		return qna_level;
	}

	public void setQna_level(int qna_level) {
		this.qna_level = qna_level;
	}

	public int getQna_ans_chk() {
		return qna_ans_chk;
	}

	public void setQna_ans_chk(int qna_ans_chk) {
		this.qna_ans_chk = qna_ans_chk;
	}
}
