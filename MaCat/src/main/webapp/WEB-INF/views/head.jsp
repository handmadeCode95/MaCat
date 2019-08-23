<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0 shrink-to-fit=no">
		<link href="resources/img/mcat-favicon.ico" rel="shortcut icon" type="image/x-icon">
		<link rel="stylesheet" href="resources/css/normalize.css">
		<link rel="stylesheet" href="resources/css/head.css">
		<script src="resources/js/jquery-3.4.1.min.js"></script>
		<!--[if lte IE 8]>
		<script src="js/html5shiv.min.js"></script>
		<script src="js/respond.min.js"></script>
		<![endif]-->
		<title>MaCat</title>
	</head>
	
	<body>
	    <!-- header -->
	    <header>
	        <div class="menu">
	            <div class="navWrap">
	            <!--로고-->
	            <h1><a href="#"><img src="resources/img/mcat-logo-footer.png" alt="MaCat"></a></h1>
	            <div class="line"><span></span></div>
	
	            <!--메뉴button-->
	            <button type="button" class="navBtn mobile">
	                <span>menu</span>
	                <span></span>
	                <span></span>
	            </button>
	            <div class="searchWrap">
	                <!-- 검색 -->
	                <form action="#" method="get">
	                    <button type="button">검색</button>
	                    <div class="searchOn">
	                        <a href="#" class="close">취소</a>
	                        <input type="search" value="검색어"> <button type="submit">검색하기</button>
	                    </div>
	                </form>
	                <!-- /검색 -->
	                <!--로그인-->
	                <div class="pc">
	                    <a href="#">로그인</a>
	                    <a href="#">회원가입</a>
	                </div>
	            </div>
	            <!--searchWrap end-->
	            <!--회원정보-->
	            <div class="members">
	                <button type="button" class="membersBtn">회원정보</button>
	            </div>
	            <!--장바구니-->
	            <div class="basket">
	                <button type="button" class="basketBtn">장바구니</button>
	            </div>
	            <!--주메뉴-->
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
	                                                <li><a href="#">의류</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">캣타워</a></li>
	                                                <li><a href="#">생활</a></li>
	                                                <li><a href="#">장난감</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">위생/목욕/미용</a></li>
	                                                <li><a href="#">기타용품</a></li>
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
	                                                <li><a href="#">의류</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">캣타워</a></li>
	                                                <li><a href="#">생활</a></li>
	                                                <li><a href="#">장난감</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">위생/목욕/미용</a></li>
	                                                <li><a href="#">기타용품</a></li>
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
	                                                <li><a href="#">의류</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">캣타워</a></li>
	                                                <li><a href="#">생활</a></li>
	                                                <li><a href="#">장난감</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">위생/목욕/미용</a></li>
	                                                <li><a href="#">기타용품</a></li>
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
	                                                <li><a href="#">의류</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">캣타워</a></li>
	                                                <li><a href="#">생활</a></li>
	                                                <li><a href="#">장난감</a></li>
	                                            </ol>
	                                            <ol>
	                                                <li><a href="#">위생/목욕/미용</a></li>
	                                                <li><a href="#">기타용품</a></li>
	                                            </ol>
	                                        </div>
	                                        <!--wrapNav right end-->
	                                    </div>
	                                    <!--wrapNav end-->
	                                </div>
	                            </div>
	                        </li><!-- 할인상품 끝-->
	                        <li>
	                            <a href="category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">전체상품<span></span></a>
	                            <!-- 전체상품 메뉴이너 없음, 바로가기-->
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
	    </header>
	    <!--header end-->
	</body>
	
</html>