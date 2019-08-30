<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
<!--초기화-->
<link rel="stylesheet" href="resources/css/normalize.css">
<!--상품등록 페이지 css-->
<link rel="stylesheet"
	href="resources/css/admin/product/macat_admin_add_product.css">

<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<!--카테고리 파트 select 문-->
<script type="text/javascript"
	src="resources/js/admin/product/add_product.js"></script>
<!-- checked 속성 poly-checked 추가 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("li").each(function() {
			$(this).click(function() {
				$(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
				$(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
			});
		});
	});
</script>

<!--상품명 제한 쿼리-->
<script type="text/javascript">
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
			alert("한글 " + (maxByte / 3) + "자 (영어 " + (maxByte) + " 바이트)"
					+ "를 초과 입력 할 수 없습니다.");
			str2 = strValue.substr(0, len);
			obj.value = str2;
			chkword(obj, 4000);
		}
	}
</script>
<!-- input 콤마찍기 쿼리-->
<script type="text/javascript">
	function SetComma(str) {
		str = str.replace(/,/g, '');
		var retValue = "";
		if (isNaN(str) == false) {
			for (i = 1; i <= str.length; i++) {
				if (i > 1 && (i % 3) == 1)
					retValue = str.charAt(str.length - i) + "," + retValue;
				else
					retValue = str.charAt(str.length - i) + retValue;
			}
		} else
			alert("숫자만 입력 가능합니다.");
		return retValue;
	}
</script>
<!--체크박스 선택 한계 쿼리-->
<script type="text/javascript">
	function count_ck(obj) {
		var chkbox = document.getElementsByName("colors");
		var chkCnt = 0;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				chkCnt++;
			}
		}
		if (chkCnt > 10) {
			alert("색상은 10개까지 선택하실 수 있습니다");
			obj.checked = false;
			return false;
		}
	}
</script>
</head>

