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
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/check.css">
    <meta http-equiv="refresh" content="1">
    <title>盘点</title>
</head>
<body>
   <div class="check-contain">
       <div class="receiving-header">
           <i class="fa fa-angle-left fa-3x"></i>
           <span>库位</span>
       </div>
       <ul class="storage-list clearFix ">
       <c:forEach items="${list }" var="s">
       	<input type="hidden" value="${s.shelf_id }" class="b">
       <li class="a" id="${s.s_id }">${s.shelf_type }</li>
       </c:forEach>
       </ul>
   </div>
</body>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/js/check.js"></script>
<script type="text/javascript">
				
					$(".a").click(function(){
						var s_id=$(this).attr("id");
						if(s_id==1){
							var shelf_type=$(this).html();
							location="productInfo.do?shelf_type="+shelf_type;
			       				
						}else{
							alert("该货架已盘点");
						}
				});
				
		
				
</script>
</html>