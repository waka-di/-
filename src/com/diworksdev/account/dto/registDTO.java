package com.diworksdev.account.dto;

public class registDTO {
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private String gender;
	private String postalCode;
	private String prefecture;
	private String address_1;
	private String address_2;
	private String authority;
	private boolean loginFlg = false;
	
	public String getfamilyName() {
		return familyName;
	}
	public void setfamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName)	{
		this.lastName = lastName;
	}
	
	public String getfamilyNameKana() {
		return familyNameKana;
	}
	public void setfamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	
	public String getlastNameKana() {
		return lastNameKana;
	}
	public void setlastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
	
	public String getmail() {
		return mail;
	}
	public void setmail(String mail)	{
		this.mail = mail;
	}
	
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public String getpostalCode() {
		return postalCode;
	}
	public void setpostalCode(String postalCode)	{
		this.postalCode = postalCode;
	}
	
	public String getprefecture() {
		return prefecture;
	}
	public void setprefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getaddress_1() {
		return address_1;
	}
	public void setaddress_1(String address_1) {
		this.address_1 = address_1;
	}
	
	public String address_2() {
		return address_2;
	}
	public void setaddress_2(String address_2)	{
		this.address_2 = address_2;
	}
	
	public String getauthority() {
		return authority;
	}
	public void setauthority(String authority) {
		this.authority = authority;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}
	
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

}
