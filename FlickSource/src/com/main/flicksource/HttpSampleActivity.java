package com.main.flicksource;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

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
		AsyncCl aul = new AsyncCl(this);
		aul.execute();
	}

	class AsyncCl extends AsyncTask<String, Void, String> {
		private HttpClient hClient;
		private HttpGet hGetMethod;
		private HttpSampleActivity mainActivity;

		public AsyncCl(HttpSampleActivity httpSampleActivity) {
			mainActivity = httpSampleActivity;
			hClient = new DefaultHttpClient();
			hGetMethod = new HttpGet();
		}

		@Override
		protected String doInBackground(String... params) {
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
		}
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			TextView textSetting = (TextView) findViewById(R.id.http_text);
			textSetting.setText(textForHttp);
		}
	}
}
