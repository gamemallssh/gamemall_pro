package module.manager_core.user.dao;

import java.io.Serializable;
import java.util.List;

import module.manager_core.user.entity.User;
import module.manager_core.user.entity.UserRole;
import core.dao.BaseDao;

public interface UserDao extends BaseDao<User> {

	public List<User> findUserByAccountAndId(String user_id, String user_account);

	public void saveUserRole(UserRole userRole);

	public void deleteUserRoleByUserId(Serializable user_id);

	public List<UserRole> getUserRolesByUserId(String user_id);

}
