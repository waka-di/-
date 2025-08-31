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
	private int gender = -1;
	private int postalCode = 0;
	private String prefecture;
	private String address_1;
	private String address_2;
	private int authority = -1;
	
	
	
	public Map<String,Object> session;
	private String errorMessage;
	public String execute() {
		if(hasFieldErrors()) {
			return INPUT;
		}
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
				return SUCCESS;
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
	@Override
	public void validate() {
		if(familyName == null || familyName.trim().isEmpty()) {
	        addFieldError("familyName", "名前（姓）が未入力です。");
	    }
	    if(lastName == null || lastName.trim().isEmpty()) {
	        addFieldError("lastName", "名前（名）が未入力です。");
	    }
	    if(familyNameKana == null || familyNameKana.trim().isEmpty()) {
	        addFieldError("familyNameKana", "カナ（姓）が未入力です。");
	    }
	    if(lastNameKana == null || lastNameKana.trim().isEmpty()) {
	        addFieldError("lastNameKana", "カナ（名）が未入力です。");
	    }
	    if(mail == null || mail.trim().isEmpty()) {
	        addFieldError("mail", "メールアドレスが未入力です。");
	    }
	    if(password == null || password.trim().isEmpty()) {
	        addFieldError("password", "パスワードが未入力です。");
	    }
	    if(gender == -1) {
	        addFieldError("gender", "性別が未選択です。");
	    }
	    if(postalCode == 0) {
	        addFieldError("postalCode", "郵便番号が未入力です。");
	    }
	    if(prefecture == null || prefecture.trim().isEmpty()) {
	        addFieldError("prefecture", "都道府県が未選択です。");
	    }
	    if(address_1 == null || address_1.trim().isEmpty()) {
	        addFieldError("address_1", "住所（市区町村）が未入力です。");
	    }
	    if(address_2 == null || address_2.trim().isEmpty()) {
	        addFieldError("address_2", "住所（番地）が未入力です。");
	    }
	    if(authority == -1) {
	        addFieldError("authority", "アカウント権限が未選択です。");
	    }
	    
	    if(familyName != null && !familyName.trim().isEmpty() && 
	    	!familyName.matches("[\\p{IsHan}\\p{IsHiragana}]+")) {
	    		addFieldError("familyName", "名前（姓）はひらがな・漢字のみ入力可能です。");
	    	}
	    	if(lastName != null && !lastName.trim().isEmpty() && 
	    	   !lastName.matches("[\\p{IsHan}\\p{IsHiragana}]+")) {
	    	        addFieldError("lastName", "名前（名）はひらがな・漢字のみ入力可能です。");
	    	 }

	    	 if(familyNameKana != null && !familyNameKana.trim().isEmpty() && 
	    	       !familyNameKana.matches("[\\p{IsKatakana}]+")) {
	    	        addFieldError("familyNameKana", "カナ（姓）はカタカナのみ入力可能です。");
	    	  }
	    	 if(lastNameKana != null && !lastNameKana.trim().isEmpty() && 
	    	    !lastNameKana.matches("[\\p{IsKatakana}]+")) {
	    	        addFieldError("lastNameKana", "カナ（名）はカタカナのみ入力可能です。");
	    	    }

	    	 if(password != null && !password.trim().isEmpty() && 
	    	     !password.matches("[A-Za-z0-9]+")) {
	    	        addFieldError("password", "パスワードは半角英数字のみ入力可能です。");
	    	  }

	    	  if(mail != null && !mail.trim().isEmpty() && 
	    	     !mail.matches("[A-Za-z0-9@\\-\\.]+")) {
	    	        addFieldError("mail", "メールアドレスは半角英数字、@、-、.のみ入力可能です。");
	    	  }

	    	  if(postalCode != 0) {
	    	      String postalStr = String.valueOf(postalCode);
	    	        if(!postalStr.matches("\\d+")) {
	    	            addFieldError("postalCode", "郵便番号は半角数字のみ入力可能です。");
	    	        }
	    	   }

	    	   if(address_1 != null && !address_1.trim().isEmpty() &&
	    	       !address_1.matches("[\\p{IsHan}\\p{IsHiragana}\\p{IsKatakana}0-9\\-\\s]+")) {
	    	        addFieldError("address_1", "住所（市区町村）は使用できない文字が含まれています。");
	    	    }
	    	    if(address_2 != null && !address_2.trim().isEmpty() &&
	    	       !address_2.matches("[\\p{IsHan}\\p{IsHiragana}\\p{IsKatakana}0-9\\-\\s]+")) {
	    	        addFieldError("address_2", "住所（番地）は使用できない文字が含まれています。");
	    	   }
	}
}

