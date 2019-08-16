<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
   
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
        <link rel="stylesheet" href="resources/css/normalize.css">
        <link rel="stylesheet" href="resources/css/join.css">
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
                	<img src="resources/img/logos/mcat-logo-footer.png" id="icon" alt="MaCat" />
                </div>
                <%-- 로그인 폼 --%>
                <form name="f" action="mber_join.mcat" method="post" onsubmit="return checkAll()">
	                <input type="text" id="login" class="fadeIn second" name="id" placeholder="아이디">
	                <input type="password" id="pw" class="fadeIn third" name="pw" placeholder="비밀번호">
	                <input type="password" id="pwChk" class="fadeIn fourth" name="pwChk" placeholder="비밀번호 확인">
	                <input type="text" id="name" class="fadeIn fifth" name="name" placeholder="이름">
	                <input type="text" id="email" class="fadeIn sixth" name="email" placeholder="이메일">
	                <select name="email_end" id="email_end" class="fadeIn sixth">
	                    <option value="@naver.com">@naver.com</option>
	                    <option value="@gmail.com">@gmail.com</option>
                        <option value="@hanmail.net">@hanmail.net</option>
                        <option value="@nate.com">@nate.com</option>
	                </select>
	                <input type="text" id="birthday_placeholder" class="fadeIn seventh" placeholder="생년월일">
	                <input type="text" id="phone" class="fadeIn eighth" name="phone" placeholder="핸드폰번호">
	                <input type="text" id="tel" class="fadeIn ninth" name="tel" placeholder="전화번호">
	                <input type="text" id="zonecode" class="fadeIn tenth" name="zonecode" placeholder="우편번호" readonly>
	                <input type="button" id="zonecode_button" class="fadeIn tenth" onclick="searchZoneode()" value="우편번호 찾기">
	                <input type="text" id="adres" class="fadeIn eleventh" name="adres" placeholder="주소" readonly>
	                <input type="text" id="detail_adres" class="fadeIn twelfth" name="detail_adres" placeholder="상세주소">
	                <input type="submit" id="join_submit" class="fadeIn thirteenth" value="작성완료">
                </form>
                <%-- 하단 텍스트 링크 --%>
                <div id="formFooter">
                	<p>모든 정보를 입력하셔야 가입이 가능합니다.</p>
                </div>
            </div>
        </div>
    </body>
    
</html>