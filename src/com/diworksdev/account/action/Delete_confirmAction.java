package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Delete_confirmAction extends ActionSupport implements SessionAware {

    private String back;
    private Map<String, Object> session;

    @Override
    public String execute() {
        if ("back".equals(back)) {
            return "back";
        }
        return SUCCESS;
    }

    public String getBack() { return back; }
    public void setBack(String back) { this.back = back; }

    @Override
    public void setSession(Map<String, Object> session) { this.session = session; }
}