package module.manager_core.role.entity;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Role implements Serializable {

	private String role_id;
	private String role_name;
	private Set<RolePrivilege> role_privilege;

	public Role() {
	}

	public Role(String role_id, String role_name,
			Set<RolePrivilege> role_privilege) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_privilege = role_privilege;
	}

	public Role(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Set<RolePrivilege> getRole_privilege() {
		return role_privilege;
	}

	public void setRole_privilege(Set<RolePrivilege> role_privilege) {
		this.role_privilege = role_privilege;
	}

}
