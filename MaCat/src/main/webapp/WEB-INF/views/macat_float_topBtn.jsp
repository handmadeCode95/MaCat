<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    
    <link rel="stylesheet" href="resources/css/top_button.css">
    
    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<!--  추가구현 필요내용 : 사용자 해상도가 달라져도 같은 위치에 있도록  -->
    <script type="text/javascript">
    // 일정 길이 이상 스크롤 다운할 때 top버튼 나타남    
    $(function(document){
        $(window).scroll( function() {
            if ($(this).scrollTop() > 200) {
                $('.top').fadeIn();
            } else {
                $('.top').fadeOut();
            }
        });        
     // 맨위로 이동하는 속도 조절
        $('.top').click(function() {
            $('html, body').animate({
                scrollTop : 0 }, 400 );
            return false;
        });       
    });
    </script>
</head>
<body>    
    <div class="top_button">
        <a href="#" class="top">
            <img src="resources/img/top_button.png" alt="top_button">
        </a>
    </div>
</body>
</html>