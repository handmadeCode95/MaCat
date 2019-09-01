<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
   
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
        <link rel="stylesheet" href="resources/css/normalize.css">
        <link rel="stylesheet" href="resources/css/join.css">
        <link rel="stylesheet" href="resources/css/radiobutton.css">
        <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <script src="resources/js/join.js"></script>
    </head>
    
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <%-- 로고 --%>
                <div class="fadeIn first">
                	<a href="main.mcat">
                		<img src="resources/img/logos/mcat-logo.png" id="icon" alt="MaCat" />
                	</a>
                </div>
                <%-- 로그인 폼 --%>
                <form name="f" action="joinOk.mcat" method="post" onsubmit="return checkAll()">
	                <input type="text" id="id" class="fadeIn second" name="mber_id" placeholder="아이디"><br>
	                <input type="password" id="pw" class="fadeIn third" name="mber_pw" placeholder="비밀번호"><br>
	                <input type="password" id="pwChk" class="fadeIn fourth" name="pwChk" placeholder="비밀번호 확인"><br>
	                <input type="text" id="name" class="fadeIn fifth" name="mber_nm" placeholder="이름"><br>
	                <div id="birthday_and_gender">	
	                	<input type="text" id="birthday_placeholder" class="fadeIn sixth" placeholder="생년월일">
	                	<div id="gender">
	                		<input type="radio" id="man" class="fadeIn ninth" name="mber_gender" value="남"><label for="man" class="fadeIn ninth">남</label>
	                		<input type="radio" id="woman" class="fadeIn ninth" name="mber_gender" value="여"><label for="woman" class="fadeIn ninth">여</label>
	                	</div>
	                </div><br>
	                <input type="text" id="phone" class="fadeIn seventh" name="mber_phone_no" placeholder="핸드폰번호"><br>
	                <input type="text" id="tel" class="fadeIn eighth" name="mber_tel_no" placeholder="전화번호"><br>
	                <div id="emails">	
		                <input type="text" id="email" class="fadeIn tenth" name="mber_email" placeholder="이메일">
		                <select name="email_end" id="email_end" class="fadeIn tenth">
		                    <option value="@naver.com">@naver.com</option>
		                    <option value="@gmail.com">@gmail.com</option>
	                        <option value="@hanmail.net">@hanmail.net</option>
	                        <option value="@nate.com">@nate.com</option>
		                </select>
	                </div><br>
	                <div id="zonecodes">	
	                	<input type="text" id="zonecode" class="fadeIn eleventh" name="mber_zip_no" placeholder="우편번호" readonly>
	                	<input type="button" id="zonecode_button" class="fadeIn eleventh" onclick="searchZip()" value="우편번호 찾기">
	               	</div><br>
	                <input type="text" id="adres" class="fadeIn twelfth" name="mber_adres" placeholder="주소" readonly><br>
	                <input type="text" id="detail_adres" class="fadeIn thirteenth" name="mber_detail_adres" placeholder="상세주소"><br>
	                <input type="submit" id="join_submit" class="fadeIn fourteenth" value="작성완료">
                </form>
                <%-- 하단 텍스트 링크 --%>
                <div id="formFooter">
                	<p>모든 정보를 입력하셔야 가입이 가능합니다.</p>
                </div>
            </div>
        </div>
    </body>
    
</html>