$(function() {
	
	// AJAX 처리시 tbody에 출력할 값
	$.fn.getTable = function(data) {
		var result = "";
  	    var pagingResult = "";
		$.each(data, function(key, value){
			if (key === "NotsVO") {
				$.each(value, function(k, v){
					result += "<tr id='" + v["not_sn"] + "'>";
					result += "<td><input type='checkbox' class='chkbox' name='nots' value='" + v["not_sn"] + "'></td>";
					result += "<td>" + v["not_sn"] + "</td>";
					result += "<td><a href='nots_update.mcat'>" + v["not_sj"] + "</a></td>";
					result += "<td>" + v["not_name"] + "</td>";
					result += "<td>" + v["mber_sn"] + "</td>";
					result += "<td>" + v["not_reg_date"].substring(0, 10) + "</td>";
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
			
			if (newJSON[name]) {
	            if (!newJSON[name].push) {
	            	newJSON[name] = [newJSON[name]];
	            }
	            newJSON[name].push(value || "");
	        } else {
	        	// 이름이 nots일 경우에는 무조건 배열처리(nots는 체크박스이다)
	        	if (name === "nots") {
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
			url			: "nots_paging.mcat",
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
	
	
	// 공지사항 검색 AJAX
	$("#searchBtn").click(function() {
		$.ajax({
			url			: "nots_search.mcat",
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
	
	
	// 삭제 AJAX
	$(document).on("click", "#delete", function(){
		$.ajax({
			url			: "delete.mcat",
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

	
	// 글쓰기 버튼 클릭시 공지사항 작성 페이지로 이동
	$("#write").click(function() {
		$(location).attr("href", "nots_write.mcat");
	});
	
});