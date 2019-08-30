function withdrawal(f) {
	f.action = "not_delete.mcat";
	f.submit();
}
	    
$(function() {	            
	// 전체 체크
	$(".all").change(function(){
		$(".chkbox").prop("checked", this.checked);
	});
});