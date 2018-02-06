package com.jiumenfang.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiumenfang.user.bean.Commodity;
import com.jiumenfang.user.dao.JMFDao;
@Service
public class JMFService implements JMFServiceImp {
	@Autowired
	private JMFDao dao;
	@Override
	public List commodityList(String start_id) {
		// TODO Auto-generated method stub
		return dao.commodityList(start_id);
	}
	
	@Override
	public List carouselList() {
		// TODO Auto-generated method stub
		return dao.carouselList();
	}
	
	@Override
	public Commodity comList(Commodity com) {
		// TODO Auto-generated method stub
		return dao.comList(com);
	}

	@Override
	public void addshop(Map map) {
		// TODO Auto-generated method stub
		dao.addshop(map);
	}

	@Override
	public void goingby(Map map) {
		// TODO Auto-generated method stub
		dao.goingby(map);
	}


	@Override
	public void addUser(Map map) {
		// TODO Auto-generated method stub
		dao.addUser(map);
	}

	@Override
	public int findUserId(Map map) {
		// TODO Auto-generated method stub
		return dao.findUserId(map);
	}

	@Override
	public void addUserIdAndShopId(Map map) {
		// TODO Auto-generated method stub
		dao.addUserIdAndShopId(map);
	}

	@Override
	public Commodity openidlength(Map map) {
		// TODO Auto-generated method stub
		return dao.openidlength(map);
	}

	@Override
	public Commodity findshopid(Map map) {
		// TODO Auto-generated method stub
		return dao.findshopid(map);
	}

	@Override
	public void updateShop_Num(Map map) {
		// TODO Auto-generated method stub
		dao.updateShop_Num(map);
	}

	@Override
	public int shopNum(Map map) {
		// TODO Auto-generated method stub
		return dao.shopNum(map);
	}

	@Override
	public List ShopIds(String openid) {
		// TODO Auto-generated method stub
		return dao.ShopIds(openid);
	}

	@Override
	public List findShopIds(int user_id) {
		// TODO Auto-generated method stub
		return dao.findShopIds(user_id);
	}

	@Override
	public Commodity findCom(Map map) {
		// TODO Auto-generated method stub
		return dao.findCom(map);
	}


	@Override
	public int Ids(Map map) {
		// TODO Auto-generated method stub
		return dao.Ids(map);
	}

	@Override
	public void deleteShop(Map map) {
		// TODO Auto-generated method stub
		dao.deleteShop(map);
	}

	@Override
	public void deleteUserShop(Map map) {
		// TODO Auto-generated method stub
		dao.deleteUserShop(map);
	}

	@Override
	public String findShopNum(Map map) {
		// TODO Auto-generated method stub
		return dao.findShopNum(map);
	}

	@Override
	public void addAddress(String openid) {
		// TODO Auto-generated method stub
		dao.addAddress(openid);
	}

	@Override
	public Commodity findAddressId(String openid) {
		// TODO Auto-generated method stub
		return dao.findAddressId(openid);
	}

	@Override
	public void updateAddress(Map map) {
		// TODO Auto-generated method stub
		dao.updateAddress(map);
	}

	@Override
	public int address_id(String openid) {
		// TODO Auto-generated method stub
		return dao.address_id(openid);
	}

	@Override
	public void addOrder(Map map) {
		// TODO Auto-generated method stub
		dao.addOrder(map);
	}

	@Override
	public void updateShopNum(Map map) {
		// TODO Auto-generated method stub
		dao.updateShopNum(map);
	}

	@Override
	public List chaUser(String openid) {
		// TODO Auto-generated method stub
		return dao.chaUser(openid);
	}

	@Override
	public List fingOrder(String openid) {
		// TODO Auto-generated method stub
		return dao.fingOrder(openid);
	}

	@Override
	public Commodity fingAddre(String openid) {
		// TODO Auto-generated method stub
		return dao.fingAddre(openid);
	}
	
	
	/* 后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台--后台  */
	@Override
	public Commodity loginAdmin(Commodity com) {
		// TODO Auto-generated method stub
		return dao.loginAdmin(com);
	}

	@Override
	public List findAllOpenId() {
		// TODO Auto-generated method stub
		return dao.findAllOpenId();
	}

	@Override
	public List orderAllList(Map map) {
		// TODO Auto-generated method stub
		return dao.orderAllList(map);
	}
	
	@Override
	public List orderAllList3(Map map) {
		// TODO Auto-generated method stub
		return dao.orderAllList3(map);
	}

	@Override
	public int findCount(Map map) {
		// TODO Auto-generated method stub
		return dao.findCount(map);
	}
	
	@Override
	public int findCount2(Map map) {
		// TODO Auto-generated method stub
		return dao.findCount2(map);
	}

	@Override
	public List status() {
		// TODO Auto-generated method stub
		return dao.status();
	}

	@Override
	public Commodity orderAllList2(String orders) {
		// TODO Auto-generated method stub
		return dao.orderAllList2(orders);
	}

	@Override
	public void updateStarts(Map map) {
		// TODO Auto-generated method stub
		dao.updateStarts(map);
	}

	@Override
	public void updateAddre(Map map) {
		// TODO Auto-generated method stub
		dao.updateAddre(map);
	}

	@Override
	public void updateOrders(Map map) {
		// TODO Auto-generated method stub
		dao.updateOrders(map);
	}



	@Override
	public Commodity findByPwd(Map map) {
		// TODO Auto-generated method stub
		return dao.findByPwd(map);
	}

	@Override
	public void updatePwd(Map map) {
		// TODO Auto-generated method stub
		dao.updatePwd(map);
	}

	@Override
	public List allPwdFind() {
		// TODO Auto-generated method stub
		return dao.allPwdFind();
	}

	@Override
	public void addAdminUser(Commodity com) {
		// TODO Auto-generated method stub
		dao.addAdminUser(com);
	}

	@Override
	public Commodity findName(String admin_name) {
		// TODO Auto-generated method stub
		return dao.findName(admin_name);
	}

	@Override
	public Commodity updateAdminPw(String admin_id) {
		// TODO Auto-generated method stub
		return dao.updateAdminPw(admin_id);
	}

	@Override
	public void xgAdmin(Map map) {
		// TODO Auto-generated method stub
		dao.xgAdmin(map);
	}

	@Override
	public void deleteAdmin(String admin_id) {
		// TODO Auto-generated method stub
		dao.deleteAdmin(admin_id);
	}

	@Override
	public void updateUserName(Map map) {
		// TODO Auto-generated method stub
		dao.updateUserName(map);
	}

	@Override
	public Commodity findOrderId(String orders) {
		// TODO Auto-generated method stub
		return dao.findOrderId(orders);
	}

	@Override
	public void updateStatus(Map map) {
		// TODO Auto-generated method stub
		dao.updateStatus(map);
	}

	@Override
	public List startList() {
		// TODO Auto-generated method stub
		return dao.startList();
	}

	@Override
	public void tuikuan(Map map) {
		// TODO Auto-generated method stub
		dao.tuikuan(map);
	}

	@Override
	public Commodity findShop_numm(Map map) {
		// TODO Auto-generated method stub
		return dao.findShop_numm(map);
	}

	@Override
	public List Forders(String orders) {
		// TODO Auto-generated method stub
		return dao.Forders(orders);
	}

	@Override
	public List dynamicimg(int com_id) {
		// TODO Auto-generated method stub
		return dao.dynamicimg(com_id);
	}

	@Override
	public Commodity leibieimg(String start_id) {
		// TODO Auto-generated method stub
		return dao.leibieimg(start_id);
	}


	






	

}
