package jp.co.se.android.recipe.chapter03;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MyListFragment extends ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, MyList.Data);
		setListAdapter(adapter);
	}

}
