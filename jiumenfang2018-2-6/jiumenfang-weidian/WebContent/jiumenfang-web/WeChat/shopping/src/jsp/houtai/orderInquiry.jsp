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
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/css/orderInquiry.css">
</head>
<body>
    <div class="contain-inquiry">
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
                            订单查询
                        </li>
                        <li class="order-edit">
                            <a href="orderEdit.do">订单修改</a>
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
                            <a href="passwordReset.do">密码重置</a>
                        </li>
                        <li>
                        	<a href="zhuxiao.do">退出登录</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="con-right">
          <form action="orderInquiry.do" method="post">
            <div class="con-right-select clearFix">
            
                <select name="status" id="status-select">
                    <option value="">全部</option>
                    <option value="1">未支付</option>
                    <option value="6">已支付</option>
                    <option value="2">未发货</option>
                    <option value="3">已发货</option>
                    <option value="4">退货中</option>
                    <option value="5">已退货</option>
                </select>
                
                
                <div class="con-right-ipt">
                 	<input type="hidden" id="page" name="currentPage"/>
					<input type="text" placeholder="请输入订单号" name="orders" value="${orders}">
                    <input type="text" placeholder="请输入收件人电话" name="address_tel" value="${address_tel}">
                    <input type="text" placeholder="请输入收件人" name="address_name" value="${address_name}">
                    收入:￥
                    <input type="text" value="" class="con-ipt-rmb">
                </div>
                
            </div>
                　　　　　<input class="laydate-icon" id="start" name="start" type="text" value="${start}">　开始时间 
　　<input class="laydate-icon" id="end" name="end" type="text" value="${end}">　结束时间
                    　　<i class="fa fa-search"></i>
		<input type="submit" value="查询" id="cx"/>
          </form>
            
            
            
            
            
            <table border="1">
                <tr>
                    <th>订单号</th>
                    <th>商品信息</th>
                    <th>价格</th>
                    <th>邮寄地址</th>
                    <th>收件人</th>
                    <th>电话</th>
                    <th>订单时间</th>
                    <th>状态</th>
                    <th>物流相关信息</th>
                </tr>
                <c:forEach items="${list}" var="aa">
	                <tr>
	                    <td>${aa.orders}</td>
	                    <td>${aa.order_com}</td>
	                    <td class="td-price">${aa.order_price}</td>
	                    <td>${aa.city} ${aa.district} ${aa.area} ${aa.address}</td>
	                    <td>${aa.address_name}</td>
	                    <td>${aa.address_tel}</td>
	                    <td>${aa.order_time}</td>
	                    <td>${aa.status}</td>
	                    <td>顺丰：<span>122333</span></td>
	                </tr>
                </c:forEach>
                
               	<tr style="height: 35px">
					<td colspan="11">
						<input type="button" value="　首页　" onclick="fenye(1)">　
						<input type="button" value="　上一页　" onclick="fenye(${page.previousPage})">　
						<input type="button" value="　下一页　" onclick="fenye(${page.nextPage})">　
						<input type="button" value="　末页　" onclick="fenye(${page.pageCount})">　　
			    			第${page.currentPage}/${page.pageCount}页
					</td>
				</tr>
            </table>
        </div>
    </div>
</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script src="<%=request.getContextPath() %>/jiumenfang-web/publicJs/laydate-v1.1/laydate/laydate.js"></script>
<script src="<%=request.getContextPath() %>/jiumenfang-web/WeChat/backStage/src/js/orderInquiry.js"></script>
<SCRIPT type="text/javascript">
                function fenye(page){
                        document.getElementById("page").value = page;
                        document.forms[0].submit();
                }
          			$("select").change(function(){
          				var status_id = $("select").val();
						location="orderInquiry.do?status_id="+status_id; 
          			});
      				$("select").val("${status_ida}");
      				
</SCRIPT>
</html>