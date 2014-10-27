package com.tsinghua.taijiru.octopress.index;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;

import com.tsinghua.taijiru.octopress.bean.octopresspost.OctopressPost;


public class OctopressIndexBuilder {
	
	public static void parseWords (String workDir, String fileStr) throws IOException {
		String[] files = fileStr.split(";");
		for (String jsonFile : files) {
			String absolutePath = workDir + jsonFile;
			System.out.println("Start : " + absolutePath);
			File file = new File(absolutePath);
			if (!file.exists()) {
				System.out.println("Warning : " + absolutePath + " doesn't exist.");
				System.out.println("Done : " + absolutePath);
				continue;
			}
			JSONObject jsonObject = JSONObject.fromObject(FileUtils.readFileToString(file, "utf-8"));
			List<OctopressPost> octopressPostlist = (List<OctopressPost>) JSONArray.toCollection(jsonObject.getJSONArray("entries"), OctopressPost.class);
			for (OctopressPost octopressPost : octopressPostlist) {
				octopressPost.parse();
			}
			JSONArray result = JSONArray.fromObject(octopressPostlist);
			JSONObject newObject = new JSONObject();
			newObject.put("entries", result.toString());
			
			FileUtils.writeStringToFile(new File(jsonFile), newObject.toString(), "utf-8");
			System.out.println("Done : " + absolutePath);
		}
	}
	
	public static void loadDict(String dicPath) throws IOException {
		File dict = new File(dicPath);
		if (!dict.exists()) {
			System.out.println("Couldn't find the dictionary file you specified.");
			return;
		}
		List<String> wordList = (List<String>) FileUtils.readLines(dict, "utf-8");
		for (String word : wordList) {
			OctopressPost.mmAnalyzer.addWord(word);
		}
		System.out.println("Done : " + dicPath);
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length == 2) {
			parseWords(args[0], args[1]);
		} else if (args.length == 3) {
			loadDict(args[2]);
			parseWords(args[0], args[1]);
		} else {
			System.out.println("Usage: OctopressIndexBuilder workDir jsonFilestoParse [dicPath]");
			System.out.println("Example: OctopressIndexBuilder /User/XXX/home/ file1.json;file2.json dict.txt");
			return;
		}
	}

}
