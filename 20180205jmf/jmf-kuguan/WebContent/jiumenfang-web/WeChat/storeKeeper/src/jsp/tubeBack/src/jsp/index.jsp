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
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/css/index.css">
    <meta http-equiv="refresh" content="600">
    <title>后台</title>
</head>
<body>
   <div class="contain">
       <div class="header clearFix">
           <div class="header-left">欢迎${user_name }登录</br><input type="button" value="退出登录" class="zhuxiao"></div>
           <div class="header-right clearFix">
               <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/logo.png" alt="">
           </div>

       </div>
             <div class="con clearFix">
           <div class="con-left">
               <ul>
                   <li style="background-color:#F7F8FD;color:#FD6C6E;">库存</li>
                   <li class="mmm">出货订单</li>
                   <li class="hhh">盘点</li>
                   <li class="ddd">单证</li>
                   <li class="ttt">退货</li>
                   <li class="qqq">权限管理</li>
               </ul>
           </div>
           <div class="con-right clearFix">
               <div class="inventory-page page">
                   <div class="shipments-page clearFix select">
                       <table>
                           <tr>
                           		<th></th>
                               <th style="width:28%">入库批次</th>
                               <th>产品信息</th>
                               <th>初存</th>
                               <th>结存</th>
                               <th>库位</th>
                               <th>出库数</th>
                               <th>明细</th>
                           </tr>
                           <c:forEach items="${list }" var="list">
                    		<tr>
                    			<td><input type="checkbox" value="${list.rep_id }" class="ck"></td>
                    			<td>${list.rep_enter }</td>
                    			<td>${list.bar_message }</td>
                    			<td>${list.num }</td>
                    			<td>${list.rep_end }</td>
                    			<td>${list.shelf_type }</td>
                    			<td class="aaaaaa">
                    				<input type="text" class="aaa" >
                    			</td>
                    			 <td class="vv">
                                   <i class="fa fa-list-ul c"  style="color:#6BBCE0;font-size: 26px">
                                   	<input type="hidden" value="${list.rep_id }" class="aa">
                                   </i>
                               </td>
                    		</tr>
                    	</c:forEach>
                       </table>
                       <table class="ll"></table>
                       <div class="con-btn">
                           <input type="button" value="发货" id="btn">
                       </div>
                   </div>
                   <div class="order-page clearFix noselect">
                       <div class="order-ipt clearFix">
                           <div class="order-slt">
                               <form action="">
                               <lable>渠道类型 </lable>
                               <select name="chan_id" id="chan_id">
                                 <option selected="selected" disabled="disabled">--选择渠道类型--</option>
                               </select>
                           </form>
                              <form action="" class="carriage">
                               <lable>运输类型 </lable>
                               <select name="tran_id" id="tran_id">
                                   <option selected="selected" disabled="disabled">--选择运输类型--</option>
                               </select>
                           </form>
                           </div>
                           <div class="clear"></div>
                           <div class="order-site clearFix">
                               <form action="">
                                   <lable class="remark-name">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 注</lable>
                                   <input type="text" class="remark" name="address_notes">
                               </form>
                                   <p class="site-name">国内地址</p>
                                   <div id="province">
                                       <select name="aimags" class="prov">
                                       </select>省
                                       <select name="market">
                                       </select>市
                                       <select name="area1" >
                                       </select>区
                                       <input type="text" name="area" class="area">
                                   </div>
                               <div class="clear"></div>
                               <form action="">
                               <lable>收件人</lable>&nbsp;&nbsp;&nbsp;
                               <input type="text" class="addressee-name" name="client_name">&nbsp;电话
                               <input type="text" class="tel" name="client_tel">
                           </form>
                           </div>
                       </div>
                       <div class="order-btn">
                            <input type="button" value="生成订单" id="b">
                       </div>
                   </div>
               </div>
               <div class="shipmentOrder-page page clearFix noselect">
                   <div class="goods-date">
				       <form  method="post">
				            <ul class="con-right-time clearFix" style="margin-left: 50px">
				                <span class="laydate-txt">开始时间 </span>
				                <input class="laydate-icon" id="start" name="start" value="${start }"/>
				                <span class="laydate-txt">结束时间</span>
				                <input class="laydate-icon" id="end" name="end" value="${end }"/>
				                <span class="laydate-search">
				                    <i class="fa fa-search"></i>
				                    <input type="button" value="查询" class="chuDate">
				                </span>
				            </ul>
						</form>

       			   </div>
                   <div class="order-list">
                       <table class="m">
                           <tr>
                               <th>订单号</th>
                               <th>入库批次</th>
                               <th> 品名</th>
                               <th>发货数</th>
                               <th>库位</th>
                               <th>渠道</th>
                               <th>运输</th>
                               <th>城市</th>
                               <th>库管</th>
                           </tr>
                           	<c:forEach items="${chuList }" var="cl">
                           		<tr>
                           			<td>${cl.order_num }</td>
                           			<td>${cl.rep_enters }</td>
                           		</tr>
                           	</c:forEach>	
                       </table>
                   </div>
               </div>
               <div class="check-page page clearFix noselect">
                   <div class="order-inquire clearFix">
                       <select name="" id="year2">
                           <option value="年份">年份</option>
                           <option value="2017">2017</option>
                       </select>
                       <select name="" id="month2">
                           <option value="月份">月份</option>
                           <option value="1月">1月</option>
                           <option value="2月">2月</option>
                           <option value="3月">3月</option>
                           <option value="4月">4月</option>
                           <option value="5月">5月</option>
                           <option value="6月">6月</option>
                           <option value="7月">7月</option>
                           <option value="8月">8月</option>
                           <option value="9月">9月</option>
                           <option value="10月">10月</option>
                           <option value="11月">11月</option>
                           <option value="12月">12月</option>
                       </select>
                       <input type="button" value="查询" class="inquire-btn">
                       <input  type="button" class="export-excel" value="导出Excel">
                   </div>
                   <div class="order-list">
                        <table class="pa">
                           <tr>
                               <th>日期</th>
                               <th>库位</th>
                               <th>入库批次</th>
                               <th>产品信息</th>
                               <th>结存</th>
                               <th>盘点数</th>
                               <th>盘点人</th>
                               <th>备注</th>

                           </tr>
                           
                       </table>
                   </div>
               </div>
               <div class="pappers-page page clearFix noselect">
                   <div class="order-inquire clearFix">
                       <select name="" id="year3">
                           <option value="年份">年份</option>
                           <option value="2017">2017</option>
                       </select>
                       <select name="" id="month3">
                           <option value="月份">月份</option>
                           <option value="1月">1月</option>
                           <option value="2月">2月</option>
                           <option value="3月">3月</option>
                           <option value="4月">4月</option>
                           <option value="5月">5月</option>
                           <option value="6月">6月</option>
                           <option value="7月">7月</option>
                           <option value="8月">8月</option>
                           <option value="9月">9月</option>
                           <option value="10月">10月</option>
                           <option value="11月">11月</option>
                           <option value="12月">12月</option>
                       </select>
                       <input type="button" value="查询" class="inquire-btn">
                       <input  type="button" class="export-excel" value="导出Excel">
                   </div>
                   <div class="order-list">
                       <table class="dan">
                           <tr>
                               <th>日期</th>
                               <th>标题</th>
                               <th>内容描述</th>
                               <th>库管</th>
                               <th>照片</th>
                           </tr>
                       </table>
                   </div>
               </div>
               <div class="returns-page page clearFix noselect">
                   <div class="order-inquire clearFix">
                       <select name="" id="year4">
                           <option value="年份">年份</option>
                           <option value="2017">2017</option>
                       </select>
                       <select name="" id="month4">
                           <option value="月份">月份</option>
                           <option value="1月">1月</option>
                           <option value="2月">2月</option>
                           <option value="3月">3月</option>
                           <option value="4月">4月</option>
                           <option value="5月">5月</option>
                           <option value="6月">6月</option>
                           <option value="7月">7月</option>
                           <option value="8月">8月</option>
                           <option value="9月">9月</option>
                           <option value="10月">10月</option>
                           <option value="11月">11月</option>
                           <option value="12月">12月</option>
                       </select>
                       <input type="button" value="查询" class="inquire-btn">
                       <input  type="button" class="export-excel" value="导出Excel">
                   </div>
                   <div class="order-list">
                       <table class="th">
                           <tr>
                               <th>日期</th>
                               <th>快递名称</th>
                               <th>运单号</th>
                               <th>产品</th>
                               <th>数量</th>
                               <th>库管</th>
                               <th>照片</th>
                           </tr>
                           		
                       </table>
                   </div>
               </div>
               <div class="permission-page page clearFix noselect">
                    <div class="establish-top clearFix">
                        <div class="establish-ipt">
                            <form>
                                <lable>创建账号</lable>
                                <input type="text" name="user_name" class="name"> 
                                <span id="user_name" style="color: #ff0000"></span>
                                <lable>创建密码</lable>
                                <input type="text" name="user_password" class="password">
                            </form>
                        </div>
                        <div class="establish-sle clearFix">
                            <div class="sle-left">
                                <p class="sle-left-name">库管端权限</p>
                                <div class="clearFix">
                                    <div class="k"></div>
                                </div>
                            </div>
                            <div class="sle-right">
                                <p class="sle-right-name">后台权限</p>
                                <div class="clearFix">
                                	<div class="h"></div>
                                </div>
                            </div>
                        </div>
                        <input type="button" value="创建" class="establish-btn btn">
                    </div>
                   <h5></h5>
                   <div class="clear"></div>
                   <div class="management-below">
                       <h1>账号管理</h1>
                       <table class="ss">
                           <tr>
                               <th>账号</th>
                               <th>库管端权限</th>
                               <th>库管端权限</th>
                               <th>修改</th>
                               <th>删除</th>
                           </tr>
                           <tr class="l">
                           		
                           </tr>
                       </table>
                   </div>
               </div>
           </div>
       </div>
   </div>
