$(function () {//全选
    $('.inbox-check').click(function () {
        var activeRow = $(this).parent().parent().parent();

        activeRow.toggleClass('active');
    });


    $('#inboxCollapse').click(function () {
        $('.inbox-menu-inner').slideToggle();
    });

    $('#chkAll').click(function () {
        if ($(this).prop('checked')) {
            $('.inbox-check').prop('checked', true);
            $('.inbox-check').parent().parent().parent().addClass('active');
        }
        else {
            $('.inbox-check').prop('checked', false);
            $('.inbox-check').parent().parent().parent().removeClass('active');
        }
    });

    $(window).resize(function () {
        if (Modernizr.mq('(min-width: 980px)')) {
            $('.inbox-menu ul').show();
        }
    });
});