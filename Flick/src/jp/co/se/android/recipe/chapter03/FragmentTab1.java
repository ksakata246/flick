package jp.co.se.android.recipe.chapter03;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class FragmentTab1 extends Fragment {

	public FragmentTab1(){
		super();
	}
	
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
	 * 
	 * @see android.support.v4.app.Fragment#onStart() source :
	 * http://qiita.com/dmnlk/items/a1d3fc2094e02841cbeb
	 */
	@Override
	public void onStart() {
		super.onStart();

		List<UrlSearchResultVO> usrVOList = new ArrayList<UrlSearchResultVO>();
		UrlSearchResultAdapter usrAdapter = new UrlSearchResultAdapter(getActivity(), 0, usrVOList);
		//ここの引数はいらない
		changeRusultData(usrAdapter);
	}

	// 初期データをここでセットする
	public void changeRusultData(ArrayAdapter<UrlSearchResultVO> adapter) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.list_container, new MyListFragment()).commit();
	}
}
