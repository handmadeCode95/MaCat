$(function() {
	
	$("ul.tab-titles li").click(function() {
		var activeTab = $(this).attr("data-tab-titles");
		$("ul.tab-titles li").removeClass("current");
		$(".tabcontent").removeClass("current");
		$(this).addClass("current");
		$("#" + activeTab).addClass("current");
	});
	
});

//장바구니 담기(회원)
function isOverlap(prduct_sq, mber_sq) {
	var cart_color = $("#color option:selected").val();
	console.log(prduct_sq, mber_sq, cart_color);
	$.ajax({
		url			: "cart_overlap.mcat",
        type		: "POST",
        dataType	: "json",
        contentType : "application/json",
        data		: JSON.stringify({"prduct_sq" : prduct_sq, "mber_sq" : mber_sq, "cart_color" : cart_color}),
        success		: function(data) {
        				  if(data) {
        					  if (confirm("장바구니에 동일한 상품이 있습니다.\n" + cart_amt + "개 더 추가하시겠습니까?")) addCart(prduct_sq, mber_sq, cart_color);
        				  } else {
        					  addCart(prduct_sq, mber_sq, cart_color);
        				  }
        			  },
        error		: function(error) {
        				  console.log(error);
        				  alert("에러 발생");
        			  }
	});
	
}

function addCart(prduct_sq, mber_sq, cart_color) {
	var cart_amt = $("#amount option:selected").val();
	console.log(prduct_sq, mber_sq, cart_color, cart_amt);
	$.ajax({
		url			: "add_cart.mcat",
        type		: "POST",
        dataType	: "json",
        contentType : "application/json",
        data		: JSON.stringify({"prduct_sq" : prduct_sq, "mber_sq" : mber_sq, "cart_amt" : cart_amt, "cart_color" : cart_color}),
        success		: function(data) {
        				  if (data > 0) {
        					  if (confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?")) location.href = "cart.mcat?mber_sq=" + mber_sq;
						  }else {
							  alert("상품 추가에 실패하였습니다\n잠시 후 다시 시도해주세요.")
						  }
        			  },
        error		: function(error) {
        				  console.log(error);
        				  alert("에러 발생");
        			  }
	});
}

// 장바구니 담기(비회원)
function setCookie(prduct_sq, ctgry_nm, prduct_price, prduct_dlvy_price, prduct_nm, prduct_thumb_nm, prduct_dc, prduct_dc_pt, prduct_dced_price, name, exp) {
	var date = new Date();
	date.setTime(date.getTime() + exp * 24 * 60 * 60 * 1000);
	
	var oldCookie = JSON.parse(getCookie(name));
	var newCookie;
	var cart_amt = parseInt($("#amount option:selected").val());
	var cart_color = $("#color option:selected").val();
	var price = prduct_price * cart_amt;
	var dc = prduct_dc * cart_amt;
	var dced_price = prduct_dced_price * cart_amt;
	
	if(oldCookie){
		var chk = 0;
		var add = false;
		for (var i in oldCookie.cart) {
			if(oldCookie.cart[i].prduct_sq === prduct_sq && oldCookie.cart[i].cart_color === cart_color){
				chk++;
				if (confirm("장바구니에 동일한 상품이 있습니다.\n" + cart_amt + "개 더 추가하시겠습니까?")) {
					oldCookie.cart[i].cart_amt = oldCookie.cart[i].cart_amt + cart_amt;
					oldCookie.cart[i].prduct_price = parseInt(oldCookie.cart[i].prduct_price) + parseInt(price);
					oldCookie.cart[i].prduct_dc = parseInt(oldCookie.cart[i].prduct_dc) + parseInt(dc);
					oldCookie.cart[i].prduct_dced_price = parseInt(oldCookie.cart[i].prduct_dced_price) + parseInt(dced_price);
					add = true;
				}else{
					continue;
				}
			}
		}
		if (chk < 1) {
			oldCookie.cart.push({"prduct_sq" : prduct_sq, "ctgry_nm" : ctgry_nm, "cart_amt" : cart_amt, "prduct_nm" : prduct_nm, "prduct_price" : price, "prduct_dlvy_price" : prduct_dlvy_price, "cart_color" : cart_color, "prduct_thumb_nm" : prduct_thumb_nm, "prduct_dc_pt" : prduct_dc_pt, "prduct_dc" : dc, "prduct_dced_price" : dced_price});
			add = true;
		}
		newCookie = oldCookie;
	}else{
		newCookie = {"cart" : [{"prduct_sq" : prduct_sq, "ctgry_nm" : ctgry_nm, "cart_amt" : cart_amt, "prduct_nm" : prduct_nm, "prduct_price" : price, "prduct_dlvy_price" : prduct_dlvy_price, "cart_color" : cart_color, "prduct_thumb_nm" : prduct_thumb_nm, "prduct_dc_pt" : prduct_dc_pt, "prduct_dc" : dc, "prduct_dced_price" : dced_price}]};
		add = true;
	}

	document.cookie = name + "=" + JSON.stringify(newCookie) + "; expires=" + date.toUTCString() + "; path=/";
	if (add) {
		if (confirm("장바구니에 상품이 추가되었습니다.\n장바구니로 이동하시겠습니까?")) location.href = "cart.mcat";
	}
};

function getCookie(name) {
	var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
	return value ?value[2] :null;
};