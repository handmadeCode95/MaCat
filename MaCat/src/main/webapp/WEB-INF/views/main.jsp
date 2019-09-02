<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<!--미니 로고-->
	<link href="resources/img/mcat-favicon.ico" rel="shortcut icon" type="image/x-icon">
	<!--초기화-->
	<link rel="stylesheet" href="resources/css/normalize.css">
	<!--메인페이지 css-->
	<link rel="stylesheet" href="resources/css/macat.css">
	<!--헤더 css-->
	<link rel="stylesheet" href="resources/css/header.css">
	<!--Footer css-->
	<link rel="stylesheet" href="resources/css/footer.css">	
	<!-- min 파일 -->
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
        <div id="header_load"> <%@ include file="header.jsp" %> </div>
        <!--navWrap end-->
        <!--슬라이딩 이미지 part html-->
        <!-- 비쥬얼 -->
        <div id="carousel_section">
            <ul class="visual">
                <li><a href="#">
                <img src="resources/img/mcat-visual-bg.png" alt="배너1"></a></li>
                <li><a href="#">
                <img src="resources/img/mcat-visual-cattunnel.png" alt="배너2"></a></li>
                <li><a href="#">
                <img src="resources/img/mcat-visual-catball.png" alt="배너3"></a></li>
                <li><a href="#">
                <img src="resources/img/mcat-visual-bg.png" alt="배너1"></a></li>
            </ul>
        </div>
        <!-- /비쥬얼 end -->
    </header>
    <!--header end-->
    
    <!-- .main -->
    <div class="main">
        <main>
            <section class="best">
                <h2>베스트상품</h2>
                <div class="bestInner clear">
                    <div class="slideshow">
                        <a href="#">
                            <div class="prodImg">
                                <img src="resources/img/mcat-best-item-01.png" alt="캣트리">
                            </div>
                            <div class="prodInfo">
                                <b>CAT TOWER</b>
                                <h5>가또블랑코 내츄럴 파인 캣트리</h5>
                                <p>240,000</p>
                            </div>
                        </a>
                    </div>
                    <div class="slideshow">
                        <a href="#">
                            <div class="prodImg">
                            <img src="resources/img/mcat-best-item-02.jpg" alt="사료">
                            </div>
                            <div class="prodInfo">
                            <b>CAT FEED</b>
                            <h5>GO! 고우 핏프리 그레인프리 </h5>
                            <p>58,000</p>
                            </div>
                        </a>    
                    </div>
                    <div class="slideshow">
                        <a href="#">
                            <div class="prodImg">
                            <img src="resources/img/mcat-best-item-03.jpg" alt="사료">
                            </div>
                            <div class="prodInfo">
                            <b>CAT FEED</b>
                            <h5>K9 내츄럴 캣 냉동건조사료</h5>
                            <p>28,000</p>
                            </div>
                        </a>
                    </div>
                    <div class="slideshow">
                        <a href="#">
                            <div class="prodImg">
                            <img src="resources/img/mcat-best-item-01.png" alt="캣트리">
                            </div>
                            <div class="prodInfo">
                            <b>CAT TOWER</b>
                            <h5>가또블랑코 내츄럴 파인 캣트리</h5>
                            <p>240,000</p>
                            </div>
                        </a>
                    </div>
                </div>
            </section>
            
            <section class="new">
                <h2>신상품</h2>
                <div class="newInner clear">
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="newImg">
                            <img src="resources/img/mcat-new-item01.jpg" alt="양모볼"></div>
                            <div class="newInfo">
                            <h5>힐링타임 빅 양모볼(젤리발바닥)</h5>
                            <p>4,000</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="newImg">
                            <img src="resources/img/mcat-new-item02.jpg" alt="캣터널"></div>
                            <div class="newInfo">
                            <h5>힐링타임 런던 캣터널</h5>
                            <p>23,000</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="newImg">
                            <img src="resources/img/mcat-new-item03.jpg" alt="캣타워"></div>
                            <div class="newInfo">
                            <h5>프리미엄 대형 직조캣타워</h5>
                            <p>85,000</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="newImg">
                            <img src="resources/img/mcat-new-item04.jpg" alt="사료"></div>
                            <div class="newInfo">
                            <h5>퓨리나 프로플랜 옵티뉴트리션</h5>
                            <p>32,000</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="newImg">
                            <img src="resources/img/mcat-new-item01.jpg" alt="양모볼"></div>
                            <div class="newInfo">
                            <h5>힐링타임 빅 양모볼(핑크 젤리발바닥)</h5>
                            <p>4,000</p>
                            </div>
                        </a>
                    </div>
                </div>
            </section>
            
            <section class="sale">
                <h2>금주 할인 상품</h2>
                <div class="saleInner clear">
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="saleImg">
                            <img src="resources/img/mcat-sale-item01.jpg" alt="케이지볼"></div>
                            <div class="saleInfo">
                            <h5>쥬쥬베 쥐돌이 케이지볼</h5>
                            <p><span></span>8,000-6,450</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="saleImg">
                            <img src="resources/img/mcat-sale-item02.jpg" alt="화장실"></div>
                            <div class="saleInfo">
                            <h5>탑도어 고양이 화장실</h5>
                            <p><span></span>30,000-24,000</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="saleImg">
                            <img src="resources/img/mcat-sale-item03.jpg" alt="캐리어"></div>
                            <div class="saleInfo">
                            <h5>블루앙쿼 펫 캐리어</h5>
                            <p><span></span>24,000-21,000</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="saleImg">
                            <img src="resources/img/mcat-sale-item04.jpg" alt="스크래쳐"></div>
                            <div class="saleInfo">
                            <h5>파이오니아 얼티메이트 스크래쳐 </h5>
                            <p><span></span>80,000-72,000</p>
                            </div>
                        </a>
                    </div>
                    <div>
                        <a href="main/category.mcat?ctgry_group=1&ctgry_level=0&ctgry_nm=사료">
                           <div class="saleImg">
                            <img src="resources/img/mcat-sale-item01.jpg" alt="케이지볼"></div>
                            <div class="saleInfo">
                            <h5>쥬쥬베 쥐돌이 케이지볼</h5>
                            <p>8,000-6,450</p>
                            </div>
                        </a>
                    </div>
                </div>
            </section>
        </main>
    </div>
    <!-- /.main -->    
    <!-- footer -->
    <footer>
        <div id="footer_load"> <%@ include file="footer.jsp" %> </div>
    </footer>
    <!-- /footer -->
</body>
</html>