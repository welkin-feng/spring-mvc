package neusoft.test.module.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import neusoft.test.module.domain.Cart;

public interface ICartMapper {
	// 用户向购物车中添加商品，需要参数oid, uid, gid, count，oid通过uuid方法生成
	@Insert("INSERT INTO cart(oid,uid,gid,count) VALUES(#{oid},#{uid},#{gid},#{count})")
	public void add(
			@Param("oid") String oid,
			@Param("uid") String uid,
			@Param("gid") String gid,
			@Param("count") Integer count);
	
	// 用户只能修改所选商品的数量，要求count > 0，服务器判断当 count == 0的时候应该执行delete方法
	@Update("update cart set count=#{count} where uid = #{uid} and gid = #{gid} ")
	public void updateCount(@Param("uid") String uid, @Param("gid") String gid, @Param("count") Integer count);
	
	// 用户删除购物车中的一件商品
	@Delete("delete from cart where uid = #{uid} and gid = #{gid}")
	public void delete(@Param("uid") String uid, @Param("gid") String gid);
	
	// 通过用户id查找他购物车中的商品
	@Select("select gid, count from cart where uid = #{uid}")
	public List<Cart> findByUid(@Param("uid") String uid);
	
	// 查找用户gid商品的数量
	@Select("select count from cart where uid = #{uid} and gid = #{gid}")
	public Integer countOfGidByUid(@Param("uid") String uid, @Param("gid") String gid);
}
