package jp.co.se.android.recipe.chapter03;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class Ch0312 extends FragmentActivity implements OnQueryTextListener {

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ch0312_main);
		adjustTab();
	}

	private void adjustTab() {
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		// ここのクラスで場合分けができる！
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Tab1", null),
				FragmentTab1.class, null);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
				FragmentTab2.class, null);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.action_bar_menu, menu);

		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
				.getActionView();

		searchView.setOnQueryTextListener(this);

		return super.onCreateOptionsMenu(menu);
	}

	/*
	 * クエリ文字列がsubmitされたタイミングで呼ばれる
	 * 
	 * @see
	 * android.widget.SearchView.OnQueryTextListener#onQueryTextSubmit(java.
	 * lang.String)
	 */
	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO ひとまず実装 入力されたクエリ文字列をトースト表示しておく
		// Toast.makeText(this, query, Toast.LENGTH_SHORT).show();

		// HttpResponse生成
		HttpResponse httpResponse = null;
		// memo Thread のポリシーに、どの操作を違反とし、違反があったときに何をするかを定義する
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.permitAll().build());

		// 検索の実装(URL定義)
		// String html =
		// "https://www.google.co.jp/?gfe_rd=cr&ei=XMhbVauEF4jN8gfgjoCABw#q=";
		String html = "https://www.googleapis.com/customsearch/v1?key=AIzaSyBB_DJ_Q7MWEyxyGRC_uJDEvy3yxysUlPU&cx=006313022508619145881:gboz0irl5wq&q=";

		// URL生成
		try {
			// UTF-8エンコード対応
			html += URLEncoder.encode(query, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Ecxeption対応
			e1.printStackTrace();
		}

		HttpUriRequest httpGet = new HttpGet(html);
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

		try {
			httpResponse = defaultHttpClient.execute(httpGet);

		} catch (Exception e) {
			// TODO Log実装
			Log.e("HttpResponse", "Error Execute");
		}

		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			try {
				// レスポンスデータをjsonオブジェクトへ変換する
				JSONObject json = new JSONObject(
						EntityUtils.toString(httpResponse.getEntity()));
				// jsonオブジェクトを配列とする
				JSONArray jsonArray = json.getJSONArray("items");

				// DefaultHttpClient shutdown
				defaultHttpClient.getConnectionManager().shutdown();
				// Custom Class list creates to store the feed data
				List<UrlSearchResultVO> usrVOList = new ArrayList<UrlSearchResultVO>();

				// 後で消す
				// なんか10件くらいしか表示されない
				String test = String.valueOf(jsonArray.length());
				Log.v("jsonlength", test);

				for (int i = 0; i < jsonArray.length(); ++i) {
					// jsonarray から JSONObjectを配列の長さ分取得する
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					UrlSearchResultVO usrVO = new UrlSearchResultVO();
					try {
						// URL of mobile gets from JSONObject
						usrVO.setDisplayLink(jsonObject
								.getString("displayLink"));
						usrVO.setHtmlFormattedUrl(jsonObject
								.getString("htmlFormattedUrl"));
						usrVO.setTitle(jsonObject.getString("title"));
						usrVO.setCacheId(jsonObject.getString("cacheId"));
						usrVO.setFormattedUrl(jsonObject
								.getString("formattedUrl"));
						usrVO.setLink(jsonObject.getString("link"));
						usrVO.setHtmlTitle(jsonObject.getString("htmlTitle"));
						usrVO.setSnippet(jsonObject.getString("snippet"));
						usrVO.setHtmlSnippet(jsonObject
								.getString("htmlSnippet"));
						usrVO.setKind(jsonObject.getString("kind"));
					} catch (JSONException e) {
						Log.v("JSONObject", "failed");
					}
					// ListView at the made object added
					usrVOList.add(usrVO);
				}

				// ここでAdapter作って毎回リストに入れた方がいい。
				UrlSearchResultAdapter usrAdapter = new UrlSearchResultAdapter(this, 0, usrVOList);
				// インスタンス作成→ここがからっぽだからnullになってる
				android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction ft = fragmentManager.beginTransaction();
				MyListFragment m = new MyListFragment(usrAdapter);
				ft.replace(R.id.list_container, m).commit();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	/*
	 * クエリ文字列が変更されたタイミングで呼ばれる
	 * 
	 * @see
	 * android.widget.SearchView.OnQueryTextListener#onQueryTextChange(java.
	 * lang.String)
	 */
	@Override
	public boolean onQueryTextChange(String newText) {
		return false;
	}

}
