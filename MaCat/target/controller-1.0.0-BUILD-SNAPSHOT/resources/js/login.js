function loginChk(){
	if(!checkId(f.id.value)){
		return false;
	}else if(!checkPw(f.pw.value)){
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

function checkId(id){
	if(!checkExistData(id,"아이디를"))
		return false;
	
	var idRegExp = /^[a-zA-Z0-9]{5,10}$/;
	if(!idRegExp.test(id)){
		alert("아이디는 영문과 숫자조합으로 5~10자 이내로 입력해주세요.");
		f.id.value = "";
		return false;
	}
	return true;
}

function checkPw(pw){
	if(!checkExistData(pw,"비밀번호를"))
		return false;
	
	var pwRegExp = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,16}$/;
	if(!pwRegExp.test(pw)){
		alert("비밀번호는 특수문자 1개이상과 영문,숫자조합으로 8~16자 이내로 작성하셔야합니다.");
		f.pw.value="";
		return false;
	}
	
	return true;
}

// 카카오 로그인 API (기능 보류)
onload = function() {
	// JavaScript 키
	Kakao.init("b9f4bfb4831bff17354b1e3de31c0ac5");
	// 카카오 로그인 버튼을 생성
	Kakao.Auth.createLoginButton({
		container: "#kakao-login-btn",
		success: function(authObj) {
			console.log(JSON.stringify(authObj));
		},
		fail: function(err) {
			alert(JSON.stringify(err));
		}
	});
}
