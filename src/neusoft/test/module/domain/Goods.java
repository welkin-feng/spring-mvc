package neusoft.test.module.domain;

public class Goods {
	private String gid; // 商品id
	private String goodsname; // 商品名
	private Double price; // 商品价格
	private String pic; // 商品图片目录
	private Classification classify;	// 商品类别
	private String cid;
	
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Classification getClassify() {
		return classify;
	}

	public void setClassify(Classification classify) {
		this.classify = classify;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}
