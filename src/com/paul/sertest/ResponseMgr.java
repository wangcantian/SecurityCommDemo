package com.paul.sertest;

import com.paul.sertest.config.Constant;
import com.paul.sertest.model.CommonResult;
import com.paul.sertest.utils.GsonUtil;

public class ResponseMgr {
	
	/**
	 * 请求返回数据处理
	 * @param commonResult
	 * @return
	 */
	public static String general(CommonResult commonResult) {
		return GsonUtil.objectToJsonStr(commonResult);
	}
	
	/**
	 * 成功请求不带数据
	 * @return
	 */
	public static String success() {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_SUCCESS, "success");
		return general(commonResult);
	}
	
	/**
	 * 成功请求带返回数据
	 * @param data
	 * @return
	 */
	public static String successWithData(Object data) {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_SUCCESS_MSG, data, "success");
		return general(commonResult);
	}
	
	/**
	 * 服务器异常不带数据
	 * @return
	 */
	public static String err() {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_EXCEPTION, "请稍后再试");
		return general(commonResult);
	}

	/**
	 * 服务器异常带数据
	 * @param data
	 * @return
	 */
	public static String errWhitData(Object data) {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_EXCEPTION_MSG, data, "请稍后再试");
		return general(commonResult);
	}
	
	/**
	 * 服务器异常带数据和消息
	 * @param data
	 * @return
	 */
	public static String errWhitData(String msg, Object data) {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_EXCEPTION_MSG, data, msg);
		return general(commonResult);
	}
	
	/**
	 * 用户未登录
	 * @return
	 */
	public static String noLogin() {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_NOLOGIN, "用户未登录");
		return general(commonResult);
	}
	
	/**
	 * 结果为空
	 * @return
	 */
	public static String noExist() {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_NOEXIST, "结果为空");
		return general(commonResult);
	}
	
	/**
	 * 无操作权限
	 * @return
	 */
	public static String noAuth() {
		CommonResult commonResult = new CommonResult(Constant.RESCODE_NOAUTH, "拒绝授权");
		return general(commonResult);
	}
}
