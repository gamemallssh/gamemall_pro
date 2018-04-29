package core.service.impl;

import java.io.Serializable;
import java.util.List;

import core.dao.BaseDao;
import core.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> baseDao;
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	@Override
	public T findObjectById(Serializable id) {
		return baseDao.findObjectById(id);
	}

	@Override
	public List<T> findObjects() {
		return baseDao.findObjects();
	}

}
