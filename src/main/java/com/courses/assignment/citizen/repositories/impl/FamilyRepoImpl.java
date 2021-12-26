package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.database.DbConnection;
import com.courses.assignment.citizen.model.entities.Citizen;
import com.courses.assignment.citizen.model.entities.Family;
import com.courses.assignment.citizen.repositories.FamilyRepo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class FamilyRepoImpl implements FamilyRepo {
    DbConnection connection = DbConnection.getInstance();

    @Override
    public List<Family> getAllByProvince(String provinceID) {
        Connection conn = connection.getConnection();
        List<Family> families = new ArrayList<>();
        try {
            String query = "select * from citizen_db.family f " +
                    "inner join citizen_db.hamlet h on f.address = h.hamletID " +
                    "inner join citizen_db.commune c on h.communeID = c.communeID " +
                    "inner join citizen_db.district d on c.districtID = d.districtID " +
                    "where d.provinceID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, provinceID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Family family = new Family();
                family.setFamilyID(result.getString("familyID"));
                family.setHouseholderID(result.getString("householderID"));
                family.setHouseholder(this.getHouseholder(result.getString("familyID")));
                family.setAddress(result.getString("address"));
                family.setFullAddress(this.getAddress(result.getString("familyID")));
                family.setMembers(this.getAllMembers(result.getString("familyID")));

                families.add(family);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return families;
    }

    @Override
    public List<Family> getAllByDistrict(String districtID) {
        Connection conn = connection.getConnection();
        List<Family> families = new ArrayList<>();
        try {
            String query = "select * from citizen_db.family f " +
                    "inner join citizen_db.hamlet h on f.address = h.hamletID " +
                    "inner join citizen_db.commune c on h.communeID = c.communeID " +
                    "where c.districtID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, districtID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Family family = new Family();
                family.setFamilyID(result.getString("familyID"));
                family.setHouseholderID(result.getString("householderID"));
                family.setHouseholder(this.getHouseholder(result.getString("familyID")));
                family.setAddress(result.getString("address"));
                family.setFullAddress(this.getAddress(result.getString("familyID")));
                family.setMembers(this.getAllMembers(result.getString("familyID")));

                families.add(family);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return families;
    }

    @Override
    public List<Family> getAllByCommune(String communeID) {
        Connection conn = connection.getConnection();
        List<Family> families = new ArrayList<>();
        try {
            String query = "select * from citizen_db.family f " +
                    "inner join citizen_db.hamlet h on f.address = h.hamletID " +
                    "where h.communeID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, communeID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Family family = new Family();
                family.setFamilyID(result.getString("familyID"));
                family.setHouseholderID(result.getString("householderID"));
                family.setHouseholder(this.getHouseholder(result.getString("familyID")));
                family.setAddress(result.getString("address"));
                family.setFullAddress(this.getAddress(result.getString("familyID")));
                family.setMembers(this.getAllMembers(result.getString("familyID")));

                families.add(family);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return families;
    }

    @Override
    public List<Family> getAllByHamlet(String hamletID) {
        Connection conn = connection.getConnection();
        List<Family> families = new ArrayList<>();
        try {
            String query = "select * from citizen_db.family f " +
                    "where f.address = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, hamletID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Family family = new Family();
                family.setFamilyID(result.getString("familyID"));
                family.setHouseholderID(result.getString("householderID"));
                family.setHouseholder(this.getHouseholder(result.getString("familyID")));
                family.setAddress(result.getString("address"));
                family.setFullAddress(this.getAddress(result.getString("familyID")));
                family.setMembers(this.getAllMembers(result.getString("familyID")));

                families.add(family);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return families;
    }

    @Override
    public List<Citizen> getAllMembers(String familyID) {
        Connection conn = connection.getConnection();
        List<Citizen> citizens = new ArrayList<>();
        try {
            String query = "select * from citizen_db.citizen cz " +
                    "inner join citizen_db.family f on cz.familyID = f.familyID " +
                    "where f.familyID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, familyID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Citizen citizen = new Citizen();
                citizen.setId(result.getString("citizenID"));
                citizen.setFullName(result.getString("full_name"));
                citizen.setBirth(result.getDate("birth"));
                citizen.setSex(result.getString("sex"));
                citizen.setNationality(result.getString("nationality"));
                citizen.setAddress(result.getString("address"));
                citizen.setFullAddress(this.getAddress(familyID));
                citizen.setHouseholderID(result.getString("householderID"));
                citizen.setHouseholder(this.getHouseholder(familyID));
                citizen.setRelationship(result.getString("relationship"));
                citizen.setFamilyID(result.getString("familyID"));

                citizens.add(citizen);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citizens;
    }

    @Override
    public Citizen getHouseholder(String familyID) {
        Connection conn = connection.getConnection();
        Citizen householder = null;
        try {
            String query = "select * from citizen_db.citizen cz " +
                    "inner join family f on cz.citizenID = f.householderID " +
                    "where f.familyID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, familyID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                householder = new Citizen();
                householder.setId(result.getString("citizenID"));
                householder.setFullName(result.getString("full_name"));
                householder.setBirth(result.getDate("birth"));
                householder.setSex(result.getString("sex"));
                householder.setNationality(result.getString("nationality"));
                householder.setAddress(result.getString("address"));
                householder.setFullAddress(this.getAddress(familyID));
                householder.setHouseholderID(result.getString("householderID"));
                householder.setHouseholder(householder);
                householder.setRelationship(result.getString("relationship"));
                householder.setFamilyID(result.getString("familyID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return householder;
    }

    @Override
    public Family getByID(String id) {
        Connection conn = connection.getConnection();
        Family family = null;
        try {
            String query = "select * from citizen_db.citizen cz where f.familyID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                family = new Family();
                family.setFamilyID(result.getString("familyID"));
                family.setHouseholderID(result.getString("householderID"));
                family.setHouseholder(this.getHouseholder(result.getString("familyID")));
                family.setAddress(result.getString("address"));
                family.setFullAddress(this.getAddress(result.getString("familyID")));
                family.setMembers(this.getAllMembers(result.getString("familyID")));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return family;
    }

    @Override
    public void add(Family family) {
    }

    @Override
    public void update(Family family) {
    }

    @Override
    public void delete(String familyID) {
    }

    @Override
    public String getAddress(String familyID) {
        Connection conn = connection.getConnection();
        StringBuilder address = new StringBuilder();
        try {
            String query = "select * from citizen_db.family f " +
                    "inner join citizen_db.hamlet h on f.address = h.hamletID " +
                    "inner join citizen_db.commune c on h.communeID = c.communeID " +
                    "inner join citizen_db.district d on c.districtID = d.districtID " +
                    "inner join citizen_db.province p on d.provinceID = p.provinceID " +
                    "where f.familyID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, familyID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                address.append(result.getString("hamlet_name"))
                        .append(", ").append(result.getString("commune_name"))
                        .append(", ").append(result.getString("district_name"))
                        .append(", ").append(result.getString("province_name"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address.toString();
    }
}
