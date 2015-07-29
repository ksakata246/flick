package jp.co.se.android.recipe.chapter03;

import java.util.ArrayList;
import java.util.List;

import jp.co.se.android.recipe.model.ModelFactory;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

public class MyFriendsListFragment extends ListFragment {

	private ArrayAdapter<FriendVOTest> friendsAdapter;

	private FragmentActivity mActivity;
	
	public MyFriendsListFragment() {
		this.friendsAdapter = createFriendsAdapter();

	};

	public MyFriendsListFragment(FragmentActivity activity) {
		this.mActivity = activity;	
		this.friendsAdapter = createFriendsAdapter();
	}

	private ArrayAdapter<FriendVOTest> createFriendsAdapter() {

		List<FriendVO> friendVOList = new ArrayList<FriendVO>();
		List<FriendVOTest> friendVOLists = new ArrayList<FriendVOTest>();

		//friendVOList = createFriendsList();
		friendVOLists = createFriendsList();

		//第一引数がnullでおちてる
		FriendsListAdapter friendsListAdapter = new FriendsListAdapter(mActivity, 0, friendVOLists);
		return friendsListAdapter;
	}

	private List<FriendVOTest> createFriendsList() {
		// 本来はDB経由だが、暫定的に作成したものを利用。
		try {
			List<FriendVO> friends = new ArrayList<FriendVO>();
			List<FriendVOTest> friendstest = new ArrayList<FriendVOTest>();
			friendstest.add(new FriendVOTest("a"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			friendstest.add(new FriendVOTest("b"));
			return friendstest;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 空を返す
		return new ArrayList<FriendVOTest>();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ArrayList<String> friendData = new ArrayList<String>();
		String[] data = new String[100];
		for (int i = 0; i < 10; i++) {
			String a = friendsAdapter.getItem(i).getFriendName();
			friendData.add(friendsAdapter.getItem(i).getFriendName());
			data[i] = a;
		}

			// ここを変える
			// http://blog.livedoor.jp/sylc/archives/1469380.htmlが参考になる
			// simpleは既存で定義されている
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
					mActivity, android.R.layout.simple_list_item_1, data);
			setListAdapter(adapter1);
	}

}
