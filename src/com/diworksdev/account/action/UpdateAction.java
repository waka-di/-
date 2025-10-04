package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.UpdateDAO;
import com.diworksdev.account.dto.ListDTO;
import com.diworksdev.account.util.PasswordUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    
    private int id;
    private String familyName;
    private String lastName;
    private String familyNameKana;
    private String lastNameKana;
    private String mail;
    private String password;
    private int gender;
    private String	postalCode;
    private String prefecture;
    private String address_1;
    private String address_2;
    private int authority;
    private boolean back;

    public String execute() throws SQLException {
    	 if (back) {
    		 return SUCCESS;
    	    }
    	 
    	 Object authorityObj = session.get("authority");
    	 Integer loginAuthority = null;

    	 if (authorityObj != null) {
    	     if (authorityObj instanceof Integer) {
    	         loginAuthority = (Integer) authorityObj;
    	     } else if (authorityObj instanceof String) {
    	         try {
    	             loginAuthority = Integer.valueOf((String) authorityObj);
    	         } catch (NumberFormatException e) {
    	             loginAuthority = null; // 数値変換できなければ null
    	         }
    	     }
    	 }
    	 if (loginAuthority != null && loginAuthority != 1) {
    	        addActionError("管理者権限が必要です");
    	        return ERROR;
    	    }
    	
        UpdateDAO dao = new UpdateDAO();
        ListDTO account = dao.getAccountById(id);
        
        this.familyName = account.getFamilyName();
        this.lastName = account.getLastName();
        this.familyNameKana = account.getFamilyNameKana();
        this.lastNameKana = account.getLastNameKana();
        this.mail = account.getMail();
        this.gender = account.getGender();
        this.postalCode = account.getPostalCode();
        this.prefecture = account.getPrefecture();
        this.address_1 = account.getAddress_1();
        this.address_2 = account.getAddress_2();
        this.authority = account.getAuthority();

        return SUCCESS;
      }
    
     

    // 更新用
    public String update() throws SQLException {
        UpdateDAO dao = new UpdateDAO();
        
        // パスワードをハッシュ化
        String hashedPassword = null;
        if (password != null && !password.isEmpty()) {
            hashedPassword = PasswordUtil.hash(password);
        }
        
        int count = dao.updateAccount(
            id, familyName, lastName,
            familyNameKana, lastNameKana,
            mail, hashedPassword, gender,
            postalCode, prefecture, address_1, address_2,
            authority
        );

        return count > 0 ? SUCCESS : ERROR;
        }
    
    // --- getter/setter ---
    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
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
    public void setAddress_2(String address_2) { 
    	this.address_2 = address_2; 
    }
    public int getAuthority() { 
    	return authority; 
    }
    public void setAuthority(int authority) { 
    	this.authority = authority; 
    }

        @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public boolean isBack() {
        return back;
    }

    public void setBack(boolean back) {
        this.back = back;
     }
}