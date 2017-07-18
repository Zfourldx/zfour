package com.ziroom.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class MessageUtil {
	public static String postWithResJson(String url,String param){
		return post(url, param, "application/x-www-form-urlencoded", "UTF-8",true, null);
		//application/x-www-form-urlencoded   application/json
	}
	
	private static String post(String strURL, String req, String contentType,
			String encode, boolean response, Map<String, String> headers) {

		String result = null;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		try {
			URL url = new URL(strURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", contentType);
			con.setRequestProperty("Comp-Control", "dsmp/sms-mt");
			/*if ((headers != null) && (headers.size() > 0)) {
				Set keys = headers.keySet();
				Iterator ir = keys.iterator();

				while (ir.hasNext()) {
					String key = (String) ir.next();
					con.setRequestProperty(key, (String) headers.get(key));
				}
			}*/
			con.setRequestProperty("abc", "inputXXX");
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setConnectTimeout(30000);
			con.setReadTimeout(30000);

			out = new BufferedOutputStream(con.getOutputStream());
			byte[] outBuf = req.getBytes(encode);
			out.write(outBuf);
			out.flush();
			if (response) {
				in = new BufferedInputStream(con.getInputStream());
				result = readByteStream(in, encode);
			} else {
				con.getInputStream();
			}
		} catch (Exception ex) {
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
			}
		}


		return result;
	}
	
	private static String readByteStream(BufferedInputStream in, String encode)
			throws IOException {
		LinkedList bufList = new LinkedList();
		int size = 0;
		while (true) {
			byte[] buf = new byte[128];
			int num = in.read(buf);
			if (num == -1)
				break;
			size += num;
			bufList.add(new mybuf(buf, num));
		}
		byte[] buf = new byte[size];
		int pos = 0;
		for (ListIterator p = bufList.listIterator(); p.hasNext();) {
			mybuf b = (mybuf) p.next();
			int i = 0;
			while (i < b.size) {
				buf[pos] = b.buf[i];
				++i;
				++pos;
			}
		}
		return new String(buf, encode);
	}
	
	private static class mybuf {
		public byte[] buf;
		public int size;

		public mybuf(byte[] b, int s) {
			this.buf = b;
			this.size = s;
		}
	}
}
