<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <title>리뷰 관리</title>
	    <!-- 초기화 -->
	    <link rel="stylesheet" href="resources/css/normalize.css">
   	    <!-- 페이징 -->
	    <link rel="stylesheet" href="resources/css/paging.css">	  
	    <!-- 라디오박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/radiobutton.css">
   	    <!-- 체크박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/checkbox.css">
	    
	    <!-- 관리자페이지 css -->
	    <link rel="stylesheet" href="resources/css/admin/reviews/manager.css">
	    <!-- 관리자 테이블 css-->
	    <link rel="stylesheet" href="resources/css/admin/reviews/admin_table.css">
	    <!--input text입력창 조절 css-->
	    <link rel="stylesheet" href="resources/css/admin/reviews/input_textarea.css">
  
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>	    	    
	    <script type="text/javascript" src="resources/js/admin/reviews/management.js"></script>
	    <!-- checkbox 전체선택 쿼리 포함 -->
	    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
	</head>

	<body>
	    <!--관리자 페이지 사이드메뉴 불러오기-->
	    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>
	    <main>
	        <section class="wrap">
	            <div class="review_management">
	                <span>리뷰 관리</span>
	            </div>
	            <form id="searchForm" action="reviews_manage.mcat" method="post">
	                <div class="review_information_container">
	                    <!--주문정보-->
	                    <div class="review_info">
	                        <div class="review_info_title"><span>리뷰정보</span></div>
	                        <div class="infomation_control_part">
	                            <!--리뷰번호 리뷰제목 리뷰작성자-->
	                            <div class="review_info_middle">
	                                <div class="checks">
	                                    <input type="checkbox" id="re_sq_chk" class="search" value="re_sq">
	                                    <label for="re_sq_chk">리뷰번호</label>
	                                    <span class="inputClickListener"><input type="text" name="re_sq" class="re_sq" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="re_sj_chk" class="search" value="re_sj">
	                                    <label for="re_sj_chk">리뷰제목</label>
	                                    <span class="inputClickListener"><input type="text" name="re_sj" class="re_sj" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="re_nm_chk" class="search" value="re_nm">
	                                    <label for="re_nm_chk">작성자명</label>
	                                    <span class="inputClickListener"><input type="tel" name="re_nm" class="re_nm" disabled></span>
	                                </div>
	                            </div>
	                            <!--리뷰아이디 리뷰평점 리뷰조회수-->
	                            <div class="review_info_right">
	                                <div class="checks">
	                                    <input type="checkbox" id="re_id_chk" class="search" value="re_id">
	                                    <label for="re_id_chk" style="margin-right: 13px;">아이디</label>
	                                    <span class="inputClickListener"><input type="text" name="re_id" class="re_id" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="re_rating_chk" class="search" value="re_rating">
	                                    <label for="re_rating">리뷰평점</label>
	                                    <span class="inputClickListener"><input type="text" name="re_rating" class="re_rating" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="re_view_cnt_chk" class="search" value="re_view_cnt">
	                                    <label for="re_view_cnt_chk" style="margin-right: 13px;">조회수</label>
	                                    <span class="inputClickListener"><input type="tel" name="re_view_cnt" class="re_view_cnt" disabled></span>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <!--기간-->
	                    <div class="searching_term">
	                        <div class="searching_term_title"><span>기간</span></div>
	                        <div class="searching_term_middle">
                            
	                            <div class="checks">
	                                <input type="checkbox" id="join_date" class="search" value="order_dt">
	                                <label for="join_date" style="margin-right: 40px;">리뷰등록일</label>
	                                <div>
	                                    <span class="inputClickListener"><input type="date" id="join_box1" name="re_reg_dt_start" class="order_dt" disabled></span>
	                                    ~
	                                    <span class="inputClickListener"><input type="date" id="join_box2" name="re_reg_dt_end" class="order_dt" disabled></span>
	                                </div>
	                            </div>
	                            
	                        </div>
	                        <!-- 기간 선택 파트 -->
	                        <div class="searching_term_right part2">
	                        
	                            <div class="join_period_btn">
	                                <ul>
	                                    <li class="join_period_li">오늘 <input type="hidden" name="re_reg_dt_start" value="${dateDTO.today}" disabled></li>
	                                    <li class="join_period_li">1주일 <input type="hidden" name="re_reg_dt_start" value="${dateDTO.oneWeekAgo}" disabled></li>
	                                    <li class="join_period_li">1개월 <input type="hidden" name="re_reg_dt_start" value="${dateDTO.oneMonthAgo}" disabled></li>
	                                    <li class="join_period_li">3개월 <input type="hidden" name="re_reg_dt_start" value="${dateDTO.threeMonthAgo}" disabled></li>
	                                    <li class="join_period_li">6개월 <input type="hidden" name="re_reg_dt_start" value="${dateDTO.sixMonthAgo}" disabled></li>
	                                    <li class="join_period_li">1년 <input type="hidden" name="re_reg_dt_start" value="${dateDTO.oneYearAgo}" disabled></li>
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
	                                    <input type="radio" name="and_or" id="and_btn" checked="checked" />
	                                    <label for="and_btn">AND</label>
	                                </div>
	                            </div>
	                            <!--or 라디오 버튼-->
	                            <div class="or_container">
	                                <div class="or">
	                                    <input type="radio" name="and_or" id="or_btn" />
	                                    <label for="or_btn">OR</label>
	                                </div>
	                            </div>
	                        </div>
	                        <!--버튼들 담은 div-->
	                        <div class="view_refresh_btn">
	                            <input id="searchBtn" class="view_btn" type="button" value="조회" />
	                            <input class="refresh_btn" type="reset" value="초기화" />
	                        </div>
	                    </div>
	                </div>
	            </form>	            
	            
	            <!-- 테이블 파트-->
	             <div class="review_info_table_title">
	                <span>리뷰정보 (총 <b id="review_count">${pageDTO.totalRecord}</b> 개)</span>
	            </div>
	            <div id="review" class="info_table">
	                <form>
	                    <div class="table_wrap">
	                        <table class="type11" id="checkbox_js">
	                            <colgroup>
	                                <col width="40" />	<!--체크박스-->
	                                <col width="80" />	<!--리뷰번호-->
	                                <col width="80" />	<!--회원번호-->
	                                <col width="80" />	<!--상품번호-->
	                                <col width="240" />	<!--등록일-->
	                                <col width="80" />	<!--리뷰평점-->
	                                <col width="100" />	<!--조회수-->
	                                <col width="100" />	<!--좋아요-->
	                                <col width="160" />	<!--답변여부-->
	                                <col width="240" />	<!--리뷰아이디-->
	                                <col width="240" />	<!--리뷰제목-->
	                                <col width="240" />	<!--리뷰작성자-->
	                            </colgroup>
	                            <thead>
	                                <tr>
	                                    <th class="checks"><input name="review" type="checkbox" id="allCheck"><label for="allCheck"></label></th>
	                                    <th scope="col">리뷰번호</th>
	                                    <th scope="col">회원번호</th>
	                                    <th scope="col">상품번호</th>
	                                    <th scope="col">등록일</th>
	                                    <th scope="col">리뷰평점</th>
	                                    <th scope="col">조회수</th>
	                                    <th scope="col">좋아요</th>
	                                    <th scope="col">답변여부</th>
	                                    <th scope="col">리뷰아이디</th>
	                                    <th scope="col">리뷰제목</th>
	                                    <th scope="col">리뷰작성자</th>
	                                </tr>
	                            </thead>
	                            <tbody id="searchResult">
	                            	<c:forEach var="i" items="${reviewDTO}">
		                                <tr id="${i.re_sq}">
		                                    <td class="checks"><input name="review" class="chkbox" type="checkbox" id="table_chk" value="${i.re_sq}"><label for="table_chk"></label></td>
		                                    <td>${i.re_sq}</td>
		                                    <td>${i.mber_sq}</td>
		                                    <td>${i.prduct_sq}</td>
		                                    <td>${i.re_reg_dt.substring(0,10)}</td>
		                                    <td>${i.re_rating}</td>
		                                    <td>${i.re_view_cnt}</td>
		                                    <td>${i.re_like}</td>
		                                    <td><input name="re_ans_st" class="${i.re_ans_st}" type="text" value="${i.re_ans_st}" disabled></td>
		                                    <td>${i.re_id}</td>
		                                    <td><a href="review_manage.mcat?re_sj='${i.re_sj}'">${i.re_sj}</a></td>
		                                    <td>${i.re_nm}</td>
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
	                        <input class="delete_btn" type="button" value="삭제" id="delete" />
	                    </div>
	                </form>
	            </div>
	        </section>
	    </main>
	</body>
</html>
