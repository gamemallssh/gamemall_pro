package module.manager_core.user.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserRole implements Serializable {

	private UserRoleId userrole_id;

	public UserRole() {
	}

	public UserRole(UserRoleId userrole_id) {
		this.userrole_id = userrole_id;
	}

	public UserRoleId getUserrole_id() {
		return userrole_id;
	}

	public void setUserrole_id(UserRoleId userrole_id) {
		this.userrole_id = userrole_id;
	}

}
