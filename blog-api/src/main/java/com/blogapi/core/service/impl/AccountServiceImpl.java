package com.blogapi.core.service.impl;

import com.blogapi.core.dao.AccountDao;
import com.blogapi.core.entity.Account;
import com.blogapi.core.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    final private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public boolean isAdmin(String id) {
        if (accountDao.existsById(id)){
            Account account = accountDao.findById(id).get();
            return account.getRoles().contains("admin");
        }
        return false;
    }

    @Override
    public boolean isBlogger(String id) {
        if (accountDao.existsById(id)){
            Account account = accountDao.findById(id).get();
            return account.getRoles().contains("blogger");
        }
        return false;
    }

    @Override
    public boolean isReader(String id) {
        if (accountDao.existsById(id)){
            Account account = accountDao.findById(id).get();
            return account.getRoles().contains("reader");
        }
        return true;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findOne(String id) {
        if (accountDao.existsById(id)){
            return accountDao.findById(id).get();
        }
        return new Account();
    }

    @Override
    public Account insert(Account account) {
        return accountDao.insert(account);
    }

    @Override
    public void delete(String id) {
        accountDao.deleteById(id);
    }

    @Override
    public Account update(Account account) {
        accountDao.deleteById(account.getId());
        return accountDao.insert(account);
    }
}
