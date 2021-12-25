package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.Province;
import com.courses.assignment.citizen.repositories.ProvinceRepo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProvinceRepoImpl implements ProvinceRepo {
    DbConnection connection = DbConnection.getInstance();

    @Override
    public List<Province> getAll() {
        Connection conn = connection.getConnection();
        List<Province> provinces = new ArrayList<>();
        try {
            String query = "select * from citizen_db.province";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Province province = new Province();
                province.setId(result.getString("provinceID"));
                province.setProvinceName(result.getString("province_name"));
                province.setPopulation(result.getInt("population"));
                province.setTotalDistricts(result.getInt("totalDistricts"));

                provinces.add(province);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinces;
    }

    @Override
    public Province getById(String id) {
        Connection conn = connection.getConnection();
        Province province = null;
        try {
            String query = "select * from citizen_db.province where provinceID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                province = new Province();
                province.setId(result.getString("provinceID"));
                province.setProvinceName(result.getString("province_name"));
                province.setPopulation(result.getInt("population"));
                province.setTotalDistricts(result.getInt("totalDistricts"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return province;
    }

    @Override
    public void add(Province province) {
        Connection conn = connection.getConnection();
        try {
            String query = "insert into citizen_db.province values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, province.getId());
            statement.setString(2, province.getProvinceName());
            statement.setInt(3, province.getPopulation());
            statement.setInt(4, province.getTotalDistricts());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Province province) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.province set " +
                    "province_name = ?, " +
                    "population = ?, " +
                    "totalDistricts = ? " +
                    "where provinceID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String provinceID) {
        Connection conn = connection.getConnection();
        try {
            String query = "delete from citizen_db.province where provinceID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, provinceID);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
