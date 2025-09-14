package com.diworksdev.account.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	 @Override
	    public void setSession(Map<String, Object> session) {
	        this.session = session;
	    }
	public String execute() {
		 ListDTO loginUser = (ListDTO) session.get("loginUser");

		 if (loginUser == null) { // 未ログイン
		        addActionError("ログインしてください。");
		        return ERROR;
		    }

		    if (loginUser.getAuthority() != 1) { // 権限不足
		        addActionError("権限がありません。");
		        return ERROR;
		    }

		   
		    return SUCCESS;
		}
}