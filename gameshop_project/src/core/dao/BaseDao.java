package core.dao;

import java.io.Serializable;
import java.util.List;

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
	
}
