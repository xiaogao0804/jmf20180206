<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/info.css">
    <meta http-equiv="refresh" content="600">
    <title>信息列表</title>
</head>
<body>
    <div class="info-contain">
        <div class="info-header">
            <p class="info-header-name">${user_name }，你好</p>
            <input type="button" value="退出" class="zhuxiao">
        </div>
        <div class="info-list">
           <table>
               <tr border="1">
                   <td class="s">
                           <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/receiving.png" alt="">
                   </td>

               </tr>
               <tr>
                    <td class="d">
                           <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/order.png" alt="">
                   </td>
                    <td class="c">
                           <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/stockUp.png" alt="">
                   </td> 

               </tr>
               <tr>
                   <td class="p">
                           <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/check.png" alt="">
                   </td>
                   <td class="dz">
                           <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/camera.png" alt="">
                   </td>
                   <td class="t">
                           <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/sales.png" alt="" style="width:100%">
                   </td>
               </tr>
           </table>
        </div>
    </div>
</body>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	
		
	var per_id="${per_id}".split(",");
	var uid="${uid}";
		$(".s").click(function(){
				for(var i in per_id){
						if(per_id[i]==1){
							location="receiving.do";
						}
				}
		});
	/* 	$(".c").click(function(){
				for(var i in per_id){
						if(per_id[i]==1){
							location="stockUp.do";
						}
				}
		});
		$(".d").click(function(){
				for(var i in per_id){
						if(per_id[i]==2){
							location="order.do";
						}
				}
		}); */
			
		$(".p").click(function(){
				for(var i in per_id){
						if(per_id[i]==3&&uid==1){
							location="check.do";
						}
						else{
							alert("该权限没有开启");
							break;
						}
				}
		});
		$(".dz").click(function(){
				for(var i in per_id){
						if(per_id[i]==4){
							location="toPappers.do";
						}
				}
		});
		$(".t").click(function(){
				for(var i in per_id){
						if(per_id[i]==5){
							location="salesReturn.do";
						}
				}
		});
		$(".zhuxiao").click(function(){
			location="toLogin.do";
		});
</script>
</html>