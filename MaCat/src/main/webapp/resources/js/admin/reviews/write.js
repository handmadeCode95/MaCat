$(function() {
	
	$("#imgUpload").change(function() {
		if(this.files && this.files[0]) {
			var reader = new FileReader;
			reader.onload = function(data) {
				$(".uploadImg img").attr("src", data.target.result).width(400);
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
});