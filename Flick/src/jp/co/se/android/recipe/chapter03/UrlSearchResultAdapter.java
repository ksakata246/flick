package jp.co.se.android.recipe.chapter03;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

public class UrlSearchResultAdapter extends ArrayAdapter<UrlSearchResultVO> {
	
	private LayoutInflater layoutInflater;
	
	public UrlSearchResultAdapter(Context context, int resource, List<UrlSearchResultVO> usrAdapterList) {
		super(context, resource, usrAdapterList);
		//このへんの仕様調べる
		layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

}
