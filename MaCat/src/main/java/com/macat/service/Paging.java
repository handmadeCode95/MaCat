package com.macat.service;

import com.macat.dto.FaqSearchDTO;
import com.macat.dto.MbersSearchDTO;
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.PageDTO;
import com.macat.dto.QnaSearchDTO;

public class Paging {
	
	// 페이징을 위한 회원 정보 검색 기록
	public static MbersSearchDTO mbersSearchDTO;
	public static NotsSearchDTO notsSearchDTO;
	public static QnaSearchDTO qnaSearchDTO;
	public static FaqSearchDTO faqSearchDTO;

	public static String usedDTO; // 페이징을 위한 조회 기록
	public static int count; // 페이징을 위한 검색 인원 수 기록
	public static String cPage; // 페이징을 위한 현재 페이지 기록

	public static void setPage(PageDTO paging, int count, String cPage) {
		paging.setTotalRecord(count);

		if (paging.getTotalRecord() <= paging.getNumPerPage()) {
			paging.setTotalPage(1);
		} else {
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				paging.setTotalPage(paging.getTotalPage() + 1);
			}
		}

		if (cPage == null) {
			paging.setNowPage(1);
		} else {
			if (paging.getTotalPage() < Integer.parseInt(cPage)) {
				paging.setNowPage(paging.getTotalPage());
			} else {
				paging.setNowPage(Integer.parseInt(cPage));
			}
		}

		paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
		paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

		paging.setBeginBlock(
				(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
		paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}
	}
	
}
