package org.toms.sample.json;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpClientTest {
	
	public static void noJsonConverter()  {
		HttpClient httpclient = new DefaultHttpClient(); 

		try {
			String url = "http://localhost:8080/nojson.do";
			String jsonStr = "asdfasdf";

			HttpPost httpost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("data", jsonStr));
			httpost.setEntity(new UrlEncodedFormEntity(nvps));

			httpost.setHeader("Content-type", "application/json; charset=utf-8");
			HttpResponse response = httpclient.execute(httpost);
			String responseBody = EntityUtils.toString(response.getEntity());
			responseBody = responseBody != null ? responseBody.replaceAll("\"", "\"") : "";
			System.out.println(responseBody);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	public static void withJsonConverter()  {
		HttpClient httpclient = new DefaultHttpClient(); 
		
		try {
			String url = "http://localhost:8080/withjson.do"; 
			String jsonStr = "{\"data\":\"data1111\"}";
			
			HttpPost httpost = new HttpPost(url); 

			httpost.setHeader("Content-type", "application/json; charset=utf-8"); 

			httpost.setEntity(new ByteArrayEntity(jsonStr.getBytes("UTF-8")));
			HttpResponse response = httpclient.execute(httpost); 
			String responseBody = EntityUtils.toString(response.getEntity()); 
			responseBody = responseBody!=null?responseBody.replaceAll("\"", "\""):""; 
			System.out.println(responseBody);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	public static void main(String[] args) throws Exception {
		 //noJsonConverter();
		 //
		 withJsonConverter();
	}
}
