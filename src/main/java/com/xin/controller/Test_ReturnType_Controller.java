package com.xin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("requestType")
public class Test_ReturnType_Controller {
	/**
	 * 通过ModelAndView转跳(success)
	 */
	@RequestMapping("modelAndView")
	public ModelAndView modelAndView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	/**
	 * 通过ModelAndView转跳(forward:/success.jsp)
	 */
	@RequestMapping("modelAndView_Forward")
	public ModelAndView modelAndView_Forword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/success.jsp");
		return mv;
	}
	/**
	 * 通过ModelAndView转跳(redirect:/success.jsp)
	 */
	@RequestMapping("modelAndView_Redirect")
	public ModelAndView modelAndView_Redirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/success.jsp");
		return mv;
	}
	/**
	 * 测试原生的request的请求转发
	 */
	@RequestMapping("requestForward")
	public void requestForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("message", "request Controller");
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	/**
	 * 测试原生的response的重定向
	 */
	@RequestMapping("responseRedirect")
	public void responseRedirect(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.sendRedirect(request.getContextPath()+"/success.jsp");
	}
	/**
	 * 测试返回String类型的请求转发
	 */
	@RequestMapping("returnString")
	public String returnString(HttpServletRequest request) {
		request.setAttribute("message", "测试返回String类型的请求转发");
		return "success";
	}
	/**
	 * 测试返回String类型的请求转发
	 */
	@RequestMapping("returnStringForward")
	public String returnStringForward(HttpServletRequest request) {
		request.setAttribute("message", "测试返回String类型的请求转发");
		return "forward:/success.jsp";
	}
	/**
	 * 测试重定向到其它路径
	 */
	@RequestMapping("returnStringRedirect")
	public String returnStringRedirect() throws Exception {
		return "redirect:/success.jsp";
	}

	/**
	 * 测试重定向到其他域名
	 */
	@RequestMapping("returnStringRedirectOther")
	public String returnStringRedirectOther() throws Exception {
		return "redirect:http://www.baidu.com";
	}
	/**
	 * 测试RedirectAttributes的addAttribute方法
	 * 	
	 */
	@RequestMapping("testRedirectAttributes_AddAttribute")
	public String testRedirectAttributes_AddAttribute(RedirectAttributes attr) {
		attr.addAttribute("message", "redirect message");
		return "redirect:/success.jsp";
	}

	/**
	 * 测试RedirectAttributes的addFlashAttribute方法在页面的取值
	 * 通过el表达式无法取出值(直接定向到页面，没有通过SpringMVC的视图解析器)
	 * @return
	 */
	@RequestMapping("testRedirectAttributes_AddFlashAttribute_GetAttributeInPage1")
	public String testRedirectAttributes_AddFlashAttribute_GetAttributeInPage1(RedirectAttributes attr) {
		attr.addFlashAttribute("message", "redirect message");
		return "redirect:/success.jsp";
	}
	
	/**
	 * 测试RedirectAttributes的addFlashAttribute方法在页面的取值
	 * 通过el表达式可以取出值(有通过SpringMVC的视图解析器)
	 * @return
	 */
	@RequestMapping("testRedirectAttributes_AddFlashAttribute_GetAttributeInPage2")
	public String testRedirectAttributes_AddFlashAttribute_GetAttributeInPage2(RedirectAttributes attr) {
		attr.addFlashAttribute("message", "redirect message");
		return "redirect:/page/success.action";
	}

	/**
	 * 测试addFlashAttribute重定向取值(后台)
	 */
	@RequestMapping("testRedirectAttributes_AddFlashAttribute_GetAttributeInController1")
	public String testRedirectAttributes_AddFlashAttribute_GetAttributeInController1(HttpSession session,RedirectAttributes attr) throws Exception {
		attr.addFlashAttribute("message", "redirect message");
		session.setAttribute("attributes", "attributes");
		return "redirect:/requestType/testGetAttributeInController1.action";
	}
	/**
	 * 测试addFlashAttribute重定向取值(后台)
	 */
	@RequestMapping("testRedirectAttributes_AddFlashAttribute_GetAttributeInController2")
	public String testRedirectAttributes_AddFlashAttribute_GetAttributeInController2(HttpSession session,RedirectAttributes attr) throws Exception {
		attr.addFlashAttribute("message", "redirect message");
		session.setAttribute("attributes", "attributes");
		return "redirect:/requestType/testGetAttributeInController2.action";
	}

	/**
	 * 测试addFlashAttribute重定向取值。
	 */
	@RequestMapping("testGetAttributeInController1")
	public String testGetAttributeInController1(HttpServletRequest request,HttpSession session)  {
		//输出值为attributes方法中setAttribute方法传递进来的值
		System.out.println(session.getAttribute("attributes"));
		//输出值为null
		System.out.println(session.getAttribute("message"));
		Map<String, Object> map=RequestContextUtils.getOutputFlashMap(request);
		//输出值为null
		System.out.println(map.get("message"));
		Map<String, ?> map2 = RequestContextUtils.getInputFlashMap(request);
		//输出值为attributes方法中addFlashAttribute方法传递进来的值
		if(map2!=null){
			System.out.println(map2.get("message"));
		}else{
			System.out.println("map2为null,估计是因为没有InputFlashMap");
		}
		return "forward:/page/success.action";
	}
	/**
	 * 测试addFlashAttribute重定向取值。
	 * 使用@ModelAttribute注解需要在SpringMVC配置文件中使用<mvc:annotation-driven>标签
	 */
	@RequestMapping("testGetAttributeInController2")
	public String testGetAttributeInController2(@ModelAttribute("message") String str){   
		System.out.println(str);   
		return "forward:/page/success.action";
	} 
}
