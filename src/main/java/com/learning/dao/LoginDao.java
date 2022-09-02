package com.learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learning.model.LoginCredentials;
import jakarta.transaction.Transactional;
import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoginDao {
    private JdbcConnectionPool conPool = null;

    LoginDao() {
        try {
            String createTablesQuery = "create table if not exists user" +
                    " ( login_id varchar(50)," +
                    " password_plain varchar(50) );" +
                    "create unique index if not exists user_login_id_unique on user(login_id);";
            getDbConnectionFromPool().createStatement().executeUpdate(createTablesQuery);
        } catch (SQLException ex) {
            System.out.println("Exception Creating Tables : " + ex);
        }
    }

    public boolean findByUserNameAndPassword(String userName, String password) {
        boolean userExists = false;
        String selectUserQuery = "select count(*) from user where login_id = ? and password_plain = ?;";
        try {
            PreparedStatement pst = getDbConnectionFromPool().prepareStatement(selectUserQuery);
            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            rs.next();
            if (rs.getInt("count(*)") == 1)
                userExists = true;
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userExists;
    }

    public List<LoginCredentials> getAllUsers() {
        List<LoginCredentials> loginList = new ArrayList<>();
        String selectUserQuery = "select login_id, password_plain from user order by login_id;";
        try {
            PreparedStatement pst = getDbConnectionFromPool().prepareStatement(selectUserQuery);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                loginList.add(new LoginCredentials(rs.getString("login_id"), rs.getString("password_plain")));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return loginList;
    }

    public boolean saveNewUser(String userName, String password) throws SQLException {
        String insertUserQuery = "insert into user(login_id, password_plain)" +
                " values (?, ?);";
        PreparedStatement pst = getDbConnectionFromPool().prepareStatement(insertUserQuery);
        pst.setString(1, userName);
        pst.setString(2, password);
        int i = pst.executeUpdate();
        pst.close();

        return i == 1;
    }

    private Connection getDbConnectionFromPool() {
        if (conPool == null) {
            try {
//                conPool = JdbcConnectionPool.create("jdbc:h2:./data/data;IFEXISTS=TRUE;AUTO_SERVER=TRUE;", "sa", "sforzo");
                conPool = JdbcConnectionPool.create("jdbc:h2:./data/data;AUTO_SERVER=TRUE;", "sa", "Bhogol(912)");
                conPool.setMaxConnections(50);
            } catch (Exception e) {
                System.out.println("Exception creating jdbc connection pool " + e);
            }
        }
        Connection newConn = null;
        try {
            newConn = conPool.getConnection();
        } catch (SQLException sQLException) {
            System.out.println("Exception getting connection from pool " + sQLException);
        }
        return newConn;
    }

}
