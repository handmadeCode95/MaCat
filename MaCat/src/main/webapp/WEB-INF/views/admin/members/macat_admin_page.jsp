<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">

	<head>
	<meta charset="UTF-8">
	<title>마캣 관리자 페이지</title>
	<!-- 초기화 -->
	<link rel="stylesheet" href="resources/css/macat_admin/normalize.css">
	<!-- 관리자페이지 css -->
	<link rel="stylesheet"
		href="resources/css/macat_admin/macat_admin_page.css">
	<!-- 체크박스 css -->
	<link rel="stylesheet" href="resources/css/macat_admin/checkbox.css">
	<!-- 라디오박스 css -->
	<link rel="stylesheet" href="resources/css/macat_admin/radiobutton.css">
	<!-- 관리자 테이블 css-->
	<link rel="stylesheet" href="resources/css/macat_admin/admin_table.css">
	
	<!-- <link rel="stylesheet" type="text/css" href="resources/css/macat_admin/macat_admin_sideMenu.css"> -->
	<!-- checked 속성 poly-checked 추가 -->
	<script src="resources/js/jquery-3.4.1.min.js"></script>
	<!--[if lte IE 8]> <script src="path/to/poly-checked.min.js"></script> <![endif]-->
	<script type="text/javascript">
	
		$(document).ready(function() {
			$("li").each(function() {
				$(this).click(function() {
					$(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
					$(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
				});
			});
		});
	</script>
	<!-- checkbox 전체선택 쿼리 -->
	<script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
	</head>
	
	<body>
		<%@ include file="../macat_admin_sideMenu.jsp"%>
		<main>
		<section class="wrap">
			<div class="member_management">
				<span>회원관리</span>
			</div>
			<div class="member_information_container">
				<!--회원정보-->
				<div class="member_info">
					<div class="member_info_title">
						<span>회원정보</span>
					</div>
					<div class="infomation_control_part">
						<!--이름 아이디 핸드폰번호 생일-->
						<div class="member_info_middle">
							<div class="checks">
								<input type="checkbox" id="name_chk"> <label
									for="name_chk" style="margin-right: 54px;">이름</label> <input
									type="text">
							</div>
							<div class="checks">
								<input type="checkbox" id="id_chk"> <label for="id_chk"
									style="margin-right: 40px;">아이디</label> <input type="text">
							</div>
							<div class="checks">
								<input type="checkbox" id="cellphone_chk"> <label
									for="cellphone_chk" style="margin-right: 12px;">핸드폰번호</label> <input
									type="text">
							</div>
							<div class="checks">
								<input type="checkbox" id="birth_chk"> <label
									for="birth_chk">생일</label>
								<div>
									<input type="text" class="birth_box1"> ~ <input
										type="text" class="birth_box2">
								</div>
	
							</div>
						</div>
						<!--회원번호 회원등급 전화번호-->
						<div class="member_info_right">
							<div class="checks">
								<input type="checkbox" id="member_no"> <label
									for="member_no" style="margin-right: 13px;">회원번호</label> <input
									type="text">
							</div>
							<div class="checks">
								<input type="checkbox" id="member_grade"> <label
									for="member_grade" style="margin-right: 13px;">회원등급</label> <input
									type="text">
							</div>
							<div class="checks">
								<input type="checkbox" id="phone_num"> <label
									for="phone_num" style="margin-right: 13px;">전화번호</label> <input
									type="text">
							</div>
						</div>
					</div>
				</div>
				<!--기간-->
				<div class="searching_term">
					<div class="searching_term_title">
						<span>기간</span>
					</div>
					<div class="searching_term_middle">
						<div class="checks">
							<input type="checkbox" id="join_date"> <label
								for="join_date" style="margin-right: 36px;">가입일</label>
							<div>
								<input type="text" class="join_box1"> ~ <input
									type="text" class="join_box2">
							</div>
						</div>
						<div class="checks">
							<input type="checkbox" id="connect_term"> <label
								for="connect_term" style="margin-right: 21px;">접속기간</label>
							<div>
								<input type="text" class="connect_box1"> ~ <input
									type="text" class="connect_box2">
							</div>
	
						</div>
					</div>
					<!-- 기간 선택 파트 -->
					<div class="searching_term_right part2">
						<div class="join_period_btn">
							<ul>
								<li>오늘</li>
								<li>1주일</li>
								<li>1개월</li>
								<li>3개월</li>
								<li>6개월</li>
								<li>1년</li>
							</ul>
						</div>
						<div class="connect_period_btn">
							<ul>
								<li>오늘</li>
								<li>1주일</li>
								<li>1개월</li>
								<li>3개월</li>
								<li>6개월</li>
								<li>1년</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- 버튼 파트-->
				<div class="btn_part">
					<div class="and_or_radio_btn">
						<!--and 라디오 버튼-->
						<div class="and_container">
							<div class="and">
								<input type="radio" name="and_or" id="and_btn" checked="checked" />
								<label for="and_btn">AND</label>
							</div>
						</div>
						<!--or 라디오 버튼-->
						<div class="or_container">
							<div class="or">
								<input type="radio" name="and_or" id="or_btn" /> <label
									for="or_btn">OR</label>
							</div>
						</div>
					</div>
					<div class="view_refresh_btn">
						<input class="view_btn" type="button" value="조회"> <input
							class="refresh_btn" type="button" value="초기화">
					</div>
				</div>
			</div>
			<!-- 테이블 파트-->
			<div class="member_info_table_title">
				<span>회원정보</span>
			</div>
			<div class="info_table">
				<table class="type11" id="checkbox_js">
					<colgroup>
						<col width="40px;" />
						<col width="100px;" />
						<col width="100px;" />
						<col width="140px;" />
						<col width="140px;" />
						<col width="240px;" />
						<col width="145px;" />
						<col width="145px;" />
						<col width="130px;" />
						<col width="130px;" />
						<col width="130px;" />
						<col width="83px;" />
						<col width="72.5px;" />
					</colgroup>
					<tr>
						<th><input type="checkbox" id="allCheck"></th>
						<th scope="col">회원번호</th>
						<th scope="col">이름</th>
						<th scope="col">아이디</th>
						<th scope="col">비밀번호</th>
						<th scope="col">이메일</th>
						<th scope="col">핸드폰번호</th>
						<th scope="col">전화번호</th>
						<th scope="col">생년월일</th>
						<th scope="col">가입일</th>
						<th scope="col">접속일</th>
						<th scope="col">포인트</th>
						<th scope="col">우편번호</th>
					</tr>
					<tr>
						<td><input type="checkbox" id="table_chk"></td>
						<td>1001</td>
						<td>손석배</td>
						<td>sonseokbae</td>
						<td>****************</td>
						<td>sonseokbae@hanmail.net</td>
						<td>01012345678</td>
						<td>03365427897</td>
						<td>1990-08-06</td>
						<td>2019-04-16</td>
						<td>2019-08-02</td>
						<td>1,000,000p</td>
						<td>12345</td>
					</tr>
				</table>
			</div>
		</section>
	
		</main>
	</body>
	
</html>
