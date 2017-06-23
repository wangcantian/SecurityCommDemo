package com.paul.sertest.model;

/**
 * 验证结果模型
 * @author XY
 *
 */
public class CheckResult {

	private int errCode;
	
	private String errMsg;
	
	private boolean success;

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
