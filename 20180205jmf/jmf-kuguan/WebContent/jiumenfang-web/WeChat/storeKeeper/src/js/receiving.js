/**
 * Created by Administrator on 2017/8/2.
 */
//获取高度
var winHeight = window.innerHeight;
window.addEventListener('resize', function(event){
    winHeight = window.innerHeight;
    console.log(winHeight);
});
$('.receiving-contain').height(winHeight);

//输入数量
$('.enterNum input').focus(function(){
    document.activeElement.blur();
    var num="";
    $('.td-num').click(function(){
       num+=$(this).html();
        $('.enterNum input').val(num);
       // console.log(num.length);
    });
});
//删除
$('.keyBoard-delete').on('click',function() {
    var newNum =$('.enterNum input').val();
    var numLen=newNum.length;
    //console.log(numLen);
    var delNum = newNum.substring(0, numLen-1);
    //console.log(delNum);
    $('.enterNum input').val(delNum);
    if($('.enterNum input').val()==''){
        var num="";
        $('.td-num').click(function(){
            num+=$(this).html();
            $('.enterNum input').val(num);
            // console.log(num.length);
        });
    }
});
//确认
/*$('.keyBoard-confirm').on('click',function(){
    window.location.href='info.html';
});*/


//返回上一页
$('.receiving-header i').on('click',function(){
    window.history.back();
})