function getCookie(name) {
	var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
	return value ?value[2] :null;
};
// 수량 형식 (,) 넣기
Number.prototype.format = function(){
    if(this == 0) return 0;
 
    var reg = /(^[+-]?\d+)(\d{3})/;
    var n = (this + '');
 
    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
 
    return n;
};

// 쿠키에 cart가 있다면 페이지 로드시 장바구니 가져오기 : 비회원 적용
$(function() {
	var carts = JSON.parse(getCookie('cart'));		
	//
function setCartValue(){
	if(carts != null){
		var priceResult = "";
		var cartResult = "";
		var chkboxID = 0;
		var totalPrice = 0;
		var totalDC = 0;
		var mostDlvyPrice = 0;
		$.each(carts, function(key, value) {
			$.each(value, function(k, v) {
				if (v["prduct_dc"] > 0) {
					totalDC += v["prduct_dc"];
				}else if (v["prduct_dc_pt"] > 0 && v["prduct_price"] > 99) {
					totalDC += v["prduct_price"] * v["prduct_dc_pt"] / 100;
				}
				
				if (mostDlvyPrice < v["prduct_dlvy_price"]) {
					mostDlvyPrice = v["prduct_dlvy_price"];
				}
				
				totalPrice += v["prduct_price"];
			});
			
			if (totalPrice - totalDC > 50000) {
				for (var i in value) {
					carts.cart[i].prduct_dlvy_price = 0;
				}
				mostDlvyPrice = 0;
			}
			
			$.each(value, function(k, v) {
				cartResult += '<tr><td><input name="carts" class="chkbox" type="checkbox" id="' + chkboxID + '" value="' + chkboxID + '" checked>';
				cartResult += '<label for="' + chkboxID + '"></label></td>';
				cartResult += '<input type="hidden" name="prduct_sq" class="' + chkboxID + '" value="' + v["prduct_sq"] + '" disabled>';
				cartResult += '<input type="hidden" name="cart_color" class="' + chkboxID + '" value="' + v["cart_color"] + '" disabled>';
				cartResult += '<td><img src="resources/img/' + v["prduct_thumb_nm"] + '" alt=""></td>';
				cartResult += '<td class="float_txt"><div class="category_box">' + v["ctgry_nm"] + '</div>';
				
				cartResult += '<a class="float_txt" href="product.mcat?prduct_sq='+ v["prduct_sq"] +'&prduct_thumb_nm='+ v["prduct_thumb_nm"] + '">' 
								+ v["prduct_nm"] + '</a></td>';
				cartResult += '<td>' + v["cart_color"] + '</td>';								
				
				cartResult += '<td class="mbers_cart_amt"><div class="__count_range"><input value="-" type="button" count_range="m" type="button" class="sub_add">'
							  +'<input class="count" value="' 
							  + v["cart_amt"].format() 
							  +'" readonly="" name=""><input value="+" type="button" count_range="p" class="sub_add"></div></td>';			
				
				cartResult += '<td id="cart_product_price">' + v["prduct_dced_price"].format() + '</td>';
				cartResult += '<td id="cart_delivery_pay">' + v["prduct_dlvy_price"].format() + '</td></tr>';
				chkboxID++;
			});
		});
		priceResult += '<tr><th>장바구니 합계</th><td>' + totalPrice.format() +'원</td></tr>';
		priceResult += '<tr><th>배송비</th><td>' + mostDlvyPrice.format() +'원</td></tr>';
		priceResult += '<tr><th>할인금액</th><td>' + totalDC.format() +'원</td></tr>';
		priceResult += '<tr><th>총 결제금액</th><td>' + (totalPrice - totalDC + mostDlvyPrice).format() +'원</td></tr>';
		
		$("#cart_result").empty();
		$("#cart_result").append(cartResult);
		$(".price_result").empty();
		$(".price_result").append(priceResult);
	}
}
	onload = setCartValue;
	//
	$("#cart_allCheck").change(function(){
		$(".chkbox").prop("checked", this.checked);
		$(".chkbox").trigger("change");
	});
	
	$(document).on("change", ".chkbox", function(){
		if ($(this).prop("checked")){
			$("." + this.value).attr("disabled", false);
			
			// 체크 안된 값이 없으면 cart_allCheck 체크박스도 체크
			if ($(".chkbox:not(:checked)").length == 0) $("#cart_allCheck").prop("checked", true);
		}else{
			$("."+this.value).attr("disabled", true);
			
			// 하나라도 체크 해제되면 cart_allCheck 체크박스도 체크 해제
			$("#cart_allCheck").prop("checked", false);
		}
	});
	
	//장바구니 담기(비회원)
	$(document).on("click", ".sub_add", function setUpdateAmtCookie(e) {		
		var $count = $(this).parent().children('input.count[value]'); // i.cart_amt
        var count_val = $count.val(); // min 1
	        e.preventDefault();
	        var type = $(this).attr('count_range');
	        // - 버튼 선택했을 때
	        if(type == 'm'){
	        	if(count_val < 2){
		                alert("더 이상 줄일 수 없습니다");
		                return;	
		           }	
	           var chks = $count.val(parseInt(count_val)-1);	            

	        }else if(type == 'p'){
	            $count.val(parseInt(count_val)+1);
	        }
			
			var date = new Date();
			date.setTime(date.getTime() + 1 * 24 * 60 * 60 * 1000); // 쿠키 기본기간 1일
			
			var prduct_sq = parseInt($(this).parents('tr').children('input[name=prduct_sq]').val());
			var cart_color = $(this).parents('tr').children('input[name=cart_color]').val();
			var oldAddedCookie = carts;
			var newCookie;
			var cart_amt = parseInt($(this).parent().children('.count').val());			
			// 여기서 this =  클릭된 class.sub_add, 
			//	cart_amt =  클릭된 class.sub_add의 부모 (=div)의 자식 (=input) 중 class="count"의 value : ${i.cart_amt}
	//		var cart_color = $("#color option:selected").val();			
			if(oldAddedCookie){
				for (var i in oldAddedCookie.cart) {					
					if(oldAddedCookie.cart[i].prduct_sq === prduct_sq && oldAddedCookie.cart[i].cart_color === cart_color){
					
						var price = (oldAddedCookie.cart[i].prduct_price / oldAddedCookie.cart[i].cart_amt) * cart_amt; // 가격 = 상품가 * 상품수량 (1000 * 3) = 3000원
						var dc = (oldAddedCookie.cart[i].prduct_dc / oldAddedCookie.cart[i].cart_amt) * cart_amt; // 할인가 = 지정 할인금액 * 상품수량 (100 * 3) = 300원
						var dced_price = (oldAddedCookie.cart[i].prduct_dced_price / oldAddedCookie.cart[i].cart_amt) * cart_amt; // 최종가 = 
						
						oldAddedCookie.cart[i].cart_amt = cart_amt;
						oldAddedCookie.cart[i].prduct_price = price ;
						oldAddedCookie.cart[i].prduct_dc = dc;
						oldAddedCookie.cart[i].prduct_dced_price = dced_price;
						// dced_price = price - dc
					}
				}
			}	
			document.cookie = 'cart' + "=" + JSON.stringify(oldAddedCookie) + "; expires=" + date.toUTCString() + "; path=/";
			carts = oldAddedCookie;
			setCartValue();		
	});
});

