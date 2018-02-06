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
				<li>
					<a href="">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/zhanghaoSelect.png" alt="">
					</a>
				</li>

				<li class="cangku">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/cangku.png" alt="">
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
                  <%--  <li id="k">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/kucun.png" alt="">
                   </li>
                   <li id="c">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/dingdan.png" alt="">
                   </li>
                   <li id="p">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/pandian.png" alt="">
                   </li>
                   <li id="d">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/danju.png" alt="">
                   </li>
                   <li id="t">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/tuihuan.png" alt="">
                   </li>
                   <li>
                       <a href="cha.do">
                       		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/quanxian.png" alt="">
                       </a>
                   </li> --%>
               </ul> 
           </div>
           <div class="con-right clearFix">
               <div class="permission-page page clearFix">
                    <div class="establish-top clearFix">
                        <div class="establish-ipt">
                            <form>
                                <lable>创建账号</lable>
                                <input type="text" name="user_name" class="name"> 
                                <span id="user_name" style="color: #ff0000"></span>
                                <lable>创建密码</lable>
                                <input type="text" name="user_password" class="password">
                            </form>
                             <input type="button" value="创建" class="establish-btn btn">
                        </div>
                        <div class="clear"></div>
                        <div class="establish-sle clearFix">
                            <div class="sle-left">
                                <p class="sle-left-name">手机</p>
                                <div class="sle-left-con clearFix">
                                    <div class="k"></div>
                                </div>
                            </div>
                            <div class="clear"></div>
                            <div class="sle-right">
                                <p class="sle-right-name">后台</p>
                               <div class="sle-right-con clearFix">
                                   <div class="h"></div>
                                </div>
                            </div>
                        </div>
                       
                    </div>
                   <h5></h5>
                   <div class="clear"></div>
                   <div class="management-below">
                       <p class="below-name">账号管理</p>
                       <div class="tb-wrap">
                       		<table>
								<tr>
	                               <th>账号</th>
	                               <th>手机权限</th>
	                               <th>后台权限</th>
	                               <th></th>
	                               <th></th>
	                           </tr>
                       		</table>
                       		<div class="below-wrap">
		                       	<table class="below-tb">
		                           <c:forEach items="${list }" var="l">
		                           		<tr>
		                           			
		                           			<td>
		                           			<input type="hidden" class="user_id" value="${l.user_id }">
		                           			${l.user_name }
		                           			</td>
		                           			<td>
		                           			<c:forEach items="${list1 }" var="s">
		                           				<input type="checkbox" class="b${l.user_id }" value="${s.per_id }">${s.per_name }
		                           			</c:forEach>
		                           			</td>
		                           			<td>
		                           			<c:forEach items="${list2 }" var="a">
		                           				<input type="checkbox" class="m${l.user_id }" value="${a.per_hid }">${a.per_hname }
		                           			</c:forEach>
		                           			</td>
		                           			<td>
		                           				<input type="button" value="修改" class="update">
		                           			</td>
		                           			<td>
		                           				<input type="button" value="删除" class="delete">
		                           			</td>
		                           			
		                           		</tr>
		                           </c:forEach>
		                           
		                       </table>         
                       		</div>
 							              		
                       </div>
                      
                   </div>
               </div>
           </div>
       </div>
   </div>
