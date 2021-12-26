package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.Account;
import com.courses.assignment.citizen.model.register.UserRegister;
import com.courses.assignment.citizen.repositories.AccountRepo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountRepoImpl implements AccountRepo {
    DbConnection connection = DbConnection.getInstance();

    @Override
    public List<Account> getAll() {
        Connection conn = connection.getConnection();
        List<Account> accounts = new ArrayList<>();
        try {
            String query = "select * from citizen_db.account";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Account account = new Account();
                account.setId(result.getInt("accountID"));
                account.setUsername(result.getString("username"));
                account.setPassword(result.getString("password"));
                account.setEmail(result.getString("email"));

                accounts.add(account);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account getById(int id) {
        Connection conn = connection.getConnection();
        Account account = null;
        try {
            String query = "select * from citizen_db.account where accountID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                account = new Account();
                account.setId(result.getInt("accountID"));
                account.setUsername(result.getString("username"));
                account.setPassword(result.getString("password"));
                account.setEmail(result.getString("email"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account getByEmail(String email) {
        Connection conn = connection.getConnection();
        Account account = null;
        try {
            String query = "select * from citizen_db.account where email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                account = new Account();
                account.setId(result.getInt("accountID"));
                account.setUsername(result.getString("username"));
                account.setPassword(result.getString("password"));
                account.setEmail(result.getString("email"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void createAccount(UserRegister register) {
        Connection conn = connection.getConnection();
        try {
            String query = "insert into citizen_db.account values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, register.getAccountID());
            statement.setString(2, register.getUsername());
            statement.setString(3, register.getPassword());
            statement.setString(4, register.getEmail());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(int id) {
        Connection conn = connection.getConnection();
        try {
            String query = "delete from citizen_db.account where accountID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePassword(String password, int id) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.account set " +
                    "password = ? " +
                    "where accountID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, password);
            statement.setInt(2, id);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmail(String email, int id) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.account set " +
                    "email = ? " +
                    "where accountID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            statement.setInt(2, id);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkEmail(String email) {
        Connection conn = connection.getConnection();
        try {
            String query = "select * from citizen_db.account where email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            conn.close();
            if (result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        Connection conn = connection.getConnection();
        try {
            String query = "select * from citizen_db.account where username = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            conn.close();
            if (result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
