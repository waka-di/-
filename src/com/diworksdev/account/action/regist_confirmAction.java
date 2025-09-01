package com.diworksdev.account.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class regist_confirmAction extends ActionSupport implements SessionAware{
	
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private int gender = 0;
	private int postalCode;
	private String prefecture;
	private String address_1;
	private String address_2;
	private int authority = 0;
	
	
	
	public Map<String,Object> session;
	private String errorMessage;
	public String execute() {
		String result = SUCCESS;
		if(!(familyName.equals("")) 
		&& !(lastName.equals("")) 
		&& !(familyNameKana.equals("")) 
		&& !(lastNameKana.equals(""))
		&& !(mail.equals("")) 
		&& !(password.equals("")) 
		&& !(gender !=0) 
		&& !(postalCode !=0) 
		&& !(prefecture.equals("")) 
		&& !(address_1.equals("")) 
		&& !(address_2.equals("")) 
		&& !(authority!=1)) {
			session.put("familyName",familyName); 
			session.put("lastName",lastName); 
			session.put("familyNameKana",familyNameKana); 
			session.put("lastNameKana",lastNameKana); 
			session.put("mail",mail); 
			session.put("password",password); 
			session.put("gender",gender); 
			session.put("postalCode",postalCode); 
			session.put("prefecture",prefecture); 
			session.put("address_1",address_1); 
			session.put("address_2",address_2);
			session.put("authority",authority); 
		}
		else { 
			setErrorMessage("未入力の項目があります。"); 
			result = ERROR; 
			} 
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
	
	public String getaddress_2() {
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}