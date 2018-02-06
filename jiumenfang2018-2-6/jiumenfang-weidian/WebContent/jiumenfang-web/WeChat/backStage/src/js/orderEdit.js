/**
 * Created by Administrator on 2017/7/18.
 */
//高度设置
let conHeight=$(window).height();
console.log(conHeight);
$('.contain-edit').height(conHeight);


//保存
 $(document).on('click','.save-btn',function(){
     $('.save-pop').css('display','block');
 });
 


$('.pop-cancel-btn').on('click',function(){
    $('.save-pop').css('display','none');
});

