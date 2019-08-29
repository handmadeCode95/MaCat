/*/////////////// 전체선택 체크박스 쿼리 /////////////// */
//전체선택 체크박스 클릭 
$(function(){ 
   $("#cart_allCheck").click(function(){
        if( $("#cart_allCheck").prop("checked") ){ 
            $("input[name=cartOne]").prop("checked",true); 
        } else {  
            $("input[name=cartOne]").prop("checked",false); 
        }   
   });
});        

function allCheckFunc( obj ) {
$("[name=cartchkAll]").prop("checked", $(obj).prop("checked") );
}

/*     체크박스 체크시 전체선택 체크 여부 : 하나 선택해제하면
    전체선택 체크박스 체크표시가 해제됨*/
function oneCheckFunc( obj )
{
    var allObj = $("[name=cartchkAll]");
    var objName = $(obj).attr("name");

    if( $(obj).prop("checked") )
    {
        checkBoxLength = $("[name="+ objName +"]").length;
        checkedLength = $("[name="+ objName +"]:checked").length;

        if( checkBoxLength == checkedLength ) {
            allObj.prop("checked", true);
        } else {
            allObj.prop("checked", false);
        }
    }
    else
    {
        allObj.prop("checked", false);
    }
}

$(function(){
    $("[name=cartchkAll]").click(function(){
        allCheckFunc( this );
    });
    $("[name=cartOne]").each(function(){
        $(this).click(function(){
            oneCheckFunc( $(this) );
        });
    });
});

/*/////////////// 수량 증가/감소 쿼리 /////////////// */
$(function(){
    // 감소(-)버튼 눌렀을 때
    $('#decreaseQuantity').click(function(e){
        e.preventDefault();
        // stat 변수에 #numberUpDown 이 있는 태그의 내용을 가져옴
        var stat = $('#numberUpDown').text();
        // num에 stat를 int 로 변환해서 담음
        var num = parseInt(stat,10);
            num--;
        // 최소값 : num에 1을 최소값으로 넣어줌
        if(num<=0){
            alert('더 이상 줄일수 없습니다.');
            num =1;
        }
        // #numberUpDown 태그 내용을 num으로 바꿈
        $('#numberUpDown').text(num);                    
    });
    
    // 증가(+)버튼 눌렀을 때
    $('#increaseQuantity').click(function(e){
        e.preventDefault();
        var stat = $('#numberUpDown').text();
        var num = parseInt(stat,10);
            num++;
    // 최대값
    if(num>10){
        alert('더 이상 늘릴수 없습니다.');
        num=10;
    }
        $('#numberUpDown').text(num);
    });
});