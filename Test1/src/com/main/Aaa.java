package com.main;

import com.tool.HttpRequest;

public class Aaa {

	// �û� key (��½�˺ŵ�����ѧԺ�ɲ�)
	public static String keyString = "19E32DA4B73F691ECBE49B7C2C048007";
	// �½�
	public static int cId = 8;
	// ��Ŀ��
	public static int chapterIds = 59;
	// �½�����
	public static String title = "ʹ��LayUI����Ȩ�޹���";

	/**
	 * ��ȡ����
	 * 
	 * @return ����JSON�ַ���
	 */
	public static String getQ() {
		String u = "https://api.ysdjypt.com/StuAPI/BrushExercise";
		String param = String.format("cId=%s&chapterIds=%s&title=%s&key=%s", cId, chapterIds, title, keyString);
		String string = HttpRequest.conPost(u, param).toString();
		return string;
	}

	/**
	 * ��ȡ��
	 * 
	 * @return ���ش�JSON�ַ���
	 */
	public static String getAn(int bEId) {
		String u = "https://api.ysdjypt.com/StuAPI/AnalysisBrushExercise";
		String param = String.format("bEId=%s&eCount=&key=%s", bEId, keyString);
		String string = HttpRequest.conPost(u, param).toString();
		return string;
	}

	/**
	 * �ύ��
	 * 
	 * @param bEId    ��ǰ���ID
	 * @param jsonStr ��ǰ��Ĵ�
	 * @return
	 */
	public static String requestAn(int bEId, String jsonStr) {
		String u = "https://api.ysdjypt.com/StuAPI/SubBrushExerciseAnswer";
		String param = String.format("bEId=%s&jsonStr=%s&key=%s", bEId, jsonStr, keyString);
		String string = HttpRequest.conPost(u, param).toString();
		return string;
	}
}
