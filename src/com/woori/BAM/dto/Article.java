package com.woori.BAM.dto;

// DTO(Data Transfer Object) → getter, setter
public class Article {
	// private 접근제어자 사용
	private int id;
	private String title;
	private String body;
	private String regDate;
	private int viewCnt;

	public Article(int id, String title, String body, String regDate, int viewCnt) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	public int getId() { // get → read
		return id;
	}

	public void setId(int id) { // set → save
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}