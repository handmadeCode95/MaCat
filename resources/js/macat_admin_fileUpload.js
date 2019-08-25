 /*숩긴 input을 다른 버튼에서 실행하게 하기*/
$(".preview-file_upload").click(function(e){
    e.preventDefault();
    $(".inp-img123").click();
});                         

// 등록 이미지 등록 미리보기
function readInputFile(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#preview').html("<img src=" + e.target.result + ">");
        }
        reader.readAsDataURL(input.files[0]);
    }
}

$(".inp-img123").on('change', function() {
    readInputFile(this);
});

// 등록 이미지 삭제 ( input file reset )
function resetInputFile($input, $preview) {
    var agent = navigator.userAgent.toLowerCase();
    if ((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1)) {
        // ie 일때
        $input.replaceWith($input.clone(true));
        $preview.empty();
    } else {
        //other
        $input.val("");
        $preview.empty();
    }
}

$(".btn-delete").click(function(event) {
    var $input = $(".inp-img123");
    var $preview = $('#preview');
    resetInputFile($input, $preview);
});