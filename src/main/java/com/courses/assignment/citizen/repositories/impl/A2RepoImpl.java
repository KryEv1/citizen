package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.A2User;
import com.courses.assignment.citizen.model.entities.User;
import com.courses.assignment.citizen.model.register.A2Register;
import com.courses.assignment.citizen.repositories.A2Repo;
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
public class A2RepoImpl implements A2Repo {
    DbConnection connection = DbConnection.getInstance();

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<A2User> getAll() {
        Connection conn = connection.getConnection();
        List<A2User> a2Users = new ArrayList<>();
        try {
            String query = "select * from citizen_db.a2_user a2 inner join citizen_db.user u on a2.userID = u.userID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                A2User a2User = new A2User();
                a2User.setId(result.getInt("userID"));
                a2User.setName(result.getString("name"));
                a2User.setBirth(result.getDate("birth"));
                a2User.setPhone(result.getString("phone"));
                a2User.setAccountID(result.getInt("accountID"));
                a2User.setUserStatus(result.getString("user_status"));
                a2User.setProvinceID(result.getInt("provinceID"));
                a2User.setA1Userid(result.getInt("a1_userID"));

                a2Users.add(a2User);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a2Users;
    }

    @Override
    public A2User getById(int id) {
        Connection conn = connection.getConnection();
        A2User a2User = null;
        try {
            String query = "select * from citizen_db.a2_user a2 inner join citizen_db.user u on a2.userID = u.userID " +
                    "where u.userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                a2User = new A2User();
                a2User.setId(result.getInt("userID"));
                a2User.setName(result.getString("name"));
                a2User.setBirth(result.getDate("birth"));
                a2User.setPhone(result.getString("phone"));
                a2User.setAccountID(result.getInt("accountID"));
                a2User.setUserStatus(result.getString("user_status"));
                a2User.setProvinceID(result.getInt("provinceID"));
                a2User.setA1Userid(result.getInt("a1_userID"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a2User;
    }

    @Override
    public void createUser(A2Register register) {
        Connection conn = connection.getConnection();
        try {
            userRepo.createUser(register);
            int id = userRepo.getByAccount(accountRepo.getByEmail(register.getEmail()).getId()).getId();
            String query = "insert into citizen_db.a2_user values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, register.getUserStatus());
            statement.setInt(3, register.getProvinceID());
            statement.setInt(4, register.getSupervisorID());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(A2User a2User) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.a2_user set " +
                    "user_status = ?, " +
                    "provinceID = ? " +
                    "where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, a2User.getUserStatus());
            statement.setInt(2, a2User.getProvinceID());
            statement.setInt(3, a2User.getId());
            statement.execute();
            User user = new User();
            user.setId(a2User.getId());
            user.setName(a2User.getName());
            user.setBirth(a2User.getBirth());
            user.setPhone(a2User.getPhone());
            user.setAccountID(a2User.getAccountID());
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
            String query = "select * from citizen_db.a2_user where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet a2User = statement.executeQuery();
            accountRepo.deleteAccount(a2User.getInt("accountID"));
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
