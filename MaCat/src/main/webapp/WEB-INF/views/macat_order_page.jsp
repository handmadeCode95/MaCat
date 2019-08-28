<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <!--여백-->
    <link rel="stylesheet" href="resources/css/spacing.css">
    <!-- macat_mypage_2nd.css-->
    <link rel="stylesheet" href="resources/css/macat_mypage.css">
    <!--초기화-->
    <link rel="stylesheet" href="resources/css/normalize.css">
    <!--주문조회-->
    <link rel="stylesheet" href="resources/css/macat_order_inquiry_page.css">
    <!--탭메뉴-->
    <link rel="stylesheet" href="resources/css/tab_menu-order_inquiry.css">
    <!--displaynone-->
    <link rel="stylesheet" href="resources/css/displaynone.css">
    <!--min file-->
    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <!-- 고정헤더 불러오기 -->
    <script type="text/javascript">
        $(document).ready(function() {
            $("#macat_header").load("macat_header.html");
        });
    </script>
    <!--탭메뉴 쿼리-->
    <script type="text/javascript">
        $(function() {
            $('ul.tab-titles li').click(function() {
                var activeTab = $(this).attr('data-tab-titles');
                $('ul.tab-titles li').removeClass('current');
                $('.tabcontent').removeClass('current');
                $(this).addClass('current');
                $('#' + activeTab).addClass('current');
            })
        });
    </script>
    <!--기간선택 쿼리-->
    <script type="text/javascript">
        $(document).ready(function() {
            $("li").each(function() {
                $(this).click(function() {
                    $(this).addClass("selected");
                    //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
                    $(this).siblings().removeClass("selected");
                    //siblings:형제요소들, removeClass:선택된 클래스의 특성을 없앰
                });
            });
        });
    </script>
    <!--페이징-->
