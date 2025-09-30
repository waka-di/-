package com.diworksdev.account.action;
import java.sql.SQLException;

import com.diworksdev.account.dao.Regist_completeDAO;
import com.opensymphony.xwork2.ActionSupport;
public class Regist_completeAction extends ActionSupport{
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private int gender;
	private String postalCode;
	private String prefecture;
	private String address_1;
	private String address_2;
	private int authority;
	
	public String execute() {
		Regist_completeDAO dao = new Regist_completeDAO();

		try {
		    int result = dao.createUser(familyName, lastName, familyNameKana, lastNameKana,
		    		mail, password, gender, postalCode, prefecture, address_1, address_2, authority);

		    if (result > 0) {
		        return SUCCESS; // 登録完了画面へ
		    } else {
		        addActionError("エラーが発生したためアカウント登録できません。");
		        return ERROR; // 確認画面へ
		    }
		} catch (SQLException e) {
		    addActionError("エラーが発生したためアカウント登録できません。");
		    return ERROR;
		}
	}
	
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName)	{
		this.lastName = lastName;
	}
	
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	
	public String getLastNameKana() {
		return lastNameKana;
	}
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail)	{
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getPostalCode() { 
		return postalCode; 
	}
	public void setPostalCode(String postalCode) { 
		this.postalCode = postalCode; 
	}
	
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2)	{
		this.address_2 = address_2;
	}
	
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
}
