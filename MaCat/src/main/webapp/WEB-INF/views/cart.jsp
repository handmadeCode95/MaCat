<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
    <!--normalize-->
    <link rel="stylesheet" href="resources/css/normalize.css">
    <!--장바구니 css-->
    <link rel="stylesheet" href="resources/css/cart.css">
    <!--여백-->
    <link rel="stylesheet" href="resources/css/spacing.css">
    <!--체크박스 모양-->
    <link rel="stylesheet" href="resources/css/checkbox.css">
            
    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
 	<!-- 체크박스 전체선택 -->
    <script type="text/javascript" src="resources/js/cart.js"></script>
</head>
	<body>
	    <div id="macat_header"><%@ include file="header.jsp" %></div>
	    <!-- 여백-->
	    <div class="cart_spacing"></div>
	    
	    <section id="wrap">
	        <div class="shoppingCart_title">
	            <span>CART</span>
	        </div>
	        
	        <div class="cart_list">
	            <table class="cart_list_main">
	                <caption>게시판 목록</caption>
	                <colgroup>
	                    <col style="width:43px;">
	                    <col style="width:170px;">
	                    <col style="width:auto;">
	                    <col style="width:85px;">
	                    <col style="width:85px;">
	                    <col style="width:85px;">
	                    <col style="width:85px;">
	                </colgroup>
	                <thead>
	                    <tr>
	                        <th scope="col">
	                            <input type="checkbox" id="cart_allCheck" checked>
	                            <label for="cart_allCheck"></label>
	                        </th>
	                        <th scope="col"><span>상품이미지</span></th>
	                        <th scope="col">상품명</th>
	                        <th scope="col">색상</th>
	                        <th scope="col">수량</th>
	                        <th scope="col">금액</th>
	                        <th scope="col">배송비</th>
	                    </tr>
	                </thead>
	                <tbody id="cart_result" class="cart_tbody">
	                	<c:choose>
	                		<c:when test="${!empty cartsDTO}">
		                		<c:forEach var="i" items="${cartsDTO}" varStatus="vs">
				                    <tr>
				                    	<!-- 체크박스 -->
				                        <td>
					                        <input name="carts" class="chkbox" type="checkbox" id="${vs.count}" value="${vs.count}"><label for="${vs.count}"></label>
					                        <input type="hidden" name="prduct_sq" class="${vs.count}" value="${i.prduct_sq}" disabled>
					                        <input type="hidden" name="cart_color" class="${vs.count}" value="${i.cart_color}" disabled>					                           
					                        <input type="hidden" name="prduct_price" class="${vs.count}" value="${i.prduct_price}" disabled>
					                        <input type="hidden" name="prduct_dlvy_price" class="${vs.count}" value="${i.prduct_dlvy_price}" disabled>
					                        <input type="hidden" name="prduct_dced_price" class="${vs.count}" value="${i.prduct_dced_price}" disabled>
					                        <input type="hidden" name="prduct_dc_pt" class="${vs.count}" value="${i.prduct_dc_pt}" disabled>
					                        <input type="hidden" name="prduct_dc" class="${vs.count}" value="${i.prduct_dc}" disabled>
				                        </td>
				                        <!-- 이미지 -->
				                        <td><img src="resources/img/${i.prduct_thumb_nm}" alt=""></td>
				                        <!-- 상품명 -->
				                        <td>
					                        <div class="category_box">${i.ctgry_nm}</div>
					                            <a href="macat_product.html">${i.prduct_nm}</a>
				                        </td>
				                        <!-- 색상 -->
				                        <td>${i.cart_color}</td>
				                        <!-- 수량 -->
				                        <td>
				                        <!--수량 증가/감소 쿼리-->	
				                          <fmt:formatNumber value="${i.cart_amt}" pattern="#,###"  />			                        	
				                        </td>
				                        <!-- 금액 -->
				                        <td id="cart_product_price">
				                        	<fmt:formatNumber value="${i.prduct_dced_price}" pattern="#,###"/>
			                        	</td>
				                        <!-- 배송비 -->
				                        <td id="cart_delivery_pay">
				                        	<fmt:formatNumber value="${i.prduct_dlvy_price}" pattern="#,###" />
				                        </td>
				                    </tr>
			                    </c:forEach>
		                    </c:when>
			                <c:otherwise>
			                    <tr>
			                        <td colspan="7">장바구니가 비었습니다.</td>
			                    </tr>
		                    </c:otherwise>
	                	</c:choose>
	                </tbody>			
	            </table>
	        </div>
			<div class="cart-order_del_wishList_box">
				<div>선택상품주문</div>
				<div>선택상품삭제</div>
				<div>위시리스트</div>
			</div>
		
			<script type="text/javascript">
			$(document).ready(function(){
			    $('.__count_range input[count_range]').click(function(e){
			        e.preventDefault();
			        var type = $(this).attr('count_range');
			        var $count = $(this).parent().children('input.count[value]');
			        var count_val = $count.val(); // min 1
			        if(type=='m'){
			            if(count_val<1){
			                return;
			            }
			            $count.val(parseInt(count_val)-1);
			        }else if(type=='p'){
			            $count.val(parseInt(count_val)+1);
			        }
			    });
			});
			</script>
			<!-- 
			<script type="text/javascript">
				jQuery(document).ready(function(){
				    // This button will increment the value
				    $('.qtyplus').click(function(e){
				        // Stop acting like a button
				        e.preventDefault();
				        // Get the field name
				        fieldName = $(this).attr('field');
				        // Get its current value
				        var currentVal = parseInt($('input[name='+fieldName+']').val());
				        // If is not undefined
				        if (!isNaN(currentVal)) {
				            // Increment
				            $('input[name='+fieldName+']').val(currentVal + 1);
				        } else {
				            // Otherwise put a 0 there
				            $('input[name='+fieldName+']').val(0);
				        }
				    });
				    
				    // This button will decrement the value till 0
				    $(".qtyminus").click(function(e) {
				        // Stop acting like a button
				        e.preventDefault();
				        // Get the field name
				        fieldName = $(this).attr('field');
				        // Get its current value
				        var currentVal = parseInt($('input[name='+fieldName+']').val());
				        // If it isn't undefined or its greater than 0
				        if (!isNaN(currentVal) && currentVal > 0) {
				            // Decrement one
				            $('input[name='+fieldName+']').val(currentVal - 1);
				        } else {
				            // Otherwise put a 0 there
				            $('input[name='+fieldName+']').val(0);
				        }
				    });				    
				});
			</script> -->
		<!--합계 테이블-->
	        <div class="cart_total_price">
	            <table class="price_result">
	            	<c:choose>
	            		<c:when test="${!empty totalPrice}">
	            			<tr>
			                    <th>장바구니 합계</th>
			                    <td><fmt:formatNumber value="${totalPrice}" pattern="#,###"></fmt:formatNumber>원</td>                   
			                </tr>
			                <tr>
			                    <th>배송비</th>
			                    <td><fmt:formatNumber value="${mostDlvyPrice}" pattern="#,###"></fmt:formatNumber>원</td>                   
			                </tr>
			                <tr>
			                    <th>할인금액</th>
			                    <td><fmt:formatNumber value="${totalDC}" pattern="#,###"></fmt:formatNumber>원</td>                   
			                </tr>  
			                <tr>
			                    <th>총 결제금액</th>
			                    <td><fmt:formatNumber value="${totalPrice - totalDC + mostDlvyPrice}" pattern="#,###"></fmt:formatNumber>원</td>                   
			                </tr>
	            		</c:when>
	            		<c:otherwise>
	            			<tr>
			                    <th>장바구니 합계</th>
			                    <td>0원</td>                   
			                </tr>
			                <tr>
			                    <th>배송비</th>
			                    <td>0원</td>                   
			                </tr>
			                <tr>
			                    <th>할인금액</th>
			                    <td>0원</td>                   
			                </tr>  
			                <tr>
			                    <th>총 결제금액</th>
			                    <td>0원</td>                   
			                </tr>  
	            		</c:otherwise>
	            	</c:choose>
	            </table>            
	        </div>
	        
	        <div class="cart_btn_container">
	            <input class="shopping_go" type="button" value="쇼핑계속하기" src="macat_product_category.html"/>
	            <input class="order_go" type="button" value="주문하러가기" />
	        </div>
	    </section>
	</body>
</html>