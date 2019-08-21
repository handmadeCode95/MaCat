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
	$(document).on("click", "#menu5", function(){
		if($("#service").is(":visible")){
			$("#service").slideToggle();
			$("#arrow").addClass("rotatedDown");
			$("#arrow").removeClass("rotatedUp");	
		}else{
			$("#service").slideToggle();
			$("#arrow").addClass("rotatedUp");
			$("#arrow").removeClass("rotatedDown");
		}
	});
});
