package com.tsinghua.taijiru.octopress.index;

import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;

import com.tsinghua.taijiru.octopress.bean.octopresspost.OctopressPost;

public class OctopressPostListTest extends TestCase {
	
	public void testOctopressPostList () throws IOException {
		JSONObject jsonObject = JSONObject.fromObject(FileUtils.readFileToString(new File("data/search.json"), "utf-8"));
		List<OctopressPost> octopressPostlist = (List<OctopressPost>) JSONArray.toCollection(jsonObject.getJSONArray("entries"), OctopressPost.class);
		for (OctopressPost octopressPost : octopressPostlist) {
			System.out.println(octopressPost.toString());
		}
	}

}
