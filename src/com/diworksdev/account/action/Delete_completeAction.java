package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.Delete_completeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Delete_completeAction extends ActionSupport implements SessionAware {
	private Integer id;  // int → Integer
    private Map<String,Object> session;

    @Override
    public String execute() {
        if (id == null) {
            addActionError("エラーが発生したためアカウント削除できません。");
            return ERROR;
        }

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Override
    public void setSession(Map<String, Object> session) { 
        this.session = session; 
    }
}