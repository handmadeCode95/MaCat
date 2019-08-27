<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>장바구니</title>
	    <!--normalize-->
	    <link rel="stylesheet" href="resources/css/normalize.css">
	    <!--장바구니 css-->
	    <link rel="stylesheet" href="resources/css/cart.css">
	    <!--여백-->
	    <link rel="stylesheet" href="resources/css/spacing.css">
	    <!--체크박스 모양-->
	    <link rel="stylesheet" href="resources/css/checkbox.css">
	            
	    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	 
	    <script type="text/javascript">
	//        고정헤더 불러오기
	        $(document).ready(function() {
	            $("#macat_header").load("macat_header.html");
	        });        
	        //전체선택 체크박스 클릭 
	        $(function(){ 
	           $("#cart_allCheck").click(function(){
	                if( $("#cart_allCheck").prop("checked") ){ 
	                    $("input[name=cartOne]").prop("checked",true); 
	                } else {  
	                    $("input[name=cartOne]").prop("checked",false); 
	                }   
	           });
	        });        
	        
	        function allCheckFunc( obj ) {
			$("[name=cartchkAll]").prop("checked", $(obj).prop("checked") );
	        }
	
	/*     체크박스 체크시 전체선택 체크 여부 : 하나 선택해제하면
	    전체선택 체크박스 체크표시가 해제됨*/
	        function oneCheckFunc( obj )
	        {
	            var allObj = $("[name=cartchkAll]");
	            var objName = $(obj).attr("name");
	
	            if( $(obj).prop("checked") )
	            {
	                checkBoxLength = $("[name="+ objName +"]").length;
	                checkedLength = $("[name="+ objName +"]:checked").length;
	
	                if( checkBoxLength == checkedLength ) {
	                    allObj.prop("checked", true);
	                } else {
	                    allObj.prop("checked", false);
	                }
	            }
	            else
	            {
	                allObj.prop("checked", false);
	            }
	        }
	
	        $(function(){
	            $("[name=cartchkAll]").click(function(){
	                allCheckFunc( this );
	            });
	            $("[name=cartOne]").each(function(){
	                $(this).click(function(){
	                    oneCheckFunc( $(this) );
	                });
	            });
	        });
	    </script>
	</head>
	<body>
	     <!-- 고정헤더 불러오기 -->
	    <div id="macat_header"></div>
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
	                    <col style="width: 85px;">
	                </colgroup>
	                <thead>
	                    <tr>
	                        <th scope="col">
	                            <input name="cartchkAll" type="checkbox" id="cart_allCheck">
	                            <label for="cart_allCheck" />
	                        </th>
	                        <th scope="col"><span>상품이미지</span></th>
	                        <th scope="col">상품명</th>
	                        <th scope="col">수량</th>
	                        <th scope="col">금액</th>
	                        <th scope="col">배송비</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td>
	                            <input name="cartOne" class="chkbox" type="checkbox" id="cart_chk1">
	                            <label for="cart_chk1" />
	                        </td>
	                        <td><img src="resources/img/macat_food01.png" alt=""></td>
	                        <td>
	                        <div class="category_box">food</div>
	                            <a href="macat_product.html">고고 캣푸드 내츄럴 본 아이돌</a>
	                        </td>
	                        <td>1</td>
	                        <td id="cart_product_price">10,000</td>
	                        <td id="cart_delivery_pay">2,500</td>
	                    </tr>
	                    <tr>
	                        <td>
	                            <input name="cartOne" class="chkbox" type="checkbox" id="cart_chk2">
	                            <label for="cart_chk2" />
	                        </td>
	                        <td><img src="resources/img/macat_food01.png" alt=""></td>
	                        <td>
	                        <div class="category_box">food</div>
	                            <a href="macat_product.html">고고 캣푸드 내츄럴 본 아이돌</a>
	                        </td>
	                        <td>1</td>
	                        <td id="cart_product_price">10,000</td>
	                        <td id="cart_delivery_pay">2,500</td>
	                    </tr>
	                    <tr>
	                        <td>
	                            <input name="cartOne" class="chkbox" type="checkbox" id="cart_chk3">
	                            <label for="cart_chk3" />
	                        </td>
	                        <td><img src="resources/img/macat_food01.png" alt=""></td>
	                        <td>
	                        <div class="category_box">food</div>
	                            <a href="macat_product.html">고고 캣푸드 내츄럴 본 아이돌</a>
	                        </td>
	                        <td>1</td>
	                        <td id="cart_product_price">10,000</td>
	                        <td id="cart_delivery_pay">2,500</td>
	                    </tr>
	                </tbody>			
	                <tbody id="cart_list_none">
	                    <tr>
	                        <td colspan="6">장바구니가 비었습니다.</td>
	                    </tr>
	                </tbody>
	            </table>
	        </div>
	        
	        <div class="cart-order_del_wishList_box">           <!--
	           <button type="button">선택상품주문</button>
	           <button type="button">선택상품삭제</button>
	           <button type="button">위시리스트</button>  -->           
	            <span>선택상품주문 <hr /> </span>     
	           
	            <span>선택상품삭제 <hr class="second"/></span>
	            
	            <span>위시리스트</span>                    
	        </div>
	        <!--합계 테이블-->
	        <div class="cart_total_price">
	            <table class="price_result">
	               <tr>
	                   <th>장바구니 합계</th>
	                    <td>10,000원</td>                   
	               </tr>
	                <tr>
	                   <th>배송비</th>
	                    <td>2,500원</td>                   
	               </tr>
	                <tr>
	                   <th>총 결제금액</th>
	                    <td>12,500원</td>                   
	               </tr>                
	            </table>            
	        </div>
	        
	        <div class="cart_btn_container">
	            <input class="shopping_go" type="button" value="쇼핑계속하기" src="macat_product_category.html"/>
	            <input class="order_go" type="button" value="주문하러가기" />
	        </div>
	    </section>
	</body>
	
</html>