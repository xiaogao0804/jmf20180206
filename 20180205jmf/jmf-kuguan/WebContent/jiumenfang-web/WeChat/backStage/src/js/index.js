/**
 * Created by Administrator on 2017/7/18.
 */
//高度设置
let conHeight=$(window).height();
console.log(conHeight);
$('.contain').height(conHeight);

//登陆部分
//取消
let cancelBtn=document.getElementById('cancel-btn');
cancelBtn.onclick=function(){
    document.getElementsByTagName('form')[0].reset();
    document.getElementsByTagName('form')[1].reset();
};
//登陆
$('.confirm-btn').on('click',function(){
    window.location.href="orderInquiry.html";
});