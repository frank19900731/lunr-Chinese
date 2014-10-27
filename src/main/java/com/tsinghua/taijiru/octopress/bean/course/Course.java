package com.tsinghua.taijiru.octopress.bean.course;

public class Course {

	public String pptname;
	public String pagenum;
	public String status;
	public String place;
	public String time;
	public String speaker;
	
	public Course() {
		this.pptname = "";
		this.pagenum = "";
		this.status = "";
		this.place = "";
		this.time = "";
		this.speaker = "";
	}
	
	public Course(String pptname, String pagenum, String status, String place,
			String time, String speaker) {
		this.pptname = pptname;
		this.pagenum = pagenum;
		this.status = status;
		this.place = place;
		this.time = time;
		this.speaker = speaker;
	}
	
	@Override
	public String toString() {
		return "Course [pptname=" + pptname + ", pagenum=" + pagenum
				+ ", status=" + status + ", place=" + place + ", time=" + time
				+ ", speaker=" + speaker + "]";
	}

	public String getPptname() {
		return pptname;
	}
	public void setPptname(String pptname) {
		this.pptname = pptname;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}	

}
