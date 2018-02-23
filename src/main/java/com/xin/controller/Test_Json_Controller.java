package com.xin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xin.exception.CustomerException;
import com.xin.pojo.Item;

@Controller
@RequestMapping("json")
public class Test_Json_Controller {
	
	@RequestMapping("testSendJson")
	@ResponseBody
	public Item testSendJson(@RequestBody Item item){   
		System.out.println(item);
		return item;
	}
}
