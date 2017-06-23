package com.paul.sertest.config;

/**
 * 全局配置常量
 * @author XY
 *
 */
public class Constant {
	
	/**
	 * 数据请求返回码
	 */
	public static final int RESCODE_SUCCESS = 1000;				//成功
	public static final int RESCODE_SUCCESS_MSG = 1001;			//成功(有返回信息)
	public static final int RESCODE_EXCEPTION = 1002;			//请求抛出异常
	public static final int RESCODE_EXCEPTION_MSG = 1008;		//异常带数据
	public static final int RESCODE_NOLOGIN = 1003;				//未登陆状态
	public static final int RESCODE_NOEXIST = 1004;				//查询结果为空
	public static final int RESCODE_NOAUTH = 1005;				//无操作权限
	public static final int RESCODE_REFTOKEN_MSG = 1006;		//刷新TOKEN(有返回数据)
	public static final int RESCODE_REFTOKEN = 1007;			//刷新TOKEN

	/**
	 * jwt
	 */
	public static final String JWT_ID = "jwt_id";										//jwtid
	public static final String JWT_SECERT = "7786df7fc3a34e26a61c034d5ec8245d";			//密匙
	public static final int JWT_TTL = 60 * 60 * 1000;									//token有效时间
	
}
