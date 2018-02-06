<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
     <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/css/login.css">
	<meta http-equiv="refresh" content="600">    
    <title>九门坊登陆</title>
</head>
<body>
	<div class="contain">
	<div class="login-contain">
         <div class="login-logo">
         	<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/logo.png"/>
         	<p class="logo-name">管理系统</p>	
         </div>
         <div class="login-ipt">
             <form action="" class="ipt-txt">
                 <span>账号</span>
                 <input type="text" placeholder="点击输入账号" name="user_name"><br>
                 <span>密码</span>
                 <input type="password" placeholder="点击输入密码" name="user_password">
             </form>
             <form action="" class="ipt-btn">
                 <input type="button" value="取消" class="btn-cancel" id="reset">
                 <input type="button" value="登入" class="btn-login" id="btn">
             </form>
         </div>
     </div>
	</div>
     
</body>
<script src="<%=request.getContextPath() %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
var	winHeight=$(window).height();
$('.contain').height(winHeight);
//sconsole.log($('body').height());
    		$("#reset").click(function(){
    			location="toHoutaiLogin.do";
    		});
    		$("#btn").click(function(){
    			$.ajax({
    				url:"houtaiLogin.do",
    				type:"post",
    				data:$("form").serialize(),
    				dataType:"json",
    				success:function(msg){
    					if(msg!=0){
    						location="stock.do";
    					}
    					else{
    						if(confirm("用户名或密码错误，是否返回重新登录")){
    							
							location="toHoutaiLogin.do";
    						}
    					}
    				}
    			});
    		});
    </script>
</html>