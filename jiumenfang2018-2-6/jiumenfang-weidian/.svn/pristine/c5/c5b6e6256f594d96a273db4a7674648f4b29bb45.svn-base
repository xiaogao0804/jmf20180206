package com.jiumenfang.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.jiumenfang.user.bean.Commodity;
import com.jiumenfang.user.service.CoreService;
import com.jiumenfang.user.service.JMFServiceImp;
import com.jiumenfang.utils.Constants;
import com.jiumenfang.utils.OpenidUtil;
import com.jiumenfang.utils.Page;
import com.jiumenfang.utils.SignUtil;
import com.jiumenfang.utils.WeChat;
import com.jiumenfang.utils.WeixinUtil;

@Controller
@RequestMapping("/xxt")
public class XxtController {
	@ResponseBody
	@RequestMapping(value="/api",method = RequestMethod.GET)
	public String xxtInterface(WeChat wc){
		String signature = wc.getSignature(); // 微信加密签名  
        String timestamp = wc.getTimestamp(); // 时间戳  
        String nonce = wc.getNonce();// 随机数  
        String echostr = wc.getEchostr();// 随机字符串  
        System.out.println(signature);
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            return echostr;  
        } else {  
            System.out.println("不是微信服务器发来的请求,请小心!");  
            return null;
        }  
	}
	@RequestMapping(value="/api",method = RequestMethod.POST)
	@ResponseBody
	public String getWeiXinMessage(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        //初始化配置文件
        String respMessage = CoreService.processRequest(request);//调用CoreService类的processRequest方法接收、处理消息，并得到处理结果；
        
        // 响应消息  
        //调用response.getWriter().write()方法将消息的处理结果返回给用户
        return respMessage;	
	}
	  @RequestMapping(value="/setOpenid")
	    public String getUserOpenid(HttpServletRequest request,HttpServletResponse res) throws IOException, Exception{
	        System.out.println("获取的code::::"+request.getParameter("code"));
	        String appid = Constants.APPID;
	        String secret = Constants.SECRET;
	        String code=request.getParameter("code");
	        JsonObject openidtoken = WeixinUtil.getOpenid(appid, secret, code);
	        System.out.println("openidtoken:"+openidtoken); 
	        String openid=openidtoken.get("openid").toString();
	        openid=openid.replace("\"", "");
	        OpenidUtil.setOpenid(openid,request);
	        return "redirect:/shouyeaa.do";
	    }
	public static void main(String[] args) {
		
		String signature = "E56004E954970049C37E8E3413432A7BB17D1A93"; // 微信加密签名  
        String timestamp = "12131"; // 时间戳  
        String nonce = "32432";// 随机数  
        String echostr = "fddsads";// 随机字符串  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
        	System.out.println("接入成功");
        } else {  
            System.out.println("不是微信服务器发来的请求,请小心!");  
        }  
	}
	
	
	@Autowired
	private JMFServiceImp jmf;
	
	@RequestMapping("goindex")
	private String goindex(){
		
		return "/houtai/index";
	}
	
	@ResponseBody
	@RequestMapping("login")
	private int login(Commodity com,HttpServletRequest request){
		Commodity comm = jmf.loginAdmin(com);
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(0);
		if(comm!=null){
			request.getSession().setAttribute("com", comm);
			return comm.getAdmin_id();
		}else{
			return 0;
		}
	}
	
	
	@ResponseBody
	@RequestMapping("status")
	private List status(){
		List list = jmf.status();
		return list;
	}
	
	//注销登录
	@RequestMapping("zhuxiao")
	private String zhuxiao(HttpSession session){
		session.invalidate();  
        //重定向到登录页面
        return "redirect:goindex.do";  
	}
	
	
	@RequestMapping("orderInquiry")
	private String orderInquiry(HttpServletRequest request,Model model,@RequestParam(defaultValue="")String end,@RequestParam(defaultValue="")String start,@RequestParam(defaultValue="")String status_id,@RequestParam(defaultValue="1")String currentPage,@RequestParam(defaultValue="")String orders,@RequestParam(defaultValue="")String address_tel,@RequestParam(defaultValue="")String address_name){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
		Map map = new HashMap(); 
		map.put("orders", orders);
		map.put("address_tel", address_tel);
		map.put("address_name", address_name);
		map.put("status_id", status_id);
		map.put("start", start);
		map.put("end", end);
		
		
		String pageSize="20";
		int count=jmf.findCount(map);
		Page page=new Page(currentPage, count, pageSize);
		int a=Integer.parseInt(currentPage);
		int b=Integer.parseInt(pageSize);
		map.put("index", (a-1)*b);
		map.put("pagesize", b);
		//查询后台显示订单信息
		List<Commodity> list = jmf.orderAllList(map);
		//return list;
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("orders", orders);
		model.addAttribute("address_tel", address_tel);
		model.addAttribute("address_name", address_name);
		model.addAttribute("status_ida", status_id);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		return "/houtai/orderInquiry";
	}
	}
	
	
	
	
	@RequestMapping("orderInquiry2")
	private String orderInquiry2(HttpServletRequest request,Model model,@RequestParam(defaultValue="")String end,@RequestParam(defaultValue="")String start,@RequestParam(defaultValue="")String status_id,@RequestParam(defaultValue="1")String currentPage,@RequestParam(defaultValue="")String orders,@RequestParam(defaultValue="")String address_tel,@RequestParam(defaultValue="")String address_name){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
		Map map = new HashMap(); 
		map.put("orders", orders);
		map.put("address_tel", address_tel);
		map.put("address_name", address_name);
		map.put("status_id", status_id);
		map.put("start", start);
		map.put("end", end);
		
		
		String pageSize="20";
		int count=jmf.findCount2(map);
		Page page=new Page(currentPage, count, pageSize);
		int a=Integer.parseInt(currentPage);
		int b=Integer.parseInt(pageSize);
		map.put("index", (a-1)*b);
		map.put("pagesize", b);
		//查询后台显示订单信息
		List<Commodity> list = jmf.orderAllList3(map);
		//return list;
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("orders", orders);
		model.addAttribute("address_tel", address_tel);
		model.addAttribute("address_name", address_name);
		model.addAttribute("status_ida", status_id);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		return "/houtai/orderInquiry2";
	}
	
	}
	
	//订单修改
	@RequestMapping("orderEdit")
	private String orderEdit(HttpServletRequest request,String orders,Model model){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
		Commodity list = jmf.orderAllList2(orders);
		model.addAttribute("orders", orders);
		model.addAttribute("aa", list);
		return "/houtai/orderEdit";
	}
	}
	
	//订单修改Admin
	@RequestMapping("orderEditAdmin")
	private String orderEditAdmin(HttpServletRequest request,String orders,Model model){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
			Commodity list = jmf.orderAllList2(orders);
			model.addAttribute("orders", orders);
			model.addAttribute("aa", list);
			return "/houtai/orderEditAdmin";
		}
	}
	
	@RequestMapping("updateStarts")
	private void updateStarts(String status_id,String order_id){
		Map map = new HashMap();
		map.put("status_id", status_id);
		map.put("order_id", order_id);
		jmf.updateStarts(map);
	}

	@RequestMapping("updateOrders")
	private void updateOrders(Commodity com){
		Map map = new HashMap();
		map.put("city", com.getCity());
		map.put("district", com.getDistrict());
		map.put("area", com.getArea());
		map.put("address", com.getAddress());
		map.put("address_name", com.getAddress_name());
		map.put("address_tel", com.getAddress_tel());
		map.put("openid", com.getOpenid());
		
		map.put("order_com", com.getOrder_com());
		map.put("order_price", com.getOrder_price());
		map.put("logistics", com.getLogistics());
		
		//修改地址
		jmf.updateAddre(map);
		//修改订单
		jmf.updateOrders(map);
		
	}
	
	//跳转到修改
	@RequestMapping("passwordReset")
	private String passwordReset(HttpServletRequest request,Model model){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
			int admin_id = com.getAdmin_id();
			model.addAttribute("admin_id", admin_id);
			return "/houtai/passwordReset";
		}
		
		
	}
	
	//跳转到修改 总后台修改
	@RequestMapping("passwordResetAdmin")
	private String passwordResetAdmin(HttpServletRequest request,Model model){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
			int admin_id = com.getAdmin_id();
			model.addAttribute("admin_id", admin_id);
			return "/houtai/passwordResetAdmin";
		}
		
		
	}
	
	//密码重置
	@ResponseBody
	@RequestMapping("updatePwd")
	private int updatePwd(HttpServletRequest request,String password,String password1,int admin_id){
		
		Map map = new HashMap();
		map.put("password", password);
		map.put("password1", password1);
		map.put("admin_id", admin_id);
		
		Commodity com = jmf.findByPwd(map);
		if(com==null){
			return 1;
		}else{
			jmf.updatePwd(map);
			return 0;
		}
		
	}
	
	
	//密码总后台管理
	@RequestMapping("allPwd")
	private String allPwd(HttpServletRequest request,Model model){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
			List list = jmf.allPwdFind();
			model.addAttribute("list", list);
		
			return "/houtai/passwordAll";
		
		}
		
	}

	
	//密码总后台管理跳转到添加页面
	@RequestMapping("addAdmin")
	private String addAdmin(HttpServletRequest request){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
		return "/houtai/addAdmin";
	}
	}
	//添加管理
	@ResponseBody
	@RequestMapping("addAdminUser")
	private int addAdminUser(Commodity com){
		
		String admin_name = com.getAdmin_name();
		Commodity findName = jmf.findName(admin_name);
		if(findName!=null){
			return 0;
		}else{
			jmf.addAdminUser(com);
			return 1;
		}
	}
	
	
	
	//添加管理
	@RequestMapping("updateAdminPw")
	private String updateAdminPw(String admin_id,HttpServletRequest request,Model model){
		Commodity com = (Commodity) request.getSession().getAttribute("com");
		if(com==null){
			return "redirect:goindex.do";
		}else{
			Commodity c = jmf.updateAdminPw(admin_id);
			model.addAttribute("c", c);
			
			return "/houtai/updateAdminPw";
		}
		
	}
	
	
	//总管理修改管理密码
	@ResponseBody
	@RequestMapping("xgAdmin")
	private int xgAdmin(String admin_id,String admin_pwd){
			Map map = new HashMap();
			map.put("admin_id", admin_id);
			map.put("admin_pwd", admin_pwd);
			jmf.xgAdmin(map);
			return 1;
		
	}
	
	//删除账号
	@ResponseBody
	@RequestMapping("deleteAdmin")
	private void deleteAdmin(String admin_id){
			jmf.deleteAdmin(admin_id);
		
	}
	
}
