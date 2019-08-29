<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마캣 관리자 페이지</title>
    <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
    <!-- 초기화 -->
    <link rel="stylesheet" href="resources/css/normalize.css">
    <!-- 관리자페이지: 상세정보 입력페이지 css -->
    <link rel="stylesheet" href="resources/css/admin/product/admin_product_detail_info.css">
    
    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("li").each(function() {
                $(this).click(function() {
                    $(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용 $(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
                });
            });
        });
    </script>
    <!-- checkbox 전체선택 쿼리 -->
    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
</head>
<body>
    <!--관리자 페이지 사이드메뉴 불러오기-->
    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>  
   
    <main>
        <section class="wrap">
            <div class="member_management">
                <span>상세페이지 작성</span>
            </div>
            <div class="detail_text_area">
            	<p>상품제목출력파트</p>
            	<div id="border_item"></div>
            	<textarea name="" id=""></textarea>
            </div>
            <div class="submit_or_back_btn">
            	<img id="submit_btn" src="resources/img/mcat-submit-btn.png" alt="">
            	<img id="back_btn" src="resources/img/mcat-back-btn.png" alt="">
            </div>
        </section>        
    </main>
</body>
</html>
