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
             <div style="width:700px;margin:100px auto">
                   <p style="font-size:22px">
                                                      账号：<input type="text" id="admin_name">
                          <span id="ts"></span>	
                   </p>
                   <p  style="font-size:22px;margin-top:20px;">
                                                      密码：<input type="text" id="admin_pwd">
                   </p>
                   <p  style="font-size:22px;margin:20px 80px;">
	                   <a href="javascript:history.go(-1)"><input type="button" value="返回" style="cursor:pointer"></a>　　
		               <input type="button" value="提交" style="cursor:pointer">
                   </p>
	               
            </div>		              	
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
         
         
         $(":button[value='提交']").click(function(){
        	 var admin_name = null;
        	 admin_name = admin_name=null?"":$("#admin_name").val();
        	 
        	 var admin_pwd = null;
        	 admin_pwd = admin_pwd=null?"":$("#admin_pwd").val();
        	 
        $("#ts").empty();
        	 
        if(admin_name!=""&&admin_pwd!=""){
        	
        	$.ajax({
        		url:"addAdminUser.do",
         		type:"post",
         		data:{"admin_name":admin_name,"admin_pwd":admin_pwd},
         		dataType:"json",
         		success:function(msg){
         			if(msg==1){
						alert("恭喜您，注册成功！");
						location="allPwd.do";
					}else{
						alert("账号已存在！请从新输入！");
						location="addAdmin.do";
					}
         		}
        	 });
        	
        }else{
        	$("#ts").css("color","red").append("用户名或密码不能为空！");
        }	 
		
				
				
				
				
				
         });
         
         
</SCRIPT>
</html>