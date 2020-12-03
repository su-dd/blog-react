package com.blogapi.service.impl;

import com.blogapi.dao.AccountRepository;
import com.blogapi.dao.po.Account;
import com.blogapi.service.AuthManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManageImpl implements AuthManage {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isAdmin(String id) {
        accountRepository.findById(id);
        return false;
    }

    @Override
    public boolean isBloger(String id) {
        return false;
    }

    @Override
    public boolean isReader(String id) {
        return false;
    }
}
