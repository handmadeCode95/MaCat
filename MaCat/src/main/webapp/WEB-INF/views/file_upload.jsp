<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
</head>
<body>

<form id="fileform" name="fileform" method="post">
	<input type="hidden" name="filename" value="${filename }">
	<input type="hidden" name="path" value="${path }">
</form>
</body>

<script type="text/javascript">
	function fileAttach(){ 
		var form = document.fileform;
	    var fname = form.filename.value; 
	    try{
    		window.opener.window.parent.pasteHTML(fname); 
	    	window.close();	
	    	
	    }catch(e){alert('업로드에 실패했습니다.'); }
	}
	fileAttach();
	this.window.close();
</script>
</html>