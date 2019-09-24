// 사이드 메뉴 선택시 이미지에 class 추가는 쿼리
$(document).on("click", ".side-item", function(){
	if($(this).next().is(":visible")){
		$(this).next().slideUp();
		$(this).children("img").addClass("rotatedDown");
		$(this).children("img").removeClass("rotatedUp");
	}else{
		$(this).next().slideDown();
		$(this).children("img").addClass("rotatedUp");
		$(this).children("img").removeClass("rotatedDown");
	}
});