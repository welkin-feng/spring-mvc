package neusoft.test.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import neusoft.test.module.domain.Goods;
import neusoft.test.module.domain.User;
import neusoft.test.module.service.IGoodsManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
@RequestMapping(value = "/classifyMapper")
public class ClassifyMapperController {
	@Value("#{goodsManager}")
	private IGoodsManager goodsManager;
	
	@RequestMapping(value = "/getGoodsByClassId", method = {RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getGoodsByClassId(@RequestParam("cid") String cid, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("goods_list");
		List<Goods> goodsList = goodsManager.getAllInOneClassification(cid);
		mv.addObject("goodsList", goodsList);
		
		User user = (User) session.getAttribute("user");
		if(user != null) {
			mv.addObject("user", user);
		}
		
		return mv;
	}

}
