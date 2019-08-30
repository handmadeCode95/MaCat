/*관리자 페이지 전체선택 체크박스*/
$(function(){ 
    //전체선택 체크박스 클릭 
    $("#allCheck").click(function(){ 
    //만약 전체 선택 체크박스가 체크된상태일경우 
    if($("#allCheck").prop("checked")) { 
    //해당화면에 전체 checkbox들을 체크해준다 
        $("input[id=table_chk]").prop("checked",true); 
    // 전체선택 체크박스가 해제된 경우
    } else { 
        //해당화면에 모든 checkbox들의 체크를해제시킨다. 
        $("input[id=table_chk]").prop("checked",false); 
    } 
  });
});
// 멀티체크 관련 
$(document).ready(function() {
	// 가입일 검색기간 선택
    $("div.join_period_btn ul li").each(function() {
        $(this).click(function() {
            $(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
            $(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
        });
    });
    // 접속일 검색기간 선택
    $("div.connect_period_btn ul li").each(function() {
        $(this).click(function() {
            $(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
            $(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
        });
    });
});
