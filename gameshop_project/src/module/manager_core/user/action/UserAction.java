package module.manager_core.user.action;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import module.manager_core.role.entity.Role;
import module.manager_core.role.service.RoleService;
import module.manager_core.user.entity.User;
import module.manager_core.user.service.UserService;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import core.action.BaseAction;

@SuppressWarnings("serial")
public class UserAction extends BaseAction {

	@Resource private UserService userService;
	@Resource private RoleService roleService;
	private List<User> userList;
	private List<Role> roleList;
	private User user;
	// 头像文件
	private File icon;
	private String iconFileName;
	private String iconContentType;
	// 用户角色ID列表
	private String[] userRoleIds;
	
	// 列表页面
	public String listUI() {
		userList = userService.findObjects();
		return "listUI";
	}

	// 添加页面
	public String addUI() {
		//roleList = roleService.findObjects();
		return "addUI";
	}

	// 保存添加
	public String add() {
		try {
			if(user != null) {
				if(icon != null) {
					// 设置头像保存路径及命名
					String filePath = ServletActionContext.getServletContext().getRealPath("/upload/user");
					String fileName = UUID.randomUUID().toString().replaceAll("-", "")
							+iconFileName.substring(iconFileName.lastIndexOf("."));
					// 复制保存头像文件
					FileUtils.copyFile(icon, new File(filePath, fileName));
					
					// 设置头像属性
					user.setUser_icon(fileName);
				}
				userService.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// 编辑页面
	public String editUI() {
		if(user != null && user.getUser_id() != null) {
			user = userService.findObjectById(user.getUser_id());
		}
		return "editUI";
	}

	// 保存编辑
	public String edit() {
		try {
			if(user != null) {
				if(icon != null) {
					String filePath = ServletActionContext.getServletContext().getRealPath("/upload/user");
					String fileName = UUID.randomUUID().toString().replaceAll("-", "")
							+iconFileName.substring(iconFileName.lastIndexOf("."));
					// 复制文件
					FileUtils.copyFile(icon, new File(filePath, fileName));
					// 清除原先头像
					if(user.getUser_icon() != null) {
						File old_file = new File(user.getUser_icon());
						if(old_file.exists()) {
							FileUtils.forceDelete(old_file);
						}
					}
					// 设置头像属性
					user.setUser_icon(fileName);
				}
				userService.update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// 保存删除
	public String delete() {
		if(user != null && user.getUser_id() != null) {
			userService.delete(user.getUser_id());
		}
		return "list";
	}

	// 批量删除
	public String deleteSelected() {
		if(selectedRow != null && selectedRow.length > 0) {
			for(String id : selectedRow) {
				userService.delete(id);
			}
		}
		return "list";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getIcon() {
		return icon;
	}

	public void setIcon(File icon) {
		this.icon = icon;
	}

	public String getIconFileName() {
		return iconFileName;
	}

	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}

	public String getIconContentType() {
		return iconContentType;
	}

	public void setIconContentType(String iconContentType) {
		this.iconContentType = iconContentType;
	}

	public String[] getUserRoleIds() {
		return userRoleIds;
	}

	public void setUserRoleIds(String[] userRoleIds) {
		this.userRoleIds = userRoleIds;
	}

}
