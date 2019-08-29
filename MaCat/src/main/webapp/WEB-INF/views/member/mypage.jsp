<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>마캣 마이페이지</title>
    <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
    <!--여백-->
    <link rel="stylesheet" href="resources/css/spacing.css">
    <!-- macat_mypage_2nd.css-->
    <link rel="stylesheet" href="resources/css/member/macat_mypage.css">
    <!--초기화-->
    <link rel="stylesheet" href="resources/css/normalize.css">

    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
</head>

<body>
    <!-- 고정헤더 불러오기 -->
	<div id="macat_header">
		<%@ include file="../header.jsp"%>
	</div>
    <!-- 여백-->
    <div class="spacing"></div>

    <section id="wrap">
        <div class="mypage_title">
           <!--마이페이지 제목-->
            <div>
                <h2>MY PAGE</h2>
                <p>마이페이지</p>
            </div>
            <!--적립금 내역들-->
            <ul>
                <li>
                   <strong class="title">가용적립금</strong>
                   <strong class="data">0 point</strong>                    
                </li>
                <li>
                   <strong class="title">총 적립금</strong>
                   <strong class="data">0 point</strong>                    
                </li>
                <li>
                   <strong class="title">사용적립금</strong>
                   <strong class="data">0 point</strong>                    
                </li>
                <li>
                   <strong class="title">총 주문</strong>
                   <strong class="data">0 point</strong>                    
                </li>
            </ul>
        </div>
        <!--주문 처리상황-->
        <!-- 각 부분의 숫자를 누르면 주문내역조회로 넘어감 -->
        <div class="orderstate">
           <!-- 제목 -->
            <div class="title">
                <h3>나의 주문처리 현황</h3>
                <span class="desc">
                    (최근 <em>3개월</em> 기준)
                </span>
            </div>
            <!-- 처리 상태 파트 -->
            <div class="state">
               <!--주문 4가지 상태 : 입금전, 배송준비, 배송중, 배송완료 >> 주문상태 페이지로 통일됨-->
                <ul class="order">
                    <li>
                        <strong>입금전</strong>
                        <a href="" class="count">0</a>
                    </li>
                    <li>
                        <strong>배송준비중</strong>
                        <a href="" class="count">0</a>
                    </li>
                    <li>
                        <strong>배송중</strong>
                        <a href="" class="count">0</a>
                    </li>
                    <li>
                        <strong>배송완료</strong>
                        <a href="" class="count">0</a>
                    </li>
                </ul>
                <!-- 여기도 숫자는 주문조회 페이지로 이동시킴-->
                <ul class="cs">
                    <li><p class="icoDot"></p>
                    <strong>취소 : </strong>
                    <a href="" class="count"><span>0</span></a>
                    </li>
                    <li><p class="icoDot"></p>
                    <strong>교환 : </strong>
                    <a href="" class="count"><span>0</span></a>
                    </li>
                    <li><p class="icoDot"></p>
                    <strong>반품 : </strong>
                    <a href="" class="count"><span>0</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!--기능페이지 이동 모음 : 주문내역조회, 회원정보, 찜리스트, 적립금, 게시물관리, 배송주소록 관리-->
        <!--마우스 오버시 남아있는 이미지 여백 투명하게..-->
        <div id="myshopMain">
            <ul>
                <a href="mypage_order_inquiry.mcat">
                    <li class="icon_li">                        
                        <img src="resources/img/schedule_icon.png" alt="주문내역_페이지">
                    </li>
                    <li>order<p>주문내역 조회</p></li>
                </a>
            </ul>
            <ul>
                <a href="">
                    <li class="icon_li">
                        <img src="resources/img/memberInfo_icon.png" alt="회원정보_페이지">
                    </li>
                    <li>profile<p>회원 정보</p></li>
                </a>    
            </ul>
            <ul>
                <a href="mypage_wishlist.mcat">
                    <li class="icon_li">
                        <img src="resources/img/wishList_icon.png" alt="찜_리스트_페이지">
                    </li>
                    <li>wish list<p>관심 상품</p></li>
                </a>
            </ul>
            <ul>
                <a href="">
                    <li class="icon_li">
                        <img src="resources/img/mileage_icon.png" alt="적립금확인_페이지">
                    </li>
                    <li>mileage<p>적립금</p></li>
                </a>
            </ul>
            <ul>
                <a href="mypage_post_management.mcat">
                    <li class="icon_li">
                        <img src="resources/img/board_icon.png" alt="게시물관리_페이지">
                    </li>
                    <li>board<p>게시물 관리</p></li>
                </a>
            </ul>
            <ul>
                <a href="mypage_deliveryAdress.mcat">
                    <li class="icon_li">
                        <img src="resources/img/schedule_icon.png" alt="배송주소록_페이지">
                    </li>
                    <li>address<p>배송 주소록 관리</p></li>
                </a>
            </ul>
            
        </div>

    </section>
    
    <footer><%@ include file="../footer.jsp" %></footer>


</body></html>