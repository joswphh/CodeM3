package com.dealership.dealership.models.repositories;

import com.dealership.dealership.DealershipApplication;
import com.dealership.dealership.models.Dealership;
import com.dealership.dealership.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DealershipRepository {
    private final DataSource dataSource;
@Autowired
    public DealershipRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void createDealership(Dealership dealership){
    String query = "INSERT INTO Dealership(DealershipName, DealershipAddress, DealershipPhone" +
            "VALUES(?,?,?)";
        List<Dealership> dealerships = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

           ps.setString(1, dealership.getName());
           ps.setString(2, dealership.getAddress());
           ps.setString(3, dealership.getPhone());
           ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Dealership> getAllDealerships(){
        String query = "SELECT * FROM vehicles";
        List<Dealership> dealerships = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ResultSet rs  = ps.executeQuery();

            while(rs.next()){
                dealerships.add(new Dealership(rs.getString("DealershipName"), rs.getString("DealershipAddress"),
                        rs.getString("DealershipPhone")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dealerships;
    }

    public void removeDealership(String name){
        String query = "DELETE FROM dealership WHERE DealershipName = ?";
        List<Dealership> dealerships  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, name);
            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateDealership(Dealership dealership) {
        String query = "UPDATE dealerships SET name = ?, address = ?, phone = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3, dealership.getPhone());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //CRUD functions for dealerships
    //getAll Dealerships, getDealershipByID, createDealership, updateDealership, deleteDealership
}
