package com.diworksdev.account.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	
	private String familyName;
    private String lastName;
    private String familyNameKana;
    private String lastNameKana;
    private String mail;
    private String password;
    private String gender = "0";
    private String postalCode;
    private String prefecture;
    private String address_1;
    private String address_2;
    private String authority;
    
    
	 @Override
	    public void setSession(Map<String, Object> session) {
	        this.session = session;
	    }
	 	 
	public String execute() {
		
		ListDTO loginUser = (ListDTO) session.get("loginUser");
	      if (loginUser == null || loginUser.getAuthority() != 1) {
	            addActionError("権限がありません。");
	            return ERROR;
	        }
    
		    return SUCCESS;
	}
	
	// Getter/Setter 
    public String getFamilyName() { 
    	return familyName; 
    }
    public void setFamilyName(String familyName) { 
    	this.familyName = familyName; 
    }
    
    public String getLastName() { 
    	return lastName; 
    }
    public void setLastName(String lastName) { 
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