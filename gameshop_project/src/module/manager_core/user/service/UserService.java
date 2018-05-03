package module.manager_core.user.service;

import java.util.List;

import module.manager_core.user.entity.User;
import module.manager_core.user.entity.UserRole;
import core.service.BaseService;

public interface UserService extends BaseService<User> {

	// 根据账号和id查询用户
	public List<User> findUserByAccountAndId(String user_id, String user_account);

	// 保存用户及其对应的角色
	public void saveUserAndRole(User user, String... roleIds);

	// 更新用户及其对应的角色
	public void updateUserAndRole(User user, String... roleIds);

	// 根据用户Id获取对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(String user_id);

}
