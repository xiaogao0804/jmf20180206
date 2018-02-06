<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/stockupInfo.css">
    <meta http-equiv="refresh" content="600">
    <title>出货</title>
</head>
<body>
   <div class="stockupInfo-contain">
       <div class="receiving-header">
           <i class="fa fa-angle-left fa-3x"></i>
           <span>任务详情</span>
       </div>
       <div class="stockUp-name clearFix">
           <form action="">
               <span>发货人</span>
               <select name="user_id" id="user_id">
                   <option disabled="disabled" selected="selected">--请选择--</option>
               </select>
           </form>
            <button class="stock-btn b">确定</button>
       </div>
       <div class="stockUp-con">
       		<div class="stockUp-con">
       <input type="hidden" value="${rep.orders_id }" id="orders_id">
          <table>
              <tr>
                  <td>出货单号</td>
                  <td>${rep.order_num }</td>
              </tr>
              <tr>
                  <td>渠道类型</td>
                  <td>${rep.chan_name }</td>
              </tr>
              <tr>
                  <td>运行方式</td>
                  <td>${rep.tran_name }</td>
              </tr>
              <tr>
                  <td>收件姓名</td>
                  <td>${rep.client_name }</td>
              </tr>
              <tr>
                  <td>收件地址</td>
                  <td>${rep.address_name }</td>
              </tr>
          </table>
       </div>
         <c:forEach items="${list }" var="d">
       <div class="stockUp-con">
           <table>
               <tr>
                   <td>产品批号</td>
                   <td colspan="3">${d.rep_enters }</td>
               </tr>
               <tr>
                   <td>产品名称</td>
                   <td colspan="3">${d.bar_message }</td>
               </tr>
               <tr>
                   <td>备货数量</td>
                   <td>${d.out_num }</td>
                   <td style="width:1.5rem">库位</td>
                   <td>${d.shelf_type }</td>
               </tr>
           </table>
       </div>
        </c:forEach>
       </div>
   </div>
</body>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script>
    //获取高度
    var winHeight = window.innerHeight;
    window.addEventListener('resize', function(event){
        winHeight = window.innerHeight;
        console.log(winHeight);
    });
    $('.stockupInfo-contain').height(winHeight);

    //返回上一页
    $('.receiving-header i').on('click',function(){
        window.history.back();
    });
	$(function(){
		$.ajax({
			url:"selectUser.do",
			type:"post",
			dataType:"json",
			success:function(msg){
				for(var i in msg){
					$("#user_id").append("<option value='"+msg[i].user_id+"'>"+msg[i].user_name+"</option>");
				}
			}
			
		});
		$(".b").click(function(){
			var user_id=$("#user_id").val();
			var order_id=$("#orders_id").val();
			location="c.do?user_id="+user_id+"&&"+"order_id="+order_id;
		});
	});    
</script>
</html>