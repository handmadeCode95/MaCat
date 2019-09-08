package com.macat.dto;

public class DateDTO {
	
	private String year, month, date;
	private String today, oneWeekAgo, oneMonthAgo, threeMonthAgo, sixMonthAgo, oneYearAgo;
	
	public DateDTO() {

	}

	public DateDTO(String year, String month, String date, String today, String oneWeekAgo, String oneMonthAgo, String threeMonthAgo,
			String sixMonthAgo, String oneYearAgo) {
		super();
		this.year = year;
		this.month = month;
		this.date = date;
		this.today = today;
		this.oneWeekAgo = oneWeekAgo;
		this.oneMonthAgo = oneMonthAgo;
		this.threeMonthAgo = threeMonthAgo;
		this.sixMonthAgo = sixMonthAgo;
		this.oneYearAgo = oneYearAgo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getOneWeekAgo() {
		return oneWeekAgo;
	}

	public void setOneWeekAgo(String oneWeekAgo) {
		this.oneWeekAgo = oneWeekAgo;
	}

	public String getOneMonthAgo() {
		return oneMonthAgo;
	}

	public void setOneMonthAgo(String oneMonthAgo) {
		this.oneMonthAgo = oneMonthAgo;
	}

	public String getThreeMonthAgo() {
		return threeMonthAgo;
	}

	public void setThreeMonthAgo(String threeMonthAgo) {
		this.threeMonthAgo = threeMonthAgo;
	}

	public String getSixMonthAgo() {
		return sixMonthAgo;
	}

	public void setSixMonthAgo(String sixMonthAgo) {
		this.sixMonthAgo = sixMonthAgo;
	}

	public String getOneYearAgo() {
		return oneYearAgo;
	}

	public void setOneYearAgo(String oneYearAgo) {
		this.oneYearAgo = oneYearAgo;
	}
	
}
