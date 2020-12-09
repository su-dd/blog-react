package com.blogapi.controller;

import com.blogapi.core.entity.Account;
import com.blogapi.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * 在 @PreAuthorize 中我们可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。
 * 需注意的一点是 hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。所以这里的 'ADMIN' 其实在
 * 数据库中存储的是 'ROLE_ADMIN' 。这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
 **/

@RestController
@RequestMapping("/Account")
@PreAuthorize("hasRole('ADMIN')")
public class AccountController {

    final private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/auths/{id}", method = RequestMethod.POST)
    public ResponseEntity auths(@PathVariable String id) {
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("isAdmin", accountService.isAdmin(id));
        resp.put("isBlogger", accountService.isBlogger(id));
        resp.put("isReader", accountService.isReader(id));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "/Accounts",method = RequestMethod.POST)
    public List<Account> getAccouts() {
        return accountService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Account findAccout(@PathVariable String id) {
        return accountService.findOne(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Account addAccount(@RequestBody Account account) {
        return accountService.insert(account);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String id) {
        accountService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Account updateAccount(@RequestBody Account account) {
        return accountService.update(account);
    }
}
