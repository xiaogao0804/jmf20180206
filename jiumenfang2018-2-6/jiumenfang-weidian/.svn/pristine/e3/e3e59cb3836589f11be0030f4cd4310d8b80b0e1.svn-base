package com.jiumenfang.utils;
import java.net.URLEncoder;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;





public class SpringMVCInterceptor implements HandlerInterceptor{

	//定义不需要拦截的属性
	private List<String> excludeUrls;
	
	
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}


	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		//可以看商城  详情 点击任何提示关注  
				//得到请求路径                      
				String cuccentUrl = request.getRequestURL().toString();
				System.out.println("cuccentUrl::::"+cuccentUrl);
				String uri = request.getRequestURI().substring(request.getContextPath().length());
				System.err.println("uri:"+uri);
				if(uri.startsWith("/xxt")||uri.startsWith("/payOk")){
					return true;
				}
				else{
					String openid=OpenidUtil.getOpenid(request);
					if(openid==null){//没有openid 要去请求
						String oldurl=(request.getRequestURL().toString().split(request.getRequestURI())[0]/*+"/"*/+request.getContextPath()+"/xxt/setOpenid.do");//.replace("//", "/");
						oldurl=URLEncoder.encode(oldurl,"GBK");
						String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Constants.APPID+"&redirect_uri="+oldurl+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
						System.err.println("url:"+url);
						response.sendRedirect(url);
						return false;
					}else{
  						 System.out.println("已经有了openid:"+OpenidUtil.getOpenid(request));
						 JsonObject openuser =OpenidUtil.getOpenInfo(request);
						 if (openuser==null) {
							  openuser = WeixinUtil.getOpenidInfo(openid, Constants.APPID, Constants.SECRET);
							  OpenidUtil.setOpenidInfo(request,openuser);
						 }
					     System.out.println("openuser:"+openuser);
						 return true;
					}
				}
//				if(cuccentUrl.contains( "/xxt/api.do")
				/*	//获取session的值
				Commodity user = (Commodity) request.getSession().getAttribute("user");
				for (String u : excludeUrls) {
					//如果包含配置文件的url的话，就放行
					if(cuccentUrl.contains(u)){
						request.setAttribute("loginError", "您好，请先登录!");
						request.getRequestDispatcher("URL").forward(request, response);
						return false;
					}
				}
				if(user!=null){
					return true;
				}*/
		
	}

}
