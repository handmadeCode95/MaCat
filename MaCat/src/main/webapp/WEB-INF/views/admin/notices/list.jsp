<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>회원 정보 관리</title>
		<style type="text/css">table, tr, td, th{border: 1px solid black; border-collapse: collapse;}</style>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<script src="resources/js/admin/notices/list.js"></script>
	</head>

	<body>
		<div style="overflow: scroll; text-align: center; margin: 0 auto;">
			<form method="post" action="notice_update.mcat">
				<h1> 공지사항 목록 </h1>
				<table style="width: 500px; margin: 0 auto;">
					<thead>
						<tr><th><input type="checkbox" class="all" name="notices_all" value="0"></th>
						<th>번호</th><th>제목</th><th>담당자</th><th>등록일</th><th>수정</th>
					</thead>
					<tbody>
                        <c:choose>
							<c:when test="${empty notices_list}">
								<tr>
									<td colspan="6"><h3>조회된 공지사항이 없습니다.</h3></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="k" items="${notices_list}" varStatus="vs">
									<tr>
										<td><input type="checkbox" class="chkbox" name="notices" value="${k.not_sn}"></td>
										<td>${k.not_sn}<input type="hidden" name="not_sn" value="${k.not_sn}"></td>
										<td><a href="#">${k.not_sj}</a></td>
										<td>${k.not_name}</td>
										<td>${k.not_reg_date.substring(0, 10)}</td>
										<td><button onclick="">수정</button></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<input type="submit" value="글쓰기">
				<input type="button" value="삭제" onclick="withdrawal(this.form)">
			</form>
		</div>
	</body>
</html>