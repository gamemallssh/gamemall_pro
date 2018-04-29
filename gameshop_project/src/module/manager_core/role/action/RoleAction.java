package module.manager_core.role.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import module.manager_core.role.entity.Role;
import module.manager_core.role.service.RoleService;
import core.action.BaseAction;
import core.constant.Constant;

@SuppressWarnings("serial")
public class RoleAction extends BaseAction {

	@Resource
	private RoleService roleService;
	private List<Role> roleList;
	private Role role;
	
	private String[] privilegeIds;

	// 列表页面
	public String listUI() {
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		roleList = roleService.findObjects();
		return "listUI";
	}

	// 添加页面
	public String addUI() {
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "addUI";
	}

	// 保存添加
	public String add() {
		if(role != null) {
			roleService.save(role);
		}
		return "list";
	}

	// 编辑页面
	public String editUI() {
		if(role != null && role.getRole_id() != null) {
			role = roleService.findObjectById(role.getRole_id());
		}
		return "editUI";
	}

	// 保存编辑
	public String edit() {
		if(role != null) {
			roleService.update(role);
		}
		return "list";
	}

	// 保存删除
	public String delete() {
		if(role != null && role.getRole_id() != null) {
			roleService.delete(role.getRole_id());
		}
		return "list";
	}

	// 批量删除
	public String deleteSelected() {
		if(selectedRow != null && selectedRow.length > 0) {
			for(String id : selectedRow) {
				roleService.delete(id);
			}
		}
		return "list";
	}
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
}
