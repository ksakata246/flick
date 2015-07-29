package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.graphics.BitmapFactory;
import model.provider.BaseResourceDataProvider;
import jp.co.se.android.recipe.chapter03.R;

public class FriendDataProvider extends
		BaseResourceDataProvider<FriendResourceCollection> {

	public static Map<String, FriendResourceCollection> dataMap;

	public FriendDataProvider() {
		super(FriendResourceCollection.class);
	}

	@Override
	public FriendResourceCollection get(String sessionGroupId) {
		return dataMap.get(sessionGroupId);
	}

	static {
		try {
			dataMap = new HashMap<String, FriendResourceCollection>();
			// for (String grpId : sessionGroupIds()) {
			List<FriendResource> friends = new ArrayList<FriendResource>();
			// for (String sessId : sessionIds(grpId)) {
			// boolean even = sessionIds(grpId).indexOf(sessId) % 2 == 0;
			friends.add(
			// resource(FriendResource.class),
			// sessId,
			friend(ModelFactory.friendData(R.drawable.ic_launcher, 1,
					BitmapFactory.decodeResource(getResources(),
							R.drawable.ic_launcher))));
			// }
			dataMap.put(grpId,
					resources(FriendResourceCollection.class, friends));

			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
