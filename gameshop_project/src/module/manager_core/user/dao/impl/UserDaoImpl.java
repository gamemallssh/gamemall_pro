package module.manager_core.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import module.manager_core.user.dao.UserDao;
import module.manager_core.user.entity.User;
import module.manager_core.user.entity.UserRole;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import core.dao.impl.BaseDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserByAccountAndId(String user_id, String user_account) {
		String hql = "FROM User WHERE user_account = ?";
		if(StringUtils.isNotBlank(user_id)) {
			hql += " AND user_id != ?";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, user_account);
		if(StringUtils.isNotBlank(user_id)) {
			query.setParameter(1, user_id);
		}
		return query.list();
	}

	@Override
	public void saveUserRole(UserRole userRole) {
		getSession().save(userRole);
	}

	@Override
	public void deleteUserRoleByUserId(Serializable user_id) {
		Query query = getSession().createQuery("DELETE FROM UserRole WHERE userrole_id.user_id = ?");
		query.setParameter(0, user_id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRolesByUserId(String user_id) {
		Query query = getSession().createQuery("FROM UserRole WHERE userrole_id.user_id = ?");
		query.setParameter(0, user_id);
		return query.list();
	}
}
