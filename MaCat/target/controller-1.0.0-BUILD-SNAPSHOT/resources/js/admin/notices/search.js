$(function() {
	// 체크박스 체크시 인풋 활성화/비활성화
	$("input[name=search_chk]").change(function() {
		if ($(this).prop("checked")) {
			$("." + this.value).attr("disabled", false);
		} else {
			$("." + this.value).attr("disabled", true);
			$("." + this.value).val(null);
		}
	});
});