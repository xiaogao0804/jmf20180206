/**
 * Created by Administrator on 2017/8/7.
 */
$('.all-val').on('click',function(){
   $('.taste-list').addClass('select');
});
$('.taste-list li').on('click',function(){
    let i=$(this).index();
    let val=$(this).html();
    
    $('.all-val').html(val);
    $('.taste-list').removeClass('select')
    $('.list-item').css('display','none').eq(i).css('display','block');
});