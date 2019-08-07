package com.macat.service;

public class ImagesVO {
	
	private String img_sn, img, prduct_sn, event_sn, faq_sn, re_sn, pq_sn, not_sn, qna_sn;
	private int img_thumb;
	
	public ImagesVO() {

	}
	
	public ImagesVO(String img_sn, String img, int img_thumb, String prduct_sn, String event_sn, String faq_sn,
			String re_sn, String pq_sn, String not_sn, String qna_sn) {
		super();
		this.img_sn = img_sn;
		this.img = img;
		this.img_thumb = img_thumb;
		this.prduct_sn = prduct_sn;
		this.event_sn = event_sn;
		this.faq_sn = faq_sn;
		this.re_sn = re_sn;
		this.pq_sn = pq_sn;
		this.not_sn = not_sn;
		this.qna_sn = qna_sn;
	}

	public String getImg_sn() {
		return img_sn;
	}

	public void setImg_sn(String img_sn) {
		this.img_sn = img_sn;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getImg_thumb() {
		return img_thumb;
	}

	public void setImg_thumb(int img_thumb) {
		this.img_thumb = img_thumb;
	}

	public String getPrduct_sn() {
		return prduct_sn;
	}

	public void setPrduct_sn(String prduct_sn) {
		this.prduct_sn = prduct_sn;
	}

	public String getEvent_sn() {
		return event_sn;
	}

	public void setEvent_sn(String event_sn) {
		this.event_sn = event_sn;
	}

	public String getFaq_sn() {
		return faq_sn;
	}

	public void setFaq_sn(String faq_sn) {
		this.faq_sn = faq_sn;
	}

	public String getRe_sn() {
		return re_sn;
	}

	public void setRe_sn(String re_sn) {
		this.re_sn = re_sn;
	}

	public String getPq_sn() {
		return pq_sn;
	}

	public void setPq_sn(String pq_sn) {
		this.pq_sn = pq_sn;
	}

	public String getNot_sn() {
		return not_sn;
	}

	public void setNot_sn(String not_sn) {
		this.not_sn = not_sn;
	}

	public String getQna_sn() {
		return qna_sn;
	}

	public void setQna_sn(String qna_sn) {
		this.qna_sn = qna_sn;
	}
}
