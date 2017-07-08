package neusoft.test.module.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neusoft.test.module.domain.Cart;
import neusoft.test.module.domain.Goods;
import neusoft.test.module.mapper.ICartMapper;
import neusoft.test.module.service.ICartManager;
import neusoft.test.module.service.IGoodsManager;

@Service("cartManager")
@Transactional
public class CartManager implements ICartManager {

	@Autowired
	private ICartMapper cartMapper;

	@Autowired
	private IGoodsManager goodsMapper;

	// 将商品添加到购物车
	@Override
	public void addToCart(String uid, String gid, Integer count) {
		Integer oldCount = cartMapper.countOfGidByUid(uid, gid);
		if(oldCount != null){
			this.updateOrDelete(uid, gid, oldCount + count);
			return;
		}
		String oid = UUID.randomUUID().toString().replace("-", "");
		cartMapper.add(oid, uid, gid, count);		
	}

	/* 用户修改自己购物车中商品的数量，如果接收到 count < 0，则不操作，
	 * 如果count == 0，则执行delete方法，
	 * 如果 count > 0且不等于原来的数量，修改
	 * */
	@Override
	public void updateOrDelete(String uid, String gid, Integer newCount) {
		Integer oldCount = cartMapper.countOfGidByUid(uid, gid);
		if(newCount > 0 && newCount != oldCount) {
			cartMapper.updateCount(uid, gid, newCount);
		}
		else if(newCount == 0) {
			cartMapper.delete(uid, gid);
		}
	}

	// 通过用户id查询他购物车里的所有商品
	@Override
	public HashMap<Goods, Integer> findByUid(String uid) {
		HashMap<Goods, Integer> cartMap = new HashMap<>();
		List<Cart> cartList = cartMapper.findByUid(uid);
		
		if(cartList != null)
			for (Cart cart : cartList) 
				cartMap.put(goodsMapper.getGoodsById(cart.getGid()), cart.getCount());
			
		return cartMap;
	}

}
