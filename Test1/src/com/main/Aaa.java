package com.main;

import com.tool.HttpRequest;

public class Aaa {

	// 用户 key (登陆账号的云栖学院可查)
	public static String keyString = "19E32DA4B73F691ECBE49B7C2C048007";
	// 章节
	public static int cId = 8;
	// 题目行
	public static int chapterIds = 59;
	// 章节名称
	public static String title = "使用LayUI开发权限管理";

	/**
	 * 获取问题
	 * 
	 * @return 返回JSON字符串
	 */
	public static String getQ() {
		String u = "https://api.ysdjypt.com/StuAPI/BrushExercise";
		String param = String.format("cId=%s&chapterIds=%s&title=%s&key=%s", cId, chapterIds, title, keyString);
		String string = HttpRequest.conPost(u, param).toString();
		return string;
	}

	/**
	 * 获取答案
	 * 
	 * @return 返回答案JSON字符串
	 */
	public static String getAn(int bEId) {
		String u = "https://api.ysdjypt.com/StuAPI/AnalysisBrushExercise";
		String param = String.format("bEId=%s&eCount=&key=%s", bEId, keyString);
		String string = HttpRequest.conPost(u, param).toString();
		return string;
	}

	/**
	 * 提交答案
	 * 
	 * @param bEId    当前题的ID
	 * @param jsonStr 当前题的答案
	 * @return
	 */
	public static String requestAn(int bEId, String jsonStr) {
		String u = "https://api.ysdjypt.com/StuAPI/SubBrushExerciseAnswer";
		String param = String.format("bEId=%s&jsonStr=%s&key=%s", bEId, jsonStr, keyString);
		String string = HttpRequest.conPost(u, param).toString();
		return string;
	}
}
