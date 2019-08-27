<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>고객 문의 관리</title>
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
	    <script src="resources/js/admin/qna/management.js"></script>
	</head>

	<body>
	    <form action="qna_search.mcat" method="post" style="margin: 0 auto; width: 850px" id="searchForm">
	    
	    	<input type="checkbox" name="search_chk" value="qc_nm">
	        카테고리 <select class="qc_nm" name="qc_nm" disabled>
	            <option value="전체" selected>전체</option>
	            <c:forEach var="i" items="${qna_ctgries}">
	            	<option value="${i.qc_nm}">${i.qc_nm}</option>
	            </c:forEach>
	        </select>
		
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="qna_sq">
	       	문의 번호 <input type="number" class="qna_sq" name="qna_sq" disabled>
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="qna_sj"checked>
	        제목 <input type="text" class="qna_sj" name="qna_sj"><br><br>
	
	        <input type="checkbox" name="search_chk" value="qna_nm">
	        고객명 <input type="text" class="qna_nm" name="qna_nm" disabled>
	        
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="qna_id">
	        아이디 <input type="text" class="qna_id" name="qna_id" disabled><br><br>
		
	        <input type="checkbox" name="search_chk" value="qna_reg_dt">
	        등록일 <input type="date" class="qna_reg_dt" name="qna_reg_dt_start" disabled>~
	        <input type="date" class="qna_reg_dt" name="qna_reg_dt_end" disabled><br><br>
	        
	        <input type="radio" name="view" value="0" checked>미답변 문의 보기
	        <input type="radio" name="view" value="1">답변 완료 문의 보기
	        <input type="radio" name="view" value="2">전체 보기<br><br>
	        <input type="radio" name="and_or_chk" value="and" checked>AND
	        <input type="radio" name="and_or_chk" value="or">OR
	        <input type="button" value="조회" id="searchBtn">
	    </form>
	    
	    <hr>
	    
	    <div id="qna" style="overflow: scroll; text-align: center; margin: 0 auto;">
			<form method="post" id="resultForm">
				<h1> 고객 문의 목록 </h1>
				<table style="width: 500px; margin: 0 auto;">
					<thead>
						<tr><th><input type="checkbox" class="all" name="qna_all" value="0"></th>
						<th>답변여부</th><th>카테고리</th><th>문의 번호</th><th>제목</th><th>고객명</th><th>아이디</th><th>등록일</th><th>조회수</th></tr>
					</thead>
					<tbody id="searchResult">
						<c:choose>
							<c:when test="${empty qnaDTO}">
								<tr>
									<td colspan="9"><h3>조회된 문의가 없습니다.</h3></td>
								</tr>
							</c:when>
							
							<c:otherwise>
								<c:forEach var="i" items="${qnaDTO}">
									<tr id="${i.qna_sq}">
										<td><input type="checkbox" class="chkbox" name="qnas" value="${i.qna_sq}"></td>
										<td>
											<c:if test="${i.qna_ans_st == 0}">미답변</c:if>
											<c:if test="${i.qna_ans_st == 1}">답변완료</c:if>
											<c:if test="${i.qna_ans_st == 2}">답글</c:if>
										</td>
										<td>${i.qc_nm}</td>
										<td>${i.qna_sq}</td>
										<td>
											<c:forEach begin="1" end="${i.qna_level}">
												&nbsp;&nbsp;┗
											</c:forEach>
											<a href="qna_view.mcat?qna_sq=${i.qna_sq}">${i.qna_sj}</a>
										</td>
										<td>${i.qna_nm}</td>
										<td>${i.qna_id}</td>
										<td>${i.qna_reg_dt.substring(0, 10)}</td>
										<td>${i.qna_view_cnt}</td>
								</c:forEach>
								
								<%-- 빈칸 추가 --%>
								<c:if test="${fn:length(qnaDTO) % 10 != 0}">
									<c:forEach begin="1" end="${10 - (fn:length(qnaDTO) % 10)}">
										<tr>
											<%-- 공백 삽입 --%>
											<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
										</tr>
									</c:forEach>
								</c:if>
							</c:otherwise>
						</c:choose>
					</tbody>
					<%-- 페이징 기법 --%>
					<tfoot>
						<tr>
							<td colspan="9">
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
				<input type="button" value="삭제" id="delete">
			</form>
		</div>
	</body>
</html>