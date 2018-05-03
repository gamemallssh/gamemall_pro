package module.manager_core.info.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Info implements Serializable {

	private String info_id;
	private String info_type;
	private String info_title;
	private String info_content;
	private String info_memo;
	private String info_creator;
	private Timestamp info_create_time;
	private String info_state;

	// 状态
	public static String INFO_STATE_PUBLIC = "1";
	public static String INFO_STATE_STOP = "0";

	// 信息分类
	public static String INFO_TYPE_TZGG = "tzgg";
	public static String INFO_TYPE_FLFS = "flfs";
	public static String INFO_TYPE_XTWH = "xtwh";
	public static Map<String, String> INFO_TYPE_MAP;
	static {
		INFO_TYPE_MAP = new HashMap<String, String>();
		INFO_TYPE_MAP.put(INFO_TYPE_TZGG, "通知公告");
		INFO_TYPE_MAP.put(INFO_TYPE_FLFS, "福利放送");
		INFO_TYPE_MAP.put(INFO_TYPE_XTWH, "系统维护");
	}

	public Info() {
	}

	public Info(String info_id, String info_type, String info_title,
			String info_content, String info_memo, String info_creator,
			Timestamp info_create_time, String info_state) {
		super();
		this.info_id = info_id;
		this.info_type = info_type;
		this.info_title = info_title;
		this.info_content = info_content;
		this.info_memo = info_memo;
		this.info_creator = info_creator;
		this.info_create_time = info_create_time;
		this.info_state = info_state;
	}

	public String getInfo_id() {
		return info_id;
	}

	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}

	public String getInfo_type() {
		return info_type;
	}

	public void setInfo_type(String info_type) {
		this.info_type = info_type;
	}

	public String getInfo_title() {
		return info_title;
	}

	public void setInfo_title(String info_title) {
		this.info_title = info_title;
	}

	public String getInfo_content() {
		return info_content;
	}

	public void setInfo_content(String info_content) {
		this.info_content = info_content;
	}

	public String getInfo_memo() {
		return info_memo;
	}

	public void setInfo_memo(String info_memo) {
		this.info_memo = info_memo;
	}

	public String getInfo_creator() {
		return info_creator;
	}

	public void setInfo_creator(String info_creator) {
		this.info_creator = info_creator;
	}

	public Timestamp getInfo_create_time() {
		return info_create_time;
	}

	public void setInfo_create_time(Timestamp info_create_time) {
		this.info_create_time = info_create_time;
	}

	public String getInfo_state() {
		return info_state;
	}

	public void setInfo_state(String info_state) {
		this.info_state = info_state;
	}

}
