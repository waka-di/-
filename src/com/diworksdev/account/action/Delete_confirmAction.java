package com.diworksdev.account.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Delete_confirmAction extends ActionSupport implements SessionAware {

	private Integer id;
    private String familyName;
    private String lastName;
    private String familyNameKana;
    private String lastNameKana;
    private String mail;
    private String password;
    private Integer gender;
    private String postalCode;
    private String prefecture;
    private String address_1;
    private String address_2;
    private Integer authority;

    private String back; // 前へ戻るボタン用
    private Map<String, Object> session;

    @Override
    public String execute() {
        if ("back".equals(back)) {
            // セッションにフォーム情報を保存
            Map<String,Object> formMap = new HashMap<>();
            formMap.put("id", id);
            formMap.put("familyName", familyName);
            formMap.put("lastName", lastName);
            formMap.put("familyNameKana", familyNameKana);
            formMap.put("lastNameKana", lastNameKana);
            formMap.put("mail", mail);
            formMap.put("password", password);
            formMap.put("gender", gender);
            formMap.put("postalCode", postalCode);
            formMap.put("prefecture", prefecture);
            formMap.put("address_1", address_1);
            formMap.put("address_2", address_2);
            formMap.put("authority", authority);

            session.put("deleteForm", formMap);

            return "back";
        }
        return SUCCESS;
    }

    // --- getter / setter ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFamilyName() { return familyName; }
    public void setFamilyName(String familyName) { this.familyName = familyName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFamilyNameKana() { return familyNameKana; }
    public void setFamilyNameKana(String familyNameKana) { this.familyNameKana = familyNameKana; }
    public String getLastNameKana() { return lastNameKana; }
    public void setLastNameKana(String lastNameKana) { this.lastNameKana = lastNameKana; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Integer getGender() { return gender; }
    public void setGender(Integer gender) { this.gender = gender; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getPrefecture() { return prefecture; }
    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }
    public String getAddress_1() { return address_1; }
    public void setAddress_1(String address_1) { this.address_1 = address_1; }
    public String getAddress_2() { return address_2; }
    public void setAddress_2(String address_2) { this.address_2 = address_2; }
    public Integer getAuthority() { return authority; }
    public void setAuthority(Integer authority) { this.authority = authority; }

    public String getBack() { return back; }
    public void setBack(String back) { this.back = back; }

    @Override
    public void setSession(Map<String, Object> session) { 
    	this.session = session; 
    }
    }
