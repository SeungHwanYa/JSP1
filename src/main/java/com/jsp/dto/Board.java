package com.jsp.dto;

public class Board {
	private int id;
	private String title;
	private BoardUser user;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public BoardUser getUser() {
		return user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBoardUser(BoardUser user) {
		this.user = user;
	}

}
