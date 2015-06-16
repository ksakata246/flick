package jp.co.se.android.recipe.chapter03;

import java.io.Serializable;

/**
 * google検索の結果をまとめるVO
 * 
 */
public class UrlSearchResultVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String displayLink;
	
	private String htmlFormattedUrl;
	
	private String title;
	
	private String cacheId;
	
	private String formattedUrl;
	
	private String link;
	
	private String htmlTitle;
	
	private String snippet;
	
	private String htmlSnippet;
	
	private String kind;	

	
	//コンストラクタ
	public UrlSearchResultVO() {}

	public void setDisplayLink(String displayLink) {
		this.displayLink = displayLink;
	}

	public String getDisplayLink() {
		return this.displayLink;
	}

	public String getHtmlFormattedUrl() {
		return htmlFormattedUrl;
	}

	public void setHtmlFormattedUrl(String htmlFormattedUrl) {
		this.htmlFormattedUrl = htmlFormattedUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCacheId() {
		return cacheId;
	}

	public void setCacheId(String cacheId) {
		this.cacheId = cacheId;
	}

	public String getFormattedUrl() {
		return formattedUrl;
	}

	public void setFormattedUrl(String formattedUrl) {
		this.formattedUrl = formattedUrl;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getHtmlTitle() {
		return htmlTitle;
	}

	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getHtmlSnippet() {
		return htmlSnippet;
	}

	public void setHtmlSnippet(String htmlSnippet) {
		this.htmlSnippet = htmlSnippet;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}
