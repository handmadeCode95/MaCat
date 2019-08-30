<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>공지사항 수정</title>
		<style type="text/css">
			#bbs table {width:580px; margin-left:10px; margin: 0 auto; border:1px solid black; border-collapse:collapse; font-size:14px;}
			#bbs table caption {font-size:20px; font-weight:bold; margin-bottom:10px;}
			#bbs table th {text-align:center; border:1px solid black; padding:4px 10px;}
			#bbs table td { text-align:left; border:1px solid black; padding:4px 10px;}
			.no {width:15%}
			.subject {width:30%}
			.writer {width:20%}
			.reg {width:20%}
			.hit {width:15%}
			.title{background:lightsteelblue}
			.odd {background:silver}
		</style>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script src="resources/js/admin/notices/update.js"></script>
	</head>
	
	<body>
		<div id="bbs">
		<form method="post" action="update.mcat">
			<table summary="공지사항 수정">
				<caption>공지사항 수정</caption>
				<tbody>
					<tr>
						<th>제목:</th>
						<td><input type="text" name="subject" size="45" value="${bvo.subject}"/></td>
					</tr>
					<tr>
						<th>이름:</th>
						<td><input type="text" name="writer" size="12" value="${bvo.writer}"/></td>
					</tr>
					<tr>
						<th>내용:</th>
						<td><textarea name="content" cols="50" rows="8">${bvo.content}</textarea></td>
					</tr>
					<tr>
						<th>비밀번호:</th>
						<td><input type="password" name="pwd" size="12"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" name="b_idx" value="${bvo.b_idx}"/>
							<input type="button" value="수정 완료" onclick="sendData()"/>
							<input type="reset" value="초기화"/>
							<input type="button" value="취소" onclick="javascript:location.href='view.mcat?b_idx=${bvo.b_idx}&cPage=${cPage}'"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</body>
	
</html>

