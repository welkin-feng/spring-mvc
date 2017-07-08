package neusoft.test.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import neusoft.test.module.domain.User;
import neusoft.test.module.service.IUserManager;

@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
@RequestMapping(value = "/userMapper")
public class UserMapperController {
	@Value("#{userManager}")
	private IUserManager userManager;
	
	@RequestMapping(value = "/getUserById", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getUserById(@RequestParam(required = true, value = "userId") String userId) {
		ModelAndView mv = new ModelAndView("userInfo");
		User user = this.userManager.getUserById(userId);
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = "/userAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView userAdd(@RequestParam(required = true, value = "userName") String userName,
			@RequestParam(required = true, value = "userPwd") String userPwd) {
			ModelAndView mv;
		if(null!=userName&&null!=userPwd){
			mv = new ModelAndView("index");
			String id = UUID.randomUUID().toString().replace("-", "");
			this.userManager.addUser(id, userName, userPwd);
		}else{
			mv = new ModelAndView("error");
		}
		return mv;
	}

	/*@RequestMapping(value = "/userUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView userUpdate(@RequestParam(required = true, value = "id") String id,
			@RequestParam(required = true, value = "userName") String userName,
			@RequestParam(required = true, value = "userPwd") String userPwd) {
		ModelAndView mv = new ModelAndView("list");
		this.userManager.updateUser(id, userName, userPwd);
		List<User> userList = this.userManager.getAll();
		mv.addObject("userList", userList);
		mv.addObject("userName", userName);
		return mv;
	}

	@RequestMapping(value = "/delUserById", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView delUserById(@RequestParam(required = true, value = "userId") String userId) {
		ModelAndView mv = new ModelAndView("userInfo");
		this.userManager.delUserById(userId);
		mv.addObject("userName", userId);
		return mv;
	}

	@RequestMapping(value = "/getAll", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView("list");
		List<User> userList = this.userManager.getAll();
		mv.addObject("userList", userList);
		mv.addObject("currentUserName", "");
		return mv;
	}

	@RequestMapping(value = "/delUserByIdForJsp", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView delUserForJsp(@RequestParam(required = true, value = "userId") String userId) {
		ModelAndView mv = new ModelAndView("list");
		this.userManager.delUserById(userId);
		List<User> userList = this.userManager.getAll();
		mv.addObject("userList", userList);
		return mv;
	}

	@RequestMapping(value = "/getUserByIdForJsp", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getUserByIdForJsp(@RequestParam(required = true, value = "userId") String userId) {
		ModelAndView mv = new ModelAndView("getuser");
		User user = this.userManager.getUserById(userId);
		mv.addObject("user", user);
		return mv;
	}*/
}
