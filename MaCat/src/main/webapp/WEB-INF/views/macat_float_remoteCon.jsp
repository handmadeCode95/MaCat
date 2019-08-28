<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/css/macat_float_remoteCon.css">
	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	<title>리모콘</title>
	<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
</head>

<body>
	<div class="floating_remoteCon">
		<div class="remoteCon_name">최근 본 상품</div>
		<div>
			<c:if test="${!empty cookie.viewedProductSq1}">
				<a
					href="product.mcat?prduct_sq=${cookie.viewedProductSq1.value}&prduct_thumb_nm=${cookie.viewedProductThumb1.value}">
					<img src="resources/img/${cookie.viewedProductThumb1.value}" alt="">
				</a>
			</c:if>
		</div>
		<div>
			<c:if test="${!empty cookie.viewedProductSq2}">
				<a
					href="product.mcat?prduct_sq=${cookie.viewedProductSq2.value}&prduct_thumb_nm=${cookie.viewedProductThumb2.value}">
					<img src="resources/img/${cookie.viewedProductThumb2.value}" alt="">
				</a>
			</c:if>
		</div>
		<div>
			<c:if test="${!empty cookie.viewedProductSq3}">
				<a
					href="product.mcat?prduct_sq=${cookie.viewedProductSq3.value}&prduct_thumb_nm=${cookie.viewedProductThumb3.value}">
					<img src="resources/img/${cookie.viewedProductThumb3.value}" alt="">
				</a>
			</c:if>
		</div>
	</div>
</body>
</html>