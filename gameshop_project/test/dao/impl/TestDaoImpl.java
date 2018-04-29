package dao.impl;

import org.springframework.stereotype.Repository;

import core.dao.impl.BaseDaoImpl;
import dao.TestDao;
import entity.TestEntity;

@Repository("testDao")
public class TestDaoImpl extends BaseDaoImpl<TestEntity> implements TestDao {

}
