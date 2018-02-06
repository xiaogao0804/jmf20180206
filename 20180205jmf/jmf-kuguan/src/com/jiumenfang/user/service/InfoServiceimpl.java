 package com.jiumenfang.user.service;
 
 import com.jiumenfang.user.bean.Barcode;
 import com.jiumenfang.user.bean.Orders;
 import com.jiumenfang.user.bean.Outs;
 import com.jiumenfang.user.bean.Pa;
 import com.jiumenfang.user.bean.Repertory;
 import com.jiumenfang.user.bean.Reps;
 import com.jiumenfang.user.bean.Shelf;
 import com.jiumenfang.user.bean.Upload;
 import com.jiumenfang.user.bean.Upload1;
 import com.jiumenfang.user.bean.User;
 import com.jiumenfang.user.dao.InfoDao;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.List;
 import java.util.Map;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 
 @Service
 public class InfoServiceimpl
   implements InfoService
 {
 
   @Autowired
   private InfoDao dao;
 
   public List inter()
   {
        return dao.inter();
   }
 
   public List bar()
   {
        return dao.bar();
   }
 
   public void rep(Repertory rep)
   {
        String str = rep.getRep_enter();
        String[] split = str.split(",");
 
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        String[] split2 = time.split("-");
 
        rep.setRep_enter(split[0].concat(split[1]).concat(split2[0]).concat(split2[1]).concat(split2[2]));
        dao.rep(rep);
   }
 
   public Barcode selectBar(String bar_num)
   {
        return dao.selectBar(bar_num);
   }
 
   public List odd()
   {
        List list = dao.odd();
        return list;
   }
 
   public Outs selectOutNum(Map map)
   {
        return dao.selectOutNum(map);
   }
 
   public List selectOrdersNum(Map map)
   {
        return dao.selectOrdersNum(map);
   }
 
   public Reps stockupInfo(Map map)
   {
        return dao.stockupInfo(map);
   }
 
   public List shelf()
   {
        return dao.shelf();
   }
 
   public List selectOrders_outs(int out_id)
   {
        return dao.selectOrders_outs(out_id);
   }
 
   public List selectRo(Map map)
   {
       return dao.selectRo(map);
   }
 
   public Reps selectOutSum(Map map)
   {
       return dao.selectOutSum(map);
   }
 
   public List selectTran()
   {
       return dao.selectTran();
   }
 
   public void updateOrdersStatusId(Map map)
   {
       dao.updateOrdersStatusId(map);
   }
 
   public List selectUser()
   {
       return dao.selectUser();
   }
 
   public void insertUserId(Map map)
   {
       dao.insertUserId(map);
   }
 
   public Orders selectStatus(int status_id)
   {
       return dao.selectStatus(status_id);
   }
 
   public List selectRepsOut(Map map)
   {
       return dao.selectRepsOut(map);
   }
 
   public List stockupInfo1(Map map)
   {
       return dao.stockupInfo1(map);
   }
 
   public List selectOutSum1(Map map)
   {
       return dao.selectOutSum1(map);
   }
 
   public List num(Map map)
   {
       return dao.num(map);
   }
 
   public void updateRepNum(Map map)
   {
       dao.updateRepNum(map);
   }
 
   public List productInfo(Map map)
   {
       return dao.productInfo(map);
   }
 
   public Shelf selectShelf(int shelf_id)
   {
       return dao.selectShelf(shelf_id);
   }
 
   public void insertBz(Map map)
   {
       dao.insertBz(map);
   }
 
   public Pa selectBzId(Map map)
   {
       return dao.selectBzId(map);
   }
 
   public void insertNumber(Map map)
   {
       dao.insertNumber(map);
   }
 
   public List selectNumber(Map map)
   {
       return dao.selectNumber(map);
   }
 
   public void insertPa(Map map)
   {
       dao.insertPa(map);
   }
 
   public List selectRep(Map map)
   {
       return dao.selectRep(map);
   }
 
   public Reps selectReps_order(int reps_id)
   {
       return dao.selectReps_order(reps_id);
   }
 
   public User selectUserName(int user_id)
   {
       return dao.selectUserName(user_id);
   }
 
   public Reps selectOrdersUser(int user_id)
   {
       return dao.selectOrdersUser(user_id);
   }
 
   public void updateRepsUserId(Map map)
   {
       dao.updateRepsUserId(map);
   }
 
   public Orders selectOrders(Map map)
   {
       return dao.selectOrders(map);
   }
 
   public List selectOrdersUser1(Map map)
   {
       return dao.selectOrdersUser1(map);
   }
 
   public List selectOrder()
   {
       return dao.selectOrder();
   }
 
   public Repertory selectOutSum2(Map map)
   {
       return dao.selectOutSum2(map);
   }
 
   public void insertUpload(Map map)
   {
       dao.insertUpload(map);
   }
 
   public void insertUpload1(Map map)
   {
       dao.insertUpload1(map);
   }
 
   public List selectReps_id(Map map)
   {
       return dao.selectReps_id(map);
   }
 
   public void updateShelf(Map map)
   {
       dao.updateShelf(map);
   }
 
   public List selectOrder_user()
   {
       return dao.selectOrder_user();
   }
 
   public void updateOrdersUserId(Map map)
   {
       dao.updateOrdersUserId(map);
   }
 
   public List login(User user)
   {
       return dao.login(user);
   }
 
   public List cha(int user_id)
   {
       return dao.cha(user_id);
   }
 
   public Repertory selectRepertory(Map map)
   {
       return dao.selectRepertory(map);
   }
 
   public void insertEnds(Map map)
   {
       dao.insertEnds(map);
   }
 
   public void insertPath(Map map)
   {
       dao.insertPath(map);
   }
 
   public Upload selectUpload(Map map)
   {
       return dao.selectUpload(map);
   }
 
   public List selectPath(Map map)
   {
       return dao.selectPath(map);
   }
 
   public void insertUpload_path(Map map)
   {
       dao.insertUpload_path(map);
   }
 
   public Upload1 selectUpload1(Map map)
   {
       return dao.selectUpload1(map);
   }
 
   public List selectPath1(Map map)
   {
       return dao.selectPath1(map);
   }
 
   public void insertUpload1_path1(Map map)
   {
       dao.insertUpload1_path1(map);
   }
 
   public void insertPath1(Map map)
   {
       dao.insertPath1(map);
   }
 
   public int findCount(Map map)
   {
       return dao.findCount(map);
   }
 
   public int findCount1() {
       return dao.findCount1();
   }
 }

