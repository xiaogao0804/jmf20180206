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
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="<%=path %>/jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/jiumenfang-web/WeChat/storeKeeper/src/css/productInfo.css">
    <meta http-equiv="refresh" content="600">
    <title>盘点</title>
</head>
<body>
    <div class="product-contain">
        <div class="receiving-header">
            <i class="fa fa-angle-left fa-3x"></i>
            <span>库位信息</span>
        </div>
        <div class="product-name clearFix">
        	<input type="hidden" value="${shelf_id }" class="q">
            <p class="name-letter">${shelf_type }</p>
            <button class="name-btn m">确定</button>
        </div>
        <c:forEach items="${list }" var="s">
        <div class="product-info">
        <input type="hidden" value="${user_id }" class="user">
            <table>
            	<tr>
            		<td>
            			<input type="hidden" value="${s.rep_id }" class="d">
            		<td>
            	</tr>
                <tr>
                    <td>产品批号</td>
                    <td>${s.rep_enter }</td>
                </tr>
                <tr>
                    <td>产品名称</td>
                    <td>${s.bar_message }</td>
                </tr>
                <tr>
                    <td>库存结存</td>
                    <td>${s.rep_end }</td>
                </tr>
                <tr>
                    <td>实盘数</td>
                    <td>
                    	 <input type="text" class="trading-num b">
                    </td>
                </tr>
            </table>
        </div>
      </c:forEach>
    </div>
</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script>
    //获取高度
    var winHeight = window.innerHeight;
    window.addEventListener('resize', function(event){
        winHeight = window.innerHeight;
        console.log(winHeight);
    });
    $('.product-contain').height(winHeight);

    //返回上一页
    $('.receiving-header i').on('click',function(){
        window.history.back();
    });
    	$(".m").click(function(){
    		var user_id=$(".user").val();
    		var shelf_id=$(".q").val();
    		var rep_id="";
    		var number="";
    		$(".d").each(function(){
    		rep_id+=","+$(this).val();
    			
    		});
    		rep_id=rep_id.substring(1);
    		$(".b").each(function(){
    			number+=","+$(this).val();
    		});
    		number=number.substring(1);
    		var bz=$(".v").html();
    		var s_id=2;
    		if(user_id!=""&&user_id!=""&&
    				shelf_id!=""&&shelf_id!=""&&
    				rep_id!=""&&rep_id!=""&&
    				number!=""&&number!=""){
    			
		    		 $.ajax({
		    			url:"pa.do",
		    			type:"post",
		    			data:{user_id:user_id,shelf_id:shelf_id,rep_id:rep_id,number:number,bz:bz,s_id:s_id},
		    			dataType:"text",
		    			success:function(msg){
		    				if(confirm("盘点成功，是否返回主页面")){
		    					location="info.do";
		    				}
		    			}
		    		}); 
    		}else{
    			alert("请填写盘点信息");
    		}
    	});
</script>
</html>