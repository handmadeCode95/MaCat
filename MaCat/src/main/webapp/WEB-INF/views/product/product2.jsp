<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>Document</title>
		<!--초기화-->
		<link rel="stylesheet" href="resources/css/normalize.css">
		<link rel="stylesheet" href="resources/css/spacing.css">
		<!--탭메뉴 css-->
		<link rel="stylesheet" href="resources/css/product/tab_menu.css">
		<!--상품 상세페이지-->
		<link rel="stylesheet" href="resources/css/product/macat_product.css">
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<!--탭메뉴 쿼리-->
		<script>
			$(function() {
				$('ul.tab-titles li').click(function() {
					var activeTab = $(this).attr('data-tab-titles');
					$('ul.tab-titles li').removeClass('current');
					$('.tabcontent').removeClass('current');
					$(this).addClass('current');
					$('#' + activeTab).addClass('current');
				})
			});
		</script>
	</head>
	
	<body>
		<!-- 고정헤더 불러오기 -->
		<div id="macat_header"><div id="macat_header"><%@ include file="../macat_header.jsp" %></div></div>
		<!-- 여백-->
		<div class="spacing"></div>
	
		<section id="wrap">
			<div class="product_img_info">
				<!---->
				<div class="img_part">
					<div class="main_img">
						<img src="resources/img/macat_food01.png" alt="">
					</div>
					<!--왼쪽 : 이미지 파트-->
					<div class="img_choice">
						<div class="slide_choice">
							<img src="resources/img/macat_food01.png" alt="">
							<img src="resources/img/macat_food01.png" alt="">
							<img src="resources/img/macat_food01.png" alt="">
							<img src="resources/img/macat_food01.png" alt="">
						</div>
					</div>
				</div>
				<!--오른쪽 정보 파트-->
				<div class="info_part">
					<div class="product_title">
						<div class="product_name">
							<ul>
								<li>
									<p>${product.prduct_nm}</p>
								</li>
								<li>
									<p id="star">
										<c:forEach var="i" begin="2" end="${product.prduct_rating_round}" step="2">
											<img src="resources/img/mcat-whole-star.png" alt="★">
										</c:forEach>
										<c:if test="${product.prduct_rating_round % 2 == 1}">
											<img src="resources/img/mcat-half-star.png" alt="☆">
										</c:if>
									</p>
								</li>
							</ul>
						</div>
						<div class="category_directory-review_count">
							<ul>
								<li>
									<p id="directory1">베스트 상품&nbsp;></p>
									<p id="directory2">&nbsp;&nbsp;캣타워</p>
								</li>
								<li>
									<p id="review_count">상품평 : 7개 &nbsp;</p>
								</li>
							</ul>
						</div>
					</div>
					<!--상품가격 파트-->
					<div class="product_price_container">
						<ul>
							<li>
								<p class="title">상품가격</p>
								<p class="info"><fmt:formatNumber value="${product.prduct_price}" pattern="#,###"></fmt:formatNumber></p>
							</li>
							<li>
								<p class="title">상품코드</p>
								<p class="info">${product.prduct_sq}</p>
							</li>
						</ul>
					</div>
					<!--배송, 적립 파트-->
					<div class="delivery_point_container">
						<div class="align_container">
							<ul class="delivery">
								<li>
									<p class="title_left">배송비</p>
								</li>
								<li>
									<p class="price"><fmt:formatNumber value="${product.prduct_dlvy_price}" pattern="#,###"></fmt:formatNumber></p>
								</li>
								<li>
									<p class="title_left">포인트 적립</p>
								</li>
								<li>
									<p class="point"><fmt:formatNumber value="${product.prduct_point}" pattern="#,###"></fmt:formatNumber> p</p>
								</li>
							</ul>
							<ul class="point_select">
								<li>
									<p class="title_right">주문수량</p>
								</li>
								<li>
									<p class="product_count_box">
										<select name="수량선택" id="">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>
									</p>
								</li>
								<li>
									<p class="title_right">컬러</p>
								</li>
								<li>
									<p class="color_choice_box">
										<select name="수량선택" id="">
											<option value="0">color</option>
											<option value="1">레드</option>
											<option value="2">블루</option>
											<option value="3">그린</option>
											<option value="4">다라이 레드</option>
											<option value="5">봉고 블루</option>
											<option value="6">마미손 핑크</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
										</select>
									</p>
								</li>
							</ul>
						</div>
					</div>
					<!--총가격 파트-->
					<div class="total_price">
						<p>
							총 <span><fmt:formatNumber value="${product.prduct_dced_price + product.prduct_dlvy_price}" pattern="#,###"></fmt:formatNumber> 원 </span>
						</p>
					</div>
					<!--찜리스트 장바구니 바로구매 버튼 파트-->
					<div class="btn_container">
						<ul>
							<!-- 찜리스트 추가 & 추가성공 alert 창만 출력-->
							<a href="">
								<li class="like_btn"><img src="resources/img/mcat_like_btn_new.png"
									alt=""></li>
							</a>
						</ul>
						<ul>
							<!-- 장바구니에 추가하시겠습니까 ask : 확인 = 추가되었습니다 / 취소 = 상품상세페이지-->
							<a href="">
								<li class="cart"><img src="resources/img/mcat_cart.png" alt="">
							</li>
							</a>
						</ul>
						<ul>
							<!-- 구매하기 : 결제 페이지로 이동 -->
							<a href="">
								<li class="buying"><img src="resources/img/mcat_buying.png" alt="">
							</li>
							</a>
						</ul>
					</div>
				</div>
			</div>
	
			<!--탭 메뉴 파트-->
			<div class="product_tab_container-tabmenu" id="item_list">
				<div class="tab" id="item_tab">
					<ul class="tab-titles" id="tab-titles">
						<li class="current" data-tab-titles="tab1"><a href="#Redirect">상품상세</a>
						</li>
						<li data-tab-titles="tab2"><a href="#Redirect">상품리뷰</a></li>
						<li data-tab-titles="tab3"><a href="#Redirect">상품문의</a></li>
						<li data-tab-titles="tab4"><a href="#Redirect">배송정보</a></li>
					</ul>
	
					<!--각 메뉴탭별로 다른 페이지를 구현할 것임-->
					<div id="tab1" class="tabcontent current">
						<%-- ${product.prduct_cn} --%>
					</div>
					<div id="tab2" class="tabcontent">
						상품리뷰 페이지입니다 <img src="resources/img/boy.png"
							style="display: block; width: 50%; margin: 0px auto;"> <img
							src="resources/img/coffe.png"
							style="display: block; width: 50%; margin: 0px auto;"> <img
							src="resources/img/dog.png"
							style="display: block; width: 50%; margin: 0px auto;">
					</div>
					<div id="tab3" class="tabcontent">
						상품문의 페이지입니다 <img src="resources/img/boy.png"
							style="display: block; width: 50%; margin: 0px auto;"> <img
							src="resources/img/coffe.png"
							style="display: block; width: 50%; margin: 0px auto;"> <img
							src="resources/img/dog.png"
							style="display: block; width: 50%; margin: 0px auto;">
					</div>
					<div id="tab4" class="tabcontent">
						배송정보 페이지입니다 <img src="resources/img/boy.png"
							style="display: block; width: 50%; margin: 0px auto;"> <img
							src="resources/img/coffe.png"
							style="display: block; width: 50%; margin: 0px auto;"> <img
							src="resources/img/dog.png"
							style="display: block; width: 50%; margin: 0px auto;">
					</div>
				</div>
			</div>
			<!--관련상품 파트-->
			<div class="related_products">
				<p>관련상품</p>
				<div class="container">
					<!-- 각 이미지에 해당되는 상품상세페이지로 이동-->
					<div class="related_product_slide">
						<img src="resources/img/macat_food02.png" alt=""
							onclick="alert('너는 바보입니다.')"> <img
							src="resources/img/macat_food03.png" alt="" onclick="alert('너는 바보입니까.')">
						<img src="resources/img/macat_food04.png" alt=""
							onclick="alert('너는 바보로구나.')"> <img
							src="resources/img/macat_food05.png" alt="" onclick="alert('너는 호구로구나.')">
						<img src="resources/img/macat_food06.png" alt=""
							onclick="alert('호날두나 되라.')">
					</div>
					<!-- 더보기 : 현재 위치한 상품상세페이지의 상품 카테고리 페이지로 이동시킴-->
					<input id="details" type="button" value="더보기"
						onclick="location.href='resources/html5/macat_product_category.html'">
				</div>
			</div>
			<!--상품정보 파트-->
			<div class="product_info_table">
				<table>
					<th></th>
				</table>
			</div>
		</section>
	</body>
	
</html>
