<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="kr">

	<head>
		<meta charset="UTF-8">
		<title>Document</title>
		<!-- normalize.css -->
		<link rel="stylesheet" href="resources/css/normalize.css">
		<!--상품 페이지용-->
		<link rel="stylesheet" href="resources/css/product/macat_product_category.css">
		<!--플로팅 메뉴 : 리모콘-->
		<link rel="stylesheet" href="resources/css/floating_remoteCon.css">
		<!--플로팅 메뉴 : top 버튼-->
		<link rel="stylesheet" href="resources/css/top_button.css">
		<!--여백-->
		<link rel="stylesheet" href="resources/css/spacing.css">
		
		<style type="text/css">
			<%-- 임시 페이징 --%>
			ol#paging {list-style: none;}
			ol#paging li {float: left; margin-right: 8px;}
			ol#paging li a {display: block;	padding: 3px 7px; color: #2f313e; font-weight: bold;}
			ol#paging li a:hover {background: #00B3DC; color: white; font-weight: bold;}
			.disable {padding: 3px 7px;	border: 1px solid silver; color: silver;}
			.now {padding: 3px 7px; background: purple; color: white; font-weight: bold;}
		</style>
		
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<!-- 고정헤더 불러오기 -->
		<script type="text/javascript">
			$(document).ready(function() {
				$("#macat_header").load("macat_header.jsp");
			});
		</script>
	</head>

	<body>
		<!-- 고정헤더 불러오기 -->
		<div id="macat_header"></div>
		<!-- 여백-->
		<div class="spacing"></div>
	
		<section class="main_contents_section">
			<div class="best_item-title_img_container">
				<div class="title_container">
					<c:forEach var="i" items="${categories}">
						<c:if test="${i.ctgry_level == 0}">
							<div class="title middle">
								베스트 상품
								<p>- ${i.ctgry_nm}</p>
							</div>
						</c:if>
					</c:forEach>
					<div class="sub_category">
						<c:forEach var="i" items="${categories}">
							<c:if test="${i.ctgry_level == 1}"><a href="">${i.ctgry_nm}</a></c:if>
						</c:forEach>
					</div>
				</div>
				<!--베스트 상품 이미지 파트-->
				<div class="container">
					<div class="cat_product_image">
						<div class="text">
							<h2>고양이 사료 & 상품 이미지</h2>
						</div>
						<div class="img_cat_product"></div>
						<!-- <img src="resources/img/cat01.jpg" alt=""> -->
					</div>
	
					<div class="cat_product_image brand_img">
						<div class="text">
							<h2>브랜드 사료 & 상품 이미지</h2>
						</div>
						<div class="img_brand_product"></div>
						<!-- <img src="resources/img/cat01.jpg" alt=""> -->
					</div>
				</div>
			</div>
	
			<!--상품 리스트 컨테이너-->
			<div class="product_container">
				<div class="container_position">
					<ul class="contents_ul">
						<c:forEach var="i" items="${products}">
							<li id="category_product">
								<div>
									<!--상품 이미지 링크 -->
									<div class="img_ratio_container">
										<a href="">
											<img id="product_img" src="<c:url value="resources/img/${i.prduct_thumb_nm}"></c:url>" alt="" style="display: block">
										</a>
									</div>
									<!--상품명, 가격-->
									<div class="title_price_container">
										<!--상품명-->
										<div class="product_title">
											<a href="">${i.prduct_nm}</a>
										</div>
										<!--가격-->
										<div class="price">
											<div class="like_btn">
												<a href=""><img src="resources/img/like_btn.png" alt=""></a>
											</div>
											<p>${i.prduct_price}원</p>
											<!--가격 위치조절용 div-->
											<div class="space"></div>
										</div>
									</div>
									<!--찜 a 태그-->
									<!-- <div class="like_btn">
		                                <a href=""><img src="resources/img/like_btn.png" alt=""></a>
		                            </div>-->
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div style="margin: 0 auto">
				<%-- 페이징 기법 --%>
				<ol id="paging">
					<%-- 이전 --%>
					<c:choose>
						<c:when test="${paging.beginBlock <= paging.pagePerBlock}">
							<li class="disable">◀</li>
						</c:when>
						<c:otherwise>
							<li><a class="page">◀<input type="hidden" name="cPage" value="${paging.beginBlock - paging.pagePerBlock + 4}"></a></li>
						</c:otherwise>
					</c:choose>
										
					<%-- 블록안에 들어간 페이지번호들 --%>
					<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock}" step="1" var="i">
						<%-- 현재 페이지는 링크 비활성화, 나머지는 해당 페이지로 링크 --%>
						<c:choose>
							<c:when test="${i == paging.nowPage}">
								<li class="now">${i}</li>
							</c:when>
							<c:otherwise>
								<li><a class="page">${i}<input type="hidden" name="cPage" value="${i}"></a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
										
						<%-- 다음 --%>
						<c:choose>
						<c:when test="${paging.endBlock >= paging.totalPage}">
							<li class="disable">▶</li>
						</c:when>
						<c:otherwise>
							<li><a class="page">▶<input type="hidden" name="cPage" value="${paging.beginBlock + paging.pagePerBlock}"></a></li>
						</c:otherwise>
					</c:choose>
				</ol>
			</div>
		</section>
	
		<footer> footer 파트 </footer>
		<!--top 버튼-->
		<div class="top_button">
			<a href=""><img src="resources/img/top_button.png" alt=""></a>
		</div>
		<!-- 플로팅 메뉴 : 리모콘-->
		<div class="floating_remoteCon">
			<div class="remoteCon_name">최근 본 상품</div>
			<div>
				<img src="" alt="">
			</div>
			<div>
				<img src="" alt="">
			</div>
			<div>
				<img src="" alt="">
			</div>
		</div>
	</body>
	
</html>
