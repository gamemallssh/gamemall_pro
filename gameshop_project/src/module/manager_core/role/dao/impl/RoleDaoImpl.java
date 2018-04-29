package module.manager_core.role.dao.impl;

import org.springframework.stereotype.Repository;

import module.manager_core.role.dao.RoleDao;
import module.manager_core.role.entity.Role;
import core.dao.impl.BaseDaoImpl;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
}
