package com.diworksdev.account.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.LoginDAO;
import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	 private String mail;       // JSPから受け取る
	    private String password;
	    private Map<String, Object> session;

	    @Override
	    public String execute() {
	        String ret = ERROR;
	        try {
	            LoginDAO dao = new LoginDAO();
	            ListDTO dto = dao.select(mail, password);

	            if (dto != null && mail.equals(dto.getMail()) && password.equals(dto.getPassword())) {
	                // セッションにログイン情報を保存
	                session.put("loginUser", dto);
	                ret = SUCCESS;
	            } 
	        } catch (SQLException e) {
	            addActionError("エラーが発生したためログイン情報を取得できません。");
	        }
	        return ret;
	    }

	    // getter / setter
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
	    public void setSession(Map<String, Object> session) {
	        this.session = session;
	    }
	}
