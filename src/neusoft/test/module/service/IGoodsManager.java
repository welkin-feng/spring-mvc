package neusoft.test.module.service;

import java.util.List;

import neusoft.test.module.domain.Goods;

public interface IGoodsManager {
	public void addGoods(String gid, String goodsname, Double price, String pic, String cid);
	public void delGoodsById(String gid);
	public void updateGoods(String gid, String goodsname, Double price, String pic, String cid);
	public List<Goods> getAll();
	// 按分类查找商品
	public List<Goods> getAllInOneClassification(String cid);
	public Goods getGoodsById(String gid);
	public List<Goods> getAllInOneClassificationByName(String name);
}
