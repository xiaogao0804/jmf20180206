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
     <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/css/index.css">
    <meta http-equiv="refresh" content="600">
    <title>后台</title>
</head>
<body>
  <div class="contain">
	<div class="header clearFix">
           <div class="header-left">
           		${user_name }你好</br>
          		 <input type="button" value="退 出" class="zhuxiao">
       		</div>
       		 <ul class="header-right clearFix">
				<li class="zhanghao">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/zhanghao.png" alt="">
				</li>

				<li>
					<a href="">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/cangkuSelect.png" alt="">
					</a>
				</li>
				<li>
					<a href="">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/xiaoshou.png" alt="">
					</a>
				</li>
				<li>
					<a href="">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/caiwu.png" alt="">
					</a>
				</li>
				<li>
					<a href="">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/shenpi.png" alt="">
					</a>
				</li>
        	</ul>
	 	</div>
       <div class="con clearFix">
           	<div class="con-left">
               <ul>
                   <li id="k">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/kucun.png" alt="">
                   </li>
                   <li id="c">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/dingdan.png" alt="">
                   </li>
                   <li id="p">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/pandianSelect.png" alt="">
                   </li>
                   <li id="d">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/danju.png" alt="">
                   </li>
                   <li id="t">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/tuihuan.png" alt="">
                   </li>
                 <%--   <li>
                       <a href="cha.do">
                       		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/quanxian.png" alt="">
                       </a>
                   </li> --%>
               </ul>
           </div>
           <div class="con-right clearFix">
               <div class="check-page page clearFix">
                   <div class="order-inquire clearFix">
                       <div class="goods-date">
				       <form action="pan.do" method="post">
				       <input type="hidden" id="page" name="currentPage"/>
				            <ul class="con-right-time clearFix" style="margin-left: 50px">
				                <span class="laydate-txt">开始时间 </span>
				                <input class="laydate-icon" id="start" name="start" value="${start }"/>
				                <span class="laydate-txt">结束时间</span>
				                <input class="laydate-icon" id="end" name="end" value="${end }"/>
				                <span class="laydate-search">
				                    <input type="submit" value="查询">
				                </span>
								<span class="laydate-open">
				                    <input type="submit" value="开启" class="kq">
				                </span>
				            </ul>
						</form>

       			   </div>
                       <input  type="button" class="export-excel out" value="导出Excel">
                   </div>
                   <div class="order-list">
                       <table class="ppp">
                           <tr>
                               <th>日期</th>
                               <th>库位</th>
                               <th>入库批次</th>
                               <th>产品名称</th>
                               <th>结存</th>
                               <th>实盘数</th>
                               <th>盘点人</th>
                           </tr>
                           <c:forEach items="${list }" var="l">
                           	<tr>
                           		<td style="text-indent:30px;">${l.p_date }</td>
                           		<td>${l.shelf_type }</td>
                           		<td>${l.rep_enter }</td>
                           		<td>${l.bar_message }</td>
                           		<td>${l.rep_end }</td>
                           		<td>${l.number_num }</td>
                           		<td>${l.user_name }</td>
                           		<td>${l.bz_name }</td>
                           		
                           	</tr>
                           </c:forEach>
							          	                           	                          	                           	
                       </table>
                         <table class="page-num">
                     		<tr>
						    	<td colspan="11">
						    		<span>第${page.currentPage}/${page.pageCount}页</span>
						    		<input type="button" value="首页" onclick="fenye(1)">
						    		<input type="button" value="上一页" onclick="fenye(${page.previousPage})">
						    		<input type="button" value="下一页" onclick="fenye(${page.nextPage})">
						    		<input type="button" value="尾页" onclick="fenye(${page.pageCount})">
								</td>
						    </tr>
                     	</table>
                   </div>
               </div>
           </div>
       </div>
   </div>
</body>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/laydate/laydate.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery.provincesCity.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/provincesData.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/js/index.js"></script>
<script type="text/javascript">
$(".kq").click(function(){
	$.ajax({
		url:"kq.do",
		type:"post",
		success:function(msg){
			alert("开启成功");
		}
	});
	
});
$(".zhuxiao").click(function(){
	location="toHoutaiLogin.do";
});
function fenye(page){
	document.getElementById("page").value = page;
	document.forms[0].submit();
}
	$(function(){
		var user_id="${user_id}";
		$(".zhanghao").click(function(){
			if(user_id==1){
				
			location="cha.do";
			}else{
				alert("对不起，您没有访问该页面的权限");
			}
			
		});
		$(".ppp").find('tr:even').css('background','#DFE9EB');
		$(".ppp").find('tr:odd').css('background','#fff');
		var per_hid="${per_hid}".split(",");
		$("#k").click(function(){
			for(var i in per_hid){
				if(per_hid[i]==1){
					location="stock.do";
				}
			}
			
		});
		$("#c").click(function(){
			for(var i in per_hid){
				if(per_hid[i]==2){
					location="chu.do";
				}
			}
			
		});
		$("#p").click(function(){
			for(var i in per_hid){
				if(per_hid[i]==3){
					location="pan.do";
				}
			}
			
		});
		$("#d").click(function(){
			for(var i in per_hid){
				if(per_hid[i]==4){
					location="chaDan.do";
				}
			}
			
		});
		$("#t").click(function(){
			for(var i in per_hid){
				if(per_hid[i]==5){
					location="chaTui.do";
				}
			}
			
		});
$(".out").click(function(){
			
	window.location.href="outExcel1.do";
		});
	});
</script>
</html>