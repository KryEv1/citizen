package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.A3User;
import com.courses.assignment.citizen.model.entities.User;
import com.courses.assignment.citizen.model.register.A3Register;
import com.courses.assignment.citizen.repositories.A3Repo;
import com.courses.assignment.citizen.repositories.AccountRepo;
import com.courses.assignment.citizen.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class A3RepoImpl implements A3Repo {
    DbConnection connection = DbConnection.getInstance();

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<A3User> getAll() {
        Connection conn = connection.getConnection();
        List<A3User> a3Users = new ArrayList<>();
        try {
            String query = "select * from citizen_db.a3_user a3 inner join citizen_db.user u on u.userID = a3.userID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                A3User a3User = new A3User();
                a3User.setId(result.getInt("userID"));
                a3User.setName(result.getString("name"));
                a3User.setBirth(result.getDate("birth"));
                a3User.setPhone(result.getString("phone"));
                a3User.setAccountID(result.getInt("accountID"));
                a3User.setUserStatus(result.getString("user_status"));
                a3User.setDistrictID(result.getInt("districtID"));
                a3User.setA2Userid(result.getInt("a2_userID"));

                a3Users.add(a3User);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a3Users;
    }

    @Override
    public A3User getById(int id) {
        Connection conn = connection.getConnection();
        A3User a3User = null;
        try {
            String query = "select * from citizen_db.a3_user a3 inner join citizen_db.user u on u.userID = a3.userID " +
                    "where u.userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                a3User = new A3User();
                a3User.setId(result.getInt("userID"));
                a3User.setName(result.getString("name"));
                a3User.setBirth(result.getDate("birth"));
                a3User.setPhone(result.getString("phone"));
                a3User.setAccountID(result.getInt("accountID"));
                a3User.setUserStatus(result.getString("user_status"));
                a3User.setDistrictID(result.getInt("districtID"));
                a3User.setA2Userid(result.getInt("a2_userID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a3User;
    }

    @Override
    public void createUser(A3Register register) {
        Connection conn = connection.getConnection();
        try {
            userRepo.createUser(register);
            int id = userRepo.getByAccount(accountRepo.getByEmail(register.getEmail()).getId()).getId();
            String query = "insert into citizen_db.a3_user values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, register.getUserStatus());
            statement.setInt(3, register.getDistrictID());
            statement.setInt(4, register.getSupervisorID());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(A3User a3User) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.a2_user set " +
                    "user_status = ?, " +
                    "districtID = ?, " +
                    "a2_userID = ?" +
                    "where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, a3User.getUserStatus());
            statement.setInt(2, a3User.getDistrictID());
            statement.setInt(3, a3User.getA2Userid());
            statement.setInt(4, a3User.getId());
            statement.execute();
            User user = new User();
            user.setId(a3User.getId());
            user.setName(a3User.getName());
            user.setBirth(a3User.getBirth());
            user.setPhone(a3User.getPhone());
            user.setAccountID(a3User.getAccountID());
            userRepo.update(user);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        Connection conn = connection.getConnection();

        try {
            String query = "select * from citizen_db.a3_user a3 inner join citizen_db.user u on u.userID = a3.userID " +
                    "where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet a3User = statement.executeQuery();
            accountRepo.deleteAccount(a3User.getInt("accountID"));
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
