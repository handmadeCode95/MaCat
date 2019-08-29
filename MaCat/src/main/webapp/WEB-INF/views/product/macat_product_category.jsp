<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <!-- normalize.css -->
    <link rel="stylesheet" href="resources/css/normalize.css">
    <!--상품 페이지용-->
    <link rel="stylesheet" href="resources/css/macat_product_category.css">    
    <!--여백-->
    <link rel="stylesheet" href="resources/css/spacing.css">

    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <!-- 고정헤더 불러오기 -->
    <script type="text/javascript">
        $(document).ready(function() {
            $("#macat_header").load("macat_header.html");
        });
        
        $(document).ready(function(){
            $(".remoteCon_load").load("macat_float_remoteCon.html");
        });
        
        $(document).ready(function(){
            $(".top_btn_load").load("macat_float_topBtn.html");
        });        
    </script>
</head>
<body>
    <!-- 고정헤더 불러오기 -->
    <div id="macat_header"></div>
    <!-- 여백-->
    <div class="spacing"></div>    
    <!-- 플로팅 메뉴 : 리모콘-->
    <div class="remoteCon_load"></div>
    <!--플로팅 메뉴 : top 버튼-->
    <div class="top_btn_load"></div>

    <section class="main_contents_section">
        <div class="best_item-title_img_container">
            <div class="title_container">
                <div class="title middle">
                    베스트 상품 <p>- 사료</p>
                </div>
                <div class="sub_category">
                    <a href="">자묘용</a> &nbsp; <a href="">성묘용</a> &nbsp;&nbsp; <a href="">노묘용</a> &nbsp;&nbsp; <a href="">전연령</a>
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
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="macat_product.html">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="macat_product.html">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="macat_product.html">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="macat_product.html">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>
                    <li id="category_product">
                        <div>
                            <!--상품 이미지 링크 -->
                            <div class="img_ratio_container">
                                <a href="">
                                   <img id="product_img" src="resources/img/macat_food01.png" alt="" style="display: block">
                                </a>
                            </div>
                            <!--상품명, 가격-->
                            <div class="title_price_container">
                              <!--상품명-->
                                <div class="product_title">
                                    <a href="">
                                        GO! 고우핏프리 그레인 프리! <br> (닭+칠면조+오리)
                                    </a>
                                </div>
                                <!--가격-->
                                <div class="price">
                                    <div class="like_btn">
                                        <a href=""><img src="resources/img/like_btn.png" alt=""></a>
                                    </div>
                                    <p>3.6kg | 58,000원</p>
                                <!--가격 위치조절용 div-->
                                <div class="space"></div>
                                </div>
                            </div>
                            <!--찜 a 태그-->
                           <!-- <div class="like_btn">
                                <a href=""><img src="../img/like_btn.png" alt=""></a>
                            </div>-->
                        </div>
                    </li>           
                </ul>
            </div>
        </div>
    </section>

    <footer>
        footer 파트
    </footer>    
</body></html>
