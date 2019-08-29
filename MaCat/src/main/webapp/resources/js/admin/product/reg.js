// 스마트에디터
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

// 상품명 제한
function chkword(obj, maxByte) {
    var strValue = obj.value;
    var strLen = strValue.length;
    var totalByte = 0;
    var len = 0;
    var oneChar = "";
    var str2 = "";
    for (var i = 0; i < strLen; i++) {                
        oneChar = strValue.charAt(i);// input 입력한 값을 charAt() 함수로 한자씩 분리
        if (escape(oneChar).length > 4) {
            totalByte += 3; // 아스키값이 아닌 유니코드이면 길이 2로 계산하고,
        } else {                    
            totalByte++; // 아스키값이면 1로 합니다.
        }                
        if (totalByte <= maxByte) {
            len = i + 1; // 입력한 문자 길이보다 넘치면 잘라내기 위해 저장
        }
    }
    // 넘어가는 글자는 자른다
    if (totalByte > maxByte) {
        alert("한글 " + (maxByte / 3) + "자 (영어 " + (maxByte) + " 바이트)" + "를 초과 입력 할 수 없습니다.");
        str2 = strValue.substr(0, len);
        obj.value = str2;
        chkword(obj, 4000);
    }
}

// input 콤마(,) 쿼리
function SetComma(str) {
    str = str.replace(/,/g, '');
    var retValue = "";
    if (isNaN(str) == false) {
        for (i = 1; i <= str.length; i++) {
            if (i > 1 && (i % 3) == 1)
                retValue = str.charAt(str.length - i) + "," + retValue;
            else retValue = str.charAt(str.length - i) + retValue;
        }
    } else alert("숫자만 입력 가능합니다.");
    return retValue;
}

// 체크박스 선택 한계 (10개)
function count_ck(obj){
    var chkbox = document.getElementsByName("palette_chk");
    var chkCnt = 0;            
    for(var i=0;i<chkbox.length; i++){
        if(chkbox[i].checked){
            chkCnt++;
        }
    }
    if(chkCnt>10){
        alert("색상은 10개까지 선택하실 수 있습니다");
        obj.checked = false;
        return false;
    }
}