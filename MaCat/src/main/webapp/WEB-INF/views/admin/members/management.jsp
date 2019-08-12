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
			<%-- paging --%>
			table tfoot ol#paging {list-style: none;}
			table tfoot ol#paging li {float: left; margin-right: 8px;}
			table tfoot ol#paging li a {display: block;	padding: 3px 7px; color: #2f313e; font-weight: bold;}
			table tfoot ol#paging li a:hover {background: #00B3DC; color: white; font-weight: bold;}
			.disable {padding: 3px 7px;	border: 1px solid silver; color: silver;}
			.now {padding: 3px 7px; background: purple; color: white; font-weight: bold;}
		</style>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script src="resources/js/admin/members/management.js"></script>
	</head>

	<body>
	    <form action="mber_search.mcat" method="post" style="margin: 0 auto; width: 850px" id="searchForm">
		
	        <input type="checkbox" name="search_chk" value="mber_sn">
	        회원 번호 <input type="number" class="mber_sn" name="mber_sn" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="id">
	        아이디 <input type="text" class="id" name="id" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="name" checked>
	        이름 <input type="text" class="name" name="name"><br><br>
	
	        <input type="checkbox" name="search_chk" value="birthday">
	        생일 <input type="date" class="birthday" name="birthday_start" disabled>~
	        <input type="date" class="birthday" name="birthday_end" disabled>
	        
	        &nbsp;&nbsp;&nbsp;성별&nbsp;<input type="radio" name="gender" value="0" checked>전체
	        <input type="radio" name="gender" value="1">남성
	        <input type="radio" name="gender" value="2">여성<br><br>
	
	        <input type="checkbox" name="search_chk" value="reg_date">
	        가입일 <input type="date" class="reg_date" name="reg_date_start" disabled>~
	        <input type="date" class="reg_date" name="reg_date_end" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="conect_rcord">
	        접속일 <input type="date" class="conect_rcord" name="conect_rcord_start" disabled>~
	        <input type="date" class="conect_rcord" name="conect_rcord_end" disabled><br><br>
	
	        <input type="checkbox" name="search_chk" value="phone">
	        핸드폰 <input type="tel" class="phone" name="phone" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="mber_grad">
	        회원 등급 <select class="mber_grad" name="mber_grad" disabled>
	            <option selected>등급선택</option>
	            <option value="4">관리자</option>
	            <option value="3">VIP</option>
	            <option value="2">GOLD</option>
	            <option value="1">WHITE</option>
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
									<tr id="${i.mber_sn}">
										<td><input type="checkbox" class="chkbox" name="mbers" value="${i.mber_sn}"></td>
										<td><input type="hidden" class="${i.mber_sn}" name="mber_sn" value="${i.mber_sn}" disabled>${i.mber_sn}</td>
										<td>${i.id}</td>
										<td><input type="password" class="${i.mber_sn}" name="pw" value="${i.pw}" disabled></td>
										<td><input type="text" class="${i.mber_sn}" name="name" value="${i.name}" disabled></td>
										<td><input type="text" class="${i.mber_sn}" name="email" value="${i.email}" disabled></td>
										<td>${i.birthday.substring(0, 10)}</td>
										<td><c:if test="${i.gender == 1}">남</c:if><c:if test="${i.gender == 2}">여</c:if></td>
										<td><input type="text" class="${i.mber_sn}" name="phone" value="${i.phone}" disabled></td>
										<td><input type="text" class="${i.mber_sn}" name="tel" value="${i.tel}" disabled></td>
										<td>${i.point}</td>
										<td>${i.reg_date.substring(0, 10)}</td>
										<td>${i.conect_rcord.substring(0, 10)}</td>
										<td><input type="text" class="${i.mber_sn}" name="zonecode" value="${i.zonecode}" disabled></td>
										<td><input type="text" class="${i.mber_sn}" name="adres" value="${i.adres}" disabled></td>
										<td><input type="text" class="${i.mber_sn}" name="detail_adres" value="${i.detail_adres}" disabled></td>
										<td><select id="grad" class="${i.mber_sn}" name="mber_grad" disabled>
								            <option>등급선택</option>
								            <option value="4" <c:if test="${i.mber_grad == 4}">selected</c:if>>운영자</option>
								            <option value="3" <c:if test="${i.mber_grad == 3}">selected</c:if>>VIP</option>
								            <option value="2" <c:if test="${i.mber_grad == 2}">selected</c:if>>GOLD</option>
								            <option value="1" <c:if test="${i.mber_grad == 1}">selected</c:if>>WHITE</option>
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
								<ol id="paging">
									<%-- 이전 --%>
									<c:choose>
										<c:when test="${paging.beginBlock <= paging.pagePerBlock}">
											<li class="disable">◀</li>
										</c:when>
										<c:otherwise>
											<li><a class="page">◀<input type="hidden" name="cPage" value="${paging.beginBlock - paging.pagePerBlock + 4}"></a></li>
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
											<li class="disable">▶</li>
										</c:when>
										<c:otherwise>
											<li><a class="page">▶<input type="hidden" name="cPage" value="${paging.beginBlock + paging.pagePerBlock}"></a></li>
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