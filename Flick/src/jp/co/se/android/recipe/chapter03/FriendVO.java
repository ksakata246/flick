package jp.co.se.android.recipe.chapter03;

import java.io.Serializable;

import android.graphics.Bitmap;

/**
 * Friends一人一人が保有している情報をまとめるVO
 * 
 */
public class FriendVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int resourceId;
	
	private String friendName;
	
	private Bitmap imp;
	
	//コンストラクタ
	public FriendVO() {}

	public FriendVO(int resourceId, String friendName, Bitmap imp) {
		this.resourceId = resourceId;
		this.friendName = friendName;
		this.imp = imp;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Bitmap getImp() {
		return imp;
	}

	public void setImp(Bitmap imp) {
		this.imp = imp;
	}

}
