package com.learning.service;

import com.learning.dao.LoginDao;
import com.learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    private final LoginDao userDao;

    @Autowired
    public UserService(LoginDao userDao) {
        this.userDao = userDao;
    }

    public boolean registerUser(User newUser){
        if (newUser.getUserName() == null || newUser.getPassword() == null) {
            return false;
        } else {
            try{
                return userDao.saveNewUser(newUser.getUserName(), newUser.getPassword());
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean authenticate(User loginUser){
        return userDao.findByUserNameAndPassword(loginUser.getUserName(), loginUser.getPassword());
    }

}
