package com.learning.service;

import com.learning.dao.LoginDao;
import com.learning.model.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LoginService {

    private final LoginDao userDao;

    @Autowired
    public LoginService(LoginDao userDao) {
        this.userDao = userDao;
    }

    public boolean registerUser(LoginCredentials newUser){
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

    public boolean authenticate(LoginCredentials loginUser){
        return userDao.findByUserNameAndPassword(loginUser.getUserName(), loginUser.getPassword());
    }

    public List<LoginCredentials> getAllUsers(){
        return userDao.getAllUsers();
    }

}
