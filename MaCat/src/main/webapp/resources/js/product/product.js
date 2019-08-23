$(function() {
	
	$('ul.tab-titles li').click(function() {
		var activeTab = $(this).attr('data-tab-titles');
		$('ul.tab-titles li').removeClass('current');
		$('.tabcontent').removeClass('current');
		$(this).addClass('current');
		$('#' + activeTab).addClass('current');
	});
	
});

function cookieCart(prduct_sq) {
	$.ajax({
		url			: "cookie_cart.mcat",
        type		: "GET",
        dataType	: "json",
        contentType : "application/json",
        data		: {prduct_sq : prduct_sq},
        success		: function(data) {
        			  	  if (confirm('장바구니에 상품이 추가되었습니다\n장바구니로 이동하시겠습니까?')) {
        			  		  //$(location).attr("href", "장바구니페이지로이동");
        			  		  alert('이동성공');
						  }else {
							  alert('이동안함');
						  }
        			  },
        error		: function(error) {
           				  console.log(error);
           				  alert("에러 발생");
           			  }
	});
}