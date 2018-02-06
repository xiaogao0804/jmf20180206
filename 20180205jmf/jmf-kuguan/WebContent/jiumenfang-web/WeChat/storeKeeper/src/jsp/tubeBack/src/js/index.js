/**
 * Created by Administrator on 2017/8/29.
 */

//获取页面高度
let winHeight=$(document).height();
$('.contain').height(winHeight);

let headerHeight=$('.header').height();
let value=winHeight-headerHeight;

$('.con').height(value);

//隔行换色
/*function trColor(t){
	$(t).find('tr:even').css('background','#DFE9EB');
	$(t).find('tr:odd').css('background','#fff');
}
trColor('.rrr');
trColor('.s');
trColor('.ppp');
trColor('.eee');
trColor('.xxx');*/

//插入行
//库存
function addTr1(a){
	var	total=19;
	var	len=$(a).find('tr').length;
	for(var i=0;i<total-len;i++){
		if(len<total){
			$(a).append("<tr class='ttt'><td style='text-indent:30px;'></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		}else{
			break;
		}
	
	}	
}
addTr1('.rrr');
//订单
$(document).ready(function(){
	$('.aaaa').each(function(){
		var	total=19;
		var	len=$('.aaaa').find('tr').length;
		for(var i=0;i<total-len;i++){
			if(len<total){
				$('.aaaa').append("<tr><td style='text-indent:30px;'></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
			}else{
				break;
			}
			
		}	
	})
})




//盘点
function addTr3(a){
	var	total=19;
	var	len=$(a).find('tr').length;
	for(var i=0;i<total-len;i++){
		if(len<total){
			$(a).append("<tr><td style='text-indent:30px;'></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		}else{
			break;
		}
		
	}	
}
addTr3('.ppp');

//单据
//退换
function addTr4(a){
	var	total=11;
	var	len=$(a).find('tr').length;
	for(var i=0;i<total-len;i++){
		if(len<total){
			$(a).append("<tr><td style='text-indent:30px;'></td><td></td><td></td><td></td><td></td><td></td></tr>")
		}else{
			break;
		}
	
	}	
}
addTr4('.eee');

//退换
function addTr5(a){
	var	total=11;
	var	len=$(a).find('tr').length;
	for(var i=0;i<total-len;i++){
		if(len<total){
			$(a).append("<tr><td style='text-indent:30px;'></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		}else{
			break;
		}
		$(a).find('tr:even').css('background','#DFE9EB');
		$(a).find('tr:odd').css('background','#fff');
	}	
}
addTr5('.xxx');


function addTrn(a){
	var	total=16;
	var	len=$(a).find('tr').length;
	for(var i=0;i<total-len;i++){
		if(len<total){
			$(a).append("<tr><td style='text-indent:30px;'></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		}else{
			break;
		}
		$(a).find('tr:even').css('background','#fff');
		$(a).find('tr:odd').css('background','#DFE9EB');
	}	
}
addTrn('.ll');
/*//发货
$('.con-btn').on('click',function(){
    $(this).parent('.shipments-page').removeClass('select').addClass('noselect');
    $('.order-page').removeClass('noselect').addClass('select');
});*/

//生成订单
/*$('.order-btn').on('click',function(){
    $(this).parent('.order-page').removeClass('select').addClass('noselect');
    $('.shipments-page').removeClass('noselect').addClass('select');
});*/

//导航栏切换
/*$('.con-left li').on('click',function(){
    var index=$(this).index();
   // console.log(index);
    $(this).css({"backgroundColor":"#F7F8FD","color":"#FD6C6E"}).siblings().css({"backgroundColor":"","color":""});
    $('.page').eq(index).removeClass('noselect').addClass('select').siblings().removeClass('select').addClass('noselect');
});*/

//品名弹窗
$('.arrow').on('click',function(){
    $('.pop-up').slideToggle();
});

//城市联动
$('#province').ProvinceCity();

//是否生成订单

$('.order-btn').on('click',function(){
    var tel=$('.tel').val();
    var isMob = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    var isPhone = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
    var telValue = $.trim(tel);
        if($('.channel').find('option:selected').val()=='选择销售渠道'||$('.carriage').find('option:selected').val()=='选择运输方式'||$('.city').find('option:selected').val()=='选择城市'||$('.addressee-name').val()==""||$('.tel').val()==""||$('.prov').find('option:selected').val()=='请选择'||$('.area').val()==""){
            alert('请填写完整信息')
        }else if(isMob.test(telValue) || isPhone.test(telValue)){
            $(this).parent('.order-page').removeClass('select').addClass('noselect');
            $('.shipments-page').removeClass('noselect').addClass('select');
        }else{
            alert('请填写正确的手机号码');
        }
});
//时间控件
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: '2017-06-01 23:59:59', //设定最小日期为当前日期
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday:false,
    choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas; //将结束日的初始值设定为开始日
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

//

