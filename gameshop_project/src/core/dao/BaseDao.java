package core.dao;

import java.io.Serializable;
import java.util.List;

import core.page.PageResult;
import core.util.QueryHelper;

public interface BaseDao<T> {

	// 添加一个对象
	public void save(T entity);
	
	// 更新一个对象
	public void update(T entity);
	
	// 删除一个对象
	public void delete(Serializable id);
	
	// 根据ID查找对象
	public T findObjectById(Serializable id);
	
	// 查询所有对象
	public List<T> findObjects();

	// 条件查询获取实体列表
	public List<T> findObjects(QueryHelper queryHelper);

	/**
	 * 获取分页结果对象
	 * @param queryHelper 查询助手
	 * @param pageNo	当前页
	 * @param pageSize	页大小
	 * @return
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize);
	
}
