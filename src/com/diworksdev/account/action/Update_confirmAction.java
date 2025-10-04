package com.diworksdev.account.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;
public class Update_confirmAction extends ActionSupport implements SessionAware{
	private Integer id;
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
		
	@Override
    public String execute() {
		System.out.println("password = " + password);//チェック用
		Object loginUserObj = session.get("loginUser");
		if (loginUserObj == null || !(loginUserObj instanceof ListDTO)) {
		    addActionError("権限がありません");
		    return ERROR;
		}

		ListDTO loginUser = (ListDTO) loginUserObj;

		if (loginUser.getAuthority() != 1) {
		    addActionError("権限がありません");
		    return ERROR;
		}
	    
		if ("true".equals(back)) {
		    return "back";  
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

        if (password != null && !password.equals("")) {
            if (!password.matches("[a-zA-Z0-9]+")) {
                addFieldError("password", "パスワードは半角英数字のみ入力可能です。");
            }
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
        	return "input";
        }
        if (password != null && !password.isEmpty()) {
            session.put("passwordTemp", password);
        } 	
        return SUCCESS;
	}

	
	public Integer getId() { 
		return id; 
	}
	public void setId(Integer id) { 
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
