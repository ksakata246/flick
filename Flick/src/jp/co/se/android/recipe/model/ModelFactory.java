package jp.co.se.android.recipe.model;

import jp.co.se.android.recipe.chapter03.FriendVO;
import android.graphics.Bitmap;

public class ModelFactory {

	public static FriendVO friendData(int resourceId, String friendName,
			Bitmap imp) {
		return new FriendVO(resourceId, friendName, imp);
	}
	
}
