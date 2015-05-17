package jp.co.se.android.recipe.chapter03;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTab1 extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.list_view, container, false);
		return v;
	}
	/*
	 * (非 Javadoc)
	 * @see android.support.v4.app.Fragment#onStart()
	 * source : http://qiita.com/dmnlk/items/a1d3fc2094e02841cbeb
	 */
	@Override
	public void onStart(){
		super.onStart();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.list_container, new MyListFragment()).commit();
	}

}
