//생년월일 input 변경
$(document).ready(function() {
    $("#birthday_placeholder").focus(function() {
        $("#birthday_placeholder").replaceWith("<input type='date' id='birthday' name='mber_birthday_dt'>");
        $("#birthday").focus();
    }); 
});

//카카오 우편번호 API 함수
function searchZip() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ""; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== "" && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== "" && data.apartment === "Y"){
               extraRoadAddr += (extraRoadAddr !== "" ? ", " + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ""){
                extraRoadAddr = " (" + extraRoadAddr + ")";
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("zonecode").value = data.zonecode;
            document.getElementById("adres").value = roadAddr + extraRoadAddr;
        }
    }).open();
}

function checkAll(){

	   if(!checkId(f.id.value)){
	      return false;
	   }else if(!checkPassword(f.id.value, f.pw.value, f.pwChk.value)){
	      return false;
	   }else if(!checkName(f.name.value)){
	      return false;
	   }else if(!checkEmail(f.email.value)){
	      return false;
	   }else if(! checkBirth(f.birthday.value)){
	      return false;
	   }else if (!checkPhone(f.phone.value)){
	      return false;
	   }else if (!checkTel(f.tel.value)){
	      return false;
	   }else if (!checkAdres(f.zonecode.value)){
	      return false;
	   }
	   return true;
	}
	
	function checkExistData(value, dataName){
		if(value == ""){
			alert(dataName + "입력해주세요");
			return false;
		}
		return true;
	}
	// 아이디 5글자 이상 10글자이하
	function checkId(id){
		if(!checkExistData(id, "아이디를"))
			return false;
		
		var idRegExp = /^[a-zA-Z0-9]{5,10}$/;
		if(!idRegExp.test(id)){
			alert("아이디는 영문과 숫자조합으로 5~10자 이내로 작성하셔야합니다.");
			f.id.value = "";
			return false;
		}
		return true;
	}
	
	function checkPassword(id, pw, pwChk){
		if(!checkExistData(pw,"비밀번호를"))
			return false;
		
		if(!checkExistData(pwChk,"비밀번호 확인을"))
			return false;
		
		var pwRegExp = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,16}$/;
		if(!pwRegExp.test(pw)){
			alert("비밀번호는 특수문자 1개이상과 영문,숫자조합으로 8~16자 이내로 작성하셔야합니다.");
			f.pw.value="";
			return false;
		}
		
		if(pw != pwChk){
			alert("비밀번호와 비밀번호 확인이 맞지 않습니다.");
			f.pw.value="";
			f.pwChk.value="";
			return false;
		}
		
		return true;
	}
		
	function checkName(name){
		if(!checkExistData(name,"이름을"))
			return false;
		
		var nameRegExp = /^[가-힣]{2,30}$/;
		if(!nameRegExp.test(name)){
			alert("이름이 올바르지 않습니다.");
			f.name.value="";
			return false;
		}
		return true;
	}
	
	
	function checkEmail(email){
			
		if(!checkExistData(email,"이메일을"))
			return false;
			var emailRegExp = /^[a-zA-Z0-9]{4,30}$/;
			if(!emailRegExp.test(email)){
				alert("메일을 확인해주세요.");
				f.email.value = "";
				return false;
			}
			
		return true;
	}
	
	var date = new Date();
	
	var year = date.getFullYear();
	var month = (date.getMonth()+1);
	var day = date.getDate();
	
	if ((month+"").length < 2){
		month = "0" + month;
	}
	
	
	if ((day+"").length < 2){
		day = "0" + day;
	}
	
	
	var getDate = year + "-" + month + "-" + day;
	
	function checkBirth(birthday){
		if(!checkExistData(birthday,"생일을"))
			return false;
		
		if(getDate <= birthday){
			alert("생년월일을 확인해주세요.");
			f.birthday.value="";
			return false;
		}
		
		return true;
	}
	
	function checkPhone(phone){
		if(!checkExistData(phone,"핸드폰번호를"))
			return false;
		
		var phoneRegExp = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
		if(!phoneRegExp.test(phone)){
			alert("핸드폰번호를 확인해주세요");
			f.phone.value="";
			return false;
		}
		return true;
	}
	
	function checkTel(tel){
		var phoneRegExp = /^(01([0|1|6|7|8|9])|(02|0[3-9]{1}))(\d{3}|\d{4})(\d{4}$)/;
		if(!phoneRegExp.test(tel)){
			alert("전화번호를 확인해주세요");
			f.tel.value="";
			return false;
		}
		return true;
	}
	
	
	function checkAdres(zonecode){
		if(!checkExistData(zonecode,"주소를"))
			return false;
		return true;
	}
