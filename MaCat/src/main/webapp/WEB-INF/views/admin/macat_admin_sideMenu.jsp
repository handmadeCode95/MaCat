<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>Document</title>
		<link rel="stylesheet" type="text/css" href="resources/css/admin/macat_admin_sideMenu.css">
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
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
				<li class="side-item">
				 <img src="resources/img/mcat-arrow-down.png" alt="" >
					<a>회원관리</a>
				</li>
				<center>
					<hr width="193" noshade="noshade" size="1px" border-color="#707070">
				</center>
				<li class="side-item">
				 <img src="resources/img/mcat-arrow-down.png" alt="">
					<a>상품관리</a>
				</li>
				<center>
				<hr width="193" noshade="noshade" size="2px" border-color="#707070">
				</center>
				<li class="side-item">
				<img id="" src="resources/img/mcat-arrow-down.png" alt="">
					<a>고객혜택관리 </a>
				</li>
				<center>
					<hr width="193" noshade="noshade" size="2px" border-color="#707070">
				</center>
				<li class="side-item">
					<img src="resources/img/mcat-arrow-down.png" alt="">
					<a>공지관리 </a>
				</li>
				<center>
					<hr width="193" noshade="noshade" size="2px" border-color="#707070">
				</center>
				<li class="side-item" id="menu5">
					<img id="arrow" src="resources/img/mcat-arrow-down.png" alt="">
					<a id="side-item-sub">고객센터</a>
					<ul id="service">
						<li>고객센터 정보 관리</li>
						<li>일반 문의 관리</li>
						<li>상품 문의 관리</li>
						<li>자주 묻는 질문 관리</li>
						<li>리뷰 관리</li>
					</ul>
				</li>
			</ul>
		</nav>
	</body>

</html>