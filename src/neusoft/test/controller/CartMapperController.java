package neusoft.test.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import neusoft.test.module.domain.Goods;
import neusoft.test.module.domain.User;
import neusoft.test.module.service.ICartManager;

@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
@RequestMapping(value = "/cart")
public class CartMapperController {

	/*
	 * @Value("#{userManager}") private IUserManager userManager;
	 * 
	 * @Value("#{goodsManager}") private IGoodsManager goodsManager;
	 */

	@Value("#{cartManager}")
	private ICartManager cartManager;

	@RequestMapping(value = "/myCart", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView myCart(HttpSession session) {
		ModelAndView mv = new ModelAndView("cart");
		User user = (User) session.getAttribute("user");
		if (user != null) {
			mv.addObject("user", user);
			HashMap<Goods, Integer> cartMap = cartManager.findByUid(user.getId());
			mv.addObject("cartMap", cartMap);
		}

		return mv;
	}

	@RequestMapping(value = "/deleteGoods", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteGoods(@RequestParam(required = true, value = "gid") String gid,
			HttpSession session, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView(new RedirectView("myCart"));
		User user = (User) session.getAttribute("user");
		if (user != null) {
			System.out.println(user.getId() + " 进入deleteGoods, gid = " + gid);
			cartManager.updateOrDelete(user.getId(), gid, 0);
			System.out.println("删除成功");
			response.getWriter().write("删除成功");
			return mv;
		}
		System.out.println("删除没成功");
		response.getWriter().write("删除没成功");
		return mv;
	}

	@RequestMapping(value = "/updateGoodsAmount", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateGoodsAmount(@RequestParam(required = true, value = "gid") String gid,
			@RequestParam(required = true, value = "count") String count,
			HttpSession session) {
		String mv = "forward:<@spring.url ''/>/cart/myCart";
		User user = (User) session.getAttribute("user");
		if (user != null) {
			System.out.println(user.getId() + " 进入updateGoodsAmount, gid = " + gid + ", count" + count);
			Integer newCount = Integer.parseInt(count);
			cartManager.updateOrDelete(user.getId(), gid, newCount);
			return mv;
		}
		return mv;
	}
}
