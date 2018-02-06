<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="jiumenfang-web/WeChat/shopping/src/css/myOrder.css">
    <title>我的订单</title>
</head>
<body>
   <div class="wrap">
           <div class="wwww"></div>
           <!--<div class="header">
               <i class="fa fa-long-arrow-left fa-2x"></i>
               <span>我的订单</span>
               <i class="fa fa-remove"></i>
           </div>-->
           <!--订单详情-->
           <!--已支付订单-->
       <div class="contain">
        <c:forEach items="${list}" var="aa">
           <div class="con-list-wrap" id="${aa.order_id}">
               <div class="con-list">
                   <div class="con-list-item clearFix" style="border-bottom: 1px dashed #e7e7e7;">
                       <div class="item-num">
                           订单号：
                       </div>
                       <div class="item-order">
                           <span class="item-num-time" id="${aa.orders}">${aa.orders}</span>
                       </div>
                   </div>
<%--                    <div class="con-list-item item-opa clearFix">
                       <div class="item-num item-items">
                          ${aa.order_com}
                          ${aa.order_com}
                       </div>
                       <div class="item-shu">
                          
                       </div>
                   </div> --%>
                    <div class="con-list-item item-opa clearFix" style="border-bottom: 1px solid #e7e7e7;">
                       <div class="item-num item-items">
                           ${aa.order_com}
                       </div>
                    <!--    <div class="item-shu">
                           X1
                       </div> -->
                   </div> 
					
                   <div class="con-list-item clearFix" style="padding-top: 0.5rem">
                       <div class="goods-name">收货地址</div>
                   </div>
                   <div class="con-list-item clearFix">
                           <div class="recipient">${aa.xingming }</div>
                           <div class="tel">${aa.dianhua }</div>

                   </div>
                   <div class="con-list-item clearFix" style="border-bottom: 1px solid #e7e7e7;font-size: 0.32rem;">
                           ${aa.sheng } , ${aa.shi } , ${aa.qu } , ${aa.dizhi }
                   </div>
                   <div class="con-list-item item-opa clearFix" style="border-bottom: 1px solid #e7e7e7;font-weight: bold">
                       <div class="item-num item-items">
                           订单金额
                       </div>
                       <div class="item-shu">
                           <i class="fa fa-rmb order_price" id="${aa.order_price}">${aa.order_price}</i>
                       </div>
                   </div>
                   <!--已完成-->
                   <div class="con-list-item clearFix" style="padding-top:0.5rem;">
                       <div class="recipient" style="font-size: 0.32rem;">物流信息</div >
                       <div class="tel" style="font-size: 0.32rem;">${aa.logistics}</div>
                   </div>
                   <div class="con-list-item clearFix">
                       <div class="recipient" style="font-size: 0.32rem;">订单编号</div >
                       <div class="tel" style="font-size: 0.32rem;">${aa.order_num}</div>
                   </div>
                   <div class="con-list-item clearFix">
                       <div class="recipient" style="font-size: 0.32rem;">下单时间</div >
                       <div class="tel" style="font-size: 0.32rem;">${aa.order_time}</div>
                   </div>
                   <div class="con-list-item clearFix" style="padding-top: 0.5rem;">
                       <div class="recipient" style="font-weight:bold;padding-top: 0.1rem">订单状态：<span class="status">${aa.status}</span></div>
                       <div class="return-money-div"></div>
                   </div>
                   <!--已发货-->
                 <!--  <div class="con-list-item clearFix" style="padding-top:0.5rem;">
                       <div class="recipient" style="font-size: 0.32rem;">物流信息</div >
                       <div class="tel" style="font-size: 0.32rem;">天天快递</div>
                   </div>
                   <div class="con-list-item clearFix">
                       <div class="recipient" style="font-size: 0.32rem;">订单编号</div >
                       <div class="tel" style="font-size: 0.32rem;">8888888888888</div>
                   </div>
                   <div class="con-list-item clearFix">
                       <div class="recipient" style="font-size: 0.32rem;">下单时间</div >
                       <div class="tel" style="font-size: 0.32rem;">2018-01-02 10:40</div>
                   </div>
                   <div class="con-list-item clearFix" style="padding-top: 0.5rem;">
                       <div class="recipient" style="font-weight:bold;padding-top: 0.1rem">订单状态：已发货</div>
                       <div class="return-money">退款</div>
                   </div>-->
               </div>
           </div>
       </c:forEach>
           <!--已发货订单-->
           <!--弹窗-->
           <!--<div class="mask-pop">
               <div class="pop-info clearFix">
                   <p class="pop-txt">亲，您确定选择退货吗？</p>
                   <p class="pop-cancel">取消</p>
                   <p class="pop-confirm">确定</p>
               </div>
              &lt;!&ndash; <div class="pop-del">
                   <i class="fa fa-remove fa-2x"></i>
               </div>&ndash;&gt;
           </div>-->
          <!-- 物流信息弹窗-->
           <!--<div class="mask-pop-logistics">
               <div class="pop-info clearFix">
                   <p class="pop-txt">单号:1111111</p>
                   <p class="pop-cancel">物流:jjjj</p>
                   <p class="pop-confirm"></p>
               </div>
                <div class="pop-del">
                    <i class="fa fa-remove fa-2x"></i>
                </div>
           </div>-->
       </div>
   </div>
</body>
<script src="jiumenfang-web/publicJs/zepto.js"></script>
<script src="jiumenfang-web/WeChat/shopping/src/js/order.js"></script>
<script type="text/javascript">
 	$(function(){
					$(".wwww").empty();
					var id = $(this).parents(".con-list-wrap").attr("id");
					if(id==""||id==null){
						$(".wwww").append("<div class='not-order' style='position: absolute;top:30%;left:50%;transform: translateX(-50%);color: #000;opacity:0.9;'>还没有订单哦~</div>");
					}
				
					$(".con-list-wrap").each(function(){
						var status = $(this).find(".status").html();
					 	if(status=="未发货"){
							$(this).find(".return-money-div").append("<p class='return-money tuikuan' style='cursor:pointer'>退款</p>");
						}else if(status=="未支付"){
							$(this).find(".return-money-div").append("<p class='return-money zhifu' style='cursor:pointer'>支付</p>");
						}else if(status=="已发货"){
							$(this).find(".return-money-div").append("<p class='return-money tuihuo' style='cursor:pointer'>退货</p>");
						} 
					});
	});
		//退款
		$(document).on("click",".tuikuan",function(){
			var order_id = $(this).parents(".con-list-wrap").attr("id");
			
			$.ajax({
				url:"tuikuan.do",
				type:"post",
				data:{"order_id":order_id},
				success:function(msg){
					if(msg==1){
						location.reload();
					}
				}
			});
		});	
		
		//支付
		$(document).on("click",".zhifu",function(){
			var order_id = $(this).parents(".con-list-wrap").attr("id");
			var order_price = $(this).parents(".con-list-wrap").find(".order_price").attr("id");
			var	orders = $(this).parents(".con-list-wrap").find(".item-num-time").attr("id");
			location="wxpay.do?order_id="+order_id+"&&"+"order_price="+order_price+"&&"+"orders="+orders;
		});	
		
		//退货
		$(document).on("click",".tuihuo",function(){
			var order_id = $(this).parents(".con-list-wrap").attr("id");
			//location="tuihuo.do？order_id="+order_id;
			$.ajax({
				url:"tuihuo.do",
				type:"post",
				data:{"order_id":order_id},
				success:function(msg){
					if(msg==1){
						location.reload();
					}
				}
			});
		});	
	
</script>
</html>