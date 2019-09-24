$(function() {
	
	// AJAX 처리시 tbody에 출력할 값
	$.fn.getTable = function(data) {
		var result = "";
  	    var pagingResult = "";
  	    var nots_count;
		$.each(data, function(key, value){
			if (key === "notsDTO") {
				$.each(value, function(k, v){
					result += '<tr id="' + v["not_sq"] + '">';
					result += '<td class="checks"><input name="nots" class="chkbox" type="checkbox" id="table_chk" value="' + v["not_sq"] 
							 + '"><label for="table_chk"></label></td>';
					result += '<td><input name="not_sq" class="' + v["not_sq"] + '" type="hidden" value="' + v["not_sq"] + '" disabled>' + v["not_sq"] + '</td>';
					result += '<td><input name="mber_sq" class="' + v["not_sq"] + '" type="text" value="' + v["mber_sq"] + '" disabled></td>';
//					result += '<td>' + v["mber_sq"] + '</td>';
					result += '<td>' + v["not_sj"] + '</td>';
					result += '<td>' + v["not_cn"] + '</td>';
					result += '<td>' + v["not_reg_dt"].substring(0, 10) + '</td></tr>';
				});
			}else if (key === "pageDTO"){
				var pageDTO = value;
				
				if (pageDTO.beginBlock <= pageDTO.pagePerBlock){
					pagingResult += '<li class="disable">';
					pagingResult +=	'<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px">'
					pagingResult += '</li>';
				}else {
					pagingResult += '<li><a class="page">';
					pagingResult += '<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px">';
					pagingResult += '<input type="hidden" name="cPage" value="' + (pageDTO.beginBlock - 1) + '">';
					pagingResult += '</a></li>';
				}
				  
				for (var i = pageDTO.beginBlock; i <= pageDTO.endBlock; i++) {
					if (i == pageDTO.nowPage) {
						pagingResult += '<li class="now">' + i + '</li>';
					}else{
						pagingResult += '<li><a class="page">' + i + '<input type="hidden" name="cPage" value="' + i + '"></a></li>';
					}
				}
				  
				if (pageDTO.endBlock >= pageDTO.totalPage){
					pagingResult += '<li class="disable">';
					pagingResult += '<img src="resources/img/mcat-arrow-slider-right-grey.png" height="10px">';
					pagingResult += '</li>';
				}else {
					pagingResult += '<li><a class="page">';
					pagingResult += '<img src="resources/img/mcat-arrow-slider-right-grey.png" height="10px">';
					pagingResult += '<input type="hidden" name="cPage" value="' + (pageDTO.beginBlock + pageDTO.pagePerBlock) + '">';
					pagingResult += '</a></li>';
				}
				nots_count = pageDTO.totalRecord;
			}
		});
		$("#searchResult").html(result);
		$("#paging").html(pagingResult);
		$("#nots_count").html(nots_count);
		if($("#allCheck").prop("checked")) $("#allCheck").prop("checked", false);
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
	
    // 검색 영역 체크박스 체크시 인풋 활성화/비활성화, 포커싱
	$(".search").change(function() {
		if ($(this).prop("checked")) {
			$("." + this.value).attr("disabled", false);
			$("." + this.value + ":first").focus();
		} else {
			$("." + this.value).attr("disabled", true);
			$("." + this.value).val(null);
			$("." + this.value).removeClass("active");
		}
	});
	
	// 검색 영역 인풋 클릭시 인풋 활성화/비활성화, 포커싱
	$(".inputClickListener").click(function() {
		if (!$(this).siblings(".search").prop("checked")){
			$(this).siblings(".search").prop("checked", true);
			$(this).siblings(".search").trigger("change");
		}
		if (!$(this).parents("div").children(".search").prop("checked")) {
			$(this).parents("div").children(".search").prop("checked", true);
			$(this).parents("div").children(".search").trigger("change");
			$(this).children().focus();
		}
	});
    
	// 하단 테이블 체크박스 체크시 인풋 활성화/비활성화 + 색상변경
	$(document).on("change", ".chkbox", function(){
		if ($(this).prop("checked")){
			$("."+this.value).attr("disabled", false);
			$("."+this.value).css("color", "#F2A766");
			
			// 체크 안된 값이 없으면 allCheck 체크박스도 체크
			if ($(".chkbox:not(:checked)").length == 0) $("#allCheck").prop("checked", true);
		}else {
			$("."+this.value).attr("disabled", true);
			$("."+this.value).css("color", "#000");
			
			// 하나라도 체크 해제되면 allCheck 체크박스도 체크 해제
			$("#allCheck").prop("checked", false);

		}
	});
	

	// 전체 체크
	$("#allCheck").change(function(){
		$(".chkbox").prop("checked", this.checked);
		$(".chkbox").trigger("change");
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
		console.log($().toJSON($("#searchForm")));
		$.ajax({
			url			: "nots_search.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
//            data		: $().toJSON($("#searchForm")),
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
	
	// 수정 AJAX
	$(document).on("click", "#update", function(){
		
		/* 체크된 열만 JSON 배열로 파싱 */
		var data = {};
		var arr = [];
		// <tr>갯수만큼 each
	    $("tbody").find("tr").each(function(){
	    	// 체크박스 체크되지 않은 열은 넘기기
	      	if (!$(this).find(".chkbox").is(":checked")) return true;
	        var row = {};
	        // <tr>안의 <input>(체크박스제외), <select>만큼 each
	        $(this).find("input:not(.chkbox), select").each(function(){
	        	// row객체에 열 정보 담기
	            row[$(this).attr("name")] = $(this).val();
	        });
	        // 담은 열 정보를 arr배열에 추가
	        arr.push(row);
	    });
	    // arr배열을 notsDTO라는 key값과 함께 저장
	    data = {notsDTO : arr};
	    // JSON형태로 직렬화
	    var notsDTO = JSON.stringify(data);

	    $.ajax({
			url			: "nots_update.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: notsDTO,
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
			url			: "nots_delete.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: $().toJSON($(".chkbox:checked")),
            success		: function(data) {
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