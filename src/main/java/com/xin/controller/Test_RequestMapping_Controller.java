package com.xin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("requestMapping")
public class Test_RequestMapping_Controller {
	/**
	 * 测试@RequestMapping中的method属性
	 * @return 
	 */
	@RequestMapping(value = "/testRequestMethod", method = RequestMethod.POST)
	public String testRequestMethod() {
		// 方法体
		System.out.println("testRequestMethod方法");
		return "success";
	}
	/**
	 * 测试@RequestMapping中的params属性
	 * @return 
	 */
	@RequestMapping(value = "/testRequestParamsInclude", params="id")
	public String testRequestParamsInclude() {
		// 方法体
		System.out.println("testRequestParamsInclude方法");
		return "success";
	}
	/**
	 * 测试@RequestMapping中的params属性
	 * @return 
	 */
	@RequestMapping(value = "/testRequestParamsExclued", params="!id")
	public String testRequestParamsExclued() {
		// 方法体
		System.out.println("testRequestParamsExclued方法");
		return "success";
	}
	/**
	 * 测试@RequestMapping中的params属性
	 * @return 
	 */
	@RequestMapping(value = "/testRequestParamsNoEqual", params="id!=1")
	public String testRequestParamsNoEqual() {
		// 方法体
		System.out.println("testRequestParamsNoEqual方法");
		return "success";
	}
	/**
	 * 测试@RequestMapping中的method属性
	 * @return 
	 */
	@RequestMapping(value = "/testRequestSamePath", params="id")
	public String testRequestSamePathNeedId(HttpServletRequest request) {
		// 方法体
		System.out.println("testRequestMethod方法");
		request.setAttribute("message", "有id参数");
		return "success";
	}
	@RequestMapping(value = "/testRequestSamePath", params="!id")
	public String testRequestSamePathNotId(HttpServletRequest request) {
		// 方法体
		System.out.println("testRequestMethod方法");
		request.setAttribute("message", "无id参数");
		return "success";
	}
}
