<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(location).attr("href","main.mcat");
				// $(location).attr("href", "category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료");
				//$(location).attr("href", "product_reg.mcat");
			});
		</script>
	</head>

	<body>
		
	</body>

</html>
