package core.action;

import com.opensymphony.xwork2.ActionSupport;

import core.page.PageResult;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {

	/* 分页 */
	private int pageNo; // 当前页
	private int pageSize; // 页大小
	protected PageResult pageResult; // 分页结果集

	// 多选框
	protected String[] selectedRow;

	public int getPageNo() {
		if (pageNo < 1) {
			pageNo = 1;
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		if (pageSize < 1) pageSize = PageResult.PAGE_SIZE;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

}
