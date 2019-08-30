<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>회원 정보 관리</title>
		<style type="text/css">
			table{width: 500px; margin: 0 auto;}
			table,tr,th,td {border: 1px solid black; border-collapse: collapse;}
			div{text-align: center; margin: 0 auto;}
			<%-- 임시 페이징 --%>
			ol#paging {list-style: none; float: right; left: -50%; position: relative; margin-top: 0px;}
			ol#paging li {float: left; margin-right: 8px; left: 50%; position: relative; margin-top: 0px;}
			ol#paging li a {display: block;	padding: 3px 7px; color: #2f313e;}
			ol#paging li a:hover {background: #F2A766; color: white;}
			.disable {padding: 3px 7px;	color: silver;}
			.now {padding: 3px 7px; background: #F25E5E; color: white;}
		</style>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script src="resources/js/admin/members/management.js"></script>
	</head>

	<body>
	    <form action="mber_search.mcat" method="post" style="margin: 0 auto; width: 850px" id="searchForm">
		
	        <input type="checkbox" name="search_chk" value="mber_sq">
	        회원 번호 <input type="number" class="mber_sq" name="mber_sq" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="mber_id">
	        아이디 <input type="text" class="mber_id" name="mber_id" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="mber_nm" checked>
	        이름 <input type="text" class="mber_nm" name="mber_nm"><br><br>
	
	        <input type="checkbox" name="search_chk" value="mber_birthday_dt">
	        생일 <input type="date" class="mber_birthday_dt" name="mber_birthday_dt_start" disabled>~
	        <input type="date" class="mber_birthday_dt" name="mber_birthday_dt_end" disabled>
	        
	        &nbsp;&nbsp;&nbsp;성별&nbsp;<input type="radio" name="mber_gender" value="0" checked>전체
	        <input type="radio" name="mber_gender" value="1">남성
	        <input type="radio" name="mber_gender" value="2">여성<br><br>
	
	        <input type="checkbox" name="search_chk" value="mber_reg_dt">
	        가입일 <input type="date" class="mber_reg_dt" name="mber_reg_dt_start" disabled>~
	        <input type="date" class="mber_reg_dt" name="mber_reg_dt_end" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="mber_conect_dt">
	        접속일 <input type="date" class="mber_conect_dt" name="mber_conect_dt_start" disabled>~
	        <input type="date" class="mber_conect_dt" name="mber_conect_dt_end" disabled><br><br>
	
	        <input type="checkbox" name="search_chk" value="mber_phone_no">
	        핸드폰 <input type="tel" class="mber_phone_no" name="mber_phone_no" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="mber_grad_nm">
	        회원 등급 <select class="mber_grad_nm" name="mber_grad_nm" disabled>
	        	<option selected>등급선택</option>
	        	<c:forEach var="i" items="${mber_grad}">
	            	<option value="${i.mber_grad_nm}">${i.mber_grad_nm}</option>
	            </c:forEach>
	        </select><br><br>

	        
	        <input type="radio" name="and_or_chk" value="and" checked>AND
	        <input type="radio" name="and_or_chk" value="or">OR
	        <input type="button" value="조회" id="searchBtn">
	    </form>
	    
	    <hr>
	    
	    <div id="members" style="overflow: scroll; text-align: center; margin: 0 auto;">
			<form method="post" id="resultForm">
				<h1> 회원 정보 목록 </h1>
				<table style="width: 500px; margin: 0 auto;">
					<thead>
						<tr><th><input type="checkbox" class="all" name="mbers_all" value="0"></th><th>번호</th><th>아이디</th><th>패스워드</th>
						<th>이름</th><th>이메일</th><th>생일</th><th>성별</th><th>휴대폰</th>
						<th>전화번호</th><th>포인트</th><th>가입날짜</th><th>접속날짜</th>
						<th>우편번호</th><th>주소</th><th>상세주소</th><th>회원등급</th></tr>
					</thead>
					<tbody id="searchResult">
						<c:choose>
							<c:when test="${empty members}">
								<tr>
									<td colspan="17"><h3>조회된 회원 정보가 없습니다.</h3></td>
								</tr>
							</c:when>
							
							<c:otherwise>
								<c:forEach var="i" items="${members}">
									<tr id="${i.mber_sq}">
										<td><input type="checkbox" class="chkbox" name="mbers" value="${i.mber_sq}"></td>
										<td><input type="hidden" class="${i.mber_sq}" name="mber_sq" value="${i.mber_sq}" disabled>${i.mber_sq}</td>
										<td>${i.mber_id}</td>
										<td><input type="password" class="${i.mber_sq}" name="mber_pw" value="${i.mber_pw}" disabled></td>
										<td><input type="text" class="${i.mber_sq}" name="mber_nm" value="${i.mber_nm}" disabled></td>
										<td><input type="text" class="${i.mber_sq}" name="mber_email" value="${i.mber_email}" disabled></td>
										<td>${i.mber_birthday_dt.substring(0, 10)}</td>
										<td>${i.mber_gender}</td>
										<td><input type="text" class="${i.mber_sq}" name="mber_phone_no" value="${i.mber_phone_no}" disabled></td>
										<td><input type="text" class="${i.mber_sq}" name="mber_tel_no" value="${i.mber_tel_no}" disabled></td>
										<td>${i.mber_point_sum}</td>
										<td>${i.mber_reg_dt.substring(0, 10)}</td>
										<td>${i.mber_conect_dt.substring(0, 10)}</td>
										<td><input type="text" class="${i.mber_sq}" name="mber_zip_no" value="${i.mber_zip_no}" disabled></td>
										<td><input type="text" class="${i.mber_sq}" name="mber_adres" value="${i.mber_adres}" disabled></td>
										<td><input type="text" class="${i.mber_sq}" name="mber_detail_adres" value="${i.mber_detail_adres}" disabled></td>
										<td><select class="${i.mber_sq}" name="mber_grad_nm" disabled>
								        	<c:forEach var="j" items="${mber_grad}">
								            	<option value="${j.mber_grad_nm}"<c:if test="${j.mber_grad_nm == i.mber_grad_nm}"> selected</c:if>>${j.mber_grad_nm}</option>
								            </c:forEach>
								        </select></td>
									</tr>
								</c:forEach>
								
								<%-- 빈칸 추가 --%>
								<c:if test="${fn:length(members) % 10 != 0}">
									<c:forEach begin="1" end="${10 - (fn:length(members) % 10)}">
										<tr>
											<%-- 공백 삽입 --%>
											<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
											<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
											<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
										</tr>
									</c:forEach>
								</c:if>
							</c:otherwise>
						</c:choose>
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
				<input type="button" value="수정" id="update">
				<input type="button" value="탈퇴" id="withdrawal">
			</form>
		</div>
	</body>
</html>