</head>
<body>
    <!-- 고정헤더 불러오기 -->
    <div id="macat_header"></div>
    <!-- 여백-->
    <div class="spacing"></div>

    <section id="wrap">
        <div id="container">
            <div id="contents">
                <div class="titleArea">
                    <span>주문조회</span>
                </div>

                <!--탭 메뉴-->
                <div class="product_tab_container-tabmenu" id="item_list">
                    <div class="tab" id="item_tab">
                        <!--메뉴 선택 파트-->
                        <ul class="tab-titles" id="tab-titles">
                            <li class="current" data-tab-titles="tab1">
                                <a href="#Redirect">주문내역조회</a>
                            </li>
                            <li data-tab-titles="tab2">
                                <a href="#Redirect">취소/반품/교환 내역</a> </li>
                        </ul>
                        <div id="tab1" class="tabcontent current">
                            <!-- 주문상태 선택 파트-->
                            <div class="order_state_box">
                                <fieldset class="base_box">
                                    <legend>검색기간설정</legend>
                                    <!--주문처리상태 선택-->
                                    <div class="state_select">
                                        <select name="" id="">
                                            <option value="all">전체 주문처리상태</option>
                                            <option value="shipped_before">입금전</option>
                                            <option value="shipped_standby">배송준비중</option>
                                            <option value="shipped_begin">배송중</option>
                                            <option value="shipped_complate">배송완료</option>
                                            <option value="order_cancel">취소</option>
                                            <option value="order_exchange">교환</option>
                                            <option value="order_return">반품</option>
                                        </select>
                                    </div>
                                    <!--기간선택-->
                                    <div class="state_select_btn">
                                        <ul>
                                            <li>오늘</li>
                                            <li>1주일</li>
                                            <li>1개월</li>
                                            <li>3개월</li>
                                            <li>6개월</li>
                                        </ul>
                                    </div>
                                    <!--검색 시작 날짜-->
                                    <input id="history_start_date" class="fText" type="text" value="yyyy-mm-dd">
                                    <button type="button">
                                        <img src="resources/img/calender.png" alt="달력보기">
                                    </button>
                                    ~
                                    <!--검색 종료 날짜-->
                                    <input id="history_end_date" class="fText" type="text" value="yyyy-mm-dd">
                                    <button type="button">
                                        <img src="resources/img/calender.png" alt="달력보기">
                                    </button>
                                    <input type="image" src="resources/img/but_search.gif">
                                </fieldset>
                                <ul class="describe">
                                    <span>기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</span>
                                    <span>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</span>
                                    <span>취소/교환/반품 신청은 주문완료일 기준 30일까지 가능합니다.</span>
                                </ul>
                            </div>

                            <!--상품정보 게시글 모음-->
                            <div class="ec-base-table">
                                <div class="title">
                                    <h3>주문 상품 정보</h3>
                                </div>
                                <table>
                                    <colgroup>
                                        <col style="width: 135px;">
                                        <col style="width: 93px;">
                                        <col style="width: auto;">
                                        <col style="width: 61px;">
                                        <col style="width: 111px;">
                                        <col style="width: 111px;">
                                        <col style="width: 111px;">
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th scope="col">
                                                주문일자
                                                <br>
                                                [주문번호]
                                            </th>
                                            <th scope="col">이미지</th>
                                            <th scope="col">상품정보</th>
                                            <th scope="col">수량</th>
                                            <th scope="col">상품구매금액</th>
                                            <th scope="col">주문처리상태</th>
                                            <th scope="col">취소/교환/반품</th>
                                        </tr>
                                    </thead>
                                    <tbody class="center">
                                        <tr class>
                                            <td class="number">
                                                주문일자입력파트
                                                <p>
                                                    <a href="macat_product.html" class="line">[상품번호입력파트]</a>
                                                </p>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_cancel.gif" alt="">
                                                </a>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_cancel2.gif" alt="">
                                                </a>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_exchange.gif" alt="">
                                                </a>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_return.gif" alt="">
                                                </a>
                                            </td>
                                            <td class="thumb">
                                                <a href="/macat_product.html">
                                                    <img src="resources/img/ratio_test.jpg" alt="상품이미지">
                                                </a>
                                            </td>
                                            <td class="product left top">
                                                <strong class="name">
                                                    <a href="macat_product.html">상품상세페이지에 설정된 이름을 출력합니다 상품이름이 한계가 있는거같은....아 저기까지네요 자동 줄바꿈 가능합니다</a>
                                                </strong>
                                                <div class="option">상품상세페이지에서 선택한 옵션 내용이 출력됩니다</div>
                                            </td>
                                            <!--상품 수량파트-->
                                            <td>1</td>
                                            <td class="right">
                                                <strong>10,000원</strong>
                                            </td>
                                            <!--주문처리상태-->
                                            <td class="state">
                                                <p class="txtEm">입금전</p>
                                                <p class="displaynone"><a href="#" target="_self"></a></p>
                                                <a href="#Redirect" class="">
                                                    <img src="resources/img/btn_order_comment.gif" alt="구매후기"></a>
                                                <a href="#none" class="">
                                                    <img src="resources/img/btn_order_retract.gif" alt="취소철회"></a>
                                                <a href="#none">
                                                    <img src="resources/img/btn_order_exchange.gif" alt="교환철회"></a>
                                                <a href="#none" class="">
                                                    <img src="resources/img/btn_order_retract2.gif" alt="반품철회"></a>
                                                <!--
                                    <a href="/board/product/write.html?board_no=4&amp;product_no=3099&amp;order_id=20190820-0000177" class="displaynone"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_comment.gif" alt="구매후기"></a>
                                    <a href="#none" class="" onclick="OrderHistory.withdraw('C','20190820-0000177|3099|000A|238305','F', 'F')"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract.gif" alt="취소철회"></a>
                                    <a href="#none" class="" onclick="OrderHistory.withdraw('E','20190820-0000177|3099|000A|238305','F', 'F')"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract2.gif" alt="교환철회"></a>
                                    <a href="#none" class="" onclick="OrderHistory.withdraw('R','20190820-0000177|3099|000A|238305','F', 'F')"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract3.gif" alt="반품철회"></a>
                                -->
                                            </td>
                                            <td>
                                                <p>
                                                    <a href="" class="line">[상세정보]</a>
                                                </p>
                                                <p>-</p>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <p class="message">주문 내역이 없습니다.</p>
                                <!--클래스명 displaynone 추가하면 안보임, 제이쿼리..-->
                            </div>
                            <div class="paginate">
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_first.gif" alt="첫 페이지">
                                </a>
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_prev.gif" alt="이전 페이지">
                                </a>
                                <ol>
                                    <li>
                                        <a href="" class="this">1</a>
                                    </li>
                                </ol>
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_next.gif" alt="다음 페이지">
                                </a>
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_last.gif" alt="마지막 페이지">
                                </a>
                            </div>
                        </div>
                        <!--취소반품교환 내역 파트-->
                        <div id="tab2" class="tabcontent">
                            <!-- 주문상태 선택 파트-->
                            <div class="order_state_box">
                                <fieldset class="base_box">
                                    <legend>검색기간설정</legend>
                                    <!--기간선택-->
                                    <div class="state_select_btn">
                                        <ul>
                                            <li>오늘</li>
                                            <li>1주일</li>
                                            <li>1개월</li>
                                            <li>3개월</li>
                                            <li>6개월</li>
                                        </ul>
                                    </div>
                                    <!--검색 시작 날짜-->
                                    <input id="history_start_date" class="fText" type="text" value="yyyy-mm-dd">
                                    <button type="button">
                                        <img src="resources/img/calender.png" alt="달력보기">
                                    </button>
                                    ~
                                    <!--검색 종료 날짜-->
                                    <input id="history_end_date" class="fText" type="text" value="yyyy-mm-dd">
                                    <button type="button">
                                        <img src="resources/img/calender.png" alt="달력보기">
                                    </button>
                                    <input type="image" src="resources/img/but_search.gif">
                                </fieldset>
                                <ul class="describe">
                                    <span>기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</span>
                                    <span>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</span>
                                </ul>
                            </div>

                            <!--상품정보 게시글 모음-->
                            <div class="ec-base-table">
                                <div class="title">
                                    <h3>취소/반품/교환</h3>
                                </div>
                                <table>
                                    <colgroup>
                                        <col style="width: 135px;">
                                        <col style="width: 93px;">
                                        <col style="width: auto;">
                                        <col style="width: 61px;">
                                        <col style="width: 111px;">
                                        <col style="width: 111px;">
                                        <col style="width: 111px;">
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th scope="col">
                                                주문일자
                                                <br>
                                                [주문번호]
                                            </th>
                                            <th scope="col">이미지</th>
                                            <th scope="col">상품정보</th>
                                            <th scope="col">수량</th>
                                            <th scope="col">상품구매금액</th>
                                            <th scope="col">주문처리상태</th>
                                            <th scope="col">취소/교환/반품</th>
                                        </tr>
                                    </thead>
                                    <tbody class="center">
                                        <tr class>
                                            <td class="number">
                                                주문일자입력파트
                                                <p>
                                                    <a href="#Redirect" class="line">[상품번호입력파트]</a>
                                                </p>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_cancel.gif" alt="">
                                                </a>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_cancel2.gif" alt="">
                                                </a>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_exchange.gif" alt="">
                                                </a>
                                                <a href="#Redirect" class onclick="페이지 이동  function">
                                                    <img src="resources/img/btn_order_return.gif" alt="">
                                                </a>
                                            </td>
                                            <td class="thumb">
                                                <a href="상품페이지로 이동합니다">
                                                    <img src="resources/img/ratio_test.jpg" alt="상품이미지">
                                                </a>
                                            </td>
                                            <td class="product left top">
                                                <strong class="name">
                                                    <a href="#Redirect">상품상세페이지에 설정된 이름을 출력합니다 상품이름이 한계가 있는거같은....아 저기까지네요 자동 줄바꿈 가능합니다</a>
                                                </strong>
                                                <div class="option">상품상세페이지에서 선택한 옵션 내용이 출력됩니다</div>
                                            </td>
                                            <!--상품 수량파트-->
                                            <td>1</td>
                                            <td class="right">
                                                <strong>10,000원</strong>
                                            </td>
                                            <!--주문처리상태-->
                                            <td class="state">
                                                <p class="txtEm">입금전취소</p>
                                                <p class="displaynone"><a href="#" target="_self"></a></p>
                                                <a href="#Redirect" class="">
                                                    <img src="resources/img/btn_order_comment.gif" alt="구매후기"></a>
                                                <a href="#none" class="">
                                                    <img src="resources/img/btn_order_retract.gif" alt="취소철회"></a>
                                                <a href="#none" class="">
                                                    <img src="resources/img/btn_order_exchange.gif" alt="교환철회"></a>
                                                <a href="#none" class="">
                                                    <img src="resources/img/btn_order_retract2.gif" alt="반품철회"></a>
                                            </td>
                                            <td>
                                                <p>
                                                    <a href="" class="line">[상세정보]</a>
                                                </p>
                                                <p>-</p>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                
                                <!--클래스명 displaynone 추가하면 안보임, 제이쿼리..-->
                                <p class="message">취소/반품/교환 내역이 없습니다.</p>
                            </div>
                            <div class="paginate">
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_first.gif" alt="첫 페이지">
                                </a>
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_prev.gif" alt="이전 페이지">
                                </a>
                                <ol>
                                    <li>
                                        <a href="" class="this">1</a>
                                    </li>
                                </ol>
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_next.gif" alt="다음 페이지">
                                </a>
                                <a href="#Redirect">
                                    <img src="resources/img/btn_page_last.gif" alt="마지막 페이지">
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
</body></html>