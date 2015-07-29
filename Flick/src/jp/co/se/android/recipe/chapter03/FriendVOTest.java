package jp.co.se.android.recipe.chapter03;

import java.io.Serializable;

/**
 * Friends一人一人が保有している情報をまとめるVO
 * 
 */
public class FriendVOTest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String friendName;

	// コンストラクタ
	public FriendVOTest() {
	}

	public FriendVOTest(String string) {
		this.friendName = string;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}
