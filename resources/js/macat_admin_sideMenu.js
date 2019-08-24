/*
var cnt = 1;

$(function(){
	$(document).on("click", "#menu5", function(){
		$("#service").slideToggle();
		if(cnt % 2 == 1){
			$("#arrow").addClass("rotatedUp");
			$("#arrow").removeClass("rotatedDown");
		}else{
			$("#arrow").addClass("rotatedDown");
			$("#arrow").removeClass("rotatedUp");
		}
		cnt++;
	});
});
*/
$(function(){
    /*판매관리*/
	$(document).on("click", "#menu1", function(){
		if($("#prd").is(":visible")){
			$("#prd").slideToggle();
			$("#arrow1").addClass("rotatedDown");
			$("#arrow1").removeClass("rotatedUp");	
		}else{
			$("#prd").slideToggle();
			$("#arrow1").addClass("rotatedUp");
			$("#arrow1").removeClass("rotatedDown");
		}
	});
    /*회원관리*/
    $(document).on("click", "#menu2", function(){
		if($("#mem").is(":visible")){
			$("#mem").slideToggle();
			$("#arrow2").addClass("rotatedDown");
			$("#arrow2").removeClass("rotatedUp");	
		}else{
			$("#mem").slideToggle();
			$("#arrow2").addClass("rotatedUp");
			$("#arrow2").removeClass("rotatedDown");
		}
	});
    /*고객센터*/
    $(document).on("click", "#menu3", function(){
		if($("#service").is(":visible")){
			$("#service").slideToggle();
			$("#arrow3").addClass("rotatedDown");
			$("#arrow3").removeClass("rotatedUp");	
		}else{
			$("#service").slideToggle();
			$("#arrow3").addClass("rotatedUp");
			$("#arrow3").removeClass("rotatedDown");
		}
	});
    /*게시글 관리*/
    $(document).on("click", "#menu4", function(){
		if($("#board").is(":visible")){
			$("#board").slideToggle();
			$("#arrow4").addClass("rotatedDown");
			$("#arrow4").removeClass("rotatedUp");	
		}else{
			$("#board").slideToggle();
			$("#arrow4").addClass("rotatedUp");
			$("#arrow4").removeClass("rotatedDown");
		}
	});
    /*카테고리 관리*/
    $(document).on("click", "#menu5", function(){
		if($("#ctg").is(":visible")){
			$("#ctg").slideToggle();
			$("#arrow5").addClass("rotatedDown");
			$("#arrow5").removeClass("rotatedUp");	
		}else{
			$("#ctg").slideToggle();
			$("#arrow5").addClass("rotatedUp");
			$("#arrow5").removeClass("rotatedDown");
		}
	});
});
