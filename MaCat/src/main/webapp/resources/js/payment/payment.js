$(document).ready(function(){
/*주소지*/
$(function() {
    $('ul.adress_tab-titles li').click(function() {
        var activeTab = $(this).attr('data-tab-titles');
        $('ul.adress_tab-titles li').removeClass('current');
        $('.adress_tabcontent').removeClass('current');
        $(this).addClass('current');
        $('#' + activeTab).addClass('current');
    })
});

/* 결제수단 */
$(function() {
    $('ul.payment_tab-titles li').click(function() {
        var activeTab = $(this).attr('data-tab-titles');
        $('ul.payment_tab-titles li').removeClass('current');
        $('.payment_tabcontent').removeClass('current');
        $(this).addClass('current');
        $('#' + activeTab).addClass('current');
        })
    });
	
/*무통장입금 선택 쿼리*/
   $(".bank_deposit-table tr.tr1 td").click(function() {
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
        $(".bank_deposit-table tr.tr2 td").removeClass("selected");
        $(".bank_deposit-table tr.tr3 td").removeClass("selected");
    });

    $(".bank_deposit-table tr.tr2 td").click(function() {
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
        $(".bank_deposit-table tr.tr1 td").removeClass("selected");
        $(".bank_deposit-table tr.tr3 td").removeClass("selected");
    });

    $(".bank_deposit-table tr.tr3 td").click(function() {
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
        $(".bank_deposit-table tr.tr1 td").removeClass("selected");
        $(".bank_deposit-table tr.tr2 td").removeClass("selected");
    });
    
});