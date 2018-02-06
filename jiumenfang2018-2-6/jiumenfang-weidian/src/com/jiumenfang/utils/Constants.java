package com.jiumenfang.utils;

/**
 * 常量
 * @author herosky
 *
 */
public class Constants {
	/**
	 * APPID
	 */
	public static String APPID = "wx93181819016578af";
	/**
	 * wx262456b3c807cc0e SECRET wx93181819016578af
	 */
	public static String SECRET = "193cc3c5f068909aa6f5939e84df9ff0";
	/**
	 *aba472c74b6e54c0bbb1789df5fb250b 获取ACCESS_TOKEN接口 193cc3c5f068909aa6f5939e84df9ff0
	 */
	public static String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/**
	 * ACCESS_TOKEN有效时间(单位：ms)
	 */
	public static int EFFECTIVE_TIME = 700000;
	/**
	 * conf.properties文件路径
	 */
	public static String CONF_PROPERTIES_PATH = "src/conf/config.properties";
	/**
	 * 微信接入token ，用于验证微信接口
	 */
	public static String TOKEN = "lalala";
}
