package com.blogapi.controller;

import com.blogapi.core.entity.Account;
import com.blogapi.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Account addAccount(@RequestBody Account account) {
        return accountService.insert(account);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String id) {
        accountService.delete(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Account deleteAccount(@RequestBody Account account) {
        return accountService.update(account);
    }

}
