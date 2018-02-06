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
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/stockUp.css">
    <meta http-equiv="refresh" content="600">
    <title>出货</title>
</head>
<body>
   <div class="stockUp-contain">
       <div class="receiving-header">
           <i class="fa fa-angle-left fa-3x"></i>
           <span>出货列表</span>
       </div>
       <div class="goods-date">
       <form action="stockUp.do" method="post">
       <input type="hidden" id="page" name="currentPage"/>
            <ul class="con-right-time clearFix" style="margin-left: 50px">
                <span class="laydate-txt">开始时间 </span>
                <input class="laydate-icon" id="start" name="start" value="${start }"/></br>
                <span class="laydate-txt">结束时间</span>
                <input class="laydate-icon" id="end" name="end" value="${end }"/>
                <span class="laydate-search">
                    <i class="fa fa-search"></i>
                    <input type="submit" value="查询">
                </span>
            </ul>
		</form>

       </div>
       <ul>
          <c:forEach items="${list }" var="s">
          	 <li class="clearFix c">
               <div class="goods-img">
                   <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/odd.png" alt="">
               </div>
                <input type="hidden" class="user_id" id="${s.user_id }">
               <div class="goods-info">
                     <p class="goods-info-odd order_id" id="${s.order_id }">${s.order_num }</p>
                     <p class="goods-info-num"> 出货数量${s.out_sum }</p>
               </div>
               <div class="goods-state">
                   <span class="s">${s.status_name }</span>
                   <i class="fa fa-angle-right"></i>
               </div>
           </li>
          </c:forEach>
           
       </ul>
       <table>
                     		<tr>
						    	<td colspan="11">
						    		第${page.currentPage}/${page.pageCount}页
						    		<input type="button" value="首页" onclick="fenye(1)">
						    		<input type="button" value="上一页" onclick="fenye(${page.previousPage})">
						    		<input type="button" value="下一页" onclick="fenye(${page.nextPage})">
						    		<input type="button" value="尾页" onclick="fenye(${page.pageCount})">
								</td>
						    </tr>
                     	</table>
   </div>
</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/laydate/laydate.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/js/stockUp.js"></script>
<script type="text/javascript">
function fenye(page){
	document.getElementById("page").value = page;
	document.forms[0].submit();
}
	$(function(){
		$(".c").each(function(){
			$(this).click(function(){
				var status_name=$(this).find('.s').html();
				if(status_name=='完成'){
				}else if(status_name=='未完成'){
				 var order_id = $(this).find(".order_id").attr("id");
					var user_id=$(this).find(".user_id").attr("id");
			location="toStockupInfo.do?order_id="+order_id+"&&"+"user_id="+user_id;
				}
			});
			
		});
	});
</script>
</html>