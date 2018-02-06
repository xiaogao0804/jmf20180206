package com.jiumenfang.user.dao;

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
import java.util.List;
import java.util.Map;

public  interface InfoDao
{
  public  List inter();

  public  List bar();

  public  void rep(Repertory paramRepertory);

  public  void insertEnter(String paramString);

  public  Barcode selectBar(String paramString);

  public  List odd();

  public  Outs selectOutNum(Map map);

  public  List selectOrdersNum(Map map);

  public  Reps stockupInfo(Map map);

  public  List shelf();

  public  List selectOrders_outs(int paramInt);

  public  List selectRo(Map map);

  public  Reps selectOutSum(Map map);

  public  List selectTran();

  public  void updateOrdersStatusId(Map map);

  public  List selectUser();

  public  void insertUserId(Map map);

  public  Orders selectStatus(int paramInt);

  public  List selectRepsOut(Map map);

  public  List stockupInfo1(Map map);

  public  List selectOutSum1(Map map);

  public  List num(Map map);

  public  void updateRepNum(Map map);

  public  List productInfo(Map map);

  public  Shelf selectShelf(int paramInt);

  public  void insertBz(Map map);

  public  Pa selectBzId(Map map);

  public  void insertNumber(Map map);

  public  List selectNumber(Map map);

  public  void insertPa(Map map);

  public  List selectRep(Map map);

  public  Reps selectReps_order(int paramInt);

  public  User selectUserName(int paramInt);

  public  Reps selectOrdersUser(int paramInt);

  public  void updateRepsUserId(Map map);

  public  Orders selectOrders(Map map);

  public  List selectOrdersUser1(Map map);

  public  List selectOrder();

  public  Repertory selectOutSum2(Map map);

  public  void insertUpload(Map map);

  public  List selectReps_id(Map map);

  public  void updateShelf(Map map);

  public  List selectOrder_user();

  public  void updateOrdersUserId(Map map);

  public  List login(User user);

  public  List cha(int user_id);

  public  Repertory selectRepertory(Map map);

  public  void insertEnds(Map map);

  public  void insertPath(Map map);

  public  Upload selectUpload(Map map);

  public  List selectPath(Map map);

  public  void insertUpload_path(Map map);

  public  Upload1 selectUpload1(Map map);

  public  List selectPath1(Map map);

  public  void insertUpload1_path1(Map map);

  public  void insertUpload1(Map map);

  public  void insertPath1(Map map);

  public  int findCount(Map map);

  public  int findCount1();
}

