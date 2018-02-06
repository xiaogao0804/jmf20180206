package com.jiumenfang.user.dao;

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
import java.util.List;
import java.util.Map;

public  interface RepDao
{
  public  List stock(Map paramMap);

  public  List chan();

  public  List tran();

  public  List city();

  public  Repertory r(String paramString);

  public  void insertAddress(Map paramMap);

  public  Address selectAddress(Map paramMap);

  public  void updateRep(Map paramMap);

  public  Client selectClient(Map paramMap);

  public  void insertClient(Map paramMap);

  public  void insertOrders(Map paramMap);

  public  Repertory selectRep(Map map);

  public  void insertReps(Map paramMap);

  public  List selectReps(String paramString);

  public  void insertOut(Map paramMap);

  public  List selectOut1(Map paramMap);

  public  void updateRepsOut_id(Map paramMap);

  public  List selectOuts(String paramString);

  public  void updateReps(Map paramMap);

  public  void updateOrder(Map paramMap);

  public  List selectOrders(String paramString);

  public  Orders selectOrder_id(Map paramMap);

  public  void updateRepsOrders_id(Map paramMap);

  public  void updateAddressId(Map paramMap);

  public  void updateClientId(Map paramMap);

  public  void insertChan_rep(Map paramMap);

  public  void insertTran_rep(Map paramMap);

  public  void insertCity_name(Map paramMap);

  public  City selectCity_id(Object paramObject);

  public  void insertOrder_rep(Map paramMap);

  public  void updateOutsOrdersId(Map paramMap);

  public  void insertOrders_out(Map paramMap);

  public  void insertReps_out(Map paramMap);

  public  void updateRepsChan_id(Map paramMap);

  public  List selectOrdersId(Map paramMap);

  public  List selectReps_id(Map paramMap);

  public  void insertRepsOrder(Map paramMap);

  public  List chu(Map paramMap);

  public  List pan(Map paramMap);

  public  List selectPermission();

  public  List selectPerh();

  public  void insertUser(Map paramMap);

  public  User selectUserId(Map paramMap);

  public  User selectUser(Map paramMap);

  public  void insertUser_Per(Map paramMap);

  public  User test(String paramString);

  public  void insertUser_PerHt(Map paramMap);

  public  List selectUser_per();

  public  void updateOrdersRepsId(Map paramMap);

  public  List selectOutsId(Map paramMap);

  public  List zs(int paramInt);

  public  List chaUser();

  public  List chaDan(Map paramMap);

  public  List chaTui(Map paramMap);

  public  List cha(Map paramMap);

  public  List cha1(int paramInt);

  public  void updateUser_per(Map paramMap);

  public  void updateUser_perid(Map paramMap);

  public  void updateUser_perhid(Map paramMap);

  public  void deletePer_id(Map paramMap);

  public  void insertUser_per(Map paramMap);

  public  void delete(int paramInt);

  public  void deleteUser(int paramInt);

  public  List<chuOrder> queryall();

  public  List<Pandian> queryPan();

  public  List<Danzheng> queryDan();

  public  List<Tuihuo> queryTui();

  public  List login(User paramUser);

  public  void insertUser_Per1(Map paramMap);

  public  void insertUser_Per2(Map paramMap);

  public  List selectPath();

  public  List selectPath(int paramInt);

  public  List chaUpload();

  public  List chaUpload1();

  public  List selectPath1(int paramInt);

  public  List selectEndNum(int paramInt);

  public  int findCount();

  public  int findCount1(Map paramMap);

  public  int findCount2();

  public  int findCount3();

  public  int findCount4();

  public  List<Huocun> queryal4();

  public  void delectUpload(int paramInt);

  public  void deleteUpload_path(int paramInt);

  public  void deletePath(int paramInt);

  public  void delectUpload1(int paramInt);

  public  void deleteUpload1_path1(int paramInt);

  public  void deletePath1(int paramInt);

  public  List selectUpload_path(int paramInt);

  public  List selectUpload1_path1(int paramInt);

public List chu1(Map map);

public List selectOutNum(Map map);

public void updateRep_end(Map map);

public List selectRepEnd(Map map);

public void insertEndNum(Map map);

public List selectUid();

public void updateUid(Map map);
}

