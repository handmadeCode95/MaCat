$(function() {
	
	// AJAX 처리시 tbody에 출력할 값
	$.fn.getTable = function(data) {
		var result = "";
  	    var pagingResult = "";
		$.each(data, function(key, value){
			if (key === "mbersVO") {
				$.each(value, function(k, v){
					result += "<tr id='" + v["mber_sn"] + "'><td><input type='checkbox' class='chkbox' name='mbers' value='" + v["mber_sn"] + "'></td>";
					result += "<td><input type='hidden' class='" + v["mber_sn"] + "' name='mber_sn' value='" + v["mber_sn"] + "' disabled>" + v["mber_sn"] + "</td>";
					result += "<td>" + v["id"] + "</td>";
					result += "<td><input type='password' class='" + v["mber_sn"] + "' name='pw' value='" + v["pw"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sn"] + "' name='name' value='" + v["name"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sn"] + "' name='email' value='" + v["email"] + "' disabled></td>";
					result += "<td>" + v["birthday"].substring(0, 10) + "</td>";
					result += "<td>"; if(v["gender"] === "1") result += "남"; if(v["gender"] === "2") result += "여"; result += "</td>";
					result += "<td><input type='text' class='" + v["mber_sn"] + "' name='phone' value='" + v["phone"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sn"] + "' name='tel' value='" + v["tel"] + "' disabled></td>";
					result += "<td>" + v["point"] + "</td>";
					result += "<td>" + v["reg_date"].substring(0, 10) + "</td>";
					result += "<td>" + v["conect_rcord"].substring(0, 10) + "</td>";
					result += "<td><input type='text' class='" + v["mber_sn"] + "' name='zonecode' value='" + v["zonecode"] + "' minlength='5' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sn"] + "' name='adres' value='" + v["adres"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sn"] + "' name='detail_adres' value='" + v["detail_adres"] + "' disabled></td>";
					result += "<td><select id='grad' class='" + v["mber_sn"] + "' name='mber_grad' disabled>";
					result += "<option>등급선택</option>";
					result += "<option value='4'"; if(v["mber_grad"] === "4") result += " selected"; result += ">운영자</option>";
					result += "<option value='3'"; if(v["mber_grad"] === "3") result += " selected"; result += ">VIP</option>";
					result += "<option value='2'"; if(v["mber_grad"] === "2") result += " selected"; result += ">GOLD</option>";
					result += "<option value='1'"; if(v["mber_grad"] === "1") result += " selected"; result += ">WHITE</option>";
					result += "</select></td></tr>";
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
	        	// 이름이 mbers일 경우에는 무조건 배열처리(mbers는 체크박스이다)
	        	if (name === "mbers") {
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

	
	// 하단 테이블 체크박스 체크시 인풋 활성화/비활성화
	$(document).on("change", "input[name=mbers]", function(){
		if ($(this).prop("checked")){
			$("."+this.value).attr("disabled", false);
		}else{
			$("."+this.value).attr("disabled", true);
		}
	});
	

	// 전체 체크
	$(".all").change(function(){
		$(".chkbox").prop("checked", this.checked);
		$("input[name=mbers]").trigger("change");
	});
	
	
	// 페이지 이동 AJAX
	$(document).on("click", ".page", function(){
		$.ajax({
			url			: "mbers_paging.mcat",
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
	
	
	// 회원 검색 AJAX
	$("#searchBtn").click(function() {
		$.ajax({
			url			: "mbers_search.mcat",
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
	    // arr배열을 mbersVO라는 key값과 함께 저장
	    data = {mbersVO : arr};
	    // JSON형태로 직렬화
	    var mbersVO = JSON.stringify(data);
	    
		$.ajax({
			url			: "mbers_update.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: mbersVO,
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
		
	
	// 탈퇴 AJAX
	$(document).on("click", "#withdrawal", function(){
		$.ajax({
			url			: "withdrawal.mcat",
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