</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/laydate/laydate.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery.provincesCity.js"></script>
<script src="<%=path %>/jiumenfang-web/publicJs/provincesData.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/js/index.js"></script>

<script type="text/javascript">
	
		var rep_out="";
		var rep_id1="";
		var ab=0;
		var out_date="";
		$("#btn").click(function(){
				if($(".ck").is(':checked')){
					
					$(".ck:checked").each(function(){
							 rep_out+=","+$(this).parent('td').siblings().find('.aaa').val();
							var rep_id=$(this).val();
							rep_id1 +=","+rep_id;
					});
									rep_out=rep_out.substring(1);
									
									rep_id1=rep_id1.substring(1);
							 if(rep_out!=null&&rep_out!=""){
				
										 $.ajax({
											url:"out.do",
											type:"post",
											data:{"rep_id":rep_id1,"rep_out":rep_out},
											dataType:"json",
											success:function(msg){
												out_date=msg.out_date;
												ab=msg.ab;
												
												
											}
											
										}); 
							 $('.con-btn').on('click',function(){
								    $(this).parent('.shipments-page').removeClass('select').addClass('noselect');
								    $('.order-page').removeClass('noselect').addClass('select');
								});
							 }
									
					
					
					
				}else{
					alert("请选择商品");
					
				}
			
		
	});
		
		
		
		
	var city_id=0;
		$("#b").click(function(){
			var aimags=$("[name='aimags']").val();
			var market=$("[name='market']").val();
			var area1=$("[name='area1']").val();
			var area=$("[name='area']").val();
			var chan_id=$("#chan_id").val();
			var tran_id=$("#tran_id").val();
			var address_notes=$("[name='address_notes']").val();
			var client_name=$("[name='client_name']").val();
			var client_tel=$("[name='client_tel']").val();
			var address_name=aimags+","+market+","+area1+","+area;
			var rep_ids="";
			$(".ck:checked").each(function(){
				rep_ids+=","+$(this).val();
			});
			rep_ids=rep_ids.substring(1);
			if(aimags!=null&&aimags!=""&&
			   market!=null&&market!=""&&
			   area1!=null&&area1!=""&&
			   area!=null&&area!=""&&
			   chan_id!=null&&chan_id!=""&&
			   tran_id!=null&&tran_id!=""&&
			   address_notes!=null&&address_notes!=""&&
			   client_name!=null&&client_name!=""&&
			   client_tel!=null&&client_tel!=""){
				
				 $.ajax({
					url:"aimags.do",
					type:"post",
					data:{aimags:aimags,rep_ids:rep_ids,address_name:address_name,chan_id:chan_id,tran_id:tran_id,address_notes:address_notes,client_name:client_name,client_tel:client_tel},
					dataType:"json",
					success:function(msg){
						var address_id=msg.address_id;
						var city_id=msg.city_id;
						var client_id=msg.client_id;
						var time1=msg.time1;
						$.ajax({
							url:"mon.do",
							type:"post",
							data:{"rep_id1":rep_id1,"chan_id":chan_id,"tran_id":tran_id,"address_id":address_id,"city_id":city_id,"client_id":client_id,"time1":time1,"ab":ab,"out_date":out_date},
							success:function(msg){
							}
						});  
					}
				});
						
				$('.order-btn').on('click',function(){
				    var tel=$('.tel').val();
				    var isMob = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
				    var isPhone = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
				    var telValue = $.trim(tel);
				        if($('.channel').find('option:selected').val()=='选择销售渠道'||$('.carriage').find('option:selected').val()=='选择运输方式'||$('.addressee-name').val()==""||$('.tel').val()==""||$('.prov').find('option:selected').val()=='请选择'||$('.area').val()==""){
				            alert('请填写完整信息')
				        }else if(isMob.test(telValue) || isPhone.test(telValue)){
				            $(this).parent('.order-page').removeClass('select').addClass('noselect');
				            $('.shipments-page').removeClass('noselect').addClass('select');
				        }else{
				            alert('请填写正确的手机号码');
				        }
				}); 
			}else{
				alert("请完善所有信息");
			}
				
								 
		});
		
		
		
		$(function(){
			
			//查询渠道
			$.ajax({
				url:"chan.do",
				type:"post",
				dataType:"json",
				success:function(msg){
					for(var i in msg){
						$("#chan_id").append("<option value='"+msg[i].chan_id+"'>"+msg[i].chan_name+"</option>");
					}
				}
			});
			//查询运输类型
			$.ajax({
				url:"tran.do",
				type:"post",
				dataType:"json",
				success:function(msg){
					for(var i in msg){
						$("#tran_id").append("<option value='"+msg[i].tran_id+"'>"+msg[i].tran_name+"</option>");
					}
				}
			});
			
			
			//去往出货订单页面
			$(".mmm").click(function(){
				$.ajax({
					url:"chu.do",
					type:"post",
					dataType:"json",
					success:function(msg){
						for(var i in msg){
							$(".m").append("<tr><td>"+msg[i].order_num+"</td><td>"+msg[i].rep_enters+"</td><td>"+msg[i].bar_message+"</td><td>"+msg[i].out_num+"</td><td>"+msg[i].shelf_type+"</td><td>"+msg[i].chan_name+"</td><td>"+msg[i].tran_name+"</td><td>"+msg[i].city_name+"</td><td>"+msg[i].user_name+"</td></tr>");
						}
					}
				});
				$(".chuDate").click(function(){
					$.ajax({
						url:"chu.do",
						type:"post",
						data:$("form").serialize(),
						dataType:"json",
						success:function(msg){
						}
					});
				});
			});
			
			//去往盘点页面
			$(".hhh").click(function(){
				$.ajax({
					url:"pan.do",
					type:"post",
					dataType:"json",
					success:function(msg){
						for(var i in msg){
							$(".pa").append("<tr><td>"+msg[i].p_date+"</td><td>"+msg[i].shelf_type+"</td><td>"+msg[i].rep_enter+"</td><td>"+msg[i].bar_message+"</td><td>"+msg[i].rep_end+"</td><td>"+msg[i].number_num+"</td><td>"+msg[i].user_name+"</td><td>"+msg[i].bz_name+"</td></tr>");
						} 
					}
				});
			});
			
			
			//去往权限管理
			$(".qqq").click(function(){
				$(".k").empty();
				$(".h").empty();
					$.ajax({
						url:"qx.do",
						type:"post",
						dataType:"json",
						success:function(msg){
							for(var i in msg){
								$(".k").append("</br><input type='checkbox' class='kk' value='"+msg[i].per_id+"'>"+msg[i].per_name);
							}
						}
					});
					$.ajax({
						url:"qxh.do",
						type:"post",
						dataType:"json",
						success:function(msg){
							for(var i in msg){
								$(".h").append("</br><input type='checkbox' class='ht' value='"+msg[i].per_hid+"'>"+msg[i].per_hname);
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
					$.ajax({
						url:"addUser.do",
						type:"post",
						data:{user_name:user_name,user_password:user_password,per_id:per_id,per_hid:per_hid},
						success:function(msg){
								alert("创建成功");
								location.reload();
							
						}
					});
				});
				
					$.ajax({
						url:"cha.do",
						type:"post",
						dataType:"json",
						success:function(msg){
								//$(".ss").append("<tr><td>'"+msg[i].user_name+"'</td></tr>");
								alert(msg.per_id);
								alert(msg);
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
			});
				$(".ll").hide();
			$(".c").click(function(){
				$(".ll").show();
				$(".ll").empty();
				var rep_id=$(this).children(".aa").val();
				
				$.ajax({
					url:"zs.do",
					type:"post",
					data:{"rep_id":rep_id},
					dataType:"json",
					success:function(msg){
						for(var i in msg){
							$(".ll").append("<tr><td>日期</td><td>产品</td><td>出货数量</td><td>结存</td></tr><tr><td>"+msg[i].date1+"</td><td>"+msg[i].bar_message+"</td><td>"+msg[i].out_num+"</td><td>"+msg[i].rep_end+"</td></tr>");
						}
					}
				});
			});
			$(".ddd").click(function(){
				//单证
				$.ajax({
					url:"chaDan.do",
					type:"post",
					dataType:"json",
					success:function(msg){
						for(var i in msg){
							$(".dan").append("<tr><td>"+msg[i].uploadDate+"</td><td>"+msg[i].title+"</td><td>"+msg[i].area+"</td><td>"+msg[i].user_name+"</td><td><img src='"+msg[i].uploadPath+"'></td></tr>");
						}
					}
				});
			});
			$(".ttt").click(function(){
				//退货
				$.ajax({
					url:"chaTui.do",
					type:"post",
					dataType:"json",
					success:function(msg){
						for(var i in msg){
							$(".th").append("<tr><td>"+msg[i].uploadDate1+"</td><td>"+msg[i].kuaidi+"</td><td>"+msg[i].yundan+"</td><td>"+msg[i].chanpin+"</td><td>"+msg[i].num+"</td><td>"+msg[i].user_name+"</td><td><img src='"+msg[i].uploadPath1+"'></td></tr>");
						}
					}
				});
			});
	});
	
</script>
</html>