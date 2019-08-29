<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>구매후기 페이지</title>
	<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
	
	<link rel="stylesheet" href="resources/css/normalize.css">
	<!-- 리뷰 페이지 -->
	<link rel="stylesheet" href="resources/css/member/review.css">
	
	<link rel="stylesheet" href="resources/css/spacing.css">

	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>

</head>
<body>
    <!-- 고정헤더 불러오기 -->
	<div id="macat_header">
		<%@ include file="../head.jsp"%>
	</div>
    <!-- 여백-->
    <div class="spacing"></div>

	<section id="wrap">
		<div class="contents">
			<div class="wish-list">
				<div class="wish-list-title">
					<div id="path">
						<ol>
							<li>홈</li>
							<li>마이쇼핑</li>
							<li>
								<strong>구매후기</strong>
							</li>
						</ol>
					</div>
					<div id="title">
						<h2>구매후기</h2>
					</div>
				</div>
				<div class="wish-list-menu">
					<table class="wish-list-main">
						<caption>구매후기 목록</caption>
						<colgroup>
							<col style="width:70px;">
							<col style="width:150px;">
							<col style="width:auto;">
							<col style="width:84px;">
							<col style="width:55px;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">상품정보</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">조회</th>
							</tr>
						</thead>
						<tbody id="wish-list-main-menu">
							<tr>
								<td>번호</td>
								<td>상품정보</td>
								<td>제목</td>
								<td>작성자</td>
								<td>조회</td>
							</tr>
						</tbody>
						<tbody class="list_none">
							<tr>
								<td colspan="8">구매 후기가 없습니다.</td>
							</tr>
						</tbody>
					</table>
					<div class="btn">
						<span id="new-post-btn">
							<a href="#">
								<img src="resources/img/macat_write.png" alt="">
							</a>
						</span>
					</div>
					<div class="search-bar">
					    <p>상품분류
					    <select id="ctg-select">
                            <option value="">카테고리분류</option>
					        <option value="">사료</option>
					        <option value="">간식</option>
					        <option value="">화장실/모래</option>
					        <option value="">장난감</option>
					        <option value="">생활용품</option>
					        <option value="">악세사리</option>
					        <option value="">목욕/위생</option>
					    </select>
                        </p>
					    <p>검색어
					    <select name="" id="">
					        <option value="">제목</option>
					        <option value="">내용</option>
					        <option value="">아이디</option>
					    </select>
					    <input type="text">
					    <a href="#"><img src="resources/img/mcat_search.png" alt=""></a>
					    </p>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

</html>