package com.tool;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
	public static StringBuffer conGet(String u) {
		StringBuffer conText = new StringBuffer();
		BufferedReader br = null;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(u);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

			String line = br.readLine();
			while (line != null) {
				conText.append(line);
				line = br.readLine();
			}
			connection.disconnect();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conText;
	}

	public static StringBuffer conPost(String u, String param) {
		StringBuffer conText = new StringBuffer();
		BufferedReader br = null;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(u);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");

			connection.setDoOutput(true);
			DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());
			dStream.writeBytes(param);
			dStream.close();

			br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

			String line = br.readLine();
			while (line != null) {
				conText.append(line);
				line = br.readLine();
			}
			connection.disconnect();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conText;
	}
}
