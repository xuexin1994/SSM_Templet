package com.xin.exception;

/**
 * 自定义异常处理类,模拟用户操作异常
 * @author xuexin
 *
 */
public class CustomerException extends Exception {
	private static final long serialVersionUID = 1L;
	public CustomerException() {
		super();
	}
	private String message;
	
	public CustomerException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
