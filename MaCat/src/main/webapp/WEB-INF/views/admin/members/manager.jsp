<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>회원 정보 관리</title>
	    <!-- 초기화 -->
	    <link rel="stylesheet" href="resources/css/normalize.css">
	    <!-- 관리자페이지 css -->
	    <link rel="stylesheet" href="resources/css/admin/members/manager.css">
	    <!-- 체크박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/checkbox.css">
	    <!-- 라디오박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/radiobutton.css">
	    <!-- 관리자 테이블 css-->
	    <link rel="stylesheet" href="resources/css/admin/members/admin_table.css">
	    <!--input text입력창 조절 css-->
	    <link rel="stylesheet" href="resources/css/admin/members/input_textarea.css">
	    <!-- 스크립트 -->
	    <script src="resources/js/admin/members/manager.js"></script>
		<!-- jQuery -->
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <!-- checkbox 전체선택 스크립트 -->
	    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
	</head>

	<body>
	    <!--관리자 페이지 사이드메뉴 불러오기-->
	    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>
	    <main>
	        <section class="wrap">
	            <div class="member_management">
	                <span>회원관리</span>
	            </div>
	            <form id="searchForm" action="mber_search.mcat" method="post">
	                <div class="member_information_container">
	                    <!--회원정보-->
	                    <div class="member_info">
	                        <div class="member_info_title"><span>회원정보</span></div>
	                        <div class="infomation_control_part">
	                            <!--이름 아이디 핸드폰번호 생일-->
	                            <div class="member_info_middle">
	                                <div class="checks">
	                                    <input type="checkbox" id="name_chk">
	                                    <label for="name_chk" style="margin-right: 54px; ">이름</label>
	                                    <input type="text" name="mber_nm">
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="id_chk">
	                                    <label for="id_chk" style="margin-right: 40px;">아이디</label>
	                                    <input type="text" name="mber_id">
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="cellphone_chk">
	                                    <label for="cellphone_chk" style="margin-right: 12px;">핸드폰번호</label>
	                                    <input type="tel" name="mber_phone_no">
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="birth_chk">
	                                    <label for="birth_chk">생일</label>
	                                    <div>
	                                        <input type="date" class="birth_box1" name="mber_birthday_dt_start"> ~
	                                        <input type="date" class="birth_box2" name="mber_birthday_dt_end">
	                                    </div>
	
	                                </div>
	                            </div>
	                            <!--회원번호 회원등급 전화번호-->
	                            <div class="member_info_right">
	                                <div class="checks">
	                                    <input type="checkbox" id="member_no">
	                                    <label for="member_no" style="margin-right: 13px;">회원번호</label>
	                                    <input type="text" name="mber_sq">
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="member_grade">
	                                    <label for="member_grade" style="margin-right: 13px;">회원등급</label>
	                                    <input type="text" name="mber_grad_nm">
	                                </div>
	                                <div class="checks">
	                                    <input type="checkbox" id="phone_num">
	                                    <label for="phone_num" style="margin-right: 13px;">전화번호</label>
	                                    <input type="tel" name="mber_tel_no">
	                                </div>
	                                <div class="gender_radio_btn">
	                                    <input type="radio" class="gender_all" id="gender_all" name="mber_gender" value="0" checked>
	                                    <label for="gender_all">전체</label>
	
	                                    <input type="radio" class="female" id="female" name="mber_gender" value="1">
	                                    <label style="margin-left: 50px;margin-right: 50px;" for="female">여자</label>
	
	                                    <input type="radio" class="male" id="male" name="mber_gender" value="2">
	                                    <label for="male">남자</label>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <!--기간-->
	                    <div class="searching_term">
	                        <div class="searching_term_title"><span>기간</span></div>
	                        <div class="searching_term_middle">
	                            <div class="checks">
	                                <input type="checkbox" id="join_date">
	                                <label for="join_date" style="margin-right: 36px;">가입일</label>
	                                <div>
	                                    <input type="date" class="join_box1" name="mber_reg_dt_start">
	                                    ~
	                                    <input type="date" class="join_box2" name="mber_reg_dt_end">
	                                </div>
	                            </div>
	                            <div class="checks">
	                                <input type="checkbox" id="connect_term">
	                                <label for="connect_term" style="margin-right: 21px;">접속기간</label>
	                                <div>
	                                    <input type="date" class="connect_box1" name="mber_conect_dt_start">
	                                    ~
	                                    <input type="date" class="connect_box2" name="mber_conect_dt_end">
	                                </div>
	
	                            </div>
	                        </div>
	                        <!-- 기간 선택 파트 -->
	                        <div class="searching_term_right part2">
	                            <div class="join_period_btn">
	                                <ul>
	                                    <li>오늘</li>
	                                    <li>1주일</li>
	                                    <li>1개월</li>
	                                    <li>3개월</li>
	                                    <li>6개월</li>
	                                    <li>1년</li>
	                                </ul>
	                            </div>
	                            <div class="connect_period_btn">
	                                <ul>
	                                    <li>오늘</li>
	                                    <li>1주일</li>
	                                    <li>1개월</li>
	                                    <li>3개월</li>
	                                    <li>6개월</li>
	                                    <li>1년</li>
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
	                                    <input type="radio" name="and_or_chk" id="and_btn" checked="checked" />
	                                    <label for="and_btn">AND</label>
	                                </div>
	                            </div>
	                            <!--or 라디오 버튼-->
	                            <div class="or_container">
	                                <div class="or">
	                                    <input type="radio" name="and_or_chk" id="or_btn" />
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
	            <div class="member_info_table_title">
	                <span>회원정보 (총 <p>1,837</p> 명)</span>
	            </div>
	            <div id="members" class="info_table">
	                <form>
	                    <div class="table_wrap">
	                        <table class="type11" id="checkbox_js">
	                            <colgroup>
	                                <col width="40" />
	                                <!--체크박스-->
	                                <col width="80" />
	                                <!--회원번호-->
	                                <col width="80" />
	                                <!--이름-->
	                                <col width="50" />
	                                <!--성별-->
	                                <col width="140" />
	                                <!--아이디-->
	                                <col width="140" />
	                                <!--비번-->
	                                <col width="140" />
	                                <!--폰번호-->
	                                <col width="140" />
	                                <!--전화번호-->
	                                <col width="100" />
	                                <!--우편번호-->
	                                <col width="300" />
	                                <!--주소-->
	                                <col width="300" />
	                                <!--상세주소-->
	                                <col width="240" />
	                                <!--이메일-->
	                                <col width="100" />
	                                <!--생년월일-->
	                                <col width="100" />
	                                <!--가입일-->
	                                <col width="100" />
	                                <!--접속일-->
	                                <col width="100" />
	                                <!--포인트-->
	                            </colgroup>
	                            <thead>
	                                <tr>
	                                    <th><input name="mbers" type="checkbox" id="allCheck"></th>
	                                    <th scope="col">회원번호</th>
	                                    <th scope="col">이름</th>
	                                    <th scope="col">성별</th>
	                                    <th scope="col">아이디</th>
	                                    <th scope="col">비밀번호</th>
	                                    <th scope="col">핸드폰번호</th>
	                                    <th scope="col">전화번호</th>
	                                    <th scope="col">우편번호</th>
	                                    <th scope="col">주소</th>
	                                    <th scope="col">상세주소</th>
	                                    <th scope="col">이메일</th>
	                                    <th scope="col">생년월일</th>
	                                    <th scope="col">가입일</th>
	                                    <th scope="col">접속일</th>
	                                    <th scope="col">포인트</th>
	                                </tr>
	                            </thead>
	                            <tbody id="searchResult">
	                            	<c:forEach var="i" items="${members}">
		                                <tr id="${i.mber_sq}">
		                                    <td><input name="mbers" class="chkbox" type="checkbox" id="table_chk" value="${i.mber_sq}"></td>
		                                    <td><input name="mber_sq" class="${i.mber_sq}" type="hidden" value="${i.mber_sq}" disabled>1001</td>
		                                    <td><input name="mber_nm" class="${i.mber_sq}" type="text" value="${i.mber_nm}" disabled></td>
		                                    <td>${i.mber_gender}</td>
		                                    <td>${i.mber_id}</td>
		                                    <td><input name="mber_pw" class="${i.mber_sq}" type="password" value="${i.mber_pw}" disabled></td>
		                                    <td><input name="mber_phone_no" class="${i.mber_sq}" type="text" value="${i.mber_phone_no}" disabled></td>
		                                    <td><input name="mber_tel_no" class="${i.mber_sq}" type="text" value="${i.mber_tel_no}" disabled></td>
		                                    <td><input name="mber_zip_no" class="${i.mber_sq}" type="text" value="${i.mber_zip_no}" disabled></td>
		                                    <td><input name="mber_adres" class="${i.mber_sq}" type="text" value="${i.mber_adres}" disabled></td>
		                                    <td><input name="mber_detail_adres" class="${i.mber_sq}" type="text" value="${i.mber_detail_adres}" disabled></td>
		                                    <td><input name="mber_email" class="${i.mber_sq}" type="text" value="${i.mber_email}" disabled></td>
		                                    <td>${i.mber_birthday_dt.substring(0, 10)}</td>
		                                    <td>${i.mber_reg_dt.substring(0, 10)}</td>
		                                    <td>${i.mber_conect_dt.substring(0, 10)}</td>
		                                    <td>${i.mber_point_sum}p</td>
		                                </tr>
	                                </c:forEach>
	                            </tbody>
	                            
	                            <%-- 페이징 기법 --%>
								<tfoot>
									<tr>
										<td colspan="17">
											<%-- 페이징 기법 --%>
											<ol id="paging">
												<%-- 이전 --%>
												<c:choose>
													<c:when test="${paging.beginBlock <= paging.pagePerBlock}">
														<li class="disable">
															<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px">
														</li>
													</c:when>
													<c:otherwise>
														<li><a class="page">
															<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px">
															<input type="hidden" name="cPage" value="${paging.beginBlock - 1}">
														</a></li>
													</c:otherwise>
												</c:choose>
																	
												<%-- 블록안에 들어간 페이지번호들 --%>
												<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock}" step="1" var="i">
													<%-- 현재 페이지는 링크 비활성화, 나머지는 해당 페이지로 링크 --%>
													<c:choose>
														<c:when test="${i == paging.nowPage}">
															<li class="now">${i}</li>
														</c:when>
														<c:otherwise>
															<li><a class="page">${i}<input type="hidden" name="cPage" value="${i}"></a></li>
														</c:otherwise>
													</c:choose>
												</c:forEach>
																	
													<%-- 다음 --%>
													<c:choose>
													<c:when test="${paging.endBlock >= paging.totalPage}">
														<li class="disable">
															<img src="resources/img/mcat-arrow-slider-right-grey.png" height="10px">
														</li>
													</c:when>
													<c:otherwise>
														<li><a class="page">
															<img src="resources/img/mcat-arrow-slider-right-grey.png" height="10px">
															<input type="hidden" name="cPage" value="${paging.beginBlock + paging.pagePerBlock}">
														</a></li>
													</c:otherwise>
												</c:choose>
											</ol>
										</td>
									</tr>
								</tfoot>
	                        </table>
	
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
