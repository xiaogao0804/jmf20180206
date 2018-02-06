<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/receiving.css">
    <title>收货</title>
</head>
<body>
   <div class="receiving-contain">
      <div class="receiving-header">
          <i class="fa fa-angle-left fa-3x"></i>
          <span>收货</span>
      </div>
      <div>
       <ul class="receiving-info">
          <li>
              <p class="receiving-info-name">批号</p>
              <div  class="receiving-info-select clearFix">
                  <p class="internation">
                      <span>国际类别</span>
                      <select name="inter" id="inter">
                         <option selected="selected" disabled="disabled">--全部--</option>
                      </select>
                 </p>                                                      
                 <p class="barCode">
                 	<span>产品条码</span>
                     <select name="bar" id="bar">
                        <option selected="selected" disabled="disabled">--全部--</option>
                     </select>
                 </p>
              </div>
          </li>
           <li>
               <p class="receiving-info-name">库位</p>
               <div  class="receiving-info-select clearFix">
                   <p class="goodsShelf">
                      	<span>货架区域</span> 
                     <select id="shelf" class="shelf">
                        <option selected="selected" disabled="disabled">--全部--</option>
                     </select>
                   </p>
               </div>
           </li>
            <li>
            	<p class="numpop">数量</p>
            	<div class="enterNum">
            		<span>实收数量</span>
           			<input type="text" placeholder="输入数量" class="num" id="num">
            	</div>
      		 </li>
       </ul>
       </div>
       <div>

       <div class="keyBoard">
           <table border="1">
               <tr>
                   <td class="td-num">1</td>
                   <td class="td-num">2</td>
                   <td class="td-num">3</td>
                   <td class="keyBoard-delete">
                       <img src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/image/delete.png" alt="">
                   </td>
               </tr>
               <tr>
                   <td class="td-num">4</td>
                   <td class="td-num">5</td>
                   <td class="td-num">6</td>
                   <td class="keyBoard-confirm" id="sub">确定</td>

               </tr>
               <tr>
                   <td class="td-num">7</td>
                   <td class="td-num">8</td>
                   <td class="td-num">9</td>
                   <td class="td-num">0</td>
               </tr>
           </table>
       </div>
      
    </div>
   </div>
</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script src="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/js/receiving.js"></script>
<script type="text/javascript">
	$(function(){
 		$.ajax({
			url:"inter.do",
			type:"post",
			dataType:"json",
			success:function(msg){
				for(var i in msg){
					$("#inter").append("<option id='"+msg[i].inter_id+"'>"+msg[i].inter_type+"</option>");
				}
			},
			async:false
		});
		$.ajax({
			url:"bar.do",
			type:"post",
			dataType:"json",
			success:function(msg){
				for(var i in msg){
					$("#bar").append("<option id='"+msg[i].bar_id+"'>"+msg[i].bar_num+"</option>");
				}
			},
			async:false
		}); 
		$.ajax({
			url:"shelf.do",
			type:"post",
			dataType:"json",
			success:function(msg){
				for(var i in msg){
					$(".shelf").append("<option value='"+msg[i].shelf_id+"'>"+msg[i].shelf_type+"</option>");
				}
			}
		});
		
		$("#sub").click(function(){
			var num=$("#num").val();
			var inter_type=$("#inter").val();
			var bar_num=$("#bar").val();
			var rep_enter=inter_type+","+bar_num;
			var shelf_id=$("#shelf").val();
			  $.ajax({
				url:"rep.do",
				type:"post",
				data:{num:num,rep_enter:rep_enter,bar_num:bar_num,shelf_id:shelf_id},
				success:function(msg){
					 if(confirm("收货成功，是否去往首页")){
						 location="info.do";
					 }
				}
			});  
		});
	});
</script>
</html>