package neusoft.test.module.service;

import java.util.List;

import neusoft.test.module.domain.Classification;
public interface IClassificationManager {

	public List<Classification> getAll();
	
	/* 下面的方法没有使用到*/
	public Classification getClassificationById(String cid);
	public void addClassification(String cid, String classname);
	public void updateClassification(String cid, String classname);
	public void delClassification(String cid);
}
