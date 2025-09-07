package com.diworksdev.account.action;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.diworksdev.account.dao.listDAO;
import com.diworksdev.account.dto.listDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{
	private List<listDTO> accountList;

    @Override
    public String execute() {
        listDAO dao = new listDAO();
        accountList = dao.getAccountList();

        // IDの降順でソート
        Collections.sort(accountList, new Comparator<listDTO>() {
            @Override
            public int compare(listDTO a1, listDTO a2) {
                return Integer.compare(a2.getId(), a1.getId()); // 降順
            }
        });

        return SUCCESS;
    }

    public List<listDTO> getAccountList() {
        return accountList;
    }
}
