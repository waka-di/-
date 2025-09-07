package com.diworksdev.account.dto;

import java.util.Date;

public class ListDTO {
    private int id;
    private String familyName;
    private String lastName;
    private String familyNameKana;
    private String lastNameKana;
    private String mail;
    private String password;
    private int gender;
    private int postalCode;
    private String prefecture;
    private String address1;
    private String address2;
    private int authority;
    private int deleteFlg;
    private Date insertDate;
    private Date updateDate;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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

    public int getPostalCode() { return postalCode; }
    public void setPostalCode(int postalCode) { this.postalCode = postalCode; }

    public String getPrefecture() { return prefecture; }
    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }

    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }

    public String getAddress2() { return address2; }
    public void setAddress2(String address2) { this.address2 = address2; }

    public int getAuthority() { return authority; }
    public void setAuthority(int authority) { this.authority = authority; }

    public int getDeleteFlg() { return deleteFlg; }
    public void setDeleteFlg(int deleteFlg) { this.deleteFlg = deleteFlg; }

    public Date getInsertDate() { return insertDate; }
    public void setInsertDate(Date insertDate) { this.insertDate = insertDate; }

    public Date getUpdateDate() { return updateDate; }
    public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
}