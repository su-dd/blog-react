package com.blogapi.controller;

import com.blogapi.service.impl.AuthManageImpl;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/Auth")
public class AuthManageController {

    private AuthManageImpl authManageImpl;

    @Autowired
    public AuthManageController(AuthManageImpl authManageImpl) {
        this.authManageImpl = authManageImpl;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity isAdmin(@PathVariable String id) {
        HashMap<String, Object> resp = new HashMap<>();
        boolean result = authManageImpl.isAdmin(id);
        resp.put("isAdmin", result);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


}
