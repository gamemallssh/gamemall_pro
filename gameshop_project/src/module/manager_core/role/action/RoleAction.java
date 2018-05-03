package module.manager_core.role.action;

import java.net.URLDecoder;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import module.manager_core.role.entity.Role;
import module.manager_core.role.entity.RolePrivilege;
import module.manager_core.role.entity.RolePrivilegeId;
import module.manager_core.role.service.RoleService;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.constant.Constant;
import core.util.QueryHelper;

@SuppressWarnings("serial")
public class RoleAction extends BaseAction {

	@Resource
	private RoleService roleService;
	private List<Role> roleList;
	private Role role;
	
	private String[] privilegeIds;
	// 查询条件回显
	private String strName;

	// 列表页面
	public String listUI() {
		// 加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		// 创建查询助手
		QueryHelper queryHelper = new QueryHelper(Role.class, "r");
		try {
			if(role != null) {
				if(StringUtils.isNotBlank(role.getRole_name())) {
					role.setRole_name(URLDecoder.decode(role.getRole_name(), "UTF-8"));
					queryHelper.addCondition("r.role_name like ?", "%"+ role.getRole_name() +"%");
				}
			}
			// 获取分页结果对象
			pageResult = roleService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}

	// 添加页面
	public String addUI() {
		// 加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "addUI";
	}

	// 保存添加
	public String add() {
		if(role != null) {
			if(privilegeIds != null && privilegeIds.length > 0) {
				HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
				for(String privilegeId : privilegeIds) {
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeId)));
				}
				role.setRole_privilege(set);
			}
			roleService.save(role);
		}
		return "list";
	}

	// 编辑页面
	public String editUI() {
		// 加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		if(role != null && role.getRole_id() != null) {
			if(StringUtils.isNotBlank(role.getRole_name())) {
				// 查询条件回显
				strName = role.getRole_name();
			}
			role = roleService.findObjectById(role.getRole_id());
			// 权限回显
			if(role.getRole_privilege() != null) {
				privilegeIds = new String[role.getRole_privilege().size()];
				int i = 0;
				for(RolePrivilege rp : role.getRole_privilege()) {
					privilegeIds[i++] = rp.getRoleprivilege_id().getPrivilege_code();
				}
			}
		}
		return "editUI";
	}

	// 保存编辑
	public String edit() {
		if(role != null) {
			if(privilegeIds != null && privilegeIds.length > 0) {
				HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
				for(String privilegeId : privilegeIds) {
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeId)));
				}
				role.setRole_privilege(set);
			}
			roleService.update(role);
		}
		return "list";
	}

	// 保存删除
	public String delete() {
		if(role != null && role.getRole_id() != null) {
			if(StringUtils.isNotBlank(role.getRole_name())) {
				// 查询条件回显
				strName = role.getRole_name();
			}
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

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}
	
}
