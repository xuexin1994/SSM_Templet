package com.xin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xin.pojo.Item;
import com.xin.service.ItemService;

@Controller
@RequestMapping("/restful")
public class RESTfulController {
	
	@Resource
	private ItemService itemService;
	
	/**
	 * RESTful风格将参数写到url上，通过url模板映射的方式取值
	 * @PathVariable 从url中获取参数的值，映射到方法的参数上，形参名需要与大括号(大括号相当于占位符)中的值相同
	 */
	@RequestMapping("/editItem/{id}/{a}/{b}/{c}")
	public String findItemById2(Model model,@PathVariable Integer id,
			@PathVariable(value="a") Integer abc,@PathVariable Integer b,@PathVariable Integer c){
		Item item = itemService.findItemById(id);
		model.addAttribute("item", item);
		return "editItem";
	}
}
