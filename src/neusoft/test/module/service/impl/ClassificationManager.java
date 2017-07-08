package neusoft.test.module.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neusoft.test.module.domain.Classification;
import neusoft.test.module.mapper.IClassificationMapper;
import neusoft.test.module.service.IClassificationManager;

@Service("classificationManager")
@Transactional
public class ClassificationManager implements IClassificationManager{
	@Autowired
	private IClassificationMapper classificationMapper;
	
	@Override
	public List<Classification> getAll() {
		List<Classification> list = classificationMapper.getAll();
		return list;
	}

	@Override
	public Classification getClassificationById(String cid) {
		Classification classification = classificationMapper.getClassification(cid);
		return classification;
	}

	@Override
	public void addClassification(String cid, String classname) {
		classificationMapper.add(cid, classname);
	}

	@Override
	public void updateClassification(String cid, String classname) {
		classificationMapper.updateClassification(cid, classname);
	}

	@Override
	public void delClassification(String cid) {
		classificationMapper.delClassificationByID(cid);
	}

}
