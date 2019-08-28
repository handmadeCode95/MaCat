//전체선택 체크박스 클릭 
$(function() {
	var carts = JSON.parse(getCookie('cart'));
	
	if(carts){
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
				cartResult += '<tr><td><input name="carts" class="chkbox" type="checkbox" id="' + chkboxID + '" checked>';
				cartResult += '<label for="' + chkboxID + '"></label></td>';
				cartResult += '<td><img src="resources/img/' + v["prduct_thumb_nm"] + '" alt=""></td>';
				cartResult += '<td><div class="category_box">' + v["ctgry_nm"] + '</div>';
				cartResult += '<a href="macat_product.html">' + v["prduct_nm"] + '</a></td>';
				cartResult += '<td>' + v["cart_color"] + '</td>';
				cartResult += '<td>' + v["cart_amt"] + '</td>';
				cartResult += '<td id="cart_product_price">' + v["prduct_dced_price"] + '</td>';
				cartResult += '<td id="cart_delivery_pay">' + v["prduct_dlvy_price"] + '</td></tr>';
			});
			chkboxID++;
		});
		priceResult += '<tr><th>장바구니 합계</th><td>' + totalPrice +'원</td></tr>';
		priceResult += '<tr><th>배송비</th><td>' + mostDlvyPrice +'원</td></tr>';
		priceResult += '<tr><th>할인금액</th><td>' + totalDC +'원</td></tr>';
		priceResult += '<tr><th>총 결제금액</th><td>' + (totalPrice - totalDC + mostDlvyPrice) +'원</td></tr>';
		
		$("#cart_result").empty();
		$("#cart_result").append(cartResult);
		$(".price_result").empty();
		$(".price_result").append(priceResult);
	}
	
	$("#cart_allCheck").change(function(){
		$(".chkbox").prop("checked", this.checked);
		$(".chkbox").trigger("change");
	});
	
	$(document).on("change", ".chkbox", function(){
		if ($(this).prop("checked")){
			$("."+this.value).attr("disabled", false);
			
			// 체크 안된 값이 없으면 cart_allCheck 체크박스도 체크
			if ($(".chkbox:not(:checked)").length == 0) $("#cart_allCheck").prop("checked", true);
		}else{
			$("."+this.value).attr("disabled", true);
			
			// 하나라도 체크 해제되면 cart_allCheck 체크박스도 체크 해제
			$("#cart_allCheck").prop("checked", false);
		}
	});
});

function getCookie(name) {
	var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
	return value ?value[2] :null;
};