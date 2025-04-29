package com.woori.BAM.dto;
// DTO(Data Transfer Object) → getter, setter

public class Article {

	// DB와 연결되기 때문에 보안상 private 접근제어자 사용
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

	public int getId() { // (카멜표기법) Getter → read, return 받음
		return id;
	}

	public void setId(int id) { // (카멜표기법) Setter → save, this(전역변수) 사용
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