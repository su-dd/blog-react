package com.blogapi.core.service.impl;

import com.blogapi.core.dao.UserDao;
import com.blogapi.core.entity.User;
import com.blogapi.core.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isAdmin(String id) {
        if (userDao.existsById(id)){
            User user = userDao.findById(id).get();
            return user.getRoles().contains("ROLE_Admin");
        }
        return false;
    }

    @Override
    public boolean isBlogger(String id) {
        if (userDao.existsById(id)){
            User user = userDao.findById(id).get();
            return user.getRoles().contains("ROLE_Blogger");
        }
        return false;
    }

    @Override
    public boolean isReader(String id) {
//        if (accountDao.existsById(id)){
//            Account account = accountDao.findById(id).get();
//            return account.getRoles().contains("ROLE_Reader");
//        }
        return true;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(String id) {
        if (userDao.existsById(id)){
            return userDao.findById(id).get();
        }
        return new User();
    }

    @Override
    public User insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public void delete(String id) {
        userDao.deleteById(id);
    }

    @Override
    public User update(User user) {
        userDao.deleteById(user.getId());
        return userDao.insert(user);
    }
}
