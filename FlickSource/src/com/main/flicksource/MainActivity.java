package com.main.flicksource;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	// 遷移用のボタン
	private Button button;
	private Button button1;
	private Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		button = (Button) findViewById(R.id.button_in_fragment_main);
		button.setOnClickListener(this);

		button1 = (Button) findViewById(R.id.button_for_tinder);
		button1.setOnClickListener(this);
		
		button2 = (Button) findViewById(R.id.button_for_http);
		button2.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_in_fragment_main:
			// ボタン押すとFlickテスト用の画面に遷移する
			Intent intent = new Intent(getApplication(),
					FlickSampleActivity.class);
			startActivity(intent);
			break;
		case R.id.button_for_tinder:
			// ボタン押すとTinderテスト用の画面に遷移する
			Intent intent2 = new Intent(getApplication(),
					TinderSampleActivity.class);
			startActivity(intent2);
			break;
		case R.id.button_for_http:
		// ボタン押すとTinderテスト用の画面に遷移する
		Intent intent3 = new Intent(getApplication(),
				HttpSampleActivity.class);
		startActivity(intent3);
		break;
		}
	}

}
