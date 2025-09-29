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
    private int 	postalCode;
    private String prefecture;
    private String address_1;
    private String address_2;
    private int authority;
    
    //ダミー
    private static final String PASSWORD_MASK = "●●●●●●●●";

    // 表示用
    public String execute() throws SQLException {
    	 UpdateDAO dao = new UpdateDAO();
    	 ListDTO dto = dao.getAccountById(id);

    	 if(dto != null) {
    	        // DAO の情報を優先
    	        this.familyName = dto.getFamilyName();
    	        this.lastName = dto.getLastName();
    	        this.familyNameKana = dto.getFamilyNameKana();
    	        this.lastNameKana = dto.getLastNameKana();
    	        this.mail = dto.getMail();
    	        this.password = PASSWORD_MASK;
    	        this.gender = dto.getGender();
    	        this.postalCode = dto.getPostalCode();
    	        this.prefecture = dto.getPrefecture();
    	        this.address_1 = dto.getAddress_1();
    	        this.address_2 = dto.getAddress_2();
    	        this.authority = dto.getAuthority();
    	    }

    	    // セッションから直前入力値を上書き（バリデーションエラー再表示用）
    	    if(session.get("familyName") != null) {
    	        this.familyName = (String) session.get("familyName");
    	        this.lastName = (String) session.get("lastName");
    	        this.familyNameKana = (String) session.get("familyNameKana");
    	        this.lastNameKana = (String) session.get("lastNameKana");
    	        this.mail = (String) session.get("mail");
    	        this.password = (String) session.get("password");
    	        this.gender = Integer.parseInt(session.get("gender").toString());
    	        this.postalCode = Integer.parseInt(session.get("postalCode").toString());
    	        this.prefecture = (String) session.get("prefecture");
    	        this.address_1 = (String) session.get("address_1");
    	        this.address_2 = (String) session.get("address_2");
    	        this.authority = Integer.parseInt(session.get("authority").toString());

    	        session.remove("familyName");
    	        session.remove("lastName");
    	        session.remove("familyNameKana");
    	        session.remove("lastNameKana");
    	        session.remove("mail");
    	        session.remove("password");
    	        session.remove("gender");
    	        session.remove("postalCode");
    	        session.remove("prefecture");
    	        session.remove("address_1");
    	        session.remove("address_2");
    	        session.remove("authority");
    	    }

    	    return SUCCESS;
    	}

    // 更新用
    public String update() throws SQLException {
        UpdateDAO dao = new UpdateDAO();
        
        // パスワードをハッシュ化
        String hashedPassword = null;
        if (password != null && !password.isEmpty() && !PASSWORD_MASK.equals(password)) {
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
    public int getPostalCode() { 
    	return postalCode; 
    }
    public void setPostalCode(int postalCode) { 
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
    public String getPasswordMasked() {
        return "●●●●●●●●";
    }
        @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}