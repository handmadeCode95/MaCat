<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항</title>
		<link rel="stylesheet" href="resources/css/normalize.css">
		<link rel="stylesheet" href="resources/css/admin/notices/view.css">
		<script src="resources/js/jquery-3.4.1.min.js"></script>
        <script src="resources/js/admin/notices/view.js"></script>
	</head>
	
	<body>
		<div id="bbs">
		<form method="post">
			<table summary="게시판 읽기">
				<caption>게시판 읽기</caption>
				<tbody>
					<tr>
						<th>제목:</th>
						<td>${bvo.subject}</td>
					</tr>
					<tr>
						<th>이름:</th>
						<td>${bvo.writer}</td>
					</tr>
					<tr>
						<th>첨부파일:</th>
						<td>
							<c:choose>
								<c:when test="${empty bvo.file_name}">
									<b>첨부파일 없음</b>
								</c:when>
								<c:otherwise>
									<a href="download.mcat?file_name=${bvo.file_name}">${bvo.file_name}</a> 
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>내용:</th>
						<td><pre>${bvo.content}</pre></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" value="${cPage}" name="cPage">
							<input type="button" value="수정" onclick="update_go(this.form)"/>
							<input type="button" value="삭제" onclick="delete_go(this.form)"/>
							<input type="button" value="목록" onclick="list_go(this.form)"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
		<br>
		
		<div id="ans_write">
			<p>댓글 쓰기</p>
			<hr>
		
			<br>
			<form method="post" action="com_write.mcat">
				<p>이름 : <input type="text" name="writer" size="15"></p>
				<p>내용 : <br>
					<textarea rows="4" cols="50" name="content"></textarea>
				</p>
				<p>비밀번호 : <input type="password" name="pwd" size="15"></p>
				<input type="hidden" value="${cPage}" name="cPage">
				<input type="hidden" name="b_idx" value="${bvo.b_idx}">
				<input type="submit" value="댓글 등록">
			</form>
		</div>
		<br>

		<div id="ans_view">
			<p>댓글</p>
			<hr>
			<c:forEach var="k" items="${c_list}">
				<form action="com_del.mcat" method="post">
					<p>이름 : ${k.writer}</p>
					<p>날짜 : ${k.write_date.substring(0, 10)}</p>
					<pre>내용 : ${k.content}</pre>
					<input type="hidden" name="c_idx" value="${k.c_idx}">
					<input type="hidden" name="b_idx" value="${bvo.b_idx}">
					<input type="hidden" value="${cPage}" name="cPage">
					<input type="submit" value="댓글 삭제">
				</form>
				<hr>
			</c:forEach>
		</div>
	</body>
	
</html>

