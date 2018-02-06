package com.jiumenfang.user.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.google.gson.JsonObject;
import com.jiumenfang.user.bean.Commodity;
import com.jiumenfang.user.service.JMFServiceImp;
import com.jiumenfang.utils.EmojiFilter;
import com.jiumenfang.utils.HttpKit;
import com.jiumenfang.utils.OpenidUtil;
import com.pay.tenpay.util.RequestHandler;

import java.util.Map.Entry;

import org.jdom.input.SAXBuilder;

import org.jdom.Document;
import org.jdom.Element;



@Controller
public class JMFController {
	@Autowired
	private JMFServiceImp jmf; 
	
	@RequestMapping("aaa")
	private String aaa(){
		return "aaaaa";
	}
	
	//查询首页显示数据
	@RequestMapping("shouyeaa")
	private String startList(Model model,HttpServletRequest request){
				//获取用户信息
				JsonObject openInfo = OpenidUtil.getOpenInfo(request);
				String name = openInfo.get("nickname").getAsString()+1;
				name = EmojiFilter.filterEmoji(name);
				String openid = OpenidUtil.getOpenid(request);
				//建立map集合
				Map map = new HashMap();
				map.put("user_name", name);
				map.put("openid", openid);
				Commodity openiddd = jmf.openidlength(map);
				//添加用户信息到用户表
				if(openiddd==null){
					jmf.addUser(map);
				}
				//修改昵称
				jmf.updateUserName(map);
				
				//系列产品展示
				List list = jmf.startList();
				model.addAttribute("list", list);
				return "series";
	}
	
	
	//显示系列产品
	@RequestMapping("commodityList")
	private String commodityList(String start_id,Model model,HttpServletRequest request){
		
		//商品数据显示
		Commodity com = jmf.leibieimg(start_id);
		model.addAttribute("com", com);
		List list = jmf.commodityList(start_id); 
		model.addAttribute("list", list);
		return "commodityList";
	}
	
	
	//根据商品id查询商品详情显示数据
	@RequestMapping("comList")
	private String comList(Commodity com,Model model){
		//商品id查询商品详情数据
		Commodity comm = jmf.comList(com); 
		//根据商品id查询商品详情图片
		List dynamic = jmf.dynamicimg(comm.getCom_id());
		model.addAttribute("dynamic", dynamic);
		model.addAttribute("aa", comm);
		return "singlePro";
	}


	
	//退款
	@ResponseBody
	@RequestMapping("tuikuan")
	private int tuikuan(String order_id){
		//建立map集合
		Map map = new HashMap();
		map.put("order_id", order_id);
		map.put("status_id",7);
		jmf.tuikuan(map);
		return 1;
	}
	
	//退货
	@ResponseBody
	@RequestMapping("tuihuo")
	private int tuihuo(String order_id){
		//建立map集合
		Map map = new HashMap();
		map.put("order_id", order_id);
		map.put("status_id",4);
		jmf.tuikuan(map);
		return 1;
	}
	
	//加入购物车
	@RequestMapping("addshop")
	private void addshop(Commodity com,int com_id,int id,HttpServletRequest request){
		
		//建立map集合
		Map map = new HashMap();
		map.put("shop_num", id);
		map.put("com_id",com_id);
		
		//获取用户信息
		JsonObject openInfo = OpenidUtil.getOpenInfo(request);
		String openid = OpenidUtil.getOpenid(request);
		map.put("openid", openid);
		
				//根据用户openid查询用户id
				int a = jmf.findUserId(map);
				map.put("user_id",a);
		
				//获取本地时间
				String date = null;
				SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date = sm.format(new Date());
				map.put("shop_time", date);
		
				//根据openid查询是否有此用户
				Commodity openiddd = jmf.openidlength(map);
				map.put("user_id", openiddd.getUser_id());
			
				//判断该用户的购物车里是否有此商品
				Commodity shopid = jmf.findshopid(map);
				if(shopid==null){
					//添加购物车表
					jmf.addshop(map);
				}else{
					//查询该用户的商品数量
					int shopnum = jmf.shopNum(map);
					//算出要修改的值
					int number = shopnum+id;
					map.put("shop_numm", number);
					//修改商品的数量
					jmf.updateShop_Num(map);
				} 
		
					//查询购物车id
					List lists = jmf.ShopIds(openid);
					for (Object obj : lists) {
						Integer shop_id = ((Commodity) obj).getShop_id();
						//放入map
						map.put("shop_id", shop_id);
						//把用户id和购物车id存入中间表
						jmf.addUserIdAndShopId(map);
					}
	}
		
