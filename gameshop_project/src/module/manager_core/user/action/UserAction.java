package module.manager_core.user.action;

import java.io.File;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import module.manager_core.role.service.RoleService;
import module.manager_core.user.entity.User;
import module.manager_core.user.entity.UserRole;
import module.manager_core.user.service.UserService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.util.QueryHelper;

@SuppressWarnings("serial")
public class UserAction extends BaseAction {

	@Resource private UserService userService;
	@Resource private RoleService roleService;
	private List<User> userList;
	private User user;
	// 头像文件
	private File icon;
	private String iconFileName;
	private String iconContentType;
	// 用户角色ID列表
	private String[] userRoleIds;
	// 查询数据回显
	private String strName;
	
	// 列表页面
	public String listUI() {
		// 获取查询助手
		QueryHelper queryHelper = new QueryHelper(User.class,"u");
		try {
			if(user != null) {
				if(StringUtils.isNotBlank(user.getUser_name())) {
					user.setUser_name(URLDecoder.decode(user.getUser_name(),"UTF-8"));
					queryHelper.addCondition("u.user_name like ?", "%"+ user.getUser_name() +"%");
				}
			}
			// 获取分页结果对象
			pageResult = userService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}

	// 添加页面
	public String addUI() {
		// 加载角色列表
		ActionContext.getContext().getContextMap().put("roleList", roleService.findObjects());
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
				userService.saveUserAndRole(user, userRoleIds);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// 编辑页面
	public String editUI() {
		ActionContext.getContext().getContextMap().put("roleList", roleService.findObjects());
		if(user != null && user.getUser_id() != null) {
			if(StringUtils.isNotBlank(user.getUser_name())) {
				// 保存查询数据
				strName = user.getUser_name();
			}
			user = userService.findObjectById(user.getUser_id());
			// 角色回显
			List<UserRole> list = userService.getUserRolesByUserId(user.getUser_id());
			if(list != null && list.size() > 0) {
				userRoleIds = new String[list.size()];
				int i = 0;
				for(UserRole ur : list) {
					userRoleIds[i++] = ur.getUserrole_id().getRole().getRole_id();
				}
			}
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
						String old_fileName = user.getUser_icon();
						File old_file = new File(filePath, old_fileName);
						if(old_file.exists()) {
							FileUtils.forceDelete(old_file);
						}
					}
					// 设置头像属性
					user.setUser_icon(fileName);
				}
				userService.updateUserAndRole(user, userRoleIds);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// 保存删除
	public String delete() {
		if(user != null && user.getUser_id() != null) {
			if(StringUtils.isNotBlank(user.getUser_name())) {
				// 保存查询数据
				strName = user.getUser_name();
			}
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

	public void verifyAccount() {
		try {
			if(user != null && StringUtils.isNotBlank(user.getUser_account())) {
				String resultStr = "true";
				// 账号一样并且ID不同，则命名重复
				List<User> list = userService.findUserByAccountAndId(user.getUser_id(), user.getUser_account());
				
				// 说明该账号已存在
				if(list != null && list.size() > 0) {
					resultStr = "false";
				}
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(resultStr.getBytes());
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

}
