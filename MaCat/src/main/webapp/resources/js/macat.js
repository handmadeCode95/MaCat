$(document).ready(function () {
    var mainNav = $('.navInner').children('ul').children('li');
    var subNav = mainNav.find('.wrap');

    /*클릭하여 on 클래스 추가*/
    $('button').click(function () {
        $(this).next().stop().slideToggle(200);
        $(this).toggleClass('on');
    });
    $('.close').click(function () {
        $(this).parent().stop().slideToggle(200);
    });
    
    $(mainNav).click(function() {        
        if (mainNav.hasClass('open')) {
            mainNav.removeClass('open');
        }
        if (!(mainNav.hasClass('open'))) {
            $(this).addClass('open');
        }
    });
    
    if ($(window).width() < 768) {
        mobilenav();
    } else {
        pcNav();
    }
    
    $(window).resize(function () {
        if ($(this).width() < 768) {
            mainNav.off();
            mobilenav();
        } else {
            mainNav.off();
            mainNav.children('a').off;
            pcNav();
        }
    });
    
    
    function mobilenav() {
        mainNav.click(function () {
            subNav.hide();
            $(this).toggleClass('on');
            $(this).find('.wrap').show();
        });
        mainNav.children('a').click(function(a) {
            a.preventDefault();
        });
    }

    function pcNav() {
        mainNav.on({
            'mouseenter focusin': function () {
                $(this).addClass('open');
            },
            'mouseleave focusout': function () {
                $(this).removeClass('open');
            }
        });
    }
    
});

// bo : 로그인세션값, path : 로그인하였을때 이동할 경로
function isLogin(bo, path) {
	if (bo) {
		location.href=path;
	}else {
		if (confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?")) location.href="login.mcat";
	}
}
