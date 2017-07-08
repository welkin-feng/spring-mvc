package neusoft.test.module.mapper;

import java.util.List;

import neusoft.test.module.domain.Classification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IClassificationMapper {
	/*
	create table classification(cid varchar(255) not null primary key, classname varchar(31) not null unique)
	*/

	@Select("SELECT * FROM classification WHERE cid=#{cid}")
	public Classification getClassification(@Param("cid") String cid);
	
	@Insert("INSERT INTO classification(cid,classname) VALUES(#{cid},#{classname})")
	public void add(@Param("cid") String cid, @Param("classname") String classname);
	
	@Update("update classification set classname=#{classname} WHERE cid=#{cid}")
	public void updateClassification (@Param("cid") String cid, @Param("classname") String classname);
	
	@Delete("delete from classification where cid=#{cid}")
	public void delClassificationByID(@Param("cid") String cid);
	
	@Select("select * from classification")
	public List<Classification> getAll();

}