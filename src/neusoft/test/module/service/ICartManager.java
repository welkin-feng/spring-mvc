package neusoft.test.module.service;

import java.util.HashMap;

import neusoft.test.module.domain.Goods;

public interface ICartManager {
	
	// 将商品添加到购物车
	public void addToCart(String uid, String gid, Integer count);
	
	/* 用户修改自己购物车中商品的数量，如果接收到 count < 0，则不操作，
	 * 如果count == 0，则执行delete方法，
	 * 如果 count > 0且不等于原来的数量，修改
	 * */
	public void updateOrDelete(String uid, String gid, Integer newCount);
	
	// 通过用户id查询他购物车里的所有商品
	public HashMap<Goods, Integer> findByUid(String uid);

}
