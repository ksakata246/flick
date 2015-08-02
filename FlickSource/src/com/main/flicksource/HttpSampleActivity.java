package com.main.flicksource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.main.flicksource.FlickSampleActivity.FlickTouchListener;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class HttpSampleActivity extends Activity {

	private String textForHttp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http_test);

		asyncDoGet();

	}

	private void asyncDoGet() {
		AsyncCl aul = new AsyncCl(this, "GET");
		aul.execute();
	}

	class AsyncCl extends AsyncTask<String, Void, String> {
		private HttpClient hClient;
		private HttpGet hGetMethod;
		private HttpPost hPostMethod;
		private HttpSampleActivity mainActivity;
		private FlickTouchListener fTouchListener;
		private String httpMethod;

		public AsyncCl(HttpSampleActivity httpSampleActivity, String string) {
			mainActivity = httpSampleActivity;
			hClient = new DefaultHttpClient();
			hGetMethod = new HttpGet();
			httpMethod = string;
		}

		public AsyncCl(FlickTouchListener flickTouchListener, String string) {
			fTouchListener = flickTouchListener;
			hClient = new DefaultHttpClient();
			hPostMethod = new HttpPost();
			httpMethod = string;
		}

		@Override
		protected String doInBackground(String... params) {
			switch (httpMethod) {
			case "GET":
				hGetMethod = new HttpGet(
						"http://52.8.212.125:3000/pull?userid=hoge&lng=136.34&lat=134.22");
				hGetMethod.setHeader("Content-Type",
						"application/json; charset=utf-8");
				HttpResponse httpResponse = null;
				try {
					httpResponse = hClient.execute(hGetMethod);
				} catch (IOException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
				try {
					// レスポンスデータをjsonオブジェクトへ変換する
					JSONObject json = new JSONObject(EntityUtils.toString(
							httpResponse.getEntity(), "UTF-8"));
					textForHttp = json.getString("data");
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				return null;
			case "POST":
				HttpClient hClient = new DefaultHttpClient();
				HttpPost postMethod = new HttpPost(
						"http://52.8.212.125:3000/flick");
				postMethod.setHeader("Content-Type",
						"application/json; charset=utf-8");
				
				StringBuilder builder = new StringBuilder();
				builder.append("{\"jsondata\":{\"userid\":\"fuga\",\"location\":[136.34,134.22],\"data\":\"dddddddata\"}}");
				HttpResponse res = null;
				try {
					postMethod.setEntity(new StringEntity(builder.toString()));
					try {
						res = hClient.execute(postMethod);
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					
				} catch (UnsupportedEncodingException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			switch (httpMethod) {
			case "GET":
				super.onPostExecute(result);
				TextView textSetting = (TextView) findViewById(R.id.http_text);
				textSetting.setText(textForHttp);
			case "POST":
				Log.v("POST","success");
			}
		}
	}
}
