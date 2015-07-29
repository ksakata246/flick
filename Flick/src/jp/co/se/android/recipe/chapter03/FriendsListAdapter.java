package jp.co.se.android.recipe.chapter03;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

public class FriendsListAdapter extends ArrayAdapter<FriendVOTest> {
	
	private LayoutInflater layoutInflater;
	
	public FriendsListAdapter(Context context, int resource, List<FriendVOTest> friendsAdapterList) {
		super(context, resource, friendsAdapterList);
		// TODO このへんの仕様調べる
		layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

}
