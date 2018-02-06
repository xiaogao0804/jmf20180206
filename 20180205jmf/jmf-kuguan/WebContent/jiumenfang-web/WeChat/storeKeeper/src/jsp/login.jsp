<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/login.css">
    <meta http-equiv="refresh" content="600">
    <title>库管登陆</title>
</head>
<body>
	<form>
    <div class="contain">
          <div class="logo">
              <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/logo.png" alt="">
              <p class="logo-name">管理系统</p>
          </div>
          <div class="login">
              <div class="user-account clearFix">
                  <div class="account-wrap">
                      <div class="account-img">账号</div>
                      <div class="account-ipt">
                          <input type="text" placeholder="请输入账号" name="user_name">
                      </div>
                  </div>
                  <div class="clear"></div>
                  <div class="pwd-wrap">
                      <div class="pwd-img">密码</div>
                      <div class="pwd-ipt">
                          <input type="password" placeholder="请输入密码" name="user_password">
                      </div>
                  </div>
                  <div	class="clear"></div>
                  <div class="submit-btn" id="sub">
                      <input type="button" value="取消"	class="cancel">
                      <input type="button" value="登入"	class="dengru">
                  </div>

              </div>
          </div>
    </div>
    </form>
</body>
<script src="<%=request.getContextPath() %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/js/login.js"></script>
<script type="text/javascript">
		$(".dengru").click(function(){
			$(".clear").empty();
				$.ajax({
					url:"login.do",
					type:"post",
					data:$("form").serialize(),
					dataType:"json",
					success:function(msg){
							if(msg!=0){
								window.location.href="info.do";
							} 
							else{
								$(".clear").append("<span style='color: red'>对不起！用户名或密码错误!</span>");
								location="toLogin.do";
							}
					}
				});
			});
		$(".cancel").click(function(){
			location="toLogin.do";
		});
	
</script>
</html>