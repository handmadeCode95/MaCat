package com.macat.service;

public class PriceUtil {
	
	public static int getDc(int price, int dc, int dc_pt) {
		int save = 0;
		if (dc > 0) {
			save = dc;
		}else if (dc_pt > 0 && price > 99) {
			save = (price * dc_pt / 100);
		}
		return save;
	}

}
