package com.macat.dto;

public class PointDTO implements AdminDTO{

	private String point_sq, mber_sq, prduct_sq, order_sq, point_save_dt, point_use_dt, point_save, point_use;
	
	public PointDTO() {	}

	public PointDTO(String point_sq, String mber_sq, String prduct_sq, String order_sq, String point_save_dt,
			String point_use_dt, String point_save, String point_use) {
		super();
		this.point_sq = point_sq;
		this.mber_sq = mber_sq;
		this.prduct_sq = prduct_sq;
		this.order_sq = order_sq;
		this.point_save_dt = point_save_dt;
		this.point_use_dt = point_use_dt;
		this.point_save = point_save;
		this.point_use = point_use;
	}

	public String getPoint_sq() {
		return point_sq;
	}

	public void setPoint_sq(String point_sq) {
		this.point_sq = point_sq;
	}

	public String getMber_sq() {
		return mber_sq;
	}

	public void setMber_sq(String mber_sq) {
		this.mber_sq = mber_sq;
	}

	public String getPrduct_sq() {
		return prduct_sq;
	}

	public void setPrduct_sq(String prduct_sq) {
		this.prduct_sq = prduct_sq;
	}

	public String getOrder_sq() {
		return order_sq;
	}

	public void setOrder_sq(String order_sq) {
		this.order_sq = order_sq;
	}

	public String getPoint_save_dt() {
		return point_save_dt;
	}

	public void setPoint_save_dt(String point_save_dt) {
		this.point_save_dt = point_save_dt;
	}

	public String getPoint_use_dt() {
		return point_use_dt;
	}

	public void setPoint_use_dt(String point_use_dt) {
		this.point_use_dt = point_use_dt;
	}

	public String getPoint_save() {
		return point_save;
	}

	public void setPoint_save(String point_save) {
		this.point_save = point_save;
	}

	public String getPoint_use() {
		return point_use;
	}

	public void setPoint_use(String point_use) {
		this.point_use = point_use;
	}
	
}