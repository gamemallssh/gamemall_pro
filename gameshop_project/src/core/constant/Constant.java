package core.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {

	// 系统用户标识符
	public static String USER = "SYS_USER";
	
	// 系统权限常量
	public static String PRIVILEGE_MALL = "mall";
	public static String PRIVILEGE_MCORE = "mcore";
	public static String PRIVILEGE_MMALL = "mmall";
	public static String PRIVILEGE_EXZONE = "exzone";
	public static String PRIVILEGE_NEWS = "news";
	public static String PRIVILEGE_SPACE = "space";

	public static Map<String, String> PRIVILEGE_MAP;
	static {
		PRIVILEGE_MAP = new HashMap<String, String>();
		PRIVILEGE_MAP.put(PRIVILEGE_MALL, "商城");
		PRIVILEGE_MAP.put(PRIVILEGE_MCORE, "信息管理");
		PRIVILEGE_MAP.put(PRIVILEGE_MMALL, "商城管理");
		PRIVILEGE_MAP.put(PRIVILEGE_EXZONE, "体验区");
		PRIVILEGE_MAP.put(PRIVILEGE_NEWS, "新闻");
		PRIVILEGE_MAP.put(PRIVILEGE_SPACE, "我的空间");
	}

}
