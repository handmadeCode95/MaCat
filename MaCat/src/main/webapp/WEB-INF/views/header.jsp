<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>헤더</title>
    <link href="resources/img/mcat-favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link rel="stylesheet" href="resources/css/normalize.css">
    <link rel="stylesheet" href="resources/css/header.css">
    <script src="resources/js/jquery-3.4.1.min.js"></script>
    <script src="resources/js/macat.js"></script>
</head>

<body>
    <!-- header -->
    <header>
        <div class="menu">
            <div class="navWrap">
                <!--로고-->
                <h1><a href="main.mcat"><img src="resources/img/mcat-logo.png" alt="마캣로고"></a></h1>
                <div class="line"><span></span></div>
                <div class="searchWrap">
                    <!-- 검색 -->
                    <form action="#" method="get">
                        <button type="button">검색</button>
                        <div class="searchOn">
                            <a href="#" class="close">취소</a>
                            <input type="search" placeholder="검색어"> <button type="submit">검색하기</button>
                        </div>
                    </form>
                    <!-- /검색 -->
                    <!--로그인-->
                    <div class="pc">
                        <a href="login.mcat">로그인</a>
                        <a href="join.mcat">회원가입</a>
                    </div>
                </div>
                <!--searchWrap end-->
                <!--회원정보-->
                <div class="members">
                    <button type="button" class="membersBtn" onclick="location.href='mypage.mcat'">회원정보</button>
                </div>
                <!--장바구니-->
                <div class="basket">
                    <button type="button" class="basketBtn" onclick="location.href='cart.mcat'">장바구니</button>
                </div>
                <!--주메뉴-->
                <!--메뉴button-->
                <button type="button" class="navBtn mobile">
                    <span>menu</span>
                    <span></span>
                    <span></span>
                </button>
                <!--헤더 주메뉴는 보이지 않게 설정되어있음 > header nav display : none;-->
                <nav>
                    <h2 class="blind">주메뉴</h2>
                    <!--네비게이션 내부 전체-->
                    <div class="navInner clear">
                        <ul>
                            <li>
                                <!--class="open" 넣고 작업하기-->
                                <a href="#">베스트상품<span></span></a>
                                <!-- 베스트 상품 메뉴이너-->
                                <div class="wrap">
                                    <div class="wrapInner clear">
                                        <div class="wrapNav">
                                            <div class="left">
                                                <ol>
                                                    <li><a href="#">BEST</a></li>
                                                    <li><a href="#">PRODUCTS</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav left end-->
                                            <div class="right">
                                                <ol>
                                                    <li><a href="#">사료</a></li>
                                                    <li><a href="#">간식</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">장난감</a></li>
                                                    <li><a href="#">생활용품</a></li>
                                                    <li><a href="#">의류</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">위생/목욕</a></li>
                                                    <li><a href="#">화장실</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav right end-->
                                        </div>
                                        <!--wrapNav end-->
                                    </div>
                                </div>
                                <!--wrap end-->
                            </li><!-- 베스트상품 끝-->
                            <li>
                                <a href="#">신상품<span></span></a>
                                <!-- 신상품 메뉴이너-->
                                <div class="wrap">
                                    <div class="wrapInner clear">
                                        <div class="wrapNav">
                                            <div class="left">
                                                <ol>
                                                    <li><a href="#">NEW</a></li>
                                                    <li><a href="#">PRODUCTS</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav left end-->
                                            <div class="right">
                                                <ol>
                                                    <li><a href="#">사료</a></li>
                                                    <li><a href="#">간식</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">장난감</a></li>
                                                    <li><a href="#">생활용품</a></li>
                                                    <li><a href="#">의류</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">위생/목욕</a></li>
                                                    <li><a href="#">화장실</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav right end-->
                                        </div>
                                        <!--wrapNav end-->
                                    </div>
                                </div>
                            </li><!-- 신상품 끝-->
                            <li>
                                <a href="macatCoupon.html">마캣쿠폰<span></span></a>
                                <div class="wrap">
                                    <div class="wrapInner clear">
                                        <div class="wrapNav">
                                            <div class="left" id="coupLeft">
                                                <ol>
                                                    <li><a href="">마캣쿠폰</a></li>
                                                    <li><a href="">Coupon</a></li>
                                                </ol>
                                            </div>
                                            <div class="right" id="coupRight">
                                                <ol>
                                                    <li><a href="">바로가기</a></li>
                                                </ol>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- 마캣쿠폰 메뉴이너 없음, 바로가기-->
                            </li><!-- 마캣쿠폰 끝-->
                            <li>
                                <a href="#">무료배송상품<span></span></a>
                                <!-- 무료배송상품 메뉴이너-->
                                <div class="wrap">
                                    <div class="wrapInner clear">
                                        <div class="wrapNav">
                                            <div class="left">
                                                <ol>
                                                    <li><a href="#">FREE</a></li>
                                                    <li><a href="#">DELIVERY</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav left end-->
                                            <div class="right">
                                                <ol>
                                                    <li><a href="#">사료</a></li>
                                                    <li><a href="#">간식</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">장난감</a></li>
                                                    <li><a href="#">생활용품</a></li>
                                                    <li><a href="#">의류</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">위생/목욕</a></li>
                                                    <li><a href="#">화장실</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav right end-->
                                        </div>
                                        <!--wrapNav end-->
                                    </div>
                                </div>
                            </li><!-- 무료배송상품 끝-->
                            <li>
                                <a href="#">할인상품<span></span></a>
                                <!-- 할인상품 메뉴이너-->
                                <div class="wrap">
                                    <div class="wrapInner clear">
                                        <div class="wrapNav">
                                            <div class="left">
                                                <ol>
                                                    <li><a href="#">SALE</a></li>
                                                    <li><a href="#">PRODUCTS</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav left end-->
                                            <div class="right">
                                                <ol>
                                                    <li><a href="#">사료</a></li>
                                                    <li><a href="#">간식</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">장난감</a></li>
                                                    <li><a href="#">생활용품</a></li>
                                                    <li><a href="#">의류</a></li>
                                                </ol>
                                                <ol>
                                                    <li><a href="#">위생/목욕</a></li>
                                                    <li><a href="#">화장실</a></li>
                                                </ol>
                                            </div>
                                            <!--wrapNav right end-->
                                        </div>
                                        <!--wrapNav end-->
                                    </div>
                                </div>
                            </li><!-- 할인상품 끝-->
                            <li>
                                <a href="#">전체상품<span></span></a>
                                <div class="wrap">
                                    <div class="wrapInner clear">
                                        <div class="wrapNav">
                                            <div class="left" id="allLeft">
                                                <ol>
                                                    <li><a href="">전체상품</a></li>
                                                    <li><a href="">All</a></li>
                                                </ol>
                                            </div>
                                            <div class="right" id="allRight">
                                                <ol>
                                                    <li><a href="">바로가기</a></li>
                                                </ol>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li><!-- 전체상품 끝-->
                        </ul>
                        <!--주메뉴 ul end-->
                    </div>
                </nav>
                <!--메뉴end-->

            </div>
            <!--navWrap end-->
        </div>
        <!--navWrap end-->
        <!--슬라이딩 이미지 part html-->
        <!-- 비쥬얼 -->

        <!-- /비쥬얼 end -->
    </header>
    <!--header end-->
</body></html>