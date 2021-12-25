package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.Hamlet;
import com.courses.assignment.citizen.repositories.HamletRepo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class HamletRepoImpl implements HamletRepo {
    DbConnection connection = DbConnection.getInstance();

    @Override
    public List<Hamlet> getAllInProvince(String provinceID) {
        Connection conn = connection.getConnection();
        List<Hamlet> hamlets = new ArrayList<>();
        try {
            String query = "select * from citizen_db.hamlet h " +
                    "inner join citizen_db.commune c on h.communeID = c.communeID " +
                    "inner join citizen_db.district d on c.districtID = d.districtID " +
                    "where provinceID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, provinceID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Hamlet hamlet = new Hamlet();
                hamlet.setId(result.getString("hamletID"));
                hamlet.setHamletName(result.getString("hamlet_name"));
                hamlet.setPopulation(result.getInt("population"));
                hamlet.setCommuneID(result.getString("communeID"));

                hamlets.add(hamlet);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hamlets;
    }

    @Override
    public List<Hamlet> getAllInDistrict(String districtID) {
        Connection conn = connection.getConnection();
        List<Hamlet> hamlets = new ArrayList<>();
        try {
            String query = "select * from citizen_db.hamlet h " +
                    "inner join citizen_db.commune c on h.communeID = c.communeID " +
                    "where districtID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, districtID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Hamlet hamlet = new Hamlet();
                hamlet.setId(result.getString("hamletID"));
                hamlet.setHamletName(result.getString("hamlet_name"));
                hamlet.setPopulation(result.getInt("population"));
                hamlet.setCommuneID(result.getString("communeID"));

                hamlets.add(hamlet);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hamlets;
    }

    @Override
    public List<Hamlet> getAllInCommune(String communeID) {
        Connection conn = connection.getConnection();
        List<Hamlet> hamlets = new ArrayList<>();
        try {
            String query = "select * from citizen_db.hamlet h where communeID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, communeID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Hamlet hamlet = new Hamlet();
                hamlet.setId(result.getString("hamletID"));
                hamlet.setHamletName(result.getString("hamlet_name"));
                hamlet.setPopulation(result.getInt("population"));
                hamlet.setCommuneID(result.getString("communeID"));

                hamlets.add(hamlet);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hamlets;
    }

    @Override
    public Hamlet getByID(String id) {
        Connection conn = connection.getConnection();
        Hamlet hamlet = null;
        try {
            String query = "select * from citizen_db.hamlet where hamletID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                hamlet = new Hamlet();
                hamlet.setId(result.getString("hamletID"));
                hamlet.setHamletName(result.getString("hamlet_name"));
                hamlet.setPopulation(result.getInt("population"));
                hamlet.setCommuneID(result.getString("communeID"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hamlet;
    }

    @Override
    public void add(Hamlet hamlet) {
        Connection conn = connection.getConnection();
        try {
            String query = "insert into citizen_db.hamlet values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, hamlet.getId());
            statement.setString(2, hamlet.getHamletName());
            statement.setInt(3, hamlet.getPopulation());
            statement.setString(4, hamlet.getCommuneID());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hamlet hamlet) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.hamlet set " +
                    "hamlet_name = ?, " +
                    "population = ?, " +
                    "communeID = ? " +
                    "where hamletID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, hamlet.getHamletName());
            statement.setInt(2, hamlet.getPopulation());
            statement.setString(3, hamlet.getCommuneID());
            statement.setString(4, hamlet.getId());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        Connection conn = connection.getConnection();
        try {
            String query = "delete from citizen_db.hamlet where hamletID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
