package com.macat.service;

public class PriceUtil {
	
	public static int getDc(int price, int dc, int dc_pt, int amt) {
		int save = 0;
		if (dc > 0) {
			save = dc * amt;
		}else if (dc_pt > 0 && price > 99) {
			save = (price * dc_pt / 100) * amt;
		}
		return save;
	}

}
