package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.District;
import com.courses.assignment.citizen.repositories.DistrictRepo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class DistrictRepoImpl implements DistrictRepo {
    DbConnection connection = DbConnection.getInstance();

    @Override
    public List<District> getAllInProvince(int provinceID) {
        Connection conn = connection.getConnection();
        List<District> districts = new ArrayList<>();
        try {
            String query = "select * from citizen_db.district where provinceID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, provinceID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                District district = new District();
                district.setId(result.getInt("districtID"));
                district.setDistrictName(result.getString("district_name"));
                district.setPopulation(result.getInt("population"));
                district.setTotalCommunes(result.getInt("totalCommunes"));
                district.setProvinceID(result.getInt("provinceID"));

                districts.add(district);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return districts;
    }

    @Override
    public District getById(int id) {
        Connection conn = connection.getConnection();
        District district = null;
        try {
            String query = "select * from citizen_db.district where districtID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                district = new District();
                district.setId(result.getInt("districtID"));
                district.setDistrictName(result.getString("district_name"));
                district.setPopulation(result.getInt("population"));
                district.setTotalCommunes(result.getInt("totalCommunes"));
                district.setProvinceID(result.getInt("provinceID"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return district;
    }

    @Override
    public void add(District district) {
        Connection conn = connection.getConnection();
        try {
            String query = "insert into citizen_db.district values(?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, district.getId());
            statement.setString(2, district.getDistrictName());
            statement.setInt(3, district.getPopulation());
            statement.setInt(4, district.getTotalCommunes());
            statement.setInt(5, district.getProvinceID());
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(District district) {
        Connection conn = connection.getConnection();
        try {
            String query = "update citizen_db.district set " +
                    "district_name = ?, " +
                    "population = ?, " +
                    "totalCommunes = ?, " +
                    "provinceID = ? " +
                    "where districtID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, district.getDistrictName());
            statement.setInt(2, district.getPopulation());
            statement.setInt(3, district.getTotalCommunes());
            statement.setInt(4, district.getProvinceID());
            statement.setInt(5, district.getId());
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
            String query = "delete from citizen_db.district where districtID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
