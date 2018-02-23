package com.xin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xin.exception.CustomerException;
import com.xin.pojo.Item;

@Controller
@RequestMapping("exception_IntoInterceptor")
public class Test_Exception_Interceptor_Controller {
	
	@RequestMapping("customerException")
	public void testCustomerException() throws CustomerException{   
		throw new CustomerException("商品不存在");
	}
	
	@RequestMapping("runtimeException")
	public void testRuntimeException() throws CustomerException{   
		System.out.println(1/0);
	}

	@RequestMapping("intoInterceptor2")
	public String intoInterceptor2(Model m){ 
		System.out.println("-----通过了拦截器二-----");
		m.addAttribute("message", "通过了拦截器二");
		return "success";
	}
	
}