<body>
	<!--관리자 페이지 사이드메뉴 불러오기-->
	<div class="macat_sideMenu_load"><%@ include
			file="../macat_admin_sideMenu.jsp"%></div>
	<main>
	<section class="wrap">
		<div class="add_product_title">
			<span>상품등록</span>
		</div>
		<form action="product_reg.mcat" method="post"
			enctype="multipart/form-data">
			<!--카테고리 선택 파트-->
			<div class="choose_product_category">
				<span>카테고리</span>
				<div class="category_select_box">
					<select class="category_depth_1" onchange="categoryChange(this)">
						<option value="0">1차 카테고리</option>
						<option value="1">사료</option>
						<option value="2">간식</option>
						<option value="3">화장실/모래</option>
						<option value="4">장난감</option>
						<option value="5">생활용품</option>
						<option value="6">악세사리</option>
						<option value="7">목욕/위생</option>
					</select> <select name="ctgry_nm" class="category_depth_2"
						id="second_category">
						<option>2차 카테고리</option>
					</select>
				</div>
			</div>
			<!--상품명 입력 파트-->
			<div class="insert_product_title">
				<span>상품명</span>
				<div class="title_write_part">
					<input class="product_title_inputBox" type="text" name="prduct_nm"
						id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
			</div>
			<!--판매가 입력 파트-->
			<div class="product_sales_price">
				<span>판매가</span>
				<div class="price_choice_box">
					<div class="tag_price">
						<span>정가</span> <input type="number" class="tag_price_input"
							name="prduct_price" id="cm_monthly_fee" value="0">
						<div class="won_percnt_box">
							<ul>
								<li>원</li>
							</ul>
						</div>
					</div>
					<div class="discount_price">
						<span>할인</span> <input type="number" class="discount_price_input"
							name="prduct_dc" id="cm_monthly_fee" value="0">
						<div class="won_percnt_box">
							<ul>
								<li>원</li>
								<!-- 미구현 -->
								<li>%</li>
							</ul>
						</div>
					</div>
					<div class="total_price">
						<span>할인가</span> <span>10,000원 (0원 할인)</span>
						<!-- 미구현 -->
					</div>
				</div>
			</div>
			<!--재고수량 파트-->
			<div class="available_stock">
				<span>재고수량</span>
				<div class="available_stock_container">
					<div class="left_stock">
						<span>재고</span> <input type="number" class="left_stock_input"
							name="prduct_amt" id="cm_monthly_fee" value="0">
						<div class="left_stock_box">
							<ul>
								<li>개</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!--상품색상 파트-->
			<div class="product_color">
				<span>상품색상</span>
				<div class="color_palette">
					<div class="palette_box">
						<input name="colors" type="checkbox" id="test_1"
							onclick="count_ck(this);" value="레드"> <label for="test_1"></label> <input name="colors" type="checkbox" id="test_2"
							onclick="count_ck(this);" value="버건디"> <label for="test_2"></label> <input name="colors" type="checkbox" id="test_3"
							onclick="count_ck(this);" value="오렌지"> <label for="test_3"></label> <input name="colors" type="checkbox" id="test_4"
							onclick="count_ck(this);" value="골드"> <label for="test_4"></label> <input name="colors" type="checkbox" id="test_5"
							onclick="count_ck(this);" value="옐로우"> <label for="test_5"></label> <input name="colors" type="checkbox" id="test_6"
							onclick="count_ck(this);" value="라임"> <label for="test_6"></label> <input name="colors" type="checkbox" id="test_7"
							onclick="count_ck(this);" value="그린"> <label for="test_7"></label> <input name="colors" type="checkbox" id="test_8"
							onclick="count_ck(this);" value="카키"> <label for="test_8"></label> <input name="colors" type="checkbox" id="test_9"
							onclick="count_ck(this);" value="민트"> <label for="test_9"></label> <input name="colors" type="checkbox" id="test_10"
							onclick="count_ck(this);" value="스카이블루"><label for="test_10"></label> <input name="colors" type="checkbox" id="test_11"
							onclick="count_ck(this);" value="블루"> <label for="test_11"></label> <input name="colors" type="checkbox" id="test_12"
							onclick="count_ck(this);" value="네이비"><label for="test_12"></label> <input name="colors" type="checkbox" id="test_13"
							onclick="count_ck(this);" value="퍼플"> <label for="test_13"></label> <input name="colors" type="checkbox" id="test_14"
							onclick="count_ck(this);" value="인디핑크"><label for="test_14"></label> <input name="colors" type="checkbox" id="test_15"
							onclick="count_ck(this);" value="핑크"> <label for="test_15"></label> <input name="colors" type="checkbox" id="test_16"
							onclick="count_ck(this);" value="베이지"><label for="test_16"></label> <input name="colors" type="checkbox" id="test_17"
							onclick="count_ck(this);" value="카멜"> <label for="test_17"></label> <input name="colors" type="checkbox" id="test_18"
							onclick="count_ck(this);" value="브라운"><label for="test_18"></label> <input name="colors" type="checkbox" id="test_19"
							onclick="count_ck(this);" value="화이트"><label for="test_19"></label> <input name="colors" type="checkbox" id="test_20"
							onclick="count_ck(this);" value="아이보리"><label for="test_20"></label> <input name="colors" type="checkbox" id="test_21"
							onclick="count_ck(this);" value="그레이"><label for="test_21"></label> <input name="colors" type="checkbox" id="test_22"
							onclick="count_ck(this);" value="차콜"> <label for="test_22"></label> <input name="colors" type="checkbox" id="test_23"
							onclick="count_ck(this);" value="블랙"> <label for="test_23"></label>
					</div>
				</div>
			</div>
			<!--상품 이미지 파트-->
			<div class="product_image">
				<span>상품이미지</span>
				<div class="main_image_part">
					<span>대표이미지</span>
					<div class="cover_layer">
						<!--미리보는 곳-->
						<div id="preview-main"></div>
						<!--파일 선택등-->
						<div class="preview_underBox">
							<input type="file" name="main_img" class="inp-img-main"
								accept=".gif, .jpg, .png">
							<button type="button" class="preview-file_upload-main">추가</button>
							<button type="button" class="btn-delete-main">삭제</button>
						</div>
					</div>
				</div>
				<div class="sub_image_part">
					<span>추가이미지</span>
					<!--1번 이미지-->
					<div class="cover_layer">
						<div id="preview-sub1"></div>
						<div class="preview_underBox">
							<input type="file" name="sub_img1" class="inp-img-sub1"
								accept=".gif, .jpg, .png">
							<button type="button" class="preview-file_upload-sub1">추가</button>
							<button type="button" class="btn-delete-sub1">삭제</button>
						</div>
					</div>
					<!--2번 이미지-->
					<div class="cover_layer">
						<div id="preview-sub2"></div>
						<div class="preview_underBox">
							<input type="file" name="sub_img2" class="inp-img-sub2"
								accept=".gif, .jpg, .png">
							<button type="button" class="preview-file_upload-sub2">추가</button>
							<button type="button" class="btn-delete-sub2">삭제</button>
						</div>
					</div>
					<!--3번 이미지-->
					<div class="cover_layer">
						<div id="preview-sub3"></div>
						<div class="preview_underBox">
							<input type="file" name="sub_img3" class="inp-img-sub3"
								accept=".gif, .jpg, .png">
							<button type="button" class="preview-file_upload-sub3">추가</button>
							<button type="button" class="btn-delete-sub3">삭제</button>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					/*숩긴 input을 다른 버튼에서 실행하게 하기*/
					$(".preview-file_upload-main").click(function(e) {
						e.preventDefault();
						$(".inp-img-main").click();
					});
					$(".preview-file_upload-sub1").click(function(e) {
						e.preventDefault();
						$(".inp-img-sub1").click();
					});
					$(".preview-file_upload-sub2").click(function(e) {
						e.preventDefault();
						$(".inp-img-sub2").click();
					});
					$(".preview-file_upload-sub3").click(function(e) {
						e.preventDefault();
						$(".inp-img-sub3").click();
					});

					// 등록 이미지 등록 미리보기
					function readInputFile(input) {
						if (input.files && input.files[0]) {
							var reader = new FileReader();
							reader.onload = function(e) {
								$('#preview-main').html(
										"<img src=" + e.target.result + ">");
							}
							reader.readAsDataURL(input.files[0]);
						}
					}
					$(".inp-img-main").on('change', function() {
						readInputFile(this);
					});
					/*추가1*/
					function readInputFile_sub1(input) {
						if (input.files && input.files[0]) {
							var reader_sub1 = new FileReader();
							reader_sub1.onload = function(e) {
								$('#preview-sub1').html(
										"<img src=" + e.target.result + ">");
							}
							reader_sub1.readAsDataURL(input.files[0]);
						}
					}
					$(".inp-img-sub1").on('change', function() {
						readInputFile_sub1(this);
					});
					/*추가2*/
					function readInputFile_sub2(input) {
						if (input.files && input.files[0]) {
							var reader_sub2 = new FileReader();
							reader_sub2.onload = function(e) {
								$('#preview-sub2').html(
										"<img src=" + e.target.result + ">");
							}
							reader_sub2.readAsDataURL(input.files[0]);
						}
					}
					$(".inp-img-sub2").on('change', function() {
						readInputFile_sub2(this);
					});
					/*추가3*/
					function readInputFile_sub3(input) {
						if (input.files && input.files[0]) {
							var reader_sub3 = new FileReader();
							reader_sub3.onload = function(e) {
								$('#preview-sub3').html(
										"<img src=" + e.target.result + ">");
							}
							reader_sub3.readAsDataURL(input.files[0]);
						}
					}
					$(".inp-img-sub3").on('change', function() {
						readInputFile_sub3(this);
					});

					// 등록 이미지 삭제 ( input file reset )
					function resetInputFile($input, $preview) {
						var agent = navigator.userAgent.toLowerCase();
						if ((navigator.appName == 'Netscape' && navigator.userAgent
								.search('Trident') != -1)
								|| (agent.indexOf("msie") != -1)) {
							// ie 일때
							$input.replaceWith($input.clone(true));
							$preview.empty();
						} else {
							//other
							$input.val("");
							$preview.empty();
						}
					}

					$(".btn-delete-main").click(function(event) {
						var $input = $(".inp-img-main");
						var $preview = $('#preview-main');
						resetInputFile($input, $preview);
					});

					$(".btn-delete-sub1").click(function(event) {
						var $input = $(".inp-img-sub1");
						var $preview = $('#preview-sub1');
						resetInputFile($input, $preview);
					});

					$(".btn-delete-sub2").click(function(event) {
						var $input = $(".inp-img-sub2");
						var $preview = $('#preview-sub2');
						resetInputFile($input, $preview);
					});

					$(".btn-delete-sub3").click(function(event) {
						var $input = $(".inp-img-sub3");
						var $preview = $('#preview-sub3');
						resetInputFile($input, $preview);
					});
				</script>
			</div>
			<!--배송정보 파트-->
			<div class="delivery_info">
				<span>배송정보</span>
				<!--배송비-->
				<div class="delivery_pay">
					<span>배송비</span> <input type="text" class="pay_input"
						name="prduct_dlvy_price" id="cm_monthly_fee" value="0"
						onkeyUp="this.value = SetComma(this.value)"
						onfocus="this.value = SetComma(this.value)">
					<div class="pay_box">
						<ul>
							<li>원</li>
						</ul>
					</div>
				</div>
				<!--배송사-->
				<div class="delivery_company">
					<span>배송사</span> <select class="delivery_box"> <!-- 미구현 -->
						<option value="0">우체국 택배</option>
						<option value="1">로젠 택배</option>
						<option value="2">옐로우캡 택배</option>
						<option value="3">CJ 택배</option>
						<option value="4">대한통운</option>
						<option value="5">편의점 택배</option>
					</select>
				</div>
			</div>

			<!--적립 파트-->
			<div class="mileage">
				<span>적립</span>
				<div class="mileage_box">
					<span>적립금</span> <input type="text" class="mileage_input"
						name="prduct_save" id="cm_monthly_fee" value="0"
						onkeyUp="this.value = SetComma(this.value)"
						onfocus="this.value = SetComma(this.value)">
					<div class="mileage_btn_box">
						<ul>
							<li>P</li> <!-- 미구현 -->
							<li>%</li>
						</ul>
					</div>
				</div>
			</div>

			<!--상세정보-->
			<div class="product_details">
				<span>상세정보</span>
				<div class="detail-resource">
					<span>소재</span> <input class="detail_1_input" type="text"
						name="prduct_matr" id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
				<div class="detail-size">
					<span>크기</span> <input class="detail_1_input" type="text"
						name="prduct_size" id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
				<div class="detail-maker">
					<span>제조사</span> <input class="detail_1_input" type="text"
						name="prduct_maker" id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
				<div class="detail-country">
					<span>제조국</span> <input class="detail_1_input" type="text"
						name="prduct_coo" id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
				<div class="detail-yymmdd">
					<span>제조일자</span> <input class="detail_1_input" type="text"
						name="prduct_dom_dt" id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
				<div class="detail-as_code">
					<span>A/S번호</span> <input class="detail_1_input" type="text"
						name="prduct_as" id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
				<div class="detail-quality">
					<span>품질보증기준</span> <input class="detail_quality_input" type="text"
						name="prduct_qa" id="byteInfo" onkeyup="chkword(this, 150)">
				</div>
			</div>
			<!--상세페이지 버튼-->
			<div class="product_detail_page">
				<div>
					<a href="javascript:void(0)"> <input
						class="detail_btn" type="submit" value="상세페이지 작성하기" />
					</a>
				</div>
			</div>
		</form>
	</section>
	</main>
</body>
</html>