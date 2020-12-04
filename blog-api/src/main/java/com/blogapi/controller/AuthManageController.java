package com.blogapi.controller;

import com.blogapi.dao.po.Account;
import com.blogapi.service.impl.AuthManageImpl;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthManageController {

    private AuthManageImpl authManageImpl;

    @Autowired
    public AuthManageController(AuthManageImpl authManageImpl) {
        this.authManageImpl = authManageImpl;
    }

    @RequestMapping(value = "/auths/{id}", method = RequestMethod.POST)
    public ResponseEntity auths(@PathVariable String id) {
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("isAdmin", authManageImpl.isAdmin(id));
        resp.put("isBlogger", authManageImpl.isBlogger(id));
        resp.put("isReader", authManageImpl.isReader(id));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Account addAccount(@RequestBody Account account) {
        return authManageImpl.insert(account);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String id) {
        authManageImpl.delete(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Account deleteAccount(@RequestBody Account account) {
        return authManageImpl.update(account);
    }

}
