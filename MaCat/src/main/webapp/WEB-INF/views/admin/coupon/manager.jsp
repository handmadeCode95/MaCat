<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>쿠폰 정보 관리</title>
	    <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
	    <!-- 초기화 -->
	    <link rel="stylesheet" href="resources/css/normalize.css">
	    <!-- 체크박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/checkbox.css">
	    <!-- 라디오박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/radiobutton.css">
	    
	    <!-- 관리자페이지 css -->
	    <link rel="stylesheet" href="resources/css/admin/coupon/manager.css">
	    <!-- 관리자 테이블 css-->
	    <link rel="stylesheet" href="resources/css/admin/coupon/admin_table.css">
	    <!--input text입력창 조절 css-->
	    <link rel="stylesheet" href="resources/css/admin/coupon/input_textarea.css">
	    <!-- 페이징 -->
	    <link rel="stylesheet" href="resources/css/paging.css">	    
	    <!-- 스크립트 -->
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>	    

	    <!-- 관리자 쿼리  -->
	    <script type="text/javascript" src="resources/js/admin/coupon/manager.js"></script>
	    <!-- checkbox 전체선택 쿼리 포함 -->
	    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
	</head>

	<body>
	    <!--관리자 페이지 사이드메뉴 불러오기-->
	    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>
	    <main>
	        <section class="wrap">
	            <div class="coupon_management">
                <span>쿠폰정보 관리</span>
            </div>
            <form id="searchForm" action="reviews_manage.mcat" method="post">
                <div class="coupon_information_container">
                   
                    <!--주문정보-->
                    <div class="coupon_info">
                        <div class="coupon_info_title"><span>쿠폰정보</span></div>
                        <div class="infomation_control_part">
                            <!--쿠폰번호 쿠폰이름-->
                            <div class="coupon_info_middle">
                                <div class="checks">
                                    <input type="checkbox" id="cpon_sq_chk" class="search" value="cpon_sq">
                                    <label for="cpon_sq_chk">쿠폰번호</label>
                                    <span class="inputClickListener">
                                    <input type="text" name="cpon_sq" class="cpon_sq" disabled></span>
                                </div>
                                <div class="checks">
                                    <input type="checkbox" id="cpon_nm_chk" class="search" value="cpon_nm">
                                    <label for="cpon_nm_chk">쿠폰이름</label>
                                    <span class="inputClickListener">
                                    <input type="text" name="cpon_nm" class="cpon_nm" disabled></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <!--기간-->
                    <div class="searching_term">
                        <div class="searching_term_title"><span>기간</span></div>
                        <div class="searching_term_middle">

                            <div class="checks">
                                <input type="checkbox" id="reg_dt" class="search" value="cpon_reg_dt">
                                <label for="reg_dt" style="margin-right: 40px;">쿠폰등록일</label>
                                <div>
                                    <span class="inputClickListener">
                                    <input type="date" id="join_box1" name="cpon_reg_dt_start" class="cpon_reg_dt" disabled></span>
                                    ~
                                    <span class="inputClickListener">
                                    <input type="date" id="join_box2" name="cpon_reg_dt_end" class="cpon_reg_dt" disabled></span>
                                </div>
                            </div>

                            <div class="checks">
                                <input type="checkbox" id="exp_dt" class="search" value="cpon_exp_dt">
                                <label for="exp_dt" style="margin-right: 40px;">쿠폰만료일</label>
                                <div>
                                    <span class="inputClickListener">
                                    <input type="date" id="connect_box1" name="cpon_exp_dt_start" class="cpon_exp_dt" disabled></span>
                                    ~
                                    <span class="inputClickListener">
                                    <input type="date" id="connect_box2" name="cpon_exp_dt_end" class="cpon_exp_dt" disabled></span>
                                </div>
                            </div>

                        </div>
                        <!-- 기간 선택 파트 -->
                        <div class="searching_term_right part2">
                            <div class="cpon_reg_period_btn">
                                <ul>
                                    <li class="cpon_reg_period_li">오늘 <input type="hidden" name="cpon_reg_dt_start" value="${dateDTO.today}" disabled></li>
                                    <li class="cpon_reg_period_li">1주일 <input type="hidden" name="cpon_reg_dt_start" value="${dateDTO.oneWeekAgo}" disabled></li>
                                    <li class="cpon_reg_period_li">1개월 <input type="hidden" name="cpon_reg_dt_start" value="${dateDTO.oneMonthAgo}" disabled></li>
                                    <li class="cpon_reg_period_li">3개월 <input type="hidden" name="cpon_reg_dt_start" value="${dateDTO.threeMonthAgo}" disabled></li>
                                    <li class="cpon_reg_period_li">6개월 <input type="hidden" name="cpon_reg_dt_start" value="${dateDTO.sixMonthAgo}" disabled></li>
                                    <li class="cpon_reg_period_li">1년 <input type="hidden" name="cpon_reg_dt_start" value="${dateDTO.oneYearAgo}" disabled></li>
                                </ul>
                            </div>

                            <div class="cpon_exp_period_btn">
                                <ul>
                                    <li class="cpon_exp_period_li">오늘 <input type="hidden" name="cpon_exp_dt_start" value="${dateDTO.today}" disabled></li>
                                    <li class="cpon_exp_period_li">1주일 <input type="hidden" name="cpon_exp_dt_start" value="${dateDTO.oneWeekAgo}" disabled></li>
                                    <li class="cpon_exp_period_li">1개월 <input type="hidden" name="cpon_exp_dt_start" value="${dateDTO.oneMonthAgo}" disabled></li>
                                    <li class="cpon_exp_period_li">3개월 <input type="hidden" name="cpon_exp_dt_start" value="${dateDTO.threeMonthAgo}" disabled></li>
                                    <li class="cpon_exp_period_li">6개월 <input type="hidden" name="cpon_exp_dt_start" value="${dateDTO.sixMonthAgo}" disabled></li>
                                    <li class="cpon_exp_period_li">1년 <input type="hidden" name="cpon_exp_dt_start" value="${dateDTO.oneYearAgo}" disabled></li>
                                </ul>
                            </div>
                        </div>
                    </div>
	                    <!-- 버튼 파트-->
	                    <div class="btn_part">
	                        <div class="and_or_radio_btn">
	                            <!--and 라디오 버튼-->
	                            <div class="and_container">
	                                <div class="and">
	                                    <input type="radio" name="and_or_chk" id="and_btn" value="and" checked="checked" />
	                                    <label for="and_btn">AND</label>
	                                </div>
	                            </div>
	                            <!--or 라디오 버튼-->
	                            <div class="or_container">
	                                <div class="or">
	                                    <input type="radio" name="and_or_chk" id="or_btn" value="or" />
	                                    <label for="or_btn">OR</label>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="view_refresh_btn">
	                            <input id="searchBtn" class="view_btn" type="button" value="조회" />
	                            <input class="refresh_btn" type="reset" value="초기화" />
	                        </div>
	                    </div>
	                </div>
	            </form>
	             <!-- 테이블 파트-->
            <div class="coupon_info_table_title">
                <span>쿠폰정보 (총 <b id="coupons_count">${pageDTO.totalRecord}</b> 개)</span>
            </div>
            <div id="coupon" class="info_table">
                <form>
                    <div class="table_wrap">
                        <table class="type11" id="checkbox_js">
                            <colgroup>
                                <col width="40" />
                                <col width="80" />
                                <col width="80" />
                                <col width="160" />                          
                                <col width="160" />                           
                                <col width="100" />
                                <col width="160" />
                                <col width="120" />
                                <col width="120" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th class="checks"><input name="coupon" type="checkbox" id="allCheck"><label for="allCheck"></label></th>
                                    <th scope="col">쿠폰번호</th>
                                    <th scope="col">회원번호</th>
                                    <th scope="col">쿠폰등록일</th>
                                    <th scope="col">쿠폰만료일</th>
                                    <th scope="col">쿠폰사용여부</th>
                                    <th scope="col">쿠폰이름</th>
                                    <th scope="col">쿠폰할인율</th>
                                    <th scope="col">쿠폰할인금액</th>
                                </tr>
                            </thead>
                            <tbody id="searchResult">
                            	<c:forEach var="i" items="${couponDTO}">
	                            	<tr id="${i.cpon_sq}">
	                                    <td class="checks"><input name="coupon" class="chkbox" type="checkbox" id="table_chk" value="${i.cpon_sq}"><label for="table_chk"></label></td>
	                                    <td><input name="cpon_sq" class="${i.cpon_sq}" type="text" value="${i.cpon_sq}" disabled>${i.cpon_sq}</td>
	                                    <td>${i.mber_sq}</td>
	                                    <td>${i.cpon_reg_dt.substring(0,10)}</td>
	                                    <td>${i.cpon_exp_dt.substring(0,10)}</td>
	                                    <td>${i.cpon_fl}</td>
	                                    <td><input name="cpon_nm" class="${i.cpon_sq}" type="text" value="${i.cpon_nm}" disabled></td>
	                                    <td><input name="cpon_dc_pt" class="${i.cpon_sq}" type="text" value="${i.cpon_dc_pt}" disabled></td>
	                                    <td><input name="cpon_dc" class="${i.cpon_sq}" type="text" value="${i.cpon_dc}" disabled></td>
	                                </tr>
                            	</c:forEach>                                
                            </tbody>
                        </table>
                    </div>
	                    <div id="pagingDiv">
							<ol id="paging">
								<%-- 이전 --%>
								<c:choose>
									<c:when test="${pageDTO.beginBlock <= pageDTO.pagePerBlock}">
										<li class="disable"><img
											src="resources/img/mcat-arrow-slider-left-grey.png"
											height="10px"></li>
									</c:when>
									<c:otherwise>
										<li><a class="page"> <img
												src="resources/img/mcat-arrow-slider-left-grey.png"
												height="10px"> <input type="hidden" name="cPage"
												value="${pageDTO.beginBlock - 1}">
										</a></li>
									</c:otherwise>
								</c:choose>
		
								<%-- 블록안에 들어간 페이지번호들 --%>
								<c:forEach begin="${pageDTO.beginBlock}" end="${pageDTO.endBlock}"
									step="1" var="i">
									<%-- 현재 페이지는 링크 비활성화, 나머지는 해당 페이지로 링크 --%>
									<c:choose>
										<c:when test="${i == pageDTO.nowPage}">
											<li class="now">${i}</li>
										</c:when>
										<c:otherwise>
											<li><a class="page">${i}<input type="hidden"
													name="cPage" value="${i}"></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
		
								<%-- 다음 --%>
								<c:choose>
									<c:when test="${pageDTO.endBlock >= pageDTO.totalPage}">
										<li class="disable">
										<img src="resources/img/mcat-arrow-slider-right-grey.png" height="10px"></li>
									</c:when>
									<c:otherwise>
										<li><a class="page"> <img
												src="resources/img/mcat-arrow-slider-right-grey.png"
												height="10px"> <input type="hidden" name="cPage"
												value="${pageDTO.beginBlock + pageDTO.pagePerBlock}">
										</a></li>
									</c:otherwise>
								</c:choose>
							</ol>
						</div>
	                    <div class="edit_delete_btn">
	                        <input class="edit_btn" type="button" value="수정" id="update" />
	                        <input class="delete_btn" type="button" value="삭제" id="delete" />
	                    </div>
	                </form>
	            </div>
	        </section>
	    </main>
	</body>
</html>
