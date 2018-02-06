/**
 * Created by Administrator on 2017/8/1.
 */
//获取高度
var winHeight = window.innerHeight;
window.addEventListener('resize', function(event){
    winHeight = window.innerHeight;
    console.log(winHeight);
});
$('.contain').height(winHeight);