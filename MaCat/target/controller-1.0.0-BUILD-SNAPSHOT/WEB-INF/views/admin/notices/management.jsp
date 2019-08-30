<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>공지사항 관리</title>
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
	    <script src="resources/js/admin/notices/management.js"></script>
	</head>

	<body>
	    <form action="not_search.mcat" method="post" style="margin: 0 auto; width: 850px" id="searchForm">
		
	        <input type="checkbox" name="search_chk" value="not_sq">
	        글 번호 <input type="number" class="not_sq" name="not_sq" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="not_sj">
	        제목 <input type="text" class="not_sj" name="not_sj" disabled><br><br>
		
	        <input type="checkbox" name="search_chk" value="not_reg_dt">
	        작성일 <input type="date" class="not_reg_dt" name="not_reg_dt_start" disabled>~
	        <input type="date" class="not_reg_dt" name="not_reg_dt_end" disabled><br><br>
	        
	        <input type="radio" name="and_or_chk" value="and" checked>AND
	        <input type="radio" name="and_or_chk" value="or">OR
	        <input type="button" value="조회" id="searchBtn">
	    </form>
	    
	    <hr>
	    
	    <div id="notices" style="overflow: scroll; text-align: center; margin: 0 auto;">
			<form method="post" id="resultForm">
				<h1> 공지사항 목록 </h1>
				<table style="width: 500px; margin: 0 auto;">
					<thead>
						<tr><th><input type="checkbox" class="all" name="nots_all" value="0"></th>
						<th>글 번호</th><th>제목</th><th>작성일</th></tr>
					</thead>
					<tbody id="searchResult">
						<c:choose>
							<c:when test="${empty notsDTO}">
								<tr>
									<td colspan="4"><h3>등록된 공지사항이 없습니다.</h3></td>
								</tr>
							</c:when>
							
							<c:otherwise>
								<c:forEach var="i" items="${notsDTO}">
									<tr id="${i.not_sq}">
										<td><input type="checkbox" class="chkbox" name="nots" value="${i.not_sq}"></td>
										<td>${i.not_sq}</td>
										<td><a href="nots_update.mcat">${i.not_sj}</a></td>
										<td>${i.not_reg_dt.substring(0, 10)}</td>
								</c:forEach>
								
								<%-- 빈칸 추가 --%>
								<c:if test="${fn:length(notsDTO) % 10 != 0}">
									<c:forEach begin="1" end="${10 - (fn:length(notsDTO) % 10)}">
										<tr>
											<%-- 공백 삽입 --%>
											<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
										</tr>
									</c:forEach>
								</c:if>
							</c:otherwise>
						</c:choose>
					</tbody>
					<%-- 페이징 기법 --%>
					<tfoot>
						<tr>
							<td colspan="4">
								<ol id="paging">
									<%-- 이전 --%>
									<c:choose>
										<c:when test="${pageDTO.beginBlock <= pageDTO.pagePerBlock}">
											<li class="disable">◀</li>
										</c:when>
										<c:otherwise>
											<li><a class="page">◀<input type="hidden" name="cPage" value="${pageDTO.beginBlock - 1}"></a></li>
										</c:otherwise>
									</c:choose>
									
									<%-- 블록안에 들어간 페이지번호들 --%>
									<c:forEach begin="${pageDTO.beginBlock}" end="${pageDTO.endBlock}" step="1" var="i">
										<%-- 현재 페이지는 링크 비활성화, 나머지는 해당 페이지로 링크 --%>
										<c:choose>
											<c:when test="${i == pageDTO.nowPage}">
												<li class="now">${i}</li>
											</c:when>
											<c:otherwise>
												<li><a class="page">${i}<input type="hidden" name="cPage" value="${i}"></a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									
									<%-- 다음 --%>
									<c:choose>
										<c:when test="${pageDTO.endBlock >= pageDTO.totalPage}">
											<li class="disable">▶</li>
										</c:when>
										<c:otherwise>
											<li><a class="page">▶<input type="hidden" name="cPage" value="${pageDTO.beginBlock + pageDTO.pagePerBlock}"></a></li>
										</c:otherwise>
									</c:choose>
								</ol>
							</td>
						</tr>
					</tfoot>
				</table>
				<input type="button" value="글쓰기" id="write">
				<input type="button" value="삭제" id="delete">
			</form>
		</div>
	</body>
</html>