</body>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery.provincesCity.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/provincesData.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/js/index.js"></script>
<script type="text/javascript">
$(".cangku").click(function(){
	location="stock.do";
});
$(".zhuxiao").click(function(){
	location="toHoutaiLogin.do";
});
	$(function(){
		//去往权限管理
			$(".k").empty();
			$(".h").empty();
				$.ajax({
					url:"qx.do",
					type:"post",
					dataType:"json",
					success:function(msg){
						for(var i in msg){
							$(".k").append("<input type='checkbox' class='kk' value='"+msg[i].per_id+"'>"+"<span class='ks'>"+msg[i].per_name)+"</span>";
						}
					}
				});
				$.ajax({
					url:"qxh.do",
					type:"post",
					dataType:"json",
					success:function(msg){
						for(var i in msg){
							$(".h").append("<input type='checkbox' class='ht' value='"+msg[i].per_hid+"'>"+"<span class='hs'>"+msg[i].per_hname)+"</span>";
						}
					}
				});
			$(".btn").click(function(){
				var user_name=$(".name").val();
				var user_password=$(".password").val();
				var per_id="";
				var per_hid="";
				$(".kk:checked").each(function(){
					per_id+=","+$(this).val();
					
				});
				$(".ht:checked").each(function(){
					per_hid+=","+$(this).val();
				});
				per_id=per_id.substring(1);
				per_hid=per_hid.substring(1);
				if(per_hid!=""&&per_hid!=null&per_id!=""&&per_id!=null){
					
					$.ajax({
						url:"addUser.do",
						type:"post",
						data:{user_name:user_name,user_password:user_password,per_id:per_id,per_hid:per_hid},
						success:function(msg){
								alert("创建成功");
								location.reload();
							
						}
					});
				}else if(per_id!=""&&per_id!=null){
					$.ajax({
						url:"addUser.do",
						type:"post",
						data:{user_name:user_name,user_password:user_password,per_id:per_id},
						success:function(msg){
								alert("创建成功");
								location.reload();
							
						}
					});
				}else{
					$.ajax({
						url:"addUser.do",
						type:"post",
						data:{user_name:user_name,user_password:user_password,per_hid:per_hid},
						success:function(msg){
								alert("创建成功");
								location.reload();
							
						}
					});
				}
			});
			
				
				
				//验证用户名是否唯一
				$(".name").blur(function(){
					var user_name=$(".name").val();
					if(user_name==null||user_name==""){
						$("#user_name").text("用户名不能为空");
						$(".btn").attr("disabled",true);
					}else{
						$.ajax({
							url:"test.do",
							type:"post",
							data:{user_name:user_name},
							success:function(msg){
								 if(msg!=1){
									$("#user_name").text("用户名可用");
									$(".btn").attr("disabled",false);
								}else{
									$("#user_name").text("用户名不可用");
									$(".btn").attr("disabled",true);
									
								} 
							}
						});
						
					}
				});
					/* var per_id = "${u.per_id}".split(",");
					var per_hid = "${u.per_hid}".split(",");
						for(var i in per_id){
							$(".b[value="+per_id[i]+"]").attr("checked",true);
						} 
						
						for(var i in per_hid){
							$(".m[value="+per_hid[i]+"]").attr("checked",true);
						}  */
						$.ajax({
							url:"aa.do",
							type:"post",
							dataType:"json",
							success:function(msg){
								for(var i in msg){
									for(var s1 in msg[i]){
										var s2=".m"+msg[i][s1].user_id;
										$(s2).each(function(){
											if(msg[i][s1].per_hid==$(this).val()){
												this.checked=true;
											}
										})
									}
									for(var s3 in msg[i]){
										var s4=".b"+msg[i][s3].user_id;
										$(s4).each(function(){
											if(msg[i][s3].per_id==$(this).val()){
												this.checked=true;
											}
										})
									}
									
								}
							}
						});
						$(".update").click(function(){
							var user_id=$(this).parents("td").siblings("td").find(".user_id").val();
							var per_ids="";
							var per_hids="";
							var s=".b"+user_id+":checked";
							$(s).each(function(){
								per_ids+=","+$(this).val();
							});
							per_ids=per_ids.substring(1);
							var a=".m"+user_id+":checked";
							$(a).each(function(){
								per_hids+=","+$(this).val();
							});
							per_hids=per_hids.substring(1);
							$.ajax({
								url:"update.do",
								type:"post",
								data:{"user_id":user_id,"per_ids":per_ids,"per_hids":per_hids},
								success:function(msg){
									alert("修改成功");
									location.reload();
								}
							});
						});
						$(".delete").click(function(){
							var user_id=$(this).parents("td").siblings("td").find(".user_id").val();
							$.ajax({
								url:"delete.do",
								type:"post",
								data:{"user_id":user_id},
								success:function(msg){
									alert("删除成功");
									location.reload();
								}
							});
						});
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
	});
</script>
</html>