package com.diworksdev.account.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Delete_confirmAction extends ActionSupport implements SessionAware{
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
	
	private String back;
	
	public Map<String,Object> session;
	
	@Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
	public String getBack() { 
		return back; 
	}
    public void setBack(String back) { 
    	this.back = back; 
    }
	
	@Override
    public String execute() {
		
		// セッションに値があればフォームにセット
        if (session.get("familyName") != null) familyName = (String) session.get("familyName");
        if (session.get("lastName") != null) lastName = (String) session.get("lastName");
        if (session.get("familyNameKana") != null) familyNameKana = (String) session.get("familyNameKana");
        if (session.get("lastNameKana") != null) lastNameKana = (String) session.get("lastNameKana");
        if (session.get("mail") != null) mail = (String) session.get("mail");
        if (session.get("password") != null) password = (String) session.get("password");
        if (session.get("gender") != null) gender = String.valueOf(session.get("gender"));
        if (session.get("postalCode") != null) postalCode = String.valueOf(session.get("postalCode"));
        if (session.get("prefecture") != null) prefecture = (String) session.get("prefecture");
        if (session.get("address_1") != null) address_1 = (String) session.get("address_1");
        if (session.get("address_2") != null) address_2 = (String) session.get("address_2");
        if (session.get("authority") != null) authority = String.valueOf(session.get("authority"));

		// 「前に戻る」ボタンが押された場合
		if (back != null) { 
			session.put("familyName", familyName); 
			session.put("lastName", lastName); 
			session.put("familyNameKana", familyNameKana); 
			session.put("lastNameKana", lastNameKana); 
			session.put("mail", mail); 
			session.put("password", password); 
			session.put("gender", gender); 
			session.put("postalCode", postalCode); 
			session.put("prefecture", prefecture); 
			session.put("address_1", address_1); 
			session.put("address_2", address_2); 
			session.put("authority", authority);
			return "back"; 
			}
		

		
        // 正常処理
        session.put("familyName", familyName);
        session.put("lastName", lastName);
        session.put("familyNameKana", familyNameKana);
        session.put("lastNameKana", lastNameKana);
        session.put("mail", mail);
        session.put("password", password);
        session.put("gender", Integer.parseInt(gender));
        session.put("postalCode", Integer.parseInt(postalCode));
        session.put("prefecture", prefecture);
        session.put("address_1", address_1);
        session.put("address_2", address_2);
        session.put("authority", Integer.parseInt(authority));
        return SUCCESS; 
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
	public void setLastName(String lastName){ 
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
	 public void setMail(String mail) { 
		 this.mail = mail; 
	}
	 public String getPassword() {
		 return password;
	}
	 public void setPassword(String password) { 
		 this.password = password; 
	}
	 public String getPasswordMasked() {
		    if (password == null) return "";
		    StringBuilder sb = new StringBuilder();
		    for(int i=0; i<password.length(); i++){
		        sb.append("●");
		    }
		    return sb.toString();
	}
    public String getGender() { 
    	return gender; 
    }
	 public void setGender(String gender) {
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
	public void setAddress_2(String address_2) {
		this.address_2 = address_2; 
	}
	public String getAuthority() { 
		return authority; 
	}
	public void setAuthority(String authority) { 
	    	this.authority = authority; 
	 }
}
