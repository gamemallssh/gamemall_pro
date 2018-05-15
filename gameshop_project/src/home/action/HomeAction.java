package home.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HomeAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "home";
	}
}
