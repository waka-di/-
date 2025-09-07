package com.diworksdev.account.action;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.diworksdev.account.dao.ListDAO;
import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{
	private List<ListDTO> accountList;

    @Override
    public String execute() {
        ListDAO dao = new ListDAO();
        accountList = dao.getAccountList();

        // IDの降順でソート
        Collections.sort(accountList, new Comparator<ListDTO>() {
            @Override
            public int compare(ListDTO a1, ListDTO a2) {
                return Integer.compare(a2.getId(), a1.getId()); // 降順
            }
        });

        return SUCCESS;
    }

    public List<ListDTO> getAccountList() {
        return accountList;
    }
}
