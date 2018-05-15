package module.manager_core.home.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HomeAction extends ActionSupport {

	public String frame() {
		return "frame";
	}

	public String top() {
		return "top";
	}

	public String left() {
		return "left";
	}

}
