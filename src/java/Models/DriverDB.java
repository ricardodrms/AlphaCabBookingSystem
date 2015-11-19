/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author k9-sheppard
 */
public class DriverDB {

    private Connection conn;

    private Statement state;
    private ResultSet rs;

    public DriverDB() {
        this.conn = DBConfig.getConnection();
    }

    public boolean addDriver(Driver driver) {
        try {

            state = conn.createStatement();
            state.executeUpdate(String.format(
                    "INSERT INTO drivers VALUES ('%s', '%s', '%s')", driver.getReg(), driver.getName(), driver.getPassword()));
            state.close();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean removeDriver(Driver driver) {
        try {
            state = conn.createStatement();
            state.executeUpdate(String.format(
                    "DELETE FROM drivers WHERE Registration='%s' AND Name='%s' AND password='%s'", driver.getReg(), driver.getName(), driver.getPassword()));
            state.close();

        } catch (SQLException e) {
            //System.err.println("Error: " + e);
            return false;

        }//try
        return true;
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<Driver>();
        try {
            state = conn.createStatement();
            rs = state.executeQuery("SELECT * from drivers");
            while(rs.next()){
                String reg = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                drivers.add(new Driver(reg, name, pass));
            }
            
            state.close();
            rs.close();

        } catch (SQLException e) {
            //System.err.println("Error: " + e);

        }//try
        return drivers;
    }
    
    public Driver doLogin(String name, String pass){
        Driver driver = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(String.format("SELECT * from drivers WHERE Name LIKE '%s' AND password LIKE '%s'", name, pass));
            while(rs.next()){

                driver = new Driver(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            
            state.close();
            rs.close();

        } catch (SQLException e) {
            //System.err.println("Error: " + e);

        }//try
        return driver;
    }

    public List<Journey> getJobsForDriver(Driver driver) {
        return null;
    }
}
