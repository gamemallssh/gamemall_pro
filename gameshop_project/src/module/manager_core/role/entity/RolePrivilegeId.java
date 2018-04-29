package module.manager_core.role.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RolePrivilegeId implements Serializable {

	private Role role;	//加载整个role可以在查询user的角色时同时获取其对应的角色名
	private String privilege_code;

	public RolePrivilegeId() {
	}

	public RolePrivilegeId(Role role, String privilege_code) {
		this.role = role;
		this.privilege_code = privilege_code;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPrivilege_code() {
		return privilege_code;
	}

	public void setPrivilege_code(String privilege_code) {
		this.privilege_code = privilege_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((privilege_code == null) ? 0 : privilege_code.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePrivilegeId other = (RolePrivilegeId) obj;
		if (privilege_code == null) {
			if (other.privilege_code != null)
				return false;
		} else if (!privilege_code.equals(other.privilege_code))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

}
