<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>FAQ 관리</title>
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
	    <script src="resources/js/admin/faq/management.js"></script>
	</head>

	<body>
	    <form action="faq_search.mcat" method="post" style="margin: 0 auto; width: 850px" id="searchForm">
	    
	    	<input type="checkbox" name="search_chk" value="qc_nm">
	        카테고리 <select class="qc_nm" name="qc_nm" disabled>
	            <option value="전체" selected>전체</option>
	            <c:forEach var="i" items="${qna_ctgries}">
	            	<option value="${i.qc_nm}">${i.qc_nm}</option>
	            </c:forEach>
	        </select>
		
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="faq_sq">
	       	번호 <input type="number" class="faq_sq" name="faq_sq" disabled><br><br>
	
	        <input type="checkbox" name="search_chk" value="faq_sj"checked>
	        제목 <input type="text" class="faq_sj" name="faq_sj">
	        
	        <input type="radio" name="and_or_chk" value="and" checked>AND
	        <input type="radio" name="and_or_chk" value="or">OR
	        <input type="button" value="조회" id="searchBtn">
	    </form>
	    
	    <hr>
	    
	    <div id="faq" style="overflow: scroll; text-align: center; margin: 0 auto;">
			<form method="post" id="resultForm">
				<h1> FAQ 목록 </h1>
				<table style="width: 500px; margin: 0 auto;">
					<thead>
						<tr><th><input type="checkbox" class="all" name="faq_all" value="0"></th>
						<th>카테고리</th><th>번호</th><th>제목</th></tr>
					</thead>
					<tbody id="searchResult">
						<c:choose>
							<c:when test="${empty faqDTO}">
								<tr>
									<td colspan="4"><h3>조회된 문의가 없습니다.</h3></td>
								</tr>
							</c:when>
							
							<c:otherwise>
								<c:forEach var="i" items="${faqDTO}">
									<tr id="${i.faq_sq}">
										<td><input type="checkbox" class="chkbox" name="faqs" value="${i.faq_sq}"></td>
										<td>${i.qc_nm}</td>
										<td>${i.faq_sq}</td>
										<td><a href="faq_view.mcat?faq_sq=${i.faq_sq}">${i.faq_sj}</a></td>
								</c:forEach>
								
								<%-- 빈칸 추가 --%>
								<c:if test="${fn:length(faqDTO) % 10 != 0}">
									<c:forEach begin="1" end="${10 - (fn:length(faqDTO) % 10)}">
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
										<c:when test="${paging.beginBlock <= paging.pagePerBlock}">
											<li class="disable">◀</li>
										</c:when>
										<c:otherwise>
											<li><a class="page">◀<input type="hidden" name="cPage" value="${paging.beginBlock - 1}"></a></li>
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
				<input type="button" value="삭제" id="delete">
			</form>
		</div>
	</body>
</html>