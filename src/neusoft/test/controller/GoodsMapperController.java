package neusoft.test.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neusoft.test.module.domain.Goods;
import neusoft.test.module.domain.User;
import neusoft.test.module.service.ICartManager;
import neusoft.test.module.service.IGoodsManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
@RequestMapping(value = "/goodsMapper")
public class GoodsMapperController {
	@Value("#{goodsManager}")
	private IGoodsManager goodsManager;
	@Value("#{cartManager}")
	private ICartManager cartManager;

	@RequestMapping(value = "/addToCart", method = { RequestMethod.GET, RequestMethod.POST })
	public void addToCart(@RequestParam(required = true, value = "gid") String gid,
			@RequestParam(required = true, value = "count") String count, HttpSession session,
			HttpServletResponse response) throws IOException {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			System.out.println(user.getId() + " 进入addToCart, gid = " + gid + ", count = " + count);
			cartManager.addToCart(user.getId(), gid, Integer.parseInt(count));
			System.out.println("添加成功");
			response.getWriter().write("添加成功");
//			return "添加成功";
		}
		System.out.println("没添加成功");
		response.getWriter().write("没添加成功");
//		return "没添加成功";
	}

	@RequestMapping(value = "/goodsUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goodsUpdate(@RequestParam(required = true, value = "gid") String gid,
			@RequestParam(required = true, value = "goodsname") String goodsname,
			@RequestParam(required = true, value = "price") Double price,
			@RequestParam(required = true, value = "pic") String pic,
			@RequestParam(required = true, value = "cid") String cid) {
		ModelAndView mv = new ModelAndView("goodsmanager");
		this.goodsManager.updateGoods(gid, goodsname, price, pic, cid);
		List<Goods> goodslist = goodsManager.getAll();
		mv.addObject("goodslist", goodslist);
		return mv;
	}

	@RequestMapping(value = "/goodsAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goodsAdd(@RequestParam(required = true, value = "goodsname") String goodsname,
			@RequestParam(required = true, value = "price") String s_price,
			@RequestParam(required = true, value = "pic") String pic,
			@RequestParam(required = true, value = "cid") String cid) {
		ModelAndView mv;
		Double price = Double.valueOf(s_price);
		if (null != goodsname && null != price && null != pic && null != cid) {
			mv = new ModelAndView("goodsmanager");
			String gid = UUID.randomUUID().toString().replace("-", "");
			this.goodsManager.addGoods(gid, goodsname, price, pic, cid);
			List<Goods> goodslist = goodsManager.getAll();
			mv.addObject("goodslist", goodslist);
		} else {
			mv = new ModelAndView("error");
		}
		return mv;
	}

	@RequestMapping(value = "/goodsAddInit", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView toGoodAddInit() {
		ModelAndView mv = new ModelAndView("goodsadd");
		return mv;
	}

	@RequestMapping(value = "/uploadFile", method = { RequestMethod.GET, RequestMethod.POST })
	public void uploadFile(CommonsMultipartFile file, HttpServletRequest request, String newFileName) {
		// 获得原始文件名
		String fileName = file.getOriginalFilename();
		System.out.println("原始文件名:" + fileName);

		// 获得项目的路径
		ServletContext sc = request.getSession().getServletContext();
		// 上传位置
		String path = sc.getRealPath("/pic") + "/"; // 设定文件保存的目录

		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		if (!file.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream(path + newFileName);
				InputStream in = file.getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					fos.write(b);
				}
				fos.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("上传图片到:" + path + newFileName);
	}

	/*
	 * @RequestMapping(value = "/getGoodsByIdForJsp", method = {
	 * RequestMethod.GET, RequestMethod.POST }) public ModelAndView
	 * getUserByIdForJsp(@RequestParam(required = true, value = "gid") String
	 * gid) { ModelAndView mv = new ModelAndView("getgoods"); Goods goods =
	 * this.goodsManager.getGoodsById(gid); mv.addObject("goods", goods); return
	 * mv; }
	 */
}
