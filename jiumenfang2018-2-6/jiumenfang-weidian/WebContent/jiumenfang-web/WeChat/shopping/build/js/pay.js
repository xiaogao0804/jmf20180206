/**
 * Created by Administrator on 2017/6/15.
 */
//头部
//返回
$(function(){
    //返回之前的页面
    $('.fa-arrow-left').click(function(){
        window.history.back();
    });

    //城市联动
    $('#province').ProvinceCity();

    //手机等验证
    $('.footer').on('click',function(){
        let  name=$('.user-ipt-name input').val();
        let tel=$('.user-ipt-tel input').val();
        let sel=$('#province select').val();
        let address=$('.user-address input').val();
        if(name==''){
            alert('请填写收件人');
        }
        if(sel.indexOf('请选择')>-1){
            alert('请选择邮寄地址');
        }
        if(address==''){
            alert('请选择街道门牌号');

        }
        if(tel==''){
            alert('请填写收件人电话');
        }else{
            //验证手机号
            let isMob=/^([0-9]{3,4}-)?[0-9]{7,8}$/;
            let isPhone=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
            let value=$.trim(tel);
            if(isMob.test(value) || isPhone.test(value)){
                return true;
            } else {
                alert('请填写正确的手机号码');
            }
        }
    });
});