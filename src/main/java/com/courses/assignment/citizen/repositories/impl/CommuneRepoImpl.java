package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.Commune;
import com.courses.assignment.citizen.repositories.CommuneRepo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommuneRepoImpl implements CommuneRepo {
    DbConnection connection = DbConnection.getInstance();

    @Override
    public List<Commune> getAllInProvince(int provinceID) {
        Connection conn = connection.getConnection();
        List<Commune> communes = new ArrayList<>();
        try {
            String query = "select * from citizen_db.commune c " +
                    "inner join citizen_db.district d on c.districtID = d.districtID " +
                    "where provinceID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, provinceID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Commune commune = new Commune();
                commune.setId(result.getInt("communeID"));
                commune.setCommuneName(result.getString("commune_name"));
                commune.setPopulation(result.getInt("population"));
                commune.setTotalHamlets(result.getInt("totalHamlets"));
                commune.setDistrictID(result.getInt("districtID"));

                communes.add(commune);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return communes;
    }

    @Override
    public List<Commune> getAllInDistrict(int districtID) {
        Connection conn = connection.getConnection();
        List<Commune> communes = new ArrayList<>();
        try {
            String query = "select * from citizen_db.commune where districtID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, districtID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Commune commune = new Commune();
                commune.setId(result.getInt("communeID"));
                commune.setCommuneName(result.getString("commune_name"));
                commune.setPopulation(result.getInt("population"));
                commune.setTotalHamlets(result.getInt("totalHamlets"));
                commune.setDistrictID(result.getInt("districtID"));

                communes.add(commune);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return communes;
    }

    @Override
    public Commune getById(int id) {
        Connection conn = connection.getConnection();
        Commune commune = null;
        try {
            String query = "select * from citizen_db.commune where communeID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                commune = new Commune();
                commune.setId(result.getInt("communeID"));
                commune.setCommuneName(result.getString("commune_name"));
                commune.setPopulation(result.getInt("population"));
                commune.setTotalHamlets(result.getInt("totalHamlets"));
                commune.setDistrictID(result.getInt("districtID"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commune;
    }

    @Override
    public void add(Commune commune) {
        Connection conn = connection.getConnection();
        try {
            String query = "insert into citizen_db.commune values(?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, commune.getId());
            statement.setString(2, commune.getCommuneName());
            statement.setInt(3, commune.getPopulation());
            statement.setInt(4, commune.getTotalHamlets());
            statement.setInt(5, commune.getDistrictID());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Commune commune) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.commune set " +
                    "commune_name = ?, " +
                    "population = ?, " +
                    "totalHamlets = ?, " +
                    "districtID = ? " +
                    "where communeID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, commune.getCommuneName());
            statement.setInt(2, commune.getPopulation());
            statement.setInt(3, commune.getTotalHamlets());
            statement.setInt(4, commune.getDistrictID());
            statement.setInt(5, commune.getId());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = connection.getConnection();
        try {
            String query = "delete from citizen_db.commune where communeID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
