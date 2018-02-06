 package com.jiumenfang.user.service;
 
 import com.jiumenfang.user.bean.Address;
 import com.jiumenfang.user.bean.City;
 import com.jiumenfang.user.bean.Client;
 import com.jiumenfang.user.bean.Danzheng;
 import com.jiumenfang.user.bean.Huocun;
 import com.jiumenfang.user.bean.Orders;
 import com.jiumenfang.user.bean.Pandian;
 import com.jiumenfang.user.bean.Repertory;
 import com.jiumenfang.user.bean.Tuihuo;
 import com.jiumenfang.user.bean.User;
 import com.jiumenfang.user.bean.chuOrder;
 import com.jiumenfang.user.dao.RepDao;
 import java.util.List;
 import java.util.Map;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 
 @Service
 public class RepServiceimpl
   implements RepService
 {
 
   @Autowired
   private RepDao dao;
 
   public List stock(Map map)
   {
        return dao.stock(map);
   }
 
   public List chan()
   {
        return dao.chan();
   }
 
   public List tran()
   {
        return dao.tran();
   }
 
   public List city()
   {
        return dao.city();
   }
 
   public Repertory r(String rep_id)
   {
        return dao.r(rep_id);
   }
 
   public void insertAddress(Map map)
   {
        dao.insertAddress(map);
   }
 
   public Address selectAddress(Map map)
   {
        return dao.selectAddress(map);
   }
 
   public Client selectClient(Map map)
   {
        return dao.selectClient(map);
   }
 
   public void insertClient(Map map)
   {
        dao.insertClient(map);
   }
 
   public void insertOrders(Map map)
   {
        dao.insertOrders(map);
   }
 
   public List selectOrders(String order_num)
   {
        return dao.selectOrders(order_num);
   }
 
   public List mon(String rep_id1)
   {
       List list = dao.selectReps(rep_id1);
       return list;
   }
 
   public Repertory selectRep(Map map)
   {
       return dao.selectRep(map);
   }
 
   public void insertReps(Map map)
   {
       dao.insertReps(map);
   }
 
   public void insertOut(Map map)
   {
       dao.insertOut(map);
   }
 
   public List selectOut1(Map map)
   {
       return dao.selectOut1(map);
   }
 
   public void updateRepsOut_id(Map map)
   {
       dao.updateRepsOut_id(map);
   }
 
   public List selectOuts(String time1)
   {
       return dao.selectOuts(time1);
   }
 
   public void updateReps(Map map)
   {
       dao.updateReps(map);
   }
 
   public void updateOrder(Map map)
   {
       dao.updateOrder(map);
   }
 
   public Orders selectOrder_id(Map map)
   {
       return dao.selectOrder_id(map);
   }
 
   public void updateRepsOrders_id(Map map)
   {
       dao.updateRepsOrders_id(map);
   }
 
   public void updateAddressId(Map map)
   {
       dao.updateAddressId(map);
   }
 
   public void updateClientId(Map map)
   {
       dao.updateClientId(map);
   }
 
   public void insertChan_rep(Map map)
   {
       dao.insertChan_rep(map);
   }
 
   public void insertTran_rep(Map map)
   {
       dao.insertTran_rep(map);
   }
 
   public void insertCity_name(Map map)
   {
       dao.insertCity_name(map);
   }
 
   public City selectCity_id(Map map)
   {
       return dao.selectCity_id(map);
   }
 
   public void insertOrder_rep(Map map)
   {
       dao.insertOrder_rep(map);
   }
 
   public void updateOutsOrdersId(Map map)
   {
       dao.updateOutsOrdersId(map);
   }
 
   public void insertOrders_out(Map map)
   {
       dao.insertOrders_out(map);
   }
 
   public void insertReps_out(Map map)
   {
       dao.insertReps_out(map);
   }
 
   public void updateRepsChan_id(Map map)
   {
       dao.updateRepsChan_id(map);
   }
 
   public List selectOrdersId(Map map)
   {
       return dao.selectOrdersId(map);
   }
 
   public List selectReps_id(Map map)
   {
       return dao.selectReps_id(map);
   }
 
   public void insertRepsOrder(Map map)
   {
       dao.insertRepsOrder(map);
   }
 
   public List chu(Map map)
   {
       return dao.chu(map);
   }
 
   public List pan(Map map)
   {
       return dao.pan(map);
   }
 
   public List selectPermission()
   {
       return dao.selectPermission();
   }
 
   public List selectPerh()
   {
       return dao.selectPerh();
   }
 
   public void insertUser(Map map)
   {
       dao.insertUser(map);
   }
 
   public User selectUserId(Map map)
   {
       return dao.selectUserId(map);
   }
 
   public User selectUser(Map map) {
       return dao.selectUser(map);
   }
 
   public void insertUser_Per(Map map)
   {
       dao.insertUser_Per(map);
   }
 
   public User test(String user_name)
   {
       return dao.test(user_name);
   }
 
   public void updateOrdersRepsId(Map map)
   {
       dao.updateOrdersRepsId(map);
   }
 
   public List selectOutsId(Map map)
   {
       return dao.selectOutsId(map);
   }
 
   public List zs(int rep_id)
   {
       return dao.zs(rep_id);
   }
 
   public List chaUser()
   {
       return dao.chaUser();
   }
 
   public List chaDan(Map map)
   {
       return dao.chaDan(map);
   }
 
   public List chaTui(Map map) {
       return dao.chaTui(map);
   }
 
   public List cha(Map map)
   {
       return dao.cha(map);
   }
 
   public List cha1(int user_id)
   {
       return dao.cha1(user_id);
   }
 
   public void deletePer_id(Map map)
   {
       dao.deletePer_id(map);
   }
 
   public void insertUser_per(Map map)
   {
       dao.insertUser_per(map);
   }
 
   public void delete(int user_id)
   {
       dao.delete(user_id);
   }
 
   public void deleteUser(int user_id)
   {
       dao.deleteUser(user_id);
   }
 
   public List<chuOrder> queryall()
   {
       return dao.queryall();
   }
 
   public List<Pandian> queryPan()
   {
       return dao.queryPan();
   }
 
   public List<Danzheng> queryDan()
   {
       return dao.queryDan();
   }
 
   public List<Tuihuo> queryTui()
   {
       return dao.queryTui();
   }
 
   public List login(User user)
   {
       return dao.login(user);
   }
 
   public void insertUser_Per1(Map map)
   {
       dao.insertUser_Per1(map);
   }
 
   public void insertUser_Per2(Map map)
   {
       dao.insertUser_Per2(map);
   }
 
   public List selectPath(int upload_id)
   {
       return dao.selectPath(upload_id);
   }
 
   public List chaUpload()
   {
       return dao.chaUpload();
   }
 
   public List chaUpload1() {
       return dao.chaUpload1();
   }
 
   public List selectPath1(int upload1_id)
   {
       return dao.selectPath1(upload1_id);
   }
 
   public List selectEndNum(int rep_id)
   {
       return dao.selectEndNum(rep_id);
   }
 
   public int findCount()
   {
       return dao.findCount();
   }
 
   public int findCount1(Map map)
   {
       return dao.findCount1(map);
   }
 
   public int findCount2()
   {
       return dao.findCount2();
   }
 
   public int findCount3()
   {
       return dao.findCount3();
   }
 
   public int findCount4()
   {
       return dao.findCount4();
   }
 
   public List<Huocun> queryal4()
   {
       return dao.queryal4();
   }
 
   public void delectUpload(int upload_id)
   {
       dao.delectUpload(upload_id);
   }
 
   public void deleteUpload_path(int upload_id)
   {
       dao.deleteUpload_path(upload_id);
   }
 
   public void deletePath(int path_id)
   {
       dao.deletePath(path_id);
   }
 
   public void delectUpload1(int upload1_id)
   {
       dao.delectUpload1(upload1_id);
   }
 
   public void deleteUpload1_path1(int upload1_id)
   {
       dao.deleteUpload1_path1(upload1_id);
   }
 
   public void deletePath1(int upload1_id)
   {
       dao.deletePath1(upload1_id);
   }
 
   public List selectUpload_path(int upload_id)
   {
       return dao.selectUpload_path(upload_id);
   }
 
   public List selectUpload1_path1(int upload1_id)
   {
       return dao.selectUpload1_path1(upload1_id);
   }

@Override
public List chu1(Map map) {
	return dao.chu1(map);
}

@Override
public List selectOutNum(Map map) {
	return dao.selectOutNum(map);
}

@Override
public void updateRep_end(Map map) {
	dao.updateRep_end(map);
	
}

@Override
public List selectRepEnd(Map map) {
	return dao.selectRepEnd(map);
}

@Override
public void insertEndNum(Map map) {
	dao.insertEndNum(map);
	
}

@Override
public List selectUid() {
	return dao.selectUid();
}

@Override
public void updateUid(Map map) {
	dao.updateUid(map);
	
}
 }

