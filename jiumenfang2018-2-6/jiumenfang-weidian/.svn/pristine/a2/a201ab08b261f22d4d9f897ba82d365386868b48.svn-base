<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="jiumenfang-web/WeChat/shopping/src/css/pay.css">

    <title>支付</title>
</head>
<body>
 <div class="wrap">
    <div class="contain">
        <!--订单列表-->
        <div class="pay-infoWrap">
            <ul class="pay-info">
                <li class="info-num clearFix">
                    <p class="pay-lay">订单号</p>
                    <p class="pay-iptWrap">
                        <input type="text" class="pay-ipt" value="${orders}">
                    </p>
                </li>
                <li class="info-num clearFix">
                    <p class="pay-lay">收货人</p>
                    <p class="pay-iptWrap user-ipt-name">
                        <input type="text" class="pay-ipt" placeholder="请输入收货人真实姓名" value="${address.address_name}" id="name">
                    </p>
                </li>
                <li class="info-num clearFix">
                    <p class="pay-lay">手机号</p>
                    <p class="pay-iptWrap user-ipt-tel">
                        <input type="text" class="pay-ipt" placeholder="请输入收货人手机号" value="${address.address_tel}" class="ss" id="tel">
                    </p>
                </li>
            </ul>
        </div>
        <div class="pay-addressWrap">
         <ul class="pay-address">
            <li class="info-num clearFix">
                <p class="site-name">所在地</p>
                <div id="province" style="position: relative;top: -0.1rem;">
                    <select id="a" style="width: 84px;height: 25px"></select>
                	<select id="b" style="width: 84px;height: 25px"></select>
                	<select id="c" style="width: 84px;height: 25px"></select> 
                </div>
            </li>
            <li class="info-num">
                <div class="user-address clearFix">
                    <p class="detailed-address">详细地址：</p>
                    <input type="text" value="${address.address}" id="address" placeholder="请输入门牌号">
                </div>
            </li>
        </ul>
        </div>
        <div class="clear"></div>
        <c:forEach items="${list}" var="aa" >
	        <div class="foods-list">
	            <div class="foods-list-item clearFix">
	            	<input type="hidden" value="${aa.com_id}" class="comIds">
	                <div class="foods-item-img">
	                    <img src="${aa.com_img }" alt="">
	                </div>
	                <div class="foods-item-name">
	                    <p class="item-name">${aa.com_name}</p>
	                    <p class="item-number">50g*5</p>
	                    <p class="item-old"><i class="fa fa-rmb">28.9</i></p>
	                    <p class="item-new"><i class="fa fa-rmb">${aa.com_price}</i></p>
	                </div>
	                <div class="foods-item-num">
	                    X<span class="ssss">${aa.shop_num}</span>
	                </div>
	            </div>
	        </div>
        </c:forEach>
		<div style="height: 3rem"></div>

    </div>
            <!--底部支付-->
        <div class="footer clearFix">
            <div class="footer-paid-name">
                <span>应付总额:</span>
                <i class="fa fa-rmb">${order_price}</i>
            </div>
            <div class="footer-paid-btn">
                <div class="paid-btn">
                    立即支付
                </div>
            </div>
        </div>
 </div>
</body>
<script src="jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="jiumenfang-web/publicJs/jquery.provincesCity.js"></script>
<script src="jiumenfang-web/publicJs/provincesData.js"></script>
<script src="jiumenfang-web/WeChat/shopping/src/js/order.js"></script>
<script src="jiumenfang-web/WeChat/shopping/src/js/pay.js"></script>
<script type="text/javascript">

//回显列表收货地址
 window.onload=function(){
	$.ajax({
		url:"xiala.do",
		type:"post",
		success:function(msg){
			 if(msg.city!=null){
				    $("#a").append($("<option id='a1' selected='selected'>"+msg.city+"</option>"));
					$("#b").append($("<option id='a2' selected='selected'>"+msg.district+"</option>"));
					$("#c").append($("<option id='a3' selected='selected'>"+msg.area+"</option>"));
			 }
		}
	}); 
} 
    //支付
	function pay(){
			var city = $('#a').val();
			var district = $('#b').val();
			var area = $('#c').val();
			var address = $('#address').val();
			var order_price = ${order_price}; 
			var address_name = $('#name').val(); 
			var address_tel = $('#tel').val();
			var orders = '${orders}'; 
			var com_id = "";
			var order_price = "${order_price}";
			var abc = "${abc}";
			$(".comIds").each(function(){
				com_id += ','+$(this).val();
			});
			com_id = com_id.substring(1);
			if(abc==1&&abc=="1"){
				var shop_numtt=$('.ssss').html();
				location="goingby.do?city="+city+"&&"+"district="+district+"&&"+"area="+area+"&&"+"address="+address+"&&"+"address_name="+address_name+"&&"+"address_tel="+address_tel+"&&"+"orders="+orders+"&&"+"comid="+com_id+"&&"+"order_price="+order_price+"&&"+"abc="+abc+"&&"+"shop_numtt="+shop_numtt;   
			}else{
				location="goingby.do?city="+city+"&&"+"district="+district+"&&"+"area="+area+"&&"+"address="+address+"&&"+"address_name="+address_name+"&&"+"address_tel="+address_tel+"&&"+"orders="+orders+"&&"+"comid="+com_id+"&&"+"order_price="+order_price+"&&"+"abc="+abc;   
			}
	}
</script>
</html>