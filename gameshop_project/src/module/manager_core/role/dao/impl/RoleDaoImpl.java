package module.manager_core.role.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import module.manager_core.role.dao.RoleDao;
import module.manager_core.role.entity.Role;
import core.dao.impl.BaseDaoImpl;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String role_id) {
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE roleprivilege_id.role.role_id = ?");
		query.setParameter(0, role_id);
		query.executeUpdate();
	}
}
