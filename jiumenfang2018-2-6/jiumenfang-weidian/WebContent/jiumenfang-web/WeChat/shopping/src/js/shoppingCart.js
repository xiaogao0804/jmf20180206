/**
 * Created by Administrator on 2017/6/16.
 */
$(function(){
    //商品数量递增
    $('.foods-add').on('click',function(){
        let num=parseInt($(this).prev('.foods-num').html());
         num=++num;
        $(this).prev('.foods-num').html(num);
        js();
    });


    //商品数量递减
    $('.foods-subtract').on('click',function(){
        let numStr=$(this).next('.foods-num').html();
        let num=parseInt(numStr);
        num=--num;
        if(num<=1){
            num=1;
        }
        $(this).next('.foods-num').html(num);
        js();

    });


    //单个商品选择 单选到多选
    //点击选择
    $('.checkbox .fa-circle-thin').on('click',function(){
        var num=0;
        var max;
        var that=$(this);
         $(this).next('i').css("display",'block');
         $(this).css('display','none');
         $('.checkbox .fa-check-circle').each(function(){
         let display=$(this).css('display');
              if(display=='block'){
                  var len=$(this).css('display','block').length;
                  num=len+num;
                   max=Math.max(num);
                  return max;

              }
         })
          let allLen= $('.checkbox .fa-circle-thin').length;
          if(max==allLen){
              $('.checkboxAll .fa-check-circle').css('display','block');
              $('.checkboxAll .fa-circle-thin').css('display','none');
          };
        js();

    });
    //点击取消
    $('.checkbox .fa-check-circle').on('click',function(){
        $(this).prev('i').css("display",'block');
        $(this).css('display','none');
        $('.checkboxAll .fa-check-circle').css('display','none');
        $('.checkboxAll .fa-circle-thin').css('display','block');
        js();
    });


    // 商品全选
    $('.checkboxAll .fa-circle-thin').on('click',function(){
        $(this).css('display','none');
        $(this).next('i').css('display','block');
        $('.fa-check-circle').css('display','block');
        $('.fa-circle-thin').css('display','none');
        js();
    });
    $('.checkboxAll .fa-check-circle').on('click',function(){
        $(this).css('display','none');
        $(this).prev('i').css('display','block');
        $('.fa-check-circle').css('display','none');
        $('.fa-circle-thin').css('display','block');
        $('.priceAll .fa-rmb').html(0.00);
    });

    //计算总价
    function js(){
        var total = 0;
        $('.checkbox').each(function(){
            if($(this).find('.fa-check-circle').css('display')!="block"){
                return
            }
            console.log(total);
            var cart = $(this).parents('.cart-foods');
            var price = +cart.find('.fa-rmb').html();
            var num = +cart.find('.foods-num').html();
            total+=price*num;
        })
        $('.priceAll').find('.fa-rmb').html(total.toFixed(2))
    };
    js();

    // 滑动删除功能
    //设定每一行的宽度=屏幕宽度+按钮宽度
    function scroll(){
        let screenWidth=$(window).width();
        let wrapWidth=parseInt($('.cart-foods').width(screenWidth)+$('.cart-foods-btn').width());
        let eachWrapWidth=$('.cart-foods-wrap').width(wrapWidth);
        //console.log(eachWrapWidth);
        $('.cart-foods-normal').width($('.cart-foods').width());

        //获取所有行，对每一行设置监听
        var lines=$('.cart-foods-normal');
        var len=lines.length;
        var lastX;

        //用于记录被按下的对象
        var pressedObj;   //当前左滑的对象
        var lastLeftObj; //上一个左滑的对象

        //用于记录按下的点
        var start;
        //网页在移动端运行时的监听
        for(var i=0;i<len;i++) {
            lines[i].addEventListener('touchstart',function(e){
                lastX=e.changedTouches[0].pageX;  //触发事件时的位置
                pressedObj=this; //记录被按下的对象
                //记录开始按下时的点
                var touches=event.touches[0];  //获取触到屏幕时初始点的位置
                start={
                    x:touches.pageX,  //横坐标
                    y:touches.pageY    //纵坐标
                }
            });

            //计算滑动过程中X和Y的变化量
            lines[i].addEventListener('touchmove',function(e){
                var touches=event.touches[0];
                console.log('sss');
                delta={
                    x:touches.pageX-start.x,
                    y:touches.pageY-start.y
                };
                //横向位移大于纵向位移，阻止纵向滚动
                if(Math.abs(delta.x) > Math.abs(delta.y)){
                    event.preventDefault();
                }
            });

            lines[i].addEventListener('touchend',function(e){
                if(lastLeftObj && pressedObj != lastLeftObj){   //点击除当前左滑对象之外的任意位置
                    $(lastLeftObj).animate({marginLeft:'0'},500);   //右滑
                    lastLeftObj=null; //清空上一个左滑的对象
                };
                var diffX=e.changedTouches[0].pageX-lastX;
                if(diffX<-150) {
                    $(pressedObj).animate({marginLeft:'-2rem'},500); //左滑
                    lastLeftObj && lastLeftObj != pressedObj &&
                    $(lastLeftObj).animate({marginLeft:"0"}, 500); // 已经左滑状态的按钮右滑
                    lastLeftObj = pressedObj; // 记录上一个左滑的对象
                } else if(diffX>150) {
                    if (pressedObj == lastLeftObj) {
                        $(pressedObj).animate({marginLeft:"0"}, 500); // 右滑
                        lastLeftObj = null; // 清空上一个左滑的对象
                    }
                }
            })
        }
    }
    scroll();

    //删除该商品
    $('.cart-foods-btn').on('click',function(){
        $(this).parents('.cart-foods-wrap').remove();
    })
});