package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.User;
import com.courses.assignment.citizen.model.register.UserRegister;
import com.courses.assignment.citizen.repositories.AccountRepo;
import com.courses.assignment.citizen.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class UserRepoImpl implements UserRepo {
    DbConnection connection = DbConnection.getInstance();

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public void createUser(UserRegister register) {
        Connection conn = connection.getConnection();
        try {
            accountRepo.createAccount(register);
            int accountID = accountRepo.getByEmail(register.getEmail()).getId();
            String query = "insert into citizen_db.user " +
                    "values (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, register.getId());
            statement.setString(2, register.getName());
            statement.setDate(3, register.getBirth());
            statement.setString(4, register.getPhone());
            statement.setInt(5, accountID);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.user set " +
                    "name = ?, " +
                    "birth = ?, " +
                    "phone = ? " +
                    "where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setDate(2, user.getBirth());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getId());
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByAccount(int accountID) {
        Connection conn = connection.getConnection();
        User user = null;
        try {
            String query = "select * from citizen_db.user where accountID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, accountID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(result.getString("userID"));
                user.setName(result.getString("name"));
                user.setBirth(result.getDate("birth"));
                user.setPhone(result.getString("phone"));
                user.setAccountID(accountID);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
