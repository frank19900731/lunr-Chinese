package com.tsinghua.taijiru.octopress.bean.octopresspost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jeasy.analysis.MMAnalyzer;

public class OctopressPost {

	public static MMAnalyzer mmAnalyzer = new MMAnalyzer();
	public String title;
	public String url;
	public String date;
	public String body;
	public List<String> categories;
	
	public OctopressPost () {
		this.title = "";
		this.url = "";
		this.date = "";
		this.body = "";
		this.categories = new ArrayList<String>();
	}

	public OctopressPost(String title, String url, String date, String body,
			List<String> categories) {
		super();
		this.title = title;
		this.url = url;
		this.date = date;
		this.body = body;
		this.categories = categories;
	}
	
	public void parse() throws IOException {
//		this.title = parseString(this.title);
		this.body = parseString(this.title + " " + this.body);
	}
	
	public static String parseString(String str) throws IOException {
		return mmAnalyzer.segment(str, " ");
	}

	@Override
	public String toString() {
		return "OctopressPost [title=" + title + "\n url=" + url + "\n date="
				+ date + "\n body=" + body + "\n categories=" + categories + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
