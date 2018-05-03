package core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import core.dao.BaseDao;
import core.page.PageResult;
import core.util.QueryHelper;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	Class<T> clazz;
	@Resource private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(Serializable id) {
		getSession().delete(this.findObjectById(id));
	}

	@Override
	public T findObjectById(Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findObjects() {
		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findObjects(QueryHelper queryHelper) {
		Query query = getSession().createQuery(queryHelper.getQueryHql());
		List<Object> parameters = queryHelper.getParameters();
		// 设置参数
		if(parameters != null) {
			for(int i=0; i<parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		Query query = getSession().createQuery(queryHelper.getQueryHql());
		List<Object> parameters = queryHelper.getParameters();
		// 设置参数
		if(parameters != null) {
			for(int i=0; i<parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		if(pageNo < 1) pageNo = 1;
		// 分页限定条件
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Object> items = query.list();
		// 获取总记录数
		Query queryCount = getSession().createQuery(queryHelper.getQueryCountHql());
		if(parameters != null) {
			for(int i=0; i<parameters.size(); i++) {
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		long totalCount = (long)queryCount.uniqueResult();
		return new PageResult(totalCount, pageNo, pageSize, items);
	}
}
