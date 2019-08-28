$(function() {
	
	$("ul.tab-titles li").click(function() {
		var activeTab = $(this).attr("data-tab-titles");
		$("ul.tab-titles li").removeClass("current");
		$(".tabcontent").removeClass("current");
		$(this).addClass("current");
		$("#" + activeTab).addClass("current");
	});
	
	// 장바구니 담기(회원)
	function addCart(prduct_sq, mber_sq) {
		var cart_amt = $("#amount option:selected").val();
		var cart_color = $("#color option:selected").val();
		$.ajax({
			url			: "add_cart.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: {"prduct_sq" : prduct_sq, "mber_sq" : mber_sq, "cart_amt" : cart_amt, "cart_color" : cart_color},
            success		: function(data) {
            				  switch(data){
            				  	  case "overlap" :
            				  		  // 수량체크먼저
            				  		  if (confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?")) location.href = "cart.mcat?mber_sq=" + mber_sq;
            				  		  break;
            				  	  default : 
            				  		  if (confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?")) location.href = "cart.mcat?mber_sq=" + mber_sq;
            				  		  break;
            				  }
            			  },
            error		: function(error) {
            				  console.log(error);
            				  alert("에러 발생");
            			  }
		});
	}
	
});

// 장바구니 담기(비회원)
function setCookie(prduct_sq, ctgry_nm, prduct_price, prduct_dlvy_price, prduct_nm, prduct_thumb_nm, prduct_dc, prduct_dc_pt, prduct_dced_price, name, exp) {
	var date = new Date();
	date.setTime(date.getTime() + exp * 24 * 60 * 60 * 1000);
	
	var oldCookie = JSON.parse(getCookie(name));
	var newCookie;
	var cart_amt = $("#amount option:selected").val();
	var cart_color = $("#color option:selected").val();
	var price = prduct_price * cart_amt;
	var dc = prduct_dc * cart_amt;
	var dced_price = prduct_dced_price * cart_amt;
	
	if(oldCookie){
		var chk = 0;
		for (var i in oldCookie.cart) {
			if(oldCookie.cart[i].prduct_sq === prduct_sq && oldCookie.cart[i].cart_color === cart_color){
				if (confirm("장바구니에 동일한 상품이 있습니다.\n" + cart_amt + "개 더 추가하시겠습니까?")) {
					oldCookie.cart[i].cart_amt = parseInt(oldCookie.cart[i].cart_amt) + parseInt(cart_amt);
					oldCookie.cart[i].prduct_price = parseInt(oldCookie.cart[i].prduct_price) + parseInt(price);
					oldCookie.cart[i].prduct_dc = parseInt(oldCookie.cart[i].prduct_dc) + parseInt(dc);
					oldCookie.cart[i].prduct_dced_price = parseInt(oldCookie.cart[i].prduct_dced_price) + parseInt(dced_price);
					chk++;
					if (confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?")) location.href = "cart.mcat";
				}else{
					continue;
				}
			}
		}
		if (chk < 1) {
			oldCookie.cart.push({"prduct_sq" : prduct_sq, "ctgry_nm" : ctgry_nm, "cart_amt" : cart_amt, "prduct_nm" : prduct_nm, "prduct_price" : price, "prduct_dlvy_price" : prduct_dlvy_price, "cart_color" : cart_color, "prduct_thumb_nm" : prduct_thumb_nm, "prduct_dc_pt" : prduct_dc_pt, "prduct_dc" : dc, "prduct_dced_price" : dced_price});
			if (confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?")) location.href = "cart.mcat"; 
		}
		newCookie = oldCookie;
	}else{
		newCookie = {"cart" : [{"prduct_sq" : prduct_sq, "ctgry_nm" : ctgry_nm, "cart_amt" : cart_amt, "prduct_nm" : prduct_nm, "prduct_price" : price, "prduct_dlvy_price" : prduct_dlvy_price, "cart_color" : cart_color, "prduct_thumb_nm" : prduct_thumb_nm, "prduct_dc_pt" : prduct_dc_pt, "prduct_dc" : dc, "prduct_dced_price" : dced_price}]};
	}

	document.cookie = name + "=" + JSON.stringify(newCookie) + "; expires=" + date.toUTCString() + "; path=/";
	//confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?");
};

function getCookie(name) {
	var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
	return value ?value[2] :null;
};