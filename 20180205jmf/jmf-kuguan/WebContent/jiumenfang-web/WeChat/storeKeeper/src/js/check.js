/**
 * Created by Administrator on 2017/8/22.
 */
//返回上一页
$('.receiving-header i').on('click',function(){
    window.history.back();
})

//获取高度
var winHeight = window.innerHeight;
window.addEventListener('resize', function(event){
    winHeight = window.innerHeight;
    console.log(winHeight);
});
$('.check-contain').height(winHeight);