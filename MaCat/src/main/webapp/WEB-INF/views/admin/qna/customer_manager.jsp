<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>고객 문의 관리</title>
	    <!-- 초기화 -->
	    <link rel="stylesheet" href="resources/css/normalize.css">
   	    <!-- 페이징 -->
	    <link rel="stylesheet" href="resources/css/paging.css">	     
   	    <!-- 체크박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/checkbox.css">
	    <!-- 라디오박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/radiobutton.css">
	    	    
	    <!-- 관리자페이지 css -->
	    <link rel="stylesheet" href="resources/css/admin/customer_center/manager.css">
	    <!-- 관리자 테이블 css-->
	    <link rel="stylesheet" href="resources/css/admin/customer_center/admin_table.css">
	    <!--input text입력창 조절 css-->
	    <link rel="stylesheet" href="resources/css/admin/customer_center/input_textarea.css">
	    
	    <!-- 스크립트 -->
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>	    
	    
	    <script type="text/javascript" src="resources/js/admin/customer_center/manager.js"></script>
	    <!-- checkbox 전체선택 쿼리 포함 -->
	    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
	</head>

	<body>
	    <!--관리자 페이지 사이드메뉴 불러오기-->
	    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>
	    <main>
	        <section class="wrap">
	            <div class="qna_management">
	                <span>고객문의관리</span>
	            </div>
	            <form id="searchForm" action="mber_search.mcat" method="post">
	                <div class="qna_information_container">
	                    <!--회원정보-->
	                    <div class="qna_info">
	                        <div class="qna_info_title"><span>고객문의정보</span></div>
	                        <div class="infomation_control_part">
	                            <!--이름 아이디 핸드폰번호 생일-->
	                            <div class="qna_info_middle">
	                                <div class="checks">
	                                    <input type="checkbox" id="_chk" class="search" value="qna_sq">
	                                    <label for="name_chk" style="margin-right: 26px; ">문의번호</label>
	                                    <span class="inputClickListener"><input type="text" name="qna_sq" class="qna_sq" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="id_chk" class="search" value="prduct_sq">
	                                    <label for="id_chk" style="margin-right: 26px;">상품번호</label>
	                                    <span class="inputClickListener"><input type="text" name="prduct_sq" class="prduct_sq" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="cellphone_chk" class="search" value="qna_id">
	                                    <label for="cellphone_chk" style="margin-right: 40px;">아이디</label>
	                                    <span class="inputClickListener"><input type="tel" name="qna_id" class="qna_id" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="birth_chk" class="search" value="qna_sj">
	                                    <label for="birth_chk">제목</label>
	                                    <div>
	                                        <span class="inputClickListener"><input type="text" id="birth_box1" name="qna_sj" class="qna_sj" disabled></span>
	                                    </div>
	
	                                </div>
	                            </div>
	                            <!--회원번호 회원등급 전화번호-->
	                            <div class="qna_info_right">
	                                <div class="checks">
	                                    <input type="checkbox" id="member_no" class="search" value="mber_sq">
	                                    <label for="member_no" style="margin-right: 13px;">회원번호</label>
	                                    <span class="inputClickListener"><input type="text" name="mber_sq" class="mber_sq" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="member_grade" class="search" value="qc_nm">
	                                    <label for="member_grade" style="margin-right: 13px;">카테고리</label>
	                                    <span class="inputClickListener"><input type="text" name="qc_nm" class="qc_nm" disabled></span>
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="phone_num" class="search" value="qna_nm">
	                                    <label for="phone_num" style="margin-right: 13px;">작성자명</label>
	                                    <span class="inputClickListener"><input type="tel" name="qna_nm" class="qna_nm" disabled></span>
	                                </div>
	                                <div class="ans_st_radio_btn">
                                    	<label>답변상태</label>
	                                    <input type="radio" class="gender_all" id="ans_st_all" name="qna_ans_st" value="전체" checked>
	                                    <label for="ans_st_all">전체</label>
	
	                                    <input type="radio" id="ans_yes" name="qna_ans_st" value="">
	                                    <label style="margin-left: 25px;margin-right: 25px;" for="ans_yes">Y</label>
	
	                                    <input type="radio" id="ans_no" name="qna_ans_st" value="">
	                                    <label for="ans_no">N</label>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <!--기간-->
	                    <div class="searching_term">
	                        <div class="searching_term_title"><span>기간</span></div>
	                        <div class="searching_term_middle">
	                            <div class="checks">
	                                <input type="checkbox" id="join_date" class="search" value="qna_reg_dt">
	                                <label for="join_date" style="margin-right: 17px;">문의등록일</label>
	                                <div>
	                                    <span class="inputClickListener"><input type="date" id="join_box1" name="qna_reg_dt_start" class="qna_reg_dt" disabled></span>
	                                    ~
	                                    <span class="inputClickListener"><input type="date" id="join_box2" name="qna_reg_dt_end" class="qna_reg_dt" disabled></span>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- 기간 선택 파트 -->
	                        <div class="searching_term_right part2">
	                            <div class="join_period_btn">
	                                <ul>
	                                    <li class="join_period_li">오늘 <input type="hidden" name="qna_reg_dt_start" value="${dateDTO.today}" disabled></li>
	                                    <li class="join_period_li">1주일 <input type="hidden" name="qna_reg_dt_start" value="${dateDTO.oneWeekAgo}" disabled></li>
	                                    <li class="join_period_li">1개월 <input type="hidden" name="qna_reg_dt_start" value="${dateDTO.oneMonthAgo}" disabled></li>
	                                    <li class="join_period_li">3개월 <input type="hidden" name="qna_reg_dt_start" value="${dateDTO.threeMonthAgo}" disabled></li>
	                                    <li class="join_period_li">6개월 <input type="hidden" name="qna_reg_dt_start" value="${dateDTO.sixMonthAgo}" disabled></li>
	                                    <li class="join_period_li">1년 <input type="hidden" name="qna_reg_dt_start" value="${dateDTO.oneYearAgo}" disabled></li>
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
	            <div class="qna_info_table_title">
	                <span>고객문의정보 (총 <b id="qnas_count">${pageDTO.totalRecord}</b> 개)</span>
	            </div>
	            <div id="qnas" class="info_table">
	                <form>
	                    <div class="table_wrap">
	                         <table class="type11" id="checkbox_js">
	                            <colgroup>
	                                <col width="40" />	<!--체크박스-->
	                                <col width="80" />	<!--답변여부-->
	                                <col width="120" />	<!--카테고리-->
	                                <col width="100" />	<!--문의 번호-->
	                                <col width="250" />	<!--제목-->
	                                <col width="100" />	<!--고객명-->
	                                <col width="150" />	<!--아이디-->
	                                <col width="150" />	<!--등록일-->
	                                <col width="100" />	<!--조회수-->             
	                            </colgroup>
	                            <thead>
	                                <tr>
	                                    <th class="checks"><input type="checkbox" id="allCheck"><label for="allCheck"></label></th>
	                                    <th scope="col">답변여부</th>
	                                    <th scope="col">카테고리</th>
	                                    <th scope="col">문의 번호</th>
	                                    <th scope="col">제목</th>
	                                    <th scope="col">고객명</th>
	                                    <th scope="col">아이디</th>
	                                    <th scope="col">등록일</th>
	                                    <th scope="col">조회수</th>
	                                </tr>
	                            </thead>
	                            <tbody id="searchResult">
	                            	<c:forEach var="i" items="${qnaDTO}">
		                                <tr id="${i.qna_sq}">
		                                	<td class="checks"><input name="qnas" class="chkbox" type="checkbox" id="table_chk" value="${i.qna_sq}"><label for="table_chk"></label></td>
		                                    <td><input name="qna_sq" class="${i.qna_sq}" type="hidden" value="${i.qna_sq}" disabled>${i.qna_ans_st}</td>
		                                    <td>${i.qc_nm}</td>
		                                    <td>${i.qna_sq}</td>
		                                    <td><a href="qna_manage.mcat?qna_sj='${i.qna_sj}'">${i.qna_sj}</a></td>
		                                    <td>${i.qna_nm}</td>
		                                    <td>${i.qna_id}</td>
		                                    <td>${i.qna_reg_dt}</td>
		                                    <td>${i.qna_view_cnt}</td>
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
