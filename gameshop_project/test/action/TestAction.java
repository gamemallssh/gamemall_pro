package action;

import javax.annotation.Resource;

import service.TestService;

import com.opensymphony.xwork2.ActionSupport;

import entity.TestEntity;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {

	private TestEntity testEntity;
	@Resource private TestService testService;
	
	private TestEntity te;

	@Override
	public String execute() throws Exception {
		testService.save(testEntity);
		return "success";
	}
	
	public String list() {
		te = testService.findObjectById("3234565");
		return "success";
	}

	public TestEntity getTestEntity() {
		return testEntity;
	}

	public void setTestEntity(TestEntity testEntity) {
		this.testEntity = testEntity;
	}

	public TestEntity getTe() {
		return te;
	}

	public void setTe(TestEntity te) {
		this.te = te;
	}

}
