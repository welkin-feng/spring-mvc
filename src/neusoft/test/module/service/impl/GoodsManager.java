package neusoft.test.module.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neusoft.test.module.domain.Goods;
import neusoft.test.module.mapper.IGoodsMapper;
import neusoft.test.module.service.IGoodsManager;

@Service("goodsManager")
@Transactional
public class GoodsManager implements IGoodsManager{
	
	@Autowired
	private IGoodsMapper goodsMapper;
	
	@Override
	public void addGoods(String gid, String goodsname, Double price, String pic, String cid) {
		goodsMapper.add(gid, goodsname, price, pic, cid);
	}

	@Override
	public void delGoodsById(String gid) {
		goodsMapper.delGoodsById(gid);
	}

	@Override
	public void updateGoods(String gid, String goodsname, Double price,
			String pic, String cid) {
		goodsMapper.updateGoods(gid, goodsname, price, pic, cid);
	}

	@Override
	public List<Goods> getAll() {
		List<Goods> list = goodsMapper.getAll();
		return list;
	}

	@Override
	public Goods getGoodsById(String gid) {
		Goods goods = goodsMapper.getGoods(gid);
		return goods;
	}

	@Override
	public List<Goods> getAllInOneClassification(String cid) {
		List<Goods> list = goodsMapper.getAllInOneClassification(cid);
		return list;
	}

	@Override
	public List<Goods> getAllInOneClassificationByName(String name) {
		List<Goods> list = goodsMapper.getAllInOneClassificationByName(name);
		return list;
	}

}
