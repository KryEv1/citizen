package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.B1User;
import com.courses.assignment.citizen.model.register.B1Register;
import com.courses.assignment.citizen.repositories.AccountRepo;
import com.courses.assignment.citizen.repositories.B1Repo;
import com.courses.assignment.citizen.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class B1RepoImpl implements B1Repo {
    DbConnection connection = DbConnection.getInstance();

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<B1User> getAll() {
        Connection conn = connection.getConnection();
        List<B1User> b1Users = new ArrayList<>();
        try {
            String query = "select * from citizen_db.b1_user b1 inner join citizen_db.user u on u.userID = b1.userID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                B1User b1User = new B1User();
                b1User.setId(result.getString("userID"));
                b1User.setName(result.getString("name"));
                b1User.setBirth(result.getDate("birth"));
                b1User.setPhone(result.getString("phone"));
                b1User.setAccountID(result.getInt("accountID"));
                b1User.setUserStatus(result.getString("user_status"));
                b1User.setCommuneID(result.getString("communeID"));
                b1User.setA3Userid(result.getString("a3_userID"));

                b1Users.add(b1User);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b1Users;
    }

    @Override
    public B1User getById(String id) {
        Connection conn = connection.getConnection();
        B1User b1User = null;
        try {
            String query = "select * from citizen_db.b1_user b1 inner join citizen_db.user u on u.userID = b1.userID " +
                    "where u.userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                b1User = new B1User();
                b1User.setId(result.getString("userID"));
                b1User.setName(result.getString("name"));
                b1User.setBirth(result.getDate("birth"));
                b1User.setPhone(result.getString("phone"));
                b1User.setAccountID(result.getInt("accountID"));
                b1User.setUserStatus(result.getString("user_status"));
                b1User.setCommuneID(result.getString("communeID"));
                b1User.setA3Userid(result.getString("a3_userID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b1User;
    }

    @Override
    public void createUser(B1Register register) {
        Connection conn = connection.getConnection();
        try {
            userRepo.createUser(register);
            String id = userRepo.getByAccount(accountRepo.getByEmail(register.getEmail()).getId()).getId();
            String query = "insert into citizen_db.b1_user values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, register.getUserStatus());
            statement.setString(3, register.getCommuneID());
            statement.setString(4, register.getSupervisorID());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(B1User b1User) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.b1_user set " +
                    "user_status = ?, " +
                    "communeID = ?, " +
                    "a3_userID = ? " +
                    "where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, b1User.getUserStatus());
            statement.setString(2, b1User.getCommuneID());
            statement.setString(3, b1User.getA3Userid());
            statement.setString(4, b1User.getId());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String id) {
        Connection conn = connection.getConnection();
        try {
            String query = "select * from citizen_db.b1_user b1 inner join citizen_db.user u on u.userID = b1.userID " +
                    "where u.userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            accountRepo.deleteAccount(result.getInt("accountID"));
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
