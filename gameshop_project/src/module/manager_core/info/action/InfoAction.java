package module.manager_core.info.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import module.manager_core.info.entity.Info;
import module.manager_core.info.service.InfoService;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.util.QueryHelper;

@SuppressWarnings("serial")
public class InfoAction extends BaseAction {

	@Resource
	private InfoService infoService;
	private Info info;
	// 异步返回结果
	private String resultStr;
	// 查询数据回显
	private String strTitle;
	
	// 列表页面
	public String listUI() {
		// 加载信息分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		// 获取查询助手
		QueryHelper queryHelper = new QueryHelper(Info.class, "i");
		try {
			// 获取查询条件
			if(info != null) {
				if(StringUtils.isNotBlank(info.getInfo_title())) {
					// 对查询条件解码
					info.setInfo_title(URLDecoder.decode(info.getInfo_title(), "UTF-8"));
					queryHelper.addCondition("i.info_title like ?", "%"+ info.getInfo_title() +"%");
				}
			}
			// 对查询结果进行排序
			queryHelper.addOrderByProperty("i.info_create_time", QueryHelper.ORDER_BY_DESC);
			// 获取分页结果对象
			pageResult = infoService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	
	// 添加页面
	public String addUI() {
		// 加载信息分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		// 设置当前时间为信息创建时间
		info = new Info();
		info.setInfo_create_time(new Timestamp(new Date().getTime()));
		return "addUI";
	}

	// 保存添加
	public String add() {
		if(info != null) {
			infoService.save(info);
		}
		return "list";
	}

	// 编辑页面
	public String editUI() {
		// 加载权限map
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		if(info != null && StringUtils.isNotBlank(info.getInfo_id())) {
			if(StringUtils.isNotBlank(info.getInfo_title())) {
				// 保存查询数据
				strTitle = info.getInfo_title();
			}
			info = infoService.findObjectById(info.getInfo_id());
		}
		return "editUI";
	}

	// 保存编辑
	public String edit() {
		if(info != null) {
			infoService.update(info);
		}
		return "list";
	}

	// 保存删除
	public String delete() {
		if(info != null && info.getInfo_id() != null) {
			if(StringUtils.isNotBlank(info.getInfo_title())) {
				// 保存查询数据
				strTitle = info.getInfo_title();
			}
			infoService.delete(info.getInfo_id());
		}
		return "list";
	}

	// 批量删除
	public String deleteSelected() {
		if(selectedRow != null && selectedRow.length > 0) {
			for(String id : selectedRow) {
				infoService.delete(id);
			}
		}
		return "list";
	}
	
	// 异步信息发布
	public String publicInfo() {
		if(info != null) {
			Info temp = infoService.findObjectById(info.getInfo_id());
			// 更新信息状态
			temp.setInfo_state(info.getInfo_state());
			infoService.update(temp);
			// 输出更新结果
			resultStr = "更新状态成功";
		}
		return "publicResult";
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

}
