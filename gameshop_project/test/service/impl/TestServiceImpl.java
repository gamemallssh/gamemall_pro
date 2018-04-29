package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.TestService;
import core.service.impl.BaseServiceImpl;
import dao.TestDao;
import entity.TestEntity;

@Service("testService")
public class TestServiceImpl extends BaseServiceImpl<TestEntity> implements TestService {

	private TestDao testDao;
	@Resource public void setTestDao(TestDao testDao) {
		super.setBaseDao(testDao);
		this.testDao = testDao;
	}

}
