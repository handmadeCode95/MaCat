<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
   
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
        <!-- 구글 로그인 -->
        <meta name="google-signin-client_id" content="168535547192-2ukgrcoohmu9iinbhbce1j3hs323ioph.apps.googleusercontent.com">
        <title>로그인</title>
        <link rel="stylesheet" href="resources/css/normalize.css">
        <link rel="stylesheet" href="resources/css/login.css">
        <link rel="shortcut icon" href="resources/img/mcat-favicon.ico">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <!-- 카카오 로그인 -->
        <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
        <!-- 구글 로그인 -->
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <script src="resources/js/login.js"></script>
    </head>
    
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
            <!-- Tabs Titles -->
                <!-- 로고 -->
                <div class="fadeIn first">
                	<img src="resources/img/mcat-logo-footer.png" id="icon" alt="MaCat" />
                </div>
                <!-- 로그인 폼 -->
                <form name="f" action="login_ok.mcat" method="post" onsubmit="return loginChk()">
	                <input type="text" id="login" class="fadeIn second" name="id" placeholder="아이디">
	                <input type="password" id="password" class="fadeIn third" name="pw" placeholder="비밀번호">
	                <input type="submit" class="fadeIn fourth" value="로그인">
                </form>
                <hr>
                <a id="kakao-login-btn"></a>
                <a href="http://developers.kakao.com/logout"></a>
                <div class="g-signin2" data-onsuccess="onSignIn"></div>
                <!-- 하단 텍스트 링크 -->
                <div id="formFooter">
                	<a class="underlineHover" href="#">아이디 찾기</a>&nbsp;&nbsp;
                	<a class="underlineHover" href="#">비밀번호 찾기</a>&nbsp;&nbsp;
                	<a class="underlineHover" href="join.mcat">회원가입</a>
                </div>
                
            </div>
        </div>
    </body>
    
</html>