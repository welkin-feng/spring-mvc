package neusoft.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import neusoft.test.module.domain.Classification;
import neusoft.test.module.domain.Goods;
import neusoft.test.module.domain.User;
import neusoft.test.module.service.IClassificationManager;
import neusoft.test.module.service.IGoodsManager;
import neusoft.test.module.service.IUserManager;

@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
@RequestMapping(value = "/user")
public class UserController {

	@Value("#{userManager}")
	private IUserManager userManager;

	@Value("#{classificationManager}")
	private IClassificationManager classifyManager;

	@Value("#{goodsManager}")
	private IGoodsManager goodsManager;

	@RequestMapping(value = "/userLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView userLogin(@RequestParam(required = true, value = "userName") String userName,
			@RequestParam(required = true, value = "userPwd") String userPwd,
			HttpSession session) {
		// 获取跳转网页名称
		String destination = userManager.userLogin(userName, userPwd);
		ModelAndView mv = null;
		if (destination != null) {
			mv = new ModelAndView(destination);
			User user = userManager.getUserByName(userName);

			mv.addObject("user", user);
			session.setAttribute("user", user);
		}

		// 根据用户类型（要跳转的网页）初始化数据
		if (destination.equals("classification")) {
			List<Classification> classifyList = classifyManager.getAll();
			mv.addObject("classifyList", classifyList);

		} else {
			List<Goods> goodsList = goodsManager.getAll();
			mv.addObject("goodsList", goodsList);
		}

		return mv;
	}

	@RequestMapping(value = "/userRegister", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView userRegister() {
		ModelAndView mv = new ModelAndView("register_user");
		return mv;
	}

	/*
	 * @RequestMapping(path = "/getUser/{userName}", method = RequestMethod.GET)
	 * public ModelAndView getUser(@PathVariable("userName") String userName) {
	 * ModelAndView mv=new ModelAndView("userInfo"); mv.addObject("userName",
	 * userName); return mv; }
	 * 
	 * @RequestMapping(value = "/ajax", method = {
	 * RequestMethod.GET,RequestMethod.POST }) public ModelAndView ajax(
	 * 
	 * @RequestParam(required=true,value="userName") String userName,
	 * 
	 * @RequestParam(required=true,value="userPwd") String userPwd) {
	 * ModelAndView mv=new ModelAndView("userInfo"); mv.addObject("userName",
	 * userName); return mv; }
	 * 
	 * @RequestMapping(value = "/add", method = {
	 * RequestMethod.GET,RequestMethod.POST }) public ModelAndView add() {
	 * ModelAndView mv=new ModelAndView("adduser"); return mv; }
	 */

}
