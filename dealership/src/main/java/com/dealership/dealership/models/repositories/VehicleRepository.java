package com.dealership.dealership.models.repositories;


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
    public class VehicleRepository {
        //Dependency
        //Without this, we can't connect to the database
        private final DataSource dataSource;

        //Autowired says, go and get me a copy of this
        @Autowired
        public VehicleRepository(DataSource dataSource){
            this.dataSource = dataSource;
        }

    public List<Vehicle> getAllVehicles(){
            String query = "SELECT * FROM vehicles";
            List<Vehicle> vehicles  = new ArrayList<>();

            try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)){

                ResultSet rs  = ps.executeQuery();

                while(rs.next()){
                    vehicles.add(new Vehicle(rs.getString("VehicleVin"), rs.getInt("VehicleYear"),
                            rs.getString("VehicleMake"), rs.getString("VehicleModel"), rs.getString("VehicleColor"),
                            rs.getString("VehicleType"), rs.getInt("VehicleOdometer"), rs.getDouble("VehiclePrice")));
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        String query = "SELECT * FROM vehicles WHERE VehiclePrice BETWEEN ? AND ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs  = ps.executeQuery();

            while(rs.next()){
                vehicles.add(new Vehicle(rs.getString("VehicleVin"), rs.getInt("VehicleYear"),
                        rs.getString("VehicleMake"), rs.getString("VehicleModel"), rs.getString("VehicleColor"),
                        rs.getString("VehicleType"), rs.getInt("VehicleOdometer"), rs.getDouble("VehiclePrice")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        String query = "SELECT * FROM vehicles WHERE VehicleMake = ? AND VehicleModel = ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,make);
            ps.setString(2,model);

            ResultSet rs  = ps.executeQuery();

            while(rs.next()){
                vehicles.add(new Vehicle(rs.getString("VehicleVin"), rs.getInt("VehicleYear"),
                        rs.getString("VehicleMake"), rs.getString("VehicleModel"), rs.getString("VehicleColor"),
                        rs.getString("VehicleType"), rs.getInt("VehicleOdometer"), rs.getDouble("VehiclePrice")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        String query = "SELECT * FROM vehicles WHERE VehicleYear BETWEEN ? AND ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs  = ps.executeQuery();

            while(rs.next()){
                vehicles.add(new Vehicle(rs.getString("VehicleVin"), rs.getInt("VehicleYear"),
                        rs.getString("VehicleMake"), rs.getString("VehicleModel"), rs.getString("VehicleColor"),
                        rs.getString("VehicleType"), rs.getInt("VehicleOdometer"), rs.getDouble("VehiclePrice")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        String query = "SELECT * FROM vehicles WHERE VehicleColor = ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,color);

            ResultSet rs  = ps.executeQuery();

            while(rs.next()){
                vehicles.add(new Vehicle(rs.getString("VehicleVin"), rs.getInt("VehicleYear"),
                        rs.getString("VehicleMake"), rs.getString("VehicleModel"), rs.getString("VehicleColor"),
                        rs.getString("VehicleType"), rs.getInt("VehicleOdometer"), rs.getDouble("VehiclePrice")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        String query = "SELECT * FROM vehicles WHERE VehicleOdometer BETWEEN ? AND ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs  = ps.executeQuery();

            while(rs.next()){
                vehicles.add(new Vehicle(rs.getString("VehicleVin"), rs.getInt("VehicleYear"),
                        rs.getString("VehicleMake"), rs.getString("VehicleModel"), rs.getString("VehicleColor"),
                        rs.getString("VehicleType"), rs.getInt("VehicleOdometer"), rs.getDouble("VehiclePrice")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        String query = "SELECT * FROM vehicles WHERE VehicleType = ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, vehicleType);

            ResultSet rs  = ps.executeQuery();

            while(rs.next()){
                vehicles.add(new Vehicle(rs.getString("VehicleVin"), rs.getInt("VehicleYear"),
                        rs.getString("VehicleMake"), rs.getString("VehicleModel"), rs.getString("VehicleColor"),
                        rs.getString("VehicleType"), rs.getInt("VehicleOdometer"), rs.getDouble("VehiclePrice")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        String query = "INSERT INTO Vehicles (VehicleVin, VehicleYear, VehicleMake, VehicleModel, VehicleColor, VehicleType, VehicleOdometer, VehiclePrice) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, vehicle.getVin());
            ps.setInt(2, vehicle.getYear());
            ps.setString(3, vehicle.getMake());
            ps.setString(4, vehicle.getModel());
            ps.setString(5, vehicle.getColor());
            ps.setString(6, vehicle.getVehicleType());
            ps.setInt(7, vehicle.getOdometer());
            ps.setDouble(8, vehicle.getPrice());
            ps.executeUpdate();


        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void removeVehicle(String vin){
        String query = "DELETE FROM vehicles WHERE VehicleID = ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, vin);
            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    }

