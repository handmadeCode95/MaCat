$(function() {
	
	// AJAX 처리시 tbody에 출력할 값
	$.fn.getTable = function(data) {
		var result = "";
  	    var pagingResult = "";
		$.each(data, function(key, value){
			if (key === "members") {
				$.each(value, function(k, v){
					result += "<tr id='" + v["mber_sq"] + "'><td><input type='checkbox' class='chkbox' name='mbers' value='" + v["mber_sq"] + "'></td>";
					result += "<td><input type='hidden' class='" + v["mber_sq"] + "' name='mber_sq' value='" + v["mber_sq"] + "' disabled>" + v["mber_sq"] + "</td>";
					result += "<td>" + v["mber_id"] + "</td>";
					result += "<td><input type='password' class='" + v["mber_sq"] + "' name='mber_pw' value='" + v["mber_pw"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sq"] + "' name='mber_nm' value='" + v["mber_nm"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sq"] + "' name='mber_email' value='" + v["mber_email"] + "' disabled></td>";
					result += "<td>" + v["mber_birthday_dt"].substring(0, 10) + "</td>";
					result += "<td>" + v["mber_gender"] + "</td>";
					result += "<td><input type='text' class='" + v["mber_sq"] + "' name='mber_phone_no' value='" + v["mber_phone_no"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sq"] + "' name='mber_tel_no' value='" + v["mber_tel_no"] + "' disabled></td>";
					result += "<td>" + v["mber_point_sum"] + "</td>";
					result += "<td>" + v["mber_reg_dt"].substring(0, 10) + "</td>";
					result += "<td>" + v["mber_conect_dt"].substring(0, 10) + "</td>";
					result += "<td><input type='text' class='" + v["mber_sq"] + "' name='mber_zip_no' value='" + v["mber_zip_no"] + "' minlength='5' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sq"] + "' name='mber_adres' value='" + v["mber_adres"] + "' disabled></td>";
					result += "<td><input type='text' class='" + v["mber_sq"] + "' name='mber_detail_adres' value='" + v["mber_detail_adres"] + "' disabled></td>";
					result += "<td><select class='" + v["mber_sq"] + "' name='mber_grad_nm' disabled>";
					result += "<option>등급선택</option>";
					$.each(data.mber_grad, function(mgKey, mgValue) {
						result += "<option value='" + mgValue["mber_grad_nm"] + "'"; if(v["mber_grad_nm"] === mgValue["mber_grad_nm"]) result += " selected"; result += ">" + mgValue["mber_grad_nm"] + "</option>";
					})
					// result += "<option value='" + mgValue["mber_grad_nm"] + "'"; if(v["mber_grad_nm"] === mgValue["mber_grad_nm"]) result += " selected"; result += ">" + mgValue["mber_grad_nm"] + "</option>";
					result += "</select></td></tr>";
				});
			}else if (key === "paging"){
				var paging = value;
				
				if (paging.beginBlock <= paging.pagePerBlock){
					pagingResult += '<li class="disable">';
					pagingResult +=	'<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px">'
					pagingResult += '</li>';
				}else {
					pagingResult += '<li><a class="page">';
					pagingResult += '<img src="resources/img/mcat-arrow-slider-left-grey.png" height="10px">';
					pagingResult += '<input type="hidden" name="cPage" value="' + (paging.beginBlock - 1) + '">';
					pagingResult += '</a></li>';
				}
				  
				for (var i = paging.beginBlock; i <= paging.endBlock; i++) {
					if (i == paging.nowPage) {
						pagingResult += '<li class="now">' + i + '</li>';
					}else{
						pagingResult += '<li><a class="page">' + i + '<input type="hidden" name="cPage" value="' + i + '"></a></li>';
					}
				}
				  
				if (paging.endBlock >= paging.totalPage){
					pagingResult += '<li class="disable">';
					pagingResult += '<img src="resources/img/mcat-arrow-slider-right-grey.png" height="10px">';
					pagingResult += '</li>';
				}else {
					pagingResult += '<li><a class="page">';
					pagingResult += '<img src="resources/img/mcat-arrow-slider-right-grey.png" height="10px">';
					pagingResult += '<input type="hidden" name="cPage" value="' + (paging.beginBlock + paging.pagePerBlock) + '">';
					pagingResult += '</a></li>';
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
	
	
    $("li").each(function() {
        $(this).click(function() {
            $(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
            $(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
        });
    });
	
	
	// 하단 테이블 체크박스 체크시 인풋 활성화/비활성화
	$(document).on("change", ".chkbox", function(){
		if ($(this).prop("checked")){
			$("."+this.value).attr("disabled", false);
		}else{
			$("."+this.value).attr("disabled", true);
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
            data		: $().toJSON($("#searchForm)")),
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
	    // arr배열을 mbersDTO라는 key값과 함께 저장
	    data = {mbersDTO : arr};
	    // JSON형태로 직렬화
	    var mbersDTO = JSON.stringify(data);
	    
		$.ajax({
			url			: "mbers_update.mcat",
            type		: "POST",
            dataType	: "json",
            contentType : "application/json",
            data		: mbersDTO,
            success		: function(data) {
            				  $("#allCheck").prop("checked", false);
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
            				  $("#allCheck").prop("checked", false);
            				  $().getTable(data);
			              },
            error		: function(error) {
            				  console.log(error);
            				  alert("에러 발생");
            			  }
		});
	});
	
});