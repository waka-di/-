package com.diworksdev.account.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.regist_completeDAO;
import com.opensymphony.xwork2.ActionSupport;
public class regist_completeAction extends ActionSupport implements SessionAware{
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private int gender;
	private int postalCode;
	private String prefecture;
	private String address_1;
	private String address_2;
	private int authority;
	private Map<String,Object>session;
	
	public String execute() throws SQLException {
		regist_completeDAO regist_completeDAO = new regist_completeDAO();
		
		regist_completeDAO.createUser(
				session.get("familyName").toString(),
			    session.get("lastName").toString(),
			    session.get("mail").toString(),
			    session.get("password").toString(),
			    (int) session.get("gender"),          
			    (int) session.get("postalCode"),
			    session.get("prefecture").toString(),
			    session.get("address_1").toString(),
			    session.get("address_2").toString(),
			    (int) session.get("authority"));
		String result = SUCCESS;
		return result;
	}
	
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
	
	public int getgender() {
		return gender;
	}
	public void setgender(int gender) {
		this.gender = gender;
	}
	
	public int getpostalCode() {
		return postalCode;
	}
	public void setpostalCode(int postalCode)	{
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
	
	public int getauthority() {
		return authority;
	}
	public void setauthority(int authority) {
		this.authority = authority;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
