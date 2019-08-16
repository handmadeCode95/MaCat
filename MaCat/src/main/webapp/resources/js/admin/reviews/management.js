$(function() {
	
	// AJAX 처리시 tbody에 출력할 값
	$.fn.getTable = function(data) {
		var result = "";
  	    var pagingResult = "";
		$.each(data, function(key, value){
			if (key === "reviewsVO") {
				$.each(value, function(k, v){
					result += "<tr id='" + v["re_sn"] + "'>";
					result += "<td><input type='checkbox' class='chkbox' name='res' value='" + v["re_sn"] + "'></td>";
					result += "<td>";
						if (v["re_ans_chk"] == 0) result += "미답변";
						if (v["re_ans_chk"] == 1) result += "답변완료";
						if (v["re_ans_chk"] == 2) result += "답글";
					result += "</td>";
					result += "<td>";
						if (v["re_ctgry"] == 1) result += "취소";
						if (v["re_ctgry"] == 2) result += "교환";
						if (v["re_ctgry"] == 3) result += "배송";
						if (v["re_ctgry"] == 4) result += "결제";
					result += "</td>";
					result += "<td>" + v["re_sn"] + "</td>";
					result += "<td>";
					for (var i = 0; i < v["re_level"]; i++) {
						result += "&nbsp;&nbsp;┗";
					}
					result += "<a href='re_view.mcat?re_sn=" + v["re_sn"] + "'>" + v["re_sj"] + "</a></td>";
					result += "<td>" + v["re_name"] + "</td>";
					result += "<td>" + v["re_reg_date"].substring(0, 10) + "</td>";
					result += "<td>" + v["re_rdcnt"] + "</td>";
				});
			}else if (key === "paging"){
				var paging = value;
				
				if (paging.beginBlock <= paging.pagePerBlock){
					pagingResult += '<li class="disable">◀</li>';
				}else {
					pagingResult += '<li><a class="page">◀<input type="hidden" name="cPage" value="' + (paging.beginBlock - paging.pagePerBlock + 4) + '"></a></li>';
				}
				  
				for (var i = paging.beginBlock; i <= paging.endBlock; i++) {
					if (i == paging.nowPage) {
						pagingResult += '<li class="now">' + i + '</li>';
					}else{
						pagingResult += '<li><a class="page">' + i + '<input type="hidden" name="cPage" value="' + i + '"></a></li>';
					}
				}
				  
				if (paging.endBlock >= paging.totalPage){
					pagingResult += '<li class="disable">▶</li>';
				}else {
					pagingResult += '<li><a class="page">▶<input type="hidden" name="cPage" value="' + (paging.beginBlock + paging.pagePerBlock) + '"></a></li>';
				}
			}
		});
		$("#searchResult").empty();
		$("#searchResult").append(result);
		$("#paging").empty();
		$("#paging").append(pagingResult);
	}
	
	
	// form 데이터를 JSON형식으로 변환
	$.fn.toJSON = function(f) {
		var array = $(f).serializeArray();
		var newJSON = {};
		
		$.each(array, function() {
			var name = $.trim(this.name), value = $.trim(this.value);
			
			if (value == "") return true;
			
			if (newJSON[name]) {
	            if (!newJSON[name].push) {
	            	newJSON[name] = [newJSON[name]];
	            }
	            newJSON[name].push(value || "");
	        } else {
	        	// 이름이 res일 경우에는 무조건 배열처리(res는 체크박스이다)
	        	if (name === "res") {
	        		newJSON[name] = [value];
	        	// 나머지는 변수 처리
				}else{
					newJSON[name] = value || "";
				}
	        }
	    });
	    return JSON.stringify(newJSON);
	};
	
	
	// 검색 영역 체크박스 체크시 인풋 활성화/비활성화
	$("input[name=search_chk]").change(function() {
		if ($(this).prop("checked")) {
			$("." + this.value).attr("disabled", false);
		} else {
			$("." + this.value).attr("disabled", true);
			$("." + this.value).val(null);
		}
	});
	
	
	// 전체 체크
	$(".all").change(function(){
		$(".chkbox").prop("checked", this.checked);
	});
	
	
	// 페이지 이동 AJAX
	$(document).on("click", ".page", function(){
		$.ajax({
			url			: "re_paging.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: $(this).find("input").val(),
            success		: function(data) {
            				  $().getTable(data);
            			  },
            error		: function(error) {
            				  console.log(error);
            				  alert("에러 발생");
            			  }
		});
	});
	
	
	// 리뷰 검색 AJAX
	$("#searchBtn").click(function() {
		$.ajax({
			url			: "re_search.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: $().toJSON($("#searchForm > *:not(input[name=search_chk])")),
            success		: function(data) {
            				  $().getTable(data);
            			  },
            error		: function(error) {
            				  console.log(error);
            				  alert("에러 발생");
            			  }
		});
	});
	
	
	// 리뷰 삭제 AJAX
	$(document).on("click", "#delete", function(){
		$.ajax({
			url			: "re_delete.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: $().toJSON($(".chkbox:checked")),
            success		: function(data) {
            				  $(".all").prop("checked", false);
            				  $().getTable(data);
			              },
            error		: function(error) {
            				  console.log(error);
            				  alert("에러 발생");
            			  }
		});
	});
	
});