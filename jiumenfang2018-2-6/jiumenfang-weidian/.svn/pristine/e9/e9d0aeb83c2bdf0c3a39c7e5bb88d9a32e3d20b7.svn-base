<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>九门坊管理后台</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/publicCss/reset.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/css/index.css">
    
</head>
<body>
    <div class="contain clearFix">
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
                        <li>
                            <i class="fa fa-chevron-right"></i>
                            订单查询
                        </li>
                        <li>订单修改</li>
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
                            密码重置
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="con-right">
            <div class="con-right-name">
                欢迎登陆九门管理后台
            </div>
            <div class="con-right-login">
            
                <form>
                    账号:&nbsp;
                    <input type="text" placeholder="点击输入账号" class="user-account" id="user-account" name="admin_name"><br><br>
                    密码:&nbsp;
                    <input type="password" placeholder="点击输入密码" class="user-password" id="user-password" name="admin_pwd">
                </form>
                
                <p class="con-right-btn">
                    <input type="button" value="取消" class="cancel-btn" id="cancel-btn">
                    <input type="button" value="登陆" class="confirm-btn" id="login">
                </p>
                <div id="div"></div>
            </div>
        </div>
    </div>
</body>
<script src="<%=request.getContextPath() %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/js/index.js"></script>

<script type="text/javascript">

	$("#login").click(function(){
		$("#div").empty();
			$.ajax({
				url:"login.do",
				type:"post",
				data:$("form").serialize(),
				dataType:"json",
				success:function(msg){
						if(msg==1){
							location="orderInquiry2.do";
						}else if(msg!=0){
							location="orderInquiry.do";
						}else{
							$("#div").append("<span style='color: red'>对不起！用户名或密码错误!</span>");
						}
				}
			});
		});
</script>
</html>