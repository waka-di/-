package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.UpdateDAO;
import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware {

    private Integer id; // 削除対象のID
    private Map<String, Object> session;
    
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

    // 戻るボタン用
    private String back;

    // --- execute ---
    @SuppressWarnings("unchecked")
    public String execute() throws SQLException {
        // セッションにdeleteFormがある場合（前へ戻った場合）
        if (session != null && session.get("deleteForm") != null) {
            Map<String, Object> form = (Map<String, Object>) session.get("deleteForm");
            this.id = (Integer) form.get("id");
            this.familyName = (String) form.get("familyName");
            this.lastName = (String) form.get("lastName");
            this.familyNameKana = (String) form.get("familyNameKana");
            this.lastNameKana = (String) form.get("lastNameKana");
            this.mail = (String) form.get("mail");
            this.password = (String) form.get("password");
            this.gender = (Integer) form.get("gender");
            this.postalCode = (String) form.get("postalCode");
            this.prefecture = (String) form.get("prefecture");
            this.address_1 = (String) form.get("address_1");
            this.address_2 = (String) form.get("address_2");
            this.authority = (Integer) form.get("authority");

            // 一度取り出したらセッションから削除
            session.remove("deleteForm");
        } 
        // セッションがなければDBから取得
        else if (id != null) {
            UpdateDAO dao = new UpdateDAO();
            ListDTO dto = dao.getAccountById(id);

            if (dto != null) {
                this.familyName = dto.getFamilyName();
                this.lastName = dto.getLastName();
                this.familyNameKana = dto.getFamilyNameKana();
                this.lastNameKana = dto.getLastNameKana();
                this.mail = dto.getMail();
                this.password = dto.getPassword(); // パスワードはそのまま
                this.gender = dto.getGender();
                this.postalCode = String.valueOf(dto.getPostalCode()); // int → String
                this.prefecture = dto.getPrefecture();
                this.address_1 = dto.getAddress_1();
                this.address_2 = dto.getAddress_2();
                this.authority = dto.getAuthority();
            }
        }
        return SUCCESS;
    }

    // --- getter/setter ---
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

    public int getGender() { return gender; }
    public void setGender(int gender) { this.gender = gender; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getPrefecture() { return prefecture; }
    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }

    public String getAddress_1() { return address_1; }
    public void setAddress_1(String address_1) { this.address_1 = address_1; }

    public String getAddress_2() { return address_2; }
    public void setAddress_2(String address_2) { this.address_2 = address_2; }

    public int getAuthority() { return authority; }
    public void setAuthority(int authority) { this.authority = authority; }

    public String getBack() { return back; }
    public void setBack(String back) { this.back = back; }

    @Override
    public void setSession(Map<String, Object> session) { this.session = session; }
}