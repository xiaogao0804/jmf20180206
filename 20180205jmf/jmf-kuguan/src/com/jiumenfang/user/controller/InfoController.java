 package com.jiumenfang.user.controller;
 
 import com.jiumenfang.user.bean.Barcode;
 import com.jiumenfang.user.bean.Number;
 import com.jiumenfang.user.bean.Orders;
 import com.jiumenfang.user.bean.Outs;
 import com.jiumenfang.user.bean.Pa;
 import com.jiumenfang.user.bean.Repertory;
 import com.jiumenfang.user.bean.Reps;
 import com.jiumenfang.user.bean.Shelf;
 import com.jiumenfang.user.bean.Upload;
 import com.jiumenfang.user.bean.Upload1;
 import com.jiumenfang.user.bean.User;
 import com.jiumenfang.user.service.InfoService;
 import com.jiumenfang.utils.Page;
 import java.io.File;
 import java.io.IOException;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
 import java.util.LinkedHashSet;
 import java.util.List;
 import java.util.Map;
 import java.util.Map.Entry;
 import java.util.Random;
 import java.util.Set;
 import java.util.TreeSet;
 import javax.servlet.ServletContext;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.util.FileCopyUtils;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.multipart.MultipartFile;
 import org.springframework.web.multipart.MultipartHttpServletRequest;
 
 @Controller
 public class InfoController
 {
 
   @Autowired
   private InfoService infoService;
 
   @RequestMapping({"toLogin"})
   public String toLogin()
   {
        return "login";
   }
 
   @ResponseBody
   @RequestMapping({"login"})
   private int login(User user, HttpServletRequest request)
   {
        List list = infoService.login(user);
        User u = null;
        for (Object object:list ) {
          u = (User)object;
     }
        
        System.out.println("22222222222:"+u);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(0);
 
        if (u != null && u.getPer_id() != 0) {
          request.getSession().setAttribute("user", u);
          return u.getUser_id();
     }
        return 0;
   }
 
   @RequestMapping({"info"})
   public String info(HttpServletRequest request, Model model) {
        User u = (User)request.getSession().getAttribute("user");
        if (u == null) {
          return "redirect:toLogin.do";
     }
        User u1=null;
        List list = infoService.cha(u.getUser_id());
        String per_id = "";
        for (Object object:list ) {
           u1= (User)object;
          per_id = per_id + "," + u1.getPer_id();
     }
        List list1=infoService.selectUser();
        User u2=null;
        for (Object object : list1) {
			u2=(User) object;
		}
        model.addAttribute("uid", u2.getUid());
        per_id = per_id.substring(1);
        model.addAttribute("per_id", per_id);
        model.addAttribute("user_name", u.getUser_name());
        return "info";
   }
 
   @RequestMapping({"receiving"})
   public String receiving(HttpServletRequest request, Model model)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       return "receiving";
   }
 
   @RequestMapping({"stockUp"})
   public String stockUp(Model model, HttpServletRequest request, @RequestParam(defaultValue="") String start, @RequestParam(defaultValue="") String end, @RequestParam(defaultValue="1") String currentPage)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       List list = infoService.odd();
       List list1 = null;
       List list2 = null;
       List s = new ArrayList();
       Reps reps = null;
       Reps q = null;
       Outs outs = null;
       int reps_id = 0;
       int orders_id = 0;
       int out_id = 0;
       String reps_date = "";
 
       Set set = new TreeSet();
       Map map = new HashMap();
       for (Object object:list ) { 
         reps = (Reps)object;
         reps_id = reps.getReps_id();
         set.add(reps_id);
     }
       Iterator it = set.iterator();
       int reps_id1 = 0;
       while (it.hasNext()) {
         reps_id1 = (int) it.next();
         Reps a = infoService.selectReps_order(reps_id1);
         map.put("reps_id",reps_id1);
         map.put("order_id",a.getOrder_id());
         map.put("user_id", user.getUser_id());
         outs = infoService.selectOutNum(map);
         list1 = infoService.selectOrdersNum(map);
         list = infoService.selectRo(map);
     }
       map.put("user_id",user.getUser_id());
       map.put("start", start);
       map.put("end", end);
       String pageSize = "3";
       int count = infoService.findCount(map);
       Page page = new Page(currentPage, count, pageSize);
       int a = Integer.parseInt(currentPage);
       int b = Integer.parseInt(pageSize);
       map.put("index",(a - 1) * b);
       map.put("pagesize",b);
       s = infoService.selectOrdersUser1(map);
       model.addAttribute("list", s);
       model.addAttribute("page", page);
       model.addAttribute("start", start);
       model.addAttribute("end", end);
       return "stockUp";
   }
 
   @RequestMapping({"order"})
   public String order(Model model, HttpServletRequest request, @RequestParam(defaultValue="") String start, @RequestParam(defaultValue="") String end, String user_name, @RequestParam(defaultValue="1") String currentPage)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       List list = infoService.odd();
       List list1 = null;
       List list2 = null;
       List s = new ArrayList();
       Reps reps = null;
       Outs outs = null;
       int reps_id = 0;
       int orders_id = 0;
       int out_id = 0;
       String reps_date = "";
 
       Set set = new TreeSet();
       Map map = new HashMap();
       for (Object object:list ) { 
         reps = (Reps)object;
         reps_id = reps.getReps_id();
         set.add(reps_id);
     }
       Iterator it = set.iterator();
       int reps_id1 = 0;
       while (it.hasNext()) {
         reps_id1 = (int) it.next();
         Reps a = infoService.selectReps_order(reps_id1);
         if (a == null) {
         break;
       }
         map.put("reps_id", reps_id1);
         map.put("order_id", a.getOrder_id());
         map.put("user_id", user.getUser_id());
         outs = infoService.selectOutNum(map);
         list1 = infoService.selectOrdersNum(map);
         list = infoService.selectRo(map);
     }
 
       model.addAttribute("user_name", user_name);
       map.put("start", start);
       map.put("end", end);
       String pageSize = "3";
       int count = infoService.findCount1();
       Page page = new Page(currentPage, count, pageSize);
       int a = Integer.parseInt(currentPage);
       int b = Integer.parseInt(pageSize);
       map.put("index", (a - 1) * b);
       map.put("pagesize", b);
       s = infoService.selectOutSum1(map);
       model.addAttribute("list1", s);
       model.addAttribute("page", page);
       model.addAttribute("start", start);
       model.addAttribute("end", end);
 
       return "order";
   }
 
   @RequestMapping({"inter"})
   @ResponseBody
   public List inter() {
       List list = infoService.inter();
       return list;
   }
   @RequestMapping({"bar"})
   @ResponseBody
   public List bar() {
       List list = infoService.bar();
       return list;
   }
   @ResponseBody
   @RequestMapping({"shelf"})
   public List shelf() {
       List list2 = infoService.shelf();
       return list2;
   }
 
   @RequestMapping({"rep"})
   @ResponseBody
   public void rep(Repertory rep, Barcode bar, HttpServletRequest request) {
       User user = (User)request.getSession().getAttribute("user");
 
       Barcode b = infoService.selectBar(bar.getBar_num());
       rep.setBar_id(b.getBar_id());
       rep.setUser_id(user.getUser_id());
       infoService.rep(rep);
   }
 
   @RequestMapping({"toStockupInfo"})
   public String toStockupInfo(Orders orders, User user, Model model, HttpServletRequest request)
   {
       User user1 = (User)request.getSession().getAttribute("user");
       if (user1 == null) {
         return "redirect:toLogin.do";
     }
 
       Map map = new HashMap();
       map.put("orders_id", orders.getOrder_id());
       User u = infoService.selectUserName(user.getUser_id());
       List list = infoService.selectReps_id(map);
       for (Object object:list) {
         Reps r = (Reps)object;
         map.put("reps_id", r.getReps_id());
     }
       Reps rep = infoService.stockupInfo(map);
       List list1 = infoService.stockupInfo1(map);
       model.addAttribute("user", u);
       model.addAttribute("rep", rep);
       model.addAttribute("list", list1);
       return "stockupInfo";
   }
 
   @RequestMapping({"toOrder"})
   public String toOrder(Orders orders, Model model, HttpServletRequest request)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       Map map = new HashMap();
       map.put("orders_id", orders.getOrder_id());
       List list = infoService.selectReps_id(map);
       for (Object object:list) { 
         Reps r = (Reps)object;
         map.put("reps_id", r.getReps_id());
     }
       Reps rep = infoService.stockupInfo(map);
       List list1 = infoService.stockupInfo1(map);
       model.addAttribute("rep", rep);
       model.addAttribute("list", list1);
       return "task";
   }
 
   @RequestMapping({"toPappers"})
   public String toPappers(HttpServletRequest request)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       return "pappers";
   }
 
   @RequestMapping({"a"})
   public String a(Orders orders, String out_nums, String rep_ids, User user, HttpServletRequest request)
   {
       User user1 = (User)request.getSession().getAttribute("user");
       if (user1 == null) {
         return "redirect:toLogin.do";
     }
       int status_id = orders.getStatus_id();
       status_id = 2;
       Map map = new HashMap();
       map.put("order_id", orders.getOrder_id());
       map.put("status_id", status_id);
       map.put("user_id", user.getUser_id());
 
       infoService.updateRepsUserId(map);
       List list = infoService.num(map);
       String[] split = rep_ids.split(",");
       Set set = new TreeSet();
       Repertory rep = null;
       for (int i = 0; i < split.length; i++) {
         set.add(split[i]);
     }
       Set set1 = new LinkedHashSet();
       for (Object object:list ) { 
 
         rep = (Repertory)object;
         set1.add(rep.getRep_end());
     }
       Iterator it1 = set1.iterator();
			while(it1.hasNext()){
				Iterator it=set.iterator();
				while(it.hasNext()){
					
					String[] split2 = out_nums.split(",");
					for (int i = 0; i < split2.length; i++){
						map.put("rep_id", it.next());
						map.put("rep_end", split2[i]);
						map.put("num", it1.next());
						infoService.updateRepNum(map);
						Repertory r = infoService.selectRepertory(map);
						map.put("end_num", r.getRep_end());
						infoService.insertEnds(map);
					}
				}
			}
 
       infoService.updateOrdersStatusId(map);
       return "redirect:stockUp.do";
   }
 
   @RequestMapping({"selectUser"})
   @ResponseBody
   public List selectUser(Model model, HttpServletRequest request) {
       List list = infoService.selectUser();
       model.addAttribute("list", list);
       return list;
   }
 
   @RequestMapping({"c"})
   public String c(User user, Orders orders, HttpServletRequest request, Model model)
   {
       User user1 = (User)request.getSession().getAttribute("user");
       if (user1 == null) {
         return "redirect:toLogin.do";
     }
 
       Map map = new HashMap();
       map.put("user_id", user.getUser_id());
       map.put("orders_id", orders.getOrder_id());
       infoService.updateOrdersUserId(map);
       infoService.insertUserId(map);
       User u = infoService.selectUserName(user.getUser_id());
       return "redirect:order.do?user_name=" + u.getUser_name();
   }
 
   @RequestMapping({"check.do"})
   public String check(Model model, HttpServletRequest request)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       List list = infoService.shelf();
       model.addAttribute("list", list);
       return "check";
   }
 
   @RequestMapping({"productInfo"})
   public String productInfo(Shelf s, Model model, HttpServletRequest request)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       Map map = new HashMap();
       List list = null;
       map.put("shelf_type", s.getShelf_type());
       list = infoService.productInfo(map);
       for (Object object:list) { 
         Repertory a = (Repertory)object;
         Shelf ss = infoService.selectShelf(a.getShelf_id());
         model.addAttribute("shelf_type", ss.getShelf_type());
         model.addAttribute("shelf_id", a.getShelf_id());
     }
       model.addAttribute("user_id", user.getUser_id());
       model.addAttribute("list", list);
       return "productInfo";
   }
 
   @RequestMapping({"pa"})
   @ResponseBody
   public void pa(User u, Shelf s, String rep_id, String number, String bz, HttpServletRequest request)
   {
       User user = (User)request.getSession().getAttribute("user");
       Map map = new HashMap();
       Date date1 = new Date();
       DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
       String time1 = format1.format(date1);
       map.put("user_id", u.getUser_id());
       map.put("bz_name", bz);
       map.put("bz_date", time1);
       infoService.insertBz(map);
       Pa p = infoService.selectBzId(map);
       Date date = new Date();
       DateFormat format = new SimpleDateFormat("yyyyMMdd");
       String time = format.format(date1);
       map.put("pa_date", time);
       map.put("bz_id", p.getBz_id());
       map.put("shelf_id", s.getShelf_id());
       map.put("s_id", s.getS_id());
       infoService.updateShelf(map);
       String[] split = number.split(",");
       for (int b = 0; b < split.length; b++) {
         map.put("number", split[b]);
         infoService.insertNumber(map);
     }
       List list = infoService.selectNumber(map);
       Number num = null;
       int a = 0;
       Set set1 = new TreeSet();
       String[] split2 = rep_id.split(",");
       for (int i = 0; i < split2.length; i++)
     {
         set1.add(split2[i]);
     }
 
       Date date2 = new Date();
       DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String time2 = format1.format(date1);
       Set set = new LinkedHashSet();
       for (Object object:list ) { 
         num = (Number)object;
         set.add(num.getNumber_id());
     }
 
       Iterator it = set.iterator();
       while (it.hasNext()){
         Iterator it1 = set1.iterator();
         while (it1.hasNext()) {
           map.put("pa_date1", time2);
           map.put("num_id", it.next());
           map.put("rep_id", it1.next());
           infoService.insertPa(map);
       }
     }
   }
 
   @RequestMapping(value={"/fileUpload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
   public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, String title, String area)
     throws IOException
   {
       User user1 = (User)request.getSession().getAttribute("user");
       if (user1 == null) {
         return "redirect:toLogin.do";
     }
       User user = (User)request.getSession().getAttribute("user");
       Date date1 = new Date();
       DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
       String time1 = format1.format(date1);
       Date date2 = new Date();
       DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String time2 = format2.format(date2);
       Map map = new HashMap();
       map.put("title", title);
       map.put("area", area);
 
       map.put("uploadDate", time1);
       map.put("uploadDate1", time2);
       map.put("user_id", user.getUser_id());
       infoService.insertUpload(map);
       Upload u = infoService.selectUpload(map);
       String responseStr = "";
       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
 
       Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
 
       String configPath = request.getSession().getServletContext().getRealPath("/images/");
 
       File file1 = new File(configPath);
       if (!file1.exists()) {
         file1.mkdirs();
     }
       String fileName = null;
       for (Map.Entry<String, MultipartFile> entity: fileMap.entrySet()){
         MultipartFile mf =entity.getValue();
 
         fileName = mf.getOriginalFilename();
 
         String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
 
         SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
         String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
         responseStr = "/home/ftpuser1/www/images/" + newFileName;
         File uploadFile = new File(responseStr);
         String aa = uploadFile.toString();
         String ab = aa.substring(18);
         String m = "http://47.93.202.254";
         String mm = m + ab;
         int a = mm.indexOf(".jpg");
         int b = mm.indexOf(".jpeg");
         int c = mm.indexOf(".gif");
         int d = mm.indexOf(".png");
         if (a > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath", mm);
 
           infoService.insertPath(map);
       }
 
         if (b > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath", mm);
 
           infoService.insertPath(map);
       }
 
        if (c > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath", mm);
 
           infoService.insertPath(map);
       }
 
         if (d > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath", mm);
 
           infoService.insertPath(map);
       }
 
     }
 
       List list1 = infoService.selectPath(map);
       Set set1 = new TreeSet();
       for (Object object : list1) {
         Upload up = (Upload)object;
         set1.add(up.getPath_id());
     }
       Iterator it1 = set1.iterator();
       while (it1.hasNext()) {
         map.put("path_id", it1.next());
         map.put("upload_id", u.getUpload_id());
         infoService.insertUpload_path(map);
     }
       return "pappers";
   }
 
   @RequestMapping(value={"/fileUpload1"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
   public String upload1(MultipartFile file, HttpServletRequest request, HttpServletResponse response, String kuaidi, String yundan, String chanpin, int num)
     throws IOException
   {
       User user1 = (User)request.getSession().getAttribute("user");
       if (user1 == null) {
         return "redirect:toLogin.do";
     }
       User user = (User)request.getSession().getAttribute("user");
       Date date1 = new Date();
       DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
       String time1 = format1.format(date1);
       Date date2 = new Date();
       DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String time2 = format2.format(date2);
       Map map = new HashMap();
       map.put("kuaidi", kuaidi);
       map.put("yundan", yundan);
       map.put("chanpin", chanpin);
       map.put("num", num);
 
       map.put("uploadDate1", time1);
       map.put("uploadDate2", time2);
       map.put("user_id", user.getUser_id());
       infoService.insertUpload1(map);
       Upload1 u = infoService.selectUpload1(map);
       String responseStr = "";
       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
 
       Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
 
       String configPath = request.getSession().getServletContext().getRealPath("/images/");
 
       File file1 = new File(configPath);
       if (!file1.exists()) {
         file1.mkdirs();
     }
       String fileName = null;
       for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
         MultipartFile mf = (MultipartFile)entity.getValue();
         fileName = mf.getOriginalFilename();
 
         String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
         SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
         String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
         responseStr = "/home/ftpuser1/www/images/" + newFileName;
         File uploadFile = new File(responseStr);
         String aa = uploadFile.toString();
         String ab = aa.substring(18);
         String m = "http://47.93.202.254";
         String mm = m + ab;
         int a = mm.indexOf(".jpg");
         int b = mm.indexOf(".jpeg");
         int c = mm.indexOf(".gif");
         int d = mm.indexOf(".png");
         if (a > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath1", mm);
 
           infoService.insertPath1(map);
       }
 
         if (b > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath", mm);
 
           infoService.insertPath1(map);
       }
 
         if (c > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath", mm);
 
           infoService.insertPath1(map);
       }
 
         if (d > 0) {
         try {
             FileCopyUtils.copy(mf.getBytes(), uploadFile);
         } catch (IOException e) {
             responseStr = "上传失败";
             e.printStackTrace();
         }
           map.put("uploadPath", mm);
 
           infoService.insertPath1(map);
       }
 
     }
 
       List list1 = infoService.selectPath1(map);
 
       Set set1 = new TreeSet();
       for (Object object:list1 ) { 
         Upload1 up = (Upload1)object;
         set1.add(up.getPath1_id());
     }
       Iterator it1 = set1.iterator();
      while (it1.hasNext()) {
         map.put("upload1_id", u.getUpload1_id());
         map.put("path1_id", it1.next());
         infoService.insertUpload1_path1(map);
     }
       return "salesReturn";
   }
 
   @RequestMapping({"salesReturn"})
   public String toSalesReturn(HttpServletRequest request)
   {
       User user = (User)request.getSession().getAttribute("user");
       if (user == null) {
         return "redirect:toLogin.do";
     }
 
       return "salesReturn";
   }
 }

