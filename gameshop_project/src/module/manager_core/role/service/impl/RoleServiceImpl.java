package module.manager_core.role.service.impl;

import javax.annotation.Resource;

import module.manager_core.role.dao.RoleDao;
import module.manager_core.role.entity.Role;
import module.manager_core.role.service.RoleService;

import org.springframework.stereotype.Service;

import core.service.impl.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	private RoleDao roleDao;
	@Resource public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}
	
	@Override
	public void update(Role role) {
		// 清除update带来的回填影响
		roleDao.deleteRolePrivilegeByRoleId(role.getRole_id());
		roleDao.update(role);
	}
	
}
