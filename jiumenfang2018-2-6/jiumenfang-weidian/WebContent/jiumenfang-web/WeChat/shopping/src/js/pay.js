'use strict';

/**
 * Created by Administrator on 2017/6/15.
 */
//头部
//返回
$(function () {
    //返回之前的页面
    $('.fa-arrow-left').click(function () {
        window.history.back();
    });

    //城市联动
    $('#province').ProvinceCity();

    //手机等验证
    $('.paid-btn').on('click', function () {
        var name = $('.user-ipt-name input').val();
        var tel = $('.user-ipt-tel input').val();
        var sel = $('#province select').val();
        var address = $('.user-address input').val();
        if (name == '') {
            alert('请填写收件人');
            return false;
        }
        if (tel == '') {
            alert('请填写收件人电话');
            return false;
        }else {
            //验证手机号
            var isMob = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
            var isPhone = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|17[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
            var value = $.trim(tel);
            if (isMob.test(value) || isPhone.test(value)) {
                
            	if (sel.indexOf('请选择') > -1) {
                    alert('请选择邮寄地址');
                    return false;
                }
                if (address == '') {
                    alert('请选择街道门牌号');
                    return false;
                }
            	
            	
            } else {
                alert('请填写正确的手机号码');
                return false;
            }
        }
        
        pay()
    });
});