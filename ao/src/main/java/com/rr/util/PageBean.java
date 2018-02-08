package com.rr.util;

import java.util.List;

public class PageBean<T> {

	private long currentPage;
	private long totalNum;
	private long totalPage;
	private long pageSize = 4;
	private List<T> pageInfo;
	
	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	public long getTotalPage() {
		
		if(totalNum % pageSize == 0){
			totalPage = totalNum / pageSize;
		}else{
			totalPage = totalNum / pageSize + 1;
		}
		
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(List<T> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}
