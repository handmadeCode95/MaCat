<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
   
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
        <title>로그인</title>
        <link rel="stylesheet" href="resources/css/normalize.css">
        <link rel="stylesheet" href="resources/css/login.css">
        <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <%-- 카카오 로그인(기능 보류) --%>
        <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <script src="resources/js/login.js"></script>
    </head>
    
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <%-- 로고 --%>
                <div class="fadeIn first">
                	<img src="resources/img/logos/mcat-logo.png" id="icon" alt="MaCat" />
                </div>
                <%-- 로그인 폼 --%>
                <form name="f" action="login_ok.mcat" method="post" onsubmit="return loginChk()">
	                <input type="text" id="id" class="fadeIn second" name="mber_id" placeholder="아이디"><br>
	                <input type="password" id="pw" class="fadeIn third" name="mber_pw" placeholder="비밀번호"><br>
	                <input type="submit" class="fadeIn fourth" value="로그인">
                </form>
                <%-- 카카오 로그인(기능 보류) --%>
                <a class="fadeIn fifth" id="kakao-login-btn"></a><a href="http://developers.kakao.com/logout"></a>
                <%-- 하단 텍스트 링크 --%>
                <div id="formFooter">
                	<a class="underlineHover" href="#" style="color: #5C5173;">아이디 찾기</a>
                	<a class="underlineHover" href="#" style="color: #5C5173;">비밀번호 찾기</a>
                	<a class="underlineHover" href="join.mcat"style="color: #5C5173;">회원가입</a>
                </div>
            </div>
        </div>
    </body>
    
</html>