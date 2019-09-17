package com.macat.dto;

public class PointSearchDTO implements AdminSearchDTO{
	
	private String point_sq, mber_sq, prduct_sq, order_sq, point_save_dt_start, point_save_dt_end, point_use_dt_start,
			point_use_dt_end, point_save, point_use, and_or_chk;
	private int begin, end;	// 페이징
	
	public PointSearchDTO() {	}

	public PointSearchDTO(String point_sq, String mber_sq, String prduct_sq, String order_sq,
			String point_save_dt_start, String point_save_dt_end, String point_use_dt_start, String point_use_dt_end,
			String point_save, String point_use, String and_or_chk, int begin, int end) {
		super();
		this.point_sq = point_sq;
		this.mber_sq = mber_sq;
		this.prduct_sq = prduct_sq;
		this.order_sq = order_sq;
		this.point_save_dt_start = point_save_dt_start;
		this.point_save_dt_end = point_save_dt_end;
		this.point_use_dt_start = point_use_dt_start;
		this.point_use_dt_end = point_use_dt_end;
		this.point_save = point_save;
		this.point_use = point_use;
		this.and_or_chk = and_or_chk;
		this.begin = begin;
		this.end = end;
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

	public String getPoint_save_dt_start() {
		return point_save_dt_start;
	}

	public void setPoint_save_dt_start(String point_save_dt_start) {
		this.point_save_dt_start = point_save_dt_start;
	}

	public String getPoint_save_dt_end() {
		return point_save_dt_end;
	}

	public void setPoint_save_dt_end(String point_save_dt_end) {
		this.point_save_dt_end = point_save_dt_end;
	}

	public String getPoint_use_dt_start() {
		return point_use_dt_start;
	}

	public void setPoint_use_dt_start(String point_use_dt_start) {
		this.point_use_dt_start = point_use_dt_start;
	}

	public String getPoint_use_dt_end() {
		return point_use_dt_end;
	}

	public void setPoint_use_dt_end(String point_use_dt_end) {
		this.point_use_dt_end = point_use_dt_end;
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