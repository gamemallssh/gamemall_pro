package module.manager_core.user.dao.impl;

import module.manager_core.user.dao.UserDao;
import module.manager_core.user.entity.User;

import org.springframework.stereotype.Repository;

import core.dao.impl.BaseDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
}
