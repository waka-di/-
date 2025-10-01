package com.diworksdev.account.action;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.ListDAO;
import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport implements SessionAware{
		private List<ListDTO> accountList;
		private Map<String, Object> session;
		
		private String familyName;
	    private String lastName;
	    private String familyNameKana;
	    private String lastNameKana;
	    private String mail;
	    private String gender;
	    private String authority;

	    private Map<String, String> genderList;
	    private Map<String, String> authorityList;
	        
	    public ListAction() {
	        genderList = new LinkedHashMap<>();
	        genderList.put("0", "男");
	        genderList.put("1", "女");
	
	        authorityList = new LinkedHashMap<>();
	        authorityList.put("0", "一般");
	        authorityList.put("1", "管理者");
	    }
    
		@Override
	    public void setSession(Map<String, Object> session) {
	        this.session = session;
	    }
		
		@Override
	    public String execute() {
			ListDTO loginUser = (ListDTO) session.get("loginUser");
		    if (loginUser == null || loginUser.getAuthority() != 1) {
		    	addActionError("権限がありません。");
		    	return ERROR;
		    }
		    
		    if (!isPost()) {
		        accountList = null; 
		        return SUCCESS;
		    }
		    
		    ListDAO dao = new ListDAO();
		    
		    boolean allDefault = isEmpty(familyName) &&
                    isEmpty(lastName) &&
                    isEmpty(familyNameKana) &&
                    isEmpty(lastNameKana) &&
                    isEmpty(mail) &&
                    isEmpty(gender) &&
                    isEmpty(authority);

			if (allDefault) {
			   accountList = dao.getAccountList();   // 全件取得
			} 
			else {
				accountList = dao.searchAccounts(
			    isEmpty(familyName) ? null : familyName,
			    isEmpty(lastName) ? null : lastName,
			    isEmpty(familyNameKana) ? null : familyNameKana,
			    isEmpty(lastNameKana) ? null : lastNameKana,
			    isEmpty(mail) ? null : mail,
			    isEmpty(gender) ? null : gender,
			     isEmpty(authority) ? null : authority
		        );
		    }
		        return SUCCESS;
		    }

		 private boolean isPost() {
		        HttpServletRequest request = ServletActionContext.getRequest();
		        return "POST".equalsIgnoreCase(request.getMethod());
		    }

		    private boolean isEmpty(String value) {
		        return value == null || value.trim().isEmpty();
		    }
   	    
    public List<ListDTO> getAccountList() { 
    	return accountList; 
    }
    public Map<String, String> getGenderList() { 
    	return genderList; 
    }
    public Map<String, String> getAuthorityList() { 
    	return authorityList; 
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
    public String getGender() { 
    	return gender; 
    }
    public void setGender(String gender) { 
    	this.gender = gender; 
    }
    public String getAuthority() { 
    	return authority; 
    }
    public void setAuthority(String authority) { 
    	this.authority = authority; 
    }
}