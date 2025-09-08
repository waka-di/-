package com.diworksdev.account.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.UpdateDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Update_completeAction extends ActionSupport implements SessionAware {
    private Map<String,Object> session;

    public String execute() {
        UpdateDAO dao = new UpdateDAO();
        try {
            int result = dao.updateAccount(
                (String)session.get("familyName"),
                (String)session.get("lastName"),
                (String)session.get("familyNameKana"),
                (String)session.get("lastNameKana"),
                (String)session.get("mail"),
                (String)session.get("password"),
                Integer.parseInt(session.get("gender").toString()),
                session.get("postalCode").toString(),
                (String)session.get("prefecture"),
                (String)session.get("address_1"),
                (String)session.get("address_2"),
                Integer.parseInt(session.get("authority").toString()),
                (Integer)session.get("id")   // 更新対象のID
            );
            if (result > 0) {
                return SUCCESS;
            } else {
                addActionError("エラーが発生したためアカウント更新できません。");
                return ERROR;
            }
        } catch (SQLException e) {
            addActionError("エラーが発生したためアカウント更新できません。");
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}