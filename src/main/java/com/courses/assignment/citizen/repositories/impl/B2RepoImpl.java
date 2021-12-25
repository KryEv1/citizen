package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.B2User;
import com.courses.assignment.citizen.model.register.B2Register;
import com.courses.assignment.citizen.repositories.AccountRepo;
import com.courses.assignment.citizen.repositories.B2Repo;
import com.courses.assignment.citizen.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class B2RepoImpl implements B2Repo {
    DbConnection connection = DbConnection.getInstance();

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<B2User> getAll() {
        Connection conn = connection.getConnection();
        List<B2User> b2Users = new ArrayList<>();
        try {
            String query = "select * from citizen_db.b2_user b2 inner join citizen_db.user u on u.userID = b2.userID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                B2User b2User = new B2User();
                b2User.setId(result.getInt("userID"));
                b2User.setName(result.getString("name"));
                b2User.setBirth(result.getDate("birth"));
                b2User.setPhone(result.getString("phone"));
                b2User.setAccountID(result.getInt("accountID"));
                b2User.setUserStatus(result.getString("user_status"));
                b2User.setHamletID(result.getInt("hamletID"));
                b2User.setB1Userid(result.getInt("b1_userID"));

                b2Users.add(b2User);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b2Users;
    }

    @Override
    public B2User getById(int id) {
        Connection conn = connection.getConnection();
        B2User b2User = null;
        try {
            String query = "select * from citizen_db.b2_user b2 inner join citizen_db.user u on u.userID = b2.userID " +
                    "where u.userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                b2User = new B2User();
                b2User.setId(result.getInt("userID"));
                b2User.setName(result.getString("name"));
                b2User.setBirth(result.getDate("birth"));
                b2User.setPhone(result.getString("phone"));
                b2User.setAccountID(result.getInt("accountID"));
                b2User.setUserStatus(result.getString("user_status"));
                b2User.setHamletID(result.getInt("hamletID"));
                b2User.setB1Userid(result.getInt("b1_userID"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b2User;
    }

    @Override
    public void createUser(B2Register register) {
        Connection conn = connection.getConnection();
        try {
            userRepo.createUser(register);
            int id = userRepo.getByAccount(accountRepo.getByEmail(register.getEmail()).getId()).getId();
            String query = "insert into citizen_db.b2_user values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, register.getUserStatus());
            statement.setInt(3, register.getHamletID());
            statement.setInt(4, register.getSupervisorID());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(B2User b2User) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.b2_user set " +
                    "user_status = ?, " +
                    "hameletID = ?, " +
                    "b1_userID = ? " +
                    "where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, b2User.getUserStatus());
            statement.setInt(2, b2User.getHamletID());
            statement.setInt(3, b2User.getB1Userid());
            statement.setInt(4, b2User.getId());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        Connection conn = connection.getConnection();
        try {
            String query = "select * from citizen_db.b2_user b2 inner join citizen_db.user u on u.userID = b2.userID " +
                    "where u.userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            accountRepo.deleteAccount(result.getInt("accountID"));
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
