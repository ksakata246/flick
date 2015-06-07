package jp.co.se.android.recipe.chapter03;

import java.io.Serializable;

/**
 * google検索の結果をまとめるVO
 * 
 */
public class FlickUrlSearchResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String url;

	public FlickUrlSearchResult() {
	}

	public FlickUrlSearchResult(String url) {
		super();
		this.url = url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}
