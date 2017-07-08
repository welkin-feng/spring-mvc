package neusoft.test.module.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import neusoft.test.module.domain.User;

public interface IUserMapper {
	/*
	 * create table user(id varchar(255) not null primary key, username varchar(31) not null unique, userpwd varchar(31) not null);
	 */
	// 使用@Select注解指明getById方法要执行的SQL
	@Select("SELECT * FROM user WHERE id = #{userId}")
	public User getUser(@Param("userId") String userId);

	@Select("SELECT * FROM user WHERE username = #{userName}")
	public User getUserByName(@Param("userName") String userName);

	
	// 使用@Insert注解指明add方法要执行的SQL
	@Insert("INSERT INTO user(id,username,userpwd) VALUES(#{id},#{userName},#{userPwd})")
	public void add(@Param("id") String id, @Param("userName") String userName, @Param("userPwd") String userPwd);

	// 使用@Update注解指明update方法要执行的SQL
	@Update("update user set username=#{userName},userpwd=#{userPwd} where id=#{id}")
	public void updateUser(@Param("id") String id, @Param("userName") String userName,
			@Param("userPwd") String userPwd);

	// 使用@Delete注解指明deleteById方法要执行的SQL
	@Delete("delete from user where id=#{userId} ")
	public void delUserById(@Param("userId") String userId);

	// 使用@Select注解指明getAll方法要执行的SQL
	@Select("select * from user")
	public List<User> getAll();

}
