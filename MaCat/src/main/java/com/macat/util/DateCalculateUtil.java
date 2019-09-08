package com.macat.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculateUtil {
	
	public static String getToday() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	public static String addDate(int date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE , date);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	public static String addMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH , month);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	public static String addYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR , year);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}
	
}
