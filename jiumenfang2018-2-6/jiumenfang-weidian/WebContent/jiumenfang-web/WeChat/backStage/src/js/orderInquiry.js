/**
 * Created by Administrator on 2017/7/19.
 */
//高度设置
let conHeight=$(window).height();
//console.log(conHeight);
$('.contain-inquiry').height(conHeight);

//时间控件
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: '2017-06-01 23:59:59', //设定最小日期为当前日期
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: laydate.now(),
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(start);
laydate(end);


//计算总收入
var priceArr=[];
var total=0;
$('.td-price').each(function(){
    let price=parseFloat($(this).html());
      priceArr.push(price);
});
console.log(priceArr);
priceArr.forEach(function(item){
    total=total+item;
});
//console.log(total);
$('.con-ipt-rmb').val(total.toFixed(2));

