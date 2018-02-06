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
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/css/passwordReset.css">
</head>
<body>
    <div class="contain-reset">
        <div class="con-left">
            <div class="con-left-name">九门坊管理后台</div>
            <div class="con-left-list">
                <!--订单后台-->
                <div class="con-left-item">
                    <div class="con-admin">
                        <i class="fa fa-indent"></i>
                        <span>订单后台</span>
                    </div>
                    <ul class="con-admin-list">
                        <li class="order-inquiry">
                            <i class="fa fa-chevron-right"></i>
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
             <div class="passWord-ipts">
                 <p class="password-p1">
                     原密码：<input type="password" placeholder="点击输入原密码" id="password">
                 </p>
                <p class="password-p2">
                    新密码：<input type="password" placeholder="点击输入新密码" class="password1">
                           <span class="password-disaccord">两次密码不一致</span>
                </p>
                 <p class="password-p3">
                     新密码：<input type="password" placeholder="重复输入新密码" class="password2">
                            <span class="password-disaccord">两次密码不一致</span>
                 </p>
                  <button class="password-cancel">取消</button>
                  <button class="password-submit" id="tj">提交</button>
             </div>
        </div>
    </div>
</body>
<script src="<%=request.getContextPath() %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/js/passwordReset.js"></script>
<script type="text/javascript">
	$("#tj").click(function(){
		var admin_id = ${admin_id};
		var password = $("#password").val();
		var password1 = $(".password1").val();
		var password2 = $(".password2").val();
		if(password1==password2&&password1!=null){
			$.ajax({
				url:"updatePwd.do",
				type:"post",
				dateType:"json",
				data:{"admin_id":admin_id,"password":password,"password1":password1},
				success:function(msg){
					if(msg==0){
						alert("恭喜您，修改密码成功！请从新登陆！");
						location="goindex.do";
					}else{
						alert("原密码输入错误！请从新输入！");
						location="passwordReset.do";
					}
				}
			});
		}
		
		
	});
</script>
</html>