package com.blogapi.controller;

import com.blogapi.service.impl.AuthManageImpl;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AuthManageController {
    @Autowired
    private AuthManageImpl authManageImpl;

//    @GetMapping(path = "/isAdmin")
    @PostMapping(path = "/isAdmin")
    public ResponseEntity isAdmin(@RequestParam("id") String id) throws Exception{
        HashMap<String, Object> resp = new HashMap<>();
        boolean result = authManageImpl.isAdmin(id);
        resp.put("isAdmin", result);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


}
