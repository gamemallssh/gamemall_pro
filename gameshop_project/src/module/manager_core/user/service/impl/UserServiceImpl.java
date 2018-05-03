package module.manager_core.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import module.manager_core.role.entity.Role;
import module.manager_core.user.dao.UserDao;
import module.manager_core.user.entity.User;
import module.manager_core.user.entity.UserRole;
import module.manager_core.user.entity.UserRoleId;
import module.manager_core.user.service.UserService;

import org.springframework.stereotype.Service;

import core.service.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	private UserDao userDao;
	@Resource public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}
	
	@Override
	public List<User> findUserByAccountAndId(String user_id, String user_account) {
		return userDao.findUserByAccountAndId(user_id, user_account);
	}

	@Override
	public void saveUserAndRole(User user, String... roleIds) {
		// 保存用户
		this.save(user);
		// 保存用户对应的角色
		if(roleIds != null) {
			for(String roleId : roleIds) {
				userDao.saveUserRole(new UserRole(new UserRoleId(user.getUser_id(), new Role(roleId))));
			}
		}
	}

	@Override
	public void updateUserAndRole(User user, String... roleIds) {
		// 清空用户对应的角色列表
		userDao.deleteUserRoleByUserId(user.getUser_id());
		// 更新用户
		this.update(user);
		// 保存用户对应的角色
		if(roleIds != null) {
			for(String roleId : roleIds) {
				userDao.saveUserRole(new UserRole(new UserRoleId( user.getUser_id(), new Role(roleId))));
			}
		}
	}

	@Override
	public List<UserRole> getUserRolesByUserId(String user_id) {
		return userDao.getUserRolesByUserId(user_id);
	}

	// 重写delete方法实现级联删除用户对应角色
	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
		// 删除用户对应的权限
		userDao.deleteUserRoleByUserId(id);
	}
}
