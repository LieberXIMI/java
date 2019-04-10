package com.southwind.entity;

public class Reader {
	private int id;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String cardid;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Reader(String username, String password, String name, String gender, String cardid, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.cardid = cardid;
		this.tel = tel;
	}
	public Reader() {
		super();
	}
	
}
