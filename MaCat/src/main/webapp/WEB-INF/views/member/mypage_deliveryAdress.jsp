<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
!<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
	
	<link rel="stylesheet" href="resources/css/normalize.css">
	<!-- 이상없음 -->
	<link rel="stylesheet" href="resources/css/member/macat_mypage_deliveryAdress.css">
	
	<link rel="stylesheet" href="resources/css/spacing.css">

	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>	
</head>

<body>
    <!-- 고정헤더 불러오기 -->
    <div id="macat_header"><%@ include file="../head.jsp" %></div>
	<!-- 여백-->
	<div class="spacing"></div>

	<section id="wrap">
		<div class="contents">
			<div class="adress">
				<div class="adress_title">
					<div id="path">
						<ol>
							<li>홈</li>
							<li>마이쇼핑</li>
							<li>
								<strong>배송 주소록 관리</strong>
							</li>
						</ol>
					</div>
					<div id="title">
						<h2>배송 주소록 관리</h2>
					</div>
				</div>
				<div class="adress_list">
					<table class="adress_list_main">
						<caption>게시판 목록</caption>
						<colgroup>
							<col style="width:27px;">
							<col style="width:80px;">
							<col style="width:95px;">
							<col style="width:95px;">
							<col style="width:120px;">
							<col style="width:120px;">
							<col style="width:auto;">
							<col style="width:76px;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">
									<span>
										<input type="checkbox">
									</span>
								</th>
								<th scope="col">주소록 고정</th>
								<th scope="col">배송지명</th>
								<th scope="col">수령인</th>
								<th scope="col">일반전화</th>
								<th scope="col">휴대전화</th>
								<th scope="col">주소</th>
								<th scope="col">수정</th>
							</tr>
						</thead>
						<tbody id="adr_main_list">
							<tr>
								<td>
									<span>
										<input type="checkbox">
									</span>
								</td>
								<td><a href="#">고정</a></td>
								<td>배송지명</td>
								<td>수령인</td>
								<td>일반전화</td>
								<td>휴대전화</td>
								<td>주소</td>
								<td><a href="#">수정</a></td>
							</tr>
						</tbody>
						<tbody class="list_none">
							<tr>
								<td colspan="8">등록된 주소가 없습니다.</td>
							</tr>
						</tbody>
					</table>
					<div class="del_or_new_btn">
						<span id="left_del_btn">
							<a href="#">
								선택 주소록 삭제
							</a>
						</span>
						<span id="right_cre_btn">
							<a href="#">
								배송지등록
							</a>
						</span>
					</div>
					<div class="precautions">
						<h3>배송주소록 유의사항</h3>
						<div class="precautions_list">
							<ol>
								<li class="item1">배송 주소록은 최대 10개까지 등록할 수 있으며, 별도로 등록하지 않을 경우 최근 배송 주소록 기준으로 자동 업데이트 됩니다.</li>
								<li class="item2">자동 업데이트를 원하지 않을 경우 주소록 고정 선택을 선택하시면 선택된 주소록은 업데이트 대상에서 제외됩니다.</li>
								<li class="item3">기본 배송지는 1개만 저장됩니다. 다른 배송지를 기본 배송지로 설정하시면 기본 배송지가 변경됩니다.</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

</html>