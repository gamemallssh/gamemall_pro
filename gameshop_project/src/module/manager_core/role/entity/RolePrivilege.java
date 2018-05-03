package module.manager_core.role.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RolePrivilege implements Serializable {

	private RolePrivilegeId roleprivilege_id;

	public RolePrivilege() {
	}

	public RolePrivilege(RolePrivilegeId roleprivilege_id) {
		this.roleprivilege_id = roleprivilege_id;
	}

	public RolePrivilegeId getRoleprivilege_id() {
		return roleprivilege_id;
	}

	public void setRoleprivilege_id(RolePrivilegeId roleprivilege_id) {
		this.roleprivilege_id = roleprivilege_id;
	}

}