	//加减数量
	@RequestMapping("plusminus")
	private void plusminus(HttpServletRequest request,String com_id,int shop_num){
		//获取用户信息
		String openid = OpenidUtil.getOpenid(request);
		//建立map集合
		Map map = new HashMap ();
		map.put("openid",openid);
		map.put("com_id",com_id);
		if(shop_num<1){
			shop_num=1;
			map.put("shop_num",shop_num);
		}else{
			map.put("shop_num",shop_num);
		}
		//根据用户openid和商品id查询购物车id
		int shop_id = jmf.Ids(map);
		map.put("shop_id", shop_id);
		
		//根据shopid修改shop_num
		jmf.updateShopNum(map);
	}
	
	//查询购物车数量
	@ResponseBody
	@RequestMapping("findAllShopNum")
	private int findAllShopNum(HttpServletRequest request){
		//获取用户信息
		String openid = OpenidUtil.getOpenid(request);
		//建立map集合
		Map map = new HashMap ();
		map.put("openid",openid);
		//根据用户openid查询用户id
		int user_id = jmf.findUserId(map);
		//根据用户id查询购物车的商品id和商品数量
		List ids = jmf.findShopIds(user_id);
		int shop_num = 0;
		for (Object obj : ids) {
			int shop_num2 = Integer.parseInt(((Commodity) obj).getShop_num());
			shop_num += shop_num2;
		}
		return shop_num;
	}
	
	//查询购物车
	@RequestMapping("findShopgouwu")
	private String findShop(Commodity com,HttpServletRequest request,Model model){
		
		//获取用户信息
		JsonObject openInfo = OpenidUtil.getOpenInfo(request);
		String openid = OpenidUtil.getOpenid(request);
		
		//建立map集合
		Map map = new HashMap ();
		map.put("openid",openid);
		
			//根据用户openid查询用户id
			int user_id = jmf.findUserId(map);
			//根据用户id查询购物车的商品id和商品数量
			List ids = jmf.findShopIds(user_id);
			List list = new ArrayList();
			for (Object obj : ids) {
				Integer com_id = ((Commodity) obj).getCom_id();
				String shop_num = ((Commodity) obj).getShop_num();
				map.put("com_id", com_id);
				Commodity comm = jmf.findCom(map);
				comm.setShop_num(shop_num);
				list.add(comm);
			}
			model.addAttribute("findCom", list);
		return "shoppingCart";
		
	}
	
	//删除购物车
	@RequestMapping("deleteShop")
	private void deleteShop(String com_id,HttpServletRequest request){
			//获取用户信息
			JsonObject openInfo = OpenidUtil.getOpenInfo(request);
			String openid = OpenidUtil.getOpenid(request);
			
			//建立map集合
			Map map = new HashMap ();
			map.put("openid",openid);
			map.put("com_id",com_id);
			
			//根据用户openid和商品id查询购物车id
			int shop_id = jmf.Ids(map);
			map.put("shop_id", shop_id);
			//删除购物车表
			jmf.deleteShop(map);
			//删除购物车中间表
			jmf.deleteUserShop(map);
	}

	//跳转到支付页面 
	@RequestMapping("togoingby")
	private String togoingby(String com_id,String abc,String order_price,String shop_num,HttpServletRequest request,Model model){
		//获取用户信息
		JsonObject openInfo = OpenidUtil.getOpenInfo(request);
		String openid = OpenidUtil.getOpenid(request);
		
		//建立map集合
		Map map = new HashMap ();
		map.put("openid",openid);
		map.put("com_id",com_id);
		map.put("order_price",order_price);
		map.put("shop_num",shop_num);
		List list = new ArrayList();
		String[] ch = com_id.split(",");
		String order_com=null;
		for (String id : ch) {
			map.put("com_id", id);
			//通过com_id查询商品
			Commodity com = jmf.findCom(map);
			if(abc==""||abc==null){
				//通过com_id和openid查询商品数量
				Commodity comm = jmf.findShop_numm(map);
				com.setShop_num(comm.getShop_num());
			}else{
				com.setShop_num(shop_num);
			}
			list.add(com);
		}
				//获取本地时间
				String orderss = null;
				//用户ID+本地时间用作订单号
				SimpleDateFormat sms=new SimpleDateFormat("yyyyMMddHHmmssSSS");
				orderss = sms.format(new Date());
				int user_id = jmf.findUserId(map);
				//拼接订单编号
				String orders =orderss+user_id;
				//根据openid查询收货地址
				Commodity address = jmf.findAddressId(openid);
				//如果地址是空添加
				if(address==null){
					//添加openid到收货地址
					jmf.addAddress(openid);
				}
				model.addAttribute("address", address);
				model.addAttribute("orders", orders);
				model.addAttribute("list", list);
				model.addAttribute("order_price", order_price);
				model.addAttribute("abc", abc);
		return "pay";
	}
	
