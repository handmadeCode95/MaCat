package com.macat.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductsDTO {
	
	private String prduct_sq, prduct_reg_dt, prduct_dom_dt, prduct_amt, prduct_view_cnt,
				   prduct_sale_sum, prduct_as, prduct_maker, prduct_coo, prduct_matr, prduct_size, prduct_nm, prduct_qa, prduct_thumb_nm,
				   ctgry_nm, prduct_cd, prduct_cn, main_img_nm, sub_img1_nm, sub_img2_nm, sub_img3_nm;
	private float prduct_rating_avg;
	private int prduct_ctgry_group, prduct_rating_round, prduct_price, prduct_dlvy_price, prduct_point, prduct_dced_price,
				prduct_save_pt = 0, prduct_save = 0, prduct_dc_pt = 0, prduct_dc = 0;
	private List<String> colors;
	private MultipartFile main_img, sub_img1, sub_img2, sub_img3;


	public ProductsDTO() {

	}

	public ProductsDTO(String prduct_sq, String prduct_reg_dt, String prduct_dom_dt, String prduct_amt,
			String prduct_view_cnt, String prduct_sale_sum, String prduct_as, String prduct_maker, String prduct_coo,
			String prduct_matr, String prduct_size, String prduct_nm, String prduct_qa, String prduct_thumb_nm,
			String ctgry_nm, String prduct_cd, String prduct_cn, String main_img_nm, String sub_img1_nm,
			String sub_img2_nm, String sub_img3_nm, float prduct_rating_avg, int prduct_ctgry_group,
			int prduct_rating_round, int prduct_price, int prduct_dlvy_price, int prduct_point, int prduct_dced_price,
			int prduct_save_pt, int prduct_save, int prduct_dc_pt, int prduct_dc, List<String> colors,
			MultipartFile main_img, MultipartFile sub_img1, MultipartFile sub_img2, MultipartFile sub_img3) {
		super();
		this.prduct_sq = prduct_sq;
		this.prduct_reg_dt = prduct_reg_dt;
		this.prduct_dom_dt = prduct_dom_dt;
		this.prduct_amt = prduct_amt;
		this.prduct_view_cnt = prduct_view_cnt;
		this.prduct_sale_sum = prduct_sale_sum;
		this.prduct_as = prduct_as;
		this.prduct_maker = prduct_maker;
		this.prduct_coo = prduct_coo;
		this.prduct_matr = prduct_matr;
		this.prduct_size = prduct_size;
		this.prduct_nm = prduct_nm;
		this.prduct_qa = prduct_qa;
		this.prduct_thumb_nm = prduct_thumb_nm;
		this.ctgry_nm = ctgry_nm;
		this.prduct_cd = prduct_cd;
		this.prduct_cn = prduct_cn;
		this.main_img_nm = main_img_nm;
		this.sub_img1_nm = sub_img1_nm;
		this.sub_img2_nm = sub_img2_nm;
		this.sub_img3_nm = sub_img3_nm;
		this.prduct_rating_avg = prduct_rating_avg;
		this.prduct_ctgry_group = prduct_ctgry_group;
		this.prduct_rating_round = prduct_rating_round;
		this.prduct_price = prduct_price;
		this.prduct_dlvy_price = prduct_dlvy_price;
		this.prduct_point = prduct_point;
		this.prduct_dced_price = prduct_dced_price;
		this.prduct_save_pt = prduct_save_pt;
		this.prduct_save = prduct_save;
		this.prduct_dc_pt = prduct_dc_pt;
		this.prduct_dc = prduct_dc;
		this.colors = colors;
		this.main_img = main_img;
		this.sub_img1 = sub_img1;
		this.sub_img2 = sub_img2;
		this.sub_img3 = sub_img3;
	}

	public String getPrduct_sq() {
		return prduct_sq;
	}

	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}

	public String getPrduct_reg_dt() {
		return prduct_reg_dt;
	}

	public void setPrduct_reg_dt(String prduct_reg_dt) {
		this.prduct_reg_dt = prduct_reg_dt;
	}

	public String getPrduct_dom_dt() {
		return prduct_dom_dt;
	}

	public void setPrduct_dom_dt(String prduct_dom_dt) {
		this.prduct_dom_dt = prduct_dom_dt;
	}

	public String getPrduct_amt() {
		return prduct_amt;
	}

	public void setPrduct_amt(String prduct_amt) {
		this.prduct_amt = prduct_amt;
	}

	public int getPrduct_price() {
		return prduct_price;
	}

	public void setPrduct_price(int prduct_price) {
		this.prduct_price = prduct_price;
	}

	public int getPrduct_dlvy_price() {
		return prduct_dlvy_price;
	}

	public void setPrduct_dlvy_price(int prduct_dlvy_price) {
		this.prduct_dlvy_price = prduct_dlvy_price;
	}

	public String getPrduct_view_cnt() {
		return prduct_view_cnt;
	}

	public void setPrduct_view_cnt(String prduct_view_cnt) {
		this.prduct_view_cnt = prduct_view_cnt;
	}

	public String getPrduct_sale_sum() {
		return prduct_sale_sum;
	}

	public void setPrduct_sale_sum(String prduct_sale_sum) {
		this.prduct_sale_sum = prduct_sale_sum;
	}

	public String getPrduct_as() {
		return prduct_as;
	}

	public void setPrduct_as(String prduct_as) {
		this.prduct_as = prduct_as;
	}

	public String getPrduct_maker() {
		return prduct_maker;
	}

	public void setPrduct_maker(String prduct_maker) {
		this.prduct_maker = prduct_maker;
	}

	public String getPrduct_coo() {
		return prduct_coo;
	}

	public void setPrduct_coo(String prduct_coo) {
		this.prduct_coo = prduct_coo;
	}

	public String getPrduct_matr() {
		return prduct_matr;
	}

	public void setPrduct_matr(String prduct_matr) {
		this.prduct_matr = prduct_matr;
	}

	public String getPrduct_size() {
		return prduct_size;
	}

	public void setPrduct_size(String prduct_size) {
		this.prduct_size = prduct_size;
	}

	public String getPrduct_nm() {
		return prduct_nm;
	}

	public void setPrduct_nm(String prduct_nm) {
		this.prduct_nm = prduct_nm;
	}

	public String getPrduct_qa() {
		return prduct_qa;
	}

	public void setPrduct_qa(String prduct_qa) {
		this.prduct_qa = prduct_qa;
	}

	public String getPrduct_thumb_nm() {
		return prduct_thumb_nm;
	}

	public void setPrduct_thumb_nm(String prduct_thumb_nm) {
		this.prduct_thumb_nm = prduct_thumb_nm;
	}

	public String getCtgry_nm() {
		return ctgry_nm;
	}

	public void setCtgry_nm(String ctgry_nm) {
		this.ctgry_nm = ctgry_nm;
	}

	public int getPrduct_dc_pt() {
		return prduct_dc_pt;
	}

	public void setPrduct_dc_pt(int prduct_dc_pt) {
		this.prduct_dc_pt = prduct_dc_pt;
	}

	public int getPrduct_save_pt() {
		return prduct_save_pt;
	}

	public void setPrduct_save_pt(int prduct_save_pt) {
		this.prduct_save_pt = prduct_save_pt;
	}

	public int getPrduct_dc() {
		return prduct_dc;
	}

	public void setPrduct_dc(int prduct_dc) {
		this.prduct_dc = prduct_dc;
	}

	public int getPrduct_save() {
		return prduct_save;
	}

	public void setPrduct_save(int prduct_save) {
		this.prduct_save = prduct_save;
	}

	public int getPrduct_point() {
		return prduct_point;
	}

	public void setPrduct_point(int prduct_point) {
		this.prduct_point = prduct_point;
	}

	public String getPrduct_cd() {
		return prduct_cd;
	}

	public void setPrduct_cd(String prduct_cd) {
		this.prduct_cd = prduct_cd;
	}

	public int getPrduct_ctgry_group() {
		return prduct_ctgry_group;
	}

	public void setPrduct_ctgry_group(int prduct_ctgry_group) {
		this.prduct_ctgry_group = prduct_ctgry_group;
	}

	public float getPrduct_rating_avg() {
		return prduct_rating_avg;
	}

	public void setPrduct_rating_avg(float prduct_rating_avg) {
		this.prduct_rating_avg = prduct_rating_avg;
	}

	public int getPrduct_rating_round() {
		return prduct_rating_round;
	}

	public void setPrduct_rating_round(int prduct_rating_round) {
		this.prduct_rating_round = prduct_rating_round;
	}

	public int getPrduct_dced_price() {
		return prduct_dced_price;
	}

	public void setPrduct_dced_price(int prduct_dced_price) {
		this.prduct_dced_price = prduct_dced_price;
	}

	public String getPrduct_cn() {
		return prduct_cn;
	}

	public void setPrduct_cn(String prduct_cn) {
		this.prduct_cn = prduct_cn;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public MultipartFile getMain_img() {
		return main_img;
	}

	public void setMain_img(MultipartFile main_img) {
		this.main_img = main_img;
	}

	public MultipartFile getSub_img1() {
		return sub_img1;
	}

	public void setSub_img1(MultipartFile sub_img1) {
		this.sub_img1 = sub_img1;
	}

	public MultipartFile getSub_img2() {
		return sub_img2;
	}

	public void setSub_img2(MultipartFile sub_img2) {
		this.sub_img2 = sub_img2;
	}

	public MultipartFile getSub_img3() {
		return sub_img3;
	}

	public void setSub_img3(MultipartFile sub_img3) {
		this.sub_img3 = sub_img3;
	}

	public String getMain_img_nm() {
		return main_img_nm;
	}

	public void setMain_img_nm(String main_img_nm) {
		this.main_img_nm = main_img_nm;
	}

	public String getSub_img1_nm() {
		return sub_img1_nm;
	}

	public void setSub_img1_nm(String sub_img1_nm) {
		this.sub_img1_nm = sub_img1_nm;
	}

	public String getSub_img2_nm() {
		return sub_img2_nm;
	}

	public void setSub_img2_nm(String sub_img2_nm) {
		this.sub_img2_nm = sub_img2_nm;
	}

	public String getSub_img3_nm() {
		return sub_img3_nm;
	}

	public void setSub_img3_nm(String sub_img3_nm) {
		this.sub_img3_nm = sub_img3_nm;
	}
	
}
