<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>고객문의 :: ${qnaVO.qna_sj}</title>
		<style type="text/css">
			*{font-family: "나눔고딕";}
			table{margin: 20px auto;}
			tr {text-align:left; padding:4px 10px; background-color: #F6F6F6;}
			th {width:120px; text-align:center; padding:4px 10px; background-color: #B2CCFF;}
		</style>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script src="resources/js/admin/qna/view.js"></script>
	</head>
	
	<body>
		<form method="post">
			<table width="700">
				<tbody>
					<tr>
						<th bgcolor="#B2EBF4">답변여부</th>
						<td><c:if test="${qnaVO.qna_ans_st == 0}">미답변</c:if>
						<c:if test="${qnaVO.qna_ans_st == 1}">답변완료</c:if></td>
					</tr>
					<tr>
						<th bgcolor="#B2EBF4">문의 번호</th>
						<td>${qnaVO.qna_sq}</td>
					</tr>
					<tr>
						<th bgcolor="#B2EBF4">제목</th>
						<td>${qnaVO.qna_sj}</td>
					</tr>
					<tr>
						<th bgcolor="#B2EBF4">고객명</th>
						<td>${qnaVO.qna_nm}</td>
					</tr>
					<tr>
						<th bgcolor="#B2EBF4">아이디</th>
						<td>${qnaVO.qna_id}</td>
					</tr>
					<tr>
						<th bgcolor="#B2EBF4">등록일</th>
						<td>${qnaVO.qna_reg_dt.substring(0, 10)}</td>
					</tr>
					<tr>
						<th bgcolor="#B2EBF4">조회수</th>
						<td>${qnaVO.qna_view_cnt}</td>
					</tr>
					<tr>
						<th bgcolor="#B2EBF4">내용</th>
						<td><pre>${qnaVO.qna_cn}</pre></td>
					</tr>
					</tbody>
					<tfoot>
					<tr>
					    <td colspan="2" align="center">
					    	<input type="button" value="목록" id="listGO" />
					    	<%-- 하단 jstl : 사용자 로그인 정보를 이용한 버튼 숨김처리 --%>
					        <input type="button" value="답글" id="answerGO"
					        <c:if test="${sessionScope.loginChk.mber_grad != 4}"> style="display: none"</c:if> />
					        <input type="button" value="수정" id="updateGO" style="display: none"
					        <c:if test="${qnaVO.mber_sq != sessionScope.loginChk.mber_sq}"> style="display: none"</c:if> />
					        <input type="button" value="삭제" id="deleteGO" style="display: none"
					        <c:if test="${qnaVO.mber_sq != sessionScope.loginChk.mber_sq || sessionScope.loginChk.mber_grad != 4}"> style="display: none"</c:if> />
					    </td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>

</html>