<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>공지사항 관리</title>
		<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
		<!-- 초기화 -->
		<link rel="stylesheet" href="resources/css/normalize.css">
		<!-- 페이징 -->
		<link rel="stylesheet" href="resources/css/paging.css">
		<!-- 체크박스 css -->
		<link rel="stylesheet" href="resources/css/admin/checkbox.css">
		<!-- 라디오박스 css -->
		<link rel="stylesheet" href="resources/css/admin/radiobutton.css">
		<!-- 공지사항 관리자 전용 css -->
		<link rel="stylesheet" href="resources/css/admin/notices/manager.css">
		<!-- 공지사항 관리자 테이블 전용 css-->
		<link rel="stylesheet"	 href="resources/css/admin/notices/admin_table.css">
		<!-- 공지사항 관리자 input_textarea 전용 css -->
		<link rel="stylesheet" href="resources/css/admin/notices/input_textarea.css">
	</head>

<body>
	<!--관리자 페이지 사이드메뉴 불러오기-->
	<div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp"%></div>
	<main> 
	<section class="wrap">
	<div class="notices_management">
                <span>공지사항 관리</span>
            </div>
            <form id="searchForm" action="nots_search.mcat" method="post">
                <div class="notices_info_container">
                    <!--공지사항 정보-->
                    <div class="notices_info">
                        <div class="notices_info_title"><span>공지사항 정보</span></div>
                        <div class="infomation_control_part">
                            <!--글번호 제목 작성일-->
                            <div class="notices_info_middle">                               
                                <div class="checks">
                                    <input type="checkbox" id="not_sq_chk" class="search" value="not_sq">
                                    <label for="not_sq_chk" style="margin-right: 54px; ">글 번호</label>
                                     <span class="inputClickListener"><input type="text" name="not_sq" class="not_sq" disabled></span>
                                </div>
                                
                                <div class="checks">
                                    <input type="checkbox" id="not_sj_chk" class="search" value="not_sj">
                                    <label for="not_sj_chk" style="margin-right: 74.5px;">제목</label>
									<span class="inputClickListener"><input type="text" name="not_sj" class="not_sj" disabled></span>
								</div>
                                
                                <div class="checks">
                                    <input type="checkbox" id="not_reg_dt_chk" class="search" value="not_reg_dt">
                                    <label for="not_reg_dt_chk">작성일</label>
                                    <div>
                                        <span class="inputClickListener"><input type="date" id="not_reg_dt_start" name="not_reg_dt_start" class="not_reg_dt" disabled></span> ~
                                        <span class="inputClickListener"><input type="date" id="not_reg_dt_end" name="not_reg_dt_end" class="not_reg_dt" disabled></span>
                                    </div>
                                </div>
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
                            <input class="refresh_btn" type="button" value="초기화" />
                        </div>
                    </div>
                </div>
            </form>
            <!-- 테이블 파트-->
            <div class="notices_info_table_title">
                <span>공지사항 (총 <b id="nots_count">${pageDTO.totalRecord}</b> 개)</span>
            </div>
            <div id="nots" class="info_table">
                <form>
                    <div class="table_wrap">
                        <table class="type11" id="checkbox_js">             
       						<colgroup>
								<col width="40" />	<!--체크박스-->
								<col width="100" /> <!--글번호-->
								<col width="800" />	<!--제목-->
								<col width="200" /> <!--작성일-->
							</colgroup>              
                            <thead>
                                <tr>
									<th class="checks"><input type="checkbox" id="allCheck"><label for="allCheck"></label></th>
									<th scope="col">글 번호</th>
									<th scope="col">제목</th>
									<th scope="col">작성일</th>
                                </tr>
                            </thead>
                            <tbody id="searchResult">
                            	<c:forEach var="i" items="${notsDTO}">
	                            	<tr id="${i.not_sq}">
										<td class="checks"><input name="nots" class="chkbox" type="checkbox" id="table_chk" value="${i.not_sq}"><label for="table_chk"></label>
										<td><input name="not_sq" class="${i.not_sq}" type="hidden" value="${i.not_sq}" disabled>${i.not_sq}</td>		
										<td>${i.not_sj}</td>
										<td>${i.not_reg_dt.substring(0, 10)}</td>
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
								<li class="disable"><img
									src="resources/img/mcat-arrow-slider-right-grey.png"
									height="10px"></li>
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
					<input class="edit_btn" type="button" value="수정" id="update"/>
					<input class="delete_btn" type="button" value="삭제" id="delete"/>
				</div>
			</form>
		</div>
	</section>
	</main>			
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<!-- checkbox 전체선택 쿼리 포함 -->
		<script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
		<!-- 공지사항 관리자 쿼리  -->
		<script type="text/javascript" src="resources/js/admin/notices/manager.js"></script>
</body>
</html>