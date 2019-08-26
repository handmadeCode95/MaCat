$(function() {
	
	
	
	var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: document.getElementById('txtContent'), // html editor가 들어갈 textarea id 입니다.
		sSkinURI: "resources/smarteditor2/SmartEditor2Skin.html",  // html editor가 skin url 입니다.
		fOnAppLoad: function () { 
	        //수정모드를 구현할 때 사용할 부분입니다. 로딩이 끝난 후 값이 체워지게 하는 구현을 합니다.
	         var title = localStorage.getItem("title");            
	         var contents = 'sadsadsa';        //db에서 불러온 값은 여기에서 체워넣습니다.
	         document.getElementById("title").value = title;     
	         oEditors.getById["txtContent"].exec("PASTE_HTML", [contents]); //로딩이 끝나면 contents를 txtContent에 넣습니다.
	     },
	     fCreator: "createSEditor2"
	 });

	var onWrite = function(){
		oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용합니다.
		
		 var contents = document.getElementById("txtContent").value;
		 var title = document.getElementById("title").value;
		 localStorage.setItem("contents", contents);
		 localStorage.setItem("title", title);             //localStorage에 제목과 내용을 저장.
		 
		var boardWriteForm = document.getElementById("boardWriteForm");  
		//boardWriteForm.action ="writeSubmit";			//저장할 페이지로 쏩니다.              
		boardWriteForm.submit();  
	};

	var pasteHTML = function(filename){
	    var sHTML = '<img src="${pageContext.request.contextPath}/resources/upload/'+filename+'">';
	    oEditors.getById["txtContent"].exec("PASTE_HTML", [sHTML]);
	};
});