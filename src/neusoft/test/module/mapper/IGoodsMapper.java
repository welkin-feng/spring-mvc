package neusoft.test.module.mapper;

import java.util.List;

import neusoft.test.module.domain.Goods;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IGoodsMapper {
	/*
	 * create table goods(gid varchar(255) not null primary key, goodsname
	 * varchar(31) not null, price double not null, pic varchar(63), cid
	 * varchar(255) not null);
	 */
	@Select("SELECT * FROM goods WHERE gid = #{gid}")
	public Goods getGoods(@Param("gid") String gid);

	@Select("select * from goods")
	public List<Goods> getAll();

	@Select("select * from goods where cid = #{cid}")
	public List<Goods> getAllInOneClassification(@Param("cid") String cid);

	@Select("select * from goods where classname=#{classname}")
	public List<Goods> getAllInOneClassificationByName(@Param("classname") String classname);
	
	@Insert("insert into goods(gid,goodsname,price,pic,cid) VALUES(#{gid}, #{goodsname}, #{price}, #{pic}, #{cid})")
	public void add(@Param("gid") String gid, @Param("goodsname") String goodsname, @Param("price") Double price,
			@Param("pic") String pic, @Param("cid") String cid);

	@Update("update goods set goodsname = #{goodsname}, price = #{price}, pic = #{pic}, cid = #{cid} where gid = #{gid}")
	public void updateGoods(@Param("gid") String gid, @Param("goodsname") String goodsname,
			@Param("price") Double price, @Param("pic") String pic, @Param("cid") String cid);

	@Delete("delete from goods where gid = #{gid} ")
	public void delGoodsById(@Param("gid") String gid);

	@Delete("delete from goods where cid = #{cid}")
	public void delGoodsByCid(@Param("cid") String cid);
}
