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
				<li class="zhanghao">
					
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/zhanghao.png" alt="">
					
				</li>

				<li>
					<a href="">
						<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/cangkuSelect.png" alt="">
					</a>
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
		<form action="stock.do" method="post">
		  <input type="hidden" id="page" name="currentPage"/>
		</form>
       <div class="con clearFix">
           <div class="con-left">
               <ul>
                   <li id="k">
                   		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/kucunSelect.png" alt="">
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
                 <%--   <li>
                       <a href="cha.do">
                       		<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/quanxian.png" alt="">
                       </a>
                   </li> --%>
               </ul>
           </div>
           <div class="con-right clearFix">          
               <div class="inventory-page page">
                   <div class="shipments-page clearFix select">
                   	<div class="excel-wrap clearFix">
                    	<div class="con-btn">
		                   <input type="button" value="发 货" id="btn">
		                </div>
		                 <input  type="button" class="export-excel out" value="导出Excel">		               
                    </div>
                    <div class="ccc clearFix">
                    	<div class="tb-wrap">
                    		<table class="rrr">
                           	<tr>
                           		<th	style="width:8%"></th>
                           		<th></th>
                               	<th style="width:33%;">入库批次</th>
                               	<th>产品名称</th>
                               	<th>初存</th>
                              	<th>结存</th>
                               	<th>库位</th>
                              	<th style="width:10%;">收货人</th>
                               	<th	style="width:6%;text-align:center;">出库</th>
                               	<th	style="text-align:center;">明细</th>                        
                           	</tr>
                          <c:forEach items="${list }" var="list">
                    		<tr class="ttt">
                    			<td style="text-indent:30px;"><input type="checkbox" value="${list.rep_id }" class="ck"></td>
                    			<td><input type="hidden" value="${list.rep_id }" class="hh"></td>
                    			<td	style="text-align:left;">${list.rep_enter }</td>
                    			<td>${list.bar_message }</td>
                    			<td>${list.num }</td> 
                    			 <td class="end">${list.rep_end }</td> 
                    			<td>${list.shelf_type }</td>
                    			 <td>${list.user_name }</td>
                    			<td class="ooo"	style="text-align:center;">
                    				<input type="text" class="aaa">
                    			</td>
                    			 <td class="vv"	style="text-align:center;">
                    			 	<img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/image/menu.png"/>
                               </td>                            
                    		</tr>
                    	</c:forEach>
                      	               	                   	
                       </table>
                     	<table class="kk">
                     		<tr>
						    	<td	class="fenye-td" colspan="11" style="text-align:center">
						    		<span>当前${page.currentPage}/${page.pageCount}页</span>
						    		<input type="button" value="首页" onclick="fenye(1)">
						    		<input type="button" value="上一页" onclick="fenye(${page.previousPage})">
						    		<input type="button" value="下一页" onclick="fenye(${page.nextPage})">
						    		<input type="button" value="尾页" onclick="fenye(${page.pageCount})">
								</td>
						    </tr>
                     	</table>
                    	</div>                    
                        
                     	   <div class='clear'></div>

                    </div>
                
                     	<div class="bbb clearFix">
                     		<div class="tb-headerWrap">
                     			<div class="header-name">
                     				
                     			</div>
                     			<table class="header-tb">
                     				<tr>
                     					<td>日期</td>
                     					<td>产品</td>
                     					<td>出货量</td>
                     					<td>结存</td>
                     				</tr>
                     			</table>
                     		</div>
                     		<div class="ll-wrap">
                     			<table class="ll">
	                       			
	                       </table>
                     	</div>
                       </div>
               </div>
       </div>
   </div>
</body>
<script src="<%=path %>/jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/js/jquery.min.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/jsp/tubeBack/src/js/index.js"></script>


<script type="text/javascript">

$(document).on('click','.vv',function(){
	$('.bbb').css('display','block');
})
var rep_out="";
var rep_id1="";
var ab=0;
var rep_end=0;
var out_date="";
$(".zhuxiao").click(function(){
	 location="toHoutaiLogin.do";
});
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
							  
							  location="out.do?rep_id="+rep_id1+"&&"+"rep_out="+rep_out;
										//alert("11111111"+ab);
							 /* $('.con-btn').on('click',function(){
								    $(this).parents('.shipments-page').removeClass('select').addClass('noselect');
								    $('.order-page').removeClass('noselect').addClass('select');
								}); */
						 }  
			}else{
				alert("请选择商品");
			} 

	});
/* var city_id=0;
	$(document).on('click','#b',function(){
		var aimags=$("[name='cho_Province']").val();
		//var aimags=$("[name='aimags']").val();
		var market=$("[name='cho_City']").val();
		//var market=$("[name='market']").val();
		var area1=$("[name='cho_Area']").val();
		//var area1=$("[name='area1']").val();
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
							location.reload();
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
	 */
	$(function(){
		var user_id="${user_id}";
		$(".zhanghao").click(function(){
			if(user_id==1){
				
			location="cha.do";
			}else{
				alert("对不起，您没有访问该页面的权限");
			}
			
		});
		$(".rrr").find('tr:even').css('background','#DFE9EB');
		$(".rrr").find('tr:odd').css('background','#fff');
		$(".end").each(function(){
			rep_end=$(this).html();
			if(rep_end==0){
				var rep_id=$(".hh").val();
				$(this).parents('.ttt').css("display","none");
			}
		});
		
		$("#cc").hide();
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
		 $(".bbb").hide(); 
		$(document).on('click','.vv',function(){
			$(".bbb").show();
			$(".ll").empty();
			$(".header-name").empty();
			var rep_id=$(this).siblings("td").children(".hh").val();
			$.ajax({
				url:"zs.do",
				type:"post",
				data:{"rep_id":rep_id},
				dataType:"json",
				success:function(msg){
					for(var j in msg){
						$(".header-name").append(msg[j].rep_enters);
						break;
					}
					//$(".ll").append("<tr><td>日期</td><td>产品</td><td>出货数量</td><td>结存</td></tr>");
					 for(var i in msg){
						$(".ll").append("<tr><td>"+msg[i].date1+"</td><td>"+msg[i].bar_message+"</td><td>"+msg[i].out_num+"</td><td>"+msg[i].end_num+"</td></tr>");
					}  
					 $(".ll").find('tr:even').css('background','#fff');
						$(".ll").find('tr:odd').css('background','#DFE9EB');
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
	function fenye(page){
			document.getElementById("page").value = page;
			document.forms[0].submit();
		}
	$(".out").click(function(){
		window.location.href="outExcel4.do";
	});
</script>
</html>