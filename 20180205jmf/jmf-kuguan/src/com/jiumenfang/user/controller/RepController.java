 package com.jiumenfang.user.controller;
 
 import com.jiumenfang.user.bean.Address;
 import com.jiumenfang.user.bean.Channal;
 import com.jiumenfang.user.bean.City;
 import com.jiumenfang.user.bean.Client;
 import com.jiumenfang.user.bean.Danzheng;
 import com.jiumenfang.user.bean.Huocun;
 import com.jiumenfang.user.bean.Orders;
 import com.jiumenfang.user.bean.Outs;
 import com.jiumenfang.user.bean.Pandian;
 import com.jiumenfang.user.bean.Repertory;
 import com.jiumenfang.user.bean.Reps;
 import com.jiumenfang.user.bean.Transport;
 import com.jiumenfang.user.bean.Tuihuo;
 import com.jiumenfang.user.bean.Upload;
 import com.jiumenfang.user.bean.Upload1;
 import com.jiumenfang.user.bean.User;
 import com.jiumenfang.user.bean.chuOrder;
 import com.jiumenfang.user.service.RepService;
 import com.jiumenfang.utils.Page;
 import java.awt.image.BufferedImage;
 import java.io.BufferedOutputStream;
 import java.io.ByteArrayOutputStream;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.text.DateFormat;
 import java.text.DecimalFormat;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Iterator;
 import java.util.LinkedHashSet;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
 import java.util.TreeSet;
 import javax.imageio.ImageIO;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.poi.hssf.usermodel.HSSFCell;
 import org.apache.poi.hssf.usermodel.HSSFCellStyle;
 import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
 import org.apache.poi.hssf.usermodel.HSSFPatriarch;
 import org.apache.poi.hssf.usermodel.HSSFRow;
 import org.apache.poi.hssf.usermodel.HSSFSheet;
 import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;
 
 @Controller
 public class RepController
 {
 
   @Autowired
   private RepService repService;
      private static long counter = 618;
 
   @RequestMapping({"toHoutaiLogin"})
   public String toHoutaiLogin()
   {
         return "tubeBack/src/jsp/login";
   }
 
   @ResponseBody
   @RequestMapping({"houtaiLogin"})
   private int houtaiLogin(User user, HttpServletRequest request) {
         List list = repService.login(user);
         User u1 = null;
         for (Object object:list ) { 
           u1 = (User)object;
     }
         HttpSession session = request.getSession();
         session.setMaxInactiveInterval(0);
 
         if ((u1 != null) && (u1.getPer_hid() != 0)) {
           request.getSession().setAttribute("user", u1);
           return u1.getUser_id();
     }
        
 
         return 0;
   }
 
   @RequestMapping({"stock"})
   public String stock(Model model, HttpServletRequest request, @RequestParam(defaultValue="1") String currentPage)
   {
         User user = (User)request.getSession().getAttribute("user");
         if (user == null) {
           return "redirect:toHoutaiLogin.do";
     }
        Map map = new HashMap();
        String pageSize = "18";
        int count = repService.findCount();
        
        
        Page page = new Page(currentPage, count, pageSize);
        int a = Integer.parseInt(currentPage);
        int b = Integer.parseInt(pageSize);
        map.put("index", (a - 1) * b);
        map.put("pagesize", b);
        List list = repService.stock(map);
        List list3 = repService.cha1(user.getUser_id());
        String per_hid = "";
        for (Object object:list3 ) {
          User u = (User)object;
          per_hid = per_hid + "," + u.getPer_hid();
     }
        per_hid = per_hid.substring(1);
        model.addAttribute("user_id", user.getUser_id());
        model.addAttribute("per_hid", per_hid);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        model.addAttribute("user_name", user.getUser_name());
        return "tubeBack/src/jsp/inventory";
   }
 
   @RequestMapping({"out"})
   public String out(String rep_id, String rep_out, HttpServletRequest request,Model model) {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:toHoutaiLogin.do";
      }
        Date date1 = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time1 = format1.format(date1);
 
        Set set = new TreeSet();
        String[] split = rep_id.split(",");
        for (int i = 0; i < split.length; i++) {
          set.add(split[i]);
     }
        Map map = new HashMap();
        map.put("out_date", time1);
        Iterator it = set.iterator();
        map.put("user_id", user.getUser_id());
        String[] split2 = rep_out.split(",");
        for (int i=0;i<split2.length;i++) {
          map.put("rep_id", it.next());
          map.put("out_num", split2[i]);
          repService.insertOut(map);
          model.addAttribute("rep_id", rep_id);
 
     }
 
        Repertory rep1 = new Repertory();
        int ab = 0;
        Repertory rep=null;
        List list = repService.selectOut1(map);
        for (Iterator localIterator1 = list.iterator(); localIterator1.hasNext(); ) { Object object = localIterator1.next();
         rep = (Repertory)object;
          rep1.setOut_num(rep.getOut_num());
          ab += Integer.parseInt(rep1.getOut_num());
     }
        List list3 = repService.cha1(user.getUser_id());
        String per_hid = "";
        for (Object object:list3 ) {
          User u = (User)object;
          per_hid = per_hid + "," + u.getPer_hid();
     }
        per_hid = per_hid.substring(1);
        model.addAttribute("user_id", user.getUser_id());
        model.addAttribute("per_hid", per_hid);
        map.put("ab", ab);
        model.addAttribute("out_date", time1);
        model.addAttribute("ab", ab);
        return "tubeBack/src/jsp/inventory2";
   }
   @RequestMapping({"chan"})
   @ResponseBody
   public List chan(Model model) {
        List list = repService.chan();
        model.addAttribute("list", list);
        return list;
   }
   @RequestMapping({"tran"})
   @ResponseBody
   public List tran(Model model) {
        List list = repService.tran();
        model.addAttribute("list", list);
        return list;
   }
   @RequestMapping({"city"})
   @ResponseBody
   public List city(Model model) {
        List list = repService.city();
        model.addAttribute("list", list);
        return list;
   }
 
   @RequestMapping({"aimags"})
   @ResponseBody
   public Map aimags(String rep_ids, Address add, Repertory rep, Client cli, Channal chan, Transport tran, String aimags, HttpServletRequest request,String yundan) {
        User user = (User)request.getSession().getAttribute("user");
 
        Date date1 = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time1 = format1.format(date1);
        request.getSession().setAttribute("time1", time1);
        String[] split1 = add.getAddress_name().split(",");
        String city_name = split1[0];
        String[] split = rep_ids.split(",");
        String address_name = add.getAddress_name().replaceAll("[,]", "");
 
        Map map = new HashMap();
        map.put("user_id", user.getUser_id());
        map.put("address_date", time1);
        map.put("address_name", address_name);
        map.put("address_notes", add.getAddress_notes());
        map.put("yundan", yundan);
        map.put("city_name", city_name);
        map.put("city_date", time1);
        repService.insertAddress(map);
        repService.insertCity_name(map);
        City city = repService.selectCity_id(map);
 
        Address a = repService.selectAddress(map);
 
        map.put("client_date", time1);
        map.put("client_name", cli.getClient_name());
        map.put("client_tel", cli.getClient_tel());
        repService.insertClient(map);
 
        Client c = repService.selectClient(map);
 
        for (int i = 0; i < split.length; i++) {
          map.put("rep_id", split[i]);
          map.put("address_id", a.getAddress_id());
          map.put("reps_date", time1);
          repService.updateAddressId(map);
          map.put("rep_id", split[i]);
 
          map.put("client_id", c.getClient_id());
          repService.updateClientId(map);
     }
        long l = counter++;
        String date3=null;
        String sequ =null;
        if(l<10){
        	date3 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        	sequ = new DecimalFormat("000000").format(l);
        }else if(l>=10&&l<100){
        	date3 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        	sequ = new DecimalFormat("000000").format(l);
        }else if(l>=100&&l<1000){
        	date3 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        	sequ = new DecimalFormat("000000").format(l);
        	
        }else if(l>=1000&&l<10000){
        	date3 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        	sequ = new DecimalFormat("000000").format(l);
        	
        }else if(l>=10000&&l<100000){
        	date3 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        	sequ = new DecimalFormat("000000").format(l);
        	
        }else{
        	
        	date3 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        	sequ = new DecimalFormat("000000").format(l);
        }
 
        Orders orders = new Orders();
        orders.setStatus_id(1);
        String order_num = date3 + sequ;
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time2 = format2.format(date1);
        request.getSession().setAttribute("time1", time1);
        map.put("order_num", order_num);
        map.put("orders_date", time1);
        map.put("orders_date1", time2);
        map.put("status_id", orders.getStatus_id());
        repService.insertOrders(map);
 
        map.put("order_num", order_num);
        map.put("orders_date", time1);
        repService.updateOrder(map);
        for (int x = 0; x < split.length; x++) {
          map.put("rep_id", split[x]);
          map.put("chan_id", chan.getChan_id());
          map.put("chan_rep_date", time1);
          repService.insertChan_rep(map);
     }
 
        for (int z = 0; z < split.length; z++) {
          map.put("rep_id", split[z]);
          map.put("tran_id", tran.getTran_id());
          map.put("tran_rep_date", time1);
          repService.insertTran_rep(map);
     }
 
        map.put("address_id", a.getAddress_id());
        map.put("city_id", city.getCity_id());
        map.put("client_id", c.getClient_id());
        map.put("chan_id", chan.getChan_id());
        map.put("tran_id",tran.getTran_id());
        map.put("time1", time1);
        return map;
   }
 
   @RequestMapping({"mon"})
   public String mon(Model model, String rep_id1, HttpServletRequest request, Transport tran, Channal chan, Address sssssss, City city, Client c, String time1, int ab, Outs outs) {
        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
        	return "redirect:toLogin.do";
        }
        Map map = new HashMap();
        map.put("user_id", user.getUser_id());
        map.put("orders_date", time1);
        map.put("address_id", sssssss.getAddress_id());
        map.put("client_id", c.getClient_id());
        map.put("city_id", city.getCity_id());
        Repertory rep = null;
        Date date1 = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        String time = format1.format(date1);
        map.put("date1", time);
        Orders or = repService.selectOrder_id(map);
        map.put("orders_id", or.getOrder_id());
        map.put("out_date", outs.getOut_date());
        map.put("out_id", outs.getOut_id());
        Set set=new TreeSet();
        Set set1=new TreeSet();
        String[] split = rep_id1.split(",");
       
        
        for (String aa : split)
     {
        	map.put("rep_id", aa);
          Repertory rep1 = repService.selectRep(map);
          map.put("reps_date", time1);
            map.put("rep", rep1);
            map.put("out_sum", ab);
            map.put("chan_id", chan.getChan_id());
            map.put("tran_id", tran.getTran_id());
            map.put("user_id", user.getUser_id());
            repService.insertReps(map);
            repService.insertOrder_rep(map);
            repService.updateOutsOrdersId(map);
            set1.add(aa);
            
            
     }
        Iterator it1=set1.iterator();
        List listo=repService.selectOutNum(map);
        	while(it1.hasNext()){
        		for (Object object : listo) {
        				map.put("rep_id", it1.next());
        				Repertory rep2 = repService.selectRep(map);
        				Outs o=(Outs) object;
        				map.put("rep_end", rep2.getRep_end());
        				map.put("out_id", o.getOut_id());
        				map.put("out_num", o.getOut_num());
        				repService.updateRep_end(map);
        				List listb=repService.selectRepEnd(map);
        				for (Object object2 : listb) {
        					Repertory r1=(Repertory) object2;
        					map.put("end_num", r1.getRep_end());
        					repService.insertEndNum(map);
        				}
        			
        		}
        	}
        
        
        
        
        map.put("order_id", or.getOrder_id());
        map.put("tran_id", tran.getTran_id());
        map.put("chan_id", chan.getChan_id());
        repService.updateRepsChan_id(map);
        List list1 = repService.selectReps_id(map);
        Reps r = null;
        for (Object object:list1 ) { 
          r = (Reps)object;
          map.put("reps_id", r.getReps_id());
          repService.insertRepsOrder(map);
     }
 
        for (int i = 0; i < split.length; i++) {
          List list = repService.mon(split[i]);
          model.addAttribute("list2", list);
     }
        List list2 = repService.selectOuts(outs.getOut_date());
        Repertory reps = null;
        for (int i = 0; i < list2.size(); i++) {
          reps = (Repertory)list2.get(i);
          map.put("rep_id", reps.getRep_id());
          map.put("out_id", reps.getOut_id());
          repService.updateReps(map);
          map.put("out_id", reps.getOut_id());
          repService.insertOrders_out(map);
     }
        
        return "redirect:stock.do";
   }
 
   @RequestMapping({"chu"})
   public String chu(Model model, @RequestParam(defaultValue="") String start, @RequestParam(defaultValue="") String end, HttpServletRequest request, @RequestParam(defaultValue="1") String currentPage)
   {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
          return "redirect:toHoutaiLogin.do";
     }
 
        Orders orders = new Orders();
        int status_id = orders.getStatus_id();
        status_id = 2;
        Map map = new HashMap();
        map.put("status_id", status_id);
        map.put("start", start);
        map.put("end", end);
        String pageSize = "18";
        int count = repService.findCount1(map);
        Page page = new Page(currentPage, count, pageSize);
        int a = Integer.parseInt(currentPage);
        int b = Integer.parseInt(pageSize);
        map.put("index", (a - 1) * b);
        map.put("pagesize", b);
        //List list = repService.chu(map);
        List list = repService.chu1(map);
        List list3 = repService.cha1(user.getUser_id());
        String per_hid = "";
        for (Object object:list3 ) { 
          User u = (User)object;
          per_hid = per_hid + "," + u.getPer_hid();
     }
        per_hid = per_hid.substring(1);
        model.addAttribute("user_id", user.getUser_id());
        model.addAttribute("per_hid", per_hid);
        model.addAttribute("page", page);
        model.addAttribute("chuList", list);
        model.addAttribute("user_name", user.getUser_name());
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "tubeBack/src/jsp/shipmentOrder";
   }
 
   @RequestMapping({"pan"})
   public String pan(Model model, @RequestParam(defaultValue="") String start, @RequestParam(defaultValue="") String end, HttpServletRequest request, @RequestParam(defaultValue="1") String currentPage)
   {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
          return "redirect:toHoutaiLogin.do";
     }
 
        Map map = new HashMap();
        map.put("start", start);
        map.put("end", end);
        String pageSize = "18";
        int count = repService.findCount2();
        Page page = new Page(currentPage, count, pageSize);
        int a = Integer.parseInt(currentPage);
        int b = Integer.parseInt(pageSize);
        map.put("index", (a - 1) * b);
        map.put("pagesize", b);
        List list = repService.pan(map);
 
        List list3 = repService.cha1(user.getUser_id());
        String per_hid = "";
        for (Object object:list3 ) {
          User u = (User)object;
          per_hid = per_hid + "," + u.getPer_hid();
     }
        per_hid = per_hid.substring(1);
        model.addAttribute("user_id", user.getUser_id());
        model.addAttribute("per_hid", per_hid);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("start", start);
        model.addAttribute("user_name", user.getUser_name());
        model.addAttribute("end", end);
        return "tubeBack/src/jsp/check1";
   }
 
   @RequestMapping({"qx"})
   @ResponseBody
   public List qx()
   {
        List list = repService.selectPermission();
        return list;
   }
      @RequestMapping({"qxh"})
   @ResponseBody
   public List qxh() { 
					List list = repService.selectPerh();
        return list; }
 
   @RequestMapping({"addUser"})
   @ResponseBody
   public int addUser(String user_name, String user_password, String per_id, String per_hid)
   {
        Map map = new HashMap();
        if(user_name!=null&&!user_name.equals("")&&user_password!=null&&!user_password.equals("")){
        	
        	map.put("user_name", user_name);
        	map.put("user_password", user_password);
        	User user = repService.selectUser(map);
        	
        	repService.insertUser(map);
        }
 
        User u = repService.selectUserId(map);
        map.put("user_id", u.getUser_id());
        if ((per_id != "") && (per_id != null) && (per_hid != "") && (per_hid != null)) {
          Set set = new TreeSet();
 
          String[] split = per_id.split(",");
          for (int i = 0; i < split.length; i++) {
            set.add(split[i]);
       }
          Set set1 = new TreeSet();
          String[] split2 = per_hid.split(",");
          for (int j = 0; j < split2.length; j++) {
            set1.add(split2[j]);
       }
          Iterator it = set.iterator();
      while(it.hasNext()){
	         Iterator it1 = set1.iterator();
					while(it1.hasNext()){
						
						       map.put("per_id", it.next());
					           map.put("per_hid", it1.next());
						
						       repService.insertUser_Per(map);
					}
       }
 
     }
        else if ((per_id != "") && (per_id != null)) {
          String[] split = per_id.split(",");
          for (int i = 0; i < split.length; i++) {
            map.put("per_id", split[i]);
            repService.insertUser_Per1(map);
       }
     }else if((per_hid != "") && (per_hid != null)){
          String[] split2 = per_hid.split(",");
          for (int j = 0; j < split2.length; j++) {
            map.put("per_hid", split2[j]);
            repService.insertUser_Per2(map);
       }
     }else{
    	 
     }
        return 0;
   }
 
   @RequestMapping({"test"})
   @ResponseBody
   public int test(User user) {
        User u = repService.test(user.getUser_name());
        if ((u != null) && (!u.equals(""))) {
          return 1;
     }
 
        return 0;
   }
 
   @RequestMapping({"zs"})
   @ResponseBody
   public List zs(Reps r)
   {
        List list = repService.zs(r.getRep_id());
        List list1 = repService.selectEndNum(r.getRep_id());
        List list2 = new ArrayList();
        list2.clear();
        Set set = new LinkedHashSet();
     Reps rs;
        for (Object object1:list1) { 
          rs = (Reps)object1;
          set.add(rs.getEnd_num());
     }
       Iterator ita = set.iterator();
       Reps reps=null;
       while (ita.hasNext()) {
        	for (Object object:list) {
        			int end_num=(int) ita.next();
        			reps = (Reps)object;
        			reps.setEnd_num(end_num);
        			list2.add(reps);
       }
        	break;
        	
     }
        return list2;
   }
 
   @RequestMapping({"cha"})
   public String cha(Model model, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
          return "redirect:toHoutaiLogin.do";
     }
 
        List list = repService.chaUser();
        List list1 = repService.selectPermission();
        List list2 = repService.selectPerh();
        List list3 = repService.cha1(user.getUser_id());
        String per_hid = "";
        for (Object object:list3) {
          User u = (User)object;
          per_hid = per_hid + "," + u.getPer_hid();
     }
        per_hid = per_hid.substring(1);
        model.addAttribute("per_hid", per_hid);
        model.addAttribute("list", list);
        model.addAttribute("list1", list1);
        model.addAttribute("user_name", user.getUser_name());
        model.addAttribute("list2", list2);
        return "tubeBack/src/jsp/permission";
   }
 
   @RequestMapping({"chaDan"})
   public String chaDan(Model model, @RequestParam(defaultValue="") String start, @RequestParam(defaultValue="") String end, HttpServletRequest request, @RequestParam(defaultValue="1") String currentPage)
   {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
          return "redirect:toHoutaiLogin.do";
     }
 
        Map map = new HashMap();
        map.put("start", start);
        map.put("end", end);
        String pageSize = "18";
        int count = repService.findCount3();
        Page page = new Page(currentPage, count, pageSize);
        int a = Integer.parseInt(currentPage);
        int b = Integer.parseInt(pageSize);
        map.put("index", (a - 1) * b);
        map.put("pagesize", b);
        List list = repService.chaDan(map);
        List list3 = repService.cha1(user.getUser_id());
        String per_hid = "";
        for (Object object:list3 ) {
          User u = (User)object;
          per_hid = per_hid + "," + u.getPer_hid();
     }
        per_hid = per_hid.substring(1);
        model.addAttribute("user_id", user.getUser_id());
        model.addAttribute("per_hid", per_hid);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("start", start);
        model.addAttribute("user_name", user.getUser_name());
        model.addAttribute("end", end);
        return "tubeBack/src/jsp/pappers";
   }
   @RequestMapping({"tu"})
   @ResponseBody
   public List tu() {
        List list = repService.chaUpload();
        List list1 = new ArrayList();
        for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
          Upload u = (Upload)object;
          list1.add(repService.selectPath(u.getUpload_id()));
     }
        return list1;
   }
 
   @RequestMapping({"chaTui"})
   public String chaTui(Model model, @RequestParam(defaultValue="") String start, @RequestParam(defaultValue="") String end, HttpServletRequest request, @RequestParam(defaultValue="1") String currentPage)
   {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
          return "redirect:toHoutaiLogin.do";
     }
 
        Map map = new HashMap();
        map.put("start", start);
        map.put("end", end);
        String pageSize = "18";
        int count = repService.findCount4();
        Page page = new Page(currentPage, count, pageSize);
        int a = Integer.parseInt(currentPage);
        int b = Integer.parseInt(pageSize);
        map.put("index", (a - 1) * b);
        map.put("pagesize", b);
        List list = repService.chaTui(map);
        List list3 = repService.cha1(user.getUser_id());
        String per_hid = "";
        for (Object object:list3 ) {
          User u = (User)object;
          per_hid = per_hid + "," + u.getPer_hid();
     }
        per_hid = per_hid.substring(1);
        model.addAttribute("user_id", user.getUser_id());
        model.addAttribute("per_hid", per_hid);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("user_name", user.getUser_name());
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "tubeBack/src/jsp/returns";
   }
   @RequestMapping({"tui"})
   @ResponseBody
   public List tui() {
        List list = repService.chaUpload1();
        List list1 = new ArrayList();
        for (Object object:list) {
          Upload1 u = (Upload1)object;
          list1.add(repService.selectPath1(u.getUpload1_id()));
     }
        return list1;
   }
      @RequestMapping({"aa"})
   @ResponseBody
   public List aa() { List list = repService.chaUser();
        User u1 = null;
        List list3 = new ArrayList();
        Set set = new HashSet();
        for (Object object:list) {
          u1 = (User)object;
          set.add(u1.getUser_id());
     }
        Iterator it = set.iterator();
        Object map = new HashMap();
        while (it.hasNext()) {
          ((Map)map).put("user_id", it.next());
          list3.add(repService.cha((Map)map));
     }
        return list3; } 
   @RequestMapping({"update"})
   @ResponseBody
   public void update(User user, String per_ids, String per_hids) {
        Map map = new HashMap();
        map.put("user_id", user.getUser_id());
        repService.deletePer_id(map);
        if ((per_ids != "") && (per_ids != null) && (per_hids != "") && (per_hids != null)) {
          Set set = new LinkedHashSet();
 
          String[] split = per_ids.split(",");
          for (int i = 0; i < split.length; i++) {
            set.add(split[i]);
       }
          Set set1 = new LinkedHashSet();
          String[] split2 = per_hids.split(",");
          for (int j = 0; j < split2.length; j++) {
            set1.add(split2[j]);
       }
          Iterator it = set.iterator();
       
          while(it.hasNext())
            
       {
        	  
        	  map.put("per_id", it.next());
            Iterator it1 = set1.iterator();
            while(it1.hasNext()){
            	
            	map.put("per_hid", it1.next());
            	
            	repService.insertUser_Per(map);
            }
       }
 
     }
        else if ((per_ids != "") && (per_ids != null)) {
          String[] split = per_ids.split(",");
          for (int i = 0; i < split.length; i++) {
            map.put("per_id", split[i]);
            repService.insertUser_Per1(map);
       }
     } else if((per_hids != "") && (per_hids != null)){
          String[] split2 = per_hids.split(",");
          for (int j = 0; j < split2.length; j++) {
            map.put("per_hid", split2[j]);
            repService.insertUser_Per2(map);
       }
     }
   }
 
      @RequestMapping({"delete"})
   @ResponseBody
   public void delete(User user) { repService.delete(user.getUser_id());
        repService.deleteUser(user.getUser_id());
   }
 
   @RequestMapping({"outExcel"})
   public void outExcel(HttpServletResponse response)
   {
        HSSFWorkbook wb = new HSSFWorkbook();
 
        HSSFSheet sheet = wb.createSheet("出货 订单表一");
 
        HSSFRow row = sheet.createRow(0);
 
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment((short)2);
 
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("订单号");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        cell.setCellValue("淘宝订单号");
        cell.setCellStyle(style);
        cell = row.createCell((short)2);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell((short)3);
        cell.setCellValue("入库批次");
        cell.setCellStyle(style);
        cell = row.createCell((short)4);
        cell.setCellValue("品名");
        cell.setCellStyle(style);
        cell = row.createCell((short)5);
        cell.setCellValue("发货数");
        cell.setCellStyle(style);
        cell = row.createCell((short)6);
        cell.setCellValue("库位");
        cell.setCellStyle(style);
        cell = row.createCell((short)7);
        cell.setCellValue("渠道");
        cell.setCellStyle(style);
        cell = row.createCell((short)8);
        cell.setCellValue("运输");
        cell.setCellStyle(style);
        cell = row.createCell((short)9);
        cell.setCellValue("城市");
        cell.setCellStyle(style);
        cell = row.createCell((short)10);
        cell.setCellValue("库管");
        cell.setCellStyle(style);
        cell = row.createCell((short)11);
        cell.setCellValue("运单号");
        cell.setCellStyle(style);
 
        List list = repService.queryall();
 
        for (int i = 0; i < list.size(); i++)
     {
          row = sheet.createRow(i + 1);
          chuOrder co = (chuOrder)list.get(i);
 
          row.createCell((short)0).setCellValue(co.getOrder_num());
          row.createCell((short)1).setCellValue(co.getAddress_notes());
          row.createCell((short)2).setCellValue(co.getClient_name());
          row.createCell((short)3).setCellValue(co.getRep_enters());
          row.createCell((short)4).setCellValue(co.getBar_message());
          row.createCell((short)5).setCellValue(co.getOut_num());
          row.createCell((short)6).setCellValue(co.getShelf_type());
          row.createCell((short)7).setCellValue(co.getChan_name());
          row.createCell((short)8).setCellValue(co.getTran_name());
          row.createCell((short)9).setCellValue(co.getCity_name());
          row.createCell((short)10).setCellValue(co.getUser_name());
          row.createCell((short)11).setCellValue(co.getYundan());
     }
 
     try
     {
          String filename = "出货订单.xls";
          response.setContentType("application/vnd.ms-excel");
          response.setCharacterEncoding("utf-8");
          response.setHeader("Content-disposition", "attachment; filename=" + new String(filename.getBytes("gbk"), "iso-8859-1"));
 
          BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
          wb.write(fout);
          fout.close();
     }
     catch (Exception e)
     {
          e.printStackTrace();
     }
   }
 
   @RequestMapping({"outExcel1"})
   public void outExcel1(HttpServletResponse response)
   {
        HSSFWorkbook wb = new HSSFWorkbook();
 
        HSSFSheet sheet = wb.createSheet("盘点表一");
 
        HSSFRow row = sheet.createRow(0);
 
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment((short)2);
 
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("日期");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        cell.setCellValue("库位");
        cell.setCellStyle(style);
        cell = row.createCell((short)2);
        cell.setCellValue("入库批次");
        cell.setCellStyle(style);
        cell = row.createCell((short)3);
        cell.setCellValue("产品信息");
        cell.setCellStyle(style);
        cell = row.createCell((short)4);
        cell.setCellValue("结存");
        cell.setCellStyle(style);
        cell = row.createCell((short)5);
        cell.setCellValue("盘点数");
        cell.setCellStyle(style);
        cell = row.createCell((short)6);
        cell.setCellValue("盘点人");
        cell.setCellStyle(style);
        cell = row.createCell((short)7);
        cell.setCellValue("备注");
        cell.setCellStyle(style);
 
        List list = repService.queryPan();
 
        for (int i = 0; i < list.size(); i++)
     {
          row = sheet.createRow(i + 1);
          Pandian co = (Pandian)list.get(i);
 
          row.createCell((short)0).setCellValue(co.getP_date());
          row.createCell((short)1).setCellValue(co.getShelf_type());
          row.createCell((short)2).setCellValue(co.getRep_enter());
          row.createCell((short)3).setCellValue(co.getBar_message());
          row.createCell((short)4).setCellValue(co.getRep_end());
          row.createCell((short)5).setCellValue(co.getNumber_num());
          row.createCell((short)6).setCellValue(co.getUser_name());
          row.createCell((short)7).setCellValue(co.getBz_name());
     }
 
     try
     {
          String filename = "盘点.xls";
          response.setContentType("application/vnd.ms-excel");
          response.setCharacterEncoding("utf-8");
          response.setHeader("Content-disposition", "attachment; filename=" + new String(filename.getBytes("gbk"), "iso-8859-1"));
 
          BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
          wb.write(fout);
          fout.close();
     }
     catch (Exception e)
     {
          e.printStackTrace();
     }
   }
 
   @RequestMapping({"outExcel2"})
   public void outExcel2(HttpServletResponse response)
   {
        HSSFWorkbook wb = new HSSFWorkbook();
 
        HSSFSheet sheet = wb.createSheet("单证表一");
 
        HSSFRow row = sheet.createRow(0);
 
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment((short)2);
        sheet.setDefaultColumnWidth(50);
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("日期");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        cell.setCellValue("标题");
        cell.setCellStyle(style);
        cell = row.createCell((short)2);
        cell.setCellValue("内容描述");
        cell.setCellStyle(style);
        cell = row.createCell((short)3);
        cell.setCellValue("库管");
        cell.setCellStyle(style);
        cell = row.createCell((short)4);
        cell.setCellValue("照片");
        cell.setCellStyle(style);
 
        List list = repService.queryDan();
 
        for (int i = 0; i < list.size(); i++)
     {
          row = sheet.createRow(i + 1);
          row.setHeight((short)2000);
          Danzheng co = (Danzheng)list.get(i);
 
          row.createCell((short)0).setCellValue(co.getUploadDate());
          row.createCell((short)1).setCellValue(co.getTitle());
          row.createCell((short)2).setCellValue(co.getArea());
          row.createCell((short)3).setCellValue(co.getUser_name());
          String aa = co.getUploadPath();
          String b = aa.substring(27);
          String c = "/home/ftpuser1/www/images";
          String cc = c + b;
          FileOutputStream fileOut = null;
          BufferedImage bufferImg = null;
          ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
       try {
            bufferImg = ImageIO.read(new File(cc));
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
 
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
 
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 40, 15, (short)4, 1 + i, (short)5, 2 + i);
 
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), 5));
       }
       catch (IOException e) {
            e.printStackTrace();
       }
     }
 
     try
     {
          String filename = "单证.xls";
          response.setContentType("application/vnd.ms-excel");
          response.setCharacterEncoding("utf-8");
          response.setHeader("Content-disposition", "attachment; filename=" + new String(filename.getBytes("gbk"), "iso-8859-1"));
 
          BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
          wb.write(fout);
          fout.close();
     }
     catch (Exception e)
     {
          e.printStackTrace();
     }
   }
 
   @RequestMapping({"outExcel3"})
   public void outExcel3(HttpServletResponse response)
   {
        HSSFWorkbook wb = new HSSFWorkbook();
 
        HSSFSheet sheet = wb.createSheet("退货表一");
 
        HSSFRow row = sheet.createRow(0);
 
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment((short)2);
        sheet.setDefaultColumnWidth(50);
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("日期");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        cell.setCellValue("快递名称");
        cell.setCellStyle(style);
        cell = row.createCell((short)2);
        cell.setCellValue("运单号");
        cell.setCellStyle(style);
        cell = row.createCell((short)3);
        cell.setCellValue("产品");
        cell.setCellStyle(style);
        cell = row.createCell((short)4);
        cell.setCellValue("数量");
        cell.setCellStyle(style);
        cell = row.createCell((short)5);
        cell.setCellValue("库管");
        cell.setCellStyle(style);
        cell = row.createCell((short)6);
        cell.setCellValue("照片");
        cell.setCellStyle(style);
 
        List list = repService.queryTui();
 
        for (int i = 0; i < list.size(); i++)
     {
          row = sheet.createRow(i + 1);
          row.setHeight((short)2000);
          Tuihuo co = (Tuihuo)list.get(i);
 
         row.createCell((short)0).setCellValue(co.getUploadDate1());
         row.createCell((short)1).setCellValue(co.getKuaidi());
         row.createCell((short)2).setCellValue(co.getYundan());
         row.createCell((short)3).setCellValue(co.getChanpin());
         row.createCell((short)4).setCellValue(co.getNum());
         row.createCell((short)5).setCellValue(co.getUser_name());
         String aa = co.getUploadPath1();
         String b = aa.substring(27);
         String c = "/home/ftpuser1/www/images";
         String cc = c + b;
         FileOutputStream fileOut = null;
         BufferedImage bufferImg = null;
         ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
       try {
           bufferImg = ImageIO.read(new File(cc));
           ImageIO.write(bufferImg, "jpg", byteArrayOut);
 
           HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
 
           HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 40, 15, (short)6, 1 + i, (short)7, 2 + i);
 
           patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), 5));
       }
       catch (IOException e) {
           e.printStackTrace();
       }
     }
 
     try
     {
         String filename = "退货.xls";
         response.setContentType("application/vnd.ms-excel");
         response.setCharacterEncoding("utf-8");
         response.setHeader("Content-disposition", "attachment; filename=" + new String(filename.getBytes("gbk"), "iso-8859-1"));
 
         BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
         wb.write(fout);
         fout.close();
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
   }
 
   @RequestMapping({"outExcel4"})
   public void outExcel4(HttpServletResponse response)
   {
       HSSFWorkbook wb = new HSSFWorkbook();
 
       HSSFSheet sheet = wb.createSheet("货存表一");
 
       HSSFRow row = sheet.createRow(0);
 
       HSSFCellStyle style = wb.createCellStyle();
       style.setAlignment((short)2);
 
       HSSFCell cell = row.createCell((short)0);
       cell.setCellValue("入库批次");
       cell.setCellStyle(style);
       cell = row.createCell((short)1);
       cell.setCellValue("产品信息");
       cell.setCellStyle(style);
       cell = row.createCell((short)2);
       cell.setCellValue("初存");
       cell.setCellStyle(style);
       cell = row.createCell((short)3);
       cell.setCellValue("结存");
       cell.setCellStyle(style);
       cell = row.createCell((short)4);
       cell.setCellValue("库位");
       cell.setCellStyle(style);
       cell = row.createCell((short)5);
       cell.setCellValue("收货人");
       cell.setCellStyle(style);
 
       List list = repService.queryal4();
 
       for (int i = 0; i < list.size(); i++)
     {
         row = sheet.createRow(i + 1);
         Huocun co = (Huocun)list.get(i);
 
         row.createCell((short)0).setCellValue(co.getRep_enter());
         row.createCell((short)1).setCellValue(co.getBar_message());
         row.createCell((short)2).setCellValue(co.getNum());
         row.createCell((short)3).setCellValue(co.getRep_end());
         row.createCell((short)4).setCellValue(co.getShelf_type());
         row.createCell((short)5).setCellValue(co.getUser_name());
     }
 
     try
     {
         String filename = "货存.xls";
         response.setContentType("application/vnd.ms-excel");
         response.setCharacterEncoding("utf-8");
         response.setHeader("Content-disposition", "attachment; filename=" + new String(filename.getBytes("gbk"), "iso-8859-1"));
 
         BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
         wb.write(fout);
         fout.close();
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
   }
 
   @RequestMapping({"delectUpload"})
   @ResponseBody
   public void delectUpload(int upload_id)
   {
       repService.delectUpload(upload_id);
       List list = repService.selectUpload_path(upload_id);
       for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
         Upload u = (Upload)object;
         repService.deletePath(u.getPath_id());
     }
       repService.deleteUpload_path(upload_id);
   }
   @RequestMapping({"delectUpload1"})
   @ResponseBody
   public void delectUpload1(int upload1_id) {
       repService.delectUpload1(upload1_id);
       List list = repService.selectUpload1_path1(upload1_id);
       for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
         Upload1 u = (Upload1)object;
         repService.deletePath1(u.getPath1_id());
     }
       repService.deleteUpload1_path1(upload1_id);
   }
   
   @RequestMapping("kq")
   @ResponseBody
   public void kq(){
	   List list=repService.selectUid();
	   int uid=1;
	   Map map=new HashMap();
	   map.put("uid", uid);
	   for (Object object : list) {
		User u=(User) object;
		map.put("user_id", u.getUser_id());
		repService.updateUid(map);
	}
   }
 }

