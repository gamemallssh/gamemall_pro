package module.manager_core.role.dao;

import module.manager_core.role.entity.Role;
import core.dao.BaseDao;

public interface RoleDao extends BaseDao<Role> {

	public void deleteRolePrivilegeByRoleId(String role_id);
}
