<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
	
	<link rel="stylesheet" type="text/css" href="resources/css/admin/macat_admin_sideMenu.css">
	
	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	<!-- 사이드메뉴 쿼리 -->
	<script src="resources/js/admin/macat_admin_sideMenu.js"></script>
</head>

<body>

	<head>
		<div class="header">
			<img src="resources/img/catlogo_white.png" alt="">
			<a>관리자 센터</a>
		</div>
	</head>
	<nav class="side-bar">
		<ul class="side-bar-menu">
			<li class="side-item" id="menu1">
				<img id="arrow1" src="resources/img/mcat-arrow-down.png" alt="">
				<a>판매관리</a>
			</li>
			<ul class="prd">
					<li><a href="product_manage.mcat">상품</a></li>
					<li><a href="add_product.mcat">상품등록</a></li>
					<li>주문</li>
					<li>배송</li>
			</ul>
			<center>
				<hr width="193" noshade="noshade" size="1px" border-color="#707070">
			</center>
			<li class="side-item" id="menu2">
				<img id="arrow2" src="resources/img/mcat-arrow-down.png" alt="">
				<a>회원관리</a>
			</li>
			<ul class="prd">
					<li><a href="mbers_manager.mcat">회원</a></li> <!-- 회원정보 조회 -->
					<li>쿠폰</li>
					<li>포인트</li>
				</ul>
			<center>
				<hr width="193" noshade="noshade" size="2px" border-color="#707070">
			</center>
			<li class="side-item" id="menu3">
				<img id="arrow3" src="resources/img/mcat-arrow-down.png" alt="">
				<a>고객센터</a>

			</li>
			<ul class="prd">
					<li><a href="qna_manage.mcat">고객문의</a></li>
					<li>리뷰</li>
				</ul>
			<center>
				<hr width="193" noshade="noshade" size="2px" border-color="#707070">
			</center>
			<li class="side-item" id="menu4">
				<img id="arrow4" src="resources/img/mcat-arrow-down.png" alt="">
				<a>게시글 관리</a>
			</li>
			<ul class="prd">
					<li><a href="nots_manage.mcat">공지</a></li>
					<li><a href="faq_manage.mcat">FAQ</a></li>
				</ul>
			<center>
				<hr width="193" noshade="noshade" size="2px" border-color="#707070">
			</center>
			<li class="side-item" id="menu5">
				<img id="arrow5" src="resources/img/mcat-arrow-down.png" alt="">
				<a id="side-item-sub">카테고리관리</a>
			</li>
			<ul class="prd">
				<li>미사용</li>
			</ul>
		</ul>
	</nav>
</body>

</html>