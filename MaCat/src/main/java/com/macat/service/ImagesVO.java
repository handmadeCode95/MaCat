package com.macat.service;

public class ImagesVO {
	
	private String img_sq, img_nm, prduct_sq, event_sq, faq_sq, re_sq, not_sq, qna_sq;
	private int img_main_fl, img_thumb_fl;
	
	public ImagesVO() {

	}

	public ImagesVO(String img_sq, String img_nm, String prduct_sq, String event_sq, String faq_sq, String re_sq,
			String not_sq, String qna_sq, int img_main_fl, int img_thumb_fl) {
		super();
		this.img_sq = img_sq;
		this.img_nm = img_nm;
		this.prduct_sq = prduct_sq;
		this.event_sq = event_sq;
		this.faq_sq = faq_sq;
		this.re_sq = re_sq;
		this.not_sq = not_sq;
		this.qna_sq = qna_sq;
		this.img_main_fl = img_main_fl;
		this.img_thumb_fl = img_thumb_fl;
	}

	public String getImg_sq() {
		return img_sq;
	}

	public void setImg_sq(String img_sq) {
		this.img_sq = img_sq;
	}

	public String getImg_nm() {
		return img_nm;
	}

	public void setImg_nm(String img_nm) {
		this.img_nm = img_nm;
	}

	public String getPrduct_sq() {
		return prduct_sq;
	}

	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}

	public String getEvent_sq() {
		return event_sq;
	}

	public void setEvent_sq(String event_sq) {
		this.event_sq = event_sq;
	}

	public String getFaq_sq() {
		return faq_sq;
	}

	public void setFaq_sq(String faq_sq) {
		this.faq_sq = faq_sq;
	}

	public String getRe_sq() {
		return re_sq;
	}

	public void setRe_sq(String re_sq) {
		this.re_sq = re_sq;
	}

	public String getNot_sq() {
		return not_sq;
	}

	public void setNot_sq(String not_sq) {
		this.not_sq = not_sq;
	}

	public String getQna_sq() {
		return qna_sq;
	}

	public void setQna_sq(String qna_sq) {
		this.qna_sq = qna_sq;
	}

	public int getImg_main_fl() {
		return img_main_fl;
	}

	public void setImg_main_fl(int img_main_fl) {
		this.img_main_fl = img_main_fl;
	}

	public int getImg_thumb_fl() {
		return img_thumb_fl;
	}

	public void setImg_thumb_fl(int img_thumb_fl) {
		this.img_thumb_fl = img_thumb_fl;
	}
	
}
