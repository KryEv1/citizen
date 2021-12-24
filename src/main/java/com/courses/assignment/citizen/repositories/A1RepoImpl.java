package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.A1User;
import com.courses.assignment.citizen.model.entities.User;
import com.courses.assignment.citizen.model.register.A1Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class A1RepoImpl implements A1Repo {
    DbConnection connection = DbConnection.getInstance();

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<A1User> getAll() {
        Connection conn = connection.getConnection();
        List<A1User> a1Users = new ArrayList<>();
        try {
            String query = "select * from citizen_db.a1_user a1 inner join citizen_db.user u on a1.userID = u.userID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                A1User a1User = new A1User();
                a1User.setId(result.getInt("userID"));
                a1User.setName(result.getString("name"));
                a1User.setBirth(result.getDate("birth"));
                a1User.setPhone(result.getString("phone"));
                a1User.setAccountID(result.getInt("accountID"));
                a1User.setUserStatus(result.getString("user_status"));
                a1User.setTotalProvinces(result.getInt("total_provinces"));

                a1Users.add(a1User);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a1Users;
    }

    @Override
    public A1User getById(int id) {
        Connection conn = connection.getConnection();
        A1User a1User = null;
        try {
            String query = "select * from citizen_db.a1_user a1 inner join citizen_db.user u on a1.userID = u.userID " +
                    "where u.userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                a1User = new A1User();
                a1User.setId(result.getInt("userID"));
                a1User.setName(result.getString("name"));
                a1User.setBirth(result.getDate("birth"));
                a1User.setPhone(result.getString("phone"));
                a1User.setAccountID(result.getInt("accountID"));
                a1User.setUserStatus(result.getString("user_status"));
                a1User.setTotalProvinces(result.getInt("total_provinces"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a1User;
    }

    @Override
    public void createUser(A1Register register) {
        Connection conn = connection.getConnection();
        try {
            userRepo.createUser(register);
            int id = userRepo.getByAccount(accountRepo.getByEmail(register.getEmail()).getId()).getId();
            String query = "insert into citizen_db.a1_user values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, register.getUserStatus());
            statement.setInt(3, register.getTotalProvinces());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(A1User a1User) {
        Connection conn = connection.getConnection();

        try {
            String query = "update citizen_db.a1_user set " +
                    "user_status = ?, " +
                    "total_provinces = ? " +
                    "where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, a1User.getUserStatus());
            statement.setInt(2, a1User.getTotalProvinces());
            statement.setInt(3, a1User.getId());
            statement.execute();
            User user = new User();
            user.setId(a1User.getId());
            user.setName(a1User.getName());
            user.setBirth(a1User.getBirth());
            user.setPhone(a1User.getPhone());
            user.setAccountID(a1User.getAccountID());
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
            String query = "select * from citizen_db.a1_user where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet a1User = statement.executeQuery();
            accountRepo.deleteAccount(a1User.getInt("accountID"));
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
