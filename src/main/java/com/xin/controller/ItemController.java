package com.xin.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xin.exception.CustomerException;
import com.xin.pojo.Item;
import com.xin.pojo.Test_QueryVO;
import com.xin.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource
	private ItemService itemService;
	
	@RequestMapping("/allList")
	public ModelAndView findAllList(){
		List<Item> list = itemService.findItemsList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("itemList", list);
		mv.setViewName("itemList");
		return mv;
	}
	/**
	 * 参数传递方式一：
	 * 	通过类型为HttpServletRequest的形参接收request(自动注入),再通过request.getParameter("参数名")方法取出参数
	 * 	同时可以在形参中定义HttpServletResponse,HttpSession。SpringMVC框架会将response及session传递到指定形参中
	 * @param request
	 * @return
	 */
	@RequestMapping("/itemEdit1")
	public ModelAndView findItemById1(HttpServletRequest request){
		String par_id = request.getParameter("id");
		int id = Integer.parseInt(par_id);
		Item item = itemService.findItemById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("item", item);
		mv.setViewName("editItem");
		return mv;
	}
	/**
	 * 返回值为String类型，接收参数中接收一个Model类型参数(实现类为BindingAwareModelMap)
	 */
	@RequestMapping("/itemEdit2")
	public String findItemById2(HttpServletRequest request,Model model){
		String par_id = request.getParameter("id");
		int id = Integer.parseInt(par_id);
		Item item = itemService.findItemById(id);
		model.addAttribute("item", item);
		return "editItem";
	}
	/**
	 * 返回值为String类型，接收参数中接收一个ModelMap类型参数(实现类为BindingAwareModelMap)
	 */
	@RequestMapping("/itemEdit3")
	public String findItemById3(HttpServletRequest request,ModelMap map){
		String par_id = request.getParameter("id");
		int id = Integer.parseInt(par_id);
		Item item = itemService.findItemById(id);
		map.addAttribute("item", item);
		return "editItem";
	}
	//测试使用model参数时返回ModelAndView时会显现那个model。
	//测试后发现显示的时时ModelAndView中的model(形参数model被覆盖，即使先调用ModelAndView的addObject方法后调用Model的addAttribute方法)
	@RequestMapping("/itemEdit4")
	public ModelAndView findItemById4(HttpServletRequest request,Model model){
		String par_id = request.getParameter("id");
		int id = Integer.parseInt(par_id);
		Item item1 = itemService.findItemById(id);
		ModelAndView mv = new ModelAndView();
		Item item2 = itemService.findItemById(2);
		mv.addObject("item", item2);
		model.addAttribute("item", item1);
		mv.setViewName("editItem");
		return mv;
	}
	@RequestMapping("/itemEdit5")
	public ModelAndView findItemById5(Integer id){
		Item item = itemService.findItemById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("item", item);
		mv.setViewName("editItem");
		return mv;
	}
	
	@RequestMapping("/itemEdit6")
	public ModelAndView findItemById6(@RequestParam(value="id",required=false) Integer ids){
		Item item = itemService.findItemById(ids);
		ModelAndView mv = new ModelAndView();
		mv.addObject("item", item);
		mv.setViewName("editItem");
		return mv;
	}
	//测试@RequestParam中同时出现required=true与defaultValue
	//测试后发现请求不带指定参数则指定参数会有默认值，而指定参数有了默认值，required=true就会成立
	@RequestMapping("/itemEdit7")
	public ModelAndView findItemById7(@RequestParam(value="id",required=true) Integer ids){
		Item item = itemService.findItemById(ids);
		ModelAndView mv = new ModelAndView();
		mv.addObject("item", item);
		mv.setViewName("editItem");
		return mv;
	}
	/**
	 * 通过id更新item
	 * @param item	需要更新的item对象
	 * @param name
	 * @return
	 */
	@RequestMapping("/updateitem")
	public String updateItemById(Item item,MultipartFile pictureFile) throws Exception{
		//上传文件的处理
		if(pictureFile.getSize()!=0){//表示有上传的文件
			//1.生成唯一的文件名(uuid)
			String filename = UUID.randomUUID().toString();
			//2.获取上传文件的扩展名
			String originalFilename = pictureFile.getOriginalFilename();//获取原始文件名
			String suffix;
			try {
				suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
			} catch (Exception e) {
				throw new CustomerException("文件无后缀名");
			}
			String pic = filename+suffix;//上传后的文件名+扩展名
			//3.将文件上传到磁盘
			pictureFile.transferTo(new File("E:/_WorkSpace/_FileUpload/"+pic));
			//4.更新商品图片路径
			item.setPic(pic);
		}
		//更新商品
		itemService.updateItem(item);
		return "redirect:/item/allList.action";
	}
	@RequestMapping("/queryitem")
	public void test_QueryVO(Test_QueryVO vo){
		System.out.println(vo);
	}
	
	@RequestMapping("/showSelectIds")
	public String deleteById(Integer[] ids){
		if(ids!=null){
			for (Integer id : ids) {
				System.out.println(id);
			}
		}else{
			System.out.println("ids Is Null");
		}
		return "redirect:/item/allList.action";
	}
	/**
	 * 测试封装List参数
	 * @param vo
	 * @return
	 */
	@RequestMapping("/showUpdateList")
	public String showUpdateList(Test_QueryVO vo){
		for (Item item : vo.getItemList()) {
			System.out.println(item);
		}
		return "redirect:/item/allList.action";
	}
	
}
