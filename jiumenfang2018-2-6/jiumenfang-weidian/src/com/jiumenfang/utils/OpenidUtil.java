package com.jiumenfang.utils;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;

public class OpenidUtil {
	static String OPENID_KEY="_openid";
	static String OPENID_INFO_KEY="_openid_info";

	/**获取opid
	 * @param request
	 * @return
	 */
	public static String getOpenid(HttpServletRequest request) {
		Object opid = request.getSession().getAttribute(OPENID_KEY);
		if (opid==null) {
			return null;
		}
		return (String) opid;
	}

	public static void setOpenid(String openid, HttpServletRequest request) {
		if (openid!=null) {
			request.getSession().setAttribute(OPENID_KEY, openid);
		}
	}

	public static JsonObject getOpenInfo(HttpServletRequest request) {
		
		return (JsonObject) request.getSession().getAttribute(OPENID_INFO_KEY);
	}

	public static void setOpenidInfo(HttpServletRequest request,
			JsonObject openuser) {
		request.getSession().setAttribute(OPENID_INFO_KEY,openuser);
	}
	
}
