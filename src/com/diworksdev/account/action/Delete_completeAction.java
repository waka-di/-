package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.Delete_completeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Delete_completeAction extends ActionSupport implements SessionAware {
    private int id;  // 削除対象のID

    private Map<String,Object> session;

    @Override
    public String execute() {
        Delete_completeDAO dao = new Delete_completeDAO();
        try {
            int result = dao.deleteAccount(id);
            if(result > 0) {
                return SUCCESS;
            } else {
                addActionError("エラーが発生したためアカウント削除できません。");
                return ERROR;
            }
        } catch (SQLException e) {
            addActionError("エラーが発生したためアカウント削除できません。");
            return ERROR;
        }
    }

    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
    }
    @Override
    public void setSession(Map<String, Object> session) { 
    	this.session = session; 
    	}
}