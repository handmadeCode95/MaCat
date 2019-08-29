<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>관리자 상품등록 페이지</title>
    <link rel="shortcut icon" href="resources/img/logos/mcat-favicon.ico">
    <!--초기화-->
    <link rel="stylesheet" href="resources/css/normalize.css">
    <!--상품등록 페이지 css-->
    <link rel="stylesheet" href="resources/css/admin/product/macat_admin_add_product.css">

    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <!-- 카테고리 파트 select 문, 단위선택 박스 색상변경, 이미지 미리보기, -->
    <script type="text/javascript" src="resources/js/admin/product/add_product.js"></script>    

</head>
<body>
    <!--관리자 페이지 사이드메뉴 불러오기-->
    <div class="macat_sideMenu_load"><%@ include file="../macat_admin_sideMenu.jsp" %></div>
    <main>
        <section class="wrap">
            <div class="add_product_title">
                <span>상품등록</span>
            </div>
            <!--카테고리 선택 파트-->
            <div class="choose_product_category">
                <span>카테고리</span>
                <div class="category_select_box">
                    <select name="" class="category_depth_1" onchange="categoryChange(this)">
                        <option value="0">1차 카테고리</option>
                        <option value="1">사료</option>
                        <option value="2">간식</option>
                        <option value="3">화장실/모래</option>
                        <option value="4">장난감</option>
                        <option value="5">생활용품</option>
                        <option value="6">악세사리</option>
                        <option value="7">목욕/위생</option>
                    </select>
                    <select name="" class="category_depth_2" id="second_category">
                        <option>2차 카테고리</option>
                    </select>
                </div>
            </div>
            <!--상품명 입력 파트-->
            <div class="insert_product_title">
                <span>상품명</span>
                <div class="title_write_part">
                    <input class="product_title_inputBox" type="text" name="title" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
            </div>
            <!--판매가 입력 파트-->
            <div class="product_sales_price">
                <span>판매가</span>
                <div class="price_choice_box">
                    <div class="tag_price">
                        <span>정가</span>
                        <input type="text" class="tag_price_input" name="cm_monthly_fee" id="cm_monthly_fee" value="" onkeyUp="this.value = SetComma(this.value)" onfocus="this.value = SetComma(this.value)">
                        <!-- 단위선택 박스 -->
                        <div class="won_percnt_box">
                            <ul>
                                <li>원</li>
                            </ul>
                        </div>
                    </div>
                    <div class="discount_price">
                        <span>할인</span>
                        <input type="text" class="discount_price_input" name="cm_monthly_fee" id="cm_monthly_fee" value="" onkeyUp="this.value = SetComma(this.value)" onfocus="this.value = SetComma(this.value)">
                        <!-- 단위선택 박스 : 기본값 원 -->
                        <div class="won_percnt_box">
                            <ul>
                                <li>원</li>
                                <li>%</li>
                            </ul>
                        </div>
                    </div>
                    <div class="total_price">
                        <span>할인가</span>
                        <span>10,000원 (0원 할인)</span>
                    </div>
                </div>
            </div>
            <!--재고수량 파트-->
            <div class="available_stock">
                <span>재고수량</span>
                <div class="available_stock_container">
                    <div class="left_stock">
                        <span>재고</span>
                        <input type="text" class="left_stock_input" name="cm_monthly_fee" id="cm_monthly_fee" value="" onkeyUp="this.value = SetComma(this.value)" onfocus="this.value = SetComma(this.value)">
                        <!-- 단위선택 박스 -->
                        <div class="left_stock_box">
                            <ul><li>개</li></ul>
                        </div>
                    </div>
                </div>
            </div>
            <!--상품색상 파트-->
            <div class="product_color">
                <span>상품색상</span>
                <div class="color_palette">
                    <div class="palette_box">
                        <input name="palette_chk" type="checkbox" id="test_1" onclick="count_ck(this);" value="레드">
                        <label for="test_1"></label>
                        <input name="palette_chk" type="checkbox" id="test_2" onclick="count_ck(this);" value="버건디">
                        <label for="test_2"></label>
                        <input name="palette_chk" type="checkbox" id="test_3" onclick="count_ck(this);" value="오렌지">
                        <label for="test_3"></label>
                        <input name="palette_chk" type="checkbox" id="test_4" onclick="count_ck(this);" value="골드">
                        <label for="test_4"></label>
                        <input name="palette_chk" type="checkbox" id="test_5" onclick="count_ck(this);" value="옐로우">
                        <label for="test_5"></label>
                        <input name="palette_chk" type="checkbox" id="test_6" onclick="count_ck(this);" value="라임">
                        <label for="test_6"></label>
                        <input name="palette_chk" type="checkbox" id="test_7" onclick="count_ck(this);" value="그린">
                        <label for="test_7"></label>
                        <input name="palette_chk" type="checkbox" id="test_8" onclick="count_ck(this);" value="카키">
                        <label for="test_8"></label>
                        <input name="palette_chk" type="checkbox" id="test_9" onclick="count_ck(this);" value="민트">
                        <label for="test_9"></label>
                        <input name="palette_chk" type="checkbox" id="test_10" onclick="count_ck(this);" value="스카이블루">
                        <label for="test_10"></label>
                        <input name="palette_chk" type="checkbox" id="test_11" onclick="count_ck(this);" value="블루">
                        <label for="test_11"></label>
                        <input name="palette_chk" type="checkbox" id="test_12" onclick="count_ck(this);" value="네이비">
                        <label for="test_12"></label>
                        <input name="palette_chk" type="checkbox" id="test_13" onclick="count_ck(this);" value="퍼플">
                        <label for="test_13"></label>
                        <input name="palette_chk" type="checkbox" id="test_14" onclick="count_ck(this);" value="인디핑크">
                        <label for="test_14"></label>
                        <input name="palette_chk" type="checkbox" id="test_15" onclick="count_ck(this);" value="핑크">
                        <label for="test_15"></label>
                        <input name="palette_chk" type="checkbox" id="test_16" onclick="count_ck(this);" value="베이지">
                        <label for="test_16"></label>
                        <input name="palette_chk" type="checkbox" id="test_17" onclick="count_ck(this);" value="카멜">
                        <label for="test_17"></label>
                        <input name="palette_chk" type="checkbox" id="test_18" onclick="count_ck(this);" value="브라운">
                        <label for="test_18"></label>
                        <input name="palette_chk" type="checkbox" id="test_19" onclick="count_ck(this);" value="화이트">
                        <label for="test_19"></label>
                        <input name="palette_chk" type="checkbox" id="test_20" onclick="count_ck(this);" value="아이보리">
                        <label for="test_20"></label>
                        <input name="palette_chk" type="checkbox" id="test_21" onclick="count_ck(this);" value="그레이"><label for="test_21"></label>
                        <input name="palette_chk" type="checkbox" id="test_22" onclick="count_ck(this);" value="차콜">
                        <label for="test_22"></label>
                        <input name="palette_chk" type="checkbox" id="test_23" onclick="count_ck(this);" value="블랙">
                        <label for="test_23"></label>
                    </div>
                </div>
            </div>            
            <!--상품 이미지 파트-->    
            <div class="product_image">
                <span>상품이미지</span>
                <div class="main_image_part" >
                    <span>대표이미지</span>
                    <div class="cover_layer">
                       <!--미리보는 곳-->
                        <div id="preview-main"></div>
                        <!--파일 선택등-->
                        <div class="preview_underBox">
                            <input type="file" name="" class="inp-img-main" accept=".gif, .jpg, .png"> 
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
                            <input type="file" name="" class="inp-img-sub1" accept=".gif, .jpg, .png"> 
                            <button type="button" class="preview-file_upload-sub1">추가</button>
                            <button type="button" class="btn-delete-sub1">삭제</button>
                        </div>   
                    </div>    
                    <!--2번 이미지-->
                    <div class="cover_layer">
                        <div id="preview-sub2"></div>
                        <div class="preview_underBox">
                            <input type="file" name="" class="inp-img-sub2" accept=".gif, .jpg, .png"> 
                            <button type="button" class="preview-file_upload-sub2">추가</button>
                            <button type="button" class="btn-delete-sub2">삭제</button>
                        </div>   
                    </div>   
                    <!--3번 이미지-->
                    <div class="cover_layer">
                        <div id="preview-sub3"></div>
                        <div class="preview_underBox">
                            <input type="file" name="" class="inp-img-sub3" accept=".gif, .jpg, .png"> 
                            <button type="button" class="preview-file_upload-sub3">추가</button>
                            <button type="button" class="btn-delete-sub3">삭제</button>
                        </div>   
                    </div>  
                </div>
            </div>             
            <!--배송정보 파트-->
            <div class="delivery_info">
                <span>배송정보</span>
                <!--배송비-->
                <div class="delivery_pay">                  
                    <span>배송비</span>
                    <input type="text" class="pay_input" name="cm_monthly_fee" id="cm_monthly_fee" value="" onkeyUp="this.value = SetComma(this.value)" onfocus="this.value = SetComma(this.value)">
                    <!-- 단위선택 박스 -->
                    <div class="pay_box">
                        <ul><li>원</li></ul>
                    </div>                    
                </div>
                <!--배송사-->
                <div class="delivery_company">
                    <span>배송사</span>   
                    <select name="" class="delivery_box">
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
                   <span>적립금</span>
                    <input type="text" class="mileage_input" name="cm_monthly_fee" id="cm_monthly_fee" value="" onkeyUp="this.value = SetComma(this.value)" onfocus="this.value = SetComma(this.value)">
                    <!-- 단위선택 박스 -->
                    <div class="mileage_btn_box">
                        <ul>
                            <li>P</li>
                            <li>%</li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <!--상세정보-->
            <div class="product_details">
                <span>상세정보</span>
                <div class="detail-resource">
                   <span>소재</span>
                    <input class="detail_1_input" type="text" name="resource" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
                <div class="detail-size">
                    <span>크기</span>
                    <input class="detail_1_input" type="text" name="size" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
                <div class="detail-maker">
                    <span>제조사</span>
                    <input class="detail_1_input" type="text" name="maker" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
                <div class="detail-country">
                    <span>제조국</span>
                    <input class="detail_1_input" type="text" name="country" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
                <div class="detail-yymmdd">
                    <span>제조일자</span>
                    <input class="detail_1_input" type="text" name="yymmdd" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
                <div class="detail-as_code">
                    <span>A/S번호</span>
                    <input class="detail_1_input" type="text" name="as_code" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
                <div class="detail-quality">
                    <span>품질보증기준</span>
                    <input class="detail_quality_input" type="text" name="quality" id="byteInfo" onkeyup="chkword(this, 150)">
                </div>
            </div>
            <!--상세페이지 버튼-->
            <div class="product_detail_page">
               <div>
               <a href="product_reg.mcat">
                   <input class="detail_btn" type="button" value="상세페이지 작성하기"/> 
               </a>                
                </div>
            </div>
        </section>            
    </main>
</body>


</html>