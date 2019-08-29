<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 관리</title>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script src="resources/js/admin/notices/search.js"></script>
	</head>

	<body>
		<form action="not_search.mcat" method="post" style="margin: 0 auto; width: 850px">
	    
            <input type="checkbox" name="search_chk" value="not_sn">
	        번호 <input type="number" class="not_sn" name="not_sn" disabled>
        
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="not_sj" checked>
	        제목 <input type="text" class="not_sj" name="not_sj">
	
	        &nbsp;&nbsp;&nbsp;<input type="checkbox" name="search_chk" value="not_name">
	        담당자 <input type="text" class="not_name" name="not_name" disabled><br><br>
	
	        <input type="checkbox" name="search_chk" value="not_reg_date">
	        등록일 <input type="date" class="not_reg_date" name="not_reg_date_start" disabled>~
	        <input type="date" class="not_reg_date" name="not_reg_date_end" disabled><br><br>
	
	        <center>
	            <input type="radio" name="and_or_chk" value="and" checked>AND
	            <input type="radio" name="and_or_chk" value="or">OR
	            <input type="submit" value="조회">
	        </center>
	    </form>
	    
	    <hr>
	    
	    <%@ include file="list.jsp" %>
	</body>
</html>