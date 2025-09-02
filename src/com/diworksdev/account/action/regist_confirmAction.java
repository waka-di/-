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
		// 初回アクセス時はフォームを空欄にする

		if (!session.containsKey("familyName")) {
	        familyName = null;
	        lastName = null;
	        familyNameKana = null;
	        lastNameKana = null;
	        mail = null;
	        password = null;
	        gender = null;
	        postalCode = null;
	        prefecture = null;
	        address_1 = null;
	        address_2 = null;
	        authority = null;
	    }
	
		if (familyName == null || familyName.trim().isEmpty()) {
            addFieldError("familyName", "名前（姓）が未入力です。");
        } else if (!familyName.matches("[\\p{IsHan}\\p{IsHiragana}]+")) {
            addFieldError("familyName", "名前（姓）はひらがな、漢字のみ入力可能です。");
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            addFieldError("lastName", "名前（名）が未入力です。");
        } else if (!lastName.matches("[\\p{IsHan}\\p{IsHiragana}]+")) {
            addFieldError("lastName", "名前（名）はひらがな、漢字のみ入力可能です。");
        }

        if (familyNameKana == null || familyNameKana.trim().isEmpty()) {
            addFieldError("familyNameKana", "カナ（姓）が未入力です。");
        } else if (!familyNameKana.matches("[\\p{IsKatakana}]+")) {
            addFieldError("familyNameKana", "カナ（姓）はカタカナのみ入力可能です。");
        }

        if (lastNameKana == null || lastNameKana.trim().isEmpty()) {
            addFieldError("lastNameKana", "カナ（名）が未入力です。");
        } else if (!lastNameKana.matches("[\\p{IsKatakana}]+")) {
            addFieldError("lastNameKana", "カナ（名）はカタカナのみ入力可能です。");
        }

        if (mail == null || mail.trim().isEmpty()) {
            addFieldError("mail", "メールアドレスが未入力です。");
        } else if (!mail.matches("[a-zA-Z0-9@\\-\\.]+")) {
            addFieldError("mail", "メールアドレスは半角英数字、@、-のみ入力可能です。");
        }

        if (password == null || password.trim().isEmpty()) {
            addFieldError("password", "パスワードが未入力です。");
        } else if (!password.matches("[a-zA-Z0-9]+")) {
            addFieldError("password", "パスワードは半角英数字のみ入力可能です。");
        }

        if (postalCode == null || postalCode.trim().isEmpty()) {
            addFieldError("postalCode", "郵便番号が未入力です。");
        } else if (!postalCode.matches("\\d+")) {
            addFieldError("postalCode", "郵便番号は半角数字のみ入力してください。");
        }

        if (prefecture == null || prefecture.trim().isEmpty()) {
            addFieldError("prefecture", "都道府県が未入力です。");
        }

        if (address_1 == null || address_1.trim().isEmpty()) {
            addFieldError("address_1", "住所（市区町村）が未入力です。");
        } else if (!address_1.matches("[\\p{IsHan}\\p{IsHiragana}\\p{IsKatakana}\\d\\-\\s]+")) {
            addFieldError("address_1", "住所（市区町村）はひらがな、漢字、数字、カタカナ、記号（ハイフンとスペース）のみ入力可能です。");
        }

        if (address_2 == null || address_2.trim().isEmpty()) {
            addFieldError("address_2", "住所（番地）が未入力です。");
        } else if (!address_2.matches("[\\p{IsHan}\\p{IsHiragana}\\p{IsKatakana}\\d\\-\\s]+")) {
            addFieldError("address_2", "住所（番地）は許可文字のみ入力可能です。");
        }

        if (authority == null || authority.trim().isEmpty()) {
            addFieldError("authority", "権限が未選択です。");
        }

        if (hasFieldErrors()) {
            return ERROR;
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