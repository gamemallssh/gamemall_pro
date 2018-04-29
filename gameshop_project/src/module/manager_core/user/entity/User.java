package module.manager_core.user.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String user_id;
	private String user_name;
	private String user_account; // 账号
	private String user_password; // 密码
	private boolean user_gender;
	private String user_phone;
	private String user_email;
	private String user_address;
	private String user_idcard;
	private String user_icon; // 头像

	public User() {
	}

	public User(String user_id, String user_name, String user_account,
			String user_password, boolean user_gender, String user_phone,
			String user_email, String user_address, String user_idcard,
			String user_icon) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_account = user_account;
		this.user_password = user_password;
		this.user_gender = user_gender;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_address = user_address;
		this.user_idcard = user_idcard;
		this.user_icon = user_icon;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public boolean isUser_gender() {
		return user_gender;
	}

	public void setUser_gender(boolean user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_idcard() {
		return user_idcard;
	}

	public void setUser_idcard(String user_idcard) {
		this.user_idcard = user_idcard;
	}

	public String getUser_icon() {
		return user_icon;
	}

	public void setUser_icon(String user_icon) {
		this.user_icon = user_icon;
	}

}
