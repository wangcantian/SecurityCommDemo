package com.paul.sertest.model;

/**
 * 标准数据返回格式
 * @author XY
 *
 */
public class CommonResult {

	private int code;
	
	private Object data;
	
	private String msg;
	
	private String token;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "CommonResult [code=" + code + ", data=" + data + ", msg=" + msg
				+ ", token=" + token + "]";
	}

	public CommonResult() { }
	
	public CommonResult(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public CommonResult(int code, Object data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public CommonResult(int code, Object data, String msg, String token) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.token = token;
	}
	
}
