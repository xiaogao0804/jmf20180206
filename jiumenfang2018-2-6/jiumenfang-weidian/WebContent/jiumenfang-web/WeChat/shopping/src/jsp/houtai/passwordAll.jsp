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
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/css/orderInquiry.css">
</head>
<body>
    <div class="contain-inquiry">
        <div class="con-left">
            <div class="con-left-name"><h1>九门坊总后台</h1></div>
            <div class="con-left-list">
                <!--订单后台-->
                <div class="con-left-item">
                    <div class="con-admin">
                        <i class="fa fa-indent"></i>
                        <span>订单后台</span>
                    </div>
                    <ul class="con-admin-list">
                        <li class="order-inquiry">
                            <a href="orderInquiry2.do">订单查询</a>
                        </li>
                        <li class="order-edit">
                            <a href="orderEditAdmin.do">订单修改</a>
                        </li>
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
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>账号</th>
                    <th>密码</th>
                    <th>操作　
                    	<input type="button" value="注册">
                    </th>
                </tr>
                <c:forEach items="${list}" var="aa">
	                <tr>
	                    <td>${aa.admin_id}</td>
	                    <td id="admin_name">${aa.admin_name}</td>
	                    <td>${aa.admin_pwd}</td>
	                    <td style="width: 130px">
	                    	<input type="button" value="修改" id="${aa.admin_id}">
	                   	      　<input type="button" value="删除" id="${aa.admin_id}" name="${aa.admin_name}">
	                    </td>
	                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script src="<%=request.getContextPath() %>/jiumenfang-web/publicJs/laydate-v1.1/laydate/laydate.js"></script>
<script src="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/js/orderInquiry.js"></script>
<SCRIPT type="text/javascript">
         $(":button[value='注册']").click(function(){
        	 location="addAdmin.do";
         });
         
         $(":button[value='修改']").click(function(){
        	 var admin_id = $(this).attr("id");
        	 location="updateAdminPw.do?admin_id="+admin_id;
         });
         
         $(":button[value='删除']").click(function(){
        	 var admin_id = $(this).attr("id");
        	 var admin_name = $(this).attr("name");
        	 if(confirm("您确定要删除用户名为: "+admin_name+"  的账号么？")){
	 				$.ajax({
	 					url:"deleteAdmin.do",
	 					type:"post",
	 					data:{"admin_id":admin_id,"admin_name":admin_name},
	 					success:function(msg){
	 						alert("恭喜您删除成功！");
	 						location.replace(location.href);
	 					}
	 				});
        		 
        	 }
         });
         
         
         
</SCRIPT>
</html>