<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>상품정보 관리</title>
	    <!-- 초기화 -->
	    <link rel="stylesheet" href="resources/css/normalize.css">
	    <!-- 관리자페이지 css -->
	    <link rel="stylesheet" href="resources/css/admin/product/manager.css">
	    <!-- 체크박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/checkbox.css">
	    <!-- 라디오박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/product/radiobutton.css">
	    <!-- 관리자 테이블 css-->
	    <link rel="stylesheet" href="resources/css/admin/product/admin_table.css">
	    <!--input text입력창 조절 css-->
	    <link rel="stylesheet" href="resources/css/admin/product/input_textarea.css">
	    <!-- 페이징 -->
	    <link rel="stylesheet" href="resources/css/paging.css">	      
	    <!-- 스크립트 -->
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>	
	        
	    <script type="text/javascript" src="resources/js/admin/product/manager.js"></script>
	    <!-- checkbox 전체선택 쿼리 포함 -->
	    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>

	</head>

	<body>
	    <!--관리자 페이지 사이드메뉴 불러오기-->
	    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>
	    <main>
	        <section class="wrap">
	            <div class="product_management">
	                <span>상품관리</span>
	            </div>
	            <form id="searchForm" action="mber_search.mcat" method="post">
	                <div class="product_information_container">
	                    <!--상품정보-->
	                    <div class="product_info">
	                        <div class="product_info_title"><span>상품정보</span></div>
	                        <div class="infomation_control_part">
	                            <!--상품번호 상품명 상품재고-->
	                            <div class="product_info_middle">
	                                <div class="checks">
	                                
	                                    <input type="checkbox" id="product_chk" class="search" value="prduct_sq">
	                                    <label for="product_chk" style="margin-right: 26px; ">상품번호</label>
	                                    <span class="inputClickListener"><input type="text" name="prduct_sq" class="prduct_sq" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="prd_name_chk" class="search" value="prduct_nm">
	                                    <label for="prd_name_chk" style="margin-right: 40px;">상품명</label>
	                                    <span class="inputClickListener"><input type="text" name="prduct_nm" class="prduct_nm" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="amt_chk" class="search" value="prduct_amt">
	                                    <label for="amt_chk" style="margin-right: 26px;">상품재고</label>
	                                    <span class="inputClickListener"><input type="text" name="prduct_amt" class="prduct_amt" disabled></span>
	                                </div>
	                                <div class="amt_radio_btn">
	                                    <input type="radio" class="amt_select" id="upper" name="amt_select" value="" checked>
	                                    <label for="upper">이상</label>
	                                    <input type="radio" class="amt_select2" id="lower" name="amt_select" value="">
	                                    <label style="margin-left: 25px;margin-right: 25px;" for="lower">이하</label>
	                                </div>
	                                
	                            </div>
	                            <!--상품코드 카테고리 배송비-->
	                            <div class="product_info_right">
	                                <div class="checks">
	                                    <input type="checkbox" id="product_code" class="search" value="prduct_cd">
	                                    <label for="product_code" style="margin-right: 13px;">상품코드</label>
	                                    <span class="inputClickListener"><input type="text" name="prduct_cd" class="prduct_cd" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="ctg_name" class="search" value="ctgry_nm">
	                                    <label for="ctg_name" style="margin-right: 13px;">카테고리</label>
	                                    <span class="inputClickListener"><input type="text" name="ctgry_nm" class="ctgry_nm" disabled></span>
	                                </div>
	                                <div class="checks">
	                        	        <input type="checkbox" id="dlvy_price" class="search" value="prduct_dlvy_price">
	                            	    <label for="dlvy_price" style="margin-right: 33px;">배송비</label>
	                                	<div>
	                                    	<span class="inputClickListener"><input type="text" id="dlvy_box1" name="prduct_dlvy_price_start" class="prduct_dlvy_price" disabled></span>
	                                	    ~
	                            	        <span class="inputClickListener"><input type="text" id="dlvy_box2" name="prduct_dlvy_price_end" class="prduct_dlvy_price" disabled></span>
	                                	</div>
	                            	</div>
	                            	<div class="dlvy_period_btn">
	                          	      	<ul>
	                         		       	<li class="dlvy_period_li">무료 <input type="hidden" name="prduct_dlvy_price_start" value="${dateDTO.today}" disabled></li>
	                            	    </ul>
	                           		 </div>
	                            </div>
	                        </div>
	                    </div>
	                    <!--기간 및 금액-->
	                    <div class="searching_term">
	                        <div class="searching_term_title"><span>기간 및 금액</span></div>
	                        <div class="searching_term_middle">
	                            <div class="checks">
	                                <input type="checkbox" id="join_date" class="search" value="prduct_reg_dt">
	                                <label for="join_date" style="margin-right: 36px;">등록일</label>
	                                <div>
	                                    <span class="inputClickListener"><input type="date" id="join_box1" name="prduct_reg_dt_start" class="prduct_reg_dt" disabled></span>
	                                    ~
	                                    <span class="inputClickListener"><input type="date" id="join_box2" name="prduct_reg_dt_end" class="prduct_reg_dt" disabled></span>
	                                </div>
	                            </div>
	                            
	                            <div class="checks">
	                                    <input type="checkbox" id="price_chk" class="search" value="prduct_price">
	                                    <label for="price_chk">가격</label>
	                                    <div>
	                                        <span class="inputClickListener"><input type="text" id="price_box1" name="prduct_price_start" class="prduct_price" disabled></span> ~
	                                        <span class="inputClickListener"><input type="text" id="price_box2" name="prduct_price_end" class="prduct_price" disabled></span>
	                                    </div>
	                                </div>
	                            <div class="checks">
	                                <input type="checkbox" id="sale_price_term" class="search" value="prduct_dc">
	                                <label for="sale_price_term" style="margin-right: 21px;">할인가격</label>
	                                <div>
	                                    <span class="inputClickListener"><input type="text" id="sale_price_box1" name="prduct_dc_start" class="prduct_dc" disabled></span>
	                                    ~
	                                    <span class="inputClickListener"><input type="text" id="sale_price_box2" name="prduct_dc_end" class="prduct_dc" disabled></span>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- 기간 선택 파트 -->
	                        <div class="searching_term_right part2">
	                            <div class="join_period_btn">
	                                <ul>
	                                    <li class="join_period_li">오늘 <input type="hidden" name="prduct_reg_dt_start" value="${dateDTO.today}" disabled></li>
	                                    <li class="join_period_li">1주일 <input type="hidden" name="prduct_reg_dt_start" value="${dateDTO.oneWeekAgo}" disabled></li>
	                                    <li class="join_period_li">1개월 <input type="hidden" name="prduct_reg_dt_start" value="${dateDTO.oneMonthAgo}" disabled></li>
	                                    <li class="join_period_li">3개월 <input type="hidden" name="prduct_reg_dt_start" value="${dateDTO.threeMonthAgo}" disabled></li>
	                                    <li class="join_period_li">6개월 <input type="hidden" name="prduct_reg_dt_start" value="${dateDTO.sixMonthAgo}" disabled></li>
	                                    <li class="join_period_li">1년 <input type="hidden" name="prduct_reg_dt_start" value="${dateDTO.oneYearAgo}" disabled></li>
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
	            <div class="product_info_table_title">
	                <span>상품정보 (총 <b id="prducts_count"> ${pageDTO.totalRecord} </b> 개)</span>
	            </div>
	            <div id="products" class="info_table">
	                <form>
	                    <div class="table_wrap">
	                        <table class="type11" id="checkbox_js">
	                            <colgroup>
	                                <col width="40" />	<!--체크박스-->
	                                <col width="80" />	<!--상품번호-->
	                                <col width="120" />	<!--상품코드-->
	                                <col width="120" />	<!--카테고리-->
	                                <col width="400" />	<!--상품명-->
	                                <col width="120" />	<!--상품가격-->
	                                <col width="120" />	<!--할인가격-->
	                                <col width="120" />	<!--배송비-->
	                                <col width="100" />	<!--제조사-->
	                                <col width="100" />	<!--제조국-->
	                                <col width="200" />	<!--주소재-->
	                                <col width="150" />	<!--등록일-->
	                                <col width="100" />	<!--할인율-->
	                                <col width="100" />	<!--적립율-->
	                                <col width="100" />	<!--적립포인트-->
	                                <col width="100" />	<!--조회수-->
	                                <col width="100" />	<!--평점-->
	                                <col width="100" />	<!--판매량-->
	                                <col width="100" />	<!--재고-->
	                            </colgroup>
	                            <thead>
	                                <tr>
	                                    <th><input name="products" type="checkbox" id="allCheck"></th>
	                                    <th scope="col">상품번호</th>
	                                    <th scope="col">상품코드</th>
	                                    <th scope="col">카테고리</th>
	                                    <th scope="col">상품명</th>
	                                    <th scope="col">상품가격</th>
	                                    <th scope="col">할인가격</th>
	                                    <th scope="col">배송비</th>
	                                    <th scope="col">제조사</th>
	                                    <th scope="col">제조국</th>
	                                    <th scope="col">주소재</th>
	                                    <th scope="col">등록일</th>
	                                    <th scope="col">할인율</th>
	                                    <th scope="col">적립율</th>
	                                    <th scope="col">적립포인트</th>
	                                    <th scope="col">조회수</th>
	                                    <th scope="col">평점</th>
	                                    <th scope="col">판매량</th>
	                                    <th scope="col">재고</th>
	                                </tr>
	                            </thead>
	                            <tbody id="searchResult">
	                            <c:forEach var="i" items="${productsDTO}">
		                                <tr id="${i.prduct_sq}">
		                                    <td><input name="prduct" class="chkbox" type="checkbox" id="table_chk" value="${i.prduct_sq}"></td>
		                                    <td><input name="prduct_sq" class="${i.prduct_sq}" type="hidden" value="${i.prduct_sq}" disabled>${i.prduct_sq}</td>		                                    
		                                    <td>${i.prduct_cd}</td> <!-- 상품코드 -->
		                                    <td>${i.ctgry_nm}</td><!-- 카테고리 -->
		                                    <td><a href="product.mcat?prduct_nm=${i.prduct_nm}">${i.prduct_nm}</a></td><!-- 상품명 -->
		                                    <td>${i.prduct_price}</td><!-- 상품가격 -->
		                                    <td>${i.prduct_dc}</td>
		                                    <td>${i.prduct_dlvy_price}</td>
		                                    <td>${i.prduct_maker}</td>
		                                    <td>${i.prduct_coo}</td>
		                                    <td>${i.prduct_matr}</td>
		                                    <td>${i.prduct_reg_dt.substring(0,10)}</td>
		                                    <td>${i.prduct_dc_pt}</td>
		                                    <td>${i.prduct_save_pt}</td>
		                                    <td>${i.prduct_save}</td>
		                                    <td>${i.prduct_view_cnt}</td>
		                                    <td>${i.prduct_rating_avg}</td>
		                                    <td>${i.prduct_sale_sum}</td>
		                                    <td>${i.prduct_amt}</td>
		                                </tr>
		                             </c:forEach>
	                            </tbody>
	                        </table>
	                    </div>
	                    <!-- 페이징 div -->
	                    <div id="pagingDiv">
							<ol id="paging">
								<%-- 이전 --%>
								<c:choose>
									<c:when test="${pageDTO.beginBlock <= pageDTO.pagePerBlock}">
										<li class="disable">
										<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px"></li>
									</c:when>
									<c:otherwise>
										<li><a class="page">
										<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px"> 
										<input type="hidden" name="cPage" value="${pageDTO.beginBlock - 1}">
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
	                        <input class="delete_btn" type="button" value="삭제" id="withdrawal" />
	                    </div>
	                </form>
	            </div>
	        </section>
	    </main>
	</body>
</html>
