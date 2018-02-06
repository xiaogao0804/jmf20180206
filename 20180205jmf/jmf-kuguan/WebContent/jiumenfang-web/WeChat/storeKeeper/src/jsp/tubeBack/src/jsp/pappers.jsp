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
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/pandian.png" alt="">
                   </li>
                   <li id="d">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/danjuSelect.png" alt="">
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
               <div class="pappers-page page clearFix">
                   <div class="order-inquire clearFix">
                          <div class="goods-date">
				       <form action="chaDan.do" method="post">
				         <input type="hidden" id="page" name="currentPage"/>
				            <ul class="con-right-time clearFix" style="margin-left: 50px">
				                <span class="laydate-txt">开始时间 </span>
				                <input class="laydate-icon" id="start" name="start" value="${start }"/>
				                <span class="laydate-txt">结束时间</span>
				                <input class="laydate-icon" id="end" name="end" value="${end }"/>
				                <span class="laydate-search">
				                   
				                    <input type="submit" value="查询">
				                </span>
				            </ul>
						</form>
       			   </div>
                       <input  type="button" class="export-excel out" value="导出Excel">
                   </div>
                   <div class="order-list">
                       <table class="eee">
                           <tr>
                               <th style="text-indent:30px;">日期</th>
                               <th>标题</th>
                               <th>内容描述</th>
                               <th>库管</th>
                               <th>照片</th>
                               <th>操作</th>
                           </tr>
                           <c:forEach items="${list }" var="l">
                           		<tr>
                           			<td	style="text-indent:30px;"><input type="hidden" value="${l.upload_id }" class="upload_id"></td>
                           			<td>${l.uploadDate }</td>
                           			<td>${l.title }</td>
                           			<td>${l.area }</td>
                           			<td>${l.user_name }</td>
                           			<td class="a1${l.upload_id }">
                           			<c:forEach items="${list1 }" var="ll">
                           				<input type="image" class="m${l.upload_id }" value="${ll.path_id }" src="${ll.uploadPath }" width="100px;" height="100px;" onclick="closeShadeLayer();return false;">
                           				<%-- <img class="ss" id="${l.uploadPath }" alt="" src="${l.uploadPath }" style="height: 100px;width: 100px;"> --%>
                           				<div class="aa"></div>
                           			</c:forEach>
                           			</td>
                           			<td>
                           				<img class="sc" src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/aa.png">
                           			</td>
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
		$(".eee").find('tr:even').css('background','#DFE9EB');
		$(".eee").find('tr:odd').css('background','#fff');
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
			window.location.href="outExcel2.do";
		});
		
		$.ajax({
			url:"tu.do",
			type:"post",
			dataType:"json",
			success:function(msg){
				for(var i in msg){
					for(var s1 in msg[i]){
						var s2=".m"+msg[i][s1].upload_id;
							if(s2=1){
								$(".a1"+msg[i][s1].upload_id).append("<a href="+msg[i][s1].uploadPath+"><input type='image' class='ssssss' style='height: 100px;width: 100px;' value="+msg[i][s1].uploadPath+" src="+msg[i][s1].uploadPath+" onclick='tupian('+msg[i][s1].uploadPath+')'>'</a>");
								/* $(".ssssss").click(function(){
									var uploadPath=$(this).val();
									location="chaTupian.do?uploadPath="+uploadPath;
								}); */
							}	
					}
				}
			}
		});
	});
	$(".sc").each(function(){
		$(this).click(function(){
			var upload_id=$(this).parent('td').siblings('.upload_id').val();
			 $.ajax({
				url:"delectUpload.do",
				type:"post",
				data:{"upload_id":upload_id},
				success:function(msg){
					alert("删除成功");
					location.reload();
				}
			}); 
		});
		
	});
</script>
</html>