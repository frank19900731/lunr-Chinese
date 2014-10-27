package com.tsinghua.taijiru.octopress.index;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;

import com.tsinghua.taijiru.octopress.bean.course.Course;
import com.tsinghua.taijiru.octopress.bean.course.CourseList;

public class CourseListTest extends TestCase {

	public void testCourseList1 () throws IOException {
		JSONObject jsonObject = JSONObject.fromObject(FileUtils.readFileToString(new File("data/k2.json"), "utf-8"));
		HashMap<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("courselist", Course.class);
		CourseList courseList = (CourseList) JSONObject.toBean(jsonObject, CourseList.class, classMap);
		
		for (Course course : courseList.getCourselist()) {
			System.out.println(course.toString());
		}
	}
	
	public void testCourseList2 () throws IOException {
		JSONObject jsonObject = JSONObject.fromObject(FileUtils.readFileToString(new File("data/k2.json"), "utf-8"));
		List<Course> courselist = (List<Course>) JSONArray.toCollection(jsonObject.getJSONArray("courselist"), Course.class);
		for (Course course : courselist) {
			System.out.println(course.toString());
		}
	}

}
