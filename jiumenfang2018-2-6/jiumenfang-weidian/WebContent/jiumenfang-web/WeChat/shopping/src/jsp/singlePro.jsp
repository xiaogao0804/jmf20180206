<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="jiumenfang-web/WeChat/shopping/src/css/singlePro.css">
    <link rel="stylesheet" href="jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="jiumenfang-web/publicCss/swiper.min.css">
    <title>商品详情</title>
</head>
<body>
<div class='box'>
	   <div class="wrap">
	       <div class="single-con">
	           <div class="single-banner swiper-container">
	               <div class="swiper-wrapper">
	               <!-- 后续轮播 -->
	               <c:forEach items="${dynamic }" var="dd">
	                    <div class="swiper-slide"> 
	                       <a href="#">
	                           <img src="${dd.dynamic_img}" alt="">
	                       </a>
	                   </div> 
	               </c:forEach>
	           </div>
	           <div style="height: 10px"></div>
	           </div>
	           <div	class="single-wrap">
	             <div class="single-info">
	             	<div class="single-infoin">
	             		<div class="single-in">
		             		<div class="single-price">
			                   <p class="info-name">
			                     <span>小酱仙&nbsp;&nbsp;&nbsp;${aa.com_name}</span>
			                   </p>
			                   <p class="num">【闪购买一送一】</p>
			             	</div>
			                <div class="single-activity">
			                   <p style="margin-bottom:1.9rem;">
			                      <span style="background-color:#ff4891;padding:0.8rem 0.8rem;color:#fff;">闪购价</span>
			                      <i class="fa fa-rmb" style="font-size:1.8rem;color:#ff4891;margin-left:1.9rem;">${aa.com_price}/瓶</i>
			                      <i class="fa fa-rmb" style="color:#000;opacity:0.5; filter:alpha(opacity=50);text-decoration:line-through;">28.5</i>
			                   </p>
			                   <p style="margin-bottom:1rem;">
								<span style="color:#000;opacity:0.6;filter:alpha(opacity=60);">包邮</span>			                   
			                   </p>
			                </div> 
	             		</div>	             	 
	             	</div>             
	           </div>
	            <div class="single-list">
	               <ul class="tab-nav clearFix">
	                   <li class="tab-nav-active">商品详情</li>
	                   <li style="float:right;">规格参数</li>
	                   <!--<li>商品评论</li>-->
	               </ul>
	               <ul class="tab-info clearFix">
	                   <li class="tab-info-active" style="text-align:center;">
	                		<img src="${aa.xiangqing_imga}" style="width:90%;margin-bottom:1.75rem;"/>
	                       <img src="${aa.xiangqing_imgb}"/>
	                   </li>
	                   <li class="format clearFix" style="width:90%;margin:0 auto;text-align:center;">
	                      <img src="${aa.guige_imga}" style="margin-bottom:1.5rem;"/>
	                      <img src="${aa.guige_imgb}"/>
	                   </li>
	                  <!-- <li>xxxxxxx</li>-->
	               </ul>
	           </div>
	           </div>
	       </div>
	           <div style="height: 1px"></div>
	       <div class="single-footer-wrap">
	           <div class="single-footer clearFix">
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	             	 <div class="shopping-bag">
	                  	<img src="jiumenfang-web/WeChat/shopping/src/image/shoppingBag.png"/>                    
	             	 </div>
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 
	             	 <div class="shopping-bag-add">
	                   	加入购物车
	              	 </div>
	       	         <div class="shopping-bag-settlement">
	                   	立刻购买
	              	 </div>
	           </div>
	           <!--加入购物车 ↓加了cart -->
	           <div class="shopping-popWrap-cart">
	          	 	<div class="shopping-mask-cart"></div>
		           	<div class="shopping-pop-cart clearFix">
		               <div class="pop-name">
		                   <img src="${aa.add_img}" alt="">
		               </div>
		               <div class="pop-num">
		               		<p class="pop-nam">${aa.com_name}</p>
		               		<div class="pop-num-nameWrap clearFix">
		               			 <p class="pop-num-name">数量:</>
			                    <div class="pop-change clearFix">
			                       <p class="pop-change-add">+</p>
			                       <p class="pop-change-num">1</p>
			                       <p class="pop-change-subtract">-</p>
			                    </div>
		               		</div>
		                   	<div class="pop-priceWrap clearFix">
		                   		<p class="pop-price-name">单价:</p>
			                    <p class="pop-price">
			                       ${aa.com_price}元/瓶
			                   	 </p>
		                   	</div>
		                   	<div class="pop-shipmentsWrap">
		                   		<p class="pop-shipments-name">预计发货：</p>
		                   		<p class="pop-shipments-time"></p>
		             		</div>
		               		<div class="pop-footer" onclick="shop()">确定</div>
		          	 </div>
		           </div>
			 </div>
	     <!--立即购买-->
	        <div class="shopping-popWrap">
	         <div class="shopping-mask"></div>
	           	<div class="shopping-pop-cart clearFix">
	               <div class="pop-name">
	                   <img src="${aa.add_img}" alt="">
	               </div>
	               <div class="pop-num">
	               		<p class="pop-nam">${aa.com_name}</p>
	               		<div class="pop-num-nameWrap clearFix">
	               			 <p class="pop-num-name">数量:</>
		                    <div class="pop-change clearFix">
		                       <p class="pop-change-add">+</p>
		                       <p class="pop-change-num sss">1</p>
		                       <p class="pop-change-subtract">-</p>
		                   </div>
	               		</div>
	                   	<div class="pop-priceWrap clearFix">
	                   		<p class="pop-price-name">单价:</p>
		                    <p class="pop-price">
		                       ${aa.com_price}元/瓶
		                   	 </p>
	                   	</div>
	                   	<div class="pop-shipmentsWrap">
	                   		<p class="pop-shipments-name">预计发货：</p>
	                   		<p class="pop-shipments-time"></p>
	               </div>
	               <div class="pop-footer" onclick="by()">支付</div>
	          	 </div>
	           </div>
	      	 </div>
	       </div>
	  </div>
 </div>
