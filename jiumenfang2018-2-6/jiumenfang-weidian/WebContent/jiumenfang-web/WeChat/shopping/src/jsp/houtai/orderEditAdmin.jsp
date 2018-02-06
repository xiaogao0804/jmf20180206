<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>九门坊管理后台</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/css/orderEdit.css">
</head>
<body>
    <div class="contain-edit">
        <div class="con-left">
            <div class="con-left-name">九门坊管理后台</div>
            <div class="con-left-list">
                <!--订单后台-->
                <div class="con-left-item">
                    <div class="con-admin">
                        <i class="fa fa-indent"></i>
                        <span>订单后台</span>
                    </div>
                    <ul class="con-admin-list">
                        <li class="order-inquiry">
                            <i class="fa fa-chevron-right"></i>
                            <a href="orderInquiry2.do">订单查询</a>
                        </li>
                        <li class="order-edit">订单修改</li>
                    </ul>
                </div>
                <!--账号管理-->
                <div class="con-left-item">
                    <div class="con-admin">
                        <span class="con-admin-name">账号管理</span>
                    </div>
                    <ul class="con-admin-list">
                       <li>
                            <i class="fa fa-chevron-right"></i>
                        	<a href="passwordResetAdmin.do">重置密码</a>
                        </li>
                        <li>
                        	<a href="allPwd.do">密码管理</a>
                        </li>
                        <li>
                        	<a href="zhuxiao.do">退出登录</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="con-right">
            <div class="order-edit-seek">
                <input type="text" placeholder="请输入订单号" value="${orders }" id="dingdan">
                <i class="fa fa-search"></i>
                <button onclick="chaxun()">查询</button>
            </div>
            
            
            
           		<div class="order-edit-noedit">
	                <div class="edit-wrap">
	                    <p class='edit-btn'>
	                        <img src="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/image/not-edit.png" alt="">
	                        <span>点击按钮进行编辑</span>
	                    </p>
	                </div>
	                
	                
	                <table border="1">
	                    <tr>
	                        <td>订单号</td>
	                        <td>商品信息</td>
	                        <td>价格</td>
	                        <td>邮寄地址</td>
	                        <td>收件人</td>
	                        <td>电话</td>
	                        <td>状态</td>
	                        <td>订单时间</td>
	                        <td>物流信息</td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <td>${aa.orders}</td>
	                        <td class="edit-td order_com">${aa.order_com}</td>
	                        <td class="edit-td order_price">${aa.order_price}</td>
	                        <td class="edit-td-address">
	                        	${aa.city} - ${aa.district} - ${aa.area} - ${aa.address}
	                        </td>
	                        <td class="edit-td address_name">${aa.address_name}</td>
	                        <td class="edit-td address_tel">${aa.address_tel}</td>
	                        <td class="edit-td edit-td-state">${aa.status}</td>
	                        <td>${aa.order_time}</td>
	                        <td class="edit-td logistics">${aa.logistics }</td>
	                    </tr>
	                </table>
	            </div>
	            
	            <div class="save-pop save-pop-hide">
	                  <p>确认要保存吗?</p>
	                  <div class="pop-btn">
	                      <button class="pop-cancel-btn">取消</button>
	                      <button class="pop-save-btn">保存</button>
	                  </div>
	            </div>
        </div>
    </div>
</body>
<script src="<%=request.getContextPath() %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/js/orderEdit.js"></script>
<script type="text/javascript">

function chaxun(){
	var orders = $("#dingdan").val();
	location = "orderEditAdmin.do?orders="+orders;
}



//编辑
var stateTxt="";
var addressTxt="";
$(document).on('click','.edit-btn',function(){
     $('.edit-td').css({'text-decoration':'underline','color':'red'}).attr('contenteditable','true');
    var txt=$('.edit-td-state').html();
    $('.edit-td-address').html('').append('<input type="text" value="${aa.city}" id="city"> -- <input type="text" value="${aa.district}" id="district"> -- <input type="text" value="${aa.area}" id="area"> -- <input type="text" value="${aa.address}" id="address">')
     $('.edit-td-state').html('').append('<select name="" class="state-btn" style="border: none;color:red;text-decoration: underline"><option value="已发货" style="" id="3">已发货</option><option value="未发货" id="2">未发货</option><option value="已退货" id="5">已退货</option><option value="已支付" id="6">已支付</option><option value="未支付" id="1">未支付</option><option value="退货中" id="4">退货中</option></select>');
     $('.edit-btn').remove();
    $('.edit-wrap').append('<p class="save-btn"><img src="<%=request.getContextPath()%>/jiumenfang-web/WeChat/backStage/src/image/edit.png" alt=""><span>编辑中，点击按钮保存</span></p>');

    $('.state-btn').change(function(){
        stateTxt=$(this).val();
      // console.log(stateTxt);
      
      
      $('option:checked').each(function(){
            var status_id=$(this).attr("id");
            var order_id = "${aa.order_id}";
            $.ajax({
            	url:"updateStarts.do",
        		type:"post",
        		data:{"status_id":status_id,"order_id":order_id},
        		success:function(msg){
        		}
            });
        });
      
      
    })
});


	//弹窗保存/取消按钮
	$('.pop-save-btn').on('click',function(){
	    $('.save-pop').css('display','none');
	    $('.edit-td').css({'text-decoration':'none','color':'#000'}).attr('contenteditable','false');
	    $('.edit-td-state').html(stateTxt);
	    $('.save-btn').remove();
	    $('.edit-wrap').append('<p class="edit-btn"><img src="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/image/not-edit.png" alt=""><span>点击按钮进行编辑</span></p>')
	    console.log(stateTxt);
	    
	    var city = $("#city").val();
	    var district = $("#district").val();
	    var area = $("#area").val();
	    var address = $("#address").val();
	    
	    addressTxt = city+' - '+district+' - '+area+' - '+address
	    $('.edit-td-address').html(addressTxt);
	    
	    var order_com = $(".order_com").html();
	    var order_price = $(".order_price").html();
	    var address_name = $(".address_name").html();
	    var address_tel = $(".address_tel").html();
	    var logistics = $(".logistics").html();
	    var openid = "${aa.openid}";
	    
	    $.ajax({
	    	url:"updateOrders.do",
    		type:"post",
    		data:{"city":city,"district":district,"area":area,"address":address,"order_com":order_com,"order_price":order_price,"address_name":address_name,"address_tel":address_tel,"logistics":logistics,"openid":openid},
    		success:function(msg){
				
    		}
	    });
	});



</script>
</html>