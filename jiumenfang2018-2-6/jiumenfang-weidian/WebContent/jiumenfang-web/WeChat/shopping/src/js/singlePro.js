/**
 * Created by Administrator on 2017/6/9.
 */
//轮播
var mySwiper = new Swiper ('.swiper-container', {
    direction: 'horizontal',
    loop: true,
    autoplay:3000,
    // 如果需要分页器。
    pagination: '.swiper-pagination',
})

//tab切换
$('.tab-nav li').on('click',function(){
    var i=$(this).index();
    $(this).addClass('tab-nav-active').siblings().removeClass('tab-nav-active');
    $('.tab-info li').eq(i).addClass('tab-info-active').siblings().removeClass('tab-info-active');
});

//整体高度
$('.box').height($(window).height());

//返回上一个页面
$('.single-header .fa-angle-left').on('click',function(){
    window.history.back();
})


//返回顶部
$('.top-back').click(function(){
    $("body").scrollTo({top:0})
});

//弹窗
function pop(select,popSelect){
	//弹出弹窗
    $(select).on('click',function(){
    	//获取屏幕的高度
    	var popHeight=$(window).height();
    	$('.shopping-popWrap').height(popHeight);
    	$('.shopping-popWrap-cart').height(popHeight);
    	var	maskHeight=$(window).height()-$('.shopping-pop-cart').height();
    	$('.shopping-mask').height(maskHeight);
    	$('.shopping-mask-cart').height(maskHeight);
    	//alert($('.shopping-mask').height());
        $(popSelect).show();
        var	now;
        var	nowDate;
        var	nowTime;
        now=new	Date();
       // nowDate=now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+((now.getDate()<10?"0":""))+now.getDate();
      	nowTime=now.getHours();
      	if(nowTime>=17){
      		nowDate=now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+((now.getDate()<10?"0":""))+(now.getDate()+1);
      	}else{
      		nowDate=now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+((now.getDate()<10?"0":""))+now.getDate();
      	}
      	$(".pop-shipments-time").html(nowDate);
       //alert(nowTime);
       // alert(nowDate);
       
    })
};
pop('.shopping-bag-add','.shopping-popWrap-cart');
pop('.shopping-bag-settlement','.shopping-popWrap');

//关闭弹窗
$('.shopping-mask').on('click',function(){
    $('.shopping-popWrap').hide();
});
$('.shopping-mask-cart').on('click',function(){
    $('.shopping-popWrap-cart').hide();
});
			/*$('.pop-remove').on('click',function(){
			    $('.shopping-pop').hide();
			});*/
			
			/*var cartNum=0;
			$('.shopping-pop-cart .pop-footer').on('click',function(){
			    $('.shopping-pop-cart').hide();
			    let shoppingNum=parseInt($('.pop-change-num').html());
			     //console.log(shoppingNum);
			    let popNum=cartNum+shoppingNum;
			    cartNum=popNum;
			    console.log(popNum);
			    $('.shopping-num').html('+'+popNum);
			});*/
$('.shopping-popWrap-cart .pop-footer').on('click',function(){
    $('.shopping-popWrap-cart').hide();
});
$('.shopping-popWrap .pop-footer').on('click',function(){
    $('.shopping-popWrap').hide();
});

//数量加减

//减
$('.shopping-popWrap-cart .pop-change-subtract').on('click',function(){
    let popNumStr=$('.shopping-popWrap-cart .pop-change-num').html();
    let popNum=parseInt(popNumStr);
    popNum=--popNum;
    if(popNum<=1){
        popNum=1
    };
    $(this).prev('.pop-change-num').html(popNum);
});

//加入购物车-加
$('.shopping-popWrap-cart .pop-change-add').on('click',function(){
    let popNumStr=$('.shopping-popWrap-cart .pop-change-num').html();
    let popNum=parseInt(popNumStr);
    popNum=++popNum;
    $(this).next('.pop-change-num').html(popNum);
});

//立即购买-加
$('.shopping-popWrap .pop-change-add').on('click',function(){
    let popNumStr=$('.shopping-popWrap .pop-change-num').html();
    let popNum=parseInt(popNumStr);
    popNum=popNum+1;
    console.log(popNum);
    $(this).next('.pop-change-num').html(popNum);
});
//减
$('.shopping-popWrap .pop-change-subtract').on('click',function(){
    let popNumStr=$('.shopping-popWrap .pop-change-num').html();
    let popNum=parseInt(popNumStr);
    popNum=--popNum;
    if(popNum<=1){
        popNum=1
    };
    $(this).prev('.pop-change-num').html(popNum);
});

 