// 수량 증감에 따른 합계변환 - 개인 회원 적용
function editCartAmt(prduct_sq, mber_sq, cart_color, cart_amt) {	
	if ( cart_amt === 0) return;	
	console.log(prduct_sq, mber_sq, cart_color, cart_amt);
	var totalData = "";	
	var totalPriceResult = "";
	var chkboxID = 0;
	var totalPrice;
	var mostDlvyPrice;
	var totalDC;
	$.ajax({
		url			: "edit_cart.mcat",
        type		: "POST",
        dataType	: "json",
        contentType : "application/json",
        data		: JSON.stringify({"prduct_sq" : prduct_sq, "mber_sq" : mber_sq, "cart_amt" : cart_amt, "cart_color" : cart_color}),
        success		: function(data) {
        					$.each(data, function(key, value) {
        						if(key === "cartList"){
        							$.each(value, function(k, v) {
            							totalData += '<tr><td><input name="carts" class="chkbox" type="checkbox" id="' + chkboxID + '" value="' + chkboxID + '" checked>';
                						totalData += '<label for="' + chkboxID + '"></label></td>';
                						totalData += '<input type="hidden" name="prduct_sq" class="' + chkboxID + '" value="' + v["prduct_sq"] + '" disabled>';
                						totalData += '<input type="hidden" name="cart_color" class="' + chkboxID + '" value="' + v["cart_color"] + '" disabled>';
                						totalData += '<td><img src="resources/img/' + v["prduct_thumb_nm"] + '" alt=""></td>';
                						totalData += '<td class="float_txt"><div class="category_box">' + v["ctgry_nm"] + '</div>';                						
                						totalData += '<a class="float_txt" href="product.mcat?prduct_sq='+ v["prduct_sq"] +'&prduct_thumb_nm='+ v["prduct_thumb_nm"] + '">' 
        								+ v["prduct_nm"] + '</a></td>';            						                						
                						totalData += '<td>' + v["cart_color"] + '</td>';								                						
                						totalData += '<td class="mbers_cart_amt"><div class="__count_range"><input value="-" type="button" count_range="m" type="button" class="sub_add" onclick="javascript:editCartAmt('
                							+ v["prduct_sq"] +',' + v["mber_sq"] + ' , ' + v["cart_color"] + ',' + (v["cart_amt"]-1)  + ')">'
                									  +'<input class="count" value="' 
                									  + parseInt(v["cart_amt"]).format()
                									  +'" readonly="" name=""><input value="+" type="button" count_range="p" class="sub_add" onclick="javascript:editCartAmt('
                          							+ v["prduct_sq"] +' , ' + v["mber_sq"] + ' , ' + v["cart_color"] + ' , ' + (v["cart_amt"]+1)  + ')"></div></td>';	
                						totalData += '<td id="cart_product_price">' + parseInt(v["prduct_dced_price"]).format() + '</td>';
                						totalData += '<td id="cart_delivery_pay">' + parseInt(v["prduct_dlvy_price"]).format() + '</td></tr>';
                						console.log(totalData);
									});
        						}else if(key === "totalPrice"){
        							totalPrice = value;
        							totalPriceResult += '<tr><th>장바구니 합계</th><td>' + parseInt(value).format() +'원</td></tr>';
        							console.log(totalPriceResult);
        						}else if(key === "mostDlvyPrice"){
        							mostDlvyPrice = value;
                					totalPriceResult += '<tr><th>배송비</th><td>' + parseInt(value).format() +'원</td></tr>';
                					console.log(totalPriceResult);
        						}else if(key === "totalDC"){
        							totalDC = value;
                					totalPriceResult += '<tr><th>할인금액</th><td>' + parseInt(value).format() +'원</td></tr>';
                					console.log(totalPriceResult);
        						}        					
        					});
        					totalPriceResult += '<tr><th>총 결제금액</th><td>' + parseInt(totalPrice - totalDC + mostDlvyPrice).format() +'원</td></tr>';
        					$("#cart_result").empty();
        					$("#cart_result").append(totalData);
        					$(".price_result").empty();
        					$(".price_result").append(totalPriceResult);
        				},        				
        error		: function(error) {
        				  console.log(error);
        				  alert("에러 발생");
        			  }    				
	});// ajax 파트 끝
	
	$("#cart_allCheck").change(function(){
		$(".chkbox").prop("checked", this.checked);
		$(".chkbox").trigger("change");
	});
	// 체크박스 함수?
	$(document).on("change", ".chkbox", function(){
		if ($(this).prop("checked")){
			$("." + this.value).attr("disabled", false);
			
			// 체크 안된 값이 없으면 cart_allCheck 체크박스도 체크
			if ($(".chkbox:not(:checked)").length == 0) $("#cart_allCheck").prop("checked", true);
		}else{
			$("."+this.value).attr("disabled", true);
			
			// 하나라도 체크 해제되면 cart_allCheck 체크박스도 체크 해제
			$("#cart_allCheck").prop("checked", false);
		}
	});
}
/*/////////////// 전체선택 체크박스 쿼리 /////////////// */
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
function oneCheckFunc( obj ){
    var allObj = $("[name=cartchkAll]");
    var objName = $(obj).attr("name");

    if( $(obj).prop("checked") ){
        checkBoxLength = $("[name="+ objName +"]").length;
        checkedLength = $("[name="+ objName +"]:checked").length;

        if( checkBoxLength == checkedLength ) {
            allObj.prop("checked", true);
        } else {
            allObj.prop("checked", false);
        }
    }
    else{
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
/*/////////////// 수량 증가/감소 쿼리 /////////////// */