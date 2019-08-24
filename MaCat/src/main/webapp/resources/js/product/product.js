$(function() {
	
	$("ul.tab-titles li").click(function() {
		var activeTab = $(this).attr("data-tab-titles");
		$("ul.tab-titles li").removeClass("current");
		$(".tabcontent").removeClass("current");
		$(this).addClass("current");
		$("#" + activeTab).addClass("current");
	});
	
});

function setCookie(name, value, exp) {
	var date = new Date();
	date.setTime(date.getTime() + exp * 24 * 60 * 60 * 1000);
	
	var oldCookie = JSON.parse(getCookie(name));
	var newCookie;
	var amount = $("#amount option:selected").val();
	var color = $("#color option:selected").val();
	
	if(oldCookie){
		var chk = 0;
		for ( var i in oldCookie.cart) {
			if(oldCookie.cart[i].prduct_sq === value && oldCookie.cart[i].cart_color === color){
				if (confirm("장바구니에 동일한 상품이 있습니다.\n" + amount + "개 더 추가하시겠습니까?")) {
					oldCookie.cart[i].cart_amt = parseInt(oldCookie.cart[i].cart_amt) + parseInt(amount);
					chk++;
				}else{
					continue;
				}
			}
		}
		if (chk < 1) {
			oldCookie.cart.push({"prduct_sq" : value, "cart_amt" : amount, "cart_color" : color});
		}
		newCookie = oldCookie;
	}else{
		newCookie = {"cart" : [{"prduct_sq" : value, "cart_amt" : amount, "cart_color" : color}]};
	}
	
	document.cookie = name + "=" + JSON.stringify(newCookie) + "; expires=" + date.toUTCString() + "; path=/";
	//confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?");
};

function getCookie(name) {
	var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
	return value ?value[2] :null;
};