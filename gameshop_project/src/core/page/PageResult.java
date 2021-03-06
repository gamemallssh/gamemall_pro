package core.page;

import java.util.List;

public class PageResult {

	// 总页数
	private int totalPageCount;
	// 总记录数
	private long totalCount;
	// 当前页
	private int pageNo;
	// 页大小
	private int pageSize;
	// 分页数据
	private List<Object> items;

	// 页大小常量
	public static int PAGE_SIZE = 5;

	public PageResult() {
	}

	public PageResult(long totalCount, int pageNo, int pageSize,
			List<Object> items) {
		this.totalCount = totalCount;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.items = items;
	}

	public int getTotalPageCount() {
		if (totalCount > 0) {
			totalPageCount = (int)((totalCount - 1) / pageSize + 1);
		} else {
			totalPageCount = 0;
		}
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	public static int getPAGE_SIZE() {
		return PAGE_SIZE;
	}

	public static void setPAGE_SIZE(int pAGE_SIZE) {
		PAGE_SIZE = pAGE_SIZE;
	}

}
