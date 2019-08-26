<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>상품 카테고리 페이지</title>
	<!-- normalize.css -->
	<link rel="stylesheet" href="resources/css/normalize.css">
	<!--상품 페이지용-->
	<link rel="stylesheet" href="resources/css/product/macat_product_category.css">
	<!--여백-->
	<link rel="stylesheet" href="resources/css/spacing.css">
	<!-- 페이징 -->
	<link rel="stylesheet" href="resources/css/paging.css">
	
	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	
	<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
</head>

<body>
	<!-- 고정헤더 불러오기 -->
	<div id="macat_header">
		<%@ include file="../head.jsp"%>
	</div>
	<!-- 여백-->
	<div class="spacing"></div>
	<!-- 리모콘 블러오기 -->
	<div class="remoteCon_load">
		<%@ include file="../macat_float_remoteCon.jsp"%>
	</div>
	<!-- top 버튼 불러오기 -->
	<div class="top_btn_load">
		<%@ include file="../macat_float_topBtn.jsp"%>
	</div>

	<section class="main_contents_section">
		<div class="best_item-title_img_container">
			<div class="title_container">
				<div class="title middle">
					<c:choose>
						<c:when test="${ctgry_level eq 0}">
								베스트 상품
							</c:when>
						<c:otherwise>
								${ctgry_nm}
							</c:otherwise>
					</c:choose>
					<c:forEach var="i" items="${sessionScope.categories}">
						<c:if test="${i.ctgry_level eq 0 && ctgry_group eq i.ctgry_group}">
							<p>-${i.ctgry_nm}</p>
						</c:if>
					</c:forEach>
				</div>
				<div class="sub_category">
					<c:forEach var="i" items="${sessionScope.categories}">
						<c:if test="${ctgry_group eq i.ctgry_group}">
							<%-- a태그 시작 --%>
							<a
								href="category.mcat?ctgry_group=${i.ctgry_group}&ctgry_level=${i.ctgry_level}&ctgry_nm=${i.ctgry_nm}"
								<c:if test="${ctgry_nm eq i.ctgry_nm}">
										id="selectedCtgry"
									</c:if>>
								<%-- a태그 내용부분 --%> <c:choose>
									<c:when test="${i.ctgry_level < 1}">
											전체
										</c:when>
									<c:otherwise>
											${i.ctgry_nm}
										</c:otherwise>
								</c:choose>
							</a>
							<%-- a태그 끝 --%>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<!--베스트 상품 이미지 파트-->
			<div class="container">
				<div class="cat_product_image">
					<div class="text">
						<h2>고양이 사료 & 상품 이미지</h2>
					</div>
					<div class="img_cat_product">
						<a href="macat_product_category.html"> 
							<img src="resources/img/cat01.jpg" alt="고양이사료 카테고리이미지">
						</a>
					</div>
				</div>

				<div class="cat_product_image brand_img">
					<div class="text">
						<h2>브랜드 사료 & 상품 이미지</h2>
					</div>
					<div class="img_brand_product">
						<a href="macat_product_category.html">
							<img src="resources/img/cat02.jpg" alt="브랜드사료 카테고리이미지">
						</a>
					</div>
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
									<a
										href="product.mcat?prduct_sq=${i.prduct_sq}&prduct_thumb_nm=${i.prduct_thumb_nm}">
										<img id="product_img" src="resources/img/${i.prduct_thumb_nm}"
										alt="" style="display: block">
									</a>
								</div>
								<!--상품명, 가격-->
								<div class="title_price_container">
									<!--상품명-->
									<div class="product_title">
										<a
											href="product.mcat?prduct_sq=${i.prduct_sq}&prduct_thumb_nm=${i.prduct_thumb_nm}">${i.prduct_nm}</a>
									</div>
									<!--가격-->
									<div class="price">
										<!-- 좋아요버튼 -->
										<div class="like_btn">
											<a href=""><img src="resources/img/like_btn.png" alt=""></a>
										</div>
										<p>
											<fmt:formatNumber value="${i.prduct_price}" pattern="#,###"></fmt:formatNumber>
											원
										</p>
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

		<div id="pagingDiv">
			<%-- 페이징 --%>
			<ol id="paging">
				<%-- 이전 --%>
				<c:choose>
					<c:when test="${paging.beginBlock <= paging.pagePerBlock}">
						<li class="pagingDisable"><img
							src="resources/img/mcat-arrow-slider-left-grey.png" height="10px">
						</li>
					</c:when>
					<c:otherwise>
						<li><a class="page"
							href="ctgry_group=${ctgry_group}&ctgry_level=${ctgry_level}&ctgry_nm=${ctgry_nm}&category.mcat?cPage=${paging.beginBlock - 1}">
								<img src="resources/img/mcat-arrow-slider-left-grey.png"
								height="10px">
						</a></li>
					</c:otherwise>
				</c:choose>

				<%-- 블록안에 들어간 페이지번호들 --%>
				<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock}"
					step="1" var="i">
					<%-- 현재 페이지는 링크 비활성화, 나머지는 해당 페이지로 링크 --%>
					<c:choose>
						<c:when test="${i == paging.nowPage}">
							<li class="nowPage">${i}</li>
						</c:when>
						<c:otherwise>
							<li><a class="page"
								href="category.mcat?ctgry_group=${ctgry_group}&ctgry_level=${ctgry_level}&ctgry_nm=${ctgry_nm}&cPage=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<%-- 다음 --%>
				<c:choose>
					<c:when test="${paging.endBlock >= paging.totalPage}">
						<li class="pagingDisable"><img
							src="resources/img/mcat-arrow-slider-right-grey.png"
							height="10px"></li>
					</c:when>
					<c:otherwise>
						<li><a class="page"
							href="category.mcat?ctgry_group=${ctgry_group}&ctgry_level=${ctgry_level}&ctgry_nm=${ctgry_nm}&cPage=${paging.beginBlock + paging.pagePerBlock}">
								<img src="resources/img/mcat-arrow-slider-right-grey.png"
								height="10px">
						</a></li>
					</c:otherwise>
				</c:choose>
			</ol>
		</div>
	</section>

	<footer>
		<%-- <%@ include file="../foot.jsp" %> --%>
	</footer>
	<!--top 버튼 : 구버전-->
	<!-- <div class="top_button">
		<a href=""><img src="resources/img/top_button.png" alt=""></a>
	</div> -->
	<!-- 플로팅 메뉴 : 리모콘 - 구버전-->
	<%-- <div class="floating_remoteCon">
		<div class="remoteCon_name">최근 본 상품</div>
		<div>
			<c:if test="${cookie.viewedProductSq1 != null}">
				<a
					href="product.mcat?prduct_sq=${cookie.viewedProductSq1.value}&prduct_thumb_nm=${cookie.viewedProductThumb1.value}">
					<img src="resources/img/${cookie.viewedProductThumb1.value}" alt="">
				</a>
			</c:if>
		</div>
		<div>
			<c:if test="${cookie.viewedProductSq2 != null}">
				<a
					href="product.mcat?prduct_sq=${cookie.viewedProductSq2.value}&prduct_thumb_nm=${cookie.viewedProductThumb2.value}">
					<img src="resources/img/${cookie.viewedProductThumb2.value}" alt="">
				</a>
			</c:if>
		</div>
		<div>
			<c:if test="${cookie.viewedProductSq3 != null}">
				<a
					href="product.mcat?prduct_sq=${cookie.viewedProductSq3.value}&prduct_thumb_nm=${cookie.viewedProductThumb3.value}">
					<img src="resources/img/${cookie.viewedProductThumb3.value}" alt="">
				</a>
			</c:if>
		</div>
	</div> --%>

</body>

</html>
