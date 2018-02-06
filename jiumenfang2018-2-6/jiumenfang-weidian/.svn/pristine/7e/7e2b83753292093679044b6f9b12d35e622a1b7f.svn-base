<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <script src="jiumenfang-web/publicJs/flexible.js"></script>
    <link rel="stylesheet" href="jiumenfang-web/publicCss/reset.css">
    <link rel="stylesheet" href="jiumenfang-web/publicCss/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="jiumenfang-web/WeChat/shopping/src/css/pay.css">
    <title>支付</title>
</head>
<body>
</body>

<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">

          function onBridgeReady(){
		         WeixinJSBridge.invoke(
		        	'getBrandWCPayRequest', {
		        		 "appId" : '${appId}', //公众号名称，由商户传入     
		                 "timeStamp" : '${paytimestamp}', //时间戳，自1970年以来的秒数     
		                 "nonceStr" : '${paynonceStr}', //随机串     
		                 "package" : '${paypackage}',
		                 "signType" : '${paysignType}', //微信签名方式:     
		                 "paySign" : '${paySign}' //支付验证微信签名 
		             } 
		        	, function(res) {
		                 //alert(res.err_msg); // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返
		                 if(res.err_msg == "get_brand_wcpay_request:ok"){  
		                 //支付成功，完成后去到哪个页面。                               
		                	 window.location.href="shouyeaa.do";
		                 }else{
		                	 window.location.href="shouyeaa.do";
		                 }
		             }); 
		  }
             
                 if (typeof WeixinJSBridge == "undefined"){
                     if( document.addEventListener ){
                         document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                     }else if (document.attachEvent){
                         document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                         document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                     }
                 }else{
                	//如果报错，可用下面方法看看是不是参数缺少。
                     /* alert('${appId}');
                     alert('${paytimestamp}');
                     alert('${paynonceStr}');
                     alert('${paypackage}');
                     alert('${paysignType}');
                     alert('${paySign}');   */
                     //调用下面方法。开启微信支付
                     onBridgeReady();
                 }
  
  
</script>
</html>