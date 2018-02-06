/**
 * Created by Administrator on 2017/7/18.
 */
//高度设置
let conHeight=$(window).height();
console.log(conHeight);
$('.contain-reset').height(conHeight);

//取消
$('.password-cancel').on('click',function(){
    $('.passWord-ipts input').val('');
});

//提交
$('.password-submit').on('click',function(){
    let password1=$('.password1').val();
    let password2=$('.password2').val();
    if(password1!=password2) {
        $('.password-disaccord').show();
        $('.passWord-ipts input').focus(function () {
            $('.password-disaccord').hide();
        });
    };
});