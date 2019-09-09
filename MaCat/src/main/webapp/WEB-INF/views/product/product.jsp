<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>마캣 상품</title>
	    <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
	    <!--초기화-->
	    <link rel="stylesheet" href="resources/css/normalize.css">
	    <link rel="stylesheet" href="resources/css/spacing.css">
	    <!--탭메뉴 css-->
	    <link rel="stylesheet" href="resources/css/product/tab_menu.css">
	    <!--상품 상세페이지-->
	    <link rel="stylesheet" href="resources/css/product/macat_product.css">
	    <link rel="stylesheet" href="resources/css/product/macat_product_category_infoTable.css">
	    
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script type="text/javascript" src="resources/js/product/product.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){			
			$('img.t1').hide();
			$('img.t1').first().show();	
			$('img.t1').css('width', 400);
				setInterval(function(){
					$('div.main_img').append($('img.t1').first());
					$('img.t1').last().hide();
					$('img.t1').first().show();
					}, 2000);
			});
	</script>
	    
	</head>
	
	<body>
	    <!-- 고정헤더 불러오기 -->
	    <div id="macat_header"><%@ include file="../header.jsp" %></div>
	    <!-- 여백-->
	    <div class="spacing"></div>
	
	    <section id="wrap">
	        <div class="product_img_info">
	            <!---->
	            <div class="img_part">
	                <div class="main_img">
	                    <c:forEach var="i" items="${imagesDTO}" varStatus="vs">
	                        <c:if test="${i.img_thumb_fl < 1}">
	                        	<c:choose>
	                        		<c:when test="${i.img_main_fl > 0}">
	                        			<img class="t1" src="resources/img/${i.img_nm}" alt="상품이미지${vs.count}">
		                        	</c:when>
		                        	<c:otherwise>
		                        		<img class="t1" src="resources/img/${i.img_nm}" alt="상품이미지${vs.count}">	
		                        	</c:otherwise>
	                        	</c:choose>
	                    	</c:if>
	                    </c:forEach>
	                </div>
	                <!--왼쪽 : 이미지 파트-->
	                <div class="img_choice">
	                 	<img src="resources/img/mcat-arrow-slider-left-grey.png" class="back" >
	                    <div class="slide_choice bxslider">
	                        <c:forEach var="i" items="${imagesDTO}" varStatus="vs">
	                        	<c:if test="${i.img_thumb_fl > 0}">
	                        		<img src="resources/img/${i.img_nm}" alt="썸네일${vs.count}" style="cursor: pointer;">
	                        	</c:if>
	                        </c:forEach>	                        
	                    </div>
	                     <img src="resources/img/mcat-arrow-slider-right-grey.png" class="next" >
	                </div>
	            </div>
	            <!--오른쪽 정보 파트-->
	            <div class="info_part">
	                <div class="product_title">
	                    <div class="product_name">
	                        <ul>
	                            <li>
	                                <p>${productsDTO.prduct_nm}</p>
	                                <span>
	                                	<c:forEach var="i" begin="2" end="${productsDTO.prduct_rating_round}" step="2">
											<img src="resources/img/mcat-whole-star.png" alt="★">
										</c:forEach>
										<c:if test="${productsDTO.prduct_rating_round % 2 eq 1}">
											<img src="resources/img/mcat-half-star.png" alt="☆">
										</c:if>
									</span>
	                            </li>
	                        </ul>
	                    </div>
	                    <div class="category_directory-review_count">
	                        <ul>
	                            <li>
	                            	<c:forEach var="i" items="${sessionScope.ctgriesDTO}">
										<c:if test="${i.ctgry_group eq productsDTO.prduct_ctgry_group && i.ctgry_level eq 0}">
											<p id="directory1">${i.ctgry_nm} ></p>
										</c:if>
									</c:forEach>
	                                <p id="directory2">${productsDTO.ctgry_nm}</p>
	                            </li>
	                            <li>
	                                <p id="review_count">상품평 : ${review_cnt}개</p>
	                            </li>
	                        </ul>
	                    </div>
	                </div>
	                <!--상품가격 파트-->
	                <div class="product_price_container">
	                    <ul>
	                        <li>
	                            <p class="title">상품가격</p>
	                            <c:choose>
	                            	<c:when test="${productsDTO.prduct_price > productsDTO.prduct_dced_price}">
	                            		<p class="info discount">
	                            			<fmt:formatNumber value="${productsDTO.prduct_price}" pattern="#,###"></fmt:formatNumber>
	                            			<img src="resources/img/mcat_discount_price_arrow.png" alt="">
	                            		</p>
	                           			<p class="discounted_info">
	                           				<fmt:formatNumber value="${productsDTO.prduct_dced_price}" pattern="#,###"></fmt:formatNumber>
	                           			</p>
	                            	</c:when>
	                            	<c:otherwise>
	                            		<p class="info">
	                            			<fmt:formatNumber value="${productsDTO.prduct_price}" pattern="#,###"></fmt:formatNumber>
	                            		</p>
	                            	</c:otherwise>
	                            </c:choose>
	                        </li>
	                        <li>
	                            <p class="title">상품코드</p>
	                            <p class="info">${productsDTO.prduct_sq}</p>
	                        </li>
	                    </ul>
	                </div>
	                <!--배송, 적립 파트-->
	                <div class="delivery_point_container">
	                    <div class="align_container">
	                        <ul class="delivery">
	                            <li>
	                                <p class="title_left">배송비</p>
	                            </li>
	                            <li>
	                                <p class="price"><fmt:formatNumber value="${productsDTO.prduct_dlvy_price}" pattern="#,###"></fmt:formatNumber></p>
	                            </li>
	                            <li>
	                                <p class="title_left">포인트 적립</p>
	                            </li>
	                            <li>
	                                <p class="point"><fmt:formatNumber value="${productsDTO.prduct_point}" pattern="#,###"></fmt:formatNumber> p</p>
	                            </li>
	                        </ul>
	                        <ul class="point_select">
	                            <li>
	                                <p class="title_right">주문수량</p>
	                            </li>
	                            <li>
	                                <p class="product_count_box">
										<select name="수량선택" id="amount">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>
									</p>
	                            </li>
	                            <li>
	                                <p class="title_right">컬러</p>
	                            </li>
	                            <li>
	                                <p class="color_choice_box">
	                                    <select name="색상선택" id="color">
	                                    	<option value="0">color</option>
	                                    	<c:forEach var="i" items="${productsDTO.colors}">
	                                    		 <option value="${i}">${i}</option>
	                                    	</c:forEach>
	                                    </select>
	                                </p>
	                            </li>
	                        </ul>
	                    </div>
	                </div>
	                <!--총가격 파트-->
	                <div class="total_price">
	                    <p>총 
	                    	<span><fmt:formatNumber value="${productsDTO.prduct_dced_price + productsDTO.prduct_dlvy_price}" pattern="#,###"></fmt:formatNumber> 원</span>
	                    </p>
	                </div>
	                <!--찜리스트 장바구니 바로구매 버튼 파트-->
	                <div class="btn_container">
	                    <ul>
	                        <!-- 찜리스트 추가 & 추가성공 alert 창만 출력-->
	                        <a href="javascript:alert('준비 중인 서비스입니다.\n이용에 불편을 드려 죄송합니다.')">
	                            <li class="like_btn">
	                                <img src="resources/img/mcat_heart_shape.png" alt="">
	                            </li>
	                        </a>
	                    </ul>
	                    <ul>
	                        <!-- 장바구니에 추가하시겠습니까 ask : 확인 = 추가되었습니다 / 취소 = 상품상세페이지-->
	                        <c:choose>
	                        	<c:when test="${empty sessionScope.loginData.mber_sq}">
		                        	<a href="javascript:setCookie(${productsDTO.prduct_sq},	'${productsDTO.ctgry_nm}', ${productsDTO.prduct_price}, ${productsDTO.prduct_dlvy_price}, '${productsDTO.prduct_nm}', '${productsDTO.prduct_thumb_nm}', ${productsDTO.prduct_dc}, ${productsDTO.prduct_dc_pt}, ${productsDTO.prduct_dced_price}, 'cart', 1);">

		                            	<li class="cart">
		                                	<img src="resources/img/mcat_cart.png" alt="">
		                            	</li>
		                        	</a>
		                        </c:when>
		                        <c:otherwise>
		                        	<a href="javascript:isOverlap(${productsDTO.prduct_sq}, ${sessionScope.loginData.mber_sq})">
			                            <li class="cart">
			                                <img src="resources/img/mcat_cart.png" alt="">
			                            </li>
			                        </a>
		                        </c:otherwise>
	                        </c:choose>
	                    </ul>
	                    <ul>
	                        <!-- 구매하기 : 결제 페이지로 이동 -->
	                        <a href="javascript:isLogin(${!empty sessionScope.loginData.mber_sq}, 'order.mcat')">
	                            <li class="buying">
	                                <img src="resources/img/mcat_buying.png" alt="">
	                            </li>
	                        </a>
	                    </ul>
	                </div>
	            </div>
	        </div>
	
	        <!--탭 메뉴 파트-->
	        <div class="product_tab_container-tabmenu" id="item_list">
	            <div class="tab" id="item_tab">
	                <ul class="tab-titles" id="tab-titles">
	                    <li class="current" data-tab-titles="tab1">
	                        <a href="#Redirect">상품상세</a>
	                    </li>
	                    <li data-tab-titles="tab2">
	                        <a href="#Redirect">상품리뷰</a> </li>
	                    <li data-tab-titles="tab3">
	                        <a href="#Redirect">상품문의</a> </li>
	                    <li data-tab-titles="tab4">
	                        <a href="#Redirect">배송정보</a> </li>
	                </ul>
	
	                <!--각 메뉴탭별로 다른 페이지를 구현할 것임-->
	                <div id="tab1" class="tabcontent current">
	                    ${productsDTO.prduct_cn}
	                </div>
	                <div id="tab2" class="tabcontent">
	                    상품리뷰 페이지입니다
	                    <img src="resources/img/boy.png">
	                    <img src="resources/img/coffe.png">
	                    <img src="resources/img/dog.png">
	                </div>
	                <div id="tab3" class="tabcontent">
	                    상품문의 페이지입니다
	                    <img src="resources/img/boy.png">
	                    <img src="resources/img/coffe.png">
	                    <img src="resources/img/dog.png">
	                </div>
	                <div id="tab4" class="tabcontent">
	                    배송정보 페이지입니다
	                    <img src="resources/img/boy.png">
	                    <img src="resources/img/coffe.png">
	                    <img src="resources/img/dog.png">
	                </div>
	            </div>
	        </div>
	        <!--관련상품 파트-->
	        <div class="related_products">
	            <p>관련상품</p>
	            <div class="container">
	                <!-- 각 이미지에 해당되는 상품상세페이지로 이동-->
	                <div class="related_product_slide">
	                	<c:forEach var="i" items="${more_product}">
		                	<a href="product.mcat?prduct_sq=${i.prduct_sq}&prduct_thumb_nm=${i.prduct_thumb_nm}">
		                		<img src="resources/img/${i.prduct_thumb_nm}" alt="">
		                	</a>
	                	</c:forEach>
	                </div>
	                <!-- 더보기 : 현재 위치한 상품상세페이지의 상품 카테고리 페이지로 이동시킴-->
	                <c:forEach var="i" items="${sessionScope.ctgriesDTO}">
						<c:if test="${i.ctgry_nm eq productsDTO.ctgry_nm}">
							<a href="category.mcat?ctgry_group=${i.ctgry_group}&ctgry_level=${i.ctgry_level}&ctgry_nm=${i.ctgry_nm}">
								<input id="details" type="button" value="더보기">
	                		</a>
						</c:if>
					</c:forEach>
	            </div>
	        </div>
	        <!--상품정보 파트-->
	        <div class="product_info_table">
	            <div class="table_title_for_products">
	                <span>상품정보</span>
	            </div>
	            <table class="type01">
	                <tr>
	                    <th scope="row">상품명</th>
	                    <td>${productsDTO.prduct_nm}</td>
	                </tr>
	                <tr>
	                    <th scope="row">제조사</th>
	                    <td>${productsDTO.prduct_maker}</td>
	                </tr>
	                <tr>
	                    <th scope="row">소재</th>
	                    <td>${productsDTO.prduct_matr}</td>
	                </tr>
	                <tr>
	                    <th scope="row">색상</th>
	                    <td>
	                    	<c:forEach var="i" items="${productsDTO.colors}" varStatus="vs">
	                        	${i}<c:if test="${!vs.last}">, </c:if> 
	                        </c:forEach>
	                    </td>
	                </tr>
	                <tr>
	                    <th scope="row">사이즈</th>
	                    <td>${productsDTO.prduct_size}</td>
	                </tr>
	                <tr>
	                    <th scope="row">제조일자</th>
	                    <td>${productsDTO.prduct_dom_dt.substring(0, 10)}</td>
	                </tr>
	                <tr>
	                    <th scope="row">품질보증기준</th>
	                    <td>${productsDTO.prduct_qa}</td>
	                </tr>
	                <tr>
	                    <th scope="row">AS상담번호</th>
	                    <td>${productsDTO.prduct_as}</td>
	                </tr>
	            </table>
	        </div>
	    </section>
	    
	    <footer><%@ include file ="../footer.jsp" %>
	    </footer>
	</body>

</html>
