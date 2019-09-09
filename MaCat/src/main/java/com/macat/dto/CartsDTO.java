package com.macat.dto;

import java.io.Serializable;

public class CartsDTO implements Serializable {
	
	private static final long serialVersionUID = -4558666853314302134L;
	
	
	private String cart_sq, prduct_sq, mber_sq, ctgry_nm, cart_color, prduct_nm, prduct_thumb_nm;
	private int prduct_price, prduct_dlvy_price, prduct_dced_price, cart_amt, prduct_dc = 0, prduct_dc_pt = 0;

	public CartsDTO() {

	}

	public CartsDTO(String cart_sq, String prduct_sq, String mber_sq, String ctgry_nm, int cart_amt,
			String cart_color, String prduct_nm, String prduct_thumb_nm, int prduct_price, int prduct_dlvy_price,
			int prduct_dced_price, int prduct_dc, int prduct_dc_pt) {
		super();
		this.cart_sq = cart_sq;
		this.prduct_sq = prduct_sq;
		this.mber_sq = mber_sq;
		this.ctgry_nm = ctgry_nm;
		this.cart_amt = cart_amt;
		this.cart_color = cart_color;
		this.prduct_nm = prduct_nm;
		this.prduct_thumb_nm = prduct_thumb_nm;
		this.prduct_price = prduct_price;
		this.prduct_dlvy_price = prduct_dlvy_price;
		this.prduct_dced_price = prduct_dced_price;
		this.prduct_dc = prduct_dc;
		this.prduct_dc_pt = prduct_dc_pt;
	}

	public String getCart_sq() {
		return cart_sq;
	}

	public void setCart_sq(String cart_sq) {
		this.cart_sq = cart_sq;
	}

	public String getPrduct_sq() {
		return prduct_sq;
	}

	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getCtgry_nm() {
		return ctgry_nm;
	}

	public void setCtgry_nm(String ctgry_nm) {
		this.ctgry_nm = ctgry_nm;
	}

	public int getCart_amt() {
		return cart_amt;
	}

	public void setCart_amt(int cart_amt) {
		this.cart_amt = cart_amt;
	}

	public String getCart_color() {
		return cart_color;
	}

	public void setCart_color(String cart_color) {
		this.cart_color = cart_color;
	}

	public String getPrduct_nm() {
		return prduct_nm;
	}

	public void setPrduct_nm(String prduct_nm) {
		this.prduct_nm = prduct_nm;
	}

	public String getPrduct_thumb_nm() {
		return prduct_thumb_nm;
	}

	public void setPrduct_thumb_nm(String prduct_thumb_nm) {
		this.prduct_thumb_nm = prduct_thumb_nm;
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
	
	public int getPrduct_dc() {
		return prduct_dc;
	}

	public void setPrduct_dc(int prduct_dc) {
		this.prduct_dc = prduct_dc;
	}

	public int getPrduct_dc_pt() {
		return prduct_dc_pt;
	}

	public void setPrduct_dc_pt(int prduct_dc_pt) {
		this.prduct_dc_pt = prduct_dc_pt;
	}

	public int getPrduct_dced_price() {
		return prduct_dced_price;
	}

	public void setPrduct_dced_price(int prduct_dced_price) {
		this.prduct_dced_price = prduct_dced_price;
	}
	
}
