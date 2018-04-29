package core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询助手：提供（HQL语句）和（参数值）
 * 分析：from( + where + order by)
 * @author aqin
 *
 */
public class QueryHelper {

	// from 子句
	private String fromClause = "";
	// where 子句
	private String whereClause = "";
	// order by 子句
	private String orderByClause = "";
	// 参数值
	private List<Object> parameters;
	
	// 排序常量
	public static String ORDER_BY_ASC = " AES";		//升序
	public static String ORDER_BY_DESC = " DESC";	//降序
	
	/**
	 * 构造from子句
	 * @param clazz 实体类
	 * @param alias 实体类对应的别名
	 */
	public QueryHelper(Class<?> clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}
	
	/**
	 * 添加where条件
	 * @param condition 查询条件语句，例如：i.title like ?(一个?对应一个参数)
	 * @param params
	 */
	public void addCondition(String condition, Object... params) {
		if(whereClause.length() > 0) {
			//AND子句
			whereClause += " AND " + condition;
		}else {
			//WHERE子句
			whereClause = " WHERE " + condition;
		}
		
		if(params != null) {
			if(parameters == null) {
				parameters = new ArrayList<Object>();
			}
			for(Object param : params) {
				parameters.add(param);
			}
		}
	}
	
	/**
	 * 构造orderby子句
	 * @param property 排序依据
	 * @param order	排序顺序
	 */
	public void addOrderByProperty(String property, String order) {
		orderByClause = " ORDER BY " + property + " " + order;
	}
	
	/**
	 * 获取HQL拼接语句
	 * @return 返回HQL语句
	 */
	public String getQueryHql() {
		return fromClause + whereClause + orderByClause;
	}
	
	/**
	 * 获取HQL查询列表的数据量的查询语句
	 * @return
	 */
	public String getQueryCountHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	public List<Object> getParameters() {
		return parameters;
	}
}
