package module.manager_core.user.service.impl;

import javax.annotation.Resource;

import module.manager_core.user.dao.UserDao;
import module.manager_core.user.entity.User;
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
}
