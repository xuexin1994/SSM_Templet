package com.xin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class _PageController {
	
	@RequestMapping("/{path}")
	public String toPage(@PathVariable String path) {
		return path;
	}
}
