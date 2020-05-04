package com.main;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.Answers;

public class Text1 {

	public static int BEId;

	public static void main(String[] args) {
		// Sua方法是刷题主要方法,一次执行一次刷题,可以用for循环控制次数
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			Sua(i + 1);
		}
	}

	public static void Sua(int suaCi) {
		JSONObject getQ = JSONObject.parseObject(Aaa.getQ());
		// System.out.println(getQ.toString());
		JSONObject Datas = getQ.getJSONObject("Data");
		BEId = Datas.getIntValue("BEId");
		JSONArray getAnDatas = JSONObject.parseObject(Aaa.getAn(BEId)).getJSONArray("Data");
		// System.out.println(getAnDatas);
		JSONArray ChoiceLists = Datas.getJSONArray("ChoiceList");
		List<Answers> answerss = new ArrayList<Answers>();
		for (int i = 0; i < ChoiceLists.size(); i++) {
			JSONObject ChoiceList = ChoiceLists.getJSONObject(i);
			JSONObject getAnData = getAnDatas.getJSONObject(i);

			Answers answers = new Answers();
			answers.TId = ChoiceList.getIntValue("TId");
			answers.Answer = getAnData.getString("Answer");
			answers.Ty = ChoiceList.getIntValue("Ty");
			answerss.add(answers);
		}
		// System.out.println(JSON.toJSONString(answerss));
		String requestAn = Aaa.requestAn(BEId, JSON.toJSONString(answerss));
		System.out.println("本次得分:" + JSON.parseObject(requestAn).getString("RightRate") + ",这是第几次:" + suaCi);
	}
}
