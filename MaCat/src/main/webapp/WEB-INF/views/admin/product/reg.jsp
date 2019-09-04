<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <title>마캣 관리자 페이지</title>

    	<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">	    

	    <!-- 초기화 -->
	    <link rel="stylesheet" href="resources/css/normalize.css">
	    <!-- 관리자페이지 css -->
	    <link rel="stylesheet" href="resources/css/admin/product/reg.css">
	    <!-- checked 속성 poly-checked 추가 -->
	    <!--[if lte IE 8]> <script src="path/to/poly-checked.min.js"></script> <![endif]-->
	    <script type="text/javascript" src="resources/se/js/HuskyEZCreator.js" charset="utf-8" ></script>
		<script type="text/javascript" src="resources/se/js/jindo.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script type="text/javascript">
	        $(document).ready(function() {
	            $("div > ul > li").each(function() {
	                $(this).click(function() {
	                    $(this).addClass("selected"); 
	                });
	            });
	        });

	    </script>
	    <!-- checkbox 전체선택 쿼리 -->
	    <script type="text/javascript" src="resources/js/checkbox_allchoose.js"></script>
	    
	</head>
	
	<body>
    <!--관리자 페이지 사이드메뉴 불러오기-->
    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>  
	   
	    <main>
	        <section class="wrap">
	            <div class="member_management">
	                <span>상세페이지 작성</span>
	            </div>
	            <div class="detail_text_area">
	            	<p>${productsDTO.prduct_nm}</p>

	            	<!-- 구분선 -->
	            	<div id="border_item"></div>
		            	<div class="smartEditor_container">
		            		<form action="product_reg_ok.mcat" id="contentsForm" method="post" enctype="multipart/form-data">
		            			<%-- <input type="hidden" name="prduct_dom_dt" value="${productsDTO.prduct_dom_dt}">
		            			<input type="hidden" name="prduct_amt" value="${productsDTO.prduct_amt}">
		            			<input type="hidden" name="prduct_price" value="${productsDTO.prduct_price}">
		            			<input type="hidden" name="prduct_as" value="${productsDTO.prduct_as}">
		            			<input type="hidden" name="prduct_maker" value="${productsDTO.prduct_maker}">
		            			<input type="hidden" name="prduct_coo" value="${productsDTO.prduct_coo}">
		            			<input type="hidden" name="prduct_matr" value="${productsDTO.prduct_matr}">
		            			<input type="hidden" name="prduct_size" value="${productsDTO.prduct_size}">
		            			<input type="hidden" name="prduct_nm" value="${productsDTO.prduct_nm}">
		            			<input type="hidden" name="prduct_qa" value="${productsDTO.prduct_qa}">
		            			<input type="hidden" name="ctgry_nm" value="${productsDTO.ctgry_nm}">
		            			<input type="hidden" name="prduct_cd" value="${productsDTO.prduct_cd}">
		            			<input type="hidden" name="main_img" value="${productsDTO.main_img}">
		            			<input type="hidden" name="sub_img1" value="${productsDTO.sub_img1}">
		            			<input type="hidden" name="sub_img2" value="${productsDTO.sub_img2}">
		            			<input type="hidden" name="sub_img3" value="${productsDTO.sub_img3}">
		            			<input type="hidden" name="prduct_price" value="${productsDTO.prduct_price}">
		            			<input type="hidden" name="prduct_dlvy_price" value="${productsDTO.prduct_dlvy_price}">
		            			<input type="hidden" name="prduct_save_pt" value="${productsDTO.prduct_save_pt}">
		            			<input type="hidden" name="prduct_save" value="${productsDTO.prduct_save}">
		            			<input type="hidden" name="prduct_dc_pt" value="${productsDTO.prduct_dc_pt}">
		            			<input type="hidden" name="prduct_dc" value="${productsDTO.prduct_dc}">
		            			<input type="hidden" name="colors" value="${productsDTO.colors}"> --%>
		            			<input type="hidden" name="colors" value="${productsDTO}">
			            		<textarea id="txtContent" name="prduct_cn"></textarea>
			            	</form>
		            	</div>	            	
	            </div>
	            <div class="submit_or_back_btn">
	            	<input id="submit_btn" type="image" src="resources/img/mcat-submit-btn.png" alt="작성완료" form="contentsForm">
	            	<img id="back_btn" src="resources/img/mcat-back-btn.png" alt="뒤로가기">
	            </div>
	        </section>        
	    </main>
	</body>

	<!-- 스마트 에디터 -->
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: document.getElementById('txtContent'), // html editor가 들어갈 textarea id
		sSkinURI: "resources/se/SmartEditor2Skin.html",  // html editor가 skin url
		htParams : {
			bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : false,	// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		},
		fOnAppLoad: function () { 
			//기본폰트
			oEditors.getById["txtContent"].setDefaultFont("나눔고딕", 11);
	        //수정모드를 구현할 때 사용할 부분. 로딩이 끝난 후 값이 체워지게 하는 구현을 하면 된다.
	        var contents = '';         //db에서 불러온 값을 여기에서 체워넣으면 됨.
	        oEditors.getById["txtContent"].exec("PASTE_HTML", [contents]); //로딩이 끝나면 contents를 txtContent에 넣음
		    },
		    fCreator: "createSEditor2"
		});
		
		var onWrite = function(){
			oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
			var boardWriteForm = document.getElementById("contentsForm");  
			boardWriteForm.action ="writeSubmit";              
			boardWriteForm.submit();  
		};
		
		var onModify = function(){
			oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
			var boardWriteForm = document.getElementById("contentsForm");  
			boardWriteForm.action ="modifySubmit";              
			boardWriteForm.submit();  
		};
		
		var pasteHTML = function(filename){
		    var sHTML = '<img src="${pageContext.request.contextPath}/resources/upload/'+filename+'">';
		    oEditors.getById["txtContent"].exec("PASTE_HTML", [sHTML]);
		};
	</script>
</html>
