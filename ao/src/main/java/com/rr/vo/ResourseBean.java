package com.rr.vo;

public class ResourseBean {
	private Integer resid;
	private String resname;
	private String url;
	
	public ResourseBean(){};
	
	public ResourseBean(Integer resid, String resname, String url){
		this.resid = resid;
		this.resname = resname;
		this.url = url;
	}

	public Integer getResid() {
		return resid;
	}

	public void setResid(Integer resid) {
		this.resid = resid;
	}

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
