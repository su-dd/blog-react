package com.blogapi.service.impl;

import com.blogapi.dao.AccountRepository;
import com.blogapi.dao.po.Account;
import com.blogapi.service.AuthManage;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthManageImpl implements AuthManage {

    private AccountRepository accountRepository;

    @Autowired
    public AuthManageImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean isAdmin(String id) {
        Account account = accountRepository.findById(id).get();
        return account.isAdmin();
    }

    @Override
    public boolean isBlogger(String id) {
        Account account = accountRepository.findById(id).get();
        return account.isBloger();
    }

    @Override
    public boolean isReader(String id) {
        Account account = accountRepository.findById(id).get();
        return account.isReader();
    }

    @Override
    public Account insert(Account account) {
        return accountRepository.insert(account);
    }

    @Override
    public void delete(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account update(Account account) {
        accountRepository.deleteById(account.getId());
        return accountRepository.insert(account);
    }
}