	//我的订单
	@RequestMapping("tomyOrdersss")
	private String tomyOrder(Commodity com,HttpServletRequest request,Model model){
		//获取用户信息
		String openid = OpenidUtil.getOpenid(request);
		//建立map集合
		Map map = new HashMap();
		map.put("openid",openid);
		//根据openid查询订单详情
		List list = jmf.fingOrder(openid);
		//根据openid查询地址详情
		Commodity comm = jmf.fingAddre(openid);
		System.out.println("comm++++"+comm);
		System.out.println("list++++"+list);
		System.out.println();
		model.addAttribute("comm", comm);
		model.addAttribute("list", list);
		return "myOrder";
	}
	
	
	//点击支付 添加订单
		@RequestMapping("goingby")
		private String goingby(String shop_numtt,String comid,Commodity com,String abc,HttpServletRequest request,Model model){
					//获取用户信息
					String openid = OpenidUtil.getOpenid(request);
					String order_price = com.getOrder_price();
					String orders = com.getOrders();
					Map map = new HashMap ();
					map.put("openid",openid);
					map.put("address_name",com.getAddress_name());
					map.put("address_tel",com.getAddress_tel());
					map.put("city",com.getCity());
					map.put("district",com.getDistrict());
					map.put("area",com.getArea());
					map.put("address",com.getAddress());
					map.put("orders",com.getOrders());
					map.put("order_price",com.getOrder_price());
					map.put("status_id", 1);
					//修改收货地址
					jmf.updateAddress(map);
					//获取收货地址id
					int address_id = jmf.address_id(openid);
					map.put("address_id", address_id);
					//添加订单
					//截取","
					String[] ccc = comid.split(",");
					String order_com = "";
					for (String id : ccc) {
						map.put("com_id", id);
						//通过com_id查询商品
						Commodity comm = jmf.findCom(map);
						if(abc==null||abc==""){
							//通过com_id和openid查询商品数量
							String shop_num = jmf.findShopNum(map);
							//拼接字符串
							order_com+=comm.getCom_name()+"　　"+"X"+shop_num+"</br></br>";	
						}else{
							order_com+=comm.getCom_name()+"　　"+"X"+shop_numtt+"</br></br>";	
						}
						
						//根据用户openid和商品id查询购物车id
						if(abc==null||abc==""){
							int shop_id = jmf.Ids(map);
							map.put("shop_id", shop_id);
							//删除购物车表
							jmf.deleteShop(map);
							//删除购物车中间表
							jmf.deleteUserShop(map);
						}
					}
					map.put("order_com", order_com);
					//获取本地时间
					String order_time = null;
					SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					order_time = sm.format(new Date());
					map.put("order_time", order_time);
					//通过订单号查看是否是用户返回继续支付
					
					List list = jmf.Forders(orders);
					if(list.size()!=0){
						//获取本地时间
						String orderss = null;
						SimpleDateFormat sms=new SimpleDateFormat("SSS");
						orderss = sms.format(new Date());
						orders = orders+orderss;
						map.put("orders", orders);
					}
					//添加订单表
					jmf.addOrder(map);
					
					
					model.addAttribute("order_price", order_price);
					model.addAttribute("orders", orders);
					return "redirect:wxpay.do";
		}
	
	
	
	
	
	
	
	
	
	
	
	//支付成功修改状态
	@ResponseBody
	@RequestMapping(value = "payOk", produces = "application/json;charset=UTF-8")
	private void updateStatus(HttpServletRequest request, HttpServletResponse response){
		
		String out_trade_no=null;
	    String return_code =null;
	    try {
	        InputStream inStream = request.getInputStream();
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = inStream.read(buffer)) != -1) {
	            outSteam.write(buffer, 0, len);
	        }
	        outSteam.close();
	        inStream.close();
	        String resultStr  = new String(outSteam.toByteArray(),"utf-8");
	        Map<String, Object> resultMap = parseXmlToList(resultStr);
	        String result_code = (String) resultMap.get("result_code");
	        String is_subscribe = (String) resultMap.get("is_subscribe");
	        String transaction_id = (String) resultMap.get("transaction_id");
	        String sign = (String) resultMap.get("sign");
	        String time_end = (String) resultMap.get("time_end");
	        String bank_type = (String) resultMap.get("bank_type");

