package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.DeleteDAO;
import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware {

    private int id; // 削除対象のID
    private Map<String, Object> session;

    @Override
    public String execute() {
        DeleteDAO dao = new DeleteDAO();
        try {
            ListDTO account = dao.getAccountById(id);
            if (account != null) {
                session.put("account", account);
                return SUCCESS;
            } else {
                addActionError("対象アカウントが存在しません。");
                return ERROR;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            addActionError("エラーが発生しました。");
            return ERROR;
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    @Override
    public void setSession(Map<String, Object> session) { this.session = session; }
}
