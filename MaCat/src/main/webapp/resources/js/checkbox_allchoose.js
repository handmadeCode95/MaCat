/* $(document).ready(function () {
     var tbl = $("#checkbox_js");

     // 테이블 헤더에 있는 checkbox 클릭시
     $(":checkbox:first", tbl).click(function () {
         // 클릭한 체크박스가 체크상태인지 체크해제상태인지 판단
         if ($(this).is(":checked")) {
             $(":checkbox", tbl).attr("checked", "checked");
         } else {
             $(":checkbox", tbl).removeAttr("checked");
         }

         // 모든 체크박스에 change 이벤트 발생시키기               
         $(":checkbox", tbl).trigger("change");
     });

     // 헤더에 있는 체크박스외 다른 체크박스 클릭시
     $(":checkbox:not(:first)", tbl).click(function () {
         var allCnt = $(":checkbox:not(:first)", tbl).length;
         var checkedCnt = $(":checkbox:not(:first)", tbl).filter(":checked").length;

         // 전체 체크박스 갯수와 현재 체크된 체크박스 갯수를 비교해서 헤더에 있는 체크박스 체크할지 말지 판단
         if (allCnt == checkedCnt) {
             $(":checkbox:first", tbl).attr("checked", "checked");
         } else {
             $(":checkbox:first", tbl).removeAttr("checked");
         }
     }).change(function () {
         if ($(this).is(":checked")) {
             // 체크박스의 부모 > 부모 니까 tr 이 되고 tr 에 selected 라는 class 를 추가한다.
             $(this).parent().parent().addClass("selected");
         } else {
             $(this).parent().parent().removeClass("selected");
         }
     });
 });*/
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
    $("li").each(function() {
        $(this).click(function() {
            $(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
            $(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
        });
    });
});


