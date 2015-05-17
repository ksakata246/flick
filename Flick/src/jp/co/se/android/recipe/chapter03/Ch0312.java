package jp.co.se.android.recipe.chapter03;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

public class Ch0312 extends FragmentActivity implements OnQueryTextListener {

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ch0312_main);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		//ここのクラスで場合分けができる！
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
		Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
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
