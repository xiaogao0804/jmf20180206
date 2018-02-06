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
    <link rel="stylesheet" href="jiumenfang-web/WeChat/shopping/src/css/shoppingCart.css">
    <title>购物车</title>
</head>
<body>
  <div class="contain">
      <div class="cart-foods-list clearFix">
      	  <c:forEach items="${findCom}" var="aa">
         	 <div class="cart-foods-wrap">
		          <div class="cart-foods-normal" style="position: relative;">
		              <div class="cart-foods clearFix">
		                  <!--选择按钮-->
		                  <div class="checkbox">
		                      <i class="fa fa-circle-thin" style="display:none"></i>
		                      <i class="fa fa-check-circle" id="${aa.com_id}" style="display:block"></i> 
		                  </div> 
		                  
		                  <!--商品图片-->
		                  <img src="${aa.com_img}" alt="">
		                  <!--名称价格-->
		                  <div class="cart-foods-info">
		                      <p>${aa.com_name}</p>
		                      <p class="cart-foods-price">
		                          <i class="fa fa-rmb" id="${aa.com_price}">${aa.com_price}</i>
		                      </p>
		                  </div>
		                  <!--增减数量-->
		                  <div class="change-num clearFix">
		                      <p class="foods-subtract" id="${aa.com_id}">-</p>
		                      <p class="foods-num" >${aa.shop_num}</p>
		                      <p class="foods-add" id="${aa.com_id}">+</p>
		                  </div>
		              </div>
		              <div class="cart-foods-btn" id="${aa.com_id}" onclick="deleteShop(${aa.com_id})">
		                  <span>删除</span>
		              </div>
		          </div>
		      </div>
	      </c:forEach>
      </div>
      <div style="height: 100px"></div>
      <!--底部全选、结算-->
      <div class="cart-accounts clearFix">
         <div class="checkboxAll">
             <i class="fa fa-circle-thin" style="display:none"></i>
             <i class="fa fa-check-circle" style="display:block"></i>
             <span style="text-align: center;">全选</span>
         </div>
          <div class="priceAll">
              <p class="price">
                  合计:
                  <i class="fa fa-rmb aaa">0.00</i>
              </p>
              <p class="notCar">不含运费</p>
          </div>
          <div class="accounts">
              结算
          </div>
      </div>
      <div class="accounts-hint">
          <!-- <span class="account-hint-add">您还没有卡收到卡时间很多看撒谎购物车哦!</span>
          <span class="account-hint-select">您还没有选择小酱仙哦！</span> -->
      </div>
  </div>
</body>
<script src="jiumenfang-web/publicJs/zepto.js"></script>
<script src="jiumenfang-web/WeChat/shopping/src/js/shoppingCart.js"></script>
<script type="text/javascript">
$(function(){
	
	$(".accounts").click(function(){
		
	 if($(".checkbox .fa-check-circle").css('display')=="none"){
		 
			$('.account-hint-select').css('display','block').fadeOut(5000);
			
		}else if($(".cart-foods-btn").attr("id")==null){
			
			$('.account-hint-add').css('display','block').fadeOut(5000);
			  
		}else{			
			togoingby();			
		}
		 
	});
		
});
//删除
function deleteShop(aa){
	var com_id = aa;
	  $.ajax({
		url:"deleteShop.do",
		type:"post",
		data:{"com_id":com_id},
		success:function(msg){
		}
		
	});  
};

//减号
 $('.foods-subtract').each(function(){
     $(this).click(function(){
         var com_id = $(this).attr("id");
         var shop_num = parseFloat($(this).next('.foods-num').html()) - 1;
         $.ajax({
     		url:"plusminus.do",
     		type:"post",
     		data:{"com_id":com_id,"shop_num":shop_num},
     		success:function(msg){
     		}
     	});
     })
 })
 
 //加号
 $('.foods-add').each(function(){
     $(this).click(function(){
         var com_id = $(this).attr("id");
         var shop_num = parseFloat($(this).prev('.foods-num').html()) + 1;
         $.ajax({
     		url:"plusminus.do",
     		type:"post",
     		data:{"com_id":com_id,"shop_num":shop_num},
     		success:function(msg){
     		}
     	});  
     })
 })
	
	//结算
 function togoingby(){ 
				var order_prices = 0;
				var com_price = "";
				var shop_num = "";
				var shop_num1 = "";
				var com_id = "";
			        var arr=[];
			        $('.checkbox .fa-check-circle').each(function(){
			            if($(this).css('display')=="block"){
			            	com_price = $(this).parents(".checkbox").siblings(".cart-foods-info").find(".fa-rmb").attr("id");
			            	shop_num = $(this).parents(".checkbox").siblings(".change-num").find('.foods-num').html();
			            	order_prices += parseFloat(parseFloat(com_price)*parseFloat(shop_num));
			            	order_price = order_prices.toFixed(2); 
			                arr.push($(this));
			                com_id += ','+$(this).attr("id");
			            }
			        });
			        com_id = com_id.substring(1);
		location="togoingby.do?order_price="+order_price+"&&"+"com_id="+com_id+"&&"+"shop_num="+shop_num;
 } 
 
</script>
</html>