	        out_trade_no = (String) resultMap.get("out_trade_no");
	        return_code = (String) resultMap.get("return_code");

	        request.setAttribute("out_trade_no", out_trade_no);
	        //通知微信.异步确认成功.必写.不然微信会一直通知后台.八次之后就认为交易失败了.
	        response.getWriter().write(RequestHandler.setXML("SUCCESS",""));
	    }  catch (Exception e) {
	        System.out.println("微信回调接口出现错误："+e);
	        try {
	            response.getWriter().write(RequestHandler.setXML("FAIL", "error"));
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    } 
	    if(return_code.equals("SUCCESS")){
	        //支付成功的业务逻辑
	    	String orders = out_trade_no;
	    	Map map = new HashMap();
	    	map.put("status_id", 2);
	    	map.put("orders", orders);
	    	jmf.updateStatus(map);
	    }else{
	        //支付失败的业务逻辑
	    	System.out.println("zhifu支付失败！~！~");
	    }
		
	}
	
	/**
	 * description: 解析微信通知xml
	 * 
	 * @param xml
	 * @return
	 * @author ex_yangxiaoyi
	 * @see
	 */
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private static Map parseXmlToList(String xml) {
		Map retMap = new HashMap();
		try {
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc = (Document) sb.build(source);
			Element root = doc.getRootElement();// 指向根节点
			List<Element> es = root.getChildren();
			if (es != null && es.size() != 0) {
				for (Element element : es) {
					retMap.put(element.getName(), element.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//获取地址回显
	@ResponseBody
	@RequestMapping("xiala")
	private Commodity xiala(HttpServletRequest request){
		//获取用户信息
		JsonObject openInfo = OpenidUtil.getOpenInfo(request);
		String openid = OpenidUtil.getOpenid(request);
		
		//根据openid查询收货地址
		Commodity address = jmf.findAddressId(openid);
		return address;
	}
	
	
 
	//微信支付
	@RequestMapping("wxpay")
	private String wxpay(String order_price,String orders,HttpServletRequest request,Model model) throws Exception{
	        String openid = OpenidUtil.getOpenid(request);
	        //得到金额
	        String money=  order_price;
	        Map<String ,String > map=new HashMap<String,String>();
	        //获取随机串
	        String nonceStr=UUID.randomUUID().toString().substring(0, 32);
	        //可以是支付物品的订单号。一个号码，看自己怎么给
	        String out_trade_no=orders;        
	        //支付金额。微信默认支付是(1=0.01)的比例，下面是将金额换算成微信可识别的
	        BigDecimal re1=new BigDecimal(money);  
	        BigDecimal re2=new BigDecimal(Float.toString(100.00f)); 
	        Float aa = re1.multiply(re2).floatValue();
	        String total_fee = String.valueOf(aa);
	        String[] smill = total_fee.split("\\.");
	        total_fee = smill[0];
	        //微信的appid
	        String appid="wx93181819016578af";
	        String body="jmf";//商品信息，可以自己起最好写英文
	        String mch_id="1481228222";//商户号
	        //密匙,商户平台的支付API密匙，注意是商户平台，不是微信平台
	        String key = "20172017jiumenfangjiumenfang2017";
	        long timestamp = System.currentTimeMillis() / 1000;
	        map.put("appid", appid );
	        map.put("body", body);
	        map.put("mch_id", mch_id);
	        map.put("nonce_str",nonceStr);
	        //这里是支付成功后返回的地址，微信会以XML形式放回数据,(例：wxxml())方法名。
	        map.put("notify_url", "http://www.jiumenfang.cn/jiumenfang/payOk.do");
	        map.put("out_trade_no", out_trade_no);
	        map.put("spbill_create_ip","223.223.204.163");
	        map.put("total_fee", total_fee);
	        map.put("trade_type", "JSAPI");
	        map.put("openid", openid);//传入OpenId
	        
	        //这里传入Map集合和key商户支付密匙
	        String paySign=getPayCustomSign(map,key);
	        map.put("sign",paySign);
	        
	        //将map转为XML格式
	        String xml= ArrayToXml(map);
	        //统一下单，这里不用改 
	        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder"; 
	        String xmlStr = HttpKit.post(url, xml);  
	        //prepayid由微信返回的 。
	        String prepay_id = ""; 
	        if (xmlStr.indexOf("SUCCESS") != -1) {  
	            Map<String, String> map2 = doXMLParse(xmlStr);  
	            prepay_id = (String) map2.get("prepay_id");  
	        } 
            Map<String, String> payMap = new HashMap<String, String>();  
            payMap.put("appId", appid);  
            payMap.put("timeStamp", String.valueOf(timestamp));  
            payMap.put("nonceStr", nonceStr);  
            payMap.put("signType", "MD5");  
            payMap.put("package", "prepay_id=" + prepay_id);  
            String paySign2=getPayCustomSign(payMap,key);
	        
	        
	        model.addAttribute("appId", appid);
	        model.addAttribute("paytimestamp", String.valueOf(timestamp));//时间戳1503305126
	        model.addAttribute("paynonceStr", nonceStr);//随机串
	        model.addAttribute("paypackage", "prepay_id="+prepay_id);//prepayid
	        model.addAttribute("paysignType", "MD5");//
	        model.addAttribute("paySign", paySign2);//签名 1E18BEC85C1EBF0F280FCC66CEBFB8C1
		        
	        //去到确认支付页面,返回页面方式不同,(例：pay.html页面)，下面
	        return "WXPay";
	}
	
	@RequestMapping("text")
	private String text(){
		
		return "text";
	}
	
	
	
	/**
     * 获取支付所需签名
     * @param ticket
     * @param timeStamp
     * @param card_id
     * @param code
     * @return
     * @throws Exception
     */
    public static String getPayCustomSign(Map<String, String> bizObj,String key) throws Exception {
        String bizString = FormatBizQueryParaMap(bizObj, false);
        return sign(bizString, key);
    }
	
	
    
    /**
     * 字典排序
     * @param paraMap
     * @param urlencode
     * @return
     * @throws Exception
     */
    public static String FormatBizQueryParaMap(Map<String, String> paraMap,
            boolean urlencode) throws Exception {
        String buff = "";
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(paraMap.entrySet());
            Collections.sort(infoIds,
                    new Comparator<Map.Entry<String, String>>() {
           public int compare(Map.Entry<String, String> o1,
                  Map.Entry<String, String> o2) {
                 return (o1.getKey()).toString().compareTo(
                                    o2.getKey());
                        }
                    });
            for (int i = 0; i < infoIds.size(); i++) {
                Map.Entry<String, String> item = infoIds.get(i);
                if (item.getKey() != "") {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlencode) {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    buff += key + "=" + val + "&";
                }
            }
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return buff;
    }
    
    
    //支付所需签名处调用此方法
    public static String sign(String content, String key)
            throws Exception{
        String signStr = "";
        signStr = content + "&key=" + key;
        return MD5(signStr).toUpperCase();
    }
    
    
  //上一方法，MD5加密处理
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
       }
    }

    
    
    
    //转为XML格式
    public static String ArrayToXml(Map<String, String> arr) {
        String xml = "<xml>";
        Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String val = entry.getValue();
            if (IsNumeric(val)) {
                xml += "<" + key + ">" + val + "</" + key + ">";
            } else
                xml += "<" + key + "><![CDATA[" + val + "]]></" + key + ">";
        }
        xml += "</xml>";
        return xml;
    }

    public static boolean IsNumeric(String str) {
        if (str.matches("\\d *")) {
            return true;
        } else {
            return false;
        }
    }
    
    //解析XML
    private Map<String, String> doXMLParse(String xml)  
            throws XmlPullParserException, IOException {  

        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());  

        Map<String, String> map = null;  

        XmlPullParser pullParser = XmlPullParserFactory.newInstance()  
                .newPullParser();  

        pullParser.setInput(inputStream, "UTF-8");// 为xml设置要解析的xml数据  

        int eventType = pullParser.getEventType();  

        while (eventType != XmlPullParser.END_DOCUMENT) {  
            switch (eventType) {  
            case XmlPullParser.START_DOCUMENT:  
                map = new HashMap<String, String>();  
                break;  

            case XmlPullParser.START_TAG:  
                String key = pullParser.getName();  
                if (key.equals("xml"))  
                    break;  
                String value = pullParser.nextText();  
                map.put(key, value);  
                break;  
            case XmlPullParser.END_TAG:  
                break; 
            }  
            eventType = pullParser.next();  
        } 
        return map;  
    }  
    
    
    
}