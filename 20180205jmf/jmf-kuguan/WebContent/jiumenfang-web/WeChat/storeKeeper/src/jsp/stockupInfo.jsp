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
           <span>出货详情</span>
       </div>
       <div class="stockUp-name clearFix">
            <p class="stock-name">备货人 <span class="user_id" id="${user.user_id }">${user.user_name }</span></p>
            <button class="stock-btn" id="btn">备货完成</button>
       </div>
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
           			<td><input type="hidden" value="${d.rep_id }" class="f"></td>
           		</tr>
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
                   <td class="s">${d.out_num }</td>
                   <td style="width:1.5rem">库位</td>
                   <td>${d.shelf_type }</td>
               </tr>
           </table>
       </div>
        </c:forEach>
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
    //unction({}))
    	$("#btn").click(function(){
    		var rep_ids="";
    		$(".f").each(function(){
    			rep_ids+=","+$(this).val();
    		});
    		var out_nums="";
    		$(".s").each(function(){
    			out_nums+=","+$(this).html();
    		});
    		rep_ids=rep_ids.substring(1);
    		out_nums=out_nums.substring(1);
    		var user_id = $(".user_id").attr("id");
    		var order_id=$("#orders_id").val();
    		location="a.do?order_id="+order_id+"&&"+"out_nums="+out_nums+"&&"+"rep_ids="+rep_ids+"&&"+"user_id="+user_id;
    	});
</script>
</html>