</body>
<script src="jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="jiumenfang-web/publicJs/swiper.min.js"></script>
<script src="jiumenfang-web/WeChat/shopping/src/js/singlePro.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"findAllShopNum.do",
			type:"post",
			success:function(msg){
				if(msg==0){
					$(".shopping-bag").append("<span class='shopping-num'></span>");
				}else{
					$(".shopping-bag").append("<span class='shopping-num'>"+'+'+msg+"</span>");
				}
					var cartNum=msg;
					$('.shopping-pop-cart .pop-footer').on('click',function(){ 
					    let shoppingNum=parseInt($('.pop-change-num').html());
					     //console.log(shoppingNum);
					    let popNum=cartNum+shoppingNum;
					    cartNum=popNum;
					    console.log(popNum);
					    $('.shopping-num').html('+'+popNum);
					});
			}
		})
	});


	//加入购物车
	function shop(){
		var id = parseInt($('.pop-change-num').html());
		var com_id = ${aa.com_id};
		 $.ajax({
			url:"addshop.do",
			type:"post",
			data:{"com_id":com_id,"id":id},
			success:function(msg){
			}
		}); 
	};
	
	
	
	
	
	
		//支付
 	function by(){
			var ids = parseInt($('.sss').html());
			var com_price = '${aa.com_price}';
			var com_id = '${aa.com_id}';
			var com_name = '${aa.com_name}';
			var abc = "1";
			var order_prices = '${aa.com_price}'*ids; 
			var order_price = order_prices.toFixed(2); 
			location="togoingby.do?com_id="+com_id+"&&"+"com_name="+com_name+"&&"+"order_price="+order_price+"&&"+"shop_num="+ids+"&&"+"abc="+abc;
		}; 
		
		 var url=''; // 根据需要获取,JS,PHP,ASP等;
			function RandomNumber(){
			//获取随机数
			    var now=new Date();
			    var number = now.getSeconds() +(now.getMilliseconds()%43)*7/1.131412567;
			    if( number ==0){
			        number = now.getFullYear() + (now.getMilliseconds()%1.24377)*7/1.131412567;
			    }
			    return number;
			}		
			
		//查看购物车
		$(".shopping-bag").click(function(){
			location="findShopgouwu.do?number="+RandomNumber()
		});
</script>
</html>