<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="jiumenfang-web/WeChat/shopping/src/css/series.css">
    <title>小酱仙</title>
</head>
<body>	
    <div class="contain">
       <c:forEach items="${list }" var="c">
           <a href="commodityList.do?start_id=${c.start_id}">
              <img src="${c.start_img}" alt="">
           </a>
       </c:forEach>
       
         <div class="bottom-logo">
       		<img src="jiumenfang-web/WeChat/shopping/src/image/bottom.png"/>
         </div>
		 <div class="order-icon">
			 		<img src="jiumenfang-web/WeChat/shopping/src/image/order_icon.png"/>      
		 </div>
    </div>
</body>
<script src="jiumenfang-web/publicJs/jquery-3.2.1.min.js"></script>
<script>
var url=''; // 根据需要获取,JS,PHP,ASP等;
function RandomNumber(){
//获取随机数
    var now=new Date();
    var number = now.getSeconds() +(now.getMilliseconds()%43)*7/1.131412567;
    if( number ==0){
        number = now.getFullYear() + (now.getMilliseconds()%1.24377)*7/1.131412567;
    }
    return number;
}				
$(".order-icon").click(function(){
	location="tomyOrdersss.do?number="+RandomNumber();
});

$(window).scroll(function(){
	var	doc_height=$(document).height();
	var scroll_top = $(document).scrollTop(); 
	var	win_height=$(window).height();
	if(scroll_top+win_height>=doc_height){
		$('.bottom-logo').show().hide(3000);
		
	}
})
</script>	
</html>