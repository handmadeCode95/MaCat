<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>FAQ 관리</title>
	    
		<link href="resources/img/mcat-favicon.ico" rel="shortcut icon" type="image/x-icon">
	    <!-- 초기화 -->
	    <link rel="stylesheet" href="resources/css/normalize.css">
	    <!-- 체크박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/checkbox.css">
	    <!-- 라디오박스 css -->
	    <link rel="stylesheet" href="resources/css/admin/radiobutton.css">
	    
	    <!-- 관리자페이지 css -->
	    <link rel="stylesheet" href="resources/css/admin/faq/manager.css">
	    <link rel="stylesheet" href="resources/css/admin/faq/admin_table.css">
	    <link rel="stylesheet" href="resources/css/admin/faq/input_textarea.css">
	    <!-- 페이징 -->
	    <link rel="stylesheet" href="resources/css/paging.css">	    
	    
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>	    
	    <script type="text/javascript" src="resources/js/admin/faq/management.js"></script>		    
	    <!-- checkbox 전체선택 쿼리 포함 -->
	    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
	</head>

	<body>
	    <!--관리자 페이지 사이드메뉴 불러오기-->
	    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>
	    <main>
	        <section class="wrap">
	            <div class="faq_management">
                <span>FAQ 목록 관리</span>
            	</div>
	            <form id="searchForm" action="faq_search.mcat" method="post">
                <div class="faq_information_container">
                    <!--faq-->
                    <div class="faq_info">
                        <div class="faq_info_title"><span>FAQ</span></div>
                        <div class="infomation_control_part">                            
                            <div class="faq_info_middle">
                               <!--카테고리 : 콤보박스-->
                                <div class="checks">
                                    <input type="checkbox" id="ctgry_chk" class="search" value="qc_nm">
                                    <label for="ctgry_chk">카테고리</label>
                                    <span class="inputClickListener">
	                                    <select class="qc_nm" name="qc_nm" disabled>
								            <option value="전체" selected>전체</option>
								            <c:forEach var="i" items="${qna_ctgries}">
								            	<option value="${i.qc_nm}">${i.qc_nm}</option>
								            </c:forEach>
								        </select>
							        </span>                                      
                                </div>
                                
                                <!--번호-->
                                <div class="checks">
                                    <input type="checkbox" id="num_chk" class="search" value="faq_sq">
                                    <label for="num_chk">번호</label>
                                    <span class="inputClickListener"><input type="number" name="faq_sq" class="faq_sq" disabled></span>
                                </div>
                                
                            </div>
                            <div class="faq_info_right">             
                                <div class="checks">
                                    <input type="checkbox" id="sj_chk" class="search" value="faq_sj">
                                    <label for="sj_chk">제목</label>
                                     <span class="inputClickListener"><input type="text" name="faq_sj" class="faq_sj" disabled></span>
                                </div>                                                                
                            </div>
                            
                        </div>
                    </div>
                    <!--기간-->
                    
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
                        <div class="view_refresh_btn">
                            <input id="searchBtn" class="view_btn" type="button" value="조회" />
                            <input class="refresh_btn" type="reset" value="초기화" />
                        </div>
                    </div>
                    <!--버튼파트 끝-->
                </div>
            </form>            
            
	            <!-- 테이블 파트-->
	           <div class="faq_info_table_title">
                <span>FAQ 게시글 (총  <b id="faqs_count">${pageDTO.totalRecord}</b> 개)</span>
            	</div>
	            <div id="faq" class="info_table">
	                <form>
	                    <div class="table_wrap">
	                        <table class="type11" id="checkbox_js">
                            <colgroup>
                                <col width="40" /><!--체크박스-->
                                <col width="200" /><!--카테고리-->
                                <col width="100" /><!--번호-->
                                <col width="100%" /><!--제목-->                               
                            </colgroup>
	                            <thead>
	                                <tr>
	                                    <th class="checks"><input type="checkbox" id="allCheck"><label for="allCheck"></label></th>
	                                    <th scope="col">카테고리</th>
	                                    <th scope="col">번호</th>
	                                    <th scope="col">제목</th>
	                                </tr>
	                            </thead>
	                            <tbody id="searchResult">	                            
									<c:forEach var="i" items="${faqDTO}">
		                                <tr id="${i.faqDTO}">
		                                    <td class="checks"><input name="faqs" class="chkbox" type="checkbox" id="table_chk" value="${i.faq_sq}"><label for="table_chk"></label></td>
		                                    <td><input name="faq_sq" class="${i.faq_sq}" type="hidden" value="${i.faq_sq}">${i.qc_nm}</td>
		                                    <td>${i.faq_sq}</td>
		                                    <td><a href="faq_view.mcat?faq_sq=${i.faq_sq}">${i.faq_sj}</a></td> 
		                                </tr>
	                                </c:forEach>								                         	
	                            </tbody>	                            
	                        </table>
	                    </div>
	                    <!-- 페이징 -->
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
	                        <input class="edit_btn" type="button" value="수정" id="update" />
	                        <input class="delete_btn" type="button" value="삭제" id="delete" />
	                    </div>
	                </form>
	            </div>
	        </section>
	    </main>
	</body>
</html>
