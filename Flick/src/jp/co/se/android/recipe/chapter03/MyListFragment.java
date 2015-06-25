package jp.co.se.android.recipe.chapter03;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

public class MyListFragment extends ListFragment {

	private boolean isFirst = false;
	private ArrayAdapter<UrlSearchResultVO> usrAdapter;

	public MyListFragment() {
	};

	// これを使ってやってみる
	public MyListFragment(ArrayAdapter<UrlSearchResultVO> adapter) {
		isFirst = true;
		this.usrAdapter = adapter;
	};

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (!isFirst) {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					getActivity(), android.R.layout.simple_list_item_1,
					MyList.Data);
			setListAdapter(adapter);
		} else {
			ArrayList<String> usrData = new ArrayList<String>();
			String[] data = new String[100];
			for (int i = 0; i < 10; i++) {
				String a = usrAdapter.getItem(i).getTitle();
				usrData.add(usrAdapter.getItem(i).getTitle());
				data[i] = a;
			}
			// ここを変える
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
					getActivity(), android.R.layout.simple_list_item_1,
					data);
			setListAdapter(adapter1);
		}
